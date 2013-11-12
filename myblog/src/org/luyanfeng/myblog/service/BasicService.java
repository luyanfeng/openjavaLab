package org.luyanfeng.myblog.service;

import java.util.List;

public interface BasicService<T> {
	
	public T getOne(String id) throws Exception;
	
	public List<T> getSome(String... ids);
	
	public boolean delSome(String ... ids) throws Exception;
	
	public boolean addOne(T t);
	
	public boolean saveAll(T... entity);
	
	public List<T> getPage(int skip, int limit ) throws Exception; 
	
	
}
