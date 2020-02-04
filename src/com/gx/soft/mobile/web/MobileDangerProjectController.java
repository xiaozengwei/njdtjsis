package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.danagerproject.persistence.domain.DanagerProject;
import com.gx.soft.danagerproject.persistence.manager.DanagerProjectManager;
import com.gx.soft.mobile.persistence.domain.ByProjectIntroduction;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/20.
 */
@Controller
@RequestMapping("mobile-danagerproject")
public class MobileDangerProjectController {
    @Autowired
    private DanagerProjectManager danagerProjectManager;
    @Autowired
    private VUserManager vUserManager;
    @RequestMapping(value = "danagerproject-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult danagerprojectList(String userId,String bdId,@RequestParam Map<String, Object> parameterMap, @ModelAttribute Page page) {
        VUser user = vUserManager.findUniqueBy("userId",userId);
        String statusCode = "1";// 成功
        String message = "获取危大工程成功";
        page.addOrder("kgTime", "desc");
//        String hql="from DanagerProject where bdId=?";
//        List<DanagerProject> dnagerProjectList=new ArrayList<>();
        if(bdId==null || bdId=="") {
            if (user != null) {
                parameterMap.put("filter_EQS_bdId", user.getComBdId());
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = danagerProjectManager.pagedQuery(page, propertyFilterList);
            } else {
                statusCode = "0";
                message = "获取危大工程失败";
            }
        }else{
            page.addOrder("kgTime", "desc");
            try {
                parameterMap.put("filter_EQS_bdId", bdId);
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = danagerProjectManager.pagedQuery(page, propertyFilterList);
                return new JsonResult(statusCode, page.getResult(), message);
            }catch (Exception ex){
                statusCode = "0";
                message = "获取危大工程失败";
            }

        }
        return new JsonResult(statusCode, page.getResult(), message);
    }
}
