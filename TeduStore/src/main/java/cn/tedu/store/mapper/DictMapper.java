package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * 查询所有的省
	 * @return
	 */
	List<Province> selectProvince();
	/**
	 * 根据省IdCode查找市
	 * @param id
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * 根据省IdCode查找市
	 * @param id
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	/***
	 * 根据省编号，查找省名字
	 * @param privinceCode
	 * @return
	 */
	String selectProvinceNameByCode(String privinceCode);
	/***
	 * 根据市编号，查找市名字
	 * @param privinceCode
	 * @return
	 */
	String selectCityNameByCode(String cityCode);
	/***
	 * 根据区县编号，查找区县名字
	 * @param privinceCode
	 * @return
	 */
	String selectAreaNameByCode(String areaCode);
}
