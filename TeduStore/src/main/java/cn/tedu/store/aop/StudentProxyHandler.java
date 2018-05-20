package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tedu.store.service.StudentService;
@Component
public class StudentProxyHandler implements InvocationHandler {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentAop studentAop;
	
	public Object getObject() {
//		第一个参数 获取业务逻辑类的类加载器对象
//		第二个参数获取业务逻辑的接口对象
//		第三个参数实现了InvocationHandler接口的实现类的对象
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		studentAop.test();
//		通过反射调用业务逻辑类的方法
		Object o = method.invoke(studentService, args);
		return o;
	}
	
}
