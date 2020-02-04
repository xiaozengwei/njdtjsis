package com.gx.soft.mobile.persistence.vo;

import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReport;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReportProject;

import java.util.ArrayList;

/**
 * Created by adminstrator on 2019/6/25.
 */
public class ProjectWeeklyReportVo {
    private WeeklyReportProject weeklyReportProject;
    private ArrayList<FileRecord> fileRecordArrayList=new ArrayList<>();

    public WeeklyReportProject getWeeklyReportProject() {
        return weeklyReportProject;
    }

    public void setWeeklyReportProject(WeeklyReportProject weeklyReportProject) {
        this.weeklyReportProject = weeklyReportProject;
    }

    public ArrayList<FileRecord> getFileRecordArrayList() {
        return fileRecordArrayList;
    }

    public void setFileRecordArrayList(ArrayList<FileRecord> fileRecordArrayList) {
        this.fileRecordArrayList = fileRecordArrayList;
    }
}
