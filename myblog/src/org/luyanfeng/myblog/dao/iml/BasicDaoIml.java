package org.luyanfeng.myblog.dao.iml;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.TypeEntity;
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
	public T getOne(String id) throws Exception {
		try {
			T t = null;
			if (StringUtils.isNotBlank(id)) {
				t = (T) this.getSession().get(this.getEntity(),	id);
				System.out.println("###############  "+t);
			}
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("### getOne()方法出错！",e);
		}
	}

	@Deprecated
	@Override
	public List<T> getSome(String... ids) {
//		this.getHibernateTemplate().find("from "+this.getT().getSimpleName()+" as t where t.id in()", value);
		return null;
	}

	@Override
	public boolean delSome(String... ids) throws Exception {
		try {
			boolean result = true;
			try {
				for(String id : ids){
					String hql = "delete from "+this.getEntity().getSimpleName()+" as t where t.id = :id ";
					this.getSession().createQuery(hql )
					.setString("id", id)
					.executeUpdate();
				}
			} catch (Exception e) {
				result = false;
				e.printStackTrace();
			}
			return result;
		} catch (Exception e) {
			throw new Exception("### delSome()方法出错！",e);
		}
	}

	@Override
	public boolean addOne(T entity) {
		Serializable save = this.getSession().save(entity);
		return save != null ;
	}

	@Override
	public boolean saveAll(T... entities) throws Exception {
		boolean result = true;
		try {
			for (T t : entities) {
				this.getSession().saveOrUpdate(t);
			}
		} catch (Exception e) {
			result = false;
			throw new Exception("### saveAll()方法出错！",e);
		}
		return result;
	}

	//XXX 这个得改！！！
	@Override
	public List<T> getPage(final int skip, final int limit, LinkedHashMap<String,Integer> sortMap, Map<String,Object> whereMap) throws Exception {
		try {
			String sortstr = "";
			if(sortMap != null && !sortMap.isEmpty()){
				sortstr = " ORDER BY ";
				int tempi = 0;
				for(Map.Entry<String, Integer> sort : sortMap.entrySet()){
					if(tempi != 0){
						sortstr += ",";
					}
					sortstr += sort.getKey()+ ( sort.getValue() == null || sort.getValue() > 0 ? " ASC " : " DESC " );
					tempi++;
				}
			}
			String wherestr = "";
			if(whereMap != null && !whereMap.isEmpty()){
				wherestr = " WHERE ";
				int tempi = 0;
				for(Map.Entry<String, Object> w : whereMap.entrySet()){
					if(tempi != 0){
						wherestr += ",";
					}
					wherestr += w.getKey()+"='"+ w.getValue()+"'";
					tempi++;
				}
			}
			return this.getSession()
					.createQuery("FROM " + getEntity().getSimpleName() + sortstr +wherestr)
					.setMaxResults(limit).setFirstResult(skip)
					.list()
					;
		} catch (Exception e) {
			throw new Exception("### 分页查询getPage()出错！",e);
		}
	}
	@Override
	public Integer executeHql(String hql,Map<String,Serializable> parameters) throws Exception {
		try {
			Query query = this.getSession().createQuery(hql);
			if(parameters != null && !parameters.isEmpty()){
				for(Map.Entry<String, Serializable> p : parameters.entrySet()){
					query.setString(p.getKey(), (String) p.getValue());
				}
			}
			return query.executeUpdate();
		} catch (Exception e) {
			throw new Exception("### HQL执行器出了问题 ！",e);
		}
	}
	@Override
	public Integer executeLocalHql(String sql, Map<String, Serializable> parameters) throws Exception {
		try {
			this.getSession().clear();
			Query query = this.getSession().createSQLQuery(sql);
			if(parameters != null && !parameters.isEmpty()){
				for(Map.Entry<String, Serializable> p : parameters.entrySet()){
					query.setString(p.getKey(),  (String) p.getValue());
				}
			}
			int executeUpdate = query.executeUpdate();
			return executeUpdate;
		} catch (Exception e) {
			throw new Exception("### SQL执行器出了问题 ！",e);
		}
	}
	
	@Override
	public List<TypeEntity> getAll() throws Exception{
		List<TypeEntity> list = this.getSession().createQuery("from "+this.getEntity().getSimpleName()).list();
		return list;
	}


}
