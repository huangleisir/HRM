package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblThirdClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_THIRD_CLASS", schema = "y01")
public class TblThirdClass implements java.io.Serializable {

	// Fields

	private Integer ftkId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String thirdKindSaleId;
	private String thirdKindIsRetail;

	// Constructors

	/** default constructor */
	public TblThirdClass() {
	}

	/** minimal constructor */
	public TblThirdClass(Integer ftkId) {
		this.ftkId = ftkId;
	}

	/** full constructor */
	public TblThirdClass(Integer ftkId, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, String thirdKindSaleId, String thirdKindIsRetail) {
		this.ftkId = ftkId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.thirdKindSaleId = thirdKindSaleId;
		this.thirdKindIsRetail = thirdKindIsRetail;
	}

	// Property accessors
	@SequenceGenerator(name = "TblThirdClass",sequenceName="TblThirdClass_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblThirdClass")
	@Id
	@Column(name = "FTK_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getFtkId() {
		return this.ftkId;
	}

	public void setFtkId(Integer ftkId) {
		this.ftkId = ftkId;
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

	@Column(name = "THIRD_KIND_SALE_ID")
	public String getThirdKindSaleId() {
		return this.thirdKindSaleId;
	}

	public void setThirdKindSaleId(String thirdKindSaleId) {
		this.thirdKindSaleId = thirdKindSaleId;
	}

	@Column(name = "THIRD_KIND_IS_RETAIL", length = 2)
	public String getThirdKindIsRetail() {
		return this.thirdKindIsRetail;
	}

	public void setThirdKindIsRetail(String thirdKindIsRetail) {
		this.thirdKindIsRetail = thirdKindIsRetail;
	}

}