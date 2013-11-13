package org.luyanfeng.myblog.action.home;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
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
	private int skip;
	private int limit;
	private LinkedHashMap<String, Integer> sortMap= new LinkedHashMap<>();
	
	@Resource(name="articleServiceIml")
	private ArticleServiceIml articleService;

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
		try {
			List<ArticleEntity> page = articleService.getPage(skip, limit, sortMap);
			ServletActionContext.getRequest().setAttribute("results", page);
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
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
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public LinkedHashMap<String, Integer> getSortMap() {
		return sortMap;
	}
	public void setSortMap(LinkedHashMap<String, Integer> sortMap) {
		this.sortMap = sortMap;
	}
	
}
