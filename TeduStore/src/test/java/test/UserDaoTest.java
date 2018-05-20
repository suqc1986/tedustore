package test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.StudentProxyHandler;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IStudentService;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserService;

public class UserDaoTest {
	ApplicationContext ac;
	UserMapper um;
	IUserService ius;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		this.um= ac.getBean("userMapper",UserMapper.class);
		ius = ac.getBean("userService",IUserService.class);
	}
	@Test
	public void testAop(){
		ApplicationContext aco = new 
				ClassPathXmlApplicationContext(
						"spring-dao.xml",
						"spring-service.xml",
						"spring-aop.xml");
//		静态代理
/*		IStudentService ss = 
				aco.getBean("studentProxy",IStudentService.class);*/
//		动态代理
		StudentProxyHandler sh = aco.getBean("studentProxyHandler",
				StudentProxyHandler.class);
		//返回代理类的对象
		IStudentService ss = (IStudentService)sh.getObject();
		ss.add();
	}
	@Test
	public void testInserst() {
		User user = new User();
		user.setUsername("admin123");
		user.setPassword("123456");
		user.setEmail("2205553696@qq.com");
		user.setPhone("15381146912");
		System.out.println(user);
		this.um.insert(user);
	}
	@Test
	public void testSelectByUsername() {
		User user =this.um.selectByUsername("admin13");
		System.out.println(user);
	}
	@Test
	/*
	 * 业务层测试注册
	 */
	public void testRegister() {
		UserService user2 = ac.getBean("userService",UserService.class);
		User user = new User();
		user.setUsername("turing");
		user.setPassword("test");
		user.setEmail("1411354774@qq.com");
		user.setPhone("13623596835");
		user2.register(user);
	}
	@Test
	/*
	 * 业务层测试邮箱是否重复
	 */
	public void testCheckEmail() {
		Boolean result =  ius.checkEmail("1411354774@qq.com");
		System.out.println(result);
	}
	/*
	 * 业务层测试邮箱是否重复
	 */
	@Test
	public void testCheckPhone() {
		Boolean result =  ius.checkPhone("15381146912");
		System.out.println(result);
	}
	/*
	 * 业务层测试username是否重复
	 */
	@Test
	public void testCheckUsername() {
		Boolean result =  ius.checkUsername("admin");
		System.out.println(result);
	}
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(2);
		user.setPassword("1234");
		user.setModifiedTime(new Date());
		user.setModifiedUser("test");
		um.update(user);
	}
	@Test
	public void changePassword() {
		/*User user =um.selectAllById(2);
		System.out.println(user);*/
		
		ius.changePassword(5, "0000", "11111");
	}
	@Test
	public void update() {
		ius.updateUser(5, "admiTest", 1, "13994899800", "3696@qq.com");
	}
	@Test
	public void getUserById() {
		System.out.println(ius.getUserById(5));
	}
	@Test
	public void updateImg() {
		um.updataImageById("image/icon/001.jpg", 6);
	}
	@Test
	public void selectAll() {
		System.out.println(um.selectAll().get(2));
	}
}
