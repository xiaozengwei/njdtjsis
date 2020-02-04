package com.gx.soft.vis.persistence.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/5/23.
 */
@Entity
@Table(name = "v_column_article", schema = "njdtjsis", catalog = "")
public class VColumnArticleL {
    private String vColumnArticleKey;
    private String articleTitle;
    private String articleType;
    private String articleContent;
    private Timestamp createTime;
    private Integer orderNum;
    private String comment;
    private String columnName;
    private String columnId;
    private String articleId;
    private String isNewsPic;
    private String picFileName;
    private String picFileRealName;
    private Long votedNum;
    private Timestamp voteLimitTime;
    private String isVote;
    private String voteMethod;
    private Integer maxVoteNum;
    private String articleStatus;
    private String parentId;
    private Date publishTime;
    private String source;
    private Integer hits;
    private String videoFileName;
    private String videoFileRealName;

    @Id
    @Column(name = "v_column_article_key")
    public String getvColumnArticleKey() {
        return vColumnArticleKey;
    }

    public void setvColumnArticleKey(String vColumnArticleKey) {
        this.vColumnArticleKey = vColumnArticleKey;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_type")
    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    @Basic
    @Column(name = "article_content")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "order_num")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "column_name")
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "column_id")
    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    @Basic
    @Column(name = "article_id")
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "is_news_pic")
    public String getIsNewsPic() {
        return isNewsPic;
    }

    public void setIsNewsPic(String isNewsPic) {
        this.isNewsPic = isNewsPic;
    }

    @Basic
    @Column(name = "pic_file_name")
    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    @Basic
    @Column(name = "pic_file_real_name")
    public String getPicFileRealName() {
        return picFileRealName;
    }

    public void setPicFileRealName(String picFileRealName) {
        this.picFileRealName = picFileRealName;
    }

    @Basic
    @Column(name = "voted_num")
    public Long getVotedNum() {
        return votedNum;
    }

    public void setVotedNum(Long votedNum) {
        this.votedNum = votedNum;
    }

    @Basic
    @Column(name = "vote_limit_time")
    public Timestamp getVoteLimitTime() {
        return voteLimitTime;
    }

    public void setVoteLimitTime(Timestamp voteLimitTime) {
        this.voteLimitTime = voteLimitTime;
    }

    @Basic
    @Column(name = "is_vote")
    public String getIsVote() {
        return isVote;
    }

    public void setIsVote(String isVote) {
        this.isVote = isVote;
    }

    @Basic
    @Column(name = "vote_method")
    public String getVoteMethod() {
        return voteMethod;
    }

    public void setVoteMethod(String voteMethod) {
        this.voteMethod = voteMethod;
    }

    @Basic
    @Column(name = "max_vote_num")
    public Integer getMaxVoteNum() {
        return maxVoteNum;
    }

    public void setMaxVoteNum(Integer maxVoteNum) {
        this.maxVoteNum = maxVoteNum;
    }

    @Basic
    @Column(name = "article_status")
    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Basic
    @Column(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "publish_time")
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "hits")
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    @Basic
    @Column(name = "video_file_name")
    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    @Basic
    @Column(name = "video_file_real_name")
    public String getVideoFileRealName() {
        return videoFileRealName;
    }

    public void setVideoFileRealName(String videoFileRealName) {
        this.videoFileRealName = videoFileRealName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VColumnArticleL that = (VColumnArticleL) o;

        if (vColumnArticleKey != null ? !vColumnArticleKey.equals(that.vColumnArticleKey) : that.vColumnArticleKey != null)
            return false;
        if (articleTitle != null ? !articleTitle.equals(that.articleTitle) : that.articleTitle != null) return false;
        if (articleType != null ? !articleType.equals(that.articleType) : that.articleType != null) return false;
        if (articleContent != null ? !articleContent.equals(that.articleContent) : that.articleContent != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (orderNum != null ? !orderNum.equals(that.orderNum) : that.orderNum != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (columnId != null ? !columnId.equals(that.columnId) : that.columnId != null) return false;
        if (articleId != null ? !articleId.equals(that.articleId) : that.articleId != null) return false;
        if (isNewsPic != null ? !isNewsPic.equals(that.isNewsPic) : that.isNewsPic != null) return false;
        if (picFileName != null ? !picFileName.equals(that.picFileName) : that.picFileName != null) return false;
        if (picFileRealName != null ? !picFileRealName.equals(that.picFileRealName) : that.picFileRealName != null)
            return false;
        if (votedNum != null ? !votedNum.equals(that.votedNum) : that.votedNum != null) return false;
        if (voteLimitTime != null ? !voteLimitTime.equals(that.voteLimitTime) : that.voteLimitTime != null)
            return false;
        if (isVote != null ? !isVote.equals(that.isVote) : that.isVote != null) return false;
        if (voteMethod != null ? !voteMethod.equals(that.voteMethod) : that.voteMethod != null) return false;
        if (maxVoteNum != null ? !maxVoteNum.equals(that.maxVoteNum) : that.maxVoteNum != null) return false;
        if (articleStatus != null ? !articleStatus.equals(that.articleStatus) : that.articleStatus != null)
            return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (hits != null ? !hits.equals(that.hits) : that.hits != null) return false;
        if (videoFileName != null ? !videoFileName.equals(that.videoFileName) : that.videoFileName != null)
            return false;
        if (videoFileRealName != null ? !videoFileRealName.equals(that.videoFileRealName) : that.videoFileRealName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vColumnArticleKey != null ? vColumnArticleKey.hashCode() : 0;
        result = 31 * result + (articleTitle != null ? articleTitle.hashCode() : 0);
        result = 31 * result + (articleType != null ? articleType.hashCode() : 0);
        result = 31 * result + (articleContent != null ? articleContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (columnId != null ? columnId.hashCode() : 0);
        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
        result = 31 * result + (isNewsPic != null ? isNewsPic.hashCode() : 0);
        result = 31 * result + (picFileName != null ? picFileName.hashCode() : 0);
        result = 31 * result + (picFileRealName != null ? picFileRealName.hashCode() : 0);
        result = 31 * result + (votedNum != null ? votedNum.hashCode() : 0);
        result = 31 * result + (voteLimitTime != null ? voteLimitTime.hashCode() : 0);
        result = 31 * result + (isVote != null ? isVote.hashCode() : 0);
        result = 31 * result + (voteMethod != null ? voteMethod.hashCode() : 0);
        result = 31 * result + (maxVoteNum != null ? maxVoteNum.hashCode() : 0);
        result = 31 * result + (articleStatus != null ? articleStatus.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        result = 31 * result + (videoFileName != null ? videoFileName.hashCode() : 0);
        result = 31 * result + (videoFileRealName != null ? videoFileRealName.hashCode() : 0);
        return result;
    }
}
