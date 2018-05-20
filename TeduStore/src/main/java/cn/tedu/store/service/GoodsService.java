package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
@Service
public class GoodsService implements IGoodsService{
	@Resource
	private GoodsMapper gm;

	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		// TODO Auto-generated method stub
		return gm.select(categoryId, offset, count);
	}
	/**
	 * 获取商品数量
	 */
	public Integer getCount(Integer categoryId) {
		// TODO Auto-generated method stub
		return gm.selectCount(categoryId);
	}
	/*
	 * 获取商品详情根据商品id
	 */
	public Goods getGoodsById(Integer id) {
		// TODO Auto-generated method stub
		return gm.selectByGoodsId(id);
	}
	

}
