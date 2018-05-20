package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
@Transactional
//底层实现类，将会全部具有事务处理能力
public interface IAddressService {
	/**
	 * 添加地址信息
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 * 获取登录用户的收货地址
	 * @param uid
	 * @return
	 */
	List<Address> getAddressByUid(Integer uid);
	/**
	 * 更改默认的地址
	 * @param uis
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * 根据id查询address
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * 根据id修改address
	 * @param address
	 */
	void updateAddress(Address address);
	
	/**
	 * 根据id删除address
	 * @param void
	 */
	void deleteAddress(Integer id);
	
}
