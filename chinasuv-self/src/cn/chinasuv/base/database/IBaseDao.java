package cn.chinasuv.base.database;

import java.util.List;
import java.util.Map;

/**
 * 查询条件传T,查询返回T或者List< T >
 * @author Venjean
 */
public interface IBaseDao {
	public long getId(String seq);
	/**
	 * 插入单条记录
	 * @param entity
	 * @return
	 */
	public <T> int insert(T entity);
	public <T> long insertWhitDesc(T entity);
	
	/**
	 * 更新操作
	 * @return
	 */
	public int update(Class<?> clazz, long id, Map<String, Object> parameters);
	public int update(Class<?> clazz, Map<String, Object> setParams, Map<String, Object> whereParams);
	
	/**
	 * 删除操作
	 * @return
	 */
	public int delete(Class<?> clazz, long id);
	public int delete(Class<?> clazz, Map<String, Object> parameters);
	
	public <T> T get(Class<T> clazz, String sql, Object[] objects);
	public <T> T get(Class<T> clazz, long id);
	public <T> T get(Class<T> clazz, Map<String, Object> parameters);
	
	public <T> List<T> getList(Class<T> clazz, String sql, Object[] objects);
	public <T> List<T> queryPage(Class<T> clazz, String sql, Object[] args, final int pageSize, final int pageNo);
	public <T> T queryForObject(String sql, Object[] args, Class<T> requiredType);
	
	public <T> List<T> getList(Class<T> clazz, Map<String,Object> param, String order, int start, int pageSize);
	public long getCount(Class<?> clazz, Map<String,Object> param);
}
