package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.attendance.persistence.domain.GxSysScore;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.mobile.persistence.domain.GxSysOrgCopy;
import com.gx.soft.mobile.persistence.manager.GxSysOrgCopyManager;
import com.gx.soft.mobile.persistence.manager.VUserCopyManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.domain.SysTypeDic;
import com.gx.soft.sb.persistence.manager.SysTypeDicManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mobile-user")
@SessionAttributes(value={"user_session"})
public class MobileUserController {
    private static Logger logger = LoggerFactory
            .getLogger(MobileUserController.class);
    @Resource(name="sysUserManager")
    private SysUserManager sysUserManager;
    @Resource(name="gxSysOrgCopyManager")
    private GxSysOrgCopyManager gxSysOrgCopyManager;
    @Resource(name="vUserCopyManager")
    private VUserCopyManager vUserCopyManager;
    @Autowired
    private SysTypeDicManager sysTypeDicManager;
    @Autowired
    private VUserManager vUserManager;
    /**
     * 获取人数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "userType-count", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult userTypeCount() {
        logger.info("mobile-user------->user-count 获取人数");
        String statusCode = "1";// 成功
        String message = "获取人数信息成功";
        List<GxSysScore> gxSysScoreList=null;
        List<SysTypeDic> dicList = sysTypeDicManager.findBy("dicType", "user_type");
        try{
            String hql = "select count(*) from GxSysUser where userType = ?";
            for(SysTypeDic sysTypeDic : dicList){
                Object[] values = {sysTypeDic.getDicName()};
                Integer count = sysUserManager.getCount(hql, values);
                sysTypeDic.setDicTotal(count);
            }
        } catch (Exception ex) {
            statusCode = "-1";
            message = "获取人数信息失败";
            logger.error("mobile-user------->user-count 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode, dicList, message);
    }



    /**
     * 获取orglist
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "org-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult orgList(@RequestParam Map<String, Object> parameterMap,String userId) {
        logger.info("mobile-user------->user-count orglist");
        String statusCode = "1";// 成功
        String message = "获取orglist信息成功";
        List<GxSysOrgCopy> orgCopyList=null;
        try{
            List<PropertyFilter> propertyFilters = PropertyFilter
                    .buildFromMap(parameterMap);
            orgCopyList=gxSysOrgCopyManager.find("dataOrder", true,propertyFilters);
        } catch (Exception ex) {
            statusCode = "-1";
            message = "获取orglist信息失败";
            logger.error("mobile-user------->user-orglist 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,orgCopyList , message);
    }

    /**
     * 获取orgdetail
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "org-list-detail", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult orgUserList(@ModelAttribute Page page, String orgId,String userName,String userMobileNum,String userType,String orgName ,String userId,
                           @RequestParam Map<String, Object> parameterMap) {
        VUser user = vUserManager.findUniqueBy("userId",userId);
        logger.info("mobile-user------->user-count orglistdetail");
        String statusCode = "1";// 成功
        String message = "获取orglistdetail信息成功";
        List<VUser> userList =null;
        try{
            if(user.getComBdId()!=null){
                parameterMap.put("filter_LIKES_comBdId", user.getComBdId());
            }
            if(user.getpOrgId().equals("0101")&&orgId.equals("0101")){
                parameterMap.put("filter_LIKES_comBdId", null);
            }
            parameterMap.put("filter_EQS_orgId", orgId);
            parameterMap.put("filter_LIKES_orgName", orgName);
            parameterMap.put("filter_LIKES_userName", userName);
            parameterMap.put("filter_EQS_userMobileNum", userMobileNum);
            parameterMap.put("filter_LIKES_userType", userType);
            page.addOrder("dataOrder", "asc");
            List<PropertyFilter> propertyFilters = PropertyFilter
                    .buildFromMap(parameterMap);
            page = vUserCopyManager.pagedQuery(page, propertyFilters);
            userList = (List<VUser>) page.getResult();
        } catch (Exception ex) {
            statusCode = "-1";
            message = "获取orgdetail信息失败";
            logger.error("mobile-user------->user-orglistdetail 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,userList, message);
    }
}
