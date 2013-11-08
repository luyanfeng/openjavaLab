package org.luyanfeng.myblog.action.admin;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.UserEntity;
import org.luyanfeng.myblog.service.iml.LoginServiceIml;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BasicAction<UserEntity> {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="loginServiceIml")
	private LoginServiceIml service;

	/**
	 * 登陆页面 
	 */
	public String toLogin(){
		return "login";
	}
	/**
	 * 登录处理器 
	 */
	public String login(){
		UserEntity user = this.getModel();
		boolean shouldLogin = service.shouldLogin(user.getUser(), user.getPasswd(), user.getEmail());
		if(shouldLogin)	this.getRequest().getSession(false).setAttribute("loginEmail", user.getEmail());
		return "index";
	}
	/**
	 * 登录参数处理器
	 */
	public void validateLogin(){
		UserEntity user = this.getModel();
		if(StringUtils.isBlank(user.getUser())){
			this.addFieldError("user", "用户名不能为空");
		}
		if(StringUtils.isBlank(user.getPasswd())){
			this.addFieldError("passwd", "用户密码不能为空");
		}
		if(StringUtils.isBlank(user.getEmail())){
			this.addFieldError("email", "用户邮箱不能为空");
		}
	}
}
