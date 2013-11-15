package org.luyanfeng.myblog.action.home;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("homeAction")
@Scope("prototype")
public class HomeAction extends BasicAction{
	private static final long serialVersionUID = 1L;
	
	/** 导航 后期做成枚举*/
	private String nav;
	private int skip;
	private int limit;
	
	@Resource(name="articleServiceIml")
	private ArticleServiceIml articleService;

	/**
	 * 首页
	 */
	public String index(){
		return SUCCESS;
	}
	/**
	 * 最近更新信息：文章|工作|论坛等 
	 */
	public String last(){
		try {
			this.getSortMap().put("updateTime", -1);
			this.getSortMap().put("time", -1);
			List<ArticleEntity> page = this.articleService.getPage(0, 10,
					this.getSortMap());
			this.setList(page);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return "json-last";
	}
	/**
	 * 文章
	 */
	public String article(){
		try {
			this.getSortMap().put("time", -1);
			List<ArticleEntity> page = articleService.getPage(skip, limit, this.getSortMap());
			ServletActionContext.getRequest().setAttribute("results", page);
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 * 相册
	 */
	public String picture(){
		return SUCCESS;
	}
	/**
	 * 工作
	 */
	public String work(){
		return SUCCESS;
	}
	/**
	 * 讨论 
	 */
	public String discuss(){
		return SUCCESS;
	}
	/**
	 *  关于
	 */
	public String about(){
		return SUCCESS;
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
}
