package test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

public class CartTest {
	ApplicationContext ac;
	CartMapper cm;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		this.cm= ac.getBean("cartMapper",CartMapper.class);
	}
	@Test
	public void insert() {
		Cart cart = new Cart();
		cart.setCount(1);
		cart.setGoodsId("10000017");
		cart.setUid(5);
		cm.insertCart(cart);
	}
	@Test
	public void selectCart() {
		System.out.println(cm.selectCart(5));
	}
	@Test
	public void deleteCart() {
		cm.deleteById(1);
	}
	@Test
	public void updateCount() {
		cm.updateCountById(4, 16);
	}
	@Test
	public void arrayList() {
		String s = "1,2,533,6,9";
		String[] arrs = s.split(",");
		arrs = Arrays.copyOf(arrs, 13);
		
		System.out.println(arrs[3]);
	}
}
