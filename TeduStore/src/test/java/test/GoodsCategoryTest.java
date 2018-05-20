package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IGoodsCategoryService;

public class GoodsCategoryTest {
	private ApplicationContext ac;
	private GoodsCategoryMapper gm;
	private IGoodsCategoryService igcs;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		this.gm= ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		this.igcs = ac.getBean("goodsCategoryService",IGoodsCategoryService.class);
	}
	@Test
	//电脑办公161
	//	二级菜单 162 171 186
	public void selectCategory() {
		List <GoodsCategory> gc =  gm.selectCategoryByParentId(162, null, null);
		List <GoodsCategory> gcs =  igcs.getCategoryByParentid(162, 0, 3);
		System.out.println(gcs.size());
	}
}
