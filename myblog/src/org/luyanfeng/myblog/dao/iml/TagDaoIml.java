package org.luyanfeng.myblog.dao.iml;

import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tagDaoIml")
public class TagDaoIml extends BasicDaoIml<TagEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}
}
