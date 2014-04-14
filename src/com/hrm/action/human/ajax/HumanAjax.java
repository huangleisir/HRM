package com.hrm.action.human.ajax;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.pojo.TblMajorName;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.HumanServer;
import com.opensymphony.xwork2.ActionSupport;
@Controller("HumanAjax")
@Scope("prototype")
public class HumanAjax extends ActionSupport{
	private List<TblFirstClass> firstClassList;
	private List<TblSecondClass> secondClassList;
	private List<TblThirdClass> thirdClassList;
	private List<TblMajorClassify> majorClassifyList;
	private List<TblStandardSalary> standardSalaryList;
	private List<TblMajorName> majorNameList;
	private List<String> attNames;
	private int firstId;
	private int secondId;
	private String type;
	private String clazz;
	//private List<TblFirstClass> firstClassList;
	@Resource(name = "HumanServerImpl")
	private HumanServer server; // 注入业务对象
	
	//返回第一机构的json对象
	public String getFiresClassList(){
		firstClassList=server.getFirstClass();
		return SUCCESS;
	}
	
	//返回第二机构的json对象，依赖第一机构id
	public String getSecondClassByFirstClass() {
		secondClassList= server.getSecondClassByFirstClass(firstId);
		return "secondClass";
	}
	
	//返回第三机构的json对象，依赖第二机构
	public String getThirdClassBySecondClass(){
		thirdClassList=server.getThirdClasBySecondClass(secondId);
		return "thirdClass";
	}
	
	
	//返回职称json对象
	public String getMajorClassify(){
		majorClassifyList=server.getMajorClassifyAll();
		return SUCCESS;
	}
	
	//根据type返回公共属列表
	public String getPublicAttMapByType(){
		/*publicAttMap=new HashMap<String, List<String>>();
		publicAttMap.put("jobTitle", server.getPublicAttNameByType("职称"));
		publicAttMap.put("hobby", server.getPublicAttNameByType("爱好"));
		publicAttMap.put("nationality", server.getPublicAttNameByType("国籍"));
		publicAttMap.put("nation", server.getPublicAttNameByType("民族"));
		publicAttMap.put("faith", server.getPublicAttNameByType("宗教信仰"));
		publicAttMap.put("politics", server.getPublicAttNameByType("政治面貌"));
		publicAttMap.put("degree", server.getPublicAttNameByType("学历"));
		publicAttMap.put("educationYears", server.getPublicAttNameByType("教育年限"));
		publicAttMap.put("major", server.getPublicAttNameByType("学历专业"));
		publicAttMap.put("strongPoint", server.getPublicAttNameByType("特长"));*/
		 
		attNames= server.getPublicAttNameByType(type);
		return SUCCESS;
	}
	//获得所有薪酬等级
	public String getTblStandardSalaryAll(){
		standardSalaryList=server.getTblStandardSalaryAll();
		return SUCCESS;
	}
	
	
	//根据职位分类id获取职位名称类
	public String getTblMajorNameByClassId(){
		majorNameList=server.getTblMajorNameByClassId(clazz);
		return SUCCESS;
	}
	
	//get set方法
	public void setFirstClassList(List<TblFirstClass> firstClassList) {
		this.firstClassList = firstClassList;
	}


	public List<TblSecondClass> getSecondClassList() {
		return secondClassList;
	}


	public void setSecondClassList(List<TblSecondClass> secondClassList) {
		this.secondClassList = secondClassList;
	}


	public int getFirstId() {
		return firstId;
	}


	public void setFirstId(int firstId) {
		this.firstId = firstId;
	}


	public List<TblFirstClass> getFirstClassList() {
		return firstClassList;
	}

	public List<TblThirdClass> getThirdClassList() {
		return thirdClassList;
	}

	public void setThirdClassList(List<TblThirdClass> thirdClassList) {
		this.thirdClassList = thirdClassList;
	}

	public int getSecondId() {
		return secondId;
	}

	public void setSecondId(int secondId) {
		this.secondId = secondId;
	}

	public List<TblMajorClassify> getMajorClassifyList() {
		return majorClassifyList;
	}

	public void setMajorClassifyList(List<TblMajorClassify> majorClassifyList) {
		this.majorClassifyList = majorClassifyList;
	}

	public List<String> getAttNames() {
		return attNames;
	}

	public void setAttNames(List<String> attNames) {
		this.attNames = attNames;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TblStandardSalary> getStandardSalaryList() {
		return standardSalaryList;
	}

	public void setStandardSalaryList(List<TblStandardSalary> standardSalaryList) {
		this.standardSalaryList = standardSalaryList;
	}

	public List<TblMajorName> getMajorNameList() {
		return majorNameList;
	}

	public void setMajorNameList(List<TblMajorName> majorNameList) {
		this.majorNameList = majorNameList;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
}
