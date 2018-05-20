package cn.tedu.store.mapper;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;

public interface OrderMapper {
	//插入订单
	void insertOrder(Order order);
	//	插入订单项
	void insertOrderItem(OrderItem orderItem);
	//	修改订单支付状态
	/**
	 * 
	 * @param oId
	 */
	/*
	  delimiter $$
	  create procedure updateItem(poid int)
	  	begin 
	  		update
	  			t_orderItem
	  		set
	  			paymentStatus=1
	  		where
	   orderid = poid;
	   end $$
	 */
	void updatePaymentStatus(Integer oId);

}
