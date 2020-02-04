package com.gx.soft.process.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.process.persistence.domain.VDtYc;
import com.gx.soft.process.persistence.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/4.
 */
@Controller
@RequestMapping("dtyc")
public class DtYcDisposeController {
    private BeanMapper beanMapper = new BeanMapper();

    @Autowired
    private ProActManager procActManager;
    @Autowired
    private ProActInstanceManager procActInstanceManager;
    @Autowired
    private ProTemplateManager procTemplateManager;
    @Autowired
    private ProInstanceManager proInstanceManager;
    @Autowired
    private DtYcApplyManager dtYcApplyManager;
    @Autowired
    private AttachmentManager attachmentManager;
    @Autowired
    private HistoryOpinionManager historyOpinionManager;
    @Autowired
    private  VDtYcManager vDtYcManager;

    @RequestMapping("to-dtyc-dispose")
    public String hysTaskList(Page page,
                              @RequestParam(required = false, defaultValue = "") String orderField,
                              @RequestParam(required = false, defaultValue = "") String orderDirection,
                              HttpSession session,
                              @RequestParam Map<String, Object> parameterMap, Model model){
//       VUser user= (VUser) session.getAttribute("user_session");
        if (orderField.length() > 0 && orderDirection.length() > 0) {
            page.setOrderBy(orderField);
            page.setOrder(orderDirection);
        }else {
            page.setOrderBy("activeTime");
            page.setOrder("ASC");
        }
        //添加条件为根据当前用户查询
//        parameterMap.put("filter_EQS_handleUser", user.getUserName());
        parameterMap.put("filter_EQS_activeState", "激活");
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page = vDtYcManager.pagedQuery(page, propertyFilters);
        List<VDtYc> list = (List<VDtYc>) page.getResult();
        page.setResult(list);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        return "dtyc/dispose/dtyc-dispose";
    }

}
