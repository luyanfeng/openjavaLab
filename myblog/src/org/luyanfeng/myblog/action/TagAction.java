package org.luyanfeng.myblog.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.service.iml.TagServcieIml;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("tagAction")
@Scope("prototype")
public class TagAction extends BasicActionExt<TagEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="tagServcieIml")
	private TagServcieIml tagServcie;
	
	/**
	 *	显隐开关
	 */
	public String switchHidden(){
		try {
			this.getJsonMap().put("s", 0);
			Map<String, Serializable> parameters = new HashMap<>();
			parameters.put("id", this.getModel().getId());
			Integer ok = this.tagServcie.executeHql("UPDATE "+this.getModel().getClass().getSimpleName()+" SET isHidden=isHidden^1 WHERE id=:id", parameters );
			if(ok > 0) this.getJsonMap().put("s", 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
		}
		return "json-switchHidden";
	}
	/**
	 *	标签管理 
	 */
	public String list(){
		try {
			this.getRequest().setAttribute("display", 0);
			List<TypeEntity> page = this.tagServcie.getAll();
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
			boolean delSome = this.tagServcie.delSome(this.getModel().getId());
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
			Integer executeHql = this.tagServcie.executeHql("UPDATE "+this.getModel().getClass().getSimpleName()+" SET name=:name WHERE id=:id ", parameters);
			
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
		TagEntity type = this.getModel();
		if(StringUtils.isBlank(type.getName())){
			this.addFieldError("name","标签不能为空");
		}
		if(this.getFieldErrors().isEmpty()){
			if(StringUtils.isBlank(type.getId())){
				type.setId(GenericUtil.getRandomId());
			}
		}
	}
}
