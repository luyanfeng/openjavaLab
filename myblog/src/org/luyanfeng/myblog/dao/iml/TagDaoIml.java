package org.luyanfeng.myblog.dao.iml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 *  反回没有更新的数据
	 */
	public List<Serializable> saveOrUpdateByNames(String... tags) throws Exception {
		try {
			Map<String, Serializable> parameters = new HashMap<>();
			List<Serializable> result = new ArrayList<>();
			for (String name : tags) {
				System.out.println("name: "+name);
				parameters.put("name", name);
				Integer count = this.executeHql(
						"UPDATE " + TagEntity.class.getSimpleName()
								+ " SET quantity=quantity+1 WHERE name=:name",
						parameters);
				if (count == null || count <= 0) {
					result.add(name);
				}
			}
			return result;
		} catch (Exception e) {
			throw new Exception("### saveOrUpdateByNames() 方法出错！",e);
		}
	}
}
