package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblHumanDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_HUMAN_DETAIL", schema = "y01")
public class TblHumanDetail implements java.io.Serializable {

	// Fields

	private Integer hfdId;
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
	private String humanSex;
	private String humanReligion;
	private String humanParty;
	private String humanNationality;
	private String humanRace;
	private String humanBirthday;
	private String humanBirthplace;
	private Integer humanAge;
	private String humanEducatedDegree;

	// Constructors

	/** default constructor */
	public TblHumanDetail() {
	}

	/** minimal constructor */
	public TblHumanDetail(Integer hfdId) {
		this.hfdId = hfdId;
	}

	/** full constructor */
	public TblHumanDetail(Integer hfdId, String humanId, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, String humanName, String humanAddress, String humanPostcode, String humanProDesignation, String humanMajorKindId, String humanMajorKindName, String humanMajorId, String humanMajorName, String humanTelephone, String humanMobilephone, String humanBank, String humanAccount, String humanQq, String humanEmail, String humanHobby, String humanSpeciality, String humanSex, String humanReligion, String humanParty, String humanNationality, String humanRace, String humanBirthday, String humanBirthplace, Integer humanAge, String humanEducatedDegree) {
		this.hfdId = hfdId;
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
	}

	// Property accessors
	@SequenceGenerator(name = "TblHumanDetail",sequenceName="TblHumanDetail_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblHumanDetail")
	@Id
	@Column(name = "HFD_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getHfdId() {
		return this.hfdId;
	}

	public void setHfdId(Integer hfdId) {
		this.hfdId = hfdId;
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

	@Column(name = "HUMAN_ACCOUNT", length = 30)
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

	@Column(name = "HUMAN_SEX", length = 2)
	public String getHumanSex() {
		return this.humanSex;
	}

	public void setHumanSex(String humanSex) {
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

}