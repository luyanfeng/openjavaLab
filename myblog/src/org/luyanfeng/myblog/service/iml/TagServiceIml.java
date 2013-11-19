package org.luyanfeng.myblog.service.iml;

import java.util.List;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.dao.iml.TagDaoIml;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TagEntity;
import org.springframework.stereotype.Repository;

/**
 * 类型service
 * @author luyanfeng
 *
 */
@Repository("tagServiceIml")
public class TagServiceIml extends BasicServiceIml<TagEntity> {

	@Resource(name="tagDaoIml")
	@Override
	public void setDao(BasicDao<TagEntity> dao) {
		super.setDao(dao);
	}

	public List<? extends TagEntity> getByAId(String articleid) throws Exception {
		TagDaoIml tagDao = (TagDaoIml) this.getDao();
		return tagDao.getByAId(articleid);
	}

	/**
	 *  通过标签id得到已关联到的文章
	 */
	public List<ArticleEntity> getArticles(String tagid)  throws Exception{
		TagDaoIml tagDao = (TagDaoIml) this.getDao();
		return tagDao.getArticles(tagid);
	}

	/**
	 * 得到所有分类，根据 参数 withSubClass ：true时查分类文章集合。
	 */
	public List<TagEntity> getAll(boolean withSubClass) throws Exception {
		TagDaoIml tagDao = (TagDaoIml) this.getDao();
		return tagDao.getAll(withSubClass);
	}
	
}
