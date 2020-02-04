package com.gx.soft.process.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.process.persistence.domain.Attachment;
import com.gx.soft.process.persistence.domain.DtYcApply;
import com.gx.soft.process.persistence.manager.AttachmentManager;
import com.gx.soft.process.persistence.manager.DtYcApplyManager;
import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/5/30.
 */
@Controller
@RequestMapping("dtyc")
public class DtYcApplyController {
    private BeanMapper beanMapper = new BeanMapper();

    @Autowired
    private DtYcApplyManager dtYcApplyManager;
    @Autowired
    private AttachmentManager attachmentManager;

    @RequestMapping("dtyc-list")
    public String List(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_EQS_bdId",user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = dtYcApplyManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "dtyc/dtyc-list";
    }
    @RequestMapping("dtyc-edit")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        DtYcApply dtYcApply = null;
        if (rowId != null) {
            dtYcApply = dtYcApplyManager.get(rowId);
            String hql="from Attachment where relationId=?";
            ArrayList<Attachment> fileRecordList= (ArrayList<Attachment>) attachmentManager.find(hql,rowId);
            model.addAttribute("fileRecordList", fileRecordList);
        }
        model.addAttribute("dtYcApply",dtYcApply);
        return "dtyc/dtyc-edit";
    }
    @RequestMapping(value = "fileDownload")
    @ResponseBody
    public   Map<String, Object> fileDownLoad( @RequestParam String delids, HttpServletRequest request,
                                               HttpServletResponse response) throws IOException {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String[] ids = delids.split(",");
        for(String id:ids){
            Attachment fileRecord = attachmentManager.get(id);
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
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(DtYcApply dtYcApply, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            DtYcApply dest ;
            String id = dtYcApply.getRowId();
            if (id != null && id.length() > 0) {
                dest = dtYcApplyManager.get(id);
                beanMapper.copy(dtYcApply, dest);
            } else {
                dtYcApply.setRowId(null);
                dest = dtYcApply;
                dest.setCreateTime(ts);
            }
            dtYcApplyManager.save(dest);
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
