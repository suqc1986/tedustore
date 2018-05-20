package cn.tedu.store.aop;

import org.springframework.stereotype.Component;

@Component
public class StudentAop {
	public void test(){
		System.out.println("StudentAop : test");
	}

}
