package cn.chinasuv.admin.entity;

public class SysRole {
	private Integer id;
	private String rolename;
	private String roleremark;
	private String roledescription;
	public SysRole() {
		super();
	}
	public SysRole(Integer id, String rolename, String roleremark, String roledescription) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.roleremark = roleremark;
		this.roledescription = roledescription;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", rolename=" + rolename + ", roleremark=" + roleremark + ", roledescription="
				+ roledescription + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoleremark() {
		return roleremark;
	}
	public void setRoleremark(String roleremark) {
		this.roleremark = roleremark;
	}
	public String getRoledescription() {
		return roledescription;
	}
	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}
	
}
