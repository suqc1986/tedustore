package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService {
	/**
	 * 查询所有省
	 * @return
	 */
	List<Province> getProvince();
	/**
	 * 根据省编码，查询市
	 */
	List<City> getCity(String provinceCode);
	/**
	 * 根据市编码，查询区县
	 */
	List<Area> getArea(String cityCode);
}
