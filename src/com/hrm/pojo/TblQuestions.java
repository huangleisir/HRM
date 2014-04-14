package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblQuestions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_QUESTIONS", schema = "y01")
public class TblQuestions implements java.io.Serializable {

	// Fields

	private Integer subId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String register;
	private String registTime;
	private String derivation;
	private String content;
	private String keyA;
	private String keyB;
	private String keyC;
	private String keyD;
	private String keyE;
	private String correctKey;
	private String changer;
	private String changeTime;

	// Constructors

	/** default constructor */
	public TblQuestions() {
	}

	/** minimal constructor */
	public TblQuestions(Integer subId) {
		this.subId = subId;
	}

	/** full constructor */
	public TblQuestions(Integer subId, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String register, String registTime, String derivation, String content, String keyA, String keyB, String keyC, String keyD, String keyE, String correctKey, String changer, String changeTime) {
		this.subId = subId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.register = register;
		this.registTime = registTime;
		this.derivation = derivation;
		this.content = content;
		this.keyA = keyA;
		this.keyB = keyB;
		this.keyC = keyC;
		this.keyD = keyD;
		this.keyE = keyE;
		this.correctKey = correctKey;
		this.changer = changer;
		this.changeTime = changeTime;
	}

	// Property accessors
	@SequenceGenerator(name = "TblQuestions",sequenceName="TblQuestions_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblQuestions")
	@Id
	@Column(name = "SUB_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getSubId() {
		return this.subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
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

	@Column(name = "DERIVATION", length = 60)
	public String getDerivation() {
		return this.derivation;
	}

	public void setDerivation(String derivation) {
		this.derivation = derivation;
	}

	@Column(name = "CONTENT")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "KEY_A")
	public String getKeyA() {
		return this.keyA;
	}

	public void setKeyA(String keyA) {
		this.keyA = keyA;
	}

	@Column(name = "KEY_B")
	public String getKeyB() {
		return this.keyB;
	}

	public void setKeyB(String keyB) {
		this.keyB = keyB;
	}

	@Column(name = "KEY_C")
	public String getKeyC() {
		return this.keyC;
	}

	public void setKeyC(String keyC) {
		this.keyC = keyC;
	}

	@Column(name = "KEY_D")
	public String getKeyD() {
		return this.keyD;
	}

	public void setKeyD(String keyD) {
		this.keyD = keyD;
	}

	@Column(name = "KEY_E")
	public String getKeyE() {
		return this.keyE;
	}

	public void setKeyE(String keyE) {
		this.keyE = keyE;
	}

	@Column(name = "CORRECT_KEY", length = 10)
	public String getCorrectKey() {
		return this.correctKey;
	}

	public void setCorrectKey(String correctKey) {
		this.correctKey = correctKey;
	}

	@Column(name = "CHANGER", length = 60)
	public String getChanger() {
		return this.changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}

	@Column(name = "CHANGE_TIME")
	public String getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

}