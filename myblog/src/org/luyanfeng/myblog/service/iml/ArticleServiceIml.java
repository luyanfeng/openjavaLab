package org.luyanfeng.myblog.service.iml;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.dao.iml.ArticleDaoIml;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.springframework.stereotype.Service;

@Service("articleServiceIml")
public class ArticleServiceIml extends BasicServiceIml<ArticleEntity> {

	@Resource(name="articleDaoIml")
	@Override
	public void setDao(BasicDao<ArticleEntity> dao) {
		super.setDao(dao);
	}
	/**
	 *  保存文章同时处理分类和标签
	 */
	public boolean saveArticles(ArticleEntity... models) throws Exception {
		if(models == null || models.length <= 0){
			return false;
		}
		try {
			for(ArticleEntity model : models){
				String tags = model.getTags();
				ArticleDaoIml articleDao = (ArticleDaoIml) this.getDao();
				if (StringUtils.isNotBlank(tags)) {
					String[] tagArray = tags.split(",");
//					List<Serializable> newTags = this.updateFilterResult(model.getId(),tagArray);
					articleDao.updateTagsRelationByTagNames(model.getId(),tagArray);
				}
				String types = model.getTypes();
				if (StringUtils.isNotBlank(types)) {
					String[] typeArray = types.split(",");
					articleDao.updateTypesRelationByTagNames(model.getId(),typeArray);
				}
			}
			return this.getDao().saveAll(models);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	public List<ArticleEntity> getByType(int skip,int limit,String typeid)throws Exception {
		ArticleDaoIml articleDao = (ArticleDaoIml) this.getDao();
		return articleDao.getByType(skip,limit,typeid);
	}

}
