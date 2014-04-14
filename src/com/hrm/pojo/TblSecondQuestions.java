package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblSecondQuestions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_SECOND_QUESTIONS", schema = "y01")
public class TblSecondQuestions implements java.io.Serializable {

	// Fields

	private Integer qskId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;

	// Constructors

	/** default constructor */
	public TblSecondQuestions() {
	}

	/** minimal constructor */
	public TblSecondQuestions(Integer qskId) {
		this.qskId = qskId;
	}

	/** full constructor */
	public TblSecondQuestions(Integer qskId, String firstKindId, String firstKindName, String secondKindId, String secondKindName) {
		this.qskId = qskId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
	}

	// Property accessors
	@SequenceGenerator(name = "TblSecondQuestions",sequenceName="TblSecondQuestions_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblSecondQuestions")
	@Id
	@Column(name = "QSK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getQskId() {
		return this.qskId;
	}

	public void setQskId(Integer qskId) {
		this.qskId = qskId;
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

}