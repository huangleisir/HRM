package com.hrm.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

public class TestVo {
	private String one;
	private String two;
	private String thrid;
	
	public TestVo() {
		super();
	}

	public TestVo(String one, String two, String thrid) {
		super();
		this.one = one;
		this.two = two;
		this.thrid = thrid;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThrid() {
		return thrid;
	}

	public void setThrid(String thrid) {
		this.thrid = thrid;
	}

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
	}

}
