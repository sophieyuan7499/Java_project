package com.iflytek.bxpt.util;

import java.util.List;
import com.iflytek.bxpt.po.Equipment;


//页面模型（封装某一页的信息）
public class PageModel {
	private List<Equipment> equipments;
	private int totalRecords;//总记录数
	private int pageSize=6;//每页展示几条数据
	private int totalPages;//总页数
	private int pageNo;//页码
	

	public List<Equipment> getEquipments() {
		return equipments;
	}
	//申明他们的get,set,方法
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalPages() {
	 return totalRecords%6==0? (totalRecords/6):(totalRecords/6 + 1);
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	//首页
	public int getTopPage() {
		return 1;
	}
	//上一页
	public int getPreviousPage() {
		return pageNo<=1? 1:(pageNo-1);
	}

	//下一页
	public int getNextPage() {
		return pageNo>=getTotalPages()? getTotalPages():(pageNo+1);
	}
	
	//尾页
	public int getLastPage() {
		return getTotalPages();
	}
}
