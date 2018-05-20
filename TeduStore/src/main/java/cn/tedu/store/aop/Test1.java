package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Test1 {
//	@Around("bean(userService)||bean(addressService)") bean
//	@Around("within(cn.tedu.store.service.UserService)") 类
//	@Around("within(cn.tedu.store.service.*Service)") *类
//	  第一个 *  返回值类型
//	  即可以是接口，也可以是实现类
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object test1(ProceedingJoinPoint pd) throws Throwable {
		System.out.println("execution----------------------------------------------");
		long start = System.currentTimeMillis();
		Object o = pd.proceed();
		long end = System.currentTimeMillis();
		long time = end-start;
//		计算性能
		System.out.println("userService耗时："+time+"毫秒");
		return o;
	}
}
