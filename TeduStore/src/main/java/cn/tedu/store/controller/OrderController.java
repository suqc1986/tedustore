package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Order;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.vo.CartVo;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Resource
	private IOrderService os;
	@Resource
	private IAddressService as;
	@RequestMapping("/orderConfirm.do")
	public String orderConfirm(HttpSession session,Integer[] ids,ModelMap map ) {
		List<CartVo> cartVos = os.getOrderByIds(this.getId(session), ids);
		map.addAttribute("cartVos",cartVos);
//		绑定订单数据到session上，供下一个需求addOrder使用
		session.setAttribute("cartVos", cartVos);
		
//		绑定收货地址
		List<Address> listAddress = as.getAddressByUid(this.getId(session));
		map.addAttribute("listAddress",listAddress);
		return "orderConfirm";
	}
	@RequestMapping("/addOrder.do")
	public String addOrder(HttpSession session) {
		Order order = new Order();
		order.setUid(this.getId(session));
		List<CartVo> caerList = (List<CartVo>) session.getAttribute("cartVos");
//		生成订单数据
		os.addOrder(order, caerList);
		session.setAttribute("orderId", order.getId());
//		溢出oid cartVos
		session.removeAttribute("");
		return "payment";
	}
	@RequestMapping("/payment.do")
	public String payment(HttpSession session) {
		os.updatePaymentStatus((Integer)session.getAttribute("orderId"));
//		溢出oid cartVos
		session.removeAttribute("orderId");
		session.removeAttribute("cartVos");
		return  "pay_success";
	}
}
