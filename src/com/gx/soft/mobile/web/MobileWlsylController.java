package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.WlsylVo;
import com.gx.soft.mobile.persistence.vo.WlsylXqVo;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.wl.persistence.domain.MaterialCount;
import com.gx.soft.wl.persistence.manager.MaterialCountManager;
import com.gx.soft.wl.persistence.manager.MaterialInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/26.
 */
@Controller
@RequestMapping("mobile-wlsyl")
public class MobileWlsylController {
    @Autowired
    private MaterialCountManager materialCountManager;
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private MaterialInfoManager materialInfoManager;
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "wlsyl-time-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult wlsylTimeList(String userId, String bdId, @ModelAttribute Page page, @RequestParam Map<String, Object> paramMap) {
        String statusCode = "1";// 成功
        String message = "获取物料使用量时间列表成功";
        String hql5="select distinct materialType from MaterialInfo";
        List<String>materialTypeList=materialInfoManager.find(hql5);
        List<String>timeList=new ArrayList<>();
        List<String>timeList1=new ArrayList<>();
        List<WlsylVo>wlsylVoList=new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if(bdId==null || bdId=="") {
            VUser user = vUserManager.findUniqueBy("userId", userId);
            try {
                String hql="select createTime from MaterialCount where bdId=?";
                timeList=materialCountManager.find(hql,user.getComBdId());

                for(int i=0;i<timeList.size();i++){
                    timeList1.add(df.format(Timestamp.valueOf(String.valueOf(timeList.get(i)))));
                }
                HashSet h = new HashSet(timeList1);
                timeList1.clear();
                timeList1.addAll(h);
                for(String t:timeList1){
                    WlsylVo wlsylVo=new WlsylVo();
                    String st=t+" 00:00:00";
                    String end=t+" 23:59:59";
                    String hql3="from MaterialCount where createTime=(select max(createTime) from  MaterialCount where bdId=? and materialType=? and createTime in (select createTime from MaterialCount where createTime>? and createTime<?))";
                    int drsywlCount=0;
                    for(String m:materialTypeList) {
                        if(!m.equals("防水材料")) {
                            List<MaterialCount> materialCountList = materialCountManager.find(hql3, user.getComBdId(), m,java.sql.Timestamp.valueOf(st), java.sql.Timestamp.valueOf(end));
                            if (materialCountList.size() > 0) {
                                drsywlCount += materialCountList.get(0).getMaterialCount();
                            }
                        }
                    }
                    wlsylVo.setCount(drsywlCount);
                    wlsylVo.setDanWei("吨");
                    wlsylVo.setTime(t);
                    wlsylVoList.add(wlsylVo);
                }

            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取物料使用量时间列表失败";
                ex.printStackTrace();
            }
        }else{
            try {
                String hql="select createTime from MaterialCount where bdId=?";
                timeList=materialCountManager.find(hql,bdId);

                for(int i=0;i<timeList.size();i++){
                    timeList1.add(df.format(Timestamp.valueOf(String.valueOf(timeList.get(i)))));
                }
                HashSet h = new HashSet(timeList1);
                timeList1.clear();
                timeList1.addAll(h);
                for(String t:timeList1){
                    WlsylVo wlsylVo=new WlsylVo();
                    String st=t+" 00:00:00";
                    String end=t+" 23:59:59";
                    String hql3="from MaterialCount where createTime=(select max(createTime) from  MaterialCount where bdId=? and materialType=? and createTime in (select createTime from MaterialCount where createTime>? and createTime<?))";
                    int drsywlCount=0;
                    for(String m:materialTypeList) {
                        if(!m.equals("防水材料")) {
                            List<MaterialCount> materialCountList = materialCountManager.find(hql3, bdId, m,java.sql.Timestamp.valueOf(st), java.sql.Timestamp.valueOf(end));
                            if (materialCountList.size() > 0) {
                                drsywlCount += materialCountList.get(0).getMaterialCount();
                            }
                        }
                    }
                    wlsylVo.setCount(drsywlCount);
                    wlsylVo.setDanWei("吨");
                    wlsylVo.setTime(t);
                    wlsylVoList.add(wlsylVo);
                }
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取物料使用量时间列表失败";
                ex.printStackTrace();
            }
        }
        return new JsonResult(statusCode,wlsylVoList,message);
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "wlsyl-xq", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult wlsylXq(String time,String bdId,String userId,@ModelAttribute Page page,@RequestParam Map<String, Object> paramMap) {
        String statusCode = "1";// 成功
        String message = "获取物料使用量详情成功";
        List<FileRecord> fileRecordList =null;
        page.addOrder("uploadTime", "desc");
        List<String>timeList=new ArrayList<>();
        List<String>timeList1=new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String hql5="select distinct materialType from MaterialInfo";
        List<String>materialTypeList=materialInfoManager.find(hql5);
        List<WlsylXqVo>wlsylXqVoList=new ArrayList<>();
        if(bdId==null || bdId=="") {
            VUser user = vUserManager.findUniqueBy("userId", userId);
            try {
                String hql="select createTime from MaterialCount where bdId=?";
                timeList=materialCountManager.find(hql,user.getComBdId());
                for(int i=0;i<timeList.size();i++){
                    timeList1.add(df.format(Timestamp.valueOf(String.valueOf(timeList.get(i)))));
                }
                HashSet h = new HashSet(timeList1);
                timeList1.clear();
                timeList1.addAll(h);
                if(timeList1.contains(time)){
                   for(String type:materialTypeList){
                       WlsylXqVo wlsylXqVo=new WlsylXqVo();
                       String st=time+" 00:00:00";
                       String end=time+" 23:59:59";
                       String hql3="from MaterialCount where createTime=(select max(createTime) from  MaterialCount where bdId=? and materialType=? and createTime in (select createTime from MaterialCount where createTime>? and createTime<?))";
                       List<MaterialCount>mList=materialCountManager.find(hql3,user.getComBdId(),type,Timestamp.valueOf(st),Timestamp.valueOf(end));
                       if(mList.size()>0){
                           wlsylXqVo.setCount(mList.get(0).getMaterialCount());
                           wlsylXqVo.setWlType(type);
                           wlsylXqVo.setDanWei("吨");
                           wlsylXqVoList.add(wlsylXqVo);
                       }
                   }
                }
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取物料使用量详情失败";
                ex.printStackTrace();
            }
        }else{

            try {
                String hql="select createTime from MaterialCount where bdId=?";
                timeList=materialCountManager.find(hql,bdId);
                for(int i=0;i<timeList.size();i++){
                    timeList1.add(df.format(Timestamp.valueOf(String.valueOf(timeList.get(i)))));
                }
                HashSet h = new HashSet(timeList1);
                timeList1.clear();
                timeList1.addAll(h);
                if(timeList1.contains(time)){
                    for(String type:materialTypeList){
                        WlsylXqVo wlsylXqVo=new WlsylXqVo();
                        String st=time+" 00:00:00";
                        String end=time+" 23:59:59";
                        String hql3="from MaterialCount where createTime=(select max(createTime) from  MaterialCount where bdId=? and materialType=? and createTime in (select createTime from MaterialCount where createTime>? and createTime<?))";
                        List<MaterialCount>mList=materialCountManager.find(hql3,bdId,type,Timestamp.valueOf(st),Timestamp.valueOf(end));
                        if(mList.size()>0){
                            wlsylXqVo.setCount(mList.get(0).getMaterialCount());
                            wlsylXqVo.setWlType(type);
                            wlsylXqVo.setDanWei("吨");
                            wlsylXqVoList.add(wlsylXqVo);
                        }
                    }
                }
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取物料使用量详情失败";
                ex.printStackTrace();
            }
        }
        return new JsonResult(statusCode,wlsylXqVoList,message);
    }
}
