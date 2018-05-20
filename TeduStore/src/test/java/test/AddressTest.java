package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.AddressService;

public class AddressTest {
	ApplicationContext ac;
	AddressMapper am;
	AddressService as;
	@Before
	public void before() {
		this.ac= new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		this.am= ac.getBean("addressMapper",AddressMapper.class);
		this.as= ac.getBean("addressService",AddressService.class);
	}
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(5);
		address.setRecvName("南方姑娘");
		address.setRecvProvince("140000");
		address.setRecvCity("140800");
		address.setRecvArea("140822");
		address.setRecvDistrict("山西省,运城市,万荣县");
		address.setRecvAddress("金葫芦镇，满斗村");
		address.setRecvPhone("15034551752");
		am.insert(address);
	}
	@Test
	public void selectByUid() {
//		List<Address> addresses = am.selectByUid(5);
		List<Address> addresses = as.getAddressByUid(2);
		
		System.out.println(addresses);
		
	}
	@Test
	public void insertAddress() {
		Address ad = new Address();
		ad.setUid(2);
		ad.setRecvName("admin");
		ad.setRecvProvince("140000");
		ad.setRecvCity("140800");
		ad.setRecvArea("140822");
		ad.setRecvAddress("这是一个详细地址");
		ad.setRecvPhone("110110110");
		as.addAddress(ad);
	}
	@Test
	public void changeIsDefault() {
		/*System.out.println(am.setCancel(5));
		System.out.println(am.setDefault(6));*/
		as.setDefault(5, 5);
	}
	@Test
	public void selectAddressById() {
		System.out.println(am.selectAddressById(5));
		Address ress = am.selectAddressById(5);
		ress.setRecvName("turing");
		as.updateAddress(ress);
	}
}
