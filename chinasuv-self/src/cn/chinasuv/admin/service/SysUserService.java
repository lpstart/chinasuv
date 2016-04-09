package cn.chinasuv.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.chinasuv.admin.dao.SysMenuDao;
import cn.chinasuv.admin.dao.SysUserDao;
import cn.chinasuv.admin.entity.SysUser;

@Service
public class SysUserService {
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
	public void deleteSysUser(Integer id) {
		this.sysUserDao.deleteByUserIdFromUserRole(id);
		this.sysUserDao.deleteByUserId(id);
	}

	@Transactional
	public void addSysUser(SysUser sysUser) {
		this.sysUserDao.add(sysUser);
	}

	@Transactional
	public void editSysUser(SysUser sysUser) {
		this.sysUserDao.update(sysUser);
	}

	@Transactional
	public List<SysUser> getAll() {
		return sysUserDao.getAll();
	}

	@Transactional
	public SysUser getByEmail(String email) {
		return sysUserDao.getUserByEmail(email);
	}

	@Transactional
	public SysUser getById(Integer id) {
		return sysUserDao.getUserById(id);
	}

}
