package cn.chinasuv.base.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import cn.chinasuv.base.database.tools.AnalysisEntity;
import cn.chinasuv.base.database.utils.AnnotationUtils;
import cn.chinasuv.base.database.utils.convert.ConvertFactory;
import cn.chinasuv.utils.StringUtils;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseDao implements IBaseDao {
	public static final int mysqlDB = 1;
	public static final int oracleDB = 2;
	Logger logger = LoggerFactory.getLogger(BaseDao.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * 获取自增序列-oracle
	 */
	public long getId(String seq) {
		if (seq == null || seq.equals("")) {
			return 0;
		}
		String sql = " SELECT " + seq + ".NEXTVAL FROM DUAL";
		try {
			return jdbcTemplate.queryForLong(sql);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 插入实体-属性名和列名相同；如果属性名和列名不相同，则在xxxDao中重写insert方法
	 */
	public <T> int insert(T entity) {
		Object[] objs = AnalysisEntity.getInsertSql(entity);
		final String sql = objs[0] + "";
		final Object[] valuesInner = (Object[]) objs[2];
		return jdbcTemplate.update(sql, valuesInner);
	}

	/**
	 * 插入实体，返回自增主键-属性名和列名相同；如果属性名和列名不相同，则在xxxDao中重写insert方法
	 */
	public <T> long insertWhitDesc(T entity) {
		Object[] objs = AnalysisEntity.getInsertSql(entity);
		final String sql = objs[0] + "";
		final String[] keysInner = (String[]) objs[1];
		final Object[] valuesInner = (Object[]) objs[2];
		final Class<?>[] types = (Class<?>[]) objs[3];

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						keysInner);
				for (int i = 0; i < keysInner.length; i++) {
					if (StringUtils.isNotEmpty(keysInner[i])) {
						Object val;
						if (types[i].isAssignableFrom(valuesInner[i].getClass())) {
							val = valuesInner[i];
						} else {
							val = ConvertFactory.convert(types[i],
									valuesInner[i]);
						}
						ps.setObject(i + 1, val);
					}
				}
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	/**
	 * 更新操作，如主键为id,按id更新
	 */
	public int update(Class<?> clazz, long id, Map<String, Object> parameters) {
		if (parameters == null || parameters.isEmpty()) {
			logger.error("update parameters is blank!");
			return 0;
		}
		String tableName = AnnotationUtils.getTableName(clazz);
		StringBuilder setParam = new StringBuilder();
		Object[] objects = new Object[parameters.size()];
		int index = 0;
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			setParam.append("," + entry.getKey() + "=?");
			objects[index] = entry.getValue();
			index++;
		}
		String sql = "update " + tableName + " set " + setParam.substring(1)
				+ " where id=" + id;
		return jdbcTemplate.update(sql, objects);
	}

	/**
	 * 按给定条件更新操作
	 */
	public int update(Class<?> clazz, Map<String, Object> setParams,
			Map<String, Object> whereParams) {
		if (setParams == null || setParams.isEmpty()) {
			logger.error("update parameters is blank!");
			return 0;
		}
		String tableName = AnnotationUtils.getTableName(clazz);
		Object[] objects = new Object[setParams.size() + whereParams.size()];
		StringBuilder setString = new StringBuilder();
		StringBuilder whereString = new StringBuilder();
		int index = 0;
		for (Map.Entry<String, Object> entry : setParams.entrySet()) {
			setString.append("," + entry.getKey() + "=?");
			objects[index] = entry.getValue();
			index++;
		}

		for (Map.Entry<String, Object> entry : whereParams.entrySet()) {
			whereString.append("," + entry.getKey() + "=?");
			objects[index] = entry.getValue();
			index++;
		}
		String sql = "update " + tableName + " set " + setString.substring(1)
				+ " where " + whereString.substring(1);
		return jdbcTemplate.update(sql, objects);
	}

	/**
	 * 删除操作-按主键id删除
	 */
	public int delete(Class<?> clazz, long id) {
		String tableName = AnnotationUtils.getTableName(clazz);
		String sql = "delete from " + tableName + " where id=?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	/**
	 * 按给定条件删除操作
	 */
	public int delete(Class<?> clazz, Map<String, Object> parameters) {
		if (parameters == null) {
			logger.error("delete parameters is blank");
		}
		String tableName = AnnotationUtils.getTableName(clazz);
		StringBuilder deleteWhere = new StringBuilder(" where ");
		int index = 0;
		Object[] objects = new Object[parameters.size()];
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			if (index != 0) {
				deleteWhere.append(" and ");
			}
			deleteWhere.append(entry.getKey() + "=?");
			objects[index] = entry.getValue();
			index++;
		}
		String sql = "delete from " + tableName + deleteWhere;
		return jdbcTemplate.update(sql, objects);
	}

	/**
	 * 根据sql取唯一实体
	 */
	public <T> T get(Class<T> clazz, String sql, Object[] objects){
		List<T> list = getList(clazz, sql.toString(), objects);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	/**
	 * 按主键id取唯一实体
	 */
	public <T> T get(Class<T> clazz, long id) {
		String tableName = AnnotationUtils.getTableName(clazz);
		StringBuilder sql = new StringBuilder("select * from ");
		sql.append(tableName);
		sql.append(" where id = ?");

		List<T> list = getList(clazz, sql.toString(), new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 按给定条件取唯一实体
	 */
	public <T> T get(Class<T> clazz, Map<String, Object> parameters) {
		if (parameters == null) {
			logger.error("get parameters is blank!");
			return null;
		}
		String tableName = AnnotationUtils.getTableName(clazz);
		StringBuilder sqlSb = new StringBuilder("select * from ");
		sqlSb.append(tableName);
		sqlSb.append(" where ");
		int index = 0;
		Object[] objects = new Object[parameters.size()];
		for (Map.Entry<String, Object> param : parameters.entrySet()) {
			if (index != 0) {
				sqlSb.append(" and ");
			}
			sqlSb.append(param.getKey() + "=?");
			objects[index] = param.getValue();
			index++;
		}
		List<T> list = getList(clazz, sqlSb.toString(), objects);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 分页查询-多表
	 */
	public <T> List<T> getList(Class<T> clazz, String sql, Object[] objects) {
		final RowMapper<T> mapper = new BeanPropertyRowMapper(clazz);
		return (List<T>) getJdbcTemplate().query(sql, objects,
				new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return mapper.mapRow(rs, rowNum);
					}
				});
	}

	public <T> List<T> queryPage(Class<T> clazz, String sql, Object[] args,
			final int pageSize, final int pageNo) {
		final RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(clazz);
		final int startRow = (pageNo - 1) * pageSize;
		final int endRow = startRow + pageSize;

		List<T> list =  getJdbcTemplate().query(sql, args,
				new ResultSetExtractor<List<T>>() {
					public List<T> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						final List<T> pageItems = new ArrayList<T>();
						int currentRow = 0;
						while (rs.next() && currentRow < endRow) {
							if (currentRow >= startRow) {
								pageItems.add(rowMapper.mapRow(rs, currentRow));
							}
							currentRow++;
						}
						return pageItems;
					}
				});
		return list;
	}

	public <T> T queryForObject(String sql, Object[] args,
			Class<T> requiredType) {
		return jdbcTemplate.queryForObject(sql, args, requiredType);
	}

	/**
	 * 分页查询-单表
	 */
	public <T> List<T> getList(Class<T> clazz, Map<String, Object> parameters,
			String order, int start, int pageSize) {
		return getList(oracleDB, clazz, parameters, order, start, pageSize);
	}

	private <T> List<T> getList(int dbType, Class<T> clazz,
			Map<String, Object> parameters, String order, int start,
			int pageSize) {
		if (parameters == null) {
			logger.error("getList parameters is blank!");
			return null;
		}
		String tableName = AnnotationUtils.getTableName(clazz);
		StringBuilder whereParam = new StringBuilder();
		Object[] objects = new Object[parameters.size() + 2];
		int index = 0;
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			if (index != 0) {
				whereParam.append(" and ");
			}
			whereParam.append(entry.getKey() + "=?");
			objects[index] = entry.getValue();
			index++;
		}
		objects[index++] = start;
		objects[index++] = pageSize;
		String sql = "";
		String orderSql = "";
		if (!"".equals(order)) {
			orderSql = " ORDER BY " + order;
		}
		if (dbType == mysqlDB) {
			sql = "select * from " + tableName + " where " + whereParam
					+ orderSql + " limit ?,?";
		} else if (dbType == oracleDB) {
			sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM "
					+ "(select * from " + tableName + " WHERE " + whereParam
					+ orderSql + " ) A ) WHERE RN BETWEEN ? AND ? ";
		}
		return getList(clazz, sql, objects);
	}

	/**
	 * 
	 */
	public long getCount(Class<?> clazz, Map<String, Object> parameters) {
		if (parameters == null) {
			logger.error("getCount parameters is blank!");
			return 0;
		}
		String tableName = AnnotationUtils.getTableName(clazz);
		StringBuilder whereParam = new StringBuilder();
		Object[] objects = new Object[parameters.size()];
		int index = 0;
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			if (index != 0) {
				whereParam.append(" and ");
			}
			whereParam.append(entry.getKey() + "=?");
			objects[index] = entry.getValue();
			index++;
		}
		String sql = "select count(*) from " + tableName + " where "
				+ whereParam;
		return jdbcTemplate.queryForObject(sql, objects, Long.class);
	}

}
