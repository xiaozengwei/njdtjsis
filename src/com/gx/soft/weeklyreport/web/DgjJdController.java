package com.gx.soft.weeklyreport.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.view.persistence.domain.DeviceCameraRecord;
import com.gx.soft.weeklyreport.persistence.domain.DgjJd;
import com.gx.soft.weeklyreport.persistence.domain.WeeklyReport;
import com.gx.soft.weeklyreport.persistence.manager.DgjJdManager;
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
 * Created by adminstrator on 2019/8/29.
 */
@Controller
@RequestMapping("dgj")
@SessionAttributes("user_session")
public class DgjJdController {
    @Autowired
    private DgjJdManager dgjJdManager;

    private BeanMapper beanMapper = new BeanMapper();
    @RequestMapping("dgj-list")
    public String dgjList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_EQS_bdId", user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("scTime", "desc");
        page = dgjJdManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "weeklyreport/dgj/dgj-list";
    }
    @RequestMapping("dgj-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        DgjJd dgjJd;
        if (rowId != null) {
            dgjJd = dgjJdManager.get(rowId);
        } else {
            dgjJd = new DgjJd();

        }
        model.addAttribute("dgjJd",dgjJd);
        return "weeklyreport/dgj/dgj-input";
    }
    @RequestMapping(value = "dgj-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(DgjJd dgjJd, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            DgjJd dest ;
            String id = dgjJd.getRowId();
            if (id != null && id.length() > 0) {
                dest = dgjJdManager.get(id);
                beanMapper.copy(dgjJd, dest);
                dest.setUploadTime(ts);
            } else {
                dgjJd.setRowId(null);
                dest = dgjJd;
                dest.setCreateTime(ts);
                if(user.getComBdId()!=null){
                    dest.setBdId(user.getComBdId());
                }
                dest.setCreateUser(user.getUserName());
            }
            dgjJdManager.save(dest);
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
    public Map<String, Object> viewRemove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        dgjJdManager.removeById(rowId);
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
