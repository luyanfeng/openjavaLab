package org.luyanfeng.myblog.action.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.entity.UserEntity;
import org.luyanfeng.myblog.service.iml.ArticleServiceIml;
import org.luyanfeng.myblog.service.iml.TagServcieIml;
import org.luyanfeng.myblog.service.iml.TypeServcieIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends BasicAction<ArticleEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="articleServiceIml")
	private ArticleServiceIml articleService;
	
	@Resource(name="typeServcieIml")
	private TypeServcieIml typeService;
	@Resource(name="tagServcieIml")
	private TagServcieIml tagService;
	
	private String nav;
	// parameters
	private Integer skip = 0;
	private Integer limit = 10;
	private LinkedHashMap<String, Integer> sortMap= new LinkedHashMap<>();
	private List<Serializable> list = new ArrayList<>();
	// json Map results
	private Map<String,Object> jsonMap = new LinkedHashMap<>();
	
	/**
	 *	类型管理 
	 */
	public String types(){
		try {
			this.getRequest().setAttribute("display", 0);
			this.getSortMap().put("time", -1);
			List<TypeEntity> page = this.typeService.getPage(skip, limit, sortMap);
			this.getList().addAll(page);
		} catch (Exception e) {
			this.getRequest().setAttribute("display", 1);
			e.printStackTrace();
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return SUCCESS;
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
			this.getRequest().setAttribute("result", this.articleService.getOne(this.getModel().getId()) );
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
			sortMap.put("time", -1);
			List<ArticleEntity> page = this.articleService.getPage(skip, limit,sortMap);
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
			this.getJsonMap().put("s", 0);
			boolean saveAll = this.articleService.saveAll(this.getModel());
			if(saveAll){
				this.getJsonMap().put("s", 1);
				String tags = this.getModel().getTags();
				String types = this.getModel().getTypes();
				if(StringUtils.isNotBlank(tags)){
					String[] tagArray = tags.split(",");
					this.saveTag(tagArray);
				}
				if(StringUtils.isNotBlank(types)){
					String[] typeArray = types.split(",");
					this.saveType(typeArray);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.getJsonMap().put("s", 0);
		}
		return "json-save";
	}
	/**
	 *	保存类型 
	 */
	private boolean saveType(String[] typeArray) {
		TypeEntity[] types= new TypeEntity[typeArray.length];
		for(int i = 0 ; i < typeArray.length ; i++){
			String name = typeArray[i];
			TypeEntity typeEntity = new TypeEntity();
			{
				typeEntity.setId(GenericUtil.getRandomId());
				typeEntity.setHidden(false);
				typeEntity.setName(name.trim());
				typeEntity.setQuantity(1);
				typeEntity.setTime(new Date());
			}
			types[i] = typeEntity;
		}
		return this.typeService.saveAll(types);
	}
	/**
	 *	保存标签 
	 */
	private boolean saveTag(String[] tagArray) {
		TagEntity[] types= new TagEntity[tagArray.length];
		for(int i = 0 ; i < tagArray.length ; i++){
			String name = tagArray[i];
			TagEntity tagEntity = new TagEntity();
			{
				tagEntity.setId(GenericUtil.getRandomId());
				tagEntity.setHidden(false);
				tagEntity.setName(name.trim());
				tagEntity.setQuantity(1);
				tagEntity.setTime(new Date());
			}
			types[i] = tagEntity;
		}
		return this.tagService.saveAll(types);
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
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public LinkedHashMap<String, Integer> getSortMap() {
		return sortMap;
	}
	public void setSortMap(LinkedHashMap<String, Integer> sortMap) {
		this.sortMap = sortMap;
	}
	public List<Serializable> getList() {
		return list;
	}
	public void setList(List<Serializable> list) {
		this.list = list;
	}
	
}
