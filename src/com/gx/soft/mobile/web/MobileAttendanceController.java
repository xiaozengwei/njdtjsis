package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.attendance.persistence.domain.VAttAll;
import com.gx.soft.attendance.persistence.manager.GxSysAttRuleManager;
import com.gx.soft.attendance.persistence.manager.VAttAllManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.restservice.persistence.domain.GxSysAttendanceResult;
import com.gx.soft.restservice.persistence.domain.VUserInOrgAtt;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceResultManager;
import com.gx.soft.restservice.persistence.manager.VUserInOrgAttManager;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("mobile-attendance")
@SessionAttributes("user_session")
public class MobileAttendanceController {
    @Resource(name="gxSysOrgManager")
    private GxSysOrgManager gxSysOrgManager;
    @Resource(name = "gxSysAttRuleManager")
    private GxSysAttRuleManager gxSysAttRuleManager;
    @Resource(name="sysUserManager")
    private SysUserManager gxUserManager;
    @Resource(name="vUserManager")
    private VUserManager vUserManager;
    @Resource(name="vAttAllManager")
    private VAttAllManager vAttAllManager;
    @Resource(name="vUserInOrgAttManager")
    private VUserInOrgAttManager vUserInOrgAttManager;
    @Resource(name="gxSysAttendanceResultManager")
    private  GxSysAttendanceResultManager gxSysAttendanceResultManager;
    @Autowired
    private SysTypeDicManager sysTypeDicManager;

    private static Logger logger = LoggerFactory.getLogger(MobileSbController.class);


