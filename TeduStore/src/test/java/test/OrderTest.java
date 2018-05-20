package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.vo.CartVo;

public class OrderTest {
	ApplicationContext ac;
	IOrderService os;
	OrderMapper om;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		this.os= ac.getBean("orderService",IOrderService.class);
		this.om= ac.getBean("orderMapper",OrderMapper.class);
	}
	@Test
	public void getOrderId() {
		System.out.println(os.getOrderByIds(5, new Integer[]{4,5,6}));
	}
	@Test
	public void insertOrder() {
		/*Order order = new Order();
		order.setUid(5);
		om.insertOrder(order);
		System.out.println(order.getId());*/
		OrderItem orderItem = new OrderItem();
		orderItem.setUid(2);
		orderItem.setGoodsid("10000001");
		orderItem.setImage("/image/xxx");
		orderItem.setTitle("戴尔");
		orderItem.setPrice(5000.0);
		orderItem.setCount(1);
		orderItem.setPaymentstatus(0);
		orderItem.setOrderstatus(0);
		orderItem.setOrderid(1);
		om.insertOrderItem(orderItem);
	}
	@Test
	public void testAdd() {
		Order order = new Order();
		order.setUid(2);
		List<CartVo> cartList = new ArrayList<CartVo>();
		CartVo cart = new CartVo();
		cart.setUid(2);
		cart.setGoodsId("10000001");
		cart.setCount(1);
		cart.setPrice(1000.0);
		cart.setImage("test.png");
		cartList.add(cart);
		os.addOrder(order, cartList);
		
	}
	@Test
	public void update() {
		om.updatePaymentStatus(4);
	}
}
