package org.luyanfeng.myblog.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.UserEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

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
	
	/**
	 *  navigation : 编辑|新建
	 */
	public String writer(){
		try {
			this.getRequest().setAttribute("display", 0);
			this.getRequest().setAttribute("result", this.service.getOne(this.getModel().getId()) );
		} catch (Exception e) {
			this.getRequest().setAttribute("display", 1);
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 *  navigation : 列表 
	 */
	public String list(){
		try {
			this.getRequest().setAttribute("display", 0);
			List<ArticleEntity> page = this.service.getPage(skip, limit);
			this.list.addAll(page);
		} catch (Exception e) {
			this.getRequest().setAttribute("display", 1);
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 *  删除
	 */
	public String delete(){
		try {
			boolean delSome = this.service.delSome(this.getModel().getId() );
			this.getJsonMap().put("s", delSome ? 1 : 0);
		} catch (Exception e) {
			e.printStackTrace();
			this.getJsonMap().put("s", 0);
		}
		return "json-delete";
	}
	/**
	 *  详情
	 */
	public String detail(){
		try {
			this.getRequest().setAttribute("result", this.service.getOne(this.getModel().getId()));
		} catch (Exception e) {
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 * 保存 
	 */
	public String save(){
		try {
			this.getJsonMap().put("s", 0);
			boolean saveAll = this.service.saveAll(this.getModel());
			if(saveAll)	this.getJsonMap().put("s", 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.getJsonMap().put("s", 0);
		}
		return "json-save";
	}
	/**
	 * validate : 保存校验
	 */
	public void validateSave() {
		ArticleEntity article = this.getModel();
		if(StringUtils.isBlank(article.getTitle())){
			this.addFieldError("title","标题不能为空");
		}
		if(StringUtils.isBlank(article.getContent())){
			this.addFieldError("content", "内容不能为空");
		}
		if(this.getFieldErrors().isEmpty()){
			UserEntity loginUser = (UserEntity)WebUtils.getSessionAttribute(getRequest(), GenericUtil.SessionInfo.USER_INFO.toString());
			article.setAuthor(loginUser.getUser());
			article.setTime(new Date());
			if(StringUtils.isBlank(article.getId())){
				article.setId(GenericUtil.getRandomId());
			}
		}
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
