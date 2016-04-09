package cn.chinasuv.admin.entity;

public class SysUserRole {
	private Integer id;
	private Integer userId;
	private Integer roleId;

	@Override
	public String toString() {
		return "SysUserRole [id=" + id + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

	public SysUserRole() {
		super();
	}

	public SysUserRole(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public SysUserRole(Integer id, Integer userId, Integer roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
