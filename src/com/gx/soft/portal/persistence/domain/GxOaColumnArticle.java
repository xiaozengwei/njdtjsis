package com.gx.soft.portal.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaColumnArticle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_column_article")
public class GxOaColumnArticle implements java.io.Serializable {

	// Fields

	private String rowId;
	private String articleTitle;
	private String articleContent;
	private String createUserId;
	private Timestamp createTime;
	private Integer orderNum;
	private String comment;
	private String articleType;
	private String articleStauts;
	private String createUserName;
	private String isNewsPic;
	private String picFileName;//已经编码的名称
	private String picFileRealName;//实际名称

	// Constructors

	/** default constructor */
	public GxOaColumnArticle() {
	}

	/** full constructor */
	public GxOaColumnArticle(String articleTitle, String articleContent,
			String createUserId, Timestamp createTime, Integer orderNum,
			String comment, String articleType, String articleStauts,
			String createUserName, String isNewsPic, String picFileName,
			String picFileRealName) {
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.orderNum = orderNum;
		this.comment = comment;
		this.articleType = articleType;
		this.articleStauts = articleStauts;
		this.createUserName = createUserName;
		this.isNewsPic = isNewsPic;
		this.picFileName = picFileName;
		this.picFileRealName = picFileRealName;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", unique = true, nullable = false, length = 32)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "article_title", length = 500)
	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	@Column(name = "article_content")
	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	@Column(name = "create_user_id", length = 100)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
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

	@Column(name = "article_type", length = 50)
	public String getArticleType() {
		return this.articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	@Column(name = "article_stauts", length = 50)
	public String getArticleStauts() {
		return this.articleStauts;
	}

	public void setArticleStauts(String articleStauts) {
		this.articleStauts = articleStauts;
	}

	@Column(name = "create_user_name", length = 200)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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