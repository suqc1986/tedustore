package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.tedu.store.bean.User;

public class BaseController{
	/**
	 * 获取登录用户ID
	 * @param session
	 * @return
	 */
	public Integer getId(HttpSession session){
		//获取session里面的user对象
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		return id;
	}
}
