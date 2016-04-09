package cn.chinasuv.base.spring;

import org.springframework.beans.factory.BeanFactory;

public class SpringHelper {
	private static BeanFactory beanFactory = null;

	public static Object getBean(String name) {
		return beanFactory.getBean(name);
	}

	public static void setBeanFactory(BeanFactory bc) {
		beanFactory = bc;
	}
}
