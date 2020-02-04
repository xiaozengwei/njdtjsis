package com.gx.soft.mobile.persistence.vo;

import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sys.persistence.domain.GxSysUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adminstrator on 2019/7/26.
 */
public class TzryVo {
    private List<FileRecord>fileRecordList=new ArrayList<>();
    private GxSysUser gxSysUser=new GxSysUser();

    public List<FileRecord> getFileRecordList() {
        return fileRecordList;
    }

    public void setFileRecordList(List<FileRecord> fileRecordList) {
        this.fileRecordList = fileRecordList;
    }

    public GxSysUser getGxSysUser() {
        return gxSysUser;
    }

    public void setGxSysUser(GxSysUser gxSysUser) {
        this.gxSysUser = gxSysUser;
    }
}
