package org.luyanfeng.myblog.action;

import java.util.List;

import javax.annotation.Resource;

import org.luyanfeng.myblog.entity.ImageEntity;
import org.luyanfeng.myblog.service.iml.ImageServiceIml;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("imageAction")
@Scope("prototype")
public class ImageAction extends BasicActionExt<ImageEntity> {
	private static final long serialVersionUID = 1L;

	@Resource(name="imageServiceIml")
	private ImageServiceIml imageServiceIml;
	private int skip;
	private int limit;
	
	private String nav;
	
	/**
	 * 上传 图片  最好放到一个公共类
	 */
	public String upload(){
		this.getJsonMap().put("s", 0);
		return "json-upload";
	}
	
	
	/**
	 * 图片列表 
	 */
	public String list(){
		try {
			this.getRequest().setAttribute("display", 0);
			List<ImageEntity> page = this.imageServiceIml.getPage(skip, limit,
					this.getSortMap(), this.getWhereMap());
			this.setList(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.getRequest().setAttribute("display", 1);
		}
		return SUCCESS;
	}
	/**
	 * 删除 
	 */
	public String delete(){
		this.getJsonMap().put("s", 0);
		return "json-delete";
	}
	/**
	 *  编辑页面
	 */
	public String toSave(){
		return SUCCESS;
	}
	/**
	 *  上传页面
	 */
	public String toUpload(){
		return SUCCESS;
	}
	/**
	 * 更新|保存 
	 */
	public String save(){
		this.getJsonMap().put("s", 0);
		return "json-save";
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
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	
	
}
