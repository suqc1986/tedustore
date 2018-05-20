package cn.tedu.store.service;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

@Service()
public class Dictservice implements IDictService{
	@Resource
	private DictMapper dictMapper;
//	redis配置
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	/**
	 * 查询所有的省
	 */
	public synchronized List<Province> getProvince() {
//		先查询redis中是否有省份信息
//		List<Province> list = (List<Province>) redisTemplate.opsForValue().get("province");
//		if(list == null) {
			System.out.println("查询Province");
//			储存到缓存
//			list = dictMapper.selectProvince();
//			redisTemplate.opsForValue().set("province", list,1,TimeUnit.DAYS);
//		}
		return dictMapper.selectProvince();
	}
	/**
	 * 根据省查询所有的市
	 */
	public List<City> getCity(String provinceCode) {
		// TODO Auto-generated method stub
		return dictMapper.selectCity(provinceCode);
	}
	
	public List<Area> getArea(String cityCode) {
		// TODO Auto-generated method stub
		return dictMapper.selectArea(cityCode);
	}
	
	
}
