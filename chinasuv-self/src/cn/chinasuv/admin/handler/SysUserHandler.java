package cn.chinasuv.admin.handler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinasuv.admin.entity.SysRole;
import cn.chinasuv.admin.entity.SysUser;
import cn.chinasuv.admin.entity.SysUserRole;
import cn.chinasuv.admin.service.SysRoleService;
import cn.chinasuv.admin.service.SysUserService;
import cn.chinasuv.base.config.AppConfig;

@Controller
@RequestMapping("/manage")
public class SysUserHandler {
	@Autowired
	private SysUserService sysUserService = null;
	@Autowired
	private SysRoleService sysRoleService = null;

	@RequestMapping(value = "/roleAllocate_do.jdo")
	public String doRoleAllocate(@RequestParam(value = "role", required = false) String role,
			@RequestParam(value = "user_id") Integer user_id) {
		List<SysUserRole> userRolePairByUserId = sysRoleService.getUserRolePairByUserId(user_id);
		List<SysUserRole> insertRolePairByUserId = new LinkedList<SysUserRole>();
		List<SysUserRole> deleteRolePairByUserIb = new LinkedList<SysUserRole>();
		if (role != null && !role.equals("")) {
			System.out.println("选择的角色：" + role);
			System.out.println("user_id：" + user_id);
			String[] rolesCheckStr = role.split(",");
			Integer[] rolesCheckInt = new Integer[rolesCheckStr.length];
			for (int i = 0; i < rolesCheckStr.length; i++) {
				rolesCheckInt[i] = Integer.parseInt(rolesCheckStr[i]);
			}
			Arrays.sort(rolesCheckInt);
			Collections.sort(userRolePairByUserId, new Comparator<SysUserRole>() {
				@Override
				public int compare(SysUserRole o1, SysUserRole o2) {
					return o1.getRoleId() - o2.getRoleId();
				}
			});
			int tempRoleId = 0;
			int i = 0, j = 0;
			for (; i < userRolePairByUserId.size() & j < rolesCheckInt.length; i++) {
				tempRoleId = userRolePairByUserId.get(i).getRoleId();
				while (tempRoleId > rolesCheckInt[j]) {
					insertRolePairByUserId.add(new SysUserRole(user_id, rolesCheckInt[j]));
					j++;
				}
				if (tempRoleId < rolesCheckInt[j]) {
					deleteRolePairByUserIb.add(userRolePairByUserId.get(i));
				} else if (tempRoleId == rolesCheckInt[j]) {
					j++;
				}
			}

			while (i < userRolePairByUserId.size()) {
				deleteRolePairByUserIb.add(userRolePairByUserId.get(i++));
			}
			while (j < rolesCheckInt.length) {
				insertRolePairByUserId.add(new SysUserRole(user_id, rolesCheckInt[j++]));
			}
			System.out.println("删除的角色:" + deleteRolePairByUserIb);
			System.out.println("添加的角色：" + insertRolePairByUserId);

			sysRoleService.batchInsertToUserRole(insertRolePairByUserId);
			sysRoleService.batchDeleteFromUserRole(deleteRolePairByUserIb);
		} else {
			sysRoleService.batchDeleteFromUserRole(userRolePairByUserId);
		}
		System.out.println("原来的角色：" + sysRoleService.getUserRolePairByUserId(user_id));
		return "redirect:userHome.jdo";
	}

	@RequestMapping(value = "/roleAllocate.jdo")
	public String toRoleAllocate(@RequestParam(value = "id") Integer userId, Map<String, Object> map) {
		map.put("roles", sysRoleService.getAllSysRole());
		map.put("user_id", userId);
		return AppConfig.AdminViewPrefix + "user/roleAllocate";
	}

	@ResponseBody
	@RequestMapping(value = "/getselfrole.jdo")
	public List<SysRole> getSelfRoleJson(@RequestParam(value = "id") Integer userId) {
		System.out.println("已有的角色：" + sysRoleService.getSysRoleByUserid(userId));
		return sysRoleService.getSysRoleByUserid(userId);
	}

	@RequestMapping(value = "/userHome.jdo")
	public String toHome(Map<String, Object> map) {
		map.put("allUser", sysUserService.getAll());
		return AppConfig.AdminViewPrefix + "user/home";
	}

	@RequestMapping(value = "/addUser.jdo")
	public String toAdd(Map<String, Object> map) {
		return AppConfig.AdminViewPrefix + "user/add";
	}

	@RequestMapping(value = "/addUser_do.jdo")
	public String addDo(SysUser sysUser) {
		sysUserService.addSysUser(sysUser);
		return "redirect:userHome.jdo";
	}
 
	@RequestMapping(value = "/editUser_do.jdo")
	public String editDo(SysUser sysUser) {
		sysUserService.editSysUser(sysUser);

		return "redirect:userHome.jdo";
	}

	@RequestMapping(value = "/deleteUser_do.jdo")
	public String deleteDo(Integer id) {
		System.out.println("要删除的用户的 id为：" + id);
		sysUserService.deleteSysUser(id);
		return "redirect:userHome.jdo";
	}

	@RequestMapping(value = "/editUser.jdo")
	public String toEdit(Integer id, Map<String, Object> map) {
		map.put("user", sysUserService.getById(id));
		return AppConfig.AdminViewPrefix + "user/edit";
	}
}
