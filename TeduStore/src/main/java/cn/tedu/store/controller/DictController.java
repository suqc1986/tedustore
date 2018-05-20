package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@RequestMapping("/dict")
@Controller
public class DictController {
	@Resource
	private IDictService distSercive;
	/**
	 * 获取province的信息
	 * @return
	 */
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr = new ResponseResult<List<Province>>();
		rr.setData(distSercive.getProvince());
		rr.setMessage("查询省成功");
		rr.setState(1);
		return rr;
	}
	/**
	 * 根据省编号查询下面的所有市
	 * @param provinceCode
	 * @return
	 */
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr = new ResponseResult<List<City>>();
		rr.setData(distSercive.getCity(provinceCode));
		rr.setMessage("查询市成功");
		rr.setState(1);
		return rr;
	}
	/**
	 * 根据市编号查询下面的所有区县
	 * @param provinceCode
	 * @return
	 */
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr = new ResponseResult<List<Area>>();
		rr.setData(distSercive.getArea(cityCode));
		rr.setMessage("查询区县成功");
		rr.setState(1);
		return rr;
	}
}
