package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 查询热门商品信息
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> select(
			@Param("categoryId") Integer categoryId,
			@Param("offset")Integer offset,
			@Param("count")Integer count);
	/**
	 * 根据categoryId查询商品数量
	 * @param categoryId
	 * @return
	 */
	Integer selectCount(Integer categoryId);
	/**
	 * 根据id查找商品详情
	 * @param id
	 * @return
	 */
	Goods selectByGoodsId(Integer id);
	/**
	 * 根据商品ID 修改商品数量
	 * @param id
	 * @param num
	 */
	void updateNumById(@Param("id")String id,@Param("num")Integer num);
}
