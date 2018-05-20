package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

@Service
public class GoodsCategoryService implements IGoodsCategoryService {
	@Resource
	private GoodsCategoryMapper GoodsCategoryMapper;
	public List<GoodsCategory> getCategoryByParentid(Integer parentId, Integer offset, Integer count) {
		// TODO Auto-generated method stub
		return GoodsCategoryMapper.selectCategoryByParentId(parentId, offset, count);
	}

}
