package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.VisVo;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.vis.persistence.domain.VViewColumnArticle;
import com.gx.soft.vis.persistence.manager.VViewColumnArticleManager;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/10.
 */
@Controller
@RequestMapping("mobile-vis")
public class MobileVisController {
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @Autowired
    private VViewColumnArticleManager vViewColumnArticleManager;
    @RequestMapping(value = "vis-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult visList(String userId, String bdId, @RequestParam Map<String, Object> parameterMap, @ModelAttribute Page page) {

        String statusCode = "1";// 成功
        String message = "获取可视化交底视频列表成功";
        page.addOrder("createTime", "desc");
        VUser user = vUserManager.findUniqueBy("userId", userId);
        if(bdId==null || bdId=="") {
            try {
                if(user!=null) {
                    parameterMap.put("filter_EQS_bdId", user.getComBdId());
                    List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                    page = vViewColumnArticleManager.pagedQuery(page, propertyFilterList);
                }
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取失败";
                ex.printStackTrace();
            }
        }else{
            try {
                parameterMap.put("filter_EQS_bdId", bdId);
                List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
                page = vViewColumnArticleManager.pagedQuery(page, propertyFilterList);
            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取失败";
                ex.printStackTrace();
            }
        }
        return new JsonResult(statusCode,page.getResult(),message);

    }
    @RequestMapping(value = "vis-look", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult visLook(String userId, String articleId,String bdId, @RequestParam Map<String, Object> paramMap, @ModelAttribute Page page) {

        String statusCode = "1";// 成功
        String message = "获取可视化交底视频列表成功";
        VisVo visVo=new VisVo();
        VUser user = vUserManager.findUniqueBy("userId", userId);
        if(bdId==null || bdId=="") {

//            page.addOrder("createTime", "desc");
            try {
                List<VViewColumnArticle> vViewColumnArticleList=null;
                if(user!=null) {
                    String hql="from VViewColumnArticle where bdId=? and articleId=?";
                    if(user.getComBdId()!=null) {
                        vViewColumnArticleList = vViewColumnArticleManager.find(hql, user.getComBdId(), articleId);
                    }else {
                        vViewColumnArticleList = vViewColumnArticleManager.find(hql, bdId, articleId);

                    }
                }
                if(vViewColumnArticleList!=null){
                    visVo.setvViewColumnArticleList(vViewColumnArticleList);
                    for(int i=0;i<vViewColumnArticleList.size();i++){
                        List<FileRecord> fileRecordList=fileRecordManager.findBy("relationId",articleId);
                        List<FileRecord> fileRecordList1=new ArrayList<>();
                        for(FileRecord f:fileRecordList){
                            String path=f.getFilePath();
                            if(path.contains("D:\\njdtjsis\\file\\")) {
                                path = path.replace("D:\\njdtjsis\\file\\", "http://221.6.30.202:18888/video/");
                            }else{
                                path = path.replace("D:\\apache-tomcat-file\\webapps\\video", "http://221.6.30.202:18888/video/");
                                path=path.replace("\\","/");
                            }
                            f.setFilePath(path);
                            fileRecordList1.add(f);
                        }
                        if(fileRecordList1.size()>0){
                            visVo.setFileRecordList(fileRecordList1);
                        }
                    }

                }

            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取失败";
                ex.printStackTrace();
            }
        }else{
            try {
                List<VViewColumnArticle> vViewColumnArticleList=null;
                String hql="from VViewColumnArticle where bdId=? and articleId=?";
                vViewColumnArticleList = vViewColumnArticleManager.find(hql,bdId,articleId);
                if(vViewColumnArticleList.size()>0){
                    visVo.setvViewColumnArticleList(vViewColumnArticleList);
                    for(int i=0;i<vViewColumnArticleList.size();i++){
                        List<FileRecord> fileRecordList=fileRecordManager.findBy("relationId",articleId);
                        List<FileRecord> fileRecordList1=new ArrayList<>();
                        for(FileRecord f:fileRecordList){
                            String path=f.getFilePath();
                            if(path.contains("D:\\njdtjsis\\file\\")) {
                                path = path.replace("D:\\njdtjsis\\file\\", "http://221.6.30.202:18888/video/");
                            }else{
                                path = path.replace("D:\\apache-tomcat-file\\webapps\\video", "http://221.6.30.202:18888/video/");
                                path=path.replace("\\","/");
                            }
                            f.setFilePath(path);
                            fileRecordList1.add(f);
                        }
                        if(fileRecordList1.size()>0){
                            visVo.setFileRecordList(fileRecordList1);
                        }

                    }

                }

            } catch (Exception ex) {
                statusCode = "-1";
                message = "获取失败";
                ex.printStackTrace();
            }
        }
        return new JsonResult(statusCode,visVo,message);

    }
}
