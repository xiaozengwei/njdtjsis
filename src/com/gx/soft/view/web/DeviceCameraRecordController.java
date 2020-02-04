package com.gx.soft.view.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.view.persistence.domain.DeviceCameraRecord;
import com.gx.soft.view.persistence.manager.DeviceCameraRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/5/13.
 */
@Controller
@SessionAttributes("user_session")
public class DeviceCameraRecordController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private DeviceCameraRecordManager deviceCameraRecordManager;

    @RequestMapping("view/view-list")
    public String viewList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_EQS_bdId",user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page = deviceCameraRecordManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "view/view-list";
    }



    @RequestMapping("view/view-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        DeviceCameraRecord deviceCameraRecord;
        if (rowId != null) {
            deviceCameraRecord = deviceCameraRecordManager.get(rowId);
        } else {
            deviceCameraRecord = new DeviceCameraRecord();
        }
        model.addAttribute("deviceCameraRecord", deviceCameraRecord);
        return "view/view-input";
    }

    @RequestMapping("view/view-show")
    public String show(@RequestParam(value = "url", required = false) String url, Model model) {
        model.addAttribute("url",url);
        return "view/view-show";
    }

    @RequestMapping(value = "view/view-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(DeviceCameraRecord deviceCameraRecord, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            DeviceCameraRecord dest ;
            String id = deviceCameraRecord.getRowId();
            if (id != null && id.length() > 0) {
                dest = deviceCameraRecordManager.get(id);
                beanMapper.copy(deviceCameraRecord, dest);
                dest.setUpdateTime(ts);
            } else {
                deviceCameraRecord.setRowId(null);
                dest = deviceCameraRecord;
                dest.setCreateTime(ts);
            }
            deviceCameraRecordManager.save(dest);
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

    @RequestMapping("view/remove")
    @ResponseBody
    public Map<String, Object> viewRemove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        deviceCameraRecordManager.removeById(rowId);
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
