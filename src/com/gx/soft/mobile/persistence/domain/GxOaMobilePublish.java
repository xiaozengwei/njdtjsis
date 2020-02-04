package com.gx.soft.mobile.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/7/15.
 */
@Entity
@Table(name = "gx_oa_mobile_publish", schema = "njdtjsis", catalog = "")
public class GxOaMobilePublish {
    private String rowId;
    private String appName;
    private String appEnName;
    private String appVer;
    private String appShowVer;
    private Timestamp publishDate;
    private String publishUser;
    private String attachId;
    private String attachName;
    private String status;
    private String updtaeContent;

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
    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "app_en_name")
    public String getAppEnName() {
        return appEnName;
    }

    public void setAppEnName(String appEnName) {
        this.appEnName = appEnName;
    }

    @Basic
    @Column(name = "app_ver")
    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    @Basic
    @Column(name = "app_show_ver")
    public String getAppShowVer() {
        return appShowVer;
    }

    public void setAppShowVer(String appShowVer) {
        this.appShowVer = appShowVer;
    }

    @Basic
    @Column(name = "publish_date")
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "publish_user")
    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    @Basic
    @Column(name = "attach_id")
    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    @Basic
    @Column(name = "attach_name")
    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "updtae_content")
    public String getUpdtaeContent() {
        return updtaeContent;
    }

    public void setUpdtaeContent(String updtaeContent) {
        this.updtaeContent = updtaeContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GxOaMobilePublish that = (GxOaMobilePublish) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) return false;
        if (appEnName != null ? !appEnName.equals(that.appEnName) : that.appEnName != null) return false;
        if (appVer != null ? !appVer.equals(that.appVer) : that.appVer != null) return false;
        if (appShowVer != null ? !appShowVer.equals(that.appShowVer) : that.appShowVer != null) return false;
        if (publishDate != null ? !publishDate.equals(that.publishDate) : that.publishDate != null) return false;
        if (publishUser != null ? !publishUser.equals(that.publishUser) : that.publishUser != null) return false;
        if (attachId != null ? !attachId.equals(that.attachId) : that.attachId != null) return false;
        if (attachName != null ? !attachName.equals(that.attachName) : that.attachName != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (updtaeContent != null ? !updtaeContent.equals(that.updtaeContent) : that.updtaeContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + (appEnName != null ? appEnName.hashCode() : 0);
        result = 31 * result + (appVer != null ? appVer.hashCode() : 0);
        result = 31 * result + (appShowVer != null ? appShowVer.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (publishUser != null ? publishUser.hashCode() : 0);
        result = 31 * result + (attachId != null ? attachId.hashCode() : 0);
        result = 31 * result + (attachName != null ? attachName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updtaeContent != null ? updtaeContent.hashCode() : 0);
        return result;
    }
}
