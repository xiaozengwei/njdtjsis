package com.gx.soft.ueditor.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/17.
 */
@Controller
@RequestMapping("fileupload")
public class UeditorController {
    private ObjectMapper objectMapper = new ObjectMapper();;

    @RequestMapping(value = "ueditor-image-upload")
    public void ueditorImageUpload(@RequestParam MultipartFile file,
                                   Model model, HttpSession session, HttpServletRequest request,
                                   HttpServletResponse response,
                                   @ModelAttribute("user_session") VUser user) throws IOException {
        String message = "File '" + file.getOriginalFilename()
                + "' uploaded successfully";
        String state = "SUCCESS";
        String url = "";
        String title = "";
        String original = "";
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + path + "/";
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            String fileOriginalName = file.getOriginalFilename();
            if (!StringUtils.isEmpty(fileOriginalName)) {
                FileUtil fileHelper = new FileUtil();
                String decodeFileName = fileHelper
                        .getDecodeFileName(fileOriginalName);// 文件名编码
                original = fileOriginalName;
                url = "/njdtjsis/fileupload/ueditor-image-get.do?fileName="
                        + decodeFileName;
                String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
                mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis\\ueditor"
                        + "\\images\\" + decodeFileName;
                fileHelper.createFile(mFilePath, file.getBytes());
                resMap.put("fileName", mFilePath);
            } else {
                message = "请选择上传文件";
                state = "FAILURE";
            }
        } catch (Exception e) {
            state = "FAILURE";
            message = "上传失败";
            e.printStackTrace();
        }
        // {'url':'60391393848223.jpg','title':'p1999637039.jpg','original':'p1999637039.jpg','state':'SUCCESS'}
        String returnStr = "{'url':'" + url + "','title':'" + title
                + "','original':'" + original + "','state':'" + state + "'}";
        resMap.put("state", state);
        resMap.put("url", url);
        resMap.put("title", title);
        resMap.put("original", original);
        String returnString = objectMapper.writeValueAsString(resMap);
        response.setCharacterEncoding("UTF-8"); // 设置编码格式
        response.setContentType("text/html"); // 设置数据格式
        PrintWriter out = response.getWriter(); // 获取写入对象
        out.print(returnString); // 将json数据写入流中
        out.flush();
        out.close();
    }
    @RequestMapping(value = "ueditor-image-get", method = RequestMethod.GET)
    public void ueditorImageGet(@RequestParam String fileName, Model model,
                                HttpSession session, HttpServletRequest request,
                                HttpServletResponse response,
                                @ModelAttribute("user_session") VUser user) throws IOException {

        FileUtil fileHelper = new FileUtil();
        try {
            if (!StringUtils.isEmpty(fileName)) {
                String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
                mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis\\ueditor"
                        + "\\images\\";
                String downLoadpath = mFilePath + fileName;
                fileHelper.downloadFile(downLoadpath, request, response,
                        fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
