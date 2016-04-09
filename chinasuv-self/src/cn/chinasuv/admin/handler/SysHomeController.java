package cn.chinasuv.admin.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.entity.Home;
import cn.chinasuv.service.HomeService;

@Controller
@RequestMapping("/manage")
public class SysHomeController {
	@Autowired
	HomeService homeService;

	@RequestMapping(value = "/home/list.jhtml")
	public String home(ModelMap model, String location) {
		model.put("picHost", AppConfig.picHost);
		homeService.manageIndexDate(model, location);
		return AppConfig.AdminViewPrefix + "home/list";
	}

	@RequestMapping(value = "/home/edit.jhtml")
	public String editHomePage(ModelMap model, Long id) {
		if (id == null || id == 0) {

		} else {
			Home home = homeService.getHomeWithPicPath(id);
			model.put("home",home );
			System.out.println(home);
		}
		return AppConfig.AdminViewPrefix + "home/edit";
	}

	@RequestMapping(value = "/home/edit.jdo")
	public String editHome(ModelMap model, Home home) {
		homeService.editHome(home);
		System.out.println(home);
		String subLocal = homeService.subLocation(home.getLocation());
		return "redirect:list.jhtml?location=" + subLocal;
	}
}
