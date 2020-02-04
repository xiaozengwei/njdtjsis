package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.map.persistence.domain.MapRecord;
import com.gx.soft.map.persistence.domain.MapToday;
import com.gx.soft.map.persistence.manager.MapRecordManager;
import com.gx.soft.map.persistence.manager.MapTodayManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/9.
 */
@Controller
@RequestMapping("mobile-map")
@SessionAttributes("user_session")
public class MobileMapController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private MapTodayManager mapTodayManager;
    @Autowired
    private MapRecordManager mapRecordManager;
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private SxpzRecordManager sxpzRecordManager;


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "map-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult mapList(String addressWl, String addressJd ,String addressWd ,String userId) {
        String statusCode = "1";// 成功
        String message = "成功";
        Timestamp ts = DateUtil.getDate();
        VUser user=vUserManager.findUniqueBy("userId",userId);
        MapToday mapToday=new MapToday();
        if(addressWl!=null){
            mapToday.setAddressWl(addressWl);
        }
        if(addressJd!=null){
            mapToday.setAddressJd(addressJd);
        }
        if(addressWd!=null){
            mapToday.setAddressWd(addressWd);
        }
        if(userId !=null){
            mapToday.setUserId(userId);
        }
        if(user!=null){
            SxpzRecord sxpzRecord=sxpzRecordManager.findUniqueBy("sxpzId",user.getComBdId());
            if(!(userId.equals("admin") || userId.equals("gong_hx"))) {
                mapToday.setBdId(user.getComBdId());
                mapToday.setBdName(sxpzRecord.getSxpzName());
                mapToday.setUserName(user.getUserName());
                mapToday.setPersonPhone(user.getUserMobileNum());
            }

        }
        if(mapToday.getAddressJd()!=null) {
            MapToday mt= null;
            mt=mapTodayManager.findUniqueBy("userId",userId);
            if(mt !=null){
                mapTodayManager.remove(mt);
            }
            mapToday.setCreateTime(ts);
            MapRecord mapRecord=new MapRecord();
            beanMapper.copy(mapToday,mapRecord);
            mapRecordManager.save(mapRecord);
            mapTodayManager.save(mapToday);

        }else {
            statusCode = "0";// 成功
            message = "失败";
        }
        return new JsonResult(statusCode,"",message);
    }
    /**
     * 2点清空数据
     */
    @Scheduled(cron ="0 0 2 * * ?")
    @RequestMapping(value = "clear", method = RequestMethod.GET, produces = "application/json")
    public void clear(){
        System.out.println("clear mapToday");
        mapTodayManager.removeAll();
    }

//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "map-list", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    JsonResult mapList(String addressWl, String addressJd ,String addressWd ,String userId) {
//        String statusCode = "1";// 成功
//        String message = "成功";
//        Timestamp ts = DateUtil.getDate();
//        VUser user=vUserManager.findUniqueBy("userId",userId);
//        MapRecord mapRecord=new MapRecord();
//        if(addressWl!=null){
//            mapRecord.setAddressWl(addressWl);
//        }
//        if(addressJd!=null){
//            mapRecord.setAddressJd(addressJd);
//        }
//        if(addressWd!=null){
//            mapRecord.setAddressWd(addressWd);
//        }
//        if(user!=null){
//            SxpzRecord sxpzRecord=sxpzRecordManager.findUniqueBy("sxpzId",user.getComBdId());
//            if(!(userId.equals("admin") || userId.equals("gong_hx"))) {
//                mapRecord.setBdId(user.getComBdId());
//                mapRecord.setBdName(sxpzRecord.getSxpzName());
//                mapRecord.setUserName(user.getUserName());
//                mapRecord.setPersonPhone(user.getUserMobileNum());
//            }
//
//        }
//        if(mapRecord.getAddressJd()!=null) {
//            mapRecord.setCreateTime(ts);
//            mapRecordManager.save(mapRecord);
//        }else {
//             statusCode = "0";// 成功
//             message = "失败";
//        }
//        return new JsonResult(statusCode,"",message);
//    }
}
