package com.hrm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblHuman entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_HUMAN", schema = "y01")
public class TblHuman implements java.io.Serializable {

	// Fields

	private Integer hufId;
	private String humanId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String humanName;
	private String humanAddress;
	private String humanPostcode;
	private String humanProDesignation;
	private String humanMajorKindId;
	private String humanMajorKindName;
	private String humanMajorId;
	private String humanMajorName;
	private String humanTelephone;
	private String humanMobilephone;
	private String humanBank;
	private String humanAccount;
	private String humanQq;
	private String humanEmail;
	private String humanHobby;
	private String humanSpeciality;
	private Byte humanSex;
	private String humanReligion;
	private String humanParty;
	private String humanNationality;
	private String humanRace;
	private String humanBirthday;
	private String humanBirthplace;
	private Integer humanAge;
	private String humanEducatedDegree;
	private Integer humanEducatedYears;
	private String humanEducatedMajor;
	private String humanSocietySecurityId;
	private String humanIdCard;
	private String remark;
	private String salaryStandardId;
	private String salaryStandardName;
	private Double salarySum;
	private Double demandSalaraySum;
	private Double paidSalarySum;
	private Integer majorChangeAmount;
	private Integer bonusAmount;
	private Integer trainingAmount;
	private Integer fileChangAmount;
	private String humanHistroyRecords;
	private String humanFamilyMembership;
	private String humanPicture;
	private String attachmentName;
	private Integer checkStatus;
	private String register;
	private String checker;
	private String changer;
	private String registTime;
	private String checkTime;
	private String changeTime;
	private String lastlyChangeTime;
	private String deleteTime;
	private String recoveryTime;
	private Short humanFileStatus;

	// Constructors

	/** default constructor */
	public TblHuman() {
	}

	/** full constructor */
	public TblHuman(String humanId, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, String humanName, String humanAddress, String humanPostcode, String humanProDesignation, String humanMajorKindId, String humanMajorKindName, String humanMajorId, String humanMajorName, String humanTelephone, String humanMobilephone, String humanBank, String humanAccount, String humanQq, String humanEmail, String humanHobby, String humanSpeciality, Byte humanSex, String humanReligion, String humanParty, String humanNationality, String humanRace, String humanBirthday, String humanBirthplace, Integer humanAge, String humanEducatedDegree, Integer humanEducatedYears, String humanEducatedMajor, String humanSocietySecurityId, String humanIdCard, String remark, String salaryStandardId, String salaryStandardName, Double salarySum, Double demandSalaraySum, Double paidSalarySum, Integer majorChangeAmount, Integer bonusAmount, Integer trainingAmount, Integer fileChangAmount, String humanHistroyRecords, String humanFamilyMembership, String humanPicture, String attachmentName, Integer checkStatus, String register, String checker, String changer, String registTime, String checkTime, String changeTime, String lastlyChangeTime, String deleteTime, String recoveryTime, Short humanFileStatus) {
		this.humanId = humanId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.humanName = humanName;
		this.humanAddress = humanAddress;
		this.humanPostcode = humanPostcode;
		this.humanProDesignation = humanProDesignation;
		this.humanMajorKindId = humanMajorKindId;
		this.humanMajorKindName = humanMajorKindName;
		this.humanMajorId = humanMajorId;
		this.humanMajorName = humanMajorName;
		this.humanTelephone = humanTelephone;
		this.humanMobilephone = humanMobilephone;
		this.humanBank = humanBank;
		this.humanAccount = humanAccount;
		this.humanQq = humanQq;
		this.humanEmail = humanEmail;
		this.humanHobby = humanHobby;
		this.humanSpeciality = humanSpeciality;
		this.humanSex = humanSex;
		this.humanReligion = humanReligion;
		this.humanParty = humanParty;
		this.humanNationality = humanNationality;
		this.humanRace = humanRace;
		this.humanBirthday = humanBirthday;
		this.humanBirthplace = humanBirthplace;
		this.humanAge = humanAge;
		this.humanEducatedDegree = humanEducatedDegree;
		this.humanEducatedYears = humanEducatedYears;
		this.humanEducatedMajor = humanEducatedMajor;
		this.humanSocietySecurityId = humanSocietySecurityId;
		this.humanIdCard = humanIdCard;
		this.remark = remark;
		this.salaryStandardId = salaryStandardId;
		this.salaryStandardName = salaryStandardName;
		this.salarySum = salarySum;
		this.demandSalaraySum = demandSalaraySum;
		this.paidSalarySum = paidSalarySum;
		this.majorChangeAmount = majorChangeAmount;
		this.bonusAmount = bonusAmount;
		this.trainingAmount = trainingAmount;
		this.fileChangAmount = fileChangAmount;
		this.humanHistroyRecords = humanHistroyRecords;
		this.humanFamilyMembership = humanFamilyMembership;
		this.humanPicture = humanPicture;
		this.attachmentName = attachmentName;
		this.checkStatus = checkStatus;
		this.register = register;
		this.checker = checker;
		this.changer = changer;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.changeTime = changeTime;
		this.lastlyChangeTime = lastlyChangeTime;
		this.deleteTime = deleteTime;
		this.recoveryTime = recoveryTime;
		this.humanFileStatus = humanFileStatus;
	}

