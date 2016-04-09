package cn.chinasuv.web.init;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 */
public class InitialServlet extends HttpServlet {

	private static WebApplicationContext springContext;
	/**
	 * @return the springContext
	 */
	public static WebApplicationContext getSpringContext() {
		return springContext;
	}
	public static<T> T getBean(Class<T> clazz){
		return springContext.getBean(clazz);
	}
	public static String REAL_PATH;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3742114267638780107L;
	
	public void destroy() {
		super.destroy();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		REAL_PATH = this.getServletContext().getRealPath("/").replaceAll("\\\\", "/");
	}
}

