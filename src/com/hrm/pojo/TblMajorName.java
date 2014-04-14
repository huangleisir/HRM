package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblMajorName entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_MAJOR_NAME", schema = "y01")
public class TblMajorName implements java.io.Serializable {

	// Fields

	private Integer makId;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private Integer testAmount;

	// Constructors

	/** default constructor */
	public TblMajorName() {
	}

	/** minimal constructor */
	public TblMajorName(Integer makId) {
		this.makId = makId;
	}

	/** full constructor */
	public TblMajorName(Integer makId, String majorKindId, String majorKindName, String majorId, String majorName, Integer testAmount) {
		this.makId = makId;
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.testAmount = testAmount;
	}

	// Property accessors
	@SequenceGenerator(name = "TblMajorName",sequenceName="TblMajorName_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblMajorName")
	@Id
	@Column(name = "MAK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getMakId() {
		return this.makId;
	}

	public void setMakId(Integer makId) {
		this.makId = makId;
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

	@Column(name = "TEST_AMOUNT", precision = 5, scale = 0)
	public Integer getTestAmount() {
		return this.testAmount;
	}

	public void setTestAmount(Integer testAmount) {
		this.testAmount = testAmount;
	}

}