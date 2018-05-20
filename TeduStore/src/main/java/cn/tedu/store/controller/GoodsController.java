package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	@Resource
	private IGoodsService gs;
	@RequestMapping("/showSearch.do")
	public String showSearch(ModelMap map, Integer categoryId,Integer pageIndex) {
//		每页显示的条数
		int pageCount = 16;
		if(pageIndex == null) {
			pageIndex = 1;
		}
		List<Goods> goodsList =  gs.getGoodsByCategoryId(categoryId, (pageIndex-1)*pageCount, pageCount);
		Integer count =  gs.getCount(categoryId);
		//把集合设置到modelMap上
		map.addAttribute("goodsList",goodsList);
		//将商品数量绑定到modelMap
		map.addAttribute("count",gs.getCount(categoryId));
		//设置页数
		int pages = count%16==0?count/pageCount:count/pageCount+1;
		map.addAttribute("pages",pages);
		//设置categoryID
		map.addAttribute("categoryId",categoryId);
		//设置当前页数
		map.addAttribute("currentPage",pageIndex);
		return "search";
	}
	@RequestMapping("/goodsInfo.do")
	public String goodsInfo(ModelMap map,Integer goodsId,Integer categoryId) {
		Goods goods = gs.getGoodsById(goodsId);
//		添加商品信息
		map.addAttribute("goods",goods);
		List<Goods> goodsList =  gs.getGoodsByCategoryId(categoryId, 0, 4);
		System.out.println(goodsList);
//		添加推荐商品信息 （只需要查找4个）
		map.addAttribute("goodsList",goodsList);
		return "product_details";
	}
}	
