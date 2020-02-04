package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReport;
import com.gx.soft.weeklyreport.persistence.manager.DgjJdManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/8/29.
 */
@Controller
@RequestMapping("mobile-dgjd")
public class MobileDgjdController {
    @Autowired
    private DgjJdManager dgjJdManager;
    @Autowired
    private VUserManager vUserManager;
    @RequestMapping(value = "dgjd-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult dgjdList(String userId, String bdId, @RequestParam Map<String, Object> parameterMap, @ModelAttribute Page page) {

        VUser user = vUserManager.findUniqueBy("userId",userId);
        String statusCode = "1";// 成功
        String message = "获取盾构进度成功";
        page.addOrder("scTime", "desc");
        if(bdId==null|| bdId=="") {
            if (user != null) {
                parameterMap.put("filter_EQS_bdId", user.getComBdId());
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = dgjJdManager.pagedQuery(page, propertyFilterList);
            } else {
                statusCode = "0";// 成功
                message = "获取盾构进度失败";
            }
        }else {
            parameterMap.put("filter_EQS_bdId", bdId);
            List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
            page = dgjJdManager.pagedQuery(page, propertyFilterList);
        }

        return new JsonResult(statusCode, page.getResult(), message);
    }
}
