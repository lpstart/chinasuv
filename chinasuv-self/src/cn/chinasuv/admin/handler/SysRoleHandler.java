package cn.chinasuv.admin.handler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinasuv.admin.entity.SysMenu;
import cn.chinasuv.admin.entity.SysRole;
import cn.chinasuv.admin.entity.SysRoleMenu;
import cn.chinasuv.admin.service.SysMenuService;
import cn.chinasuv.admin.service.SysRoleService;
import cn.chinasuv.base.config.AppConfig;

@Controller
@RequestMapping("/manage")
public class SysRoleHandler {
	@Autowired
	private SysRoleService sysRoleService = null;
	@Autowired
	private SysMenuService sysMenuService = null;

	@RequestMapping(value = "/menuAllocate_do.jdo")
	public String allocateMenuDo(@RequestParam(value = "menu", required = false) String menu, Integer role_id) {
		List<SysRoleMenu> roleMenuPairByRoleId = sysRoleService.getRoleMenuPairByRoleId(role_id);
		LinkedList<SysRoleMenu> deleteRoleMenu = new LinkedList<SysRoleMenu>();
		LinkedList<SysRoleMenu> insertRoleMenu = new LinkedList<SysRoleMenu>();
		if (menu != null && !menu.equals("")) {
			String[] menuidsChecked = menu.split(",");
			Integer[] menuidsCheckedInt = new Integer[menuidsChecked.length];
			for (int i = 0; i < menuidsChecked.length; i++) {
				menuidsCheckedInt[i] = Integer.parseInt(menuidsChecked[i]);
			}
			Arrays.sort(menuidsCheckedInt);
			// 从小到大排序
			Collections.sort(roleMenuPairByRoleId, new Comparator<SysRoleMenu>() {
				@Override
				public int compare(SysRoleMenu o1, SysRoleMenu o2) {
					return o1.getMenuId() - o2.getMenuId();
				}
			});

			int tempMenuId = 0;
			int i = 0, j = 0;
			for (; i < roleMenuPairByRoleId.size() & j < menuidsCheckedInt.length; i++) {
				tempMenuId = roleMenuPairByRoleId.get(i).getMenuId();
				while (tempMenuId > menuidsCheckedInt[j]) {
					insertRoleMenu.add(new SysRoleMenu(role_id, menuidsCheckedInt[j]));
					j++;
				}
				if (tempMenuId < menuidsCheckedInt[j]) {
					deleteRoleMenu.add(roleMenuPairByRoleId.get(i));
				} else if (tempMenuId == menuidsCheckedInt[j]) {
					j++;
				}
			}

			while (i < roleMenuPairByRoleId.size()) {
				deleteRoleMenu.add(roleMenuPairByRoleId.get(i++));
			}
			while (j < menuidsCheckedInt.length) {
				insertRoleMenu.add(new SysRoleMenu(role_id, menuidsCheckedInt[j++]));
			}
			sysRoleService.batchInsertToRoleMenu(insertRoleMenu);
			sysRoleService.batchDeleteFromRoleMenu(deleteRoleMenu);
		} else {
			sysRoleService.batchDeleteFromRoleMenu(roleMenuPairByRoleId);
		}
		return "redirect:roleHome.jdo";
	}

	@ResponseBody
	@RequestMapping(value = "/getSelfMenuWithSubMenu.jdo")
	public List<SysMenu> getSelfMenuWithSubMenu(@RequestParam(value = "id") Integer roleId) {
		System.out.println("获得已有菜单 Json：" + roleId);
		List<SysMenu> topWithSubMenu = sysMenuService.getTopMenuWithSubMenuByRoleId(roleId);
		return topWithSubMenu;
	}

	@RequestMapping(value = "/menuAllocate.jdo")
	public String toAllocateMenu(@RequestParam(value = "id", required = false) Integer roleId,
			Map<String, Object> map) {
		System.out.println(roleId);
		List<SysMenu> allTopMenuWithSubMenu = sysMenuService.getAllTopMenuWithSubMenu();
		System.out.println(allTopMenuWithSubMenu);
		map.put("role_id", roleId);
		map.put("menus", allTopMenuWithSubMenu);

		return AppConfig.AdminViewPrefix + "role/menuAllocate";
	}

	@RequestMapping(value = "/roleHome.jdo")
	public String toHome(Map<String, Object> map) {
		map.put("allRole", sysRoleService.getAllSysRole());
		return AppConfig.AdminViewPrefix + "role/home";
	}

	@RequestMapping(value = "/addRole.jdo")
	public String toAdd() {
		return AppConfig.AdminViewPrefix + "role/add";
	}

	@RequestMapping(value = "/addRole_do.jdo")
	public String addDo(SysRole sysRole) {
		sysRoleService.addSysRole(sysRole);
		return "redirect:roleHome.jdo";
	}

	@RequestMapping(value = "/editRole_do.jdo")
	public String editDo(SysRole sysRole) {
		sysRoleService.editSysRole(sysRole);
		return "redirect:roleHome.jdo";
	}

	@RequestMapping(value = "/deleteRole_do.jdo")
	public String deleteDo(Integer id) {
		System.out.println("要删除的role id为：" + id);
		sysRoleService.deleteSysRoleById(id);
		return "redirect:roleHome.jdo";
	}

	@RequestMapping(value = "/editRole.jdo")
	public String toEdit(Integer id, Map<String, Object> map) {
		System.out.println(id);
		map.put("role", sysRoleService.getSysRoleById(id));
		return AppConfig.AdminViewPrefix + "role/edit";
	}
}
