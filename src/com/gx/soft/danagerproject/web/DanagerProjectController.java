package com.gx.soft.danagerproject.web;

//import com.gx.core.export.ExcelDataNormalStrategy;
//import com.gx.core.export.ExcelDataReflectionStrategy;
//import com.gx.core.export.ExcelExportUtil;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
//import com.gx.core.util.ServletUtils;
import com.gx.soft.common.util.DateUtil;
//import com.gx.soft.common.util.ExcelOptUtil;
import com.gx.soft.danagerproject.persistence.domain.DanagerProject;
import com.gx.soft.danagerproject.persistence.manager.DanagerProjectManager;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.VerticalAlignment;
//import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/6/20.
 */
@Controller
@RequestMapping("dangerproject")
@SessionAttributes("user_session")
public class DanagerProjectController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private DanagerProjectManager danagerProjectManager;

    @RequestMapping("dangerproject-list")
    public String generalizeList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user){
        parameterMap.put("filter_EQS_bdId",user.getComBdId());
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = danagerProjectManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        return "dangerproject/dangerproject-list";
    }
    @RequestMapping("dangerproject-input")
    public String generalizeInput(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        DanagerProject danagerProject;
        if (rowId != null) {
            danagerProject = danagerProjectManager.get(rowId);
        } else {
            danagerProject = new DanagerProject();
        }
        model.addAttribute("danagerProject", danagerProject);
        return "dangerproject/dangerproject-input";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> save(DanagerProject danagerProject, @ModelAttribute("user_session") VUser user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            DanagerProject dest = null;
            String id = danagerProject.getRowId();
            if (id != null && id.length() > 0) {
                dest = danagerProjectManager.get(id);
                dest.setCreateTime(ts);
                beanMapper.copy(danagerProject, dest);
            } else {
                danagerProject.setRowId(null);
                dest=danagerProject;
                dest.setCreateTime(ts);
            }
            danagerProjectManager.save(dest);
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
    public Map<String, Object> remove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        danagerProjectManager.removeById(rowId);
                        System.out.print("");
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
    @RequestMapping("look")
    public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
        DanagerProject danagerProject;
        danagerProject = danagerProjectManager.get(rowId);
        model.addAttribute("danagerProject", danagerProject);
        return "dangerproject/dangerproject-look";
    }
//    @RequestMapping("export")
//    public void export(HttpServletResponse response, HttpSession session, String name) throws Exception {
////1.测试含有实体类的，有注解的方式
//        List<DanagerProject> users = danagerProjectManager.getAll();
//
//        String[] columnNameArr = {"userName", "age", "gender"};
//        String fileName = "用户列表导出";
//        Map<String, Object> metaMap = new HashMap<>();
//
//        metaMap.put("clazz", DanagerProject.class);
//        metaMap.put("columnNames", columnNameArr);
//        metaMap.put("columnWidth", null);
//        metaMap.put("columnComment", null);
//        ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataReflectionStrategy());
//        try {
//            excelExportUtil.exportBean(response, fileName, users, metaMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


}
