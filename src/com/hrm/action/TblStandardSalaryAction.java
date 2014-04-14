package com.hrm.action;

import java.text.ParseException;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.pojo.TblStandardSalaryDetail;
import com.hrm.service.ITblStandardSalaryService;
import com.hrm.utils.Pager;
import com.hrm.utils.StringToTimeStamp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("TblStandardSalaryAction")
public class TblStandardSalaryAction extends ActionSupport implements
		ModelDriven {
	/**
	 * 薪酬标准Action
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ITblStandardSalaryService tblStandardSalaryService;
	// 表实体对象
	private TblStandardSalary tblStandardSalary;
	// 页数
	private Pager<TblStandardSalary> page;
	LinkedHashMap<String, String> orderby;

	public LinkedHashMap<String, String> getOrderby() {
		return orderby;
	}

	public void setOrderby(LinkedHashMap<String, String> orderby) {
		this.orderby = orderby;
	}

	public Pager<TblStandardSalary> getPage() {
		return page;
	}

	@Autowired
	public void setPage(Pager<TblStandardSalary> page) {
		this.page = page;
	}

	public TblStandardSalary getTblStandardSalary() {
		return tblStandardSalary;
	}

	public void setTblStandardSalary(TblStandardSalary tblStandardSalary) {
		this.tblStandardSalary = tblStandardSalary;
	}

	/*
	 * //查找 public String find(){
	 * tblStandardSalary=tblStandardSalaryService.find
	 * (tblStandardSalary.getSsdId());
	 * System.out.println("获取的ID是："+tblStandardSalary.getSsdId()); return
	 * "success"; }
	 */
	// 根据薪酬名和薪酬登记时间查找
	public String check() throws Exception {
		// name
		String standardName = tblStandardSalary.getStandardName();
		String registTime = StringToTimeStamp.parse(tblStandardSalary
				.getRegistTime());
		System.out.println("获取的ID是：" + standardName);
		System.out.println("获取的时间是：" + registTime);
		String hql = "o.standardName = ? and o.registTime = ?";
		// String hql =
		// "from TblStandardSalary as o where o.standardName like:name ";
		// from Subject as s where s.subname like :name and s.subinfo like
		// :info";,registTime

		QueryResult<TblStandardSalary> rsl = tblStandardSalaryService
				.getScrollData(-1, -1, hql, new Object[] { standardName,
						registTime });
		System.out.println(rsl);
		page.setList(tblStandardSalaryService.getScrollData(-1, -1, hql,
				new Object[] { standardName, registTime }).getResultlist());
		// 设置总记录
		page.setTotal((int) rsl.getTotalrecord());
		// 设置分页总页数
		page.setTotalPage();
		return "check";
	}

	// 登记复核查询
	public String re_check() {
		// TblStandardSalary=TblStandardSalaryService.find(TblStandardSalary);
		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		page.setList(result.getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// 设置分页总页数
		page.setTotalPage();
		return "re_check";
	}

	// 薪酬设置复核查询
	public String sp_recheck() {
		// TblStandardSalary=TblStandardSalaryService.find(TblStandardSalary);
		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		page.setList(result.getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// 设置分页总页数
		page.setTotalPage();
		return "sp_recheck";
	}

	// 更新查询
	public String mo_check() throws ParseException {
		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		page.setList(result.getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// orderby LinkedHashMap<要排序的字段, desc/dsc>
		// page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
		// page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
		// 设置分页总页数
		page.setTotalPage();
		return "mo_check";
	}

	// 更新精确查询
	public String mo_check1() throws ParseException {
		String standardName = tblStandardSalary.getStandardName();
		String registTime = StringToTimeStamp.parse(tblStandardSalary
				.getRegistTime());
		System.out.println("获取的ID是：" + standardName);
		System.out.println("获取的时间是：" + registTime);
		String hql = "o.standardName = ? and o.registTime = ?";
		// String hql =
		// "from TblStandardSalary as o where o.standardName like:name ";
		// from Subject as s where s.subname like :name and s.subinfo like
		// :info";,registTime

		QueryResult<TblStandardSalary> rsl = tblStandardSalaryService
				.getScrollData(-1, -1, hql, new Object[] { standardName,
						registTime });
		System.out.println(rsl);
		page.setList(tblStandardSalaryService.getScrollData(-1, -1, hql,
				new Object[] { standardName, registTime }).getResultlist());
		// 设置总记录
		page.setTotal((int) rsl.getTotalrecord());
		// 设置分页总页数
		page.setTotalPage();
		return "mo_check1";
	}

	// sp_check 薪酬设置查询全部
	public String sp_check() {
		// LinkedHashMap<"tblStandardSalary.getSsdId()","desc"> orderby;
		// 对象ID
		// String id = (tblStandardSalaryDetail.getSdtId()+"");
		// String standardName = tblStandardSalary.getStandardName();
		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		// String hql = "o.standardName = ?";
		page.setList(result.getResultlist());
		// page.setList(tblStandardSalaryService.getScrollData(-1, -1, hql, new
		// Object[]{standardName}).getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// orderby LinkedHashMap<要排序的字段, desc/dsc>
		// page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
		// page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
		// 设置分页总页数
		page.setTotalPage();
		return "sp_check";
		// return "modify";
	}

	// 薪酬按名称查询
	public String sp_check1() {
		// LinkedHashMap<"tblStandardSalary.getSsdId()","desc"> orderby;
		// 对象ID
		// String id = (tblStandardSalaryDetail.getSdtId()+"");
		String standardName = tblStandardSalary.getStandardName();
		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		String hql = "o.standardName = ?";
		// page.setList(result.getResultlist());
		page.setList(tblStandardSalaryService.getScrollData(-1, -1, hql,
				new Object[] { standardName }).getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// orderby LinkedHashMap<要排序的字段, desc/dsc>
		// page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
		// page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
		// 设置分页总页数
		page.setTotalPage();
		return "sp_check";
		// return "modify";
	}

	// 新增
	public String save() {
		try {
			tblStandardSalary.setRegistTime(StringToTimeStamp
					.parse(tblStandardSalary.getRegistTime()));
			tblStandardSalary.setCheckTime(StringToTimeStamp
					.parse(tblStandardSalary.getCheckTime()));
			tblStandardSalary.setChangeTime(StringToTimeStamp
					.parse(tblStandardSalary.getChangeTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblStandardSalaryService.save(tblStandardSalary);
		return SUCCESS;
	}

	// 修改
	public String update() {
		// System.out.println(tblStandardSalary.getSsdId());
		TblStandardSalary tbls = tblStandardSalaryService
				.find(tblStandardSalary.getSsdId());
		tbls.setStandardId(tblStandardSalary.getStandardId());
		tbls.setStandardName(tblStandardSalary.getStandardName());
		tbls.setSalarySum(tblStandardSalary.getSalarySum());
		tbls.setDesigner(tblStandardSalary.getDesigner());
		tbls.setRegister(tblStandardSalary.getRegister());
		tbls.setChecker(tblStandardSalary.getChecker());
		tbls.setRemark(tblStandardSalary.getRemark());
		try {
			// 将更新后的时间添加
			/*
			 * tbls.setRegistTime(StringToTimeStamp.parse(tbls.getRegistTime()));
			 * tbls.setCheckTime(StringToTimeStamp.parse(tbls.getCheckTime()));
			 * tbls
			 * .setChangeTime(StringToTimeStamp.parse(tbls.getChangeTime()));
			 */
			// System.out.println("获取更新前"+tblStandardSalary.getSsdId());
			// 将未改的时间添加
			tbls.setRegistTime(StringToTimeStamp.parse(tblStandardSalary
					.getRegistTime()));
			tbls.setCheckTime(StringToTimeStamp.parse(tblStandardSalary
					.getCheckTime()));
			tbls.setChangeTime(StringToTimeStamp.parse(tblStandardSalary
					.getChangeTime()));
			// System.out.println(tblStandardSalary.getSsdId());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tblStandardSalaryService.update(tbls);
		return SUCCESS;
	}

	// 获取更新表单数据
	public String modify() {
		this.setTblStandardSalary(tblStandardSalaryService
				.find(tblStandardSalary.getSsdId()));
		return "modify";
	}

	// 获取更新表单数据
	public String sp_modify() {
		this.setTblStandardSalary(tblStandardSalaryService
				.find(tblStandardSalary.getSsdId()));
		return "sp_modify";
	}

	// 登记复核
	public String register() {
		this.setTblStandardSalary(tblStandardSalaryService
				.find(tblStandardSalary.getSsdId()));

		return "register";
	}

	// sp_regist薪酬设置复核
	public String sp_register() {
		this.setTblStandardSalary(tblStandardSalaryService
				.find(tblStandardSalary.getSsdId()));
		return "sp_register";
	}

	/*
	 * //设置复核 public String setup(){
	 * this.setTblStandardSalary(tblStandardSalaryService
	 * .find(tblStandardSalary.getSsdId()));
	 * 
	 * return "setup"; }
	 */
	// 删除
	public String delete() {
		tblStandardSalaryService.delete(tblStandardSalaryService
				.find(tblStandardSalary.getSsdId()));
		return SUCCESS;
	}

	// 薪酬查询
	public String spliter() {
		// LinkedHashMap<"tblStandardSalary.getSsdId()","desc"> orderby;
		// 对象ID
		// String id = (tblStandardSalary.getSsdId()+"");

		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		page.setList(result.getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// orderby LinkedHashMap<要排序的字段, desc/dsc>
		// page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
		// page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
		// 设置分页总页数
		page.setTotalPage();
		return "spliter";
		// return "modify";
	}

	// 分页
	public String fenye() {
		// LinkedHashMap<"tblStandardSalary.getSsdId()","desc"> orderby;
		// 对象ID
		// String id = (tblStandardSalary.getSsdId()+"");

		QueryResult<TblStandardSalary> result = tblStandardSalaryService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());
		// 设置分页查询结果集
		page.setList(result.getResultlist());
		// 设置总记录
		page.setTotal((int) result.getTotalrecord());
		// orderby LinkedHashMap<要排序的字段, desc/dsc>
		// page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
		// page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
		// 设置分页总页数
		page.setTotalPage();
		return "fenye";
		// return "modify";
	}

	@Override
	public Object getModel() {
		return page;
	}
}
