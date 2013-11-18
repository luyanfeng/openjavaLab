package org.luyanfeng.myblog.service.iml;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.ArticleEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
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

	/**
	 * 得到类型及内容
	 * @param tyid
	 */
	public Map<String , Object> getOneWithContents(String tyid) {
		
		return null;
	}

}
