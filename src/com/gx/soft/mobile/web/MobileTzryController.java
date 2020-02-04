package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.TzryVo;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/26.
 */
@Controller
@RequestMapping("mobile-tzry")
public class MobileTzryController {
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private FileRecordManager fileRecordManager;

    @RequestMapping(value = "tzry-list", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    JsonResult tzryList(String userId, String bdId, @RequestParam Map<String, Object> paramMap, @ModelAttribute Page page) {

        String statusCode = "1";// 成功
        String message = "获取特种人员列表成功";
        page.addOrder("createTime", "desc");
        VUser user = vUserManager.findUniqueBy("userId", userId);
        page.addOrder("createTime", "desc");
        List<GxSysUser> userList = new ArrayList<>();
        if (bdId == null || bdId == "") {
            try {
                if (user != null) {
                    paramMap.put("filter_EQS_bdId", user.getComBdId());
                    List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
                    page = sysUserManager.pagedQuery(page, propertyFilterList);
                }
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取特种人员列表失败";
                ex.printStackTrace();
            }
        } else {
            try {
                paramMap.put("filter_EQS_bdId",bdId);
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
                page = sysUserManager.pagedQuery(page, propertyFilterList);
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取特种人员列表失败";
                ex.printStackTrace();
            }
        }
        return new JsonResult(statusCode, page.getResult(), message);
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "tzry-record", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult viewRecord(String rowId,@ModelAttribute Page page,@RequestParam Map<String, Object> parameterMap) {
        String statusCode = "1";// 成功
        String message = "获取特种人员详情成功";
        TzryVo tzryVo=new TzryVo();
        List<FileRecord> fileRecordList =null;
        page.addOrder("uploadTime", "desc");
        try{
            String hql="from FileRecord where relationId=?";
            fileRecordList=fileRecordManager.find(hql,rowId);
            if(fileRecordList!=null){
                tzryVo.setFileRecordList(fileRecordList);
            }
            GxSysUser user=null;
            user=sysUserManager.get(rowId);
            if (user!=null){
                tzryVo.setGxSysUser(user);
            }
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取特种人员详情失败";
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,tzryVo,message);
    }
}


