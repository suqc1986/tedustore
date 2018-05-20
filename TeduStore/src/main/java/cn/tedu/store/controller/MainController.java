package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.GoodsService;

@RequestMapping("/main")
@Controller
public class MainController {
	@Resource
	private GoodsCategoryService gcm;
	@Resource
	private GoodsService gs;
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		//存放二级目录
		List<GoodsCategory> computerList = gcm.getCategoryByParentid(161, 0, 3);
		//存放三级目录
		List<List<GoodsCategory>> category161List = new ArrayList<List<GoodsCategory>>();
		
		//根据二级目录的id添加三级目录
		for (GoodsCategory list : computerList) {
			category161List.add(gcm.getCategoryByParentid(list.getId(),null, null));
		}
		map.addAttribute("category161List",category161List);
		map.addAttribute("computerList",computerList);
		//存放商品详情
		List<Goods> goodses =  gs.getGoodsByCategoryId(163, 0, 3);
		map.addAttribute("goodsList",goodses);
		return "index";
	}
	
	
}
