package org.luyanfeng.myblog.action.admin;

import javax.annotation.Resource;

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
	@Resource(name="articleServiceIml")
	private ArticleServiceIml service;
	/**
	 * 首页
	 */
	public String index(){
		return "index";
	}
	
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	
}
