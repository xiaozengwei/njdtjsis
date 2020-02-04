package com.gx.soft.vis.web;

import com.gx.core.hibernate.HibernateUtils;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.domain.GxSysOrg;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.vo.ZtreeData;
import com.gx.soft.vis.persistence.domain.AttachEntity;
import com.gx.soft.vis.persistence.domain.GxViewColumn;
import com.gx.soft.vis.persistence.domain.GxViewColumnArticle;
import com.gx.soft.vis.persistence.domain.GxViewColumnArticleRelation;
import com.gx.soft.vis.persistence.manager.GxViewColumnArticleManager;
import com.gx.soft.vis.persistence.manager.GxViewColumnArticleReManager;
import com.gx.soft.vis.persistence.manager.GxViewColumnManager;
import com.gx.soft.vis.persistence.manager.VViewColumnArticleManager;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by adminstrator on 2019/5/15.
 */
@Controller
@RequestMapping("vis")
@SessionAttributes("user_session")
//@SessionAttributes("user_session")
public class VViewColumnArticleController {
    private BeanMapper beanMapper = new BeanMapper();
    private ArrayList<String>rowIdList=new ArrayList<>();

    @Autowired
    private VViewColumnArticleManager vViewColumnArticleManager;
    @Autowired
    private GxViewColumnManager gxViewColumnManager;
    @Autowired
    private GxViewColumnArticleManager gxViewColumnArticleManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @Autowired
    private GxViewColumnArticleReManager gxViewColumnArticleReManager;



    @RequestMapping("vis-manager")
    public String visManagerPage(Model model) {
        return "vis/vis-manager";
    }


    @RequestMapping(value = "vis-tree", produces = "application/json")
    public
    @ResponseBody
    List<ZtreeData> visTree(@RequestParam Map<String, Object> parameterMap, Model model) {
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        List<GxViewColumn> visList = gxViewColumnManager.find("orderNum", true, propertyFilters);
        List<ZtreeData> ztreeData = new ArrayList<ZtreeData>();
        for (GxViewColumn vis : visList) {
            ZtreeData zData = new ZtreeData(vis.getRowId(), vis.getParentId(), vis.getColumnName(), vis.getColumnName());
            ztreeData.add(zData);
        }
        return ztreeData;
    }

