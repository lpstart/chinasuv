package cn.chinasuv.entity;

import java.util.Date;

import cn.chinasuv.base.database.utils.Table;

@Table(name="main_topic_summary")
public class TopicSummary {
	private Long id;
	private Long picId;
	private String picPath;
	private String title;
	private int sort;
	private Date createTime;
	private int status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
