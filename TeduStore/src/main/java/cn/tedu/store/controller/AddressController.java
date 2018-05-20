package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@RequestMapping("/address")
@Controller
public class AddressController extends BaseController {
	@Resource
	private IAddressService as;
	/**
	 * 显示页面
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String shoeAddress() {
		return "addressAdmin";
	}
	/**
	 * 插入地址数据
	 * @return
	 */
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag,
			HttpSession session
			){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		Address ar = new Address();
		ar.setUid(this.getId(session));
		ar.setRecvName(recvName);
		ar.setRecvProvince(recvProvince);
		ar.setRecvCity(recvCity);
		ar.setRecvArea(recvArea);
		ar.setRecvAddress(recvAddress);
		ar.setRecvPhone(recvPhone);
		ar.setRecvTel(recvTel);
		ar.setRecvZip(recvZip);
		ar.setRecvTag(recvTag);
		as.addAddress(ar);
		rr.setMessage("address添加成功");
		rr.setState(1);
		return rr;
	}
	/**
	 * 查询所有的地址信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<List<Address>> getAddressByUid(HttpSession session){
		ResponseResult<List<Address>> rr = new ResponseResult<List<Address>>();
		List<Address> address = as.getAddressByUid(this.getId(session));
		rr.setData(address);
		rr.setMessage("select ok");
		rr.setState(1);
		return rr;
	}
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session ,Integer id){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			as.setDefault(this.getId(session), id);
			rr.setMessage("获取地址信息成功");
			rr.setState(1);
		}catch (Exception e) {
			rr.setMessage(e.getMessage());
			rr.setState(0);
		}
		return rr;
	}
	@RequestMapping("/getAddressById.do")
	@ResponseBody
	public ResponseResult<Address> getAddressById(Integer id){
		ResponseResult<Address> rr = new ResponseResult<Address>();
		rr.setData(as.getAddressById(id));
		rr.setMessage("查询地址信息成功");
		rr.setState(1);
		return rr;
	}
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddressById(
			@RequestParam("id") Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag,
			HttpSession session
			){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		Address ar = as.getAddressById(id);
		ar.setId(id);
		ar.setUid(this.getId(session));
		ar.setRecvName(recvName);
		ar.setRecvProvince(recvProvince);
		ar.setRecvCity(recvCity);
		ar.setRecvArea(recvArea);
		ar.setRecvAddress(recvAddress);
		ar.setRecvPhone(recvPhone);
		ar.setRecvTel(recvTel);
		ar.setRecvZip(recvZip);
		ar.setRecvTag(recvTag);
		as.updateAddress(ar);
		rr.setMessage("修改成功");
		rr.setState(1);
		return rr;
	}
	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public ResponseResult<Void> deleteAddress(Integer id){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		as.deleteAddress(id);
		rr.setState(1);
		rr.setMessage("删除成功");
		return rr;
	}
}
