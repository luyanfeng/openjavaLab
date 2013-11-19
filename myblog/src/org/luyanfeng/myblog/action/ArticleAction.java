package org.luyanfeng.myblog.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.entity.UserEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.luyanfeng.myblog.service.iml.TagServiceIml;
import org.luyanfeng.myblog.service.iml.TypeServiceIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends BasicActionExt<ArticleEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="articleServiceIml")
	private ArticleServiceIml articleService;
	
	@Autowired
	private TypeServiceIml typeServiceIml;
	@Autowired
	private TagServiceIml tagServiceIml;
	
	private List<TypeEntity> typeList = new ArrayList<>();
	private List<TagEntity> tagList = new ArrayList<>();
	private String nav;
	// parameters
	private Integer skip = 0;
	private Integer limit = 10;

	/**
	 *  navigation : 类型管理
	 */
	public String types(){
		return "forward-types";
	}
	/**
	 *  navigation : 标签管理
	 */
	public String tags(){
		return "forward-tags";
	}
	
	/**
	 *  评论开关
	 */
	public String switchReview(){
		try {
			Map<String, Serializable> parameters = new HashMap<>();
			parameters.put("id", this.getModel().getId());
			Integer executeHql = this.articleService.executeLocalHql("UPDATE bl_article  SET isOpen=isOpen^1 WHERE id=:id ", parameters );
			this.getJsonMap().put("s", executeHql);
		} catch (Exception e) {
			this.getJsonMap().put("s", 0);
			e.printStackTrace();
		}
		return "json-switchReview";
	}
	/**
	 *  阅读计数器
	 */
	private String readTimes(){
		try {
			this.getRequest().setAttribute("display", 0);
			Map<String, Serializable> parameters = new HashMap<>();
			parameters.put("id", this.getModel().getId());
			Integer executeHql = this.articleService.executeHql("UPDATE "+ArticleEntity.class.getSimpleName()+" AS t SET t.readtimes=t.readtimes+1 WHERE t.id=:id ", parameters );
			this.getRequest().setAttribute("display", executeHql> 0 ? 0 : 1);
		} catch (Exception e) {
			this.getRequest().setAttribute("display", 1);
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 *  navigation : 编辑|新建
	 */
	public String writer(){
		try {
			this.getRequest().setAttribute("display", 0);
			ArticleEntity one = this.articleService.getOne(this.getModel().getId()) ;
			this.typeList = this.typeServiceIml.getAll();
			if(one != null){
				List<? extends TypeEntity> types = this.typeServiceIml.getByAId(one.getId());
				if(types != null){
					one.getTypeList().addAll(types);
				}
				List<? extends TagEntity> tags = this.tagServiceIml.getByAId(one.getId());
				if(tags != null){
					one.getTagList().addAll(tags);
				}
				this.getRequest().setAttribute("result", one);
			}
		} catch (Exception e) {
			this.getRequest().setAttribute("display", 1);
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 *  navigation : 列表 
	 */
	public String list(){
		try {
			this.getRequest().setAttribute("display", 0);
			this.getJsonMap().put("time", -1);
			List<ArticleEntity> page = this.articleService.getPage(skip, limit,this.getSortMap(),null);
			this.setList(page);
		} catch (Exception e) {
			this.getRequest().setAttribute("display", 1);
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 *  删除
	 */
	public String delete(){
		try {
			boolean delSome = this.articleService.delSome(this.getModel().getId() );
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
			this.getRequest().setAttribute("result", this.articleService.getOne(this.getModel().getId()));
			this.readTimes();
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
			boolean saveAll = this.articleService.saveArticles(this.getModel());
			this.getJsonMap().put("s", saveAll ? 1 : 0);
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
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	public List<TypeEntity> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<TypeEntity> typeList) {
		this.typeList = typeList;
	}
	public List<TagEntity> getTagList() {
		return tagList;
	}
	public void setTagList(List<TagEntity> tagList) {
		this.tagList = tagList;
	}
	
}
