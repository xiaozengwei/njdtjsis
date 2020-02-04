package com.gx.soft.restservice.web;


import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.soft.attendance.persistence.domain.GxSysAttRule;
import com.gx.soft.attendance.persistence.domain.GxSysResult;
import com.gx.soft.attendance.persistence.domain.VAtt;
import com.gx.soft.attendance.persistence.domain.VAttAll;
import com.gx.soft.attendance.persistence.manager.GxSysAttRuleManager;
import com.gx.soft.attendance.persistence.manager.GxSysResultManager;
import com.gx.soft.attendance.persistence.manager.VAttAllManager;
import com.gx.soft.attendance.persistence.manager.VAttManager;
import com.gx.soft.common.util.DateFormatUtil;
import com.gx.soft.mobile.persistence.domain.VUserCopy;
import com.gx.soft.mobile.persistence.manager.VUserCopyManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.restservice.persistence.domain.*;
import com.gx.soft.restservice.persistence.manager.*;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.persistence.manager.VUserManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.*;
import java.net.ServerSocket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("attendanceTest")
public class AttendanceTestController {
    static Logger logger = Logger.getLogger(AttendanceTestController.class.getName());
    static Timestamp timeTemp;
    @RequestMapping(value = "acceptAttendance", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResult acceptAttendance(@RequestBody String data) {
        JSONObject json=null;
        JSONArray array=null;
        Map<String, Object> paraMap = new HashMap<String, Object>();
        GxSysAttendanceResult result=new GxSysAttendanceResult();
        java.sql.Date dd=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(data!=null){
            json=JSONObject.fromObject(data);
            Object code1=json.get("Code");
            int code=10;
            if(code1!=null){
                code=(int)code1;
            }
            try{
                dd=new java.sql.Date(simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime());
            }catch (Exception e){
                e.printStackTrace();
            }
            String tt= DateFormatUtil.convertUtilDateToStringShow(new Date());
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("filter_GED_signTime",tt+" 00:00:00");
            map.put("filter_LED_signTime",tt+" 23:59:59");
            List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(map);
            int count = gxSysAttendanceResultManager.find(propertyFilters).size();
            if(count==0){
//            for(VUser vUser:vUserManager.getAll()){
                for(VUserCopy vUser:vUserCopyManager.getAll()){
                    result.setRowId(null);
                    result.setSignTime(dd);
                    result.setUserId(vUser.getUserId());
                    result.setUserName(vUser.getUserName());
                    result.setOrgName(vUser.getOrgName());
                    result.setDataOrder(vUser.getDataOrder());
                    result.setWorkTime("0");
                    GxSysAttRule gxSysAttRule=gxSysAttRuleManager.findUniqueBy("orgRowId",vUser.getOrgId());
                    if(gxSysAttRule!=null){
                        result.setRuleName(gxSysAttRule.getRuleName());
                    }
                    result.setCount("0");
                    gxSysAttendanceResultManager.save(result);
                }
            }

            if(code==1){
                if(!json.get("Data").toString().equals("null")){
                    GxSysAttendance gxSysAttendance=new GxSysAttendance();
                    GxSysAttendanceAll gxSysAttendanceAll=new GxSysAttendanceAll();
                    array=(JSONArray)json.get("Data");
                    if(array.size()!=0){
                        JSONObject js = (JSONObject)array.get(0);
                        String signTime=js.get("EventTime")==null ? ""           //打卡时间
                                :js.getString("EventTime").toString();
                        String certificateNo=js.get("PersonCode")==null ? ""     //证件号码
                                :js.getString("PersonCode").toString();
//                        String doorControlName=js.get("ControlName")==null ? ""  //门禁地址
//                                :js.getString("ControlName").toString();
                        String doorName=js.get("DoorName")==null?""
                                :js.getString("DoorName").toString();
                        String signType=js.get("EventType")==null ? ""           //签到类型
                                :js.getString("EventType").toString();
                        String cardNo=js.get("CardNo")==null?""                  //刷卡通过卡号
                                :js.getString("CardNo").toString();
                        if(certificateNo.equals("")&&!cardNo.equals("")){
                            GxSysUser gxSysUser=sysUserManager.findUniqueBy("cardNo",cardNo);
                            if(gxSysUser==null){
                                certificateNo=cardNo;
                            }else {
                                certificateNo=gxSysUser.getUserCardId();
                            }
                            gxSysAttendance.setAttendancenNum("card-"+cardNo);
                        }else{
                            gxSysAttendance.setAttendancenNum("face-"+certificateNo);
                        }
                        String uniqueId=UUID.randomUUID().toString();
                        gxSysAttendance.setUniqueId(uniqueId);
                        gxSysAttendance.setSignTime(new Timestamp(DateFormatUtil.convertDate(signTime).getTime()));
                        gxSysAttendance.setSignType(signType);
                        gxSysAttendance.setDoorControlName(doorName);
                        gxSysAttendance.setCertificateNo(certificateNo);
                        Date date=new Date();
                        Timestamp timestamp=new Timestamp(date.getTime());
                        gxSysAttendance.setLocalRecordTime(timestamp);
                        gxSysAttendanceManager.save(gxSysAttendance);

                        gxSysAttendanceAll.setUniqueId(uniqueId);
                        gxSysAttendanceAll.setSignTime(new Timestamp(DateFormatUtil.convertDate(signTime).getTime()));
                        gxSysAttendanceAll.setSignType(signType);
                        gxSysAttendanceAll.setDoorControlName(doorName);
                        gxSysAttendanceAll.setCertificateNo(certificateNo);
                        gxSysAttendanceAll.setLocalRecordTime(timestamp);
                        gxSysAttendanceAllManager.save(gxSysAttendanceAll);


                        VAtt att= vAttManager.findUniqueBy("uniqueId",uniqueId);
                        if(att!=null){
                            paraMap.put("filter_EQS_userId",att.getUserId());
                            paraMap.put("filter_GED_signTime",DateFormatUtil.convertUtilDateToStringShow(date)+" 00:00:00");
                            paraMap.put("filter_LED_signTime",DateFormatUtil.convertUtilDateToStringShow(date)+" 23:59:59");
                            List<PropertyFilter> propertyFilters1 = PropertyFilter
                                    .buildFromMap(paraMap);
                            if(gxSysAttendanceResultManager.find(propertyFilters1).size()!=0){
                                GxSysAttendanceResult result1=gxSysAttendanceResultManager.find(propertyFilters1).get(0);
                                //
                                //设置doorcontrolname，对应gxSysAttendanceResult表
                                //
                                result1.setDoorControlName("燕子矶站");
                                Long workTime=Long.parseLong(result1.getWorkTime());
                                if(Integer.parseInt(result1.getCount())>=1){
                                    if(result1.getSignType()!=null&&result1.getSignType().equals("0")&&att.getSignType().equals("1")){
                                        if(workTime==0){
                                            workTime=att.getSignTime().getTime()-result1.getEarlyTime().getTime();
                                        }else {
                                            List<VAtt> vAttList=vAttManager.find("signTime",true,propertyFilters1);
                                            workTime+=att.getSignTime().getTime()-vAttList.get(vAttList.size()-2).getSignTime().getTime();
//                                            workTime+=att.getSignTime().getTime()-timeTemp010802.getTime();
                                        }
                                        result1.setWorkTime(String .valueOf(workTime));
                                        result1.setLastTime(att.getSignTime());
                                    }
                                }

                                if(result1.getSignType()!=null&&result1.getSignType().equals("1")&&att.getSignType().equals("1")&&workTime!=null&&workTime!=0){
                                    workTime+=att.getSignTime().getTime()-result1.getLastTime().getTime();
                                    result1.setWorkTime(String .valueOf(workTime));
                                    result1.setLastTime(att.getSignTime());
                                }
                                if(result1.getWorkTime().equals("0")&&att.getSignType().equals("0")){
                                    result1.setEarlyTime(att.getSignTime());
                                    result1.setLastTime(null);
                                }
                                if(result1.getEarlyTime()==null&&att.getSignType().equals("1")){
                                    result1.setLastTime(att.getSignTime());
                                }
                                result1.setSignType(att.getSignType());
                                result1.setCount(String.valueOf(1+Integer.parseInt(result1.getCount())));
                                gxSysAttendanceResultManager.save(result1);
                            }
                        }
                    }
                }
            }
        }
        return new JsonResult("1", data, "success");
    }



    /**
     * 接口考勤数据
     */
    @RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult test(String cerNumber, String start, String end, String nocf) {
        List<GxSysAttendance> list = new ArrayList<GxSysAttendance>();
        GxSysAttendance gxSysAttendance = null;
        JSONArray jsonArray = null;
        JSONObject json=null;
        String statusCode=null;
        Map<String, String> param = new HashMap<String, String>();
        param.put("cerNumber", cerNumber);
        param.put("start", start);
        param.put("end", end);
        param.put("nocf", nocf);
        String endpoint = "http://www.zhuren360.com/attendance/getByCerNumber";
        JSONObject paramStr = JSONObject.fromObject(param);
        String result = HttpClient.sendHttpRequest(endpoint, paramStr.toString(), "application/json;charset=utf-8");
        if (result != null ) {
            json= JSONObject.fromObject(result);
            int code = (int) json.get("code");
            if (code == 10000) {
                jsonArray = (JSONArray) json.get("data");
                statusCode = "1";
            }else {
                statusCode="0";
            }
        }
//        return result;
        return new JsonResult(statusCode, jsonArray, (String)json.get("msg"));
    }

    /**
     * 当天考勤数据入库（每2分钟）
     */
    @Scheduled(cron = "0 0/2 * * * ? ")
    @RequestMapping(value = "input", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
    public void input() {
        logger.info("当天取数据定时器启动");
        long startTime = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<String, Object>();
        Timestamp ts = null;
        GxSysAttendanceResult result=new GxSysAttendanceResult();
        Date d = new Date();
        java.sql.Date dd=null;
        int t=0;
        int k=0;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = simpleDateFormat.format(d);
        JsonResult jsonResult = test("91140000110104513E", start, start, "1");
        JSONObject json=JSONObject.fromObject(jsonResult);
        String code=(String)json.get("statusCode");
        JsonResult jsonResult4 = test("91410300171075680N", start, start, "1");
        JSONObject json4=JSONObject.fromObject(jsonResult4);
        JSONArray array=null;
        JSONArray array4=null;

        if(!json.get("entity").toString().equals("null")){
            array=(JSONArray)json.get("entity");
        }
        if(!json4.get("entity").toString().equals("null")){
            array4=(JSONArray)json4.get("entity");
        }
        if(array!=null&&array4!=null){
            array.addAll(array4);
        }

//        logger.info("接口数据条数："+String.valueOf(array.size()));
        try{
            dd=new java.sql.Date(simpleDateFormat.parse(start).getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        String st=start+" 00:00:00";
        String end=start+" 23:59:59";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("filter_GED_signTime",st);
        paraMap.put("filter_LED_signTime",end);
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(paraMap);
        int count=gxSysAttendanceResultManager.find(propertyFilters).size();
        if(count==0){
//            for(VUser vUser:vUserManager.getAll()){
            for(VUserCopy vUser:vUserCopyManager.getAll()){
                result.setRowId(null);
                result.setSignTime(dd);
                result.setUserId(vUser.getUserId());
                result.setUserName(vUser.getUserName());
                result.setOrgName(vUser.getOrgName());
                result.setDataOrder(vUser.getDataOrder());
                result.setWorkTime("0");
                GxSysAttRule gxSysAttRule=gxSysAttRuleManager.findUniqueBy("orgRowId",vUser.getOrgId());
                if(gxSysAttRule!=null){
                    result.setRuleName(gxSysAttRule.getRuleName());
                }
                result.setCount("0");
                gxSysAttendanceResultManager.save(result);
            }
        }

        if(code.equals("1")){
            if(array!=null||array.equals("")){
                GxSysAttendance attendance=new GxSysAttendance();

                for(int i=0;i<array.size();i++){
//                    long startTime = System.currentTimeMillis();    //获取开始时间
                    JSONObject js=(JSONObject) array.get(i);
                    String signTime=js.get("signTime")==null ? ""
                            :js.getString("signTime").toString();       //签到时间
                    if(!signTime.equals("")||signTime!=null){
                        try {
                            Long timeLong=Long.parseLong(signTime);
                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            ts = new Timestamp(sdf.parse(sdf.format(timeLong)).getTime());
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }

                    String uniqueId=js.get("uniqueId")==null ? ""
                            :js.getString("uniqueId").toString();       //考勤唯一字段
//                    GxSysAttendance temp=gxSysAttendanceManager.findUniqueBy("uniqueId",uniqueId);
//                    if(temp!=null){
////                        long endTime = System.currentTimeMillis();    //获取结束时间
////                        logger.info("第"+i+"个"+"程序运行时间：" + (endTime - startTime) + "ms ：已存在");    //输出程序运行时间
//                        continue;
//                    }
                    String biddingsId=js.get("biddingsId")==null ? ""
                            :js.getString("biddingsId").toString();     //自定义班组标识
                    String certificateNo=js.get("certificateNo")==null ? ""
                            :js.getString("certificateNo").toString();  //证件号码
                    String certificateType=js.get("certificateType")==null ? ""
                            :js.getString("certificateType").toString();//证件类型
                    String doorControlName=js.get("doorControlName")==null ? ""
                            :js.getString("doorControlName").toString();//门禁地址
                    String id=js.get("id")==null ? ""
                            :js.getString("id").toString();             //人员id
                    String imageUrl=js.get("imageUrl")==null ? ""
                            :js.getString("imageUrl").toString();       //图片链接
                    String projectId=js.get("projectId")==null ? ""
                            :js.getString("projectId").toString();      //自定义项目标识
                    if(!(projectId.equals("5cb7d83971f451130d973909")||projectId.equals("5ce50fc68994bc5bb595a55d"))){
                        k++;
                        continue;
                    }
                    String signType=js.get("signType")==null ? ""
                            :js.getString("signType").toString();       //签到类型
                    String restNum=js.get("restNum")==null ? ""
                            :js.getString("restNum").toString();
                    String total=js.get("total")==null ? ""
                            :js.getString("total").toString();
                    String validCount=js.get("validCount")==null ? ""
                            :js.getString("validCount").toString();
                    String attendancenNum=js.get("attendancenNum")==null ? ""
                            :js.getString("attendancenNum").toString();
                    AttendanceRecordTime recordTime=attendanceRecordTimeManager.get(projectId);
                    if(ts.compareTo(recordTime.getRecordTime())<0){
                        k++;
                        continue;
                    }else if(ts.compareTo(recordTime.getRecordTime())==0){
                        if(gxSysAttendanceManager.findUniqueBy("uniqueId",uniqueId)!=null){
                            continue;
                        }
                    }
                    attendance.setUniqueId(uniqueId);
                    attendance.setBiddingsId(biddingsId);
                    attendance.setCertificateNo(certificateNo);
                    attendance.setCertificateType(certificateType);
                    attendance.setDoorControlName(doorControlName);
                    attendance.setId(id);
                    attendance.setImageUrl(imageUrl);
                    attendance.setProjectId(projectId);
                    attendance.setSignTime(ts);
                    attendance.setSignType(signType);
                    attendance.setRestNum(restNum);
                    attendance.setTotal(total);
                    attendance.setValidCount(validCount);
                    attendance.setAttendancenNum(attendancenNum);
                    GxSysAttendanceAll gxSysAttendanceAll=new GxSysAttendanceAll();
                    Date date=new Date();
                    Timestamp timestamp=new Timestamp(date.getTime());
                    attendance.setLocalRecordTime(timestamp);

                    gxSysAttendanceManager.save(attendance);
                    gxSysAttendanceAll.setUniqueId(uniqueId);
                    gxSysAttendanceAll.setBiddingsId(biddingsId);
                    gxSysAttendanceAll.setCertificateNo(certificateNo);
                    gxSysAttendanceAll.setCertificateType(certificateType);
                    gxSysAttendanceAll.setDoorControlName(doorControlName);
                    gxSysAttendanceAll.setId(id);
                    gxSysAttendanceAll.setImageUrl(imageUrl);
                    gxSysAttendanceAll.setProjectId(projectId);
                    gxSysAttendanceAll.setSignTime(ts);
                    gxSysAttendanceAll.setSignType(signType);
                    gxSysAttendanceAll.setRestNum(restNum);
                    gxSysAttendanceAll.setTotal(total);
                    gxSysAttendanceAll.setValidCount(validCount);
                    gxSysAttendanceAll.setAttendancenNum(attendancenNum);
                    gxSysAttendanceAll.setLocalRecordTime(timestamp);
                    gxSysAttendanceAllManager.save(gxSysAttendanceAll);

//                    AttendanceRecordTime recordTime=attendanceRecordTimeManager.get("1");
                    AttendanceAllRecordTime recordTimeAll=attendanceAllRecordTimeManager.get(projectId);
                    recordTimeAll.setRecordTime(ts);
                    recordTimeAll.setLocalRecordTime(timestamp);
                    attendanceAllRecordTimeManager.save(recordTimeAll);

                    recordTime.setRecordTime(ts);
                    recordTime.setLocalRecordTime(timestamp);
                    attendanceRecordTimeManager.save(recordTime);

                    VAtt att= vAttManager.findUniqueBy("uniqueId",uniqueId);
                    if(att==null){
                        continue;
                    }
                    paraMap.put("filter_EQS_userId",att.getUserId());
                    paraMap.put("filter_GED_signTime",st);
                    paraMap.put("filter_LED_signTime",end);
                    List<PropertyFilter> propertyFilters1 = PropertyFilter
                            .buildFromMap(paraMap);
                    if(gxSysAttendanceResultManager.find(propertyFilters1).size()==0){
                        continue;
                    }
                    boolean flog=true;
                    List<GxSysAttendanceResult> list=gxSysAttendanceResultManager.find(propertyFilters1);
                    GxSysAttendanceResult result1=list.get(0);
                    if(result1.getDoorControlName()==null||result1.getDoorControlName().equals("")){
                        result1.setDoorControlName(doorControlName);
                        flog=false;
                    }else {
                        for(i=0;i<list.size();i++){
                            if(list.get(i).getDoorControlName().equals(doorControlName)){
                                result1=list.get(i);
                                flog=false;
                                break;
                            }
                        }
                    }
                    if(flog){
                        GxSysAttendanceResult gxSysAttendanceResult = new GxSysAttendanceResult();
                        beanMapper.copy(result1,gxSysAttendanceResult);
                        gxSysAttendanceResult.setRowId(null);
                        gxSysAttendanceResult.setSignType(null);
                        gxSysAttendanceResult.setEarlyTime(null);
                        gxSysAttendanceResult.setLastTime(null);
                        gxSysAttendanceResult.setCount("0");
                        gxSysAttendanceResult.setWorkTime("0");
                        gxSysAttendanceResult.setDoorControlName(doorControlName);
                        result1=gxSysAttendanceResult;
                    }
                    Long workTime=Long.parseLong(result1.getWorkTime());
                    if(Integer.parseInt(result1.getCount())>=1){
                        if(result1.getSignType().equals("0")&&att.getSignType().equals("1")){
                            if(workTime==0){
                                workTime=att.getSignTime().getTime()-result1.getEarlyTime().getTime();
                            }else {
                                List<VAtt> vAttList=vAttManager.find("signTime",true,propertyFilters1);
                                workTime+=att.getSignTime().getTime()-vAttList.get(vAttList.size()-2).getSignTime().getTime();
                            }
                            result1.setWorkTime(String .valueOf(workTime));
                            result1.setLastTime(att.getSignTime());
                        }
                        if(result1.getSignType().equals("1")&&att.getSignType().equals("1")&&workTime!=0){
                            workTime+=att.getSignTime().getTime()-result1.getLastTime().getTime();
                            result1.setWorkTime(String .valueOf(workTime));
                            result1.setLastTime(att.getSignTime());
                        }
                    }
                    if(result1.getWorkTime().equals("0")&&att.getSignType().equals("0")){
                        result1.setEarlyTime(att.getSignTime());
                        result1.setLastTime(null);
                    }
                    if(result1.getEarlyTime()==null&&att.getSignType().equals("1")){
                        result1.setLastTime(att.getSignTime());
                    }
                    result1.setSignType(att.getSignType());
                    t++;
                    result1.setCount(String.valueOf(1+Integer.parseInt(result1.getCount())));
                    gxSysAttendanceResultManager.save(result1);
//                    long endTime = System.currentTimeMillis();    //获取结束时间
//                    logger.info("第"+i+"个"+"程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
                }
                map.put("statusCode",200);
                map.put("message","考勤数据入库成功");
            }
        }
        else{
            map.put("statusCode",300);
            map.put("message","考勤数据入库失败");
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        logger.info("定时结束，程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
//        logger.info("更新了：" + t + "条");    //输出更新条数
//        logger.info("去：" + k + "条");    //输出更新条数
//        logger.info("当天表有:"+gxSysAttendanceManager.getCount()+"条");

    }
    /**
     * 0点清空数据
     */
    @Scheduled(cron ="0 0 0 * * ?")
    @RequestMapping(value = "clear", method = RequestMethod.GET, produces = "application/json")
    public void clear(){
        logger.info("清空数据定时器启动");
        gxSysAttendanceManager.removeAll();
    }
//    /**
//     * 昨天考勤数据入库历史
//     */
//    @Scheduled(cron ="0 0 0 * * ?")
//    @RequestMapping(value = "inputOne", method = RequestMethod.GET, produces = "application/json")
//    public void inputone() {
//        logger.info("昨天考勤数据入库历史定时器启动");
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -1); //得到前一天
//        Date d = calendar.getTime();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String end = df.format(d);
//        inputAll(end);
//    }

    /**
     * 历史考勤数据入库（时间：s-昨天）
     */
    @RequestMapping(value = "inputAll", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
    public void inputAll(String s) {
//        long startTime = System.currentTimeMillis();
        Timestamp ts = null;
        int t=0;
        int k=0;
        Map<String, Object> map = new HashMap<String, Object>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date d = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String end = df.format(d);
        JsonResult jsonResult = test("91140000110104513E",s,end,"1");
        JSONObject json=JSONObject.fromObject(jsonResult);
        String code=(String)json.get("statusCode");
        JSONArray array=(JSONArray)json.get("entity");
        logger.info("接口数据条数："+String.valueOf(array.size()));
        if(code.equals("1")){
            if(array!=null||array.equals("")){
                GxSysAttendanceAll attendanceAll=new GxSysAttendanceAll();
                for(int i=0;i<array.size();i++){
//                    long startTime = System.currentTimeMillis();    //获取开始时间
                    JSONObject js=(JSONObject) array.get(i);
                    String signTime=js.get("signTime")==null ? ""
                            :js.getString("signTime").toString();       //签到时间
                    if(!signTime.equals("")||signTime!=null){
                        try {
                            Long timeLong=Long.parseLong(signTime);
                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            ts = new Timestamp(sdf.parse(sdf.format(timeLong)).getTime());
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    AttendanceAllRecordTime recordTime=attendanceAllRecordTimeManager.get("1");
                    if(ts.compareTo(recordTime.getRecordTime())<0){
                        k++;
                        continue;
                    }

                    String uniqueId=js.get("uniqueId")==null ? ""
                            :js.getString("uniqueId").toString();       //考勤唯一字段
//                    GxSysAttendance temp=gxSysAttendanceManager.findUniqueBy("uniqueId",uniqueId);
//                    if(temp!=null){
////                        long endTime = System.currentTimeMillis();    //获取结束时间
////                        logger.info("第"+i+"个"+"程序运行时间：" + (endTime - startTime) + "ms ：已存在");    //输出程序运行时间
//                        continue;
//                    }
                    String biddingsId=js.get("biddingsId")==null ? ""
                            :js.getString("biddingsId").toString();     //自定义班组标识
                    String certificateNo=js.get("certificateNo")==null ? ""
                            :js.getString("certificateNo").toString();  //证件号码
                    String certificateType=js.get("certificateType")==null ? ""
                            :js.getString("certificateType").toString();//证件类型
                    String doorControlName=js.get("doorControlName")==null ? ""
                            :js.getString("doorControlName").toString();//门禁地址
                    String id=js.get("id")==null ? ""
                            :js.getString("id").toString();             //人员id
                    String imageUrl=js.get("imageUrl")==null ? ""
                            :js.getString("imageUrl").toString();       //图片链接
                    String projectId=js.get("projectId")==null ? ""
                            :js.getString("projectId").toString();      //自定义项目标识
                    if(!projectId.equals("5cb7d83971f451130d973909")){
                        k++;
                        continue;
                    }
                    String signType=js.get("signType")==null ? ""
                            :js.getString("signType").toString();       //签到类型
                    String restNum=js.get("restNum")==null ? ""
                            :js.getString("restNum").toString();
                    String total=js.get("total")==null ? ""
                            :js.getString("total").toString();
                    String validCount=js.get("validCount")==null ? ""
                            :js.getString("validCount").toString();
                    String attendancenNum=js.get("attendancenNum")==null ? ""
                            :js.getString("attendancenNum").toString();
                    attendanceAll.setUniqueId(uniqueId);
                    attendanceAll.setBiddingsId(biddingsId);
                    attendanceAll.setCertificateNo(certificateNo);
                    attendanceAll.setCertificateType(certificateType);
                    attendanceAll.setDoorControlName(doorControlName);
                    attendanceAll.setId(id);
                    attendanceAll.setImageUrl(imageUrl);
                    attendanceAll.setProjectId(projectId);
                    attendanceAll.setSignTime(ts);
                    attendanceAll.setSignType(signType);
                    attendanceAll.setRestNum(restNum);
                    attendanceAll.setTotal(total);
                    attendanceAll.setValidCount(validCount);
                    attendanceAll.setAttendancenNum(attendancenNum);
                    Date date=new Date();
                    Timestamp timestamp=new Timestamp(date.getTime());
                    attendanceAll.setLocalRecordTime(timestamp);
                    gxSysAttendanceAllManager.save(attendanceAll);
//                    AttendanceAllRecordTime recordTime=attendanceAllRecordTimeManager.get("1");
                    recordTime.setRecordTime(ts);
                    recordTime.setLocalRecordTime(timestamp);
                    attendanceAllRecordTimeManager.save(recordTime);
                    t++;
//                    long endTime = System.currentTimeMillis();    //获取结束时间
//                    logger.info("第"+i+"个"+"程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
                }
                map.put("statusCode",200);
                map.put("message","考勤数据入库成功");
            }
        }
        else{
            map.put("statusCode",300);
            map.put("message","考勤数据入库失败");
        }
//        long endTime = System.currentTimeMillis();    //获取结束时间
//        logger.info("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        logger.info("all表更新了：" + t + "条");    //输出更新条数
        logger.info("去重了"+k+"条");
        logger.info("all表现有:"+gxSysAttendanceAllManager.getCount()+"条");
    }


    /**
     * 历史数据汇总入库
     */
    @RequestMapping(value = "inputResult", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void inputResult() {
        long startTime = System.currentTimeMillis();
        logger.info("汇总开始");
//        List<VUser> vUserList= vUserManager.find(PropertyFilter.buildFromMap(new HashMap<String,Object>()));
        List<VUserCopy> vUserList=vUserCopyManager.find(PropertyFilter.buildFromMap(new HashMap<String,Object>()));
        List<String> timeList=timeList("2019-05-07");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(String time:timeList){
            String stTime=time+" 00:00:00";
            String endTime=time+" 23:59:59";
            Map<String, Object> paraMapAtt = new HashMap<String, Object>();
            paraMapAtt.put("filter_GED_signTime",stTime);
            paraMapAtt.put("filter_LED_signTime",endTime);
            List<PropertyFilter> propertyFiltersAtt = PropertyFilter.buildFromMap(paraMapAtt);

            List<VAttAll> attList= vAttAllManager.find("signTime",true,propertyFiltersAtt);         //一天所有数据

            for(VUserCopy vuser:vUserList){
                List<VAttAll> listOwn=new ArrayList<VAttAll>();
                for(VAttAll att:attList){
                    if(att.getUserId().equals(vuser.getUserId())){
                        listOwn.add(att);
                    }
                }
                GxSysAttendanceResult data=new GxSysAttendanceResult();
                int size=listOwn.size();
                data.setRowId(null);
                data.setWorkTime("0");
                data.setUserType(vuser.getUserType());
                try {
                    java.sql.Date t=new java.sql.Date(sdf.parse(time).getTime());
                    data.setSignTime(t);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                data.setUserName(vuser.getUserName());
                data.setOrgName(vuser.getOrgName());
                data.setCount(String.valueOf(size));
                data.setUserId(vuser.getUserId());
                data.setDataOrder(vuser.getDataOrder());

                String type="";
                Timestamp temp=null;
                for(VAttAll vAttAll:listOwn){
                    Long workTime= Long.parseLong(data.getWorkTime());
                    if(type.equals("0")&&vAttAll.getSignType().equals("1")){
                        if(data.getEarlyTime()!=null){
                            data.setEarlyTime(temp);
                        }
                        if(workTime==0){
                            workTime=vAttAll.getSignTime().getTime()-temp.getTime();
                        }else {
                            workTime+=vAttAll.getSignTime().getTime()-temp.getTime();
                        }
                        data.setWorkTime(String .valueOf(workTime));
                        data.setLastTime(vAttAll.getSignTime());
                    }
                    type=vAttAll.getSignType();
                    if(type.equals("0")){
                        temp=vAttAll.getSignTime();
                    }
                    data.setSignType(type);
                }


                GxSysAttRule rule=gxSysAttRuleManager.findUniqueBy("orgRowId",vuser.getOrgId());
                if(rule!=null){
                    data.setRuleName(rule.getRuleName());
                }
                Map<String, Object> paraMapAtt1 = new HashMap<String, Object>();
                paraMapAtt1.put("filter_GED_resultTime",stTime);
                paraMapAtt1.put("filter_LED_resultTime",endTime);
                paraMapAtt1.put("filter_EQS_userId",vuser.getUserId());
                List<PropertyFilter> propertyFiltersAtt1 = PropertyFilter.buildFromMap(paraMapAtt1);
                GxSysResult result1=gxSysResultManager.find(propertyFiltersAtt1).get(0);
                data.setResultKey(result1.getRowId());
                data.setResultType(result1.getResultType());
                data.setResultCheckType(result1.getResultTypeChange());
                gxSysAttendanceResultManager.save(data);
            }
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        logger.info("汇总运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }


    /**
     * 历史考勤判断Gx_Sys_result
     */
    @RequestMapping(value = "insertResult", method = RequestMethod.GET, produces = "application/json")
    public void insertResult(){
        List<VUserCopy> vUserList=vUserCopyManager.find(PropertyFilter.buildFromMap(new HashMap<String,Object>()));
//        List<VUser> vUserList= vUserManager.find(PropertyFilter.buildFromMap(new HashMap<String,Object>()));
        List<String> timeList=timeList("2019-05-07");
        java.sql.Date t=null;
        for(String time:timeList){
            String stTime=time+" 00:00:00";
            String endTime=time+" 23:59:59";
            Map<String, Object> paraMapAtt = new HashMap<String, Object>();
            paraMapAtt.put("filter_GED_signTime",stTime);
            paraMapAtt.put("filter_LED_signTime",endTime);
            List<PropertyFilter> propertyFiltersAtt = PropertyFilter.buildFromMap(paraMapAtt);
            List<VAttAll> attList= vAttAllManager.find(propertyFiltersAtt);         //一天所有数据
            for(VUserCopy vuser:vUserList){
                List<VAttAll> listOwn=new ArrayList<VAttAll>();
                for(VAttAll att:attList){
                    if(att.getUserId().equals(vuser.getUserId())){
                        listOwn.add(att);
                    }
                }
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    t=new java.sql.Date(sdf.parse(time).getTime());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                //判断
                GxSysResult gxSysResult=new GxSysResult();
                gxSysResult.setRowId(null);
                gxSysResult.setUserId(vuser.getUserId());
                gxSysResult.setResultTime(t);
                if(listOwn.size()>=2){
                    gxSysResult.setResultType("正常");
                }else {
                    gxSysResult.setResultType("异常");
                }
                gxSysResultManager.save(gxSysResult);
            }
        }
    }
    /**
     * 当天考勤数据整合判断
     */
    @Scheduled(cron ="0 0 0 * * ?")
    @RequestMapping(value = "resultEdit", method = RequestMethod.GET, produces = "application/json")
    public void resultEdit() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date d = calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date t =null;
        String time=sdf.format(d);
        String stTime=time+" 00:00:00";
        String endTime=time+" 23:59:59";
        Map<String, Object> paraMapAtt = new HashMap<String, Object>();
        paraMapAtt.put("filter_GED_signTime",stTime);
        paraMapAtt.put("filter_LED_signTime",endTime);
        List<PropertyFilter> propertyFiltersAtt = PropertyFilter.buildFromMap(paraMapAtt);
        List<GxSysAttendanceResult> attList= gxSysAttendanceResultManager.find(propertyFiltersAtt);         //一天所有数据
        try{
            t=new java.sql.Date(sdf.parse(time).getTime());
        }catch (Exception e){
            e.printStackTrace();
        }

        for(GxSysAttendanceResult result:attList){
            GxSysResult gxSysResult=new GxSysResult();
            gxSysResult.setRowId(null);
            gxSysResult.setUserId(result.getUserId());
            gxSysResult.setResultTime(t);
            if(Integer.parseInt(result.getCount())>=2){
                gxSysResult.setResultType("正常");
            }else {
                gxSysResult.setResultType("异常");
            }
            gxSysResultManager.save(gxSysResult);
            Map<String, Object> paraMapAtt1 = new HashMap<String, Object>();
            paraMapAtt1.put("filter_GED_resultTime",stTime);
            paraMapAtt1.put("filter_LED_resultTime",endTime);
            paraMapAtt1.put("filter_EQS_userId",result.getUserId());
            List<PropertyFilter> propertyFiltersAtt1 = PropertyFilter.buildFromMap(paraMapAtt1);
            GxSysResult result1=gxSysResultManager.find(propertyFiltersAtt1).get(0);
            result.setResultKey(result1.getRowId());
            result.setResultType(result1.getResultType());
            result.setResultCheckType(result1.getResultTypeChange());
            gxSysAttendanceResultManager.save(result);
        }



    }



    public List<String> timeList(String start){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> timeList = new ArrayList<String>();
        try{
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(sdf.parse(start));

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.add(Calendar.DATE,-1);
            while (tempStart.before(tempEnd)) {
                timeList.add(sdf.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return timeList;
    }


    @RequestMapping(value = "try", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult tr() {
        JSONArray jsonArray = null;
        JSONObject json=null;
        String statusCode=null;
        Map<String, String> param = new HashMap<String, String>();
        param.put("Key","050e0dc1-deb8-4db4-9d88-9d5637d70b71");
        param.put("Type","Event");
        param.put("STime","2018-01-01 00:00:00");
        param.put("ETime","2018-12-31 23:59:59");
        String endpoint = "http://117.88.47.85:9527/wsAcsData.asmx/GetData";
        JSONObject paramStr = JSONObject.fromObject(param);
        String result = HttpClient.sendHttpRequest(endpoint, paramStr.toString(), "application/json;charset=utf-8");
        if (result != null ) {
            json= JSONObject.fromObject(result);
            int code = (int) json.get("code");
            if (code == 10000) {
                jsonArray = (JSONArray) json.get("data");
                statusCode = "1";
            }else {
                statusCode="0";
            }
        }
//        return result;
        return new JsonResult(statusCode, jsonArray, (String)json.get("msg"));
    }

    @RequestMapping(value = "close", method = RequestMethod.GET, produces = "application/json")
    public void close(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Resource(name="vUserCopyManager")
    private VUserCopyManager vUserCopyManager;
    @Resource(name="gxSysAttendanceManager")
    private GxSysAttendanceManager gxSysAttendanceManager;
    @Resource(name="attendanceRecordTimeManager")
    private AttendanceRecordTimeManager attendanceRecordTimeManager;
    @Resource(name="gxSysAttendanceAllManager")
    private GxSysAttendanceAllManager gxSysAttendanceAllManager;
    @Resource(name="attendanceAllRecordTimeManager")
    private AttendanceAllRecordTimeManager attendanceAllRecordTimeManager;
    @Resource(name="vUserManager")
    private VUserManager vUserManager;
    @Autowired
    private SysUserManager sysUserManager;
    @Resource(name="gxSysAttendanceResultManager")
    private GxSysAttendanceResultManager gxSysAttendanceResultManager;
    @Resource(name="gxSysAttRuleManager")
    private GxSysAttRuleManager gxSysAttRuleManager;
    @Resource(name="gxSysResultManager")
    private GxSysResultManager gxSysResultManager;
    @Resource(name="vAttAllManager")
    private VAttAllManager vAttAllManager;
    @Autowired
    private VAttManager vAttManager;
    private ServerSocket serverSocket;
    private BeanMapper beanMapper = new BeanMapper();
}

