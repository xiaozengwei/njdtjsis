package com.gx.soft.mobile.web;

import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.manager.GxOaMobileFunctionManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.WorksitePublicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/7/4.
 */
@Controller
@RequestMapping("mobile-vo")
public class WorksiteVoController {
    @Autowired
    private GxOaMobileFunctionManager gxOaMobileFunctionManager;
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "vo-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult voList(String userId,String functionId,@ModelAttribute Page page, @RequestParam Map<String, Object> paramMap) {
        String statusCode = "1";// 成功
        String message = "获取列表成功";
        List<WorksitePublicVo>publicVoList=new ArrayList<>();
        String pageName=gxOaMobileFunctionManager.get(functionId).getFunctionUrl();
        if(userId.equals("admin") || userId.equals("gong_hx")){
            for(int i=0;i<5;i++){
                if(i==0) {
                    WorksitePublicVo publicVo = new WorksitePublicVo();
                    publicVo.setBdId("010301");
                    publicVo.setBdName("1号线北延工程土建施工D1N-TA01标");
                    publicVo.setPageName(pageName);
                    publicVoList.add(publicVo);
                }else if(i==1) {
                    WorksitePublicVo publicVo = new WorksitePublicVo();
                    publicVo.setBdId("010802");
                    publicVo.setBdName("1号线北延工程土建施工D1N-TA03标");
                    publicVo.setPageName(pageName);
                    publicVoList.add(publicVo);
                }else if(i==2){
                    WorksitePublicVo publicVo = new WorksitePublicVo();
                    publicVo.setBdId("010401");
                    publicVo.setBdName("1号线北延工程土建施工D1N-TA04标");
                    publicVo.setPageName(pageName);
                    publicVoList.add(publicVo);
                }else if(i==3) {
                    WorksitePublicVo publicVo = new WorksitePublicVo();
                    publicVo.setBdId("010501");
                    publicVo.setBdName("1号线北延工程二桥公园停车场D1N-TA05标");
                    publicVo.setPageName(pageName);
                    publicVoList.add(publicVo);
                }
                else {
                        WorksitePublicVo publicVo = new WorksitePublicVo();
                        publicVo.setBdId("010201");
                        publicVo.setBdName("1号线北延工程土建施工D1N-TA02标");
                        publicVo.setPageName(pageName);
                        publicVoList.add(publicVo);
                }
            }
        }else {
            statusCode="0";
            message="获取列表失败";
        }
        return new JsonResult(statusCode,publicVoList,message);
    }
}
