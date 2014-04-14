package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblMajorClassify entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_MAJOR_CLASSIFY", schema = "y01")
public class TblMajorClassify implements java.io.Serializable {

	// Fields

	private Integer mfkId;
	private String majorKindId;
	private String majorKindName;

	// Constructors

	/** default constructor */
	public TblMajorClassify() {
	}

	/** minimal constructor */
	public TblMajorClassify(Integer mfkId) {
		this.mfkId = mfkId;
	}

	/** full constructor */
	public TblMajorClassify(Integer mfkId, String majorKindId, String majorKindName) {
		this.mfkId = mfkId;
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
	}

	// Property accessors
	@SequenceGenerator(name = "TblMajorClassify",sequenceName="TblMajorClassify_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblMajorClassify")
	@Id
	@Column(name = "MFK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getMfkId() {
		return this.mfkId;
	}

	public void setMfkId(Integer mfkId) {
		this.mfkId = mfkId;
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

}