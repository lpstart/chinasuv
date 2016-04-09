package cn.chinasuv.base.database.utils;

import java.lang.annotation.Annotation;

public class AnnotationUtils {
	public static String getTableName(Class<?> clazz){
		String tableName = "";
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Table) {
				Table table = (Table) annotation;
				tableName = table.name();
			}
		}
		return tableName;
	}
}
