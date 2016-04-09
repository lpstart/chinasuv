package cn.chinasuv.admin.entity;

import java.util.List;

public class SysMenu {
	private Integer id;
	private String menuname;
	private String menuremark;
	private String location;
	private Integer parent_id;
	private Integer seq;
	private List<SysMenu> childMenu;
	private Integer level;

	public SysMenu() {
		super();
	}

	@Override
	public String toString() {
		return "SysMenu [id=" + id + ", menuname=" + menuname + ", menuremark=" + menuremark + ", location=" + location
				+ ", parent_id=" + parent_id + ", seq=" + seq + ", childMenu=" + childMenu + ", level=" + level + "]";
	}

	public SysMenu(Integer id, String menuname, String menuremark, String location, Integer parent_id, Integer seq) {
		super();
		this.id = id;
		this.menuname = menuname;
		this.menuremark = menuremark;
		this.location = location;
		this.parent_id = parent_id;
		this.seq = seq;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenuremark() {
		return menuremark;
	}

	public void setMenuremark(String menuremark) {
		this.menuremark = menuremark;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public List<SysMenu> getChildMenu() {
		return childMenu;
	}

	public int getChildSize() {
		if (childMenu == null) {
			return 0;
		}
		return childMenu.size();
	}

	public void setChildMenu(List<SysMenu> childMenu) {
		this.childMenu = childMenu;
	}

}
