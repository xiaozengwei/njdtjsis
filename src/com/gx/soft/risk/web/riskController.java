package com.gx.soft.risk.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.mobile.persistence.domain.BuilddgPadDay;
import com.gx.soft.mobile.persistence.manager.BuilddgPadDayManager;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/5/27.
 */
@Controller
@RequestMapping("risk")
@SessionAttributes("user_session")
public class riskController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    BuilddgPadDayManager builddgPadDayManager;
    @Autowired
    SxpzRecordManager sxpzRecordManager;
    @RequestMapping("risk-list")
    public String viewList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
       if(!user.getUserId().equals("liu_wq")) {
           parameterMap.put("filter_EQS_bdId", user.getComBdId());
       }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = builddgPadDayManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "risk/risk-list";
    }

    @RequestMapping("risk-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        BuilddgPadDay builddgPadDay;
        String startTime=null;
        String endTime=null;
        if (rowId != null) {
            builddgPadDay = builddgPadDayManager.get(rowId);
            startTime=builddgPadDay.getCrTime().split("-")[0];
            endTime=builddgPadDay.getCrTime().split("-")[1];
        } else {
            builddgPadDay = new BuilddgPadDay();
        }
        model.addAttribute("builddgPadDay", builddgPadDay);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        return "risk/risk-input";
    }
    @RequestMapping("risk-look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        BuilddgPadDay builddgPadDay;
        builddgPadDay = builddgPadDayManager.get(rowId);
        String startTime=builddgPadDay.getCrTime().split("-")[0];
        String endTime=builddgPadDay.getCrTime().split("-")[1];
        model.addAttribute("builddgPadDay", builddgPadDay);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        return "risk/risk-look";
    }
    @RequestMapping(value = "risk-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(BuilddgPadDay builddgPadDay,@RequestParam("startTime")String startTime, @RequestParam("endTime")String endTime,@ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            BuilddgPadDay dest ;
            String id = builddgPadDay.getRowId();
            if (id != null && id.length() > 0) {
                dest = builddgPadDayManager.get(id);
                String time=startTime;
                time=time.replace("-", ".");
                endTime=endTime.replace("-", ".");
                time+=("-"+endTime);
                dest.setCrTime(time);
                dest.setCreateTime(ts);
                beanMapper.copy(builddgPadDay, dest);
            } else {
                builddgPadDay.setRowId(null);
                dest = builddgPadDay;
                String time=startTime;
                time=time.replace("-", ".");
                endTime=endTime.replace("-", ".");
                time+=("-"+endTime);
                dest.setCrTime(time);
                dest.setCreateTime(ts);
            }
            builddgPadDayManager.save(dest);
        } catch (Exception e) {
            statusCode = "300";
            message = "操作失败";
            e.printStackTrace();
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("closeCurrent", true);
        return resMap;
    }
    @RequestMapping("lookup-risk-bdId-list")
    public String orgLookupList(@ModelAttribute Page page,
                                @RequestParam Map<String, Object> parameterMap, Model model) {

        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        page = sxpzRecordManager.pagedQuery(page, propertyFilters);
        List<SxpzRecord> sxpzRecordList = (List<SxpzRecord>) page.getResult();
        page.setResult(sxpzRecordList);
        model.addAttribute("page", page);

        return "risk/risk-list-lookup";

    }
    @RequestMapping("remove")
    @ResponseBody
    public Map<String, Object> viewRemove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        builddgPadDayManager.removeById(rowId);
                    }
                }
            }
        } catch (Exception e) {
            statusCode = "300";
            message = "删除失败";
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("reload", true);
        return resMap;
    }
}
