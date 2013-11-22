package org.luyanfeng.myblog.dao.iml;

import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("imageDaoIml")
public class ImageDaoIml extends BasicDaoIml<ImageEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}

}
