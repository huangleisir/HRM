package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblResume entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_RESUME", schema = "y01")
public class TblResume implements java.io.Serializable {

	// Fields

	private Integer resId;
	private String humanName;
	private String engageType;
	private String humanAddress;
	private String humanPostcode;
	private String humanMajorKindId;
	private String humaMajorKindName;
	private String humanMajorId;
	private String humanMajorName;
	private String humanTelephone;
	private String humanHomephone;
	private String humanMobilephone;
	private String humanEmail;
	private String humanHobby;
	private String humanSpecility;
	private String humanSex;
	private String humanReligion;
	private String humanParty;
	private String humanNationality;
	private String humanRace;
	private String humanBirthday;
	private Integer humanAge;
	private String humanEducatedDegree;
	private Integer humanEducatedYears;
	private String humanEducatedMajor;
	private String humanCollege;
	private String humanIdcard;
	private String humanBirthplace;
	private Double demandSalaryStandard;
	private String humanHistoryRecords;
	private String remark;
	private String recomandation;
	private String humanPicture;
	private String attachmentName;
	private Integer checkStatus;
	private String register;
	private String registTime;
	private String checker;
	private String checkTime;
	private Integer interviewStatus;
	private Double totalPoints;
	private Integer testAmount;
	private String testChecker;
	private String testCheckTime;
	private String passRegister;
	private String passRegistTime;
	private String passChecker;
	private String passCheckTime;
	private Integer passCheckStatus;
	private String passCheckcomment;
	private String passPasscomment;

	// Constructors

	/** default constructor */
	public TblResume() {
	}

	/** minimal constructor */
	public TblResume(Integer resId) {
		this.resId = resId;
	}

	/** full constructor */
	public TblResume(Integer resId, String humanName, String engageType, String humanAddress, String humanPostcode, String humanMajorKindId, String humaMajorKindName, String humanMajorId, String humanMajorName, String humanTelephone, String humanHomephone, String humanMobilephone, String humanEmail, String humanHobby, String humanSpecility, String humanSex, String humanReligion, String humanParty, String humanNationality, String humanRace, String humanBirthday, Integer humanAge, String humanEducatedDegree, Integer humanEducatedYears, String humanEducatedMajor, String humanCollege, String humanIdcard, String humanBirthplace, Double demandSalaryStandard, String humanHistoryRecords, String remark, String recomandation, String humanPicture, String attachmentName, Integer checkStatus, String register, String registTime, String checker, String checkTime, Integer interviewStatus, Double totalPoints, Integer testAmount, String testChecker, String testCheckTime, String passRegister, String passRegistTime, String passChecker, String passCheckTime, Integer passCheckStatus, String passCheckcomment, String passPasscomment) {
		this.resId = resId;
		this.humanName = humanName;
		this.engageType = engageType;
		this.humanAddress = humanAddress;
		this.humanPostcode = humanPostcode;
		this.humanMajorKindId = humanMajorKindId;
		this.humaMajorKindName = humaMajorKindName;
		this.humanMajorId = humanMajorId;
		this.humanMajorName = humanMajorName;
		this.humanTelephone = humanTelephone;
		this.humanHomephone = humanHomephone;
		this.humanMobilephone = humanMobilephone;
		this.humanEmail = humanEmail;
		this.humanHobby = humanHobby;
		this.humanSpecility = humanSpecility;
		this.humanSex = humanSex;
		this.humanReligion = humanReligion;
		this.humanParty = humanParty;
		this.humanNationality = humanNationality;
		this.humanRace = humanRace;
		this.humanBirthday = humanBirthday;
		this.humanAge = humanAge;
		this.humanEducatedDegree = humanEducatedDegree;
		this.humanEducatedYears = humanEducatedYears;
		this.humanEducatedMajor = humanEducatedMajor;
		this.humanCollege = humanCollege;
		this.humanIdcard = humanIdcard;
		this.humanBirthplace = humanBirthplace;
		this.demandSalaryStandard = demandSalaryStandard;
		this.humanHistoryRecords = humanHistoryRecords;
		this.remark = remark;
		this.recomandation = recomandation;
		this.humanPicture = humanPicture;
		this.attachmentName = attachmentName;
		this.checkStatus = checkStatus;
		this.register = register;
		this.registTime = registTime;
		this.checker = checker;
		this.checkTime = checkTime;
		this.interviewStatus = interviewStatus;
		this.totalPoints = totalPoints;
		this.testAmount = testAmount;
		this.testChecker = testChecker;
		this.testCheckTime = testCheckTime;
		this.passRegister = passRegister;
		this.passRegistTime = passRegistTime;
		this.passChecker = passChecker;
		this.passCheckTime = passCheckTime;
		this.passCheckStatus = passCheckStatus;
		this.passCheckcomment = passCheckcomment;
		this.passPasscomment = passPasscomment;
	}

