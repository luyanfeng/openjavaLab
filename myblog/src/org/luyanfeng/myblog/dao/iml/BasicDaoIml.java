package org.luyanfeng.myblog.dao.iml;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.util.GenericUtil;

@SuppressWarnings("unchecked")
public abstract  class BasicDaoIml<T>  implements BasicDao<T> {
	
	private SessionFactory sf;
	private Session session;
	protected Session getSession() {
		if(this.session == null || !this.session.isOpen()){
			this.session = sf.getCurrentSession();
		}
		return session;
	}
	protected SessionFactory getSf() {
		return sf;
	}
	/**
	 *  注入sessionfectory 时一最好super.setSf(sf)下，不然BasicDaoIml下的方法将不能用。
	 */
	protected void setSf(SessionFactory sf){
		this.sf = sf;
	}


	protected Class<T> getEntity() {
		return  (Class<T>) GenericUtil.getGenericClass(getClass());
	}
	

	@Override
	public T getOne(String id) {
		T t = (T) this.getSession().get(this.getEntity().getSimpleName(), id);
		return t;
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
			this.getSession().delete(this.getEntity().getSimpleName(),this.getEntity());
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addOne(T entity) {
		Serializable save = this.getSession().save(entity);
		return save != null ;
	}

	@Override
	public boolean saveAll(T... entities) {
		boolean result = true;
		try {
			for (T t : entities) {
				this.getSession().saveOrUpdate(t);
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<T> getPage(final int skip, final int limit) {
		return this.getSession().createQuery("from "+getEntity().getSimpleName()).setMaxResults(limit).setFirstResult(skip).list();
	}


}
