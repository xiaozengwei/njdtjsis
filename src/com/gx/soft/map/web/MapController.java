package com.gx.soft.map.web;

import com.alibaba.fastjson.JSONObject;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.map.persistence.domain.MapRecord;
import com.gx.soft.map.persistence.domain.MapToday;
import com.gx.soft.map.persistence.manager.MapRecordManager;
import com.gx.soft.map.persistence.manager.MapTodayManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by adminstrator on 2019/7/10.
 */
@Controller
@RequestMapping("map")
@SessionAttributes("user_session")
public class MapController {
    @Autowired
    private MapRecordManager mapRecordManager;
    @Autowired
    private MapTodayManager mapTodayManager;
    @Autowired
    private VUserManager vUserManager;
    @RequestMapping("map-list")
    public String mapList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        if(user.getComBdId()!=null) {
            parameterMap.put("filter_EQS_bdId", user.getComBdId());
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = mapTodayManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return   "map/map-list";
    }

    @RequestMapping(value = "map" , method = RequestMethod.POST)
    @ResponseBody
    public  JSONObject  map(@ModelAttribute("user_session") VUser user){
        List<MapToday>mapTodayList=null;
        if(user.getComBdId()!=null) {
            mapTodayList=mapTodayManager.findBy("bdId", user.getComBdId());
        }else {
            mapTodayList=mapTodayManager.getAll();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mapRecordList", mapTodayList);
        return jsonObject;
    }
//    @RequestMapping(value = "map" , method = RequestMethod.POST)
//    @ResponseBody
//    public  JSONObject  map(@ModelAttribute("user_session") VUser user){
//        List<MapRecord>mapRecordList=new ArrayList<>();
//        String hql2="select DISTINCT  userName from MapRecord ";
//        List<String>userNameList=mapRecordManager.find(hql2);
//        for(String userName:userNameList){
//            if(user.getComBdId()==null && userName!=null) {
//                String hql = " SELECT max(createTime) from MapRecord WHERE userName=?";
//                Timestamp time=mapRecordManager.findUnique(hql,userName);
//                String hql1="from MapRecord where createTime=?";
//                mapRecordList.add((MapRecord) mapRecordManager.findUnique(hql1,time));
//            }else {
//                if(userName!=null){
//                    VUser user1=vUserManager.findUniqueBy("userName",userName);
//                    if(user1!=null) {
//                        if (user1.getComBdId().equals(user.getComBdId())) {
//                            String hql = " SELECT max(createTime) from MapRecord WHERE userName=?";
//                            Timestamp time = mapRecordManager.findUnique(hql, userName);
//                            String hql1 = "from MapRecord where createTime=?";
//                            mapRecordList.add((MapRecord) mapRecordManager.findUnique(hql1, time));
//                        }
//                    }
//                }
//
//            }
//        }
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("mapRecordList", mapRecordList);
//        return jsonObject;
//    }
    @RequestMapping("map-dialog")
    public String mapdialog(@ModelAttribute("mapRecord") MapRecord mapRecord,Model model){
        model.addAttribute("mapRecord",mapRecord);
        return "map/map-dialog";
    }





}
