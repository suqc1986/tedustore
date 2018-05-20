package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 * 插入地址数据
	 * @param address
	 */
	void insert(Address address);
	/**
	 * 根据UID 查询 收获地址
	 * @param uid
	 * @return 如果存在收获地址list集合的size（）>0,如果不存在收获地址list集合的size（） == 0,
	 */
	List<Address> selectByUid(Integer uid);
	
	/**
	 * 把登录用户的所有的isDefault = 0
	 */
	Integer setCancel(Integer uid);
	
	/**
	 * 把选中的isDefault
	 */
	Integer setDefault(Integer id);
	/**
	 * 根据id查找地址信息
	 * @param id
	 * @return
	 */
	Address selectAddressById(Integer id);
	/**
	 * 根据Id修改地址信息
	 */
	void updateById(Address address);
	/**
	 * 根据ID删除address
	 */
	void deleteAddress(Integer id);
}
