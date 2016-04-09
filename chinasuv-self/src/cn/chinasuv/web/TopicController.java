package cn.chinasuv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.service.CommonService;
import cn.chinasuv.service.TopicService;

@Controller
public class TopicController extends BaseController {

	@Autowired CommonService commonService;
	@Autowired TopicService topicService;
	
	@RequestMapping(value="/topic/summary.php")
	public String topicSummary(ModelMap model){
		commonService.headerDate(model);
		topicService.getTopicSummary(model);
		return AppConfig.WebViewPrefix + "summary";
	}
	
	@RequestMapping(value="/topic/details/{id}.html")
	public String topicDetails(ModelMap model,@PathVariable Long id){
		model.put("picHost", AppConfig.picHost);
		System.out.println(id);
		return AppConfig.WebViewPrefix + "topic";
	}
}
