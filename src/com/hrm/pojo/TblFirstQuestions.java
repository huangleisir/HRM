package com.hrm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblFirstQuestions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_FIRST_QUESTIONS", schema = "y01")
public class TblFirstQuestions implements java.io.Serializable {

	// Fields

	private Integer qfkId;
	private String firstKindId;
	private String firstKindName;

	// Constructors

	/** default constructor */
	public TblFirstQuestions() {
	}

	/** full constructor */
	public TblFirstQuestions(String firstKindId, String firstKindName) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
	}

	// Property accessors
	@SequenceGenerator(name = "TblFirstQuestions",sequenceName="TblFirstQuestions_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblFirstQuestions")
	@Id
	@Column(name = "QFK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getQfkId() {
		return this.qfkId;
	}

	public void setQfkId(Integer qfkId) {
		this.qfkId = qfkId;
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

}