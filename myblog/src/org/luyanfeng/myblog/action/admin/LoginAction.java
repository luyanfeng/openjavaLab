package org.luyanfeng.myblog.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.UserEntity;
import org.luyanfeng.myblog.service.iml.LoginServiceIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BasicAction<UserEntity> {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="loginServiceIml")
	private LoginServiceIml service;

	/**
	 *  navigation：登陆页面 
	 */
	public String toLogin(){
		return "toLogin";
	}
	/**
	 * navigation： 后台首面转向
	 */
	public String login(){
		return SUCCESS;
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
		if(this.getFieldErrors().isEmpty()){
			UserEntity user2 = this.service.getUser(user.getUser(), user.getPasswd(), user.getEmail());
			HttpSession session = this.getRequest().getSession(false);
			if(user2 != null){
				session.setAttribute(GenericUtil.SessionInfo.USER_EMAIL.toString(), user2.getEmail());
				session.setAttribute(GenericUtil.SessionInfo.USER_INFO.toString(), user2);
			}else {
				this.addActionError("用户信息不匹配，或着不存在");
			};
		}
	}
}
