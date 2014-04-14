package com.hrm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblFirstClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_FIRST_CLASS", schema = "y01")
public class TblFirstClass implements java.io.Serializable {

	// Fields

	private Integer ffkId;
	private String firstKindId;
	private String firstKindName;
	private String firstKindSalaryId;
	private String firstKindSaleId;

	// Constructors

	/** default constructor */
	public TblFirstClass() {
	}

	/** full constructor */
	public TblFirstClass(String firstKindId, String firstKindName, String firstKindSalaryId, String firstKindSaleId) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.firstKindSalaryId = firstKindSalaryId;
		this.firstKindSaleId = firstKindSaleId;
	}

	// Property accessors
	@SequenceGenerator(name = "TblFirstClass",sequenceName="TblFirstClass_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblFirstClass")
	@Id
	@Column(name = "FFK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getFfkId() {
		return this.ffkId;
	}

	public void setFfkId(Integer ffkId) {
		this.ffkId = ffkId;
	}

	@Column(name = "FIRST_KIND_ID", length = 5)
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

	@Column(name = "FIRST_KIND_SALARY_ID")
	public String getFirstKindSalaryId() {
		return this.firstKindSalaryId;
	}

	public void setFirstKindSalaryId(String firstKindSalaryId) {
		this.firstKindSalaryId = firstKindSalaryId;
	}

	@Column(name = "FIRST_KIND_SALE_ID")
	public String getFirstKindSaleId() {
		return this.firstKindSaleId;
	}

	public void setFirstKindSaleId(String firstKindSaleId) {
		this.firstKindSaleId = firstKindSaleId;
	}

}