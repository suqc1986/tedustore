package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService {
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;

	/**
	 * 添加地址信息，并设置 isDefalut（是否为默认值） 和 district(地址详情)；
	 */
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		//查询拼接省市区县
		String district = dictMapper.selectProvinceNameByCode(address.getRecvProvince())+
				dictMapper.selectCityNameByCode(address.getRecvCity())+
				dictMapper.selectAreaNameByCode(address.getRecvArea());
		address.setRecvDistrict(district);
		//给isDefault设置值 查看是否是第一条地址信息
		Integer isDefault = addressMapper.selectByUid(address.getUid()).size();
		if(isDefault > 0) {
			address.setIsDefault(0);
		}else {
			address.setIsDefault(1);
		}
		//插入addressData
		addressMapper.insert(address);
		
	}
	/**
	 * 根据UId查询地址信息
	 */
	public List<Address> getAddressByUid(Integer uid) {
		// TODO Auto-generated method stub
		return addressMapper.selectByUid(uid);
	}
	/**
	 * 更改默认地址
	 */
	public void setDefault(Integer uid, Integer id) {
		// TODO Auto-generated method stub
		if(addressMapper.setCancel(uid) == 0) 
			throw new RuntimeException("默认值清除失败");
		
		if(addressMapper.setDefault(id) ==0) 
			throw new RuntimeException("默认值添加失败");
	}
	/**
	 * 根据id查询address
	 */
	public Address getAddressById(Integer id) {
		// TODO Auto-generated method stub
		return addressMapper.selectAddressById(id);
	}
	/**
	 * 根据id修改address
	 */
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		String district = dictMapper.selectProvinceNameByCode(address.getRecvProvince())+
				dictMapper.selectCityNameByCode(address.getRecvCity())+
				dictMapper.selectAreaNameByCode(address.getRecvArea());
		//拼接出来详细地址
		address.setRecvDistrict(district);
		addressMapper.updateById(address);
	}
	/**
	 * 根据id删除address
	 */
	public void deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		addressMapper.deleteAddress(id);
	}

}
