package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVo;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Resource
	private ICartService cs;
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String id,Integer count){
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setCount(count);
		cart.setGoodsId(id);
		cs.addCart(cart);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		rr.setMessage("添加购物车成功");
		rr.setState(1);
		return rr;
	}
	@RequestMapping("/showCart.do")
	public String showCart(ModelMap map,HttpSession session) {
		List<CartVo> goodsList = cs.showCart(this.getId(session));
		map.addAttribute("goodsList",goodsList);
		return "cart";
	}
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id) {
		cs.deleteCart(id);
		return "redirect:/cart/showCart.do";
	}
	@RequestMapping("/deleteBatchById.do")
	public String deleteBatchById(Integer[] ids) {
		cs.deleteBatchByid(ids);
		return "redirect:/cart/showCart.do";
	}
	@RequestMapping("/updateCount.do")
	@ResponseBody
	public ResponseResult<Void> updateCount(Integer id,Integer count){
		cs.updateCount(id, count);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		rr.setMessage("count changed success");
		rr.setState(1);
		return rr;
	}
	
}
