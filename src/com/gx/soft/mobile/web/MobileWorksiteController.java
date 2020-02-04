package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.worksite.persistence.manager.WorkSiteIndexManager;
import com.gx.soft.worksite.persistence.manager.WorksiteRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/5.
 */
@Controller
@SessionAttributes("user_session")
@RequestMapping("mobile-worksite")
public class MobileWorksiteController {
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private WorkSiteIndexManager workSiteIndexManager;
    @Autowired
    private WorksiteRecordManager worksiteRecordManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "worksite-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult viewList(String userId,String bdId,@ModelAttribute Page page, @RequestParam Map<String, Object> paramMap) {
        String statusCode = "1";// 成功
        String message = "获取工点列表成功";
        if(bdId==null || bdId=="") {
            VUser user = vUserManager.findUniqueBy("userId", userId);
            page.addOrder("createTime", "desc");
            try {
                paramMap.put("filter_EQS_bdId", user.getComBdId());
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
                page = workSiteIndexManager.pagedQuery(page, propertyFilterList);
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取工点列表失败";
                ex.printStackTrace();
            }
        }else{
            page.addOrder("createTime", "desc");
            try {
                paramMap.put("filter_EQS_bdId", bdId);
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
                page = workSiteIndexManager.pagedQuery(page, propertyFilterList);
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取工点列表失败";
                ex.printStackTrace();
            }
        }
        return new JsonResult(statusCode,page.getResult(),message);
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "worksite-record", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult viewRecord(String worksiteId,@ModelAttribute Page page,@RequestParam Map<String, Object> parameterMap) {
        String statusCode = "1";// 成功
        String message = "获取工点列表成功";
        List<FileRecord> fileRecordList =null;
        page.addOrder("uploadTime", "desc");
        try{
            parameterMap.put("filter_EQS_relationId", worksiteId);
            List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
            page = fileRecordManager.pagedQuery(page, propertyFilterList);
//            String hql="from FileRecord where relationId=?";
//            fileRecordList=fileRecordManager.find(hql,worksiteId);
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取详细列表失败";
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,page.getResult(),message);
    }
}
