package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	/**
	 * 根据父级id查找商品信息
	 * @param parentId 父级id
	 * @param offset 查询的起始位置（偏移量）
	 * @param count （查询数量）
	 * @return 商品信息的数组
	 */
	List<GoodsCategory> getCategoryByParentid(Integer parentId,Integer offset,Integer count);
}
