package cn.chinasuv.entity;

import cn.chinasuv.base.database.utils.Table;

@Table(name="main_item")
public class Item {
	private Long id;
	private Long pid;
	private String itemName;
	private int sort;
	private String goUrl;
	private String desc;
	private int itemCount;
	private int isHeader;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getGoUrl() {
		return goUrl;
	}
	public void setGoUrl(String goUrl) {
		this.goUrl = goUrl;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getIsHeader() {
		return isHeader;
	}
	public void setIsHeader(int isHeader) {
		this.isHeader = isHeader;
	}
}
