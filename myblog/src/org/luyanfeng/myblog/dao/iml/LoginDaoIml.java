package org.luyanfeng.myblog.dao.iml;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("loginDaoIml")
public class LoginDaoIml extends BasicDaoIml<UserEntity> {

	@Autowired
	public void setSF(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 用户是否已登陆 
	 */
	public boolean isLogin(){
		return false;
	}
	/**
	 * 得到一个注册用户
	 */
	public UserEntity getUser(final String user, final String passwd, final String email){
		HibernateCallback<UserEntity> action = new HibernateCallback<UserEntity>() {
			@SuppressWarnings("unchecked")
			@Override
			public UserEntity doInHibernate(Session session) throws HibernateException,
					SQLException {
				List<UserEntity> list = session.createQuery("from bl_user as u WHERE u.user = :? AND u.email = :? AND u.passwd = :? ")
										.setString(0, user).setString(1, passwd).setString(2, email)
										.list();
				if(list != null && !list.isEmpty()){
					return list.get(0);
				}
				return null;
			}
		};
		return this.getHibernateTemplate().execute(action );
	}
	/**
	 * 用户是否可以登陆 
	 */
	public boolean shouldLogin(final String user, final String passwd, final String email){
		UserEntity user2 = this.getUser(user, passwd, email);
		return user2 != null ;
		
	}
	
}
