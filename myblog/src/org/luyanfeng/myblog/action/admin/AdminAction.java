package org.luyanfeng.myblog.action.admin;

import java.util.Date;

import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.AboutEntity;
import org.luyanfeng.myblog.service.iml.AboutServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends BasicAction{
	private static final long serialVersionUID = 1L;
	/** 导航 后期做成枚举*/
	private String nav;
	@Autowired
	private AboutServiceIml aboutServiceIml;
	private AboutEntity about = new AboutEntity();
	
	/**
	 * 首页
	 */
	public String index(){
		return "index";
	}
	/**
	 * 关于
	 */
	public String about(){
		this.getRequest().setAttribute("result",this.aboutServiceIml.getLast());
		return "about";
	}
	/**
	 * 保存关于
	 */
	public String saveAbout(){
		try {
			this.getJsonMap().put("s", 0);
			this.getAbout().setId("1");
			this.getAbout().setTime(new Date());
			boolean saveAll = this.aboutServiceIml.saveAll(this.getAbout());
			if(saveAll) this.getJsonMap().put("s", 1);
		} catch (Exception e) {
			this.addActionError("服务器忙，请稍后再试！"+e.getMessage());
			this.getJsonMap().put("s", 0);
			e.printStackTrace();
		}
		return "json-saveAbout";
	}
	
	
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	public AboutEntity getAbout() {
		return about;
	}
	public void setAbout(AboutEntity about) {
		this.about = about;
	}
	
}
