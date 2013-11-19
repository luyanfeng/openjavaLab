package org.luyanfeng.myblog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章、标签 关系表
 * @author luyanfeng
 *
 */
@Entity
@Table(name="bl_article_tag")
public class ArticleTagEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(length=40)
	private String id;
	@Column(nullable=false)
	private String article_id;
	@Column(nullable=false)
	private String tag_id;
	
	
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ArticleTagEntity [id=" + id + ", article_id=" + article_id
				+ ", tag_id=" + tag_id + "]";
	}
	
	
}
