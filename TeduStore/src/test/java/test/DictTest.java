package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

public class DictTest {
	ApplicationContext ac;
	DictMapper dm;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		this.dm= ac.getBean("dictMapper",DictMapper.class);
	}
	@Test
	public void selectProvince() {
		List<Province> provinces = dm.selectProvince();
		System.out.println(provinces);
	}
	@Test
	public void selectCities() {
		List<City> cities = dm.selectCity("140000");
		System.out.println(cities);
	}
	@Test
	public void selectAreas() {
		List<Area> areas = dm.selectArea("140800");
		System.out.println(areas);
	}
	@Test
	public void selectName() {
		System.out.println(dm.selectProvinceNameByCode("140000"));
		System.out.println(dm.selectCityNameByCode("140800"));
		System.out.println(dm.selectAreaNameByCode("140822"));
	}
}
