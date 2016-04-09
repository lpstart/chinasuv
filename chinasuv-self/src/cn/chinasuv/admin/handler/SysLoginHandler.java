package cn.chinasuv.admin.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.chinasuv.admin.entity.SysMenu;
import cn.chinasuv.admin.entity.SysUser;
import cn.chinasuv.admin.service.SysMenuService;
import cn.chinasuv.admin.service.SysUserService;
import cn.chinasuv.base.config.AppConfig;

@Controller
@SessionAttributes(value = { "user", "menus" })
@RequestMapping("/manage")
public class SysLoginHandler {
	@Autowired
	private SysUserService sysUserService = null;
	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping("/home.jdo")
	public String login(String email, String password, Map<String, Object> map) {
		Object object = map.get("user");
		String returnPage;
		if (object != null) {
			List<SysMenu> menus = sysMenuService.getTopMenuWithSubMenuBySysUser((SysUser) object);
			map.put("menus", menus);
			returnPage = "home";
		} else {
			System.out.println(email + "---用户登陆---" + password);
			SysUser sysUser = sysUserService.getByEmail(email);
			if (sysUser != null) {
				if (sysUser.getPassword().equals(password)) {
					List<SysMenu> menus = sysMenuService.getTopMenuWithSubMenuBySysUser(sysUser);
					map.put("user", sysUser);
					map.put("menus", menus);
					returnPage = "home";
				} else {
					map.put("email", email);
					map.put("errorMessage", "密码错误。");
					returnPage = "login";
				}
			} else {
				map.put("errorMessage", "管理员 " + email + "不存在。");
				returnPage = "login";
			}
		}
		return AppConfig.AdminViewPrefix + returnPage;
	}
}
