package com.gx.soft.generalize.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.mobile.persistence.domain.BuilddgPadDay;
import com.gx.soft.mobile.persistence.domain.ByProjectIntroduction;
import com.gx.soft.mobile.persistence.manager.ByProIntroManager;
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
 * Created by adminstrator on 2019/6/11.
 */
@Controller
@RequestMapping("generalize")
@SessionAttributes("user_session")
public class GeneralizeController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    ByProIntroManager byProIntroManager;
    @RequestMapping("generalize-list")
    public String generalizeList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
//        page.addOrder("dataOrder", "createTime");
        page = byProIntroManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "generalize/generalize-list";
    }
    @RequestMapping("generalize-input")
    public String generalizeInput(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        ByProjectIntroduction byProjectIntroduction;
        if (rowId != null) {
            byProjectIntroduction = byProIntroManager.get(rowId);
        } else {
            byProjectIntroduction = new ByProjectIntroduction();
        }
        model.addAttribute("byProjectIntroduction", byProjectIntroduction);
        return "generalize/generalize-input";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(ByProjectIntroduction byProjectIntroduction,@ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            ByProjectIntroduction dest=null;
            String id = byProjectIntroduction.getRowId();
            if (id != null && id.length() > 0) {
                dest = byProIntroManager.get(id);
                dest.setCreateTime(ts);
                beanMapper.copy(byProjectIntroduction, dest);
            }
            byProIntroManager.save(dest);
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
}
