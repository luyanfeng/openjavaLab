package org.luyanfeng.myblog.action.home;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("homeAction")
@Scope("prototype")
public class HomeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<ArticleEntity> list = new ArrayList<>();
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
	/**
	 * 文章
	 */
	public String article(){
		return "article";
	}
	/**
	 * 相册
	 */
	public String picture(){
		return "picture";
	}
	/**
	 * 工作
	 */
	public String work(){
		return "work";
	}
	/**
	 * 讨论 
	 */
	public String discuss(){
		return "discuss";
	}
	/**
	 *  关于
	 */
	public String about(){
		return "about";
	}
	
	
	public List<ArticleEntity> getList() {
		return list;
	}
	public void setList(List<ArticleEntity> list) {
		this.list = list;
	}
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	
}
