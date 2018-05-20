package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	/**
	 * 根据商品分类id查询商品详情
	 * @param cartgoryId
	 * @param offset
	 * @param count
	 * @return 商品详情
	 */
	List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offset,Integer count);
	/**
	 * 根据categoryId查找商品数量
	 * @param categoryId
	 * @return 
	 */
	Integer getCount(Integer categoryId);
	/**
	 * 根据商品id查询商品详情
	 * @param id
	 * @return
	 */
	Goods getGoodsById(Integer id);
}
