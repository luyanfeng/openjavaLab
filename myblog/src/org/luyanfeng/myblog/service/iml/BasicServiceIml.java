package org.luyanfeng.myblog.service.iml;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.service.BasicService;

public class BasicServiceIml<T> implements BasicService<T> {

	private BasicDao<T> dao;

	public BasicDao<T> getDao() {
		return dao;
	}
	public void setDao(BasicDao<T> dao) {
		System.out.println("basicDao init.....");
		this.dao = dao;
	}

	@Override
	public T getOne(String id) throws Exception {
		return this.dao.getOne(id);
	}

	@Override
	public List<T> getSome(String... ids) {
		return this.dao.getSome(ids);
	}
	@Override
	public List<T> getPage(int skip, int limit, LinkedHashMap<String, Integer> sortMap ) throws Exception {
		return this.dao.getPage(skip, limit, sortMap);
	}

	@Override
	public boolean delSome(String... ids) throws Exception {
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
	@Override
	public Integer executeHql(String hql, Map<String, Serializable> parameters) throws Exception {
		return this.dao.executeHql(hql, parameters);
	}
	@Override
	public Integer executeLocalHql(String hql, Map<String, Serializable> parameters) throws Exception {
		return this.dao.executeLocalHql(hql, parameters);
	}

}
