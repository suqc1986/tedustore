package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;
	
//	读取配置文件
	@Value("#{dbConfig.salt}")
	
	private String salt;
	
	public void register(User user){
		if(userMapper.selectByUsername(user.getUsername()) ==null){
			String newp = DigestUtils.md5Hex(user.getPassword()+salt);
			user.setPassword(newp);
			userMapper.insert(user);
		}else {
//			如果不存在 抛出用户名已存在的异常
			throw new UsernameAlreadyExistException("用名已经存在");
		}
	}
	/**
	 * 查询email是否重复
	 * @param email
	 * @return false表示不存在,可以使用，true表示重复，不能使用
	 */
	public boolean checkEmail(String email) {
		return userMapper.selectByEmail(email) > 0;
	}
	/**
	 * 查询phone是否重复
	 * @param phone
	 * @return false表示不存在,可以使用，true表示重复，不能使用
	 */
	public boolean checkPhone(String phone) {
		// TODO Auto-generated method stub
		return userMapper.selectByPhone(phone) > 0;
	}
	/**
	 * 查询Username是否重复
	 * @param Username
	 * @return false表示不存在,可以使用，true表示重复，不能使用
	 */
	public boolean checkUsername(String uname) {
		return userMapper.selectByUsername(uname) != null;
	}
	/**
	 * 登录方法
	 */
	public User login(String username, String password) {
		System.out.println("login方法开始执行");
		// TODO Auto-generated method stub
		User user = userMapper.selectByUsername(username);
		if(user == null) {
			throw new UserNotFoundException("用户不存在");
		}
		String newp = DigestUtils.md5Hex(password+salt);
		if(newp.equals(user.getPassword())) {
			return user;
		}else {
			throw new PasswordNotMatchException("密码不匹配");
		}
	}
	
	/**
	 * 修改密码
	 */
	public void changePassword(Integer id, String oldPassword, String newPassword) {
		User user = userMapper.selectAllById(id);
		if(user != null) {
//		使用MD5加密
			String newp = DigestUtils.md5Hex(oldPassword+salt);
			if(user.getPassword().equals(oldPassword)) {
				User newUser = new User();
				newUser.setId(id);
				newUser.setPassword(DigestUtils.md5Hex(newPassword+salt));
				userMapper.update(newUser);
			}else {
				throw new PasswordNotMatchException("密码不匹配");
			}
		}
	}
	public void updateUser(Integer id, String username, Integer gender, String phone, String email) {
		// TODO Auto-generated method stub
		User user = new User();
		User u1 = userMapper.selectByUsername(username);
		if(u1 == null) {
			user.setUsername(username);
		}else {
			User u2 = userMapper.selectAllById(id);
			if(u2 != null) {
				if(u2.getUsername().equals(username)) {
					
				}else {
					throw new UsernameAlreadyExistException("用户名已存在");
				}
			}else {
				//如果发现用户不存在，则可以进行某些操作
			}
		}
		user.setId(id);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.update(user);
	}
	/*
	 *根据id查找User
	 */
	public User getUserById(Integer id) {
		return userMapper.selectAllById(id);
	}
	/**
	 * 根据id修改头像路径
	 */
	public void updataImageById(String image, Integer id) {
		// TODO Auto-generated method stub
		userMapper.updataImageById(image, id);
	}
}
