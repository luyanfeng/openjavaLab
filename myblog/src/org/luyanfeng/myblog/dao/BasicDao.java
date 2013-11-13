package org.luyanfeng.myblog.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface BasicDao<T> {

	
	public T getOne(String id) throws Exception;
	
	@Deprecated
	public List<T> getSome(String... ids);
	
	public boolean delSome(String... ids) throws Exception;
	
	public boolean addOne(T entity);
	
	public boolean saveAll(T...entities);

	public List<T> getPage(int skip, int limit, LinkedHashMap<String, Integer> sortMap) throws Exception;

	/**
	 *  hibernate hql 写操作
	 */
	Integer executeHql(String hql, Map<String, Serializable> parameters) throws Exception;
	/**
	 *  本地 sql 操作
	 * @throws Exception 
	 */
	public Integer executeLocalHql(String hql, Map<String, Serializable> parameters) throws Exception;

}
