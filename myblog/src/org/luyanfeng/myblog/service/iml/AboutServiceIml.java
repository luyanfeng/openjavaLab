package org.luyanfeng.myblog.service.iml;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.AboutEntity;
import org.springframework.stereotype.Service;

@Service("aboutServiceIml")
public class AboutServiceIml extends BasicServiceIml<AboutEntity> {

	@Resource(name="aboutDaoIml")
	@Override
	public void setDao(BasicDao<AboutEntity> dao) {
		super.setDao(dao);
	}

}
