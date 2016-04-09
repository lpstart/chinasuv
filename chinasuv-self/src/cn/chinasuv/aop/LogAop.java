package cn.chinasuv.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
public class LogAop {
	private final static Log log = LogFactory.getLog(LogAop.class);

	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* cn.chinasuv.web..*(..))")
	public void aspect() {
	}
	
	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点 同时接受JoinPoint切入点对象,可以没有该参数
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		System.out.print(joinPoint+";params:");
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i]+",");
		}
		System.out.println();
		if (log.isInfoEnabled()) {
			log.debug("before " + joinPoint);
		}
	}

	// 配置后置通知,使用在方法aspect()上注册的切入点
	//@After("aspect()")
	public void after(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.debug("after " + joinPoint);
		}
	}


	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	//@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.debug("afterReturn " + joinPoint);
		}
	}

	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut = "aspect()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		if (log.isInfoEnabled()) {
			log.debug("afterThrow " + joinPoint + "\t" + ex.getMessage());
		}
	}
}
