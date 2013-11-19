package org.luyanfeng.myblog.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.luyanfeng.myblog.entity.TypeEntity;

public interface BasicDao<T> {

	
	public T getOne(String id) throws Exception;
	
	@Deprecated
	public List<T> getSome(String... ids);
	
	public boolean delSome(String... ids) throws Exception;
	
	public boolean addOne(T entity);
	
	public boolean saveAll(T...entities) throws Exception;

	/**
	 * 分页查询
	 * @param skip 查询开始行号
	 * @param limit 设定反回查询的数量
	 * @param sortMap 排序Map
	 * @param tyid 
	 */
	public List<T> getPage(int skip, int limit, LinkedHashMap<String, Integer> sortMap, Map<String,Object> whereMap) throws Exception;

	/**
	 *  hibernate hql 写操作
	 */
	Integer executeHql(String hql, Map<String, Serializable> parameters) throws Exception;
	/**
	 *  本地 sql 操作
	 */
	public Integer executeLocalHql(String hql, Map<String, Serializable> parameters) throws Exception;

	/**
	 * 得到所有 --- 一般数量不是很多的表可以用
	 */
	public List<T> getAll()throws Exception;

}
