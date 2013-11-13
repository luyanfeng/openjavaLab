package org.luyanfeng.myblog.service.iml;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.springframework.stereotype.Repository;

/**
 * 类型service
 * @author luyanfeng
 *
 */
@Repository("typeServcieIml")
public class TypeServcieIml extends BasicServiceIml<TypeEntity> {

	@Resource(name="typeDaoIml")
	@Override
	public void setDao(BasicDao<TypeEntity> dao) {
		super.setDao(dao);
	}

	
}
