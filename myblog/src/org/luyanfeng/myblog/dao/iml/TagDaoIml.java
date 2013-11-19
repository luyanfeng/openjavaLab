package org.luyanfeng.myblog.dao.iml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("tagDaoIml")
public class TagDaoIml extends BasicDaoIml<TagEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}

	/**
	 *  反回没有更新的数据
	 */
	public List<Serializable> saveByNames( ArticleEntity article, String... tags) throws Exception {
		try {
			List<Serializable> result = new ArrayList<>();
			for (String name : tags) {
				Query hql = this.getSession().createQuery("from "+this.getEntity().getSimpleName()+" where name=:name" )
						.setString("name", name);
						;
				int executeHql = hql.list().size();
				if(executeHql <= 0 ){
					TagEntity tag = new TagEntity();
					tag.setId(GenericUtil.getRandomId());
					tag.setHidden(false);
					tag.setTime(new Date());
					if(article != null){
						tag.getArticles().add(article);
					}
					this.getSession().merge(tag);
				}
			}
			return result;
		} catch (Exception e) {
			throw new Exception("### saveOrUpdateByNames() 方法出错！"+this.getEntity().getName(),e);
		}
	}

	public List<? extends TagEntity> getByAId(String articleid) throws Exception {
		try {
			List list = this
					.getSession()
					.createSQLQuery(
							"select t.* from bl_article_type as a, bl_type as t where a.article_id=:articleid and a.type_id=t.id ")
					.addEntity(TagEntity.class)
					.setString("articleid", articleid).list();
			return list;
		} catch (Exception e) {
			throw new Exception("### getByAId() 方法出错！"+this.getClass().getName(),e);
		}
	}

	
	public List<ArticleEntity> getArticles(String tagid) {
		List list = this.getSession().createSQLQuery(" select a.* from bl_article_tag as at,bl_article as a, bl_tag as t where t.id=at.tag_id and at.article_id=a.id and t.id=:tagid")
		.addEntity(ArticleEntity.class)
		.setString("tagid", tagid)
		.list()
		;
		return list;
	}

	/**
	 *  得到所有分类，根据 参数 withSubClass ：true时查分类文章集合。
	 */
	public List<TagEntity> getAll(boolean withSubClass) throws Exception {
		List<TagEntity> all = super.getAll();
		for(TagEntity tag : all){
			List list = this.getSession().createSQLQuery("select * from bl_article_tag as at , bl_article as a where a.id=at.article_id and at.tag_id = :tagid")
			.addEntity(ArticleEntity.class)
			.setString("tagid", tag.getId())
			.list();
			tag.setArticles(list);
		}
		return all;
	}

}
