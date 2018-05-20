package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;
@Service
public class CartService implements ICartService {
	@Resource
	private CartMapper cm;
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		cm.insertCart(cart);
	}
	//显示购物车
	public List<CartVo> showCart(Integer uid) {
		// TODO Auto-generated method stub
		return cm.selectCart(uid);
	}
	//删除购物车一条数据
	public void deleteCart(Integer id) {
		// TODO Auto-generated method stub
		cm.deleteById(id);
	}
	//根据id数组删除购物车数据
	public void deleteBatchByid(Integer[] id) {
		// TODO Auto-generated method stub
		cm.deleteBatchById(id);
	}
	public void updateCount(Integer id, Integer count) {
		// TODO Auto-generated method stub
		cm.updateCountById(id, count);
	}
}
