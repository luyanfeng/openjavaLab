package org.luyanfeng.myblog.dao.iml;

import java.util.List;

import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("articleDaoIml")
public class ArticleDaoIml extends BasicDaoIml<ArticleEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}

}
