package com.gx.soft.wl.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.mobile.persistence.domain.BuilddgPadDay;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.view.persistence.domain.DeviceCameraRecord;
import com.gx.soft.wl.persistence.domain.MaterialCount;
import com.gx.soft.wl.persistence.manager.MaterialCountManager;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/25.
 */
@Controller
@RequestMapping("wlcount")
@SessionAttributes("user_session")
public class WlsylController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private MaterialCountManager materialCountManager;
    @RequestMapping("wlcount-list")
    public String wlTestList(@ModelAttribute Page page,
                             @ModelAttribute("user_session") VUser user,
                             @RequestParam Map<String, Object> parameterMap, Model model) {

        if(!user.getUserId().equals("yu_j") && !user.getUserId().equals("ren_yy")){
            parameterMap.put("filter_EQS_bdId",user.getComBdId());
        }
        page.setOrderBy("createTime");
        page.setOrder("DESC");
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page = materialCountManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "wl/count/wlcount-list";
    }
    @RequestMapping("wlcount-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        MaterialCount materialCount=null;
        if (rowId != null) {
            materialCount = materialCountManager.get(rowId);
        } else {
            materialCount = new MaterialCount();
        }
        model.addAttribute("materialCount", materialCount);
        return "wl/count/wlcount-input";
    }
    @RequestMapping(value = "wlcount-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(MaterialCount materialCount, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            MaterialCount dest ;
            String id = materialCount.getRowId();
            if (id != null && id.length() > 0) {
                dest = materialCountManager.get(id);
                beanMapper.copy(materialCount, dest);
                dest.setUploadTime(ts);
            } else {
                materialCount.setRowId(null);
                dest = materialCount;
                dest.setCreateTime(ts);
                dest.setCreateName(user.getUserName());
            }
            materialCountManager.save(dest);
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
                        materialCountManager.removeById(rowId);
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
    @RequestMapping("wlcount-look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        MaterialCount materialCount;
        materialCount = materialCountManager.get(rowId);

        model.addAttribute("materialCount", materialCount);

        return "wl/count/wlcount-look";
    }

}
