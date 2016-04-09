package cn.chinasuv.base.database.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import cn.chinasuv.base.database.utils.AnnotationUtils;

public class AnalysisEntity {
	/**
	 * 分析传入的实体，返回插入的sql信息
	 * 
	 * @param <T>
	 * @return sql key[] value[] type
	 */
	public static <T> Object[] getInsertSql(T entity) {
		String tableName = AnnotationUtils.getTableName(entity.getClass());
		StringBuilder sbKey = new StringBuilder();
		StringBuilder sbValue = new StringBuilder();
		Field[] fields = entity.getClass().getDeclaredFields();
		String[] keys = new String[fields.length];
		Object[] values = new Object[fields.length];
		Class<?>[] types = new Class<?>[fields.length];
		int index = 0;
		for (Field field : fields) {
			Object value = new Object();
			field.setAccessible(true);
			try {
				value = field.get(entity);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			String modifier = Modifier.toString(field.getModifiers());
			if ("id".equals(field.getName().toLowerCase())
					|| modifier.indexOf("static") > 0 || value == null) {
				continue;
			}
			values[index] = value;
			keys[index] = field.getName();
			types[index] = field.getType();
			sbKey.append("," + field.getName());
			sbValue.append(",?");
			index++;
		}
		return new Object[] {
				"insert into " + tableName + "(" + sbKey.substring(1)
						+ ") values(" + sbValue.substring(1) + ")", keys,
				values, types };
	}

	public static Object[] getInsertSql(String tableName,
			Map<String, Object> parameters) {
		StringBuilder sbKey = new StringBuilder();
		StringBuilder sbValue = new StringBuilder();
		String[] keys = new String[parameters.size()];
		Object[] values = new Object[parameters.size()];
		Class<?>[] types = new Class<?>[parameters.size()];
		int index = 0;
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			keys[index] = entry.getKey();
			values[index] = entry.getValue();
			types[index] = entry.getValue().getClass();
			sbKey.append("," + entry.getKey());
			sbValue.append(",?");
			index++;
		}
		return new Object[] {
				"insert into " + tableName + "(" + sbKey.substring(1)
						+ ") values(" + sbValue.substring(1) + ")", keys,
				values, types };
	}

	/**
	 * 根据传入的实体class,实例化该实体;并会检验传入的实体是否实现RowMapper接口,如果未实现则返回null
	 * 
	 * @param clazz
	 * @return 返回指定实体对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createEntity(Class<T> clazz) {

		Class<?>[] inters = clazz.getInterfaces();
		boolean checkT = false;
		for (Class<?> inter : inters) {
			if (RowMapper.class.getName().equals(inter.getName())) {
				checkT = true;
			}
		}
		if (!checkT) {
			return null;
		}
		T entity = null;
		try {
			entity = (T) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return entity;
	}
}
