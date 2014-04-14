package com.hrm.action.human.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限配置
 * 
 * @author pengdaofa
 *
 */
@Retention(RetentionPolicy.RUNTIME)//代表Permission注解保留在的阶段
@Target(ElementType.METHOD)
public @interface Permission {
	/**
	 * 用户名包含什么字符串才有权限
	 * */
	String nameInclude();

}
