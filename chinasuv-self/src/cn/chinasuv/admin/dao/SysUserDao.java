package cn.chinasuv.admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.chinasuv.admin.entity.SysUser;
import cn.chinasuv.base.database.BaseDao;

@Repository
public class SysUserDao {
	@Autowired private BaseDao baseDao;

	public SysUser getUserByName() {
		return null;
	}

	public List<SysUser> getAll() {
		String sql = "select id,username,gender,phonenumber,email,description,password from sys_user order by id";
		return baseDao.getList(SysUser.class, sql, null);
	}

	public void deleteByUserId(Integer id) {
		if (id != null) {
			String sql = "delete from sys_user where id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { id });
		}
	}

	public void deleteByUserIdFromUserRole(Integer id) {
		if (id != null) {
			String sql = "delete from sys_user_role where user_id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { id });
		}
	}

	public int add(SysUser sysUser) {
		String sql = "insert into sys_user(username,gender,phonenumber,email,description,password) values(:username,:gender,:phonenumber,:email,:description,:password)";
		return new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql, new BeanPropertySqlParameterSource(sysUser));
	}

	public int update(SysUser sysUser) {
		String sql = "update sys_user set username=:username,gender=:gender,phonenumber=:phonenumber,email=:email,description=:description,password=:password where id=:id";
		return new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql, new BeanPropertySqlParameterSource(sysUser));
	}

	public SysUser getUserById(Integer id) {
		String sql = "select id,username,gender,phonenumber,email,description,password from sys_user where id=?";
		return baseDao.get(SysUser.class, sql, new Object[]{id});
	}

	public SysUser getUserByEmail(String email) {
		String sql = "select * from sys_user where email=?";
		return baseDao.get(SysUser.class, sql, new Object[]{email});
	}
	
	
	
}
