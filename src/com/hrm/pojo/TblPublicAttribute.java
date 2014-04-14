package com.hrm.pojo;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TblPublicAttribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TBL_PUBLIC_ATTRIBUTE", schema = "y01")
public class TblPublicAttribute implements java.io.Serializable {

	// Fields

	private Integer pbcId;
	private String attributeKind;
	private String attributeName;

	// Constructors

	/** default constructor */
	public TblPublicAttribute() {
	}

	/** minimal constructor */
	public TblPublicAttribute(Integer pbcId) {
		this.pbcId = pbcId;
	}

	/** full constructor */
	public TblPublicAttribute(Integer pbcId, String attributeKind, String attributeName) {
		this.pbcId = pbcId;
		this.attributeKind = attributeKind;
		this.attributeName = attributeName;
	}

	// Property accessors
	@SequenceGenerator(name = "TblPublicAttribute",sequenceName="TblPublicAttribute_DB")
	@GeneratedValue(strategy = SEQUENCE, generator = "TblPublicAttribute")
	@Id
	@Column(name = "PBC_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getPbcId() {
		return this.pbcId;
	}

	public void setPbcId(Integer pbcId) {
		this.pbcId = pbcId;
	}

	@Column(name = "ATTRIBUTE_KIND", length = 60)
	public String getAttributeKind() {
		return this.attributeKind;
	}

	public void setAttributeKind(String attributeKind) {
		this.attributeKind = attributeKind;
	}

	@Column(name = "ATTRIBUTE_NAME", length = 60)
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

}