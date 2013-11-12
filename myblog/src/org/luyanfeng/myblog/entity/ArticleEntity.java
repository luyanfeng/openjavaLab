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
@Table(name="bl_article")
public class ArticleEntity implements Serializable {

	private static final long serialVersionUID = 5786852236479125353L;
	
	@Id
	private String id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String content;
	private String tags;
	@Column(nullable=false)
	private String author;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	private String updateTime;
	
	
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "ArticleEntity [id=" + id + ", title=" + title + ", content="
				+ content + ", tags=" + tags + ", author=" + author + ", time="
				+ time + ", updateTime=" + updateTime + "]";
	}

}
