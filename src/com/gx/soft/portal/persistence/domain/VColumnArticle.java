package com.gx.soft.portal.persistence.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VColumnArticle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_column_article")
public class VColumnArticle implements java.io.Serializable {

	private String VColumnArticleKey;
	private String articleTitle;
	private String articleType;
	private String articleContent;
	private String articleStauts;
	private Timestamp createTime;
	private Integer orderNum;
	private String comment;
	private String columnName;
	private String columnId;
	private String articleId;
	private String isNewsPic;
	private String picFileName;// 已经编码的名称
	private String picFileRealName;// 实际名称

	@Id
	@Column(name = "v_column_article_key")
	public String getVColumnArticleKey() {
		return this.VColumnArticleKey;
	}

	public void setVColumnArticleKey(String VColumnArticleKey) {
		this.VColumnArticleKey = VColumnArticleKey;
	}

	@Column(name = "article_title", length = 500)
	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	@Column(name = "article_type", length = 50)
	public String getArticleType() {
		return this.articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	@Column(name = "article_content")
	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	@Column(name = "article_stauts", length = 50)
	public String getArticleStauts() {
		return this.articleStauts;
	}

	public void setArticleStauts(String articleStauts) {
		this.articleStauts = articleStauts;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "order_num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "comment", length = 500)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "column_name", length = 200)
	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Column(name = "column_id", nullable = false, length = 32)
	public String getColumnId() {
		return this.columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	@Column(name = "article_id", nullable = false, length = 32)
	public String getArticleId() {
		return this.articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	@Column(name = "is_news_pic", length = 1)
	public String getIsNewsPic() {
		return this.isNewsPic;
	}

	public void setIsNewsPic(String isNewsPic) {
		this.isNewsPic = isNewsPic;
	}

	@Column(name = "pic_file_name", length = 500)
	public String getPicFileName() {
		return this.picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	@Column(name = "pic_file_real_name", length = 500)
	public String getPicFileRealName() {
		return this.picFileRealName;
	}

	public void setPicFileRealName(String picFileRealName) {
		this.picFileRealName = picFileRealName;
	}
}