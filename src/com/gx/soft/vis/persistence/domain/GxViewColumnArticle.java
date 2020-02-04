package com.gx.soft.vis.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/7/5.
 */
@Entity
@Table(name = "gx_view_column_article", schema = "njdtjsis", catalog = "")
public class GxViewColumnArticle {
    private String rowId;
    private String articleTitle;
    private String articleContent;
    private String createUserId;
    private Timestamp createTime;
    private Integer orderNum;
    private String comment;
    private String articleType;
    private String createUserName;
    private String isNewsPic;
    private String picFileName;
    private String picFileRealName;
    private Long votedNum;
    private String isVote;
    private String voteMethod;
    private Integer maxVoteNum;
    private Timestamp voteLimitTime;
    private Date publishTime;
    private String source;
    private String articleStatus;
    private Integer hits;
    private String videoFileName;
    private String videoFileRealName;
    private String bdId;
    private String bdName;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "row_id", unique = true, nullable = false, length = 40)
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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
    @Column(name = "article_content")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "create_user_id")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
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
    @Column(name = "article_type")
    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    @Basic
    @Column(name = "create_user_name")
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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
    @Column(name = "vote_limit_time")
    public Timestamp getVoteLimitTime() {
        return voteLimitTime;
    }

    public void setVoteLimitTime(Timestamp voteLimitTime) {
        this.voteLimitTime = voteLimitTime;
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
    @Column(name = "article_status")
    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
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

    @Basic
    @Column(name = "bd_id")
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    @Basic
    @Column(name = "bd_name")
    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GxViewColumnArticle that = (GxViewColumnArticle) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (articleTitle != null ? !articleTitle.equals(that.articleTitle) : that.articleTitle != null) return false;
        if (articleContent != null ? !articleContent.equals(that.articleContent) : that.articleContent != null)
            return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (orderNum != null ? !orderNum.equals(that.orderNum) : that.orderNum != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (articleType != null ? !articleType.equals(that.articleType) : that.articleType != null) return false;
        if (createUserName != null ? !createUserName.equals(that.createUserName) : that.createUserName != null)
            return false;
        if (isNewsPic != null ? !isNewsPic.equals(that.isNewsPic) : that.isNewsPic != null) return false;
        if (picFileName != null ? !picFileName.equals(that.picFileName) : that.picFileName != null) return false;
        if (picFileRealName != null ? !picFileRealName.equals(that.picFileRealName) : that.picFileRealName != null)
            return false;
        if (votedNum != null ? !votedNum.equals(that.votedNum) : that.votedNum != null) return false;
        if (isVote != null ? !isVote.equals(that.isVote) : that.isVote != null) return false;
        if (voteMethod != null ? !voteMethod.equals(that.voteMethod) : that.voteMethod != null) return false;
        if (maxVoteNum != null ? !maxVoteNum.equals(that.maxVoteNum) : that.maxVoteNum != null) return false;
        if (voteLimitTime != null ? !voteLimitTime.equals(that.voteLimitTime) : that.voteLimitTime != null)
            return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (articleStatus != null ? !articleStatus.equals(that.articleStatus) : that.articleStatus != null)
            return false;
        if (hits != null ? !hits.equals(that.hits) : that.hits != null) return false;
        if (videoFileName != null ? !videoFileName.equals(that.videoFileName) : that.videoFileName != null)
            return false;
        if (videoFileRealName != null ? !videoFileRealName.equals(that.videoFileRealName) : that.videoFileRealName != null)
            return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (bdName != null ? !bdName.equals(that.bdName) : that.bdName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (articleTitle != null ? articleTitle.hashCode() : 0);
        result = 31 * result + (articleContent != null ? articleContent.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (articleType != null ? articleType.hashCode() : 0);
        result = 31 * result + (createUserName != null ? createUserName.hashCode() : 0);
        result = 31 * result + (isNewsPic != null ? isNewsPic.hashCode() : 0);
        result = 31 * result + (picFileName != null ? picFileName.hashCode() : 0);
        result = 31 * result + (picFileRealName != null ? picFileRealName.hashCode() : 0);
        result = 31 * result + (votedNum != null ? votedNum.hashCode() : 0);
        result = 31 * result + (isVote != null ? isVote.hashCode() : 0);
        result = 31 * result + (voteMethod != null ? voteMethod.hashCode() : 0);
        result = 31 * result + (maxVoteNum != null ? maxVoteNum.hashCode() : 0);
        result = 31 * result + (voteLimitTime != null ? voteLimitTime.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (articleStatus != null ? articleStatus.hashCode() : 0);
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        result = 31 * result + (videoFileName != null ? videoFileName.hashCode() : 0);
        result = 31 * result + (videoFileRealName != null ? videoFileRealName.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        return result;
    }
}
