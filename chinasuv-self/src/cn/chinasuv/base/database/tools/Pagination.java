package cn.chinasuv.base.database.tools;

import java.util.List;

public class Pagination {
	private int DEF_PAGESIZE = 10;
	private String requestUrl;
	/**
	 * 总个数
	 */
	private int totalCount = 0;
	
	/**
	 * 每页个数
	 */
	private int pageSize = DEF_PAGESIZE;
	/**
	 * 页码
	 */
	private int pageNo = 1;
	
	/**
	 * 当前页记录
	 */
	private List<?> list;

	public Pagination(){
		
	}
	
	public Pagination(int pageNo, int pageSize, int totalCount) {
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setPageNo(pageNo);
		checkPageNo();
	}
	
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setPageNo(pageNo);
		checkPageNo();
		this.list = list;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		if(totalCount%pageSize == 0){
			return totalCount/pageSize;
		} else {
			return totalCount/pageSize + 1;
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			this.pageSize = DEF_PAGESIZE;
		} else {
			this.pageSize = pageSize;
		}
	}

	public int getPageNo() {
		if(pageNo < 1){
			return 1;
		} else {
			return pageNo;
		}
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	public void checkPageNo(){
		if (this.pageNo == 1) {
			return;
		}
		int tp = getTotalPage();
		if (this.pageNo > tp) {
			this.pageNo = tp;
		}
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
}
