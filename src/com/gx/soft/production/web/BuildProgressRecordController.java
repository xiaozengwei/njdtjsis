package com.gx.soft.production.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.mobile.persistence.domain.BuildProgressRecord;
import com.gx.soft.mobile.persistence.domain.BuilddgPadDay;
import com.gx.soft.mobile.persistence.manager.BuildProgressManager;
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
 * Created by adminstrator on 2019/5/28.
 */
@Controller
@RequestMapping("production")
@SessionAttributes("user_session")
public class BuildProgressRecordController {
    private BeanMapper beanMapper = new BeanMapper();

    @Autowired
    private BuildProgressManager buildProgressManager;
    @RequestMapping("production-list")
    public String List(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        if(!user.getUserId().equals("yu_jx")) {
            parameterMap.put("filter_EQS_bdId", user.getComBdId());
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("ext1", "desc");
        page = buildProgressManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "production/production-list";
    }
    @RequestMapping("production-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        BuildProgressRecord buildProgressRecord;
        if (rowId != null) {
            buildProgressRecord = buildProgressManager.get(rowId);
        } else {
            buildProgressRecord = new BuildProgressRecord();
        }
        model.addAttribute("buildProgressRecord", buildProgressRecord);
        return "production/production-input";
    }
    @RequestMapping(value = "production-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(BuildProgressRecord buildProgressRecord,@ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            BuildProgressRecord dest ;
            String id = buildProgressRecord.getRowId();
            if (id != null && id.length() > 0) {
                dest = buildProgressManager.get(id);
                beanMapper.copy(buildProgressRecord, dest);
            } else {
                buildProgressRecord.setRowId(null);
                dest = buildProgressRecord;
            }
            buildProgressManager.save(dest);
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
    @RequestMapping("remove")
    @ResponseBody
    public Map<String, Object> remove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        buildProgressManager.removeById(rowId);
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
    @RequestMapping("production-look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        BuildProgressRecord buildProgressRecord;
        buildProgressRecord = buildProgressManager.get(rowId);
        model.addAttribute("buildProgressRecord", buildProgressRecord);
        return "production/production-look";
    }
}
