package com.gx.soft.worksite.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.vis.persistence.domain.AttachEntity;
import com.gx.soft.worksite.persistence.domain.WorksiteIndex;
import com.gx.soft.worksite.persistence.domain.WorksiteRecord;
import com.gx.soft.worksite.persistence.manager.WorkSiteIndexManager;
import com.gx.soft.worksite.persistence.manager.WorksiteRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/4.
 */
@Controller
@RequestMapping("worksite")
@SessionAttributes("user_session")
public class WorkSiteController {
    private BeanMapper beanMapper = new BeanMapper();

    @Autowired
    private WorkSiteIndexManager workSiteIndexManager;
    @Autowired
    private WorksiteRecordManager worksiteRecordManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @RequestMapping("worksite-list")
    public String queryWorksiteList(@ModelAttribute Page page,
                              @RequestParam(required = false, defaultValue = "") String orderField,
                              @RequestParam(required = false, defaultValue = "") String orderDirection,
                              @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user) {
       if(!user.getUserId().equals("hu_b")) {
           parameterMap.put("filter_EQS_bdId", user.getComBdId());
       }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = workSiteIndexManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "worksite/worksite-list";
    }

    @RequestMapping("worksite-detail")
    public String queryDetail(@ModelAttribute Page page,
                                    @RequestParam("worksiteId") String worksiteId,
                                    @RequestParam Map<String, Object> parameterMap, Model model) {
        parameterMap.put("filter_EQS_worksiteId",worksiteId);
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = worksiteRecordManager.pagedQuery(page, propertyFilters);
        String hql="from FileRecord where relationId=?";
        List<FileRecord>fileRecordList=fileRecordManager.find(hql,worksiteId);
        model.addAttribute("page", page);
        model.addAttribute("worksiteId", worksiteId);
        model.addAttribute("time",workSiteIndexManager.get(worksiteId).getCreateTime());
        model.addAttribute("fileRecordList", fileRecordList);
        return "worksite/worksite-detail";
    }

    @RequestMapping("fileupload")
    @ResponseBody
    public Map<String, Object> processUpload(@RequestParam MultipartFile file,
                                             Model model, HttpSession session, @RequestParam("worksiteId") String worksiteId
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
                String mFilePath = session.getServletContext().getRealPath("") + decodeFileName; // 取得服务器路径
                mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\worksite\\" + decodeFileName;
                fileHelper.createFile(mFilePath, file.getBytes());
                fileRecord.setFilePath(mFilePath);
                fileRecord.setUploadUserName(user.getUserId());
                fileRecord.setUploadUserId(user.getUserName());
                fileRecord.setFileName(fileOriginalName);
                Timestamp time = new Timestamp(System.currentTimeMillis());
                fileRecord.setUploadTime(time);
                fileRecord.setFileType(file.getContentType());
                fileRecord.setRelationId(worksiteId);
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
        return resMap;
    }

    @RequestMapping("remove")
    public @ResponseBody
    Map<String, Object> remove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        workSiteIndexManager.removeById(rowId);
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

    @RequestMapping("worksite-input")
    public String input(String rowId, Model model) {
        WorksiteIndex worksiteIndex;
        if (rowId != null) {
            worksiteIndex = workSiteIndexManager.get(rowId);
        } else {
            worksiteIndex = new WorksiteIndex();
        }
        model.addAttribute("worksiteIndex", worksiteIndex);
        return "worksite/worksite-input";
    }
    @RequestMapping("worksite-add")
    public String input( Model model) {
        WorksiteRecord worksiteRecord=new WorksiteRecord();
        model.addAttribute("WorksiteRecord", worksiteRecord);
        return "worksite/worksite-add";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save( WorksiteIndex worksiteIndex, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            WorksiteIndex dest ;
            String id = worksiteIndex.getRowId();
            if (id != null && id.length() > 0) {

                dest = workSiteIndexManager.get(id);
                String hql="from WorksiteRecord where worksiteId=?";
                ArrayList<WorksiteRecord>worksiteRecordList= (ArrayList<WorksiteRecord>) worksiteRecordManager.find(hql,id);
                for(int i=0;i<worksiteRecordList.size();i++){
                    WorksiteRecord worksiteRecord=worksiteRecordList.get(i);
                    worksiteRecord.setBdIntro(worksiteIndex.getExt1());
                    worksiteRecord.setBdId(worksiteIndex.getBdId());
                    worksiteRecord.setBdName(worksiteIndex.getBdName());
                    worksiteRecord.setWorksitName(worksiteIndex.getWorksiteName());
                    worksiteRecordManager.save(worksiteRecord);
                }
                beanMapper.copy(worksiteIndex, dest);
                dest.setUpdateTime(ts);
                System.out.print(ts);
            } else {
                worksiteIndex.setRowId(null);
                dest = worksiteIndex;
                dest.setCreateTime(ts);
            }
            dest.setExt1(dest.getExt1().trim());
            workSiteIndexManager.save(dest);
            dest.setWorksiteId(dest.getRowId());
            dest.setExt1(dest.getExt1().trim());
            workSiteIndexManager.save(dest);
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
}
