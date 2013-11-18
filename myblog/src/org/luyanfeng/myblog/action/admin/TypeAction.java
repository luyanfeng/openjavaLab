package org.luyanfeng.myblog.action.admin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.action.BasicActionExt;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.service.iml.TypeServiceIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("typeAction")
@Scope("prototype")
public class TypeAction extends BasicActionExt<TypeEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="typeServiceIml")
	private TypeServiceIml typeService;
	
	// parameters
	private Integer skip = 0;
	private Integer limit = 10;
	
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
			List<TypeEntity> page = this.typeService.getAll();
			this.setList(page);
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
			boolean delSome = this.typeService.delSome(this.getModel().getId());
			this.getJsonMap().put("s", delSome? 1 : 0 );
		} catch (Exception e) {
			e.printStackTrace();
			this.getJsonMap().put("s", 0);
		}
		return "json-delete";
	}
	/**
	 * 保存 |修改
	 */
	public String save(){
		try {
			Map<String, Serializable> parameters = new HashMap<>();
			parameters.put("id", this.getModel().getId());
			parameters.put("name", this.getModel().getName());
			Integer executeHql = this.typeService.executeHql("UPDATE "+this.getModel().getClass().getSimpleName()+" SET name=:name WHERE id=:id ", parameters);
			this.getJsonMap().put("s", executeHql);
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
}
