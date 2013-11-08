package org.luyanfeng.myblog.service.iml;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.iml.LoginDaoIml;
import org.luyanfeng.myblog.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service("loginServiceIml")
public class LoginServiceIml extends BasicServiceIml<UserEntity> {

	@Resource(name="loginDaoIml")
	private LoginDaoIml dao;
	
	public boolean isLogin(){
		return false;
	}
	/**
	 * 得到一个注册用户
	 */
	public UserEntity getUser(String user, String passwd, String email){
		return dao.getUser(user, passwd, email);
	}
	/**
	 * 用户是否可以登陆 
	 */
	public boolean shouldLogin(String user, String passwd, String email){
		return dao.shouldLogin(user, passwd, email);
	}
}
