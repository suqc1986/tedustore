package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.vo.CartVo;
@Service
public class OrderService implements IOrderService {
	@Resource
	private CartMapper cartMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private OrderMapper orderMapper;
	
	public List<CartVo> getOrderByIds(Integer uid, Integer[] ids) {
		//定义新集合orderList
		List<CartVo> orderList = new ArrayList<CartVo>();
		// 调用持久层方法selectCart（）得到集合
		List<CartVo> carts = cartMapper.selectCart(uid);
		//遍历集合 得到 id
		for (CartVo cv : carts) {
			for(Integer id:ids) {
				if(id == cv.getId()) {
					orderList.add(cv);
					break;
				}
			}
		}
		return orderList;
	}
	public void addOrder(Order order, List<CartVo> listVo) {
		// TODO Auto-generated method stub
		orderMapper.insertOrder(order);
		for(CartVo cart:listVo) {
			OrderItem orderItem = new OrderItem();
			orderItem.setUid(cart.getUid());
			orderItem.setGoodsid(cart.getGoodsId());
			orderItem.setTitle(cart.getTitle());
			orderItem.setImage(cart.getImage());
			orderItem.setPrice(cart.getPrice());
			orderItem.setCount(cart.getCount());
			orderItem.setPaymentstatus(0);
			orderItem.setOrderid(order.getId());
			orderItem.setOrderstatus(0);
			orderMapper.insertOrderItem(orderItem);
			//根据id查询商品的信息
			Goods goods = goodsMapper.selectByGoodsId(Integer.parseInt(cart.getGoodsId()));
			//修改商品库存数量
			goodsMapper.updateNumById(cart.getGoodsId(), goods.getNum()-cart.getCount());
		}
/*//			将orderId绑定到session上
		HttpSession session,
		session.setAttribute("orderId",order.getId());*/
	}
	public void updatePaymentStatus(Integer oId) {
		// TODO Auto-generated method stub
		orderMapper.updatePaymentStatus(oId);
	}

}
