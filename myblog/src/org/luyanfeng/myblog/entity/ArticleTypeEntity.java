package org.luyanfeng.myblog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章 、分类关系表
 * @author luyanfeng
 *
 */
@Entity
@Table(name="bl_article_type")
public class ArticleTypeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(length=40)
	private String id;
	@Column(nullable=false)
	private String article_id;
	@Column(nullable=false)
	private String type_id;
	
	
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ArticleTypeEntity [id=" + id + ", article_id=" + article_id
				+ ", type_id=" + type_id + "]";
	}
	
	
}
