package com.gx.soft.mobile.persistence.vo;

/**
 * Created by adminstrator on 2019/7/11.
 */
public class CheckUpdateVo {
    private String apkUrl;
    private String wgtUrl;
    public  String statusl;
    public  String appName;
    public  String appVer;
    public  String updateContent;

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getWgtUrl() {
        return wgtUrl;
    }

    public void setWgtUrl(String wgtUrl) {
        this.wgtUrl = wgtUrl;
    }

    public String getStatusl() {
        return statusl;
    }

    public void setStatusl(String statusl) {
        this.statusl = statusl;
    }
}
