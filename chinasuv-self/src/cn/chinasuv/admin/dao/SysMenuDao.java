package cn.chinasuv.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cn.chinasuv.admin.entity.SysMenu;
import cn.chinasuv.admin.entity.SysUser;
import cn.chinasuv.base.database.BaseDao;

@Repository
public class SysMenuDao {
	@Autowired
	private BaseDao baseDao;

	public List<SysMenu> getTopMenuByUser(SysUser sysUser) {
		return getTopMenuByUserId(sysUser.getId());
	}

	/**
	 * 找到某个用户的所有的一级菜单
	 * 
	 * @param id
	 *            用户的id
	 * @return
	 */
	public List<SysMenu> getTopMenuByUserId(Integer id) {
		return getSubMenuByMenuIdOfSomeone(id, 0);
	}

	public List<SysMenu> getTopMenuByRoleId(Integer roleId) {
		return getSubMenuByMenuIdOfSomerole(roleId, 0);
	}

	public int updateMenu(SysMenu sysMenu) {
		String sql = "update sys_menu set location=? where id=?";
		return baseDao.getJdbcTemplate().update(sql, new Object[] { sysMenu.getLocation(), sysMenu.getId() });
	}

	public void addMenu(SysMenu sysMenu) {
		String sql = "insert into sys_menu(id,menuname,menuremark,location,parent_id,seq,level) values(:id,:menuname,:menuremark,:location,:parent_id,:seq,:level)";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(sysMenu);
		new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql, namedParameters);
	}

	/**
	 * 找到一级菜单
	 * 
	 * @return
	 */
	public List<SysMenu> getAllTopMenu() {
		return getSubMenuByMenuId(0);
	}

	/**
	 * 得到所有的menu，一级菜单和二级菜单平等处理
	 * 
	 * @return
	 */
	public List<SysMenu> getAllMenu() {
		String sql = "select id,menuremark,location,parent_id,seq from sys_menu";
		List<SysMenu> allMenu = baseDao.getJdbcTemplate().query(sql, new RowMapper<SysMenu>() {
			@Override
			public SysMenu mapRow(ResultSet res, int rowNum) throws SQLException {
				SysMenu sysMenu = new SysMenu();
				sysMenu.setId(res.getInt("id"));
				sysMenu.setMenuname(res.getString("menuremark"));
				sysMenu.setMenuremark(res.getString("menuremark"));
				sysMenu.setLocation(res.getString("location"));
				sysMenu.setParent_id(res.getInt("parent_id"));
				sysMenu.setSeq(res.getInt("seq"));
				return sysMenu;
			}
		});
		return allMenu;
	}

	public SysMenu getMenuByMenuId(Integer id) {
		String sql = "select id,menuname,menuremark,parent_id,level,location,seq from sys_menu where id=?";
		List<SysMenu> sysMenus = baseDao.getJdbcTemplate().query(sql, new Object[] { id }, new RowMapper<SysMenu>() {
			@Override
			public SysMenu mapRow(ResultSet res, int rowNum) throws SQLException {
				SysMenu sysMenu = new SysMenu();
				sysMenu.setId(res.getInt("id"));
				sysMenu.setMenuname(res.getString("menuname"));
				sysMenu.setMenuremark(res.getString("menuremark"));
				sysMenu.setLocation(res.getString("location"));
				sysMenu.setLevel(res.getInt("level"));
				sysMenu.setParent_id(res.getInt("parent_id"));
				sysMenu.setSeq(res.getInt("seq"));
				return sysMenu;
			}

		});
		if (sysMenus.size() > 0)
			return sysMenus.get(0);
		return null;
	}

	public int getSubMenuMaxSeq(Integer id) {
		String sql = "select max(seq) from sys_menu where parent_id=?";
		return baseDao.getJdbcTemplate().queryForInt(sql, new Object[] { id });
	}

	/**
	 * 根据父菜单，找到所有的子菜单
	 * 
	 * @param id
	 * @return
	 */
	public List<SysMenu> getSubMenuByMenuId(Integer id) {
		String sql = "select id,menuname,menuremark,location,seq,parent_id,level from sys_menu where parent_id=? order by seq";
		List<SysMenu> childMenus = baseDao.getJdbcTemplate().query(sql, new Object[] { id }, new RowMapper<SysMenu>() {
			@Override
			public SysMenu mapRow(ResultSet res, int rowNum) throws SQLException {
				SysMenu sysMenu = new SysMenu();
				sysMenu.setId(res.getInt("id"));
				sysMenu.setMenuname(res.getString("menuname"));
				sysMenu.setMenuremark(res.getString("menuremark"));
				sysMenu.setLocation(res.getString("location"));
				sysMenu.setLevel(res.getInt("level"));
				sysMenu.setParent_id(res.getInt("parent_id"));
				sysMenu.setSeq(res.getInt("seq"));
				return sysMenu;
			}

		});
		return childMenus;
	}

	public List<SysMenu> getSubMenuByMenuIdOfSomerole(Integer roleId, Integer parentMenuId) {
		String menuSql = "select menu.* from sys_menu as menu "
				+ "join sys_role_menu as rolemenu on rolemenu.menu_id=menu.id and rolemenu.role_id=? "
				+ "where menu.parent_id=? " + "order by menu.seq";
		List<SysMenu> sysMenus = baseDao.getJdbcTemplate().query(menuSql, new Object[] { roleId, parentMenuId },
				new RowMapper<SysMenu>() {
					public SysMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
						SysMenu sysMenu = new SysMenu();
						sysMenu.setId(rs.getInt("id"));
						sysMenu.setMenuname(rs.getString("menuname"));
						sysMenu.setMenuremark(rs.getString("menuremark"));
						sysMenu.setLocation(rs.getString("location"));
						sysMenu.setParent_id(rs.getInt("parent_id"));
						sysMenu.setLevel(rs.getInt("level"));
						sysMenu.setSeq(rs.getInt("seq"));
						return sysMenu;
					}
				});
		return sysMenus;
	}

	/**
	 * 找到属于某个用户的某个父菜单的子菜单
	 * 
	 * @param userId
	 *            用户的id
	 * @param parentMenuId
	 *            父菜单的id
	 * @return 返回这个菜单
	 */
	public List<SysMenu> getSubMenuByMenuIdOfSomeone(Integer userId, Integer parentMenuId) {
		String menuSql = "select menu.* from sys_menu as menu "
				+ "join sys_role_menu as rolemenu on rolemenu.menu_id=menu.id and menu.parent_id=? "
				+ "join sys_user_role as userrole on userrole.role_id=rolemenu.role_id " + "where userrole.user_id=? "
				+ "order by menu.seq";
		List<SysMenu> sysMenus = baseDao.getJdbcTemplate().query(menuSql, new Object[] { parentMenuId, userId },
				new RowMapper<SysMenu>() {
					public SysMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
						SysMenu sysMenu = new SysMenu();
						sysMenu.setId(rs.getInt("id"));
						sysMenu.setMenuname(rs.getString("menuname"));
						sysMenu.setMenuremark(rs.getString("menuremark"));
						sysMenu.setLocation(rs.getString("location"));
						sysMenu.setParent_id(rs.getInt("parent_id"));
						sysMenu.setLevel(rs.getInt("level"));
						sysMenu.setSeq(rs.getInt("seq"));
						return sysMenu;
					}
				});
		return sysMenus;
	}

	public void deleteByMenuId(Integer menuId) {
		if (menuId != null) {
			String sql = "delete from sys_menu where id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { menuId });
		}
	}

	public void deleteByMenuIdFromRoleMenu(Integer menuId) {
		if (menuId != null) {
			String sql = "delete from sys_role_menu where menu_id=?";
			baseDao.getJdbcTemplate().update(sql, new Object[] { menuId });
		}
	}

}
