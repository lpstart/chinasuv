package cn.chinasuv.entity;

import cn.chinasuv.base.database.utils.Table;

@Table(name="main_home")
public class Home {
	/**
	 * LB-首页轮播
	 * TF-today focus
	 * RD-首页-中间-推荐文章
	 * SL-顶部 scroll推荐 
	 * RD24-24-小时阅读
	 * RD24_MORE-24小时阅读-更多推荐
	 */
	public static String[] LOCATIONS = {"LB", "TF", "RRD1", "RRD2", "RRD3", "RRD4", "RRD5", "RRD6", "SL", "RD24","RD24_1","RD24_2","RD24_3","RD24_4","RD24_5","RD24_6", "RT", "PC", "GC", "TK","ZT", "YG"};
	
	@Override
	public String toString() {
		return "Home [id=" + id + ", location=" + location + ", title=" + title + ", picId=" + picId + ", picPath="
				+ picPath + ", objType=" + objType + ", objId=" + objId + ", goUrl=" + goUrl + ", sort=" + sort
				+ ", itemId=" + itemId + ", itemName=" + itemName + "]";
	}
	private Long id;
	private String location;
	private String title;
	private Long picId;
	private String picPath;
	private int objType;
	private Long objId;
	private String goUrl;
	private int sort;
	private Long itemId;
	private String itemName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPicId() {
		return picId;
	}
	public void setPicId(Long picId) {
		this.picId = picId;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public int getObjType() {
		return objType;
	}
	public void setObjType(int objType) {
		this.objType = objType;
	}
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
	public String getGoUrl() {
		return goUrl;
	}
	public void setGoUrl(String goUrl) {
		this.goUrl = goUrl;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