	// Property accessors
	@SequenceGenerator(name = "TblHuman",sequenceName="TblHuman_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblHuman")
	@Id
	@Column(name = "HUF_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getHufId() {
		return this.hufId;
	}

	public void setHufId(Integer hufId) {
		this.hufId = hufId;
	}

	@Column(name = "HUMAN_ID", length = 30)
	public String getHumanId() {
		return this.humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
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

	@Column(name = "HUMAN_NAME", length = 60)
	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
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

	@Column(name = "HUMAN_PRO_DESIGNATION", length = 60)
	public String getHumanProDesignation() {
		return this.humanProDesignation;
	}

	public void setHumanProDesignation(String humanProDesignation) {
		this.humanProDesignation = humanProDesignation;
	}

	@Column(name = "HUMAN_MAJOR_KIND_ID", length = 2)
	public String getHumanMajorKindId() {
		return this.humanMajorKindId;
	}

	public void setHumanMajorKindId(String humanMajorKindId) {
		this.humanMajorKindId = humanMajorKindId;
	}

	@Column(name = "HUMAN_MAJOR_KIND_NAME", length = 60)
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

	@Column(name = "HUMAN_MAJOR_NAME", length = 60)
	public String getHumanMajorName() {
		return this.humanMajorName;
	}

	public void setHumanMajorName(String humanMajorName) {
		this.humanMajorName = humanMajorName;
	}

	@Column(name = "HUMAN_TELEPHONE", length = 20)
	public String getHumanTelephone() {
		return this.humanTelephone;
	}

	public void setHumanTelephone(String humanTelephone) {
		this.humanTelephone = humanTelephone;
	}

	@Column(name = "HUMAN_MOBILEPHONE", length = 11)
	public String getHumanMobilephone() {
		return this.humanMobilephone;
	}

	public void setHumanMobilephone(String humanMobilephone) {
		this.humanMobilephone = humanMobilephone;
	}

	@Column(name = "HUMAN_BANK", length = 50)
	public String getHumanBank() {
		return this.humanBank;
	}

	public void setHumanBank(String humanBank) {
		this.humanBank = humanBank;
	}

	@Column(name = "HUMAN_ACCOUNT", length = 50)
	public String getHumanAccount() {
		return this.humanAccount;
	}

	public void setHumanAccount(String humanAccount) {
		this.humanAccount = humanAccount;
	}

	@Column(name = "HUMAN_QQ", length = 15)
	public String getHumanQq() {
		return this.humanQq;
	}

	public void setHumanQq(String humanQq) {
		this.humanQq = humanQq;
	}

	@Column(name = "HUMAN_EMAIL", length = 50)
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

	@Column(name = "HUMAN_SPECIALITY", length = 60)
	public String getHumanSpeciality() {
		return this.humanSpeciality;
	}

	public void setHumanSpeciality(String humanSpeciality) {
		this.humanSpeciality = humanSpeciality;
	}

	@Column(name = "HUMAN_SEX", precision = 2, scale = 0)
	public Byte getHumanSex() {
		return this.humanSex;
	}

	public void setHumanSex(Byte humanSex) {
		this.humanSex = humanSex;
	}

	@Column(name = "HUMAN_RELIGION", length = 50)
	public String getHumanReligion() {
		return this.humanReligion;
	}

	public void setHumanReligion(String humanReligion) {
		this.humanReligion = humanReligion;
	}

	@Column(name = "HUMAN_PARTY", length = 50)
	public String getHumanParty() {
		return this.humanParty;
	}

	public void setHumanParty(String humanParty) {
		this.humanParty = humanParty;
	}

	@Column(name = "HUMAN_NATIONALITY", length = 50)
	public String getHumanNationality() {
		return this.humanNationality;
	}

	public void setHumanNationality(String humanNationality) {
		this.humanNationality = humanNationality;
	}

	@Column(name = "HUMAN_RACE", length = 50)
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

	@Column(name = "HUMAN_BIRTHPLACE", length = 50)
	public String getHumanBirthplace() {
		return this.humanBirthplace;
	}

	public void setHumanBirthplace(String humanBirthplace) {
		this.humanBirthplace = humanBirthplace;
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

	@Column(name = "HUMAN_SOCIETY_SECURITY_ID", length = 30)
	public String getHumanSocietySecurityId() {
		return this.humanSocietySecurityId;
	}

	public void setHumanSocietySecurityId(String humanSocietySecurityId) {
		this.humanSocietySecurityId = humanSocietySecurityId;
	}

	@Column(name = "HUMAN_ID_CARD", length = 20)
	public String getHumanIdCard() {
		return this.humanIdCard;
	}

	public void setHumanIdCard(String humanIdCard) {
		this.humanIdCard = humanIdCard;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SALARY_STANDARD_ID", length = 30)
	public String getSalaryStandardId() {
		return this.salaryStandardId;
	}

	public void setSalaryStandardId(String salaryStandardId) {
		this.salaryStandardId = salaryStandardId;
	}

	@Column(name = "SALARY_STANDARD_NAME", length = 60)
	public String getSalaryStandardName() {
		return this.salaryStandardName;
	}

	public void setSalaryStandardName(String salaryStandardName) {
		this.salaryStandardName = salaryStandardName;
	}

	@Column(name = "SALARY_SUM", precision = 8)
	public Double getSalarySum() {
		return this.salarySum;
	}

	public void setSalarySum(Double salarySum) {
		this.salarySum = salarySum;
	}

	@Column(name = "DEMAND_SALARAY_SUM", precision = 8)
	public Double getDemandSalaraySum() {
		return this.demandSalaraySum;
	}

	public void setDemandSalaraySum(Double demandSalaraySum) {
		this.demandSalaraySum = demandSalaraySum;
	}

	@Column(name = "PAID_SALARY_SUM", precision = 8)
	public Double getPaidSalarySum() {
		return this.paidSalarySum;
	}

	public void setPaidSalarySum(Double paidSalarySum) {
		this.paidSalarySum = paidSalarySum;
	}

	@Column(name = "MAJOR_CHANGE_AMOUNT", precision = 5, scale = 0)
	public Integer getMajorChangeAmount() {
		return this.majorChangeAmount;
	}

	public void setMajorChangeAmount(Integer majorChangeAmount) {
		this.majorChangeAmount = majorChangeAmount;
	}

	@Column(name = "BONUS_AMOUNT", precision = 5, scale = 0)
	public Integer getBonusAmount() {
		return this.bonusAmount;
	}

	public void setBonusAmount(Integer bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	@Column(name = "TRAINING_AMOUNT", precision = 5, scale = 0)
	public Integer getTrainingAmount() {
		return this.trainingAmount;
	}

	public void setTrainingAmount(Integer trainingAmount) {
		this.trainingAmount = trainingAmount;
	}

	@Column(name = "FILE_CHANG_AMOUNT", precision = 5, scale = 0)
	public Integer getFileChangAmount() {
		return this.fileChangAmount;
	}

	public void setFileChangAmount(Integer fileChangAmount) {
		this.fileChangAmount = fileChangAmount;
	}

	@Column(name = "HUMAN_HISTROY_RECORDS")
	public String getHumanHistroyRecords() {
		return this.humanHistroyRecords;
	}

	public void setHumanHistroyRecords(String humanHistroyRecords) {
		this.humanHistroyRecords = humanHistroyRecords;
	}

	@Column(name = "HUMAN_FAMILY_MEMBERSHIP")
	public String getHumanFamilyMembership() {
		return this.humanFamilyMembership;
	}

	public void setHumanFamilyMembership(String humanFamilyMembership) {
		this.humanFamilyMembership = humanFamilyMembership;
	}

	@Column(name = "HUMAN_PICTURE")
	public String getHumanPicture() {
		return this.humanPicture;
	}

	public void setHumanPicture(String humanPicture) {
		this.humanPicture = humanPicture;
	}

	@Column(name = "ATTACHMENT_NAME")
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

	@Column(name = "LASTLY_CHANGE_TIME")
	public String getLastlyChangeTime() {
		return this.lastlyChangeTime;
	}

	public void setLastlyChangeTime(String lastlyChangeTime) {
		this.lastlyChangeTime = lastlyChangeTime;
	}

	@Column(name = "DELETE_TIME")
	public String getDeleteTime() {
		return this.deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Column(name = "RECOVERY_TIME")
	public String getRecoveryTime() {
		return this.recoveryTime;
	}

	public void setRecoveryTime(String recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	@Column(name = "HUMAN_FILE_STATUS", precision = 3, scale = 0)
	public Short getHumanFileStatus() {
		return this.humanFileStatus;
	}

	public void setHumanFileStatus(Short humanFileStatus) {
		this.humanFileStatus = humanFileStatus;
	}

}