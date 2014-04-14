package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblInterview entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_INTERVIEW", schema = "y01")
public class TblInterview implements java.io.Serializable {

	// Fields

	private Integer einId;
	private String humanName;
	private Integer interviewAmount;
	private String humanMajorKindId;
	private String humanMajorKindName;
	private String humanMajorId;
	private String humanMajorName;
	private String imageDegree;
	private String nativeLanguageDegree;
	private String foreignLanguageDegree;
	private String responseSpeedDegree;
	private String eqDegree;
	private String iqDegree;
	private String multiQualityDegree;
	private String register;
	private String checker;
	private String registerTime;
	private String checkTime;
	private Integer resumeId;
	private String result;
	private String interviewComment;
	private String checkComment;
	private Integer interviewStatus;
	private Integer checkStatus;

	// Constructors

	/** default constructor */
	public TblInterview() {
	}

	/** minimal constructor */
	public TblInterview(Integer einId) {
		this.einId = einId;
	}

	/** full constructor */
	public TblInterview(Integer einId, String humanName, Integer interviewAmount, String humanMajorKindId, String humanMajorKindName, String humanMajorId, String humanMajorName, String imageDegree, String nativeLanguageDegree, String foreignLanguageDegree, String responseSpeedDegree, String eqDegree, String iqDegree, String multiQualityDegree, String register, String checker, String registerTime, String checkTime, Integer resumeId, String result, String interviewComment, String checkComment, Integer interviewStatus, Integer checkStatus) {
		this.einId = einId;
		this.humanName = humanName;
		this.interviewAmount = interviewAmount;
		this.humanMajorKindId = humanMajorKindId;
		this.humanMajorKindName = humanMajorKindName;
		this.humanMajorId = humanMajorId;
		this.humanMajorName = humanMajorName;
		this.imageDegree = imageDegree;
		this.nativeLanguageDegree = nativeLanguageDegree;
		this.foreignLanguageDegree = foreignLanguageDegree;
		this.responseSpeedDegree = responseSpeedDegree;
		this.eqDegree = eqDegree;
		this.iqDegree = iqDegree;
		this.multiQualityDegree = multiQualityDegree;
		this.register = register;
		this.checker = checker;
		this.registerTime = registerTime;
		this.checkTime = checkTime;
		this.resumeId = resumeId;
		this.result = result;
		this.interviewComment = interviewComment;
		this.checkComment = checkComment;
		this.interviewStatus = interviewStatus;
		this.checkStatus = checkStatus;
	}

	// Property accessors
	@SequenceGenerator(name = "TblInterview",sequenceName="TblInterview_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblInterview")
	@Id
	@Column(name = "EIN_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getEinId() {
		return this.einId;
	}

	public void setEinId(Integer einId) {
		this.einId = einId;
	}

	@Column(name = "HUMAN_NAME", length = 60)
	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	@Column(name = "INTERVIEW_AMOUNT", precision = 5, scale = 0)
	public Integer getInterviewAmount() {
		return this.interviewAmount;
	}

	public void setInterviewAmount(Integer interviewAmount) {
		this.interviewAmount = interviewAmount;
	}

	@Column(name = "HUMAN_MAJOR_KIND_ID", length = 2)
	public String getHumanMajorKindId() {
		return this.humanMajorKindId;
	}

	public void setHumanMajorKindId(String humanMajorKindId) {
		this.humanMajorKindId = humanMajorKindId;
	}

	@Column(name = "HUMAN_MAJOR_KIND_NAME", length = 30)
	public String getHumanMajorKindName() {
		return this.humanMajorKindName;
	}

	public void setHumanMajorKindName(String humanMajorKindName) {
		this.humanMajorKindName = humanMajorKindName;
	}

	@Column(name = "HUMAN_MAJOR_ID", length = 2)
	public String getHumanMajorId() {
		return this.humanMajorId;
	}

	public void setHumanMajorId(String humanMajorId) {
		this.humanMajorId = humanMajorId;
	}

	@Column(name = "HUMAN_MAJOR_NAME", length = 30)
	public String getHumanMajorName() {
		return this.humanMajorName;
	}

	public void setHumanMajorName(String humanMajorName) {
		this.humanMajorName = humanMajorName;
	}

	@Column(name = "IMAGE_DEGREE", length = 20)
	public String getImageDegree() {
		return this.imageDegree;
	}

	public void setImageDegree(String imageDegree) {
		this.imageDegree = imageDegree;
	}

	@Column(name = "NATIVE_LANGUAGE_DEGREE", length = 20)
	public String getNativeLanguageDegree() {
		return this.nativeLanguageDegree;
	}

	public void setNativeLanguageDegree(String nativeLanguageDegree) {
		this.nativeLanguageDegree = nativeLanguageDegree;
	}

	@Column(name = "FOREIGN_LANGUAGE_DEGREE", length = 20)
	public String getForeignLanguageDegree() {
		return this.foreignLanguageDegree;
	}

	public void setForeignLanguageDegree(String foreignLanguageDegree) {
		this.foreignLanguageDegree = foreignLanguageDegree;
	}

	@Column(name = "RESPONSE_SPEED_DEGREE", length = 20)
	public String getResponseSpeedDegree() {
		return this.responseSpeedDegree;
	}

	public void setResponseSpeedDegree(String responseSpeedDegree) {
		this.responseSpeedDegree = responseSpeedDegree;
	}

	@Column(name = "EQ_DEGREE", length = 20)
	public String getEqDegree() {
		return this.eqDegree;
	}

	public void setEqDegree(String eqDegree) {
		this.eqDegree = eqDegree;
	}

	@Column(name = "IQ_DEGREE", length = 20)
	public String getIqDegree() {
		return this.iqDegree;
	}

	public void setIqDegree(String iqDegree) {
		this.iqDegree = iqDegree;
	}

	@Column(name = "MULTI_QUALITY_DEGREE", length = 20)
	public String getMultiQualityDegree() {
		return this.multiQualityDegree;
	}

	public void setMultiQualityDegree(String multiQualityDegree) {
		this.multiQualityDegree = multiQualityDegree;
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

	@Column(name = "REGISTER_TIME")
	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "CHECK_TIME")
	public String getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "RESUME_ID", precision = 5, scale = 0)
	public Integer getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	@Column(name = "RESULT", length = 20)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "INTERVIEW_COMMENT")
	public String getInterviewComment() {
		return this.interviewComment;
	}

	public void setInterviewComment(String interviewComment) {
		this.interviewComment = interviewComment;
	}

	@Column(name = "CHECK_COMMENT")
	public String getCheckComment() {
		return this.checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

	@Column(name = "INTERVIEW_STATUS", precision = 5, scale = 0)
	public Integer getInterviewStatus() {
		return this.interviewStatus;
	}

	public void setInterviewStatus(Integer interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	@Column(name = "CHECK_STATUS", precision = 5, scale = 0)
	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

}