package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblStandardSalaryDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_STANDARD_SALARY_DETAIL", schema = "y01")
public class TblStandardSalaryDetail implements java.io.Serializable {

	// Fields

	private Integer sdtId;
	private String standardId;
	private String standardName;
	private Integer itemId;
	private String itemName;
	private Double salary;

	// Constructors

	/** default constructor */
	public TblStandardSalaryDetail() {
	}

	/** minimal constructor */
	public TblStandardSalaryDetail(Integer sdtId) {
		this.sdtId = sdtId;
	}

	/** full constructor */
	public TblStandardSalaryDetail(Integer sdtId, String standardId, String standardName, Integer itemId, String itemName, Double salary) {
		this.sdtId = sdtId;
		this.standardId = standardId;
		this.standardName = standardName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.salary = salary;
	}

	// Property accessors
	@SequenceGenerator(name = "TblStandardSalaryDetail",sequenceName="TblStandardSalaryDetail_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblStandardSalaryDetail")
	@Id
	@Column(name = "SDT_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getSdtId() {
		return this.sdtId;
	}

	public void setSdtId(Integer sdtId) {
		this.sdtId = sdtId;
	}

	@Column(name = "STANDARD_ID", length = 30)
	public String getStandardId() {
		return this.standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	@Column(name = "STANDARD_NAME", length = 60)
	public String getStandardName() {
		return this.standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	@Column(name = "ITEM_ID", precision = 5, scale = 0)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "ITEM_NAME", length = 60)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "SALARY", precision = 8)
	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}