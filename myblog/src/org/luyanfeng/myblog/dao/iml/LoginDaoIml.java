package org.luyanfeng.myblog.dao.iml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.luyanfeng.myblog.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginDaoIml")
@SuppressWarnings("unchecked")
public class LoginDaoIml extends BasicDaoIml<UserEntity> {

	@Autowired
	@Override
	protected void setSf(SessionFactory sf) {
		try {
			super.setSf(sf);
		} catch (Exception e) {
			throw new RuntimeException("注入sessionFactory时出现了错误",e);
		}
	}
	/**
	 * 用户是否已登陆 
	 */
	public boolean isLogin(){
		return false;
	}
	//TODO 1234
	/**
	 * 得到一个注册用户
	 */
	public UserEntity getUser(String user, String passwd, String email){
		try {
			Session session2 = this.getSession();
			List<UserEntity> list = session2
					.createQuery(
							"from "+this.getEntity().getSimpleName()+" as u WHERE u.user = ? AND u.email = ? AND u.passwd = ? ")
					.setString(0, user)
					.setString(1, email)
					.setString(2, passwd).list();
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("＃＃＃ getUser（）方式出现了错误",e);
		}
	}
	/**
	 * 用户是否可以登陆 
	 */
	public boolean shouldLogin(String user, String passwd, String email){
		try {
			UserEntity user2 = this.getUser(user, passwd, email);
			System.out.println(user2);
			return user2 != null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("＃＃＃ shooudLogin() 方法出现了错误",e);
		}
		
	}
}
