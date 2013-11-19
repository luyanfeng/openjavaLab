package org.luyanfeng.myblog.dao.iml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("typeDaoIml")
public class TypeDaoIml extends BasicDaoIml<TypeEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}
	/**
	 *  反回没有更新的数据
	 */
	public List<Serializable> saveOrUpdateByNames(String... types) throws Exception {
		try {
			Map<String, Serializable> parameters = new HashMap<>();
			List<Serializable> result = new ArrayList<>();
			for (String name : types) {
				parameters.put("name", name);
				Integer count = this.executeLocalHql(
						"UPDATE bl_type SET quantity=quantity+1 WHERE name=:name",
						parameters);
				if (count == null || count <= 0) {
					result.add(name);
				}
			}
			return result;
		} catch (Exception e) {
			throw new Exception("### saveOrUpdateByNames() 方法出错！",e);
		}
	}
	public List<? extends TypeEntity> getByAId(String articleid) {
		List list = this.getSession().createSQLQuery("select t.* from bl_article_type as a, bl_type as t where a.article_id=:articleid and a.type_id=t.id ")
		.addEntity(TypeEntity.class)
		.setString("articleid", articleid)
		.list()
		;
		return list;
	}
	/**
	 *  得到所有分类，根据 参数 withSubClass ：true时查分类文章集合。
	 */
	public List<TypeEntity> getAll(boolean withSubClass) throws Exception {
		List<TypeEntity> all = super.getAll();
		if(all != null){
			for(TypeEntity type : all){
				List list = this.getSession().createSQLQuery("select * from bl_article_type as at , bl_article as a where a.id=at.article_id and at.type_id = :typeid")
						.addEntity(ArticleEntity.class)
						.setString("typeid", type.getId())
						.list();
				type.setArticles(list);
			}
		}
		return all;
	}
	
	
}
