package com.gx.soft.mobile.persistence.vo;

import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReport;

import java.util.ArrayList;

/**
 * Created by adminstrator on 2019/6/24.
 */
public class WeeklyReportVO {
    private WeeklyReport  weeklyReport;
    private ArrayList<FileRecord>fileRecordArrayList=new ArrayList<>();

    public WeeklyReport getWeeklyReport() {
        return weeklyReport;
    }

    public void setWeeklyReport(WeeklyReport weeklyReport) {
        this.weeklyReport = weeklyReport;
    }

    public ArrayList<FileRecord> getFileRecordArrayList() {
        return fileRecordArrayList;
    }

    public void setFileRecordArrayList(ArrayList<FileRecord> fileRecordArrayList) {
        this.fileRecordArrayList = fileRecordArrayList;
    }
}