    @RequestMapping(value = "vis-list")
    public String showColumnArticleManagerList(@ModelAttribute Page page,
                                               String columnId, @RequestParam Map<String, Object> parameterMap,
                                               Model model,@ModelAttribute("user_session") VUser user) {
        page.addOrder("createTime", "desc");
        StringUtils.setDefualtStringIfNull(columnId);
        parameterMap.put("filter_EQS_columnId", columnId);
        parameterMap.put("filter_EQS_bdId",user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);

        page = vViewColumnArticleManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);
        model.addAttribute("columnId", columnId);
        return "vis/vis-list";
    }

    @RequestMapping("vis-remove")
    @ResponseBody
    public Map<String, Object> viewRemove(@RequestParam("delides") String delides) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delides != null && delides.length() > 0) {
                String[] ids = delides.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        gxViewColumnArticleManager.removeById(rowId);
                        String hql="select rowId from GxViewColumnArticleRelation where articleId=?";
                        List<String>rowIdList=gxViewColumnArticleReManager.find(hql,rowId);
                        for(String id:rowIdList){
                            gxViewColumnArticleReManager.removeById(id);
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
        resMap.put("divid", "article-manager-view-list");
        return resMap;
    }

    @RequestMapping("vis-input")
    public String input(@RequestParam("columnId") String columnId,Model model) {
        GxViewColumnArticle gxViewColumnArticle=new GxViewColumnArticle();
        String hql = "from FileRecord where relationId=?";
        List<FileRecord> fileRecordList= gxViewColumnArticleReManager.find(hql,columnId);
        model.addAttribute("gxViewColumnArticle", gxViewColumnArticle);
        model.addAttribute("columnId", columnId);
        model.addAttribute("fileRecordList", fileRecordList);
        return "vis/vis-input";
    }


    @RequestMapping("vis-edit")
    public String edit(@RequestParam("bean") String bean,Model model) {
        GxViewColumnArticle gxViewColumnArticle=gxViewColumnArticleManager.get(bean);
        String hql = "from FileRecord where relationId=?";
        List<FileRecord> fileRecordList= gxViewColumnArticleReManager.find(hql,bean);
        model.addAttribute("fileRecordList", fileRecordList);
        model.addAttribute("gxViewColumnArticle",gxViewColumnArticle);
        model.addAttribute("gxViewColumnArticle",gxViewColumnArticle);
        model.addAttribute("columnId",bean);
        return "vis/vis-edit";
    }
    @RequestMapping("vis-look")
    public String look(@RequestParam("bean") String bean,Model model) {
        GxViewColumnArticle gxViewColumnArticle=gxViewColumnArticleManager.get(bean);
        String hql = "from FileRecord where relationId=?";
        List<FileRecord> fileRecordList= gxViewColumnArticleReManager.find(hql,bean);
        model.addAttribute("fileRecordList", fileRecordList);
        model.addAttribute("gxViewColumnArticle",gxViewColumnArticle);
        model.addAttribute("columnId",bean);
        return "vis/vis-look";
    }
    @RequestMapping(value = "vis-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(@ModelAttribute("gxViewColumnArticle") GxViewColumnArticle gxViewColumnArticle, @RequestParam("columnId") String columnId, HttpSession session) {
        VUser user=(VUser)session.getAttribute("user_session");
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            GxViewColumnArticle dest;
            GxViewColumnArticleRelation relation=new GxViewColumnArticleRelation() ;
            String id = gxViewColumnArticle.getRowId();

            if (id != null && id.length() > 0) {
                dest = gxViewColumnArticleManager.get(id);
                beanMapper.copy(gxViewColumnArticle, dest);
                dest.setCreateTime(ts);
            } else {
                gxViewColumnArticle.setRowId(null);
                dest = gxViewColumnArticle;
                dest.setCreateTime(ts);
                relation.setColumnId(columnId);
                relation.setCreateTime(ts);
                relation.setCreateUserId(user.getUserId());
            }
            gxViewColumnArticleManager.save(dest);
            String rowID=dest.getRowId();
            if(rowID!=null) {
                for (int i = 0; i < rowIdList.size(); i++) {
                    FileRecord fileRecord = fileRecordManager.get(rowIdList.get(i));
                    fileRecord.setRelationId(rowID);
                    fileRecordManager.save(fileRecord);
                    System.out.println();
                }
                rowIdList.clear();
            }
            String hql = "SELECT rowId from GxViewColumnArticle WHERE articleTitle=?";
            List articleId= gxViewColumnArticleReManager.find(hql,gxViewColumnArticle.getArticleTitle());
            relation.setArticleId((String) articleId.get(0));
            gxViewColumnArticleReManager.save(relation);
        } catch (Exception e) {
            statusCode = "300";
            message = "操作失败";
            e.printStackTrace();
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("closeCurrent", true);
        resMap.put("divid", "article-manager-view-list");
        return resMap;
    }

    @RequestMapping("fileupload")
    @ResponseBody
    public Map<String, Object> processUpload(@RequestParam MultipartFile file,
                                              Model model, HttpSession session, @RequestParam("columnId") String columnId
                                             ) throws IOException {
        Map<String, Object> resMap = new HashMap<String, Object>();
        VUser user=(VUser)session.getAttribute("user_session");
        resMap.put("user", user);
        model.addAttribute("message", "File '" + file.getOriginalFilename());
//        String bol="yes";
        String fileOriginalName = file.getOriginalFilename();
        String statusCode = "200", message = "上传成功";
        AttachEntity attachment = new AttachEntity();
        FileRecord fileRecord=new FileRecord();
        try {
            if (!StringUtils.isEmpty(fileOriginalName)) {
                FileUtil fileHelper = new FileUtil();
                String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
//                String cc=session.getServletContext().getRealPath("");
//                System.out.println(session.getServletContext().getRealPath("") );
//                String mFilePath = session.getServletContext().getRealPath("") + decodeFileName; // 取得服务器路径
                String mFilePath ="D:\\apache-tomcat-file\\webapps\\video\\video"+ decodeFileName;
                fileHelper.createFile(mFilePath, file.getBytes());
                fileRecord.setFilePath(mFilePath);
                fileRecord.setUploadUserName(user.getUserId());
                fileRecord.setUploadUserId(user.getUserName());
                fileRecord.setFileName(fileOriginalName);
                Timestamp time = new Timestamp(System.currentTimeMillis());
                fileRecord.setUploadTime(time);
                fileRecord.setFileType(file.getContentType());
//                fileRecord.setRelationId(columnId);
                fileRecordManager.save(fileRecord);
                message = "请选择上传文件";
                statusCode = "300";
            }

        } catch (Exception e) {
            statusCode = "300";
            message = "上传失败";
//            bol="no";
            e.printStackTrace();
        }
        resMap.put("AttachEntity", fileRecord);
//        resMap.put("bol", bol);
        if(fileRecord.getRowId()!=null) {
            rowIdList.add(fileRecord.getRowId());
        }
        return resMap;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> download(@RequestParam String delids){
        Map<String, Object> resMap = new HashMap<String, Object>();
        List<String> row_ides=new ArrayList<>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        row_ides.add(rowId);
                        String filePath=fileRecordManager.get(rowId).getFilePath();
                        FileUtil fileHelper = new FileUtil();
                        boolean isDelete = true;
                        try {
                            fileHelper.deleteFile(filePath);
                            if (!isDelete) {
                                statusCode = "300";
                                message = "删除失败";
                            }
                        } catch (Exception e) {
                            statusCode = "300";
                            e.printStackTrace();
                        }
                        fileRecordManager.removeById(rowId);
                    }
                }
            }
        } catch (Exception e) {
            statusCode = "300";
            message = "删除失败";
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("lastRowId",row_ides);
        return resMap;
    }

    @RequestMapping(value = "fileDownload")
    @ResponseBody
    public   Map<String, Object> fileDownLoad( @RequestParam String delids, HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String[] ids = delids.split(",");
        for(String id:ids){
            FileRecord fileRecord = fileRecordManager.get(id);
            if(fileRecord!=null) {
                String filePath = fileRecord.getFilePath();
                String fileName = fileRecord.getFileName();
                FileUtil fileHelper = new FileUtil();
                fileHelper.downloadFile(filePath, request, response, fileName);
                resMap.put("statusCode", "200");
                resMap.put("message", "下载成功");
            }else {
                resMap.put("statusCode", "300");
                resMap.put("message", "下载失败");
            }
        }

        return resMap;
    }
//    @RequestMapping("th")
//    public void th(){
//        String hql="from FileRecord where filePath like '%apache-tomcat-7.0.75_64_puk%'";
//        ArrayList<FileRecord>fileRecordArrayList= (ArrayList<FileRecord>) fileRecordManager.find(hql);
//        for(int i=0;i<fileRecordArrayList.size();i++){
//            String cc=fileRecordArrayList.get(i).getFilePath();
//            cc=cc.replace("D:\\apache-tomcat-7.0.75_64_puk\\webapps\\","D:\\njdtjsis\\file\\");
//            System.out.println(cc);
//            fileRecordArrayList.get(i).setFilePath(cc);
//            fileRecordManager.save(fileRecordArrayList.get(i));
//        }

//    }


}
