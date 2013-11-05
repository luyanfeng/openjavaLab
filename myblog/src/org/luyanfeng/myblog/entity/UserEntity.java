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
	private String id;
	private String name;
	@Column(nullable=false)
	private String email;
	private String user;
	private String passwd;
	private String info;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	@Temporal(TemporalType.TIMESTAMP)
	private Date upateTime;
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
	public Date getUpateTime() {
		return upateTime;
	}
	public void setUpateTime(Date upateTime) {
		this.upateTime = upateTime;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", email=" + email
				+ ", user=" + user + ", passwd=" + passwd + ", info=" + info
				+ ", time=" + time + ", upateTime=" + upateTime + "]";
	}
	
	

}
