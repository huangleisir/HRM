package com.hrm.action.human.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Controller;

import com.hrm.utils.WebUtils;

/**
 * human模块的权限管理切入点
 * 
 * @author pengdaofa
 * 
 */
@Aspect //注明该处使用AOP
@Controller("HumanPermissionAspect")//注明该组件是需要在部署阶段被加载进内存的
public class HumanPermissionAspect {

	@Pointcut("execution(java.lang.String com.hrm.action..*.*())")
	private void actionMethod() {
		System.out.println("作用范围：execution(java.lang.String com.hrm.action..*.*())");
	}
	@Around("actionMethod()")
	public Object permissionAdive(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("=======************=========进入HumanPermissionAspect.permissionAdive方法");
		Permission per = getCurrentPermission(pjp);
		System.out.println("-----@Around中前导部分，即将返回值，并退出HumanPermissionAspect.permissionAdive方法");
		Object obj = pjp.proceed();
		System.out.println("=*=*=*@Around：后导部分--------");
		if (hasPower(per)) {
			System.out.println("恭喜你，有权限访问该页面"+"pjp.proceed()在代码中多出现一回，就会多执行一次@aspect中的方法");
			return obj;
		}
		System.out.println("抱歉，你没有权限访问该页面");
		return "noPower";
		
	}
	
	@Before("actionMethod()")
	public Object permissionAdive2() throws Throwable {
		System.out.println("=======****@Before********=========");
		return null;
	}
	
	@After("actionMethod()")
	public Object permissionAdive3() throws Throwable {
		System.out.println("=======****@After********=========");
		return null;
	}
	
	/**
	 * 得到当前执行的方法的Permission注解对象。
	 * 
	 * @param pjp
	 */
	private Permission getCurrentPermission(ProceedingJoinPoint pjp) {
		// 拦截的实体类
		Object target = pjp.getTarget();
		// 拦截的方法名称
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		Permission anno = method.getAnnotation(Permission.class);
		System.out.println("拦截到方法，方法名：" + method.getName());
		if (anno != null)
			System.out.println("anno的属性：" + anno.nameInclude());
		else {
			System.out.println(anno);
		}
		return anno;
	}

	private boolean hasPower(Permission per) {
		if (per == null)
			return true;
		String userName = WebUtils.getUser().getUName();
		if (userName.indexOf(per.nameInclude()) >= 0)
			return true;
		else
			return false;
	}

}
