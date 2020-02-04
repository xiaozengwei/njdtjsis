package com.gx.soft.hiddenDanger.web;

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
import com.gx.soft.sys.persistence.manager.SysFunctionManager;
import com.gx.soft.vis.persistence.domain.AttachEntity;
import com.gx.soft.yh.persistence.domain.YhPcSituation;
import com.gx.soft.yh.persistence.manager.YhPcSituationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/5/28.
 */
@Controller
@RequestMapping("hiddenDanger")
@SessionAttributes("user_session")
public class hiddenDangerController {
    private BeanMapper beanMapper = new BeanMapper();
    private ArrayList<String>rowIdList=new ArrayList<>();
    @Autowired
    private FileRecordManager fileRecordManager;
    @Autowired
    private YhPcSituationManager yhPcSituationManager;
    @RequestMapping("hiddenDanger-list")
    public String viewList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        if(!user.getUserId().equals("liu_yc")) {
            parameterMap.put("filter_EQS_bdId", user.getComBdId());
        }
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = yhPcSituationManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
//        System.out.println("****************************************************");
//        System.out.println("隐患排查隐患排查隐患排查隐患排查隐患排查隐患排查隐患排查隐患排查隐患排查");
//        System.out.println("****************************************************");
        return "hiddenDanger/hiddenDanger-list";
    }
    @RequestMapping("hiddenDanger-input")
    public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        YhPcSituation yhPcSituation;
        if (rowId != null) {
            yhPcSituation = yhPcSituationManager.get(rowId);
            String hql="from FileRecord where relationId=?";
            ArrayList<FileRecord>fileRecordList= (ArrayList<FileRecord>) fileRecordManager.find(hql,rowId);
            model.addAttribute("fileRecordList", fileRecordList);
        } else {
            yhPcSituation = new YhPcSituation();
        }
        model.addAttribute("yhPcSituation", yhPcSituation);
        return "hiddenDanger/hiddenDanger-input";
    }
    @RequestMapping(value = "hiddenDanger-save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(YhPcSituation yhPcSituation, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            YhPcSituation dest ;
            String id = yhPcSituation.getRowId();
            if (id != null && id.length() > 0) {
                dest = yhPcSituationManager.get(id);
                String rowID=id;
                for (int i = 0; i < rowIdList.size(); i++) {
                        FileRecord fileRecord = fileRecordManager.get(rowIdList.get(i));
                        fileRecord.setRelationId(rowID);
                        fileRecordManager.save(fileRecord);
                }
                beanMapper.copy(yhPcSituation, dest);
            } else {
                yhPcSituation.setRowId(null);

                dest = yhPcSituation;
                dest.setCreateTime(ts);
            }
            dest.setBriefIntro(dest.getBriefIntro().trim());
            yhPcSituationManager.save(dest);
            String rowID=dest.getRowId();
            if(rowID!=null) {
                for (int i = 0; i < rowIdList.size(); i++) {
                    FileRecord fileRecord = fileRecordManager.get(rowIdList.get(i));
                    fileRecord.setRelationId(rowID);
                    fileRecordManager.save(fileRecord);
                }
                rowIdList.clear();
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
    @RequestMapping("remove")
    @ResponseBody
    public Map<String, Object> viewRemove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        yhPcSituationManager.removeById(rowId);
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
    @RequestMapping("hiddenDanger-look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        YhPcSituation yhPcSituation;
        yhPcSituation = yhPcSituationManager.get(rowId);
        String hql="from FileRecord where relationId=?";
        ArrayList<FileRecord>fileRecordList= (ArrayList<FileRecord>) fileRecordManager.find(hql,rowId);
        model.addAttribute("yhPcSituation", yhPcSituation);
        model.addAttribute("fileRecordList", fileRecordList);
        return "hiddenDanger/hiddenDanger-look";
    }

    @RequestMapping("fileupload")
    @ResponseBody
    public Map<String, Object> processUpload(@RequestParam MultipartFile file,
                                             Model model, HttpSession session
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
                mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\hiddenDanger\\" + decodeFileName;
                fileHelper.createFile(mFilePath, file.getBytes());
                fileRecord.setFilePath(mFilePath);
                fileRecord.setUploadUserName(user.getUserId());
                fileRecord.setUploadUserId(user.getUserName());
                fileRecord.setFileName(fileOriginalName);
                Timestamp time = new Timestamp(System.currentTimeMillis());
                fileRecord.setUploadTime(time);
                fileRecord.setFileType(file.getContentType());
                fileRecord.setFileIdentifyName(decodeFileName);
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
        if(fileRecord.getRowId()!=null) {
            rowIdList.add(fileRecord.getRowId());
        }
        return resMap;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestParam String delids){
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
                        rowIdList.remove(rowId);
                        resMap.put("nowRowId", rowId);
                    }
                }
            }
        } catch (Exception e) {
            statusCode = "300";
            message = "删除失败";
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("row_ides",row_ides);
        return resMap;
    }



}
