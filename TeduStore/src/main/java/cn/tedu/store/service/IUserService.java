package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;

public interface IUserService {
	/**
	 * 注册方法，用户名重复抛出异常
	 */
	void register(User user);
	/**
	 * 验证邮箱是否存在 true表示存在，false表示不存在
	 */
	boolean checkEmail(String email);
	/**
	 * 验证手机号是否存在 true表示存在，false表示不存在
	 */
	boolean checkPhone(String phone);
	/**
	 * 验证手机号是否存在 true表示存在，false表示不存在
	 */
	boolean checkUsername(String uname);

	/**
	 * 登录的功能
	 * @param uasername
	 * @param password
	 * @return  登录成功返回user对象 如果失败抛出运行时异常
	 * PasswordNotMatchException
	 * UserNotFoundException
	 */
	User login(String username,String password);
	/**
	 * 更改密码
	 * @param user
	 * @param newPassword
	 */
	void changePassword(Integer id,String oldPassword,String newPassword);
	/**
	 * 修改用户基本信息
	 * @param id
	 * @param username
	 * @param gender
	 * @param phone
	 * @param enail
	 */
	void updateUser(Integer id,String username,Integer gender,String phone,String email);
	/**
	 * 根据ID查询user对象
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 根据id修改图片路径
	 * @param image
	 * @param id
	 */
	void updataImageById(String image,Integer id);
}
