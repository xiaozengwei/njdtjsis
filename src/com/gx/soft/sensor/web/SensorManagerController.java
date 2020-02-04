package com.gx.soft.sensor.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.sensor.persistence.domain.SensorDataRecordHistory;
import com.gx.soft.sensor.persistence.domain.SensorIndex;
import com.gx.soft.sensor.persistence.manager.SensorDataRecordHistoryManager;
import com.gx.soft.sensor.persistence.manager.SensorDataRecordReltimeManager;
import com.gx.soft.sensor.persistence.manager.SensorIndexManager;
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
 * Created by adminstrator on 2019/5/29.
 */
@Controller
@RequestMapping("manager")
@SessionAttributes("user_session")
public class SensorManagerController {
    private BeanMapper beanMapper = new BeanMapper();

    @Autowired
    private SensorIndexManager sensorIndexManager;

    @Autowired
    private SensorDataRecordReltimeManager sensorDataRecordReltimeManager;

    @Autowired
    private SensorDataRecordHistoryManager sensorDataRecordHistoryManager;
    /**
     * 传感器设备管理页面
     *
     * @param page
     * @param parameterMap
     * @param model
     * @return
     */
    @RequestMapping("manager-list")
    public String manager_list(Page page, String orderField, String orderDirection,
                               @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user) {
        parameterMap.put("filter_EQS_sensorSiteBdId",user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        page.addOrder("orderNum", "desc");
        page = sensorIndexManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);
        model.addAttribute("orderField", orderField);
        model.addAttribute("orderDirection", orderDirection);

        return "sensor/manager/manager-list";

    }

    @RequestMapping("manager-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        SensorIndex sensorIndex;
        if (rowId != null) {
            sensorIndex = sensorIndexManager.get(rowId);
        } else {
            sensorIndex = new SensorIndex();
        }
        model.addAttribute("sensorIndex", sensorIndex);
        return "sensor/manager/sensor-input";
    }

    @RequestMapping(value = "manager-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(SensorIndex sensorIndex,@RequestParam("bdId")String bdId,@RequestParam("bdName")String bdName) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            SensorIndex dest ;
            String id = sensorIndex.getRowId();
            if (id != null && id.length() > 0) {
                dest = sensorIndexManager.get(id);
                dest.setSensorSiteBdId(bdId);
                dest.setSensorSiteBd(bdName);
                beanMapper.copy(sensorIndex, dest);
            } else {
                String hql="SELECT max(orderNum) from SensorIndex";
                List<Long> orderNum = sensorDataRecordHistoryManager.find(hql);

                sensorIndex.setRowId(null);
                dest = sensorIndex;
                if(orderNum.size()!=0) {
                    dest.setOrderNum((long)(orderNum.get(0) + 1));
                }else {
                    dest.setOrderNum((long)1);
                }
                dest.setSensorSiteBdId(bdId);
                dest.setSensorSiteBd(bdName);
            }
            sensorIndexManager.save(dest);
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
                        sensorIndexManager.removeById(rowId);
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
    @RequestMapping("manager-look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        SensorIndex sensorIndex;
        sensorIndex = sensorIndexManager.get(rowId);
        model.addAttribute("sensorIndex", sensorIndex);
        return "sensor/manager/manager-look";
    }
}
