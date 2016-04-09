package cn.chinasuv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.service.CommonService;
import cn.chinasuv.service.HomeService;

@Controller
public class HomeController extends BaseController{
	@Autowired CommonService commonService;
	@Autowired HomeService homeService;
	/**
	 * 首页
	 */
	@RequestMapping(value = "/home/index.php")
	public String index(ModelMap model){
		commonService.headerDate(model);
		homeService.indexDate(model);
		return AppConfig.WebViewPrefix + "index";
	}
	
	
	@RequestMapping(value = "/api.json")
	@ResponseBody
	public String hello(){
		return "world";
	}
	
}
