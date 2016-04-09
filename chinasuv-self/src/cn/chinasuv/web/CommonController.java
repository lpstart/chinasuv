package cn.chinasuv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinasuv.service.CommonService;

@Controller
public class CommonController extends BaseController {
	@Autowired CommonService commonService;
	
	@RequestMapping(value="/get/picInfo.json")
	@ResponseBody
	public String picInfo(Long picId){
		return commonService.getPic(picId);
	}
}
