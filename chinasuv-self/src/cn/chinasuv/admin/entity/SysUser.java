package cn.chinasuv.admin.entity;

public class SysUser {
	private Integer id;
	private String username;
	private String password;
	private String gender;
	private String phonenumber;
	private String email;
	private String description;

	public SysUser(String userName, String password, String gender, String email) {
		super();
		this.username = userName;
		this.password = password;
		this.gender = gender;
		this.email = email;
	}

	public SysUser() {
		super();
	}

	public SysUser(Integer id, String userName, String password, String gender, String phoneNumber, String email,
			String description) {
		super();
		this.id = id;
		this.username = userName;
		this.password = password;
		this.gender = gender;
		this.phonenumber = phoneNumber;
		this.email = email;
		this.description = description;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", userName=" + username + ", password=" + password + ", gender=" + gender
				+ ", phoneNumber=" + phonenumber + ", email=" + email + ", description=" + description + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
