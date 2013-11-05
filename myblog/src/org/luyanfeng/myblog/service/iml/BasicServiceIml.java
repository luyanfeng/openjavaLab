package org.luyanfeng.myblog.service.iml;

import java.util.List;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.service.BasicService;

public class BasicServiceIml<T> implements BasicService<T> {

	protected BasicDao<T> dao;


	@Override
	public T getOne(String id) {
		return this.dao.getOne(id);
	}

	@Override
	public List<T> getSome(String... ids) {
		return this.dao.getSome(ids);
	}
	@Override
	public List<T> getPage(int skip, int limit ) {
		return this.dao.getPage(skip,limit);
	}

	@Override
	public boolean delSome(String... ids) {
		return this.dao.delSome(ids);
	}

	@Override
	public boolean addOne(T t) {
		return this.dao.addOne(t);
	}

	@Override
	public boolean saveAll(T... entity) {
		return this.dao.saveAll(entity);
	}

}
