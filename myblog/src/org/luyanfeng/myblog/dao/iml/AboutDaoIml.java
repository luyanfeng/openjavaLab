package org.luyanfeng.myblog.dao.iml;

import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.AboutEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("aboutDaoIml")
public class AboutDaoIml extends BasicDaoIml<AboutEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		super.setSf(sf);
	}
}
