package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblStandardSalary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_STANDARD_SALARY", schema = "y01")
public class TblStandardSalary implements java.io.Serializable {

	// Fields

	private Integer ssdId;
	private String standardId;
	private String standardName;
	private String designer;
	private String register;
	private String checker;
	private String changer;
	private String registTime;
	private String checkTime;
	private String changeTime;
	private Double salarySum;
	private Integer checkStatus;
	private Integer changeStatus;
	private String checkCommnet;
	private String remark;

	// Constructors

	/** default constructor */
	public TblStandardSalary() {
	}

	/** minimal constructor */
	public TblStandardSalary(Integer ssdId) {
		this.ssdId = ssdId;
	}

	/** full constructor */
	public TblStandardSalary(Integer ssdId, String standardId, String standardName, String designer, String register, String checker, String changer, String registTime, String checkTime, String changeTime, Double salarySum, Integer checkStatus, Integer changeStatus, String checkCommnet, String remark) {
		this.ssdId = ssdId;
		this.standardId = standardId;
		this.standardName = standardName;
		this.designer = designer;
		this.register = register;
		this.checker = checker;
		this.changer = changer;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.changeTime = changeTime;
		this.salarySum = salarySum;
		this.checkStatus = checkStatus;
		this.changeStatus = changeStatus;
		this.checkCommnet = checkCommnet;
		this.remark = remark;
	}

	// Property accessors
	@SequenceGenerator(name = "TblStandardSalary",sequenceName="TblStandardSalary_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblStandardSalary")
	@Id
	@Column(name = "SSD_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getSsdId() {
		return this.ssdId;
	}

	public void setSsdId(Integer ssdId) {
		this.ssdId = ssdId;
	}

	@Column(name = "STANDARD_ID", length = 30)
	public String getStandardId() {
		return this.standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	@Column(name = "STANDARD_NAME", length = 60)
	public String getStandardName() {
		return this.standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	@Column(name = "DESIGNER", length = 60)
	public String getDesigner() {
		return this.designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	@Column(name = "REGISTER", length = 60)
	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	@Column(name = "CHECKER", length = 60)
	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	@Column(name = "CHANGER", length = 60)
	public String getChanger() {
		return this.changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}

	@Column(name = "REGIST_TIME")
	public String getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	@Column(name = "CHECK_TIME")
	public String getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "CHANGE_TIME")
	public String getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "SALARY_SUM", precision = 8)
	public Double getSalarySum() {
		return this.salarySum;
	}

	public void setSalarySum(Double salarySum) {
		this.salarySum = salarySum;
	}

	@Column(name = "CHECK_STATUS", precision = 5, scale = 0)
	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Column(name = "CHANGE_STATUS", precision = 5, scale = 0)
	public Integer getChangeStatus() {
		return this.changeStatus;
	}

	public void setChangeStatus(Integer changeStatus) {
		this.changeStatus = changeStatus;
	}

	@Column(name = "CHECK_COMMNET")
	public String getCheckCommnet() {
		return this.checkCommnet;
	}

	public void setCheckCommnet(String checkCommnet) {
		this.checkCommnet = checkCommnet;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}