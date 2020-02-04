package com.gx.soft.mobile.web;


import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.manager.GxOaMobileFunctionManager;
import com.gx.soft.mobile.persistence.vo.DoorControlNameVo;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.restservice.persistence.domain.VUserInOrgAtt;
import com.gx.soft.restservice.persistence.manager.VUserInOrgAttManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mobile-door")
@SessionAttributes(value={"user_session"})
public class MobileDoorController {
    @Autowired
    private GxOaMobileFunctionManager gxOaMobileFunctionManager;
    @Autowired
    private VUserManager vUserManager;
    @Autowired
    private VUserInOrgAttManager vUserInOrgAttManager;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "door-list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResult voList(String bdId, @ModelAttribute Page page, @RequestParam Map<String, Object> paramMap) {
        String statusCode = "1";// 成功
        String message = "获取列表成功";
        List<DoorControlNameVo> doorList=new ArrayList<>();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(date);
        String st=time+" 00:00:00";
        String end=time+" 23:59:59";
        paramMap.put("filter_GED_signTime",st);
        paramMap.put("filter_LED_signTime",end);
        paramMap.put("filter_EQS_signType","0");
        paramMap.put("filter_LIKES_bdId",bdId);

        List<String> list= vUserInOrgAttManager.find("select doorControlName from VUserInOrgAtt where bdId=? and signTime=? group by doorControlName",bdId,new Date());
        for(String doorControlName:list){
            if(doorControlName!=null){
                paramMap.put("filter_EQS_doorControlName",doorControlName);
                DoorControlNameVo doorControlNameVo = new DoorControlNameVo();
                doorControlNameVo.setBdId(bdId);
                doorControlNameVo.setDoorControlName(doorControlName);
                doorControlNameVo.setCount(String.valueOf(vUserInOrgAttManager.find(PropertyFilter.buildFromMap(paramMap)).size()));
                doorList.add(doorControlNameVo);
            }

        }
        return new JsonResult(statusCode,doorList,message);
    }
}
