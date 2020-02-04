package com.gx.soft.robot.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.mobile.persistence.domain.BuilddgPadDay;
import com.gx.soft.robot.persistence.domain.RobotWords;
import com.gx.soft.robot.persistence.manager.RobotWordsManager;
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
 * Created by adminstrator on 2019/6/17.
 */
@Controller
@SessionAttributes("user_session")
@RequestMapping("robotWeb")
public class RobotWebController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private RobotWordsManager robotWordsManager;

    @RequestMapping("robot-list")
    public String viewList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_EQS_rwordsId",user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = robotWordsManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "robot/robot-list";
    }
    @RequestMapping("robot-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        RobotWords robotWords;
        if (rowId != null) {
            robotWords = robotWordsManager.get(rowId);

        } else {
            robotWords = new RobotWords();
        }
        model.addAttribute("robotWords", robotWords);
        model.addAttribute("bdName", robotWords.getRwordsId());
        return "robot/robot-input";
    }
    @RequestMapping("robot-look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        RobotWords robotWords;
        robotWords = robotWordsManager.get(rowId);
        String bdName=robotWords.getRwordsId();
        model.addAttribute("robotWords", robotWords);
        model.addAttribute("bdName", bdName);
        return "robot/robot-look";
    }
    @RequestMapping(value = "robot-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(RobotWords robotWords,@RequestParam("bdName")String bdName, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            RobotWords dest ;
            String id = robotWords.getRowId();
            if (id != null && id.length() > 0) {
                dest = robotWordsManager.get(id);
                if(bdName!=null){
                    robotWords.setRwordsId(bdName);
                }
                beanMapper.copy(robotWords, dest);
            } else {
                robotWords.setRowId(null);
                robotWords.setRwordsId(bdName);
                robotWords.setCreateTime(ts);
                dest = robotWords;
            }
            robotWordsManager.save(dest);
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
                        robotWordsManager.removeById(rowId);
                        System.out.println();
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
