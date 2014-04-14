package com.hrm.action;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblPositionRelease;
import com.hrm.service.ITblPositionReleaseService;
import com.hrm.utils.Pager;
import com.hrm.utils.StringToTimeStamp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblPositionReleaseAction")
public class TblPositionReleaseAction extends ActionSupport implements ModelDriven {

	@Autowired
	private ITblPositionReleaseService tblPositionReleaseService;

	// 表实体对象
	private TblPositionRelease tblPositionRelease;

	private Pager<TblPositionRelease> page;
	
	private String mess;

	// 根据ID查找
	public String findById() {
		return "find";
	}
	@Permission(nameInclude = "admin")
	public String regist(){
		return "regist";
	}
	// 新增
	@Permission(nameInclude = "admin")
	public String save() {
		try {
			tblPositionRelease.setDeadline(StringToTimeStamp.parse(tblPositionRelease.getDeadline()));
			tblPositionRelease.setRegistTime(StringToTimeStamp.parse(tblPositionRelease.getRegistTime()));
			tblPositionRelease.setChangeTime(StringToTimeStamp.parse(tblPositionRelease.getChangeTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblPositionReleaseService.save(tblPositionRelease);
		return SUCCESS;
	}

	// 修改
	@Permission(nameInclude = "admin")
	public String update() {
		
		TblPositionRelease release=tblPositionReleaseService.find(tblPositionRelease.getMaeId());
		
		try {
			BeanUtils.copyProperties(release, tblPositionRelease);
			release.setDeadline(StringToTimeStamp.parse(release.getDeadline()));
			release.setRegistTime(StringToTimeStamp.parse(release.getRegistTime()));
			release.setChangeTime(StringToTimeStamp.parse(release.getChangeTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		tblPositionReleaseService.update(release);
		return SUCCESS;
	}
	@Permission(nameInclude = "admin")
	public String modify() {
		this.setTblPositionRelease(tblPositionReleaseService.find(tblPositionRelease.getMaeId()));
		return "modify";
	}

	// 删除
	@Permission(nameInclude = "admin")
	public String delete() {
		this.setTblPositionRelease(tblPositionReleaseService.find(tblPositionRelease.getMaeId()));
		tblPositionReleaseService.delete(tblPositionRelease);
		return SUCCESS;
	}

	// 分页
	
	public String spliter() {
		QueryResult<TblPositionRelease> result = tblPositionReleaseService
				.getScrollData((page.getPageNo() - 1) * page.getPageSize(),
						page.getPageSize());

		// 设置分页查询结果集
		page.setList(result.getResultlist());

		// 设置总记录
		page.setTotal((int) result.getTotalrecord());

		// 设置分页总页数
		page.setTotalPage();
		
		if("query".equals(mess))
			return "spliter";
		else{
			return "manager";
		}
	}

	public String check(){
		tblPositionRelease=tblPositionReleaseService.find(tblPositionRelease.getMaeId());
		return "check";
	}
	
	public TblPositionRelease getTblPositionRelease() {
		return tblPositionRelease;
	}

	public void setTblPositionRelease(TblPositionRelease tblPositionRelease) {
		this.tblPositionRelease = tblPositionRelease;
	}

	@Override
	public Object getModel() {
		return page;
	}

	public Pager<TblPositionRelease> getPage() {
		return page;
	}
	@Autowired
	public void setPage(Pager<TblPositionRelease> page) {
		this.page = page;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}
	
	
}
