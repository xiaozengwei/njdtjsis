package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.view.persistence.domain.DeviceCameraRecord;
import com.gx.soft.view.persistence.manager.DeviceCameraRecordManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/5/14.
 */
@Controller
@RequestMapping("mobile-view")
@SessionAttributes("user_session")
public class MobileViewController {

    // 日志
    private static Logger logger = LoggerFactory.getLogger(MobileViewController.class);

    @Autowired
    private VUserManager vUserManager;

    @Autowired
    private DeviceCameraRecordManager deviceCameraRecordManager;


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "view-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult viewList( String userId,String bdId,@ModelAttribute Page page,@RequestParam Map<String, Object> paramMap) {
        VUser vUser=vUserManager.findUniqueBy("userId",userId);
        String statusCode = "1";// 成功
        String message = "获取视屏信息成功";
        page.addOrder("createTime", "desc");
        if(bdId==null || bdId=="") {
            if (vUser != null) {
                try {
                    paramMap.put("filter_EQS_bdId", vUser.getComBdId());
                    List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
                    page = deviceCameraRecordManager.pagedQuery(page, propertyFilterList);
                } catch (Exception ex) {
                    statusCode = "-1";
                    message = "获取视屏信息失败";
                    ex.printStackTrace();
                }
            }
        }else {
            paramMap.put("filter_EQS_bdId", bdId);
            List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
            page = deviceCameraRecordManager.pagedQuery(page, propertyFilterList);
            return new JsonResult(statusCode,page.getResult(),message);
        }
        return new JsonResult(statusCode,page.getResult(),message);
    }

}
