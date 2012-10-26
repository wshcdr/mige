package com.spark.core.support;

import java.util.List;

/**
 * @author hgu
 * 
 */
public class PageResult<T> {
	private int		pageNo;
	private int		pageSize;
	private int		pageCount;
	private int		totalRecord;
	private List<T>	result;

	public void calculate() {
		if (pageSize <= 0) {
			throw new IllegalArgumentException("page size must begger than 0");
		}
		/*
		 * calculate page count
		 */
		pageCount = totalRecord / pageSize;
		pageCount += totalRecord % pageSize == 0 ? 0 : 1;

		if (pageNo > pageCount) {
			pageNo = pageCount;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
