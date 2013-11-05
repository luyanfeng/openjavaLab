package org.luyanfeng.myblog.service.iml;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.springframework.stereotype.Service;

@Service("articleServiceIml")
public class ArticleServiceIml extends BasicServiceIml<ArticleEntity> {

	
	
	@Resource(name="articleDaoIml")
	private BasicDao<ArticleEntity> dao;

}
