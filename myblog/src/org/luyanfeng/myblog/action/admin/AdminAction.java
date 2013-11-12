package org.luyanfeng.myblog.action.admin;

import java.util.LinkedHashMap;
import java.util.Map;

import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.UserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends BasicAction<UserEntity>{
	private static final long serialVersionUID = 1L;
	private Map<String,Object> jsonMap = new LinkedHashMap<>();;
	
	/** 导航 后期做成枚举*/
	private String nav;
	/**
	 * 首页
	 */
	public String index(){
		return "index";
	}
	/**
	 * 退出系统
	 */
	public String quit(){
		try {
			this.getRequest().getSession(false).invalidate();
			this.getJsonMap().put("s", 1);
		} catch (Exception e) {
			this.getJsonMap().put("s", 0);
			this.addActionError("退出系统操作出错！");
		}
		return "json-quit";
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
