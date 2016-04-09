 package cn.chinasuv.admin.entity;

import java.io.Serializable;

public class ImageResp implements Serializable{

	private static final long serialVersionUID = 1L;
	private String success="success";
	private String id;//图片id
	private String picPath;//图片路径
	private String name;//前端图片名字
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
