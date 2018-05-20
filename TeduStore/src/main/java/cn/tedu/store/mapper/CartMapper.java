package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {
//	插入购物车数据
	void insertCart(Cart cart);
//查询uid下面的商品信息
//	添加值对象CartVo
	List<CartVo> selectCart(Integer uid);
//	根据id删除购物车数据
	void deleteById(Integer id);
//	根据id数组删除购物车数据
	void deleteBatchById(Integer[] id);
//	根据id修改购物车商品数量
	void updateCountById(@Param("id") Integer id,@Param("count") Integer count);
	
}
