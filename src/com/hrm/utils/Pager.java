package com.hrm.utils;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("page")
public class Pager<T> {
	// 总记录数
	private Integer total;
	// 总页数
	private Integer totalPage;
	// 当前第几页 初始值为1
	private Integer pageNo = 1 ;
	// 每页显示多少记录数 初始值为3
	private Integer pageSize = 3;
	// 保存分页的记录 分页为复用 这里的list在显示不同的页面时被不同的列表内容充满
	private List<T> list;

	public void setTotalPage() {
		totalPage = ((total % pageSize == 0) ? total / pageSize : total / pageSize + 1);
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
}
