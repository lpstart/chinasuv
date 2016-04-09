package cn.chinasuv.entity;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.common.reflect.Reflection;

import cn.chinasuv.base.database.utils.Table;

@Table(name="main_pic")
public class Picture {
	private Long id;
	private String picPath;
	private String smallPicPath;
	private Date createTime;
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSmallPicPath() {
		return smallPicPath;
	}
	public void setSmallPicPath(String smallPicPath) {
		this.smallPicPath = smallPicPath;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
