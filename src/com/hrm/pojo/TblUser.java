package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_USER",schema = "y01")
public class TblUser implements java.io.Serializable {

	// Fields

	private Integer UId;
	private String UName;
	private String UTrueName;
	private String UPassword;

	// Constructors

	/** default constructor */
	public TblUser() {
	}

	/** minimal constructor */
	public TblUser(Integer UId) {
		this.UId = UId;
	}

	/** full constructor */
	public TblUser(Integer UId, String UName, String UTrueName, String UPassword) {
		this.UId = UId;
		this.UName = UName;
		this.UTrueName = UTrueName;
		this.UPassword = UPassword;
	}

	// Property accessors
	@SequenceGenerator(name = "TblUser",sequenceName="TblUser_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblUser")
	@Id
	@Column(name = "U_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	@Column(name = "U_NAME", length = 60)
	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	@Column(name = "U_TRUE_NAME", length = 60)
	public String getUTrueName() {
		return this.UTrueName;
	}

	public void setUTrueName(String UTrueName) {
		this.UTrueName = UTrueName;
	}

	@Column(name = "U_PASSWORD", length = 60)
	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

}