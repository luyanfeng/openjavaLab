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
@Table(name="bl_about",uniqueConstraints={@UniqueConstraint(columnNames={"title"})})
public class AboutEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id @Column(length=40)
	private String id;					// 统一主键 
	@Column(nullable=false,length=80)
	private String title;				// 标题
	@Column(nullable=false,length=5000)
	private String content;				// 内容
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;					// 时间
	@Column(length=80)
	private String author;				// 作者
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "AboutEntity [id=" + id + ", title=" + title + ", content="
				+ content + ", time=" + time + ", author=" + author + "]";
	}
		
}
