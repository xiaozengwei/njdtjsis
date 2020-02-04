package com.gx.soft.vis.web;

import com.gx.soft.common.util.FileUtil;
import com.gx.soft.sb.persistence.domain.EquipmentInfo;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.vis.persistence.domain.GxViewColumn;
import com.gx.soft.vis.persistence.domain.VColumnArticleL;
import com.gx.soft.vis.persistence.domain.VViewColumnArticle;
import com.gx.soft.vis.persistence.manager.GxViewColumnManager;
import com.gx.soft.vis.persistence.manager.VColumnArticleManager;
import com.gx.soft.vis.persistence.manager.VViewColumnArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.List;
import java.io.IOException;
import java.util.*;

/**
 * Created by adminstrator on 2019/5/23.
 */
@Controller
@RequestMapping("text")
public class MobileController {
    @Autowired
    private VColumnArticleManager vColumnArticleManager;
    @Autowired
    private GxViewColumnManager gxViewColumnManager;
    @Autowired
    private VViewColumnArticleManager vViewColumnArticleManager;
    @Autowired
    private FileRecordManager fileRecordManager;
    @RequestMapping("construction")
    public String construction(Model model){
        String hql = "from VColumnArticleL vca where vca.columnId=? order by publishTime desc";
        java.util.List<VColumnArticleL> articleList1 = vColumnArticleManager.find(hql,"8a808007650d4a6a01650e5884cd0009");
        java.util.List<VColumnArticleL> articleList2 = vColumnArticleManager.find(hql,"8a808007650d4a6a01650e5bde5d000f");
        ArrayList<java.util.List<VColumnArticleL>> bList = new ArrayList<>();
        bList.add(articleList1);
        bList.add(articleList2);
        //先遍历大集合，取出里面的第一个集合articleList1，进行遍历，然后循环遍历后面的
        for (int j = 0; j < bList.size() ; j++) {
            //判断是否为热度文章
            for (int i = 0; i < bList.get(j).size(); i++) {
                //获取文章创建时间
                long da = bList.get(j).get(i).getPublishTime().getTime();
                //获取当前时间
                long date = new java.util.Date().getTime();
                //计算时间差
                long sjc = (date - da)/1000;
                //如果时间差在三天以内
                if (sjc<=3*24*60*60){
                    //给文章的状态码设置为1，表示为热度文章
                    bList.get(j).get(i).setArticleStatus("1");
                }else{
                    //超过三天，状态码设置为0
                    bList.get(j).get(i).setArticleStatus("0");
                }
            }
        }
        model.addAttribute("articleList1", articleList1);
        model.addAttribute("articleList2", articleList2);
        return "vis/construction/metro-build-main";
    }
    @RequestMapping("generalize")
    public String generalize(Model model){
        String hql = "from VViewColumnArticle  where columnId=? order by createTime desc";
        java.util.List<VViewColumnArticle> articleList1 = vViewColumnArticleManager.find(hql,"8a808007650d4a6a01650e5596550003");
        Map<String, Object> parameterMap = new HashMap<>();
        String hql2="  from FileRecord where relationId=?";
        java.util.List<FileRecord>fileRecord=fileRecordManager.find(hql2,"8a808007650d4a6a01650e5596550003");
        java.util.List<String>filePath=new ArrayList<>();
        for(FileRecord file:fileRecord){
//            String c="http:\\localhost:8080\\";
            String c=file.getFilePath().split("webapps")[1];
            filePath.add(c);
        }
        model.addAttribute("articleList1", articleList1);
        model.addAttribute("fileRecord", fileRecord);
        model.addAttribute("filePath", filePath);
        return "vis/generalize/generalize-main";
    }
    @RequestMapping("show")
    public String show(String rowId,String columnId,String tag,Model model){
        String hql="from VViewColumnArticle WHERE articleId=? and columnId=? ORDER BY createTime desc";
        java.util.List<VViewColumnArticle> functionList = vViewColumnArticleManager.find(hql,rowId,columnId);
        model.addAttribute("VColumnArticle",functionList.get(0).getArticleContent());
        return "vis/construction/show";
    }
    @RequestMapping(method = RequestMethod.GET, value = "QR-code-show")
    public void downloadReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String qrCode = "C:\\qrCode\\20190527\\main.jpg";
        String fileName = "main.jpg";
        FileUtil fileHelper = new FileUtil();
        fileHelper.downloadFile(qrCode, request, response, fileName);

    }
}
