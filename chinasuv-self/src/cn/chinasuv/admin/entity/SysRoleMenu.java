package cn.chinasuv.admin.entity;

public class SysRoleMenu {
	private Integer id;
	private Integer roleId;
	private Integer menuId;

	public SysRoleMenu() {
		super();
	}

	@Override
	public String toString() {
		return "SysRoleMenu [id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}

	public SysRoleMenu(Integer roleId, Integer menuId) {
		super();
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public SysRoleMenu(Integer id, Integer roleId, Integer menuId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

}
