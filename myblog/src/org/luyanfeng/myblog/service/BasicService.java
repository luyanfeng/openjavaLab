package org.luyanfeng.myblog.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.luyanfeng.myblog.entity.TypeEntity;

public interface BasicService<T> {
	
	public T getOne(String id) throws Exception;
	
	public List<T> getSome(String... ids);
	
	public List<TypeEntity> getAll()throws Exception;
	
	public boolean delSome(String ... ids) throws Exception;
	
	public boolean addOne(T t);
	
	public boolean saveAll(T... entity) throws Exception;
	
	List<T> getPage(int skip, int limit, LinkedHashMap<String, Integer> sortMap) throws Exception;

	Integer executeHql(String hql, Map<String, Serializable> parameters) throws Exception;
	
	// 本地sql接口，一般少用
	Integer executeLocalHql(String sql, Map<String, Serializable> parameters) throws Exception;

}
