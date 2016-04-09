package cn.chinasuv.entity;

import java.util.Date;
import java.util.List;

import cn.chinasuv.base.database.utils.Table;

@Table(name = "main_article")
public class Article {
	/**
	 * 图集
	 */
	public static final int ATLAS = 1;
	/**
	 * 文章
	 */
	public static final int ARTICLE = 0;
	private Long id;
	private Long itemId;
	private String itemName;
	private String title;
	private String summary;
	private Long picId;
	/**
	 * 文章的封面图
	 */
	private String picPath;
	/**
	 * 文章内容，如果{@link Article#contentType}是0，则内容为文章，是1，则是图片集
	 */
	private String content;
	/**
	 * 如果为0，则表示{@link Article#content}为文章，若为1，{@link Article#content}为图片集
	 */
	private int contentType;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date upTime;
	/**
	 * 二级列表排序
	 */
	private int sort;
	private Long viewCount;
	private Long goodCount;
	private Long badCount;
	private Long commentCount;
	private String resource;
	private String author;
	private String editor;
	private List<Picture> picList;
	private Article lastArt;
	private Article nextArt;
	/**
	 * 记录文章的状态：0表示正常，1表示删除
	 */
	private Integer status;

	public Article() {
		super();
	}

	public Article(Long id) {
		super();
		this.id = id;
	}

	public Article(Long itemId, String title, String summary, Long picId, String picPath, String content,
			int contentType, Date createTime, Date upTime, String resource, String author, String editor) {
		super();
		this.itemId = itemId;
		this.title = title;
		this.summary = summary;
		this.picId = picId;
		this.picPath = picPath;
		this.content = content;
		this.contentType = contentType;
		this.createTime = createTime;
		this.upTime = upTime;
		this.resource = resource;
		this.author = author;
		this.editor = editor;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", title=" + title + ", summary="
				+ summary + ", picId=" + picId + ", picPath=" + picPath + ", content=" + content + ", contentType="
				+ contentType + ", createTime=" + createTime + ", upTime=" + upTime + ", sort=" + sort + ", viewCount="
				+ viewCount + ", goodCount=" + goodCount + ", badCount=" + badCount + ", commentCount=" + commentCount
				+ ", resource=" + resource + ", author=" + author + ", editor=" + editor + ", picList=" + picList
				+ ", lastArt=" + lastArt + ", nextArt=" + nextArt + ", status=" + status + "]";
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getBadCount() {
		return badCount;
	}

	public void setBadCount(Long badCount) {
		this.badCount = badCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getContentType() {
		return contentType;
	}

	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public Long getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(Long goodCount) {
		this.goodCount = goodCount;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public List<Picture> getPicList() {
		return picList;
	}

	public void setPicList(List<Picture> picList) {
		this.picList = picList;
	}

	public Article getLastArt() {
		return lastArt;
	}

	public void setLastArt(Article lastArt) {
		this.lastArt = lastArt;
	}

	public Article getNextArt() {
		return nextArt;
	}

	public void setNextArt(Article nextArt) {
		this.nextArt = nextArt;
	}
}
