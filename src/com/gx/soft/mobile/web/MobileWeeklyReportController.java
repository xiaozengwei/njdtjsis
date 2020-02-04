package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.danagerproject.persistence.domain.DanagerProject;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.ProjectWeeklyReportVo;
import com.gx.soft.mobile.persistence.vo.WeeklyReportVO;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReport;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReportProject;
import com.gx.soft.weeklyreport.persistence.manager.WeeklyReportManager;
import com.gx.soft.weeklyreport.persistence.manager.WeeklyReportProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/21.
 */
@Controller
    @RequestMapping("mobile-weeklyreport")
public class MobileWeeklyReportController {
    @Autowired
    private WeeklyReportManager weeklyReportManager;
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @Autowired
    private WeeklyReportProjectManager weeklyReportProjectManager;

    @RequestMapping(value = "weeklyreport-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult weeklyreportList(String userId,String bdId, @RequestParam Map<String, Object> parameterMap, @ModelAttribute Page page) {

        VUser user = vUserManager.findUniqueBy("userId",userId);
        String statusCode = "1";// 成功
        String message = "获取标段形象进度成功";
        page.addOrder("createTime", "desc");
        if(bdId==null|| bdId=="") {
            if (user != null) {
                parameterMap.put("filter_EQS_bdId", user.getComBdId());
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = weeklyReportManager.pagedQuery(page, propertyFilterList);
                int totalCount=(int)page.getTotalCount();
                page.setPageSize(totalCount);
                page=weeklyReportManager.pagedQuery(page, propertyFilterList);
                List< WeeklyReport>list= (List<WeeklyReport>) page.getResult();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                for(WeeklyReport weeklyReport:list){
                    if(weeklyReport.getExt2()!=null && weeklyReport.getExt2()!="") {
                        weeklyReport.setExt2(sdf.format(Timestamp.valueOf(weeklyReport.getExt2())));
                        weeklyReport.setExt3(sdf.format(Timestamp.valueOf(weeklyReport.getExt3())));
                    }
                }
            } else {
                statusCode = "0";// 成功
                message = "获取标段形象进度失败";
            }
        }else {
            parameterMap.put("filter_EQS_bdId", bdId);
            List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
            page = weeklyReportManager.pagedQuery(page, propertyFilterList);
            int totalCount=(int)page.getTotalCount();
            page.setPageSize(totalCount);
            page=weeklyReportManager.pagedQuery(page, propertyFilterList);
            List< WeeklyReport>list= (List<WeeklyReport>) page.getResult();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            for(WeeklyReport weeklyReport:list){
                if(weeklyReport.getExt2()!=null && weeklyReport.getExt2()!="") {
                    weeklyReport.setExt2(sdf.format(Timestamp.valueOf(weeklyReport.getExt2())));
                    weeklyReport.setExt3(sdf.format(Timestamp.valueOf(weeklyReport.getExt3())));
                }
            }
            return new JsonResult(statusCode, page.getResult(), message);
        }

        return new JsonResult(statusCode, page.getResult(), message);
    }
    @RequestMapping(value = "weeklyreportproject-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult weeklyreportprojectList(String userId, String bdId,@RequestParam Map<String, Object> parameterMap, @ModelAttribute Page page) {
        System.out.println();
        VUser user = vUserManager.findUniqueBy("userId",userId);
        String statusCode = "1";// 成功
        String message = "获取项目部周报列表成功";
        page.addOrder("createTime", "desc");
        if(bdId==null|| bdId=="") {
            if (user != null) {
                parameterMap.put("filter_EQS_bdId", user.getComBdId());
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = weeklyReportProjectManager.pagedQuery(page, propertyFilterList);
                int totalCount=(int)page.getTotalCount();
                page.setPageSize(totalCount);
                page=weeklyReportProjectManager.pagedQuery(page, propertyFilterList);
                List< WeeklyReportProject>list= (List<WeeklyReportProject>) page.getResult();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                for(WeeklyReportProject weeklyReport:list){
                    if(weeklyReport.getExt2()!=null && weeklyReport.getExt2()!="") {
                        weeklyReport.setExt2(sdf.format(Timestamp.valueOf(weeklyReport.getExt2())));
                        weeklyReport.setExt3(sdf.format(Timestamp.valueOf(weeklyReport.getExt3())));
                    }
                }
                System.out.println();
            } else {
                statusCode = "0";// 成功
                message = "获取项目部周报列表失败";
            }
        }else {
            parameterMap.put("filter_EQS_bdId", bdId);
            List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
            page = weeklyReportProjectManager.pagedQuery(page, propertyFilterList);
            int totalCount=(int)page.getTotalCount();
            page.setPageSize(totalCount);
            page=weeklyReportProjectManager.pagedQuery(page, propertyFilterList);
            List< WeeklyReportProject>list= (List<WeeklyReportProject>) page.getResult();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            for(WeeklyReportProject weeklyReport:list){

                if(weeklyReport.getExt2()!=null && weeklyReport.getExt2()!="" ) {
                    weeklyReport.setExt2(sdf.format(Timestamp.valueOf(weeklyReport.getExt2())));
                    weeklyReport.setExt3(sdf.format(Timestamp.valueOf(weeklyReport.getExt3())));
                }
            }
            return new JsonResult(statusCode, page.getResult(), message);
        }
        return new JsonResult(statusCode, page.getResult(), message);
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "weeklyreport-record", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult viewRecord(String rowId) {
        String statusCode = "1";// 成功
        String message = "获取标段形象进度列表成功";
        List<FileRecord> fileRecordList =null;
        WeeklyReport weeklyReport=new WeeklyReport();
        WeeklyReportVO  weeklyReportVO=new WeeklyReportVO();
//        ArrayList<Object>list=new ArrayList<>();
        try{
            String hql="from FileRecord where relationId=?";
            fileRecordList=fileRecordManager.find(hql,rowId);
            weeklyReport=weeklyReportManager.get(rowId);
            weeklyReportVO.setFileRecordArrayList((ArrayList<FileRecord>) fileRecordList);
            weeklyReportVO.setWeeklyReport(weeklyReport);
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取标段形象进度失败";
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,weeklyReportVO,message);
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "weeklyreportproject-record", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult weeklyreportprojectRecord(String rowId) {
        System.out.println();
        String statusCode = "1";// 成功
        String message = "获取项目部周报详细列表成功";
        List<FileRecord> fileRecordList =null;
        WeeklyReportProject weeklyReportProject=new WeeklyReportProject();
        ProjectWeeklyReportVo projectWeeklyReportVo=new ProjectWeeklyReportVo();
//        ArrayList<Object>list=new ArrayList<>();
        try{
            String hql="from FileRecord where relationId=?";
            fileRecordList=fileRecordManager.find(hql,rowId);
            weeklyReportProject=weeklyReportProjectManager.get(rowId);
            projectWeeklyReportVo.setFileRecordArrayList((ArrayList<FileRecord>) fileRecordList);
            projectWeeklyReportVo.setWeeklyReportProject(weeklyReportProject);
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取项目部周报详细列表失败";
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,projectWeeklyReportVo,message);
    }
}
