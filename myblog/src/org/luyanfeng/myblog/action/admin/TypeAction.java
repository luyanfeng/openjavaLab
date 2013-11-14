package org.luyanfeng.myblog.action.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.service.iml.TypeServcieIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("typeAction")
@Scope("prototype")
public class TypeAction extends BasicAction<TypeEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="typeServcieIml")
	private TypeServcieIml typeService;
	
	// parameters
	private Integer skip = 0;
	private Integer limit = 10;
	private LinkedHashMap<String, Integer> sortMap= new LinkedHashMap<>();
	private List<Serializable> list = new ArrayList<>();
	// json Map results
	private Map<String,Object> jsonMap = new LinkedHashMap<>();
	
	/**
	 *	显隐开关
	 */
	public String switchHidden(){
		try {
			this.getJsonMap().put("s", 0);
			Map<String, Serializable> parameters = new HashMap<>();
			parameters.put("id", this.getModel().getId());
			Integer ok = this.typeService.executeLocalHql("update bl_type set isHidden=isHidden^1 where id=:id", parameters );
			if(ok > 0) this.getJsonMap().put("s", 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return "json-switchHidden";
	}
	/**
	 *	类型管理 
	 */
	public String list(){
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
	 *  删除
	 */
	public String delete(){
		try {
		} catch (Exception e) {
			e.printStackTrace();
			this.getJsonMap().put("s", 0);
		}
		return "json-delete";
	}
	/**
	 * 保存 
	 */
	public String save(){
		try {
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
		TypeEntity type = this.getModel();
		if(StringUtils.isBlank(type.getName())){
			this.addFieldError("name","类型不能为空");
		}
		if(this.getFieldErrors().isEmpty()){
			if(StringUtils.isBlank(type.getId())){
				type.setId(GenericUtil.getRandomId());
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
