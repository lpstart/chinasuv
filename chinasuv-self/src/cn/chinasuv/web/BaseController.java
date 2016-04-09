package cn.chinasuv.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import cn.chinasuv.base.database.tools.Pagination;


public class BaseController {
	/**
	 * 获取访问者IP
	 * 
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * 
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 * 如果还不存在则调用Request .getRemoteAddr()。
	 * 
	 * @param request
	 * @return
	 */
	public String getCurrUserIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("Proxy-Client-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("WL-Proxy-Client-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("HTTP_CLIENT_IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}else{
			return request.getRemoteAddr();
		}
	}
	
	/**
	 * 设置分页参数
	 * @return
	 */
	public Pagination getPagination(HttpServletRequest request){
		Object pageNo = request.getParameter("pageNo");
		Object pageSize = request.getParameter("pageSize");
		Pagination pagination = new Pagination();
		if(null == pageNo){
			pagination.setPageNo(1);
		}else{
			pagination.setPageNo(Integer.parseInt(pageNo.toString()));
		}
		if(null == pageSize){
			pagination.setPageSize(5);
		}else{
			pagination.setPageSize(Integer.parseInt(pageSize.toString()));
		}
		pagination.setRequestUrl(request.getRequestURL().toString());
		return pagination;
	}
	
	private static String removePageNo(String queryString) {
		int bIndex = queryString.indexOf("&pageNo=");
		if(bIndex > 0) {
			queryString = queryString.substring(0, bIndex);
		} else {
			
		}
		return queryString;
	}
	
	public static void main(String[] args) {
		System.out.println(removePageNo("tid=232&pageNo=2234"));
		System.out.println(removePageNo("pageNo=2&tid=23"));
		
		String ss= "/asdf/adsf.php";
		System.out.println(ss.substring(1));
	}
}
