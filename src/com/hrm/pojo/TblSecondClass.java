package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblSecondClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_SECOND_CLASS", schema = "y01")
public class TblSecondClass implements java.io.Serializable {

	// Fields

	private Integer fskId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String secondSalaryId;
	private String secondSaleId;

	// Constructors

	/** default constructor */
	public TblSecondClass() {
	}

	/** minimal constructor */
	public TblSecondClass(Integer fskId) {
		this.fskId = fskId;
	}

	/** full constructor */
	public TblSecondClass(Integer fskId, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String secondSalaryId, String secondSaleId) {
		this.fskId = fskId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.secondSalaryId = secondSalaryId;
		this.secondSaleId = secondSaleId;
	}

	// Property accessors
	@SequenceGenerator(name = "TblSecondClass",sequenceName="TblSecondClass_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblSecondClass")
	@Id
	@Column(name = "FSK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getFskId() {
		return this.fskId;
	}

	public void setFskId(Integer fskId) {
		this.fskId = fskId;
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

	@Column(name = "SECOND_SALARY_ID")
	public String getSecondSalaryId() {
		return this.secondSalaryId;
	}

	public void setSecondSalaryId(String secondSalaryId) {
		this.secondSalaryId = secondSalaryId;
	}

	@Column(name = "SECOND_SALE_ID")
	public String getSecondSaleId() {
		return this.secondSaleId;
	}

	public void setSecondSaleId(String secondSaleId) {
		this.secondSaleId = secondSaleId;
	}

}