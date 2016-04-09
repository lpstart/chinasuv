package cn.chinasuv.admin.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.chinasuv.admin.entity.SysMenu;
import cn.chinasuv.admin.service.SysMenuService;
import cn.chinasuv.base.config.AppConfig;

@Controller
@RequestMapping("/manage")
public class SysMenuHandler {
	@Autowired
	private SysMenuService sysMenuService = null;


	@RequestMapping(value = "/menuHome.jdo")
	public String toMenuHome(Map<String, Object> map) {
		map.put("allMenu", sysMenuService.getAllMenu());
		return AppConfig.AdminViewPrefix + "menu/home";
	}

	@RequestMapping(value = "/addMenu.jdo")
	public String toAddMenu(Map<String, Object> map) {
		//将一级菜单返回，让可以选择新建的菜单属于哪个父菜单
		map.put("allTopMenu", sysMenuService.getAllTopMenu());
		return AppConfig.AdminViewPrefix + "menu/add";
	}

	@RequestMapping(value = "/addMenu_do.jdo")
	public String addMenuDo(SysMenu sysMenu) {
		sysMenuService.addMenu(sysMenu);
		return "redirect:menuHome.jdo";
	}

	@RequestMapping(value = "/editMenu_do.jdo")
	public String editMenuDo(SysMenu sysMenu) {
		sysMenuService.editMenu(sysMenu);
		return "redirect:menuHome.jdo";
	}

	@RequestMapping(value = "/deleteMenu_do.jdo")
	public String deleteMenuDo(Integer id) {
		System.out.println("要删除的menu id为：" + id);
		sysMenuService.deleteMenuById(id);
		return "redirect:menuHome.jdo";
	}

	@RequestMapping(value = "/editMenu.jdo")
	public String editMenu(Integer id, Map<String, Object> map) {
		// System.out.println(sysMenu);
		System.out.println(id);
		SysMenu sysMenuTemp = sysMenuService.getMenuById(id);
		map.put("menu", sysMenuTemp);
		if (sysMenuTemp != null) {
			int parent_id = sysMenuTemp.getParent_id();
			if (parent_id == 0) {
				map.put("parentMenuName", "0");
			} else {
				map.put("parentMenuName", sysMenuService.getMenuById(parent_id).getMenuremark());
			}
		}
		return AppConfig.AdminViewPrefix + "menu/edit";
	}

}