	// Property accessors
	@SequenceGenerator(name = "TblResume",sequenceName="TblResume_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblResume")
	@Id
	@Column(name = "RES_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getResId() {
		return this.resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	@Column(name = "HUMAN_NAME", length = 60)
	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	@Column(name = "ENGAGE_TYPE", length = 30)
	public String getEngageType() {
		return this.engageType;
	}

	public void setEngageType(String engageType) {
		this.engageType = engageType;
	}

	@Column(name = "HUMAN_ADDRESS", length = 200)
	public String getHumanAddress() {
		return this.humanAddress;
	}

	public void setHumanAddress(String humanAddress) {
		this.humanAddress = humanAddress;
	}

	@Column(name = "HUMAN_POSTCODE", length = 10)
	public String getHumanPostcode() {
		return this.humanPostcode;
	}

	public void setHumanPostcode(String humanPostcode) {
		this.humanPostcode = humanPostcode;
	}

	@Column(name = "HUMAN_MAJOR_KIND_ID", length = 2)
	public String getHumanMajorKindId() {
		return this.humanMajorKindId;
	}

	public void setHumanMajorKindId(String humanMajorKindId) {
		this.humanMajorKindId = humanMajorKindId;
	}

	@Column(name = "HUMA_MAJOR_KIND_NAME", length = 60)
	public String getHumaMajorKindName() {
		return this.humaMajorKindName;
	}

	public void setHumaMajorKindName(String humaMajorKindName) {
		this.humaMajorKindName = humaMajorKindName;
	}

	@Column(name = "HUMAN_MAJOR_ID", length = 2)
	public String getHumanMajorId() {
		return this.humanMajorId;
	}

	public void setHumanMajorId(String humanMajorId) {
		this.humanMajorId = humanMajorId;
	}

	@Column(name = "HUMAN_MAJOR_NAME", length = 60)
	public String getHumanMajorName() {
		return this.humanMajorName;
	}

	public void setHumanMajorName(String humanMajorName) {
		this.humanMajorName = humanMajorName;
	}

	@Column(name = "HUMAN_TELEPHONE", length = 60)
	public String getHumanTelephone() {
		return this.humanTelephone;
	}

	public void setHumanTelephone(String humanTelephone) {
		this.humanTelephone = humanTelephone;
	}

	@Column(name = "HUMAN_HOMEPHONE", length = 60)
	public String getHumanHomephone() {
		return this.humanHomephone;
	}

	public void setHumanHomephone(String humanHomephone) {
		this.humanHomephone = humanHomephone;
	}

	@Column(name = "HUMAN_MOBILEPHONE", length = 60)
	public String getHumanMobilephone() {
		return this.humanMobilephone;
	}

	public void setHumanMobilephone(String humanMobilephone) {
		this.humanMobilephone = humanMobilephone;
	}

	@Column(name = "HUMAN_EMAIL", length = 60)
	public String getHumanEmail() {
		return this.humanEmail;
	}

	public void setHumanEmail(String humanEmail) {
		this.humanEmail = humanEmail;
	}

	@Column(name = "HUMAN_HOBBY", length = 60)
	public String getHumanHobby() {
		return this.humanHobby;
	}

	public void setHumanHobby(String humanHobby) {
		this.humanHobby = humanHobby;
	}

	@Column(name = "HUMAN_SPECILITY", length = 60)
	public String getHumanSpecility() {
		return this.humanSpecility;
	}

	public void setHumanSpecility(String humanSpecility) {
		this.humanSpecility = humanSpecility;
	}

	@Column(name = "HUMAN_SEX", length = 2)
	public String getHumanSex() {
		return this.humanSex;
	}

	public void setHumanSex(String humanSex) {
		this.humanSex = humanSex;
	}

	@Column(name = "HUMAN_RELIGION", length = 60)
	public String getHumanReligion() {
		return this.humanReligion;
	}

	public void setHumanReligion(String humanReligion) {
		this.humanReligion = humanReligion;
	}

	@Column(name = "HUMAN_PARTY", length = 60)
	public String getHumanParty() {
		return this.humanParty;
	}

	public void setHumanParty(String humanParty) {
		this.humanParty = humanParty;
	}

	@Column(name = "HUMAN_NATIONALITY", length = 60)
	public String getHumanNationality() {
		return this.humanNationality;
	}

	public void setHumanNationality(String humanNationality) {
		this.humanNationality = humanNationality;
	}

	@Column(name = "HUMAN_RACE", length = 60)
	public String getHumanRace() {
		return this.humanRace;
	}

	public void setHumanRace(String humanRace) {
		this.humanRace = humanRace;
	}

	@Column(name = "HUMAN_BIRTHDAY")
	public String getHumanBirthday() {
		return this.humanBirthday;
	}

	public void setHumanBirthday(String humanBirthday) {
		this.humanBirthday = humanBirthday;
	}

	@Column(name = "HUMAN_AGE", precision = 5, scale = 0)
	public Integer getHumanAge() {
		return this.humanAge;
	}

	public void setHumanAge(Integer humanAge) {
		this.humanAge = humanAge;
	}

	@Column(name = "HUMAN_EDUCATED_DEGREE", length = 60)
	public String getHumanEducatedDegree() {
		return this.humanEducatedDegree;
	}

	public void setHumanEducatedDegree(String humanEducatedDegree) {
		this.humanEducatedDegree = humanEducatedDegree;
	}

	@Column(name = "HUMAN_EDUCATED_YEARS", precision = 5, scale = 0)
	public Integer getHumanEducatedYears() {
		return this.humanEducatedYears;
	}

	public void setHumanEducatedYears(Integer humanEducatedYears) {
		this.humanEducatedYears = humanEducatedYears;
	}

	@Column(name = "HUMAN_EDUCATED_MAJOR", length = 60)
	public String getHumanEducatedMajor() {
		return this.humanEducatedMajor;
	}

	public void setHumanEducatedMajor(String humanEducatedMajor) {
		this.humanEducatedMajor = humanEducatedMajor;
	}

	@Column(name = "HUMAN_COLLEGE", length = 60)
	public String getHumanCollege() {
		return this.humanCollege;
	}

	public void setHumanCollege(String humanCollege) {
		this.humanCollege = humanCollege;
	}

	@Column(name = "HUMAN_IDCARD", length = 60)
	public String getHumanIdcard() {
		return this.humanIdcard;
	}

	public void setHumanIdcard(String humanIdcard) {
		this.humanIdcard = humanIdcard;
	}

	@Column(name = "HUMAN_BIRTHPLACE", length = 200)
	public String getHumanBirthplace() {
		return this.humanBirthplace;
	}

	public void setHumanBirthplace(String humanBirthplace) {
		this.humanBirthplace = humanBirthplace;
	}

	@Column(name = "DEMAND_SALARY_STANDARD", precision = 8)
	public Double getDemandSalaryStandard() {
		return this.demandSalaryStandard;
	}

	public void setDemandSalaryStandard(Double demandSalaryStandard) {
		this.demandSalaryStandard = demandSalaryStandard;
	}

	@Column(name = "HUMAN_HISTORY_RECORDS")
	public String getHumanHistoryRecords() {
		return this.humanHistoryRecords;
	}

	public void setHumanHistoryRecords(String humanHistoryRecords) {
		this.humanHistoryRecords = humanHistoryRecords;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECOMANDATION")
	public String getRecomandation() {
		return this.recomandation;
	}

	public void setRecomandation(String recomandation) {
		this.recomandation = recomandation;
	}

	@Column(name = "HUMAN_PICTURE", length = 60)
	public String getHumanPicture() {
		return this.humanPicture;
	}

	public void setHumanPicture(String humanPicture) {
		this.humanPicture = humanPicture;
	}

	@Column(name = "ATTACHMENT_NAME", length = 60)
	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	@Column(name = "CHECK_STATUS", precision = 5, scale = 0)
	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Column(name = "REGISTER", length = 60)
	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	@Column(name = "REGIST_TIME")
	public String getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	@Column(name = "CHECKER", length = 60)
	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	@Column(name = "CHECK_TIME")
	public String getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "INTERVIEW_STATUS", precision = 5, scale = 0)
	public Integer getInterviewStatus() {
		return this.interviewStatus;
	}

	public void setInterviewStatus(Integer interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	@Column(name = "TOTAL_POINTS", precision = 5)
	public Double getTotalPoints() {
		return this.totalPoints;
	}

	public void setTotalPoints(Double totalPoints) {
		this.totalPoints = totalPoints;
	}

	@Column(name = "TEST_AMOUNT", precision = 5, scale = 0)
	public Integer getTestAmount() {
		return this.testAmount;
	}

	public void setTestAmount(Integer testAmount) {
		this.testAmount = testAmount;
	}

	@Column(name = "TEST_CHECKER", length = 60)
	public String getTestChecker() {
		return this.testChecker;
	}

	public void setTestChecker(String testChecker) {
		this.testChecker = testChecker;
	}

	@Column(name = "TEST_CHECK_TIME")
	public String getTestCheckTime() {
		return this.testCheckTime;
	}

	public void setTestCheckTime(String testCheckTime) {
		this.testCheckTime = testCheckTime;
	}

	@Column(name = "PASS_REGISTER", length = 60)
	public String getPassRegister() {
		return this.passRegister;
	}

	public void setPassRegister(String passRegister) {
		this.passRegister = passRegister;
	}

	@Column(name = "PASS_REGIST_TIME")
	public String getPassRegistTime() {
		return this.passRegistTime;
	}

	public void setPassRegistTime(String passRegistTime) {
		this.passRegistTime = passRegistTime;
	}

	@Column(name = "PASS_CHECKER", length = 60)
	public String getPassChecker() {
		return this.passChecker;
	}

	public void setPassChecker(String passChecker) {
		this.passChecker = passChecker;
	}

	@Column(name = "PASS_CHECK_TIME")
	public String getPassCheckTime() {
		return this.passCheckTime;
	}

	public void setPassCheckTime(String passCheckTime) {
		this.passCheckTime = passCheckTime;
	}

	@Column(name = "PASS_CHECK_STATUS", precision = 5, scale = 0)
	public Integer getPassCheckStatus() {
		return this.passCheckStatus;
	}

	public void setPassCheckStatus(Integer passCheckStatus) {
		this.passCheckStatus = passCheckStatus;
	}

	@Column(name = "PASS_CHECKCOMMENT", length = 60)
	public String getPassCheckcomment() {
		return this.passCheckcomment;
	}

	public void setPassCheckcomment(String passCheckcomment) {
		this.passCheckcomment = passCheckcomment;
	}

	@Column(name = "PASS_PASSCOMMENT", length = 60)
	public String getPassPasscomment() {
		return this.passPasscomment;
	}

	public void setPassPasscomment(String passPasscomment) {
		this.passPasscomment = passPasscomment;
	}

}