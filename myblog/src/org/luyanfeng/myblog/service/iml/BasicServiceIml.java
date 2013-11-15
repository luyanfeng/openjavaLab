package org.luyanfeng.myblog.service.iml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.luyanfeng.myblog.dao.BasicDao;
import org.luyanfeng.myblog.entity.TagEntity;
import org.luyanfeng.myblog.entity.TypeEntity;
import org.luyanfeng.myblog.service.BasicService;
import org.luyanfeng.myblog.util.GenericUtil;

public class BasicServiceIml<T> implements BasicService<T> {

	private BasicDao<T> dao;

	public BasicDao<T> getDao() {
		return dao;
	}
	public void setDao(BasicDao<T> dao) {
		System.out.println("basicDao init.....");
		this.dao = dao;
	}

	@Override
	public T getOne(String id) throws Exception {
		return this.dao.getOne(id);
	}

	@Override
	public List<T> getSome(String... ids) {
		return this.dao.getSome(ids);
	}
	@Override
	public List<T> getPage(int skip, int limit, LinkedHashMap<String, Integer> sortMap ) throws Exception {
		return this.dao.getPage(skip, limit, sortMap);
	}

	@Override
	public boolean delSome(String... ids) throws Exception {
		return this.dao.delSome(ids);
	}

	@Override
	public boolean addOne(T t) {
		return this.dao.addOne(t);
	}

	@Override
	public boolean saveAll(T... entity) throws Exception {
		try {
			return this.dao.saveAll(entity);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	/**
	 *	保存类型 
	 * @throws Exception 
	 */
	private List<? extends Serializable> generateTypes(String[] typeArray) throws Exception {
		List<TypeEntity> types = new ArrayList<>();
		for(int i = 0 ; i < typeArray.length ; i++){
			String name = typeArray[i];
			TypeEntity typeEntity = new TypeEntity();
			{
				typeEntity.setId(GenericUtil.getRandomId());
				typeEntity.setHidden(false);
				typeEntity.setName(name.trim());
				typeEntity.setQuantity(1);
				typeEntity.setTime(new Date());
			}
			types.add(typeEntity);
		}
		return types;
	}
	/**
	 *	保存标签 
	 * @throws Exception 
	 */
	private List<? extends Serializable> generateTags(String[] tagArray) throws Exception {
		List<TagEntity> tags = new ArrayList<>();
		for(int i = 0 ; i < tagArray.length ; i++){
			String name = tagArray[i];
			TagEntity tagEntity = new TagEntity();
			{
				tagEntity.setId(GenericUtil.getRandomId());
				tagEntity.setHidden(false);
				tagEntity.setName(name.trim());
				tagEntity.setQuantity(1);
				tagEntity.setTime(new Date());
			}
			tags.add( tagEntity );
		}
		return tags;
	}
	@Override
	public Integer executeHql(String hql, Map<String, Serializable> parameters) throws Exception {
		return this.dao.executeHql(hql, parameters);
	}
	@Override
	public Integer executeLocalHql(String hql, Map<String, Serializable> parameters) throws Exception {
		return this.dao.executeLocalHql(hql, parameters);
	}
	@Override
	public List<TypeEntity> getAll() throws Exception {
		return this.getDao().getAll();
	}

}