    /**
     *  考勤查询（取当天打卡）
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "att-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult attList( @ModelAttribute Page page,String userId,String userName,String start,String end,String bdId) {
        VUser user = vUserManager.findUniqueBy("userId",userId);
        logger.info("mobile-attendance------->addentance-list 考勤信息");
        String statusCode = "1";// 成功
        String message = "获取考勤信息成功";
        try{
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String time = sdf.format(date);
            String stTime=null;
            String endTime=null;
            Map<String,Object> paramMap=new HashMap<String,Object>();
            if(start!=null&&!start.equals("")){
                stTime=start+" 00:00:00";
            }else{
                stTime="2019-04-25 00:00:00";
            }
            if(end!=null&&!end.equals("")){
                endTime=end+" 23:59:59";
            }else{
                endTime=time+" 23:59:59";
            }
            if((start==null&&end==null)||(start.equals("")&&end.equals(""))){
                stTime=time+" 00:00:00";
                endTime=time+" 23:59:59";
            }
            if(user.getComBdId()!=null){
                paramMap.put("filter_LIKES_bdId",user.getComBdId());
            }else{
                paramMap.put("filter_LIKES_bdId",bdId);
            }
            paramMap.put("filter_GED_signTime",stTime);
            paramMap.put("filter_LED_signTime",endTime);
            paramMap.put("filter_LIKES_userName",userName);
            paramMap.put("filter_NOTS_count","0");
            List<PropertyFilter> propertyFilterList=PropertyFilter.buildFromMap(paramMap);
            page.addOrder("dataOrder","asc");
            page = vUserInOrgAttManager.pagedQuery(page,propertyFilterList);
            for(VUserInOrgAtt result:(List<VUserInOrgAtt>)page.getResult()){
                int workTime=Integer.parseInt(result.getWorkTime());
                int hours = workTime/3600000;
                int minutes = (workTime/1000) % 3600 /60;
                int seconds = (workTime/1000) % 60;
                result.setWorkTime(hours+"h"+minutes+"m"+seconds+"s");
            }
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取考勤信息失败";
            logger.error("mobile-attendance------->attendance-list 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode,page.getResult(),message);
    }

    /**
     *  考勤查询（取所有人最新）
     */
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "att-list", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JsonResult attList( @ModelAttribute Page page) {
//        logger.info("mobile-attendance------->addentance-list 考勤信息详情");
//        String statusCode = "1";// 成功
//        String message = "获取考勤信息成功";
//        List<VAttAll> result=new ArrayList<VAttAll>();
//        Map<String, Object> paraMap = new HashMap<String, Object>();
//        List<PropertyFilter> propertyFilters= PropertyFilter
//                .buildFromMap(paraMap);
//        List<VAttAll> vAttAllList=new ArrayList<>();
//        try{
////            page=vUserManager.pagedQuery(page,propertyFilters);
////            List<VUser> userList=(List<VUser>)page.getResult();
//            for(VUser vUser:vUserManager.getAll()){
//                List<VAttAll> list=vAttAllManager.findBy("userId",vUser.getUserId());
//                if(list.size()==0){
//                    continue;
//                }
//                Timestamp ts=list.get(0).getSignTime();
//                VAttAll one=list.get(0);
//                for(VAttAll vAttAll:list){
//                    if(ts.before(vAttAll.getSignTime())){
//                        ts = vAttAll.getSignTime();
//                        one=vAttAll;
//                    }
//                }
//                if(one.getSignType().equals("0")){
//                    one.setSignType("进");
//                }else if(one.getSignType().equals("1")){
//                    one.setSignType("出");
//                }
//                result.add(one);
//            }
//            page.setTotalCount(result.size());
//            page.setResult(result);
//            if(page.getPageCurrent()<page.getPageCount()){
//                for(int i=(page.getPageCurrent()-1)*page.getPageSize();i<((page.getPageCurrent()-1)*page.getPageSize())+page.getPageSize();i++){
//                    vAttAllList.add(result.get(i));
//                }
//            }else {
//                for(int i=(page.getPageCurrent()-1)*page.getPageSize();i<page.getTotalCount();i++){
//                    vAttAllList.add(result.get(i));
//                }
//            }
//        }catch (Exception ex) {
//            statusCode = "-1";
//            message = "获取考勤信息失败";
//            logger.error("mobile-attendance------->attendance-list 出错了");
//            ex.printStackTrace();
//        }
//        return new JsonResult(statusCode,vAttAllList,message);
//    }



    /**
     *  考勤详情查询
     * @param
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "att-detail", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult detailList(@ModelAttribute Page page, String userId, String time) {
        VUser user = vUserManager.findUniqueBy("userId",userId);
        logger.info("mobile-attendance------->addentance-list 考勤信息详情");
        String statusCode = "1";// 成功
        String message = "获取考勤详细信息成功";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        try{

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date)sdf.parse(time);
            if(userId.length()>0&&userId!=null){
                String start =time;
                String stTime=start+" 00:00:00";
                String endTime=start+" 23:59:59";
                paraMap.put("filter_GED_signTime",stTime);
                paraMap.put("filter_LED_signTime",endTime);
                paraMap.put("filter_EQS_userId",userId);
                List<PropertyFilter> propertyFilters= PropertyFilter
                        .buildFromMap(paraMap);
                page.addOrder("signTime","asc");
                page = vAttAllManager.pagedQuery(page,propertyFilters);
                List<VAttAll> vAttAllList=new ArrayList<>();
                for(VAttAll vAttAll:(List<VAttAll>)page.getResult()){
                    if(vAttAll.getSignType().equals("0")){
                        vAttAll.setSignType("进");
                    }else if(vAttAll.getSignType().equals("1")){
                        vAttAll.setSignType("出");
                    }
                    vAttAllList.add(vAttAll);
                }
                page.setResult(vAttAllList);
            }
        }catch (NullPointerException ex){
            statusCode = "-1";
            if(userId==null){
                message = "未输入用户名";
            }else {
                message = "未输入时间";
            }

            logger.error("mobile-attendance------->attendance-detail-list 出错了");
            ex.printStackTrace();
        }
        catch (ParseException ex){
            statusCode = "-1";
            message = "time格式不正确";
            logger.error("mobile-attendance------->attendance-detail-list 出错了");
            ex.printStackTrace();
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取考勤详细信息失败";
            logger.error("mobile-attendance------->attendance-detail-list 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode, page.getResult(),message);
    }

    /**
     * 考勤状态人数
     * @return
     */
    @RequestMapping(value = "att-count", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult attCount(String time) {

        logger.info("mobile-attendance------->attendance-count 获取考勤人数统计");
        String statusCode = "1";// 成功
        String message = "获取考勤人数信息成功";
        List<SysTypeDic> dicList=new ArrayList<SysTypeDic>();
        Map<String, Object> paraMap = new HashMap<String, Object>();
        SysTypeDic sysTypeDic1=new SysTypeDic();
        SysTypeDic sysTypeDic2=new SysTypeDic();
        SysTypeDic sysTypeDic3=new SysTypeDic();
        int count1=0;
        int count2=0;
        int count3=0;
        try {
            if(!time.equals("")&&time!=null){
                String stTime=time+" 00:00:00";
                String endTime=time+" 23:59:59";
                paraMap.put("filter_GED_signTime",stTime);
                paraMap.put("filter_LED_signTime",endTime);
                paraMap.put("filter_NOTS_count","0");
            }
            List<PropertyFilter> propertyFilters= PropertyFilter
                    .buildFromMap(paraMap);
            List<GxSysAttendanceResult> resultList=gxSysAttendanceResultManager.find(propertyFilters);

            for(GxSysAttendanceResult att:resultList){

                if(att.getResultType()==null){
                    throw new Exception("当天考勤结果未审核");
                }

                if(Integer.parseInt(att.getCount())>0){
                    count1++;
                    if(att.getResultType().equals("正常")){
                        count2++;
                    }else {
                        count3++;
                    }
                }

            }
            sysTypeDic1.setRowId(null);
            sysTypeDic1.setDicTotal(count1);
            sysTypeDic1.setDicType("attendanceType");
            sysTypeDic1.setDicName("当天考勤签到人数");

            sysTypeDic2.setRowId(null);
            sysTypeDic2.setDicTotal(count2);
            sysTypeDic2.setDicType("attendanceType");
            sysTypeDic2.setDicName("正常考勤人数");
            sysTypeDic3.setRowId(null);
            sysTypeDic3.setDicTotal(count3);
            sysTypeDic3.setDicType("attendanceType");
            sysTypeDic3.setDicName("异常考勤人数");


            dicList.add(sysTypeDic1);
            dicList.add(sysTypeDic2);
            dicList.add(sysTypeDic3);

        } catch (NullPointerException ex){
            statusCode = "-1";
            if(time==null){
                message = "未输入时间";
            }
            logger.error("mobile-attendance------->attendance-count 出错了");
            ex.printStackTrace();
        }catch (Exception ex) {
            statusCode = "-1";
            message = "获取考勤人数信息失败";
            message+="————"+ex.getMessage();
            logger.error("mobile-attendance------->attendance-count 出错了");
            ex.printStackTrace();
        }
        return new JsonResult(statusCode, dicList, message);
    }





    /**
     *  进场人员考勤记录
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "att-in-result", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult attList(@ModelAttribute Page page,String userId,String bdid,String doorControlName) {
        VUser user = vUserManager.findUniqueBy("userId",userId);
        logger.info("mobile-attendance------->addentance-list 考勤信息列表");
        String statusCode = "1";// 成功
        String message = "获取考勤信息列表成功";
        try{
            Map<String,Object> paramMap=new HashMap<String,Object>();
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String time=sdf.format(date);
            String st=time+" 00:00:00";
            String end=time+" 23:59:59";
            paramMap.put("filter_GED_signTime",st);
            paramMap.put("filter_LED_signTime",end);
            paramMap.put("filter_NOTS_count","0");
            paramMap.put("filter_LIKES_bdId",bdid);
            paramMap.put("filter_EQS_doorControlName",doorControlName);
            List<PropertyFilter> propertyFilterList=PropertyFilter.buildFromMap(paramMap);
            page.addOrder("signType","asc");
            page.addOrder("dataOrder","asc");
            page= vUserInOrgAttManager.pagedQuery(page,propertyFilterList);

            for(VUserInOrgAtt result:(List<VUserInOrgAtt>)page.getResult()){
                int workTime=Integer.parseInt(result.getWorkTime());
                int hours = workTime/3600000;
                int minutes = (workTime/1000) % 3600 /60;
                int seconds = (workTime/1000) % 60;
                result.setWorkTime(hours+"h"+minutes+"m"+seconds+"s");
            }
        } catch (NullPointerException ex) {
            statusCode = "-1";
            message = ex.getMessage();
            logger.error("mobile-attendance------->attendance-detail-list 出错了");
        } catch (Exception ex){
            statusCode = "-1";
            message = "获取考勤信息列表失败";
            logger.error("mobile-attendance------->attendance-detail-list 出错了");
            ex.printStackTrace();
        }

        return new JsonResult(statusCode, page.getResult(),message);
    }


    /**
     *  考勤查询（姓名 开始-结束时间）
     */
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "att-list", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JsonResult attList(@ModelAttribute Page page, String userName, String start,String end) {
//        logger.info("mobile-attendance------->addentance-list 考勤信息列表");
//        String statusCode = "1";// 成功
//        String message = "获取考勤信息列表成功";
//        try{
//            Map<String, Object> paraMap = new HashMap<String, Object>();
//            if(start!=null&&!start.equals("")){
//                String stTime=start+" 00:00:00";
//                paraMap.put("filter_GED_signTime",stTime);
//            }
//            if(end!=null&&!end.equals("")){
//                String endTime=end+" 23:59:59";
//                paraMap.put("filter_LED_signTime",endTime);
//            }
//            paraMap.put("filter_EQS_userName",userName);
//            List<PropertyFilter> propertyFilters= PropertyFilter
//                    .buildFromMap(paraMap);
//            page = vAttAllManager.pagedQuery(page,propertyFilters);
//
//        } catch (Exception ex) {
//            statusCode = "-1";
//            message = "获取考勤信息列表失败";
//            logger.error("mobile-attendance------->attendance-detail-list 出错了");
//            ex.printStackTrace();
//        }
//        return new JsonResult(statusCode, page.getResult(),message);
//    }
/**
 *  test
 */
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "a", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JsonResult a(@ModelAttribute Page page, String userName, String start,String end) {
//        logger.info("mobile-attendance------->addentance-list 考勤信息列表");
//        String statusCode = "1";// 成功
//        String message = "获取考勤信息列表成功";
//        Date m=null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try{
//
//            Calendar c = Calendar.getInstance();
//            c.setTime(sdf.parse("2019-04-01"));
//            c.add(Calendar.MONTH, +1);
//            c.add(Calendar.DATE,-1);
//            m = c.getTime();
//
//        } catch (Exception ex) {
//            statusCode = "-1";
//            message = "获取考勤信息列表失败";
//            logger.error("mobile-attendance------->attendance-detail-list 出错了");
//            ex.printStackTrace();
//        }
//        return new JsonResult(statusCode,sdf.format(m),message);
//    }





}
