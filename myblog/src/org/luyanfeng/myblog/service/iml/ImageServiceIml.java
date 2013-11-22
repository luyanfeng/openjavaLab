package org.luyanfeng.myblog.service.iml;

import javax.annotation.Resource;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.ImageEntity;
import org.springframework.stereotype.Service;

@Service("imageServiceIml")
public class ImageServiceIml extends BasicServiceIml<ImageEntity> {

	@Resource(name="imageDaoIml")
	@Override
	public void setDao(BasicDao<ImageEntity> dao) {
		super.setDao(dao);
	}
}
