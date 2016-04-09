package cn.chinasuv.admin.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.chinasuv.admin.entity.SysRole;
import cn.chinasuv.admin.entity.SysRoleMenu;
import cn.chinasuv.admin.entity.SysUserRole;
import cn.chinasuv.base.database.BaseDao;

@Repository
public class SysRoleDao {
	@Autowired
	private BaseDao baseDao;

	public void addRole(SysRole sysRole) {
		String sql = "insert into sys_role(rolename,roleremark,roledescription) values(:rolename,:roleremark,:roledescription)";
		new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql,
				new BeanPropertySqlParameterSource(sysRole));
	}

	public void updateSysRole(SysRole sysRole) {
		String sql = "update sys_role set rolename=:rolename,roledescription=:roledescription,roleremark=:roleremark where id=:id";
		new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql,
				new BeanPropertySqlParameterSource(sysRole));
	}

	public SysRole getSysRoleById(Integer id) {
		String sql = "select id,rolename,roledescription,roleremark from sys_role where id=? and status=1";
		return baseDao.get(SysRole.class, sql, new Object[] { id });
	}

	public List<SysRole> getAllSysRole() {
		String sql = "select id,rolename,roledescription,roleremark from sys_role where status=1";
		return baseDao.getList(SysRole.class, sql, null);
	}

	public void deleteById(Integer id) {
		if (id != null) {
			String sql = "delete from sys_role where id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { id });
		}
	}

	public void deleteByRoleIdFromRoleMenu(Integer id) {
		if (id != null) {
			String sql = "delete from sys_role_menu where role_id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { id });
		}
	}

	public List<SysRoleMenu> getRoleMenuPairByRoleId(Integer roleId) {
		String sql = "select id,menu_id,role_id from sys_role_menu where role_id=? and status=1 order by menu_id";
		return baseDao.getList(SysRoleMenu.class, sql, new Object[] { roleId });
	}

	public List<SysUserRole> getUserRolePairByUserId(Integer userId) {
		String sql = "select id,user_id,role_id from sys_user_role where user_id=? and status=1 order by role_id";
		return baseDao.getList(SysUserRole.class, sql, new Object[] { userId });
	}

	public void deleteByRoleIdFromUserRole(Integer id) {
		if (id != null) {
			String sql = "delete from sys_user_role where role_id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { id });
		}
	}

	/**
	 * 根据用户id得到这个用户的所有角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysRole> getRoleByUserId(Integer userId) {

		if (userId != null) {
			String sql = "select sys_role.* from sys_role join sys_user_role as userrole on sys_role.id=userrole.role_id and userrole.user_id=?";
			return baseDao.getList(SysRole.class, sql, new Object[] { userId });
		}
		return new ArrayList<SysRole>();
	}

	/**
	 * 批量从表sys_user_role中删除
	 * 
	 * @param sysUserRoles
	 * @return
	 */
	public int[] batchDeleteFromUserRole(final List<SysUserRole> sysUserRoles) {
		int[] updateCounts = baseDao.getJdbcTemplate().batchUpdate("delete from sys_user_role where id=?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, sysUserRoles.get(i).getId());
					}

					public int getBatchSize() {
						return sysUserRoles.size();
					}
				});
		return updateCounts;
	}

	/**
	 * 批量向表sys_user_role中添加
	 * 
	 * @param sysUserRoles
	 * @return
	 */
	public int[] batchInsertToUserRole(final List<SysUserRole> sysUserRoles) {
		int[] updateCounts = baseDao.getJdbcTemplate().batchUpdate(
				"insert into sys_user_role(user_id,role_id) values(?,?)", new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, sysUserRoles.get(i).getUserId());
						ps.setInt(2, sysUserRoles.get(i).getRoleId());
					}

					public int getBatchSize() {
						return sysUserRoles.size();
					}
				});
		return updateCounts;
	}

	public int[] batchDeleteFromRoleMenu(final List<SysRoleMenu> sysRoleMenus) {
		int[] updateCounts = baseDao.getJdbcTemplate().batchUpdate("delete from sys_role_menu where id=?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, sysRoleMenus.get(i).getId());
					}

					public int getBatchSize() {
						return sysRoleMenus.size();
					}
				});
		return updateCounts;
	}

	public int[] batchInsertToRoleMenu(final List<SysRoleMenu> sysRoleMenus) {
		int[] updateCounts = baseDao.getJdbcTemplate().batchUpdate(
				"insert into sys_role_menu(role_id,menu_id) values(?,?)", new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, sysRoleMenus.get(i).getRoleId());
						ps.setInt(2, sysRoleMenus.get(i).getMenuId());
					}

					public int getBatchSize() {
						return sysRoleMenus.size();
					}
				});
		return updateCounts;
	}

}
