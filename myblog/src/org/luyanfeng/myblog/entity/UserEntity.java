package org.luyanfeng.myblog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="bl_user", uniqueConstraints={@UniqueConstraint(columnNames={"email","user"})})
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 119345666020003942L;
	
	@Id
	private String id;					// 主键
	private String name;                // 妮称
	@Column(nullable=false)             
	private String email;               // 邮箱
	private String user;                // 账号
	private String passwd;              // 密码
	private String info;                // 简介
	@Column(nullable=false)             
	@Temporal(TemporalType.TIMESTAMP)   
	private Date time;                  // 建立时间
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)   
	private Date updateTime;            // 更新时间
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", email=" + email
				+ ", user=" + user + ", passwd=" + passwd + ", info=" + info
				+ ", time=" + time + ", updateTime=" + updateTime + "]";
	}

}
