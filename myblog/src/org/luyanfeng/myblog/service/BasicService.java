package org.luyanfeng.myblog.service;

import java.util.List;

public interface BasicService<T> {
	
	public T getOne(String id);
	
	public List<T> getSome(String... ids);
	
	public boolean delSome(String ... ids);
	
	public boolean addOne(T t);
	
	public boolean saveAll(T... entity);
	
	public List<T> getPage(int skip, int limit ); 
	
	
}
