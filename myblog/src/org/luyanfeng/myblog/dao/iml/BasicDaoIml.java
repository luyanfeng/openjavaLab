package org.luyanfeng.myblog.dao.iml;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

public  class BasicDaoIml<T> extends HibernateDaoSupport implements BasicDao<T> {
	
	protected Class<T> getT() {
		return  (Class<T>) GenericUtil.getGenericClass(getClass());
	}

	@Override
	public T getOne(String id) {
		return (T) this.getHibernateTemplate().get(this.getT().getSimpleName(), id);
	}

	@Deprecated
	@Override
	public List<T> getSome(String... ids) {
//		this.getHibernateTemplate().find("from "+this.getT().getSimpleName()+" as t where t.id in()", value);
		return null;
	}

	@Override
	public boolean delSome(String... ids) {
		boolean result = true;
		try {
			this.getHibernateTemplate().delete(this.getT().getSimpleName(),this.getT());
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addOne(T entity) {
		Serializable save = this.getHibernateTemplate().save(entity);
		return save != null ;
	}

	@Override
	public boolean saveAll(T... entities) {
		boolean result = true;
		try {
			for (T t : entities) {
				this.getHibernateTemplate().saveOrUpdate(t);
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<T> getPage(final int skip, final int limit) {
		HibernateCallback<List<T>> action = new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("from "+getT().getSimpleName()).setMaxResults(limit).setFirstResult(skip).list();
			}
		};
		return this.getHibernateTemplate().execute(action  );
	}


}
