package org.luyanfeng.myblog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bl_tag")
public class TagEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id @Column(length=40)
	private String id;					// 统一主键 
	@Column(nullable=false,length=50)
	private String name;				// 名称
	private Integer quantity = 0;		// 数量
	private boolean isHidden;			// 显示、隐藏
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;					// 时间
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="tagList", targetEntity=ArticleEntity.class)
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
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
		return "TagEntity [id=" + id + ", name=" + name + ", quantity="
				+ quantity + ", isHidden=" + isHidden + ", time=" + time
				+ ", articles=" + articles + "]";
	}
	
}
