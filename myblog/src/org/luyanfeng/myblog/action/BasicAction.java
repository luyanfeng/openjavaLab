package org.luyanfeng.myblog.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<? extends Serializable> list = new ArrayList<>();
	private LinkedHashMap<String, Integer> sortMap= new LinkedHashMap<>();
	private LinkedHashMap<String,Object> whereMap = new LinkedHashMap<>();
	// json Map results
	private Map<String,Object> jsonMap = new LinkedHashMap<>();
	
	public List<? extends Serializable> getList() {
		return list;
	}
	public void setList(List<? extends Serializable> list) {
		this.list = list;
	}
	public LinkedHashMap<String, Integer> getSortMap() {
		return sortMap;
	}
	public void setSortMap(LinkedHashMap<String, Integer> sortMap) {
		this.sortMap = sortMap;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public LinkedHashMap<String, Object> getWhereMap() {
		return whereMap;
	}
	public void setWhereMap(LinkedHashMap<String, Object> whereMap) {
		this.whereMap = whereMap;
	}
	
}
