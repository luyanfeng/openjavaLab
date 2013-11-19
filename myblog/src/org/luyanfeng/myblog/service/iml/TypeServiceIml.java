package org.luyanfeng.myblog.service.iml;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.dao.iml.TypeDaoIml;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 类型service
 * @author luyanfeng
 *
 */
@Repository("typeServiceIml")
public class TypeServiceIml extends BasicServiceIml<TypeEntity> {

	@Resource(name="typeDaoIml")
	@Override
	public void setDao(BasicDao<TypeEntity> dao) {
		super.setDao(dao);
	}

	@Autowired
	private ArticleServiceIml articleServiceIml;
	
	public List<? extends TypeEntity> getByAId(String articleid) {
		TypeDaoIml typeDao = (TypeDaoIml) this.getDao();
		return typeDao.getByAId(articleid);
	}

	/**
	 * 得到所有分类，根据 参数 withSubClass ：true时查分类文章集合。
	 */
	public List<TypeEntity> getAll(boolean withSubClass) throws Exception {
		TypeDaoIml typeDao = (TypeDaoIml) this.getDao();
		List<TypeEntity> all = typeDao.getAll(withSubClass);
		// 未分类的
		TypeEntity uname = new TypeEntity();
		uname.setName("所有文章");
		uname.setArticles(this.articleServiceIml.getAll());
		if(all != null && withSubClass){
			all.add(0, uname);
		}else{
			all = new ArrayList<>();
			all.add(uname);
		}
		return all;
	}

	
}
