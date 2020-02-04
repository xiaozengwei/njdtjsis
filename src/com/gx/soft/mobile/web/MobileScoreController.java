package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.attendance.persistence.domain.GxSysScore;
import com.gx.soft.attendance.persistence.domain.VUserOrgScore;
import com.gx.soft.attendance.persistence.manager.GxSysScoreManager;
import com.gx.soft.attendance.persistence.manager.VUserOrgScoreManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.manager.EquipmentInfoManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mobile-score")
@SessionAttributes("user_session")
public class MobileScoreController {
    // 日志
    private static Logger logger = LoggerFactory.getLogger(MobileSbController.class);

    @Autowired
    private VUserManager vUserManager;

    @Autowired
    private EquipmentInfoManager equipmentInfoManager;

    @Resource(name="gxSysScoreManager")
    private GxSysScoreManager gxSysScoreManager;
    @Resource(name="vUserOrgScoreManager")
    private VUserOrgScoreManager vUserOrgScoreManager;
    /**
     *  积分查询
     * @param
     * @param model
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "score-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult scoreList(@ModelAttribute Page page, String userId) {
        VUser user = vUserManager.findUniqueBy("userId",userId);
        logger.info("mobile-score------->score-list 获取积分信息列表");
        String statusCode = "1";// 成功
        String message = "获取积分信息成功";
        List<GxSysScore> gxSysScoreList=null;
        try{
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            List<PropertyFilter> propertyFilters = PropertyFilter
                    .buildFromMap(parameterMap);
            page.addOrder("orderNum","desc");
            page = gxSysScoreManager.pagedQuery(page,propertyFilters);
        } catch (Exception ex) {
            statusCode = "-1";
            message = "获取积分信息失败";
            logger.error("mobile-score------->score-list 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode, page.getResult(), message);
    }


    /**
     *  积分详情查询
     * @param
     * @param model
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "score-detail", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult scoreDetail(@ModelAttribute Page page,String userId,String startTime,String endTime){
        VUser user = vUserManager.findUniqueBy("userId",userId);
        logger.info("mobile-score------->score-detail 获取积分详情信息列表");
        String statusCode = "1";// 成功
        String message = "获取积分详情信息成功";
        List<VUserOrgScore> vUserOrgScoreList=null;
        try{
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            parameterMap.put("filter_EQS_userId",userId);
            parameterMap.put("filter_GED_recordTime",startTime);
            parameterMap.put("filter_LED_recordTime",endTime);
            List<PropertyFilter> propertyFilters = PropertyFilter
                    .buildFromMap(parameterMap);
            page.addOrder("dataOrder","desc");
            page=vUserOrgScoreManager.pagedQuery(page,propertyFilters);
        } catch (Exception ex) {
            statusCode = "-1";
            message = "获取积分信息失败";
            logger.error("mobile-score------->score-detail 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode, page.getResult(), message);
    }
}
