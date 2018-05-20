package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAop {
	@Before("bean(userService)")
//	方法执行之前
	public void test1() {
		System.out.println("执行方法之前@Before");
	}
	@After("bean(userService)")
//方法执行之后（anyhow 无论如何）
	public void test2() {
		System.out.println("执行方法之后@After");
	}
	@AfterReturning("bean(userService)")
	//方法执行之后（不发生异常的情况下）
	public void test3() {
		System.out.println("执行方法之后@AfterReturning");
	}
	@AfterThrowing("bean(userService)")
	//方法执行之后（发生异常的情况下执行）
	public void test4() {
		System.out.println("发生异常执行方法之后@AfterThrowing");
	}
	@Around("bean(userService)")
	//环绕通知必须有返回值
//	必须要定义参数 ProceedingJoinPoint
	public Object test5(ProceedingJoinPoint pin) {
		System.out.println("环绕通知开始@Around");
		Object o = new Object();
//		调用业务逻辑方法
		try {
			 o = pin.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("环绕通知方法快执行结束@Around");
		return o;
	}
}
