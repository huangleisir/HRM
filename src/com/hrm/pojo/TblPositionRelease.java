package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblPositionRelease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_POSITION_RELEASE", schema = "y01")
public class TblPositionRelease implements java.io.Serializable {

	// Fields

	private Integer maeId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private Integer humanAmount;
	private String engageType;
	private String deadline;
	private String register;
	private String changer;
	private String registTime;
	private String changeTime;
	private String majorDescribe;
	private String engageRequired;

	// Constructors

	/** default constructor */
	public TblPositionRelease() {
	}

	/** minimal constructor */
	public TblPositionRelease(Integer maeId) {
		this.maeId = maeId;
	}

	/** full constructor */
	public TblPositionRelease(Integer maeId, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, String majorKindId, String majorKindName, String majorId, String majorName, Integer humanAmount, String engageType, String deadline, String register, String changer, String registTime, String changeTime, String majorDescribe, String engageRequired) {
		this.maeId = maeId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.humanAmount = humanAmount;
		this.engageType = engageType;
		this.deadline = deadline;
		this.register = register;
		this.changer = changer;
		this.registTime = registTime;
		this.changeTime = changeTime;
		this.majorDescribe = majorDescribe;
		this.engageRequired = engageRequired;
	}

	// Property accessors
	@SequenceGenerator(name = "TblPositionRelease",sequenceName="TblPositionRelease_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblPositionRelease")
	@Id
	@Column(name = "MAE_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getMaeId() {
		return this.maeId;
	}

	public void setMaeId(Integer maeId) {
		this.maeId = maeId;
	}

	@Column(name = "FIRST_KIND_ID", length = 2)
	public String getFirstKindId() {
		return this.firstKindId;
	}

	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}

	@Column(name = "FIRST_KIND_NAME", length = 60)
	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	@Column(name = "SECOND_KIND_ID", length = 2)
	public String getSecondKindId() {
		return this.secondKindId;
	}

	public void setSecondKindId(String secondKindId) {
		this.secondKindId = secondKindId;
	}

	@Column(name = "SECOND_KIND_NAME", length = 60)
	public String getSecondKindName() {
		return this.secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	@Column(name = "THIRD_KIND_ID", length = 2)
	public String getThirdKindId() {
		return this.thirdKindId;
	}

	public void setThirdKindId(String thirdKindId) {
		this.thirdKindId = thirdKindId;
	}

	@Column(name = "THIRD_KIND_NAME", length = 60)
	public String getThirdKindName() {
		return this.thirdKindName;
	}

	public void setThirdKindName(String thirdKindName) {
		this.thirdKindName = thirdKindName;
	}

	@Column(name = "MAJOR_KIND_ID", length = 2)
	public String getMajorKindId() {
		return this.majorKindId;
	}

	public void setMajorKindId(String majorKindId) {
		this.majorKindId = majorKindId;
	}

	@Column(name = "MAJOR_KIND_NAME", length = 60)
	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	@Column(name = "MAJOR_ID", length = 2)
	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	@Column(name = "MAJOR_NAME", length = 60)
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column(name = "HUMAN_AMOUNT", precision = 5, scale = 0)
	public Integer getHumanAmount() {
		return this.humanAmount;
	}

	public void setHumanAmount(Integer humanAmount) {
		this.humanAmount = humanAmount;
	}

	@Column(name = "ENGAGE_TYPE", length = 60)
	public String getEngageType() {
		return this.engageType;
	}

	public void setEngageType(String engageType) {
		this.engageType = engageType;
	}

	@Column(name = "DEADLINE")
	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Column(name = "REGISTER", length = 60)
	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
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

	@Column(name = "CHANGE_TIME")
	public String getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "MAJOR_DESCRIBE")
	public String getMajorDescribe() {
		return this.majorDescribe;
	}

	public void setMajorDescribe(String majorDescribe) {
		this.majorDescribe = majorDescribe;
	}

	@Column(name = "ENGAGE_REQUIRED")
	public String getEngageRequired() {
		return this.engageRequired;
	}

	public void setEngageRequired(String engageRequired) {
		this.engageRequired = engageRequired;
	}

}