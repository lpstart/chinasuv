package cn.chinasuv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.service.CommonService;

@Controller
public class AController extends BaseController{
	@Autowired private CommonService commonService;
	
	@RequestMapping(value="/a/aboutus.html")
	public String aboutUs(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/aboutus";
	}
	@RequestMapping(value="/a/adservice.html")
	public String adService(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/adservice";
	}
	@RequestMapping(value="/a/contact.html")
	public String contact(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/contact";
	}
	@RequestMapping(value="/a/copyright.html")
	public String copyRight(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/copyright";
	}
	@RequestMapping(value="/a/job.html")
	public String job(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/job";
	}
	@RequestMapping(value="/a/links.html")
	public String links(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/links";
	}
	@RequestMapping(value="/a/renew.html")
	public String renew(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/renew";
	}
	@RequestMapping(value="/a/sitemap.html")
	public String sitemap(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/sitemap";
	}
	@RequestMapping(value="/a/subscribe.html")
	public String subscribe(ModelMap model){
		return AppConfig.WebViewPrefix + "a/subscribe";
	}
	@RequestMapping(value="/a/subscriptions.html")
	public String subscriptions(ModelMap model){
		commonService.headerDate(model);
		return AppConfig.WebViewPrefix + "a/subscriptions";
	}
}
