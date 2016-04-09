package cn.chinasuv.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.chinasuv.admin.dao.SysMenuDao;
import cn.chinasuv.admin.dao.SysUserDao;
import cn.chinasuv.admin.entity.SysMenu;
import cn.chinasuv.admin.entity.SysUser;

@Service
public class SysMenuService {
	@Autowired
	private SysUserDao sysUserDao = null;
	@Autowired
	private SysMenuDao sysMenuDao = null;

	public void setSysMenuDao(SysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
	}

	public SysMenuDao getSysMenuDao() {
		return sysMenuDao;
	}

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	@Transactional
	public SysMenu getMenuById(Integer id) {
		return sysMenuDao.getMenuByMenuId(id);
	}

	/**
	 * 得到所有的menu，一级菜单和二级菜单平等处理
	 * 
	 * @return
	 */
	@Transactional
	public List<SysMenu> getAllMenu() {
		return sysMenuDao.getAllMenu();
	}

	@Transactional
	public List<SysMenu> getAllTopMenu() {
		return sysMenuDao.getAllTopMenu();
	}

	@Transactional
	public List<SysMenu> getAllTopMenuWithSubMenu() {
		List<SysMenu> topMenu = sysMenuDao.getAllTopMenu();
		for (SysMenu temp : topMenu) {
			temp.setChildMenu(sysMenuDao.getSubMenuByMenuId(temp.getId()));
		}
		return topMenu;
	}

	@Transactional
	public void editMenu(SysMenu sysMenu) {
		sysMenuDao.updateMenu(sysMenu);
	}

	@Transactional
	public void addMenu(SysMenu sysMenu) {
		if (sysMenu.getMenuname() == null) {
			sysMenu.setMenuname(sysMenu.getMenuremark());
		}
		if (sysMenu.getParent_id() != 0)
			sysMenu.setLevel(1);
		else {
			sysMenu.setLevel(0);
		}
		if (sysMenu.getSeq() == null) {
			int seq = sysMenuDao.getSubMenuMaxSeq(sysMenu.getParent_id()) + 1;
			sysMenu.setSeq(seq);
		}
		sysMenuDao.addMenu(sysMenu);
	}

	@Transactional
	public void deleteMenuById(Integer menuId) {
		sysMenuDao.deleteByMenuIdFromRoleMenu(menuId);
		sysMenuDao.deleteByMenuId(menuId);
	}

	/**
	 * 找到这个用户的伴随着子菜单的一级菜单
	 * 
	 * @param sysUser
	 *            用户
	 * @return
	 */
	@Transactional
	public List<SysMenu> getTopMenuWithSubMenuBySysUser(SysUser sysUser) {
		return getTopMenuWithSubMenuByUserId(sysUser.getId());
	}

	/**
	 * 找到这个用户的伴随着子菜单的一级菜单
	 * 
	 * @param id
	 *            用户id
	 * @return
	 */
	@Transactional
	public List<SysMenu> getTopMenuWithSubMenuByUserId(Integer id) {
		List<SysMenu> sysMenus = sysMenuDao.getTopMenuByUserId(id);
		for (SysMenu sysMenu : sysMenus) {
			sysMenu.setChildMenu(sysMenuDao.getSubMenuByMenuIdOfSomeone(id, sysMenu.getId()));
		}
		return sysMenus;
	}

	@Transactional
	public List<SysMenu> getTopMenuWithSubMenuByRoleId(Integer roleId) {
		List<SysMenu> sysMenus = sysMenuDao.getTopMenuByRoleId(roleId);
		for (SysMenu sysMenu : sysMenus) {
			sysMenu.setChildMenu(sysMenuDao.getSubMenuByMenuIdOfSomerole(roleId, sysMenu.getId()));
		}
		return sysMenus;
	}
}
