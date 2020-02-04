package com.gx.soft.attendance.web;


import com.gx.core.export.ExcelDataNormalStrategy;
import com.gx.core.export.ExcelExportUtil;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.attendance.persistence.domain.GxSysAttRule;
import com.gx.soft.attendance.persistence.manager.*;
import com.gx.soft.common.util.DateFormatUtil;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.mobile.persistence.domain.GxSysOrgCopy;
import com.gx.soft.mobile.persistence.manager.GxSysOrgCopyManager;
import com.gx.soft.mobile.persistence.manager.VUserCopyManager;
import com.gx.soft.restservice.persistence.domain.GxSysAttendance;
import com.gx.soft.restservice.persistence.domain.GxSysAttendanceAll;
import com.gx.soft.restservice.persistence.domain.GxSysAttendanceResult;
import com.gx.soft.restservice.persistence.domain.VUserInOrgAtt;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceAllManager;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceManager;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceResultManager;
import com.gx.soft.restservice.persistence.manager.VUserInOrgAttManager;
import com.gx.soft.restservice.web.AttendanceTestController;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxSysOrgManager;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("attendance")
@SessionAttributes("user_session")
public class AttendanceController {
    static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AttendanceTestController.class.getName());

    /**
     *  考勤详情管理
     * @return
     */
    @RequestMapping("att-detail1")
    public String attDetail1(@ModelAttribute Page page,String userId, Model model, String time) {
        String start =time;
        String stTime=start+" 00:00:00";
        String endTime=start+" 23:59:59";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("filter_GED_signTime",stTime);
        paraMap.put("filter_LED_signTime",endTime);
        paraMap.put("filter_EQS_userId",userId);
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(paraMap);
//        List<VUserOrgRuleAtt> vUserOrgRuleAttList = vUserOrgRuleAttManager.find(propertyFilters);
        page.addOrder("signTime","asc");
        page = vAttAllManager.pagedQuery(page,propertyFilters);
        model.addAttribute("attList",page.getResult());
        model.addAttribute("page",page);
        return "attendance/att-detail1";
    }

    /**
     *  考勤编辑
     * @param
     * @param model
     * @return
     */
    @RequestMapping("att-input")
    public String attInput(
            String uniqueId,String userId,Timestamp oldTime, Model model) {
        GxSysAttendanceAll gxSysAttendanceAll = null;
        if (uniqueId != null) {
            gxSysAttendanceAll=gxSysAttendanceAllManager.findUniqueBy("uniqueId",uniqueId);
            model.addAttribute("att",gxSysAttendanceAll);
            model.addAttribute("oldTime",oldTime);
            model.addAttribute("userId",userId);
            return "attendance/att-edit";
        } else {
            gxSysAttendanceAll = new GxSysAttendanceAll();
            model.addAttribute("userId",userId);
            model.addAttribute("att",gxSysAttendanceAll);
            return "attendance/att-edit";
        }
    }
    /**
     *  考勤save
     * @param
     * @return
     */
    @RequestMapping(value="att-save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> attSave(GxSysAttendanceAll gxSysAttendanceAll,GxSysAttendance gxSysAttendance,String userId,Timestamp oldTime) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            GxSysAttendanceAll dest=null;
            GxSysAttendance dest2=null;
            GxSysAttendanceResult re=null;
            String uniqueId =gxSysAttendanceAll.getUniqueId();
            if(uniqueId!=null&&uniqueId.length()>0){
                Map<String, Object> paraMap = new HashMap<String, Object>();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

                Date date = sdf.parse(sdf.format(gxSysAttendance.getSignTime()));
                logger.info("gxSysAttendance.getSignTime():"+sdf.format(gxSysAttendance.getSignTime()));
                paraMap.put("filter_GED_signTime",sdf.format(gxSysAttendance.getSignTime()));
                paraMap.put("filter_LED_signTime",sdf.format(gxSysAttendance.getSignTime()));
                paraMap.put("filter_EQS_userId",userId);
                List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(paraMap);
                re=gxSysAttendanceResultManager.find(propertyFilters).get(0);

                if(oldTime.compareTo(re.getEarlyTime())==0){
                    re.setEarlyTime(gxSysAttendance.getSignTime());
                }else if(oldTime.compareTo(re.getLastTime())==0){
                    re.setLastTime(gxSysAttendance.getSignTime());
                }else{
                    if(gxSysAttendance.getSignTime().compareTo(re.getEarlyTime())<0){
                        re.setEarlyTime(gxSysAttendance.getSignTime());
                    }
                    if(gxSysAttendance.getSignTime().compareTo(re.getLastTime())>0){
                        re.setLastTime(gxSysAttendance.getSignTime());
                    }
                }

                dest=gxSysAttendanceAllManager.get(uniqueId);
                dest2=gxSysAttendanceManager.get(uniqueId);
                if(dest!=null){
                    beanMapper.copy(gxSysAttendanceAll,dest);
                    beanMapper.copy(gxSysAttendance,dest2);
                }
            } else {

            }
            gxSysAttendanceAllManager.save(dest);
            gxSysAttendanceManager.save(dest2);
            gxSysAttendanceResultManager.save(re);
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



    /**
     *  考勤查询
     * @return
     */
    @RequestMapping("att-list")
    public String attList(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page,@ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_NOTS_count","0");
        page.addOrder("signTime","desc");
        if(user.getComBdId()!=null){
            parameterMap.put("filter_LIKES_bdId",user.getComBdId());
            page.addOrder("doorControlName","asc");
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("dataOrder","asc");
        page= vUserInOrgAttManager.pagedQuery(page,propertyFilters);
        for(VUserInOrgAtt result:(List<VUserInOrgAtt>)page.getResult()){
            int workTime=Integer.parseInt(result.getWorkTime());
            int hours = workTime/3600000;
            int minutes = (workTime/1000) % 3600 /60;
//            int seconds = (workTime/1000) % 60;
            result.setWorkTime(hours+"h"+minutes+"m"
//                    +seconds+"s"
            );
        }
        model.addAttribute("page",page);
        return "attendance/att-list";
    }
    /**
     *  考勤管理
     * @return
     */
    @RequestMapping("att-list1")
    public String attList1(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page,@ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_NOTS_count","0");
        page.addOrder("signTime","desc");
        if(user.getComBdId()!=null){
            parameterMap.put("filter_LIKES_bdId",user.getComBdId());
            page.addOrder("doorControlName","asc");
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("dataOrder","asc");
        page= vUserInOrgAttManager.pagedQuery(page,propertyFilters);
        for(VUserInOrgAtt result:(List<VUserInOrgAtt>)page.getResult()){
            int workTime=Integer.parseInt(result.getWorkTime());
            int hours = workTime/3600000;
            int minutes = (workTime/1000) % 3600 /60;
//            int seconds = (workTime/1000) % 60;
            result.setWorkTime(hours+"h"+minutes+"m"
//                    +seconds+"s"
            );
        }
        model.addAttribute("page",page);
        return "attendance/att-list1";
    }

    /**
     *  考勤详情
     * @return
     */
    @RequestMapping("att-detail")
    public String attDetail(@ModelAttribute Page page,String userId, Model model, String time) {
        String start =time;
        String stTime=start+" 00:00:00";
        String endTime=start+" 23:59:59";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("filter_GED_signTime",stTime);
        paraMap.put("filter_LED_signTime",endTime);
        paraMap.put("filter_EQS_userId",userId);
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(paraMap);
//        List<VUserOrgRuleAtt> vUserOrgRuleAttList = vUserOrgRuleAttManager.find(propertyFilters);
        page.addOrder("signTime","asc");
        page = vAttAllManager.pagedQuery(page,propertyFilters);
        model.addAttribute("attList",page.getResult());
        model.addAttribute("page",page);
        return "attendance/att-detail";
    }


    /**
     *  考勤规则管理
     * @param
     * @param model
     * @return
     */
    @RequestMapping("get-all-rule")
    public String getAllRule(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page,
                             @ModelAttribute("user_session") VUser user) {
        if(user.getComBdId()!=null){
            parameterMap.put("filter_LIKES_comBdId",user.getComBdId());
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("orderNum","asc");
        page=gxSysAttRuleManager.pagedQuery(page,propertyFilters);
        List<GxSysAttRule> ruleList = (List<GxSysAttRule>) page.getResult();
        model.addAttribute("ruleList", ruleList);
        model.addAttribute("page",page);

        return "attendance/all-rule";
    }

    /**
     *  编辑考勤规则
     * @param
     * @param model
     * @return
     */
    @RequestMapping("rule-input")
    public String input(
            String orgRowId, Model model) {
        GxSysAttRule gxSysAttRule = null;
        if (orgRowId != null) {
            gxSysAttRule = gxSysAttRuleManager.findUniqueBy("orgRowId",orgRowId);
            model.addAttribute("orgId", orgRowId);
            model.addAttribute("model", gxSysAttRule);
            return "attendance/rule-edit";
        } else {
            gxSysAttRule = new GxSysAttRule();
            model.addAttribute("model", gxSysAttRule);
            return "attendance/rule-input";
        }
    }
    /**
     *  编辑考勤规则后更新
     * @param
     * @return
     */
    @RequestMapping(value="rule-save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(GxSysAttRule gxSysAttRule, String orgId, String orgName,String comBdId) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
                GxSysAttRule dest=null;
                String id =gxSysAttRule.getRowId();
            if(id!=null&&id.length()>0){
                dest=gxSysAttRuleManager.get(id);
                if(dest!=null){
                    beanMapper.copy(gxSysAttRule,dest);
                    dest.setUpdateTime(ts);
                    gxSysAttRuleManager.save(dest);
                }
            } else {
                if (StringUtils.validateString(orgId)) {
                    String[] orgIdArr = orgId.split(",");
                    String[] orgNameArr = orgName.split(",");
                    String[] comBdIdArr = comBdId.split(",");
                    int i=0;
                    for (String eOrgId : orgIdArr) {
                        gxSysAttRule.setRowId(null);
                        dest=gxSysAttRule;
                        dest.setCreateTime(ts);
                        dest.setOrgRowId(eOrgId);
                        dest.setOrgName(orgNameArr[i]);
                        dest.setComBdId(comBdIdArr[i]);
                        if(gxSysAttRuleManager.getCount()==0){
                            dest.setOrderNum(1);
                        }else {
                            String hql = "SELECT max(t.orderNum) FROM  GxSysAttRule t";
                            List maxNum = gxSysAttRuleManager.find(hql);
                            dest.setOrderNum(Integer.valueOf(maxNum.get(0).toString())+1);
                        }
                        gxSysAttRuleManager.save(dest);
                        i++;
                    }
                }

            }

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
    /**
     * 查找带回-组织页面
     *
     * @param page
     * @param parameterMap
     * @param model
     * @return
     */
    @RequestMapping("lookup-org-list")
    public String orgLookupList(@ModelAttribute Page page,
                                @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user) {
        if(user.getComBdId()!=null){
            parameterMap.put("filter_EQS_orgBdId",user.getComBdId());
        }
        parameterMap.put("filter_EQS_orgType","3");
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        page = vNoOrgManager.pagedQuery(page, propertyFilters);
        List<GxSysOrgCopy> orgList = (List<GxSysOrgCopy>) page.getResult();
        page.setResult(orgList);
        model.addAttribute("page", page);
        return "attendance/org-list-lookup";
    }
    /**
     * 规则的删除
     *
     * @param delids
     * @return
     */
    @RequestMapping("rule-remove")
    public @ResponseBody
    Map<String, Object> ruleRemove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null) {
                        GxSysAttRule sysAttRule=gxSysAttRuleManager.get(rowId);
                        if (sysAttRule != null) {
                            gxSysAttRuleManager.remove(sysAttRule);
                        }

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

    /**
     * 规则的删除
     *
     * @param
     * @return
     */
    @RequestMapping("export")
    public @ResponseBody
    Map<String, Object> export(HttpServletResponse response,String start,String end,String type,@ModelAttribute("user_session") VUser user) {
        Page page=new Page();
        if(start!=null){
            int index=start.lastIndexOf(",");
            start=start.substring(index==-1?0:index+1);
        }
        if (end!=null){
            int index1=end.lastIndexOf(",");
            end=end.substring(index1==-1?0:index1+1);
        }
        if(type!=null){
            int index=type.lastIndexOf(",");
            type=type.substring(index==-1?0:index+1);
        }
        page.setPageSize(100000000);
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "导出成功";
        String[] columnNameArr = {"signTime", "userName","earlyTime","lastTime","userType","orgName"};
        String fileName = "考勤";
        Map<String, Object> metaMap = new HashMap<>();
        String[] columnComment = {"日期", "姓名","进","出","工种","部门"};
        Integer[] columnWidth = {100, 100, 250,250,100,250};
        metaMap.put("columnName", columnNameArr);
        metaMap.put("columnWidth", columnWidth);
        metaMap.put("columnComment", columnComment);
        ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataNormalStrategy());
        Map<String,Object> parameterMap=new HashMap<>();
        parameterMap.put("filter_GED_signTime",start);
        parameterMap.put("filter_LED_signTime",end);
        parameterMap.put("filter_LIKES_bdId",user.getComBdId());
        String bdId=user.getComBdId()==null?"":user.getComBdId();
        if(type.equals("0")&&!bdId.equals("")){
            String orgId="";
            if(bdId.equals("010203")){
                orgId="010203-";
            }else if(bdId.equals("010201")||bdId.equals("010802")){
                orgId="010201-010802";
            }else if (bdId.equals("010401")||bdId.equals("010501")){
                orgId="010401-010501";
            }
            parameterMap.put("filter_INS_orgId",orgId);
        }else if(type.equals("1")&&!bdId.equals("")){
            parameterMap.put("filter_INS_orgId",bdId+"01");
        }else if(type.equals("2")&&!bdId.equals("")){
            String orgList="";
            for(GxSysOrgCopy orgCopy:gxSysOrgCopyManager.findBy("parentOrgId",bdId)){
                if(orgCopy.getRowId().equals(bdId+"01")||orgCopy.getRowId().equals(bdId+"03")){
                    continue;
                }
                orgList+=orgCopy.getRowId()+",";
            }
            if (orgList.length() > 0) {
                orgList = orgList.substring(0, orgList.length() - 1);
            }
            parameterMap.put("filter_INS_orgId",orgList);
        }else if(type.equals("3")&&!bdId.equals("")){
            String orgList="";
            for(GxSysOrgCopy orgCopy:gxSysOrgCopyManager.findBy("parentOrgId",bdId+"03")){
                orgList+=orgCopy.getRowId()+",";
            }
            if (orgList.length() > 0) {
                orgList = orgList.substring(0, orgList.length() - 1);
            }
            parameterMap.put("filter_INS_orgId",orgList);
        }
        List<PropertyFilter> propertyFilterList=PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("signTime","desc");
        page.addOrder("userType","desc");
        page.addOrder("orgName","desc");
        page=vUserInOrgAttManager.pagedQuery(page,propertyFilterList);
        try {
            excelExportUtil.exportBean1(response, fileName,(List<VUserInOrgAtt>)page.getResult(), metaMap);
        } catch (Exception e) {
            statusCode = "300";
            message = "导出失败";
            e.printStackTrace();
        }
        resMap.put("statusCode",statusCode);
        resMap.put("message",message);
        return resMap;
    }

    /**
     * 组织关系ztrre-考勤
     * @param model
     * @return
     */
    @RequestMapping("attendance-manager")
    public String attendanceManagerPage(Model model) {
        return "attendance/attendance-org-manager";
    }

    /**
     *  考勤查询
     * @return
     */
    @RequestMapping("att-list-test")
    public String attListTest(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page,@ModelAttribute("user_session") VUser user,String level){
        parameterMap.put("filter_NOTS_count","0");
        page.addOrder("signTime","desc");
        if(user.getComBdId()!=null){
            parameterMap.put("filter_LIKES_bdId",user.getComBdId());
            parameterMap.put("filter_EQS_orgLevel",level);
            page.addOrder("doorControlName","asc");
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("dataOrder","asc");
        page= vUserInOrgAttManager.pagedQuery(page,propertyFilters);
        for(VUserInOrgAtt result:(List<VUserInOrgAtt>)page.getResult()){
            int workTime=Integer.parseInt(result.getWorkTime());
            int hours = workTime/3600000;
            int minutes = (workTime/1000) % 3600 /60;
//            int seconds = (workTime/1000) % 60;
            result.setWorkTime(hours+"h"+minutes+"m"
//                    +seconds+"s"
            );
        }
        model.addAttribute("level",level);
        model.addAttribute("page",page);
        return "attendance/att-org-list";
    }


    @Resource(name="gxSysOrgManager")
    private GxSysOrgManager gxSysOrgManager;
    @Resource(name = "gxSysAttRuleManager")
    private GxSysAttRuleManager gxSysAttRuleManager;
    @Resource(name="sysUserManager")
    private SysUserManager gxUserManager;
    @Resource(name="vUserManager")
    private VUserManager vUserManager;
    @Resource(name="vNoOrgManager")
    private VNoOrgManager vNoOrgManager;
    @Resource(name="gxSysAttendanceResultManager")
    private GxSysAttendanceResultManager gxSysAttendanceResultManager;
    @Resource(name="vAttAllManager")
    private VAttAllManager vAttAllManager;
    @Resource(name="gxSysAttendanceManager")
    private GxSysAttendanceManager gxSysAttendanceManager;
    @Resource(name="gxSysAttendanceAllManager")
    private GxSysAttendanceAllManager gxSysAttendanceAllManager;
    @Resource(name="vUserInOrgAttManager")
    private VUserInOrgAttManager vUserInOrgAttManager;
    @Resource(name="vUserCopyManager")
    private VUserCopyManager vUserCopyManager;
    @Autowired
    private GxSysOrgCopyManager gxSysOrgCopyManager;
    BeanMapper beanMapper =new BeanMapper();
}
