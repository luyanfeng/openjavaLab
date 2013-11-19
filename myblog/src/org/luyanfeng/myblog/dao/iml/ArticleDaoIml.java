package org.luyanfeng.myblog.dao.iml;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("articleDaoIml")
public class ArticleDaoIml extends BasicDaoIml<ArticleEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}

	@SuppressWarnings("unchecked")
	public List<TagEntity> getTagsRelationByAId(String articleid) throws Exception {
		List<TagEntity> list = null;
		try {
			list = this
					.getSession()
					.createSQLQuery(
							"select article_id,tag_id from bl_article_tag where article_id=:articleid")
					.setString("articleid", articleid).list();
		} catch (Exception e) {
			throw new Exception(" ### getTagsRelationByAId() 方法出错！"+this.getClass().getName(),e);
		}
		return list;
	}

	/**
	 *  通过文章id删除标签关系
	 */
	public int delTagsRelationByAId(String articleid) throws Exception{
		int executeUpdate = 0;
		try {
			executeUpdate = this
					.getSession()
					.createSQLQuery(
							"delete from  bl_article_tag where article_id=:articleid ")
					.setString("articleid", articleid).executeUpdate();
		} catch (Exception e) {
			throw new Exception(" ### delTagsRelationByAId() 方法出错！"+this.getClass().getName(),e);
		}
		return executeUpdate;
	}

	/**
	 * 标签存在就更新关系，否则就新加标签并更新关系
	 */
	public void updateTagsRelationByTagNames(String articleid, String[] tagArray) throws Exception {
		if(tagArray != null && tagArray.length > 0){
			Session session = this.getSession();
			
			this.getSession().createSQLQuery("delete from  bl_article_tag where article_id=:articleid ")
					.setString("articleid", articleid).executeUpdate();
			for(String name : tagArray){
				TagEntity r = (TagEntity) session.createSQLQuery("select * from bl_tag where name = :name").addEntity(TagEntity.class).setString("name", name).uniqueResult();
				String tagid = null;
				if(r != null){
					// 保存标签关系
					tagid = (String) r.getId();
				}else{
					tagid = GenericUtil.getRandomId();
					int update = session.createSQLQuery(" insert into bl_tag(`id`, `isHidden`, `name`, `time`) values(:id,:isHidden,:name,:time)")
										.setString("id",tagid )
										.setBoolean("isHidden", false)
										.setString("name", name)
										.setDate("time", new Date())
										.executeUpdate()
										;
					if(update < 1){
						throw new Exception("保存 新标签关系 失败");
					}
				}
				// 保存标签关系
				int update = session.createSQLQuery(" insert into bl_article_tag(id,article_id,tag_id) values(:uuid,:articleid,:tagid)")
						.setString("uuid", GenericUtil.getRandomId())
						.setString("articleid", articleid)
						.setString("tagid", tagid)
						.executeUpdate()
						;
				if(update < 1){
					throw new Exception("保存 新标签关系 失败");
				}
			}
		}
	}
	/**
	 * 分类存在就更新关系，否则就新加分类并更新关系
	 */
	public void updateTypesRelationByTagNames(String articleid, String[] typeArray) throws Exception {
		if(typeArray != null && typeArray.length > 0){
			Session session = this.getSession();
			
			this.getSession().createSQLQuery("delete from  bl_article_type where article_id=:articleid ").setString("articleid", articleid).executeUpdate();
			for(String name : typeArray){
				TypeEntity r = (TypeEntity) session.createSQLQuery("select * from bl_type where name = :name").addEntity(TypeEntity.class).setString("name", name).uniqueResult();
				String typeid = null;
				if(r != null){
					// 保存标签关系
					typeid  = (String) r.getId();
				}else{
					typeid = GenericUtil.getRandomId();
					int update = session.createSQLQuery(" insert into bl_type(`id`, `isHidden`, `name`, `time`) values(:id,:isHidden,:name,:time)")
							.setString("id",typeid )
							.setBoolean("isHidden", false)
							.setString("name", name)
							.setDate("time", new Date())
							.executeUpdate()
							;
					if(update < 1){
						throw new Exception("保存 新分类关系 失败");
					}
				}
				// 保存标签关系
				int update = session.createSQLQuery(" insert into bl_article_type(id,article_id,type_id) values(:uuid,:articleid,:typeid)")
						.setString("uuid", GenericUtil.getRandomId())
						.setString("articleid", articleid)
						.setString("typeid", typeid)
						.executeUpdate()
						;
				if(update < 1){
					throw new Exception("保存 新分类关系 失败");
				}
			}
		}
	}

	/**
	 *  通过分类id得到文章列表 分页
	 */
	public List<ArticleEntity> getByType(int skip, int limit, String typeid) {
		@SuppressWarnings("unchecked")
		List<ArticleEntity> list = this.getSession().createSQLQuery(" select a.* from bl_article_type as at, bl_article as a where at.article_id=a.id and at.type_id=:typeid")
		.addEntity(ArticleEntity.class).setString("typeid", typeid)
		.list()
		;
		return list;
	}

}
