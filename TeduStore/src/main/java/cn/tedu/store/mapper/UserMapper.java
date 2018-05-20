package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;
/**
 * 对用户管理模块持久层完成数据层操作
 * @author soft01
 *
 */
public interface UserMapper {
	/**
	 * 向数据库插入数据
	 * @param user
	 */
	void insert (User user);
	/**
	 * 根据用户名查询user对象
	 * @param username 用户名
	 * @return user 如果查到用户名返回的是user对象 如果没有返回null；
	 */
	User selectByUsername(String username);
	/**
	 * 查询email是否重复
	 * @param email
	 * @return 0表示不存在，1表示重复
	 */
	Integer selectByEmail(String email);
	/**
	 * 查询phone是否重复
	 * @param phone
	 * @return 0表示不存在，1表示重复
	 */
	Integer selectByPhone(String phone);
	/**
	 * 修改用户数据
	 * @param user
	 */
	void update (User user);
	/**
	 * 根据ID查找用户信息
	 * @param id
	 * @return 如果存在返回User对象，反之 返回 null；
	 */
	User selectAllById(Integer id);
	/**
	 * 根据id修改图片路径
	 * @param image
	 * @param id
	 */
	void updataImageById(@Param("image") String image,@Param("id") Integer id);
	 /**
	  * 查询出所有的用户信息
	  * @return
	  */
	List<User> selectAll(); 
}
