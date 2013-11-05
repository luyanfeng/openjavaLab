package org.luyanfeng.myblog.dao;

import java.util.List;

public interface BasicDao<T> {

	
	public T getOne(String id);
	
	@Deprecated
	public List<T> getSome(String... ids);
	
	public boolean delSome(String... ids);
	
	public boolean addOne(T entity);
	
	public boolean saveAll(T...entities);

	public List<T> getPage(int skip, int limit);
}
