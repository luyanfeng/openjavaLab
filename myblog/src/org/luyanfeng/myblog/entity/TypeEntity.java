package org.luyanfeng.myblog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="bl_type", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class TypeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id @Column(length=40)
	private String id;					// 统一主键 
	@Column(nullable=false,length=50)
	private String name;				// 名称
	private boolean isHidden;			// 显示、隐藏
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;					// 时间
	// 排序属性
	@Column(length=40)
	private String preid;				// 队前数据主键 null时为第一个
	@Column(length=40)
	private String subid;				// 队后数据主键 null时为最后一个
	
	/*@ManyToMany(fetch=FetchType.LAZY ,mappedBy="typeList" , targetEntity=ArticleEntity.class)*/
	@Transient
	private List<ArticleEntity> articles =  new ArrayList<>();
	
	
	
	
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
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public String getPreid() {
		return preid;
	}
	public void setPreid(String preid) {
		this.preid = preid;
	}
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public List<ArticleEntity> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleEntity> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "TypeEntity [id=" + id + ", name=" + name + ", isHidden="
				+ isHidden + ", time=" + time + ", preid=" + preid + ", subid="
				+ subid + ", articles=" + articles + "]";
	}
	
}
