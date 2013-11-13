package org.luyanfeng.myblog.service.iml;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.TagEntity;
import org.springframework.stereotype.Repository;

/**
 * 类型service
 * @author luyanfeng
 *
 */
@Repository("tagServcieIml")
public class TagServcieIml extends BasicServiceIml<TagEntity> {

	@Resource(name="tagDaoIml")
	@Override
	public void setDao(BasicDao<TagEntity> dao) {
		super.setDao(dao);
	}

	
}
