package cn.chinasuv.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.chinasuv.admin.dao.SysRoleDao;
import cn.chinasuv.admin.entity.SysRole;
import cn.chinasuv.admin.entity.SysRoleMenu;
import cn.chinasuv.admin.entity.SysUserRole;

@Service
public class SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;

	@Transactional
	public void editSysRole(SysRole sysRole) {
		if (sysRole.getRoleremark() == null) {
			sysRole.setRoleremark(sysRole.getRolename());
		}
		if (sysRole.getRolename() == null) {
			sysRole.setRolename(sysRole.getRoleremark());
		}
		this.sysRoleDao.updateSysRole(sysRole);
	}

	@Transactional
	public List<SysRole> getAllSysRole() {
		return sysRoleDao.getAllSysRole();
	}

	/**
	 * 根据角色的id得到角色的信息
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public SysRole getSysRoleById(Integer id) {
		return sysRoleDao.getSysRoleById(id);
	}

	/**
	 * 根据用户的id得到这个用户的所有角色的信息
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public List<SysRole> getSysRoleByUserid(Integer useId) {
		return sysRoleDao.getRoleByUserId(useId);
	}

	@Transactional
	public void addSysRole(SysRole sysRole) {
		if (sysRole.getRoleremark() == null) {
			sysRole.setRoleremark(sysRole.getRolename());
		}
		if (sysRole.getRolename() == null) {
			sysRole.setRolename(sysRole.getRoleremark());
		}
		sysRoleDao.addRole(sysRole);
	}

	@Transactional(readOnly = true)
	public List<SysRoleMenu> getRoleMenuPairByRoleId(Integer roleId) {
		return sysRoleDao.getRoleMenuPairByRoleId(roleId);
	}
	@Transactional(readOnly = true)
	public List<SysUserRole> getUserRolePairByUserId(Integer userId) {
		return sysRoleDao.getUserRolePairByUserId(userId);
	}

	@Transactional
	public void deleteSysRoleById(Integer roleId) {
		sysRoleDao.deleteByRoleIdFromRoleMenu(roleId);
		sysRoleDao.deleteByRoleIdFromUserRole(roleId);
		sysRoleDao.deleteById(roleId);
	}

	@Transactional
	public void batchDeleteFromRoleMenu(List<SysRoleMenu> sysRoleMenus) {
		sysRoleDao.batchDeleteFromRoleMenu(sysRoleMenus);
	}

	@Transactional
	public void batchInsertToRoleMenu(List<SysRoleMenu> sysRoleMenus) {
		sysRoleDao.batchInsertToRoleMenu(sysRoleMenus);
	}

	@Transactional
	public void batchDeleteFromUserRole(List<SysUserRole> sysUserRoles) {
		sysRoleDao.batchDeleteFromUserRole(sysUserRoles);
	}

	@Transactional
	public void batchInsertToUserRole(List<SysUserRole> sysUserRoles) {
		sysRoleDao.batchInsertToUserRole(sysUserRoles);
	}

}
