package com.gx.soft.worksite.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.worksite.persistence.domain.WorksiteIndex;
import com.gx.soft.worksite.persistence.domain.WorksiteRecord;
import com.gx.soft.worksite.persistence.manager.WorkSiteIndexManager;
import com.gx.soft.worksite.persistence.manager.WorksiteRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/14.
 */
@Controller
@RequestMapping("worksiteTime")
@SessionAttributes("user_session")
public class WorkSiteTimeController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private WorkSiteIndexManager workSiteIndexManager;
    @Autowired
    private WorksiteRecordManager worksiteRecordManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @RequestMapping("worksiteTime-list")
    public String queryWorksiteList(@ModelAttribute Page page,
                                    @RequestParam(required = false, defaultValue = "") String orderField,
                                    @RequestParam(required = false, defaultValue = "") String orderDirection,
                                    @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user) {
        if(!user.getUserId().equals("hu_b")) {
            parameterMap.put("filter_EQS_bdId", user.getComBdId());
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = worksiteRecordManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "worksite/time/worksiteTime-list";
    }
    @RequestMapping("worksiteTime-input")
    public String input(String rowId, Model model) {
        WorksiteRecord worksiteRecord;
        if (rowId != null) {
            worksiteRecord = worksiteRecordManager.get(rowId);
        } else {
            worksiteRecord = new WorksiteRecord();
        }
        model.addAttribute("worksiteRecord", worksiteRecord);
        return "worksite/time/worksiteTime-input";
    }
    @RequestMapping("look")
    public String look(String rowId, Model model) {
        WorksiteRecord worksiteRecord;
        if (rowId != null) {
            worksiteRecord = worksiteRecordManager.get(rowId);
        } else {
            worksiteRecord = new WorksiteRecord();
        }
        model.addAttribute("worksiteRecord", worksiteRecord);
        return "worksite/time/worksiteTime-look";
    }
    @RequestMapping("lookup-worksiteId-list")
    public String orgLookupList(@ModelAttribute Page page,
                                @RequestParam Map<String, Object> parameterMap, Model model) {

        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        page = workSiteIndexManager.pagedQuery(page, propertyFilters);
        List<WorksiteIndex> worksiteIndexList = (List<WorksiteIndex>) page.getResult();
        page.setResult(worksiteIndexList);
        model.addAttribute("page", page);

        return "worksite/time/worksite-list-lookup";

    }
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save( WorksiteRecord worksiteRecord, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            WorksiteRecord dest ;
            String id = worksiteRecord.getRowId();
            if (id != null && id.length() > 0) {
                dest = worksiteRecordManager.get(id);
                WorksiteIndex index=workSiteIndexManager.get(worksiteRecord.getWorksiteId());
                worksiteRecord.setBdId(index.getBdId());
                worksiteRecord.setBdName(index.getBdName());
                worksiteRecord.setBdIntro(index.getExt1());
                beanMapper.copy(worksiteRecord, dest);
                dest.setUpdateTime(ts);
                System.out.print(ts);
            } else {
                worksiteRecord.setRowId(null);
                WorksiteIndex index=workSiteIndexManager.get(worksiteRecord.getWorksiteId());
                worksiteRecord.setBdId(index.getBdId());
                worksiteRecord.setBdName(index.getBdName());
                worksiteRecord.setBdIntro(index.getExt1());
                dest = worksiteRecord;
                dest.setCreateTime(ts);
            }
            worksiteRecordManager.save(dest);
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
    public @ResponseBody
    Map<String, Object> remove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        worksiteRecordManager.removeById(rowId);
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
