package com.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

//分页类
@Component
public class Page {
	private int pageIndex;// 第几页
	private int pagePre;//limit前参
	private int pageSize;// 每页几条
	private int totalCount;// 总条数
	private int totalPages;// 总页数
	// 每页要显示的数据
	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	public int getPageIndex() {
		return pageIndex;
	}
	
	public int getPagePre() {
		return pagePre;
	}

	public void setPagePre(int pagePre) {
		this.pagePre = pagePre;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		this.totalPages = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<Map<String,Object>> getList() {
		return list;
	}
	public void setList(List<Map<String,Object>> list) {
		this.list = list;
	}
	
}
