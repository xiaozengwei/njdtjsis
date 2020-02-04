package com.gx.soft.mobile.web;

import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.process.persistence.domain.Attachment;
import com.gx.soft.process.persistence.domain.DtYcApply;
import com.gx.soft.process.persistence.manager.AttachmentManager;
import com.gx.soft.process.persistence.manager.DtYcApplyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/10/14.
 */
@Controller
@RequestMapping("mobile-dtyc")
public class MobileDtycController {
    @Autowired
    private DtYcApplyManager dtYcApplyManager;
    @Autowired
    private AttachmentManager attachmentManager;
    @Autowired
    private SxpzRecordManager sxpzRecordManager;
    @RequestMapping("dtyc-save")
    @ResponseBody
    public Map<String, Object> save(HttpServletRequest request,String applicantName, String applicantPhone, String applicantIdCard
    , String bdId, String ycAddress, String ycMs, String clYj  , Model model, HttpSession session) throws IOException{
        Timestamp ts = DateUtil.getDate();
        DtYcApply dtYcApply=new DtYcApply();
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        if(applicantName!=null && applicantName.length()>0) {
            dtYcApply.setApplicantName(applicantName);
        }
        if(applicantPhone!=null && applicantPhone.length()>0){
            dtYcApply.setApplicantPhone(applicantPhone);
        }
        if(applicantIdCard!=null && applicantIdCard.length()>0){
            dtYcApply.setApplicantIdCard(applicantIdCard);
        }
        if(ycAddress!=null && ycAddress.length()>0){
            dtYcApply.setYcAddress(ycAddress);
        }
        if(ycMs!=null && ycMs.length()>0){
            dtYcApply.setYcMs(ycMs);
        }
        if(clYj!=null && clYj.length()>0){
            dtYcApply.setClYj(clYj);
        }
        if(bdId!=null && bdId.length()>0){
            dtYcApply.setBdId(bdId);
        }
        dtYcApply.setCreateTime(ts);
        dtYcApplyManager.save(dtYcApply);
        String attachmentId=null;


        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());


        commonsMultipartResolver.setDefaultEncoding("utf-8");

        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> map = mulReq.getFileMap();

            // key为前端的name属性，value为上传的对象（MultipartFile）
            for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
                // 自己的保存文件逻辑
                MultipartFile files=entry.getValue();
                String fileOriginalName = files.getOriginalFilename();
                try {
                    if (!StringUtils.isEmpty(fileOriginalName)) {
                        FileUtil fileHelper = new FileUtil();
                        String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
                        String mFilePath = session.getServletContext().getRealPath("") + decodeFileName; // 取得服务器路径
                        mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\dtyc\\" + decodeFileName;
                        fileHelper.createFile(mFilePath, files.getBytes());
                        Attachment attachment=new Attachment();
                        attachment.setFilePath(mFilePath);
                        attachment.setUploadUserName(applicantName);
                        attachment.setFileName(fileOriginalName);
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        attachment.setUploadTime(time);
                        attachment.setFileType(files.getContentType());
                        attachment.setRelationId(dtYcApply.getRowId());
                        attachmentManager.save(attachment);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        return resMap;

    }
    @RequestMapping("bd-list")
    @ResponseBody
    public  List<SxpzRecord>  viewList(){
        List<SxpzRecord>sxpzRecordList=sxpzRecordManager.getAll();
        return sxpzRecordList;
    }
}
