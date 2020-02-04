package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.mobile.persistence.domain.BuildProgressRecord;
import com.gx.soft.mobile.persistence.domain.ByProjectIntroduction;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.yh.persistence.domain.YhPcSituation;
import com.gx.soft.yh.persistence.manager.YhPcSituationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/12.
 */
@Controller
@RequestMapping("mobile-hidden")
public class MobileHiddenDanagerController {
    @Autowired
    YhPcSituationManager yhPcSituationManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @Autowired
    private VUserManager vUserManager;
    @RequestMapping( "file-list")
    public @ResponseBody
    JsonResult progress(@RequestParam Map<String, Object> parameterMap) {
        List<FileRecord>fileRecordList=fileRecordManager.getAll();
        return new JsonResult("200", fileRecordList, "获取附件列表成功");
    }
    @RequestMapping( "yh-list")
    public @ResponseBody
    JsonResult yhList(String userId,String bdId,@RequestParam Map<String, Object> parameterMap,@ModelAttribute Page page) {
        VUser vUser=vUserManager.findUniqueBy("userId",userId);
        String statusCode="1";
        String message="获取隐患排查列表成功";
        page.addOrder("createTime", "desc");
        if(bdId==null|| bdId=="") {
            if (vUser != null) {
                if (userId.equals("liu_yc")) {
                } else {
                    parameterMap.put("filter_EQS_bdId", vUser.getComBdId());
                }
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = yhPcSituationManager.pagedQuery(page, propertyFilterList);

            } else {
                statusCode = "0";
                message = "获取隐患排查列表失败";
            }
        }else {
            page.addOrder("createTime", "desc");
            parameterMap.put("filter_EQS_bdId", bdId);
            List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
            page = yhPcSituationManager.pagedQuery(page, propertyFilterList);
        }
        return new JsonResult(statusCode, page.getResult(), message);
    }
    @RequestMapping(value = "fileDownload")
    @ResponseBody
    public Map<String, Object>  fileDownLoad( String rowId,HttpServletRequest request,
                                               HttpServletResponse response) {
        String hql="from FileRecord where relationId=?";
        ArrayList<FileRecord>fileRecordList= (ArrayList<FileRecord>) fileRecordManager.find(hql,rowId);
        Map<String, Object> resMap = new HashMap<String, Object>();
        for(int i=0;i<fileRecordList.size();i++){
            FileUtil fileHelper = new FileUtil();
            fileHelper.downloadFile(fileRecordList.get(i).getFilePath(), request, response, fileRecordList.get(i).getFileName());
        }
        resMap.put("statusCode", "200");
        resMap.put("message", "下载成功");
        return resMap;
    }
}
