package org.luyanfeng.myblog.action.admin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONResult;
import org.apache.struts2.json.JSONUtil;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends BasicAction<ArticleEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="articleServiceIml")
	private ArticleServiceIml service;
	private String nav;
	// parameters
	private Integer skip = 10;
	private Integer limit = 0;
	private List<ArticleEntity> list = new ArrayList<>();
	// json Map results
	private Map<String,Object> jsonMap = new LinkedHashMap<>();
	
	public String writer(){
		return SUCCESS;
	}
	public String list(){
		System.out.println("skip = "+skip);
		System.out.println("limit = "+limit);
//		List<ArticleEntity> page = this.service.getPage(skip, limit);
		List<ArticleEntity> page = new ArrayList<>();
		this.list.addAll(page);
		return SUCCESS;
	}
	public String delete(){
		return SUCCESS;
	}
	public String save(){
		try {
			//		ArticleEntity model = this.getModel();
			this.jsonMap.put("s", 1);
			JSONUtil.serialize(this.jsonMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "save";
	}
	
	
	//-----------------------------
	public Integer getSkip() {
		return skip;
	}
	public void setSkip(Integer skip) {
		this.skip = skip;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
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
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
}
