package com.gx.soft.mobile.persistence.vo;

import com.gx.core.page.Page;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adminstrator on 2019/7/3.
 */
public class WorksitePublicVo {
   private String bdName;
   private String bdId;
   private String pageName;


    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}
