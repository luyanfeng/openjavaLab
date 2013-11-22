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
@Table(name="bl_image",uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class ImageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @Column(length=40)
	private String id;			// 主键
	@Column(nullable=false,length=50)
	private String name;		// 名字
	@Column(nullable=false,length=100)
	private String path;		// 路径
	@Column(nullable=false,length=200)
	private String info;		// 简介
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;			// 时间
	
	
	
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", name=" + name + ", path=" + path
				+ ", info=" + info + ", time=" + time + "]";
	}
	
	
}
