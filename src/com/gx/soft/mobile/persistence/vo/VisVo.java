package com.gx.soft.mobile.persistence.vo;

import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.vis.persistence.domain.VViewColumnArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adminstrator on 2019/7/10.
 */
public class VisVo {
    private List<VViewColumnArticle> vViewColumnArticleList = new ArrayList<>();
    private List<FileRecord> fileRecordList = new ArrayList<>();

    public List<VViewColumnArticle> getvViewColumnArticleList() {
        return vViewColumnArticleList;
    }

    public void setvViewColumnArticleList(List<VViewColumnArticle> vViewColumnArticleList) {
        this.vViewColumnArticleList = vViewColumnArticleList;
    }

    public List<FileRecord> getFileRecordList() {
        return fileRecordList;
    }

    public void setFileRecordList(List<FileRecord> fileRecordList) {
        this.fileRecordList = fileRecordList;
    }
}


