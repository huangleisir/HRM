package com.hrm.utils;

public class PageHelper {
	private int pageIndex = 1;// 当前页
	private int pageSize = 5;// 每页显示多少行
	private int total;// 总行数
	private Integer totalPage;// 总页数

	public PageHelper() {
	}

	public PageHelper(int pageIndex, Integer pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	public int getBeginIndex() {
		return pageIndex * pageSize - pageSize;
	}

	// 总共有多少页
	public int getTotalPage() {
		totalPage = ((total % pageSize == 0) ? total / pageSize : total
				/ pageSize + 1);
		return totalPage;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNextPage() {
		return pageIndex + 1 > getTotalPage() ? pageIndex : pageIndex + 1;
	}

	public int getPrePage() {
		return pageIndex - 1 <= 0 ? 1 : pageIndex - 1;
	}

	public static void main(String[] args) {
		PageHelper p = new PageHelper(2, 10);
		p.setTotal(1);
		System.out.println(p.getTotalPage());
	}

}
