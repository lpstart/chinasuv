package cn.chinasuv.admin.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.chinasuv.base.config.AppConfig;

@Controller
@RequestMapping("/manage")
public class ManageFowardHandler {
	@Autowired
	private static String SUCCESS = "success";

	@RequestMapping(value = "/login.jdo")
	public String login() {
		return AppConfig.AdminViewPrefix + "login";
	}

	@RequestMapping(value = "/HomeTop.jdo")
	public String toHomeTop() {
		return AppConfig.AdminViewPrefix + "homeTop";
	}

	@RequestMapping(value = "/HomeLeft.jdo")
	public String toHomeLeft(Map<String, Object> map) {
		return AppConfig.AdminViewPrefix + "homeLeft";
	}

	@RequestMapping(value = "/HomeWelcome.jdo")
	public String toHomeWelcom() {
		return AppConfig.AdminViewPrefix + "homeWelcome";
	}
	
	
	
	
	
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
		System.out.println("testRequestParam-->");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.POST)
	public String testRestPost(@PathVariable("id") Integer id) {
		System.out.println("test POST---> " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("test PUT---> " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelte(@PathVariable("id") Integer id) {
		System.out.println("test delete---> " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRestGet(@PathVariable("id") Integer id) {
		System.out.println("test get---> " + id);
		return SUCCESS;
	}

	@RequestMapping("/testpathvariable/{id}")
	public String testpathvariable(@PathVariable("id") Integer id) {
		System.out.println("testpathvariable" + " ____>  id:" + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testregpath/*/abc")
	public String testRegPath() {
		System.out.println("testregpath");
		return SUCCESS;
	}

	@RequestMapping(value = "/testparamsandheaders", method = RequestMethod.GET, params = { "username=haha" })
	public String testParamsAndHeaders() {
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}

	@RequestMapping(value = "/helloworld")
	public String hello() {
		System.out.println("Hello world.");
		return SUCCESS;
	}

	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("test method.");
		return SUCCESS;
	}

}
