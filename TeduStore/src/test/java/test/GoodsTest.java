package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

public class GoodsTest {
	private ApplicationContext ac;
	private GoodsMapper gm;
	private IGoodsService igs;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		this.gm= ac.getBean("goodsMapper",GoodsMapper.class);
		this.igs = ac.getBean("goodsService",IGoodsService.class);
	}
	@Test
	public void select(){
		System.out.println(igs.getGoodsByCategoryId(163, 0, 3));
		System.out.println(gm.select(163, 0, 3));
	}
	@Test
	public void selectGoodsCount() {
		System.out.println(gm.selectCount(163));
		System.out.println(igs.getCount(163));
	}
	@Test
	public void selectGoodsById(){
		System.out.println(igs.getGoodsById(10000017));
	}
	@Test
	public void updateGoodsNumById(){
		gm.updateNumById("10000001", 9997);
	}
	
}
