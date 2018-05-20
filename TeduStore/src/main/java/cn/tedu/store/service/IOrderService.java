package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Order;
import cn.tedu.store.vo.CartVo;

public interface IOrderService {
	/**
	 * 获取订单数据
	 * @param uid
	 * @param ids
	 * @return
	 */
	List<CartVo> getOrderByIds(Integer uid,Integer[] ids);
	/**
	 * 添加订单数据 添加订单详情，修改商品库存
	 * @param order
	 * @param listVo
	 */
	void addOrder(Order order,List<CartVo> listVo);
	/**
	 * 根据oid改变支付状态
	 * @param oId
	 */
	void updatePaymentStatus(Integer oId);
}
