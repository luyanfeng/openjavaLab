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

@Entity
@Table(name="bl_article")
public class ArticleEntity implements Serializable {

	private static final long serialVersionUID = 5786852236479125353L;
	
	@Id @Column(length=40)
	private String id;						// 统一主键 
	@Column(nullable=false,length=100)		
	private String title;					// 标题
	@Column(nullable=false,length=5000)
	private String content;					// 内容 
	private Integer readtimes = 0;			// 阅读次数
	private Integer reviewtimes = 0;		// 评论次数
	private boolean isOpen;					// 开放性/可评论性
	@Column(nullable=false, length=50)
	private String author;					// 作者
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;						// 创建时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;				// 更新时间
	
	/*@ManyToMany(fetch=FetchType.LAZY,  cascade={CascadeType.ALL})
	@JoinTable(
		name="bl_article_type",
		joinColumns={@JoinColumn(referencedColumnName="id",name ="article_id")},
		inverseJoinColumns={@JoinColumn(referencedColumnName="id", name="type_id")}
	)*/
	@Transient
	private List<TypeEntity> typeList = new ArrayList<>();	//分类
	
	/*@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinTable(
			name="bl_article_tag",
			joinColumns={@JoinColumn(referencedColumnName="id",name="article_id")},
			inverseJoinColumns={@JoinColumn(referencedColumnName="id", name="tag_id")}
		)*/	
	@Transient
	private List<TagEntity> tagList = new ArrayList<>();	// 标签
	
	@Transient
	private String tags;			// 标签，用空格隔开 传值用
	@Transient
	private String types;			// 分类，用空格隔开 传值用
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public Integer getReadtimes() {
		return readtimes;
	}
	public void setReadtimes(Integer readtimes) {
		this.readtimes = readtimes;
	}
	public Integer getReviewtimes() {
		return reviewtimes;
	}
	public void setReviewtimes(Integer reviewtimes) {
		this.reviewtimes = reviewtimes;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public List<TypeEntity> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<TypeEntity> typeList) {
		this.typeList = typeList;
	}
	public List<TagEntity> getTagList() {
		return tagList;
	}
	public void setTagList(List<TagEntity> tagList) {
		this.tagList = tagList;
	}
	@Override
	public String toString() {
		return "ArticleEntity [id=" + id + ", title=" + title + ", content="
				+ content + ", readtimes=" + readtimes + ", reviewtimes="
				+ reviewtimes + ", isOpen=" + isOpen + ", author=" + author
				+ ", time=" + time + ", updateTime=" + updateTime
				+ ", tags="
				+ tags + ", types=" + types + "]";
	}

}
