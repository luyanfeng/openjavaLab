package org.luyanfeng.myblog.service.iml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.dao.iml.TagDaoIml;
import org.luyanfeng.myblog.dao.iml.TypeDaoIml;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.util.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("articleServiceIml")
public class ArticleServiceIml extends BasicServiceIml<ArticleEntity> {

	@Resource(name="articleDaoIml")
	@Override
	public void setDao(BasicDao<ArticleEntity> dao) {
		super.setDao(dao);
	}
	@Autowired
	private TypeDaoIml typeDao;
	@Autowired
	private TagDaoIml tagDao;
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
				if (StringUtils.isNotBlank(tags)) {
					String[] tagArray = tags.split(",");
					List<Serializable> newTags = this.tagDao.saveOrUpdateByNames(tagArray);
					model.setTagList((List<TagEntity>) this.generateTags(newTags));
				}
				String types = model.getTypes();
				if (StringUtils.isNotBlank(types)) {
					String[] typeArray = types.split(",");
					List<Serializable> newTypes = this.typeDao.saveOrUpdateByNames(typeArray);
					model.setTypeList((List<TypeEntity>) this.generateTypes(newTypes));
				}
				
			}
			return this.getDao().saveAll(models);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	/**
	 *	封装类型 
	 */
	private List<? extends Serializable> generateTypes(List<Serializable> newTypes) throws Exception {
		List<TypeEntity> types = new ArrayList<>();
		for(Serializable name : newTypes){
			TypeEntity typeEntity = new TypeEntity();
			{
				typeEntity.setId(GenericUtil.getRandomId());
				typeEntity.setHidden(false);
				typeEntity.setName(((String) name).trim());
				typeEntity.setQuantity(1);
				typeEntity.setTime(new Date());
			}
			types.add(typeEntity);
		}
		return types;
	}
	/**
	 *	封装标签 
	 */
	private List<? extends Serializable> generateTags(List<Serializable> newTags) throws Exception {
		List<TagEntity> tags = new ArrayList<>();
		for(Serializable name : newTags){
			TagEntity tagEntity = new TagEntity();
			{
				tagEntity.setId(GenericUtil.getRandomId());
				tagEntity.setHidden(false);
				tagEntity.setName(((String) name).trim()); // 有危险
				tagEntity.setQuantity(1);
				tagEntity.setTime(new Date());
			}
			tags.add( tagEntity );
		}
		return tags;
	}
	
	public List<ArticleEntity> getByType(int skip,int limit,String typeid)throws Exception {
		TypeEntity one = this.typeDao.getOne(typeid);
		List<ArticleEntity> articles = one.getArticles();
		return articles;
	}


}
