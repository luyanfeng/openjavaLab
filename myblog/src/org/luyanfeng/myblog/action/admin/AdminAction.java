package org.luyanfeng.myblog.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.UserEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends BasicAction<UserEntity>{
	private static final long serialVersionUID = 1L;
	
	/** 导航 后期做成枚举*/
	private String nav;
	
	private UserEntity user =new UserEntity();
	
	
	@Resource(name="articleServiceIml")
	private ArticleServiceIml service;
	/**
	 * 首页
	 */
	public String index(){
		return "index";
	}
	//TODO 后台权限校验 ,改用Interceptor实现
	public void validateIndex(){
		/*HttpSession session = this.getRequest().getSession();
		if(session.isNew()  || (StringUtils.isBlank(this.getModel().getUser()) || StringUtils.isBlank(this.getModel().getPasswd()))){
			this.addActionError("你无权访问！");
		}else{
			// mysql .
			session.setAttribute("login", this.getModel());
		}*/
	}
	/**
	 * 登录
	 */
	public String login(){
		return "login";
	}

	
	
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	
}
