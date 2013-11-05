package org.luyanfeng.myblog.dao.iml;

import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("articleDaoIml")
public class ArticleDaoIml extends BasicDaoIml<ArticleEntity> {

	@Autowired
	public void setSF(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	
}
