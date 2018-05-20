package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	//添加购物车
	void addCart(Cart cart);
	//显示购物车
	List<CartVo> showCart(Integer uid);
	//删除购物车
	void deleteCart(Integer id);
	//根据id数组删除购物车数据
	void deleteBatchByid(Integer[] ids);
	//根据id数组更改购物车商品数量
	void updateCount(Integer id,Integer count);
}
