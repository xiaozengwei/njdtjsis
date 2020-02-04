package com.gx.soft.vis.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.vis.persistence.domain.GxViewColumn;
import com.gx.soft.vis.persistence.domain.GxViewColumnArticle;
import com.gx.soft.vis.persistence.domain.GxViewColumnArticleRelation;
import com.gx.soft.vis.persistence.manager.GxViewColumnArticleReManager;
import com.gx.soft.vis.persistence.manager.GxViewColumnManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adminstrator on 2019/5/22.
 */
@Controller
@RequestMapping("vis")
public class ColumnController {
    private BeanMapper beanMapper = new BeanMapper();
    @Autowired
    private GxViewColumnManager gxViewColumnManager;

    @Autowired
    private GxViewColumnArticleReManager gxViewColumnArticleReManager;

    @RequestMapping("column-list")
    public String list(Page page, String orderField, String orderDirection,
                       @RequestParam Map<String, Object> parameterMap, Model model) {

        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("createTime", "desc");
        page = gxViewColumnManager.pagedQuery(page, propertyFilters);

        // List<GxSysOrg> orgList = (List<GxSysOrg>) page.getResult();
        Map<String, GxViewColumn> orgIdAndNameMap = new HashMap<>();
        List<GxViewColumn> orgList = gxViewColumnManager.find(propertyFilters);
        for (GxViewColumn column : orgList) {
            orgIdAndNameMap.put(column.getRowId(), column);
        }
        // page.setResult(orgList);
        model.addAttribute("page", page);
        model.addAttribute("orgIdAndNameMap", orgIdAndNameMap);
        model.addAttribute("orderField", orderField);
        model.addAttribute("orderDirection", orderDirection);

        return "vis/column-list";

    }
    @RequestMapping("vis-input-column")
    public String inputColumn(Model model) {
        GxViewColumn gxViewColumn=new GxViewColumn();

        model.addAttribute("gxViewColumn",gxViewColumn);
        return "vis/vis-input-column";
    }
    @RequestMapping(value = "column-save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(GxViewColumn gxViewColumn) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            GxViewColumn dest = null;
            String id = gxViewColumn.getRowId();

            if (id != null && id.length() > 0) {
                dest = gxViewColumnManager.get(id);
                if (dest != null) {
//                    String parentName=dest.getParentName().trim();
//                    System.out.println(parentName);
//                    if(parentName.isEmpty()){
//                        gxViewColumn.setParentId("0");
//                    }
//                    System.out.println(gxViewColumn.getParentId());
                    beanMapper.copy(gxViewColumn, dest);
                    dest.setCreateTime(ts);
                }
            } else {
                gxViewColumn.setRowId(null);
                dest = gxViewColumn;
                dest.setCreateTime(ts);
            }
            gxViewColumnManager.save(dest);

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
    @RequestMapping("vis-delete-column")
    @ResponseBody
    public Map<String, Object> viewRemove(@RequestParam("delides") String delides) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delides != null && delides.length() > 0) {
                String[] ids = delides.split(",");
                for (String rowId : ids) {
                    if (rowId != null && rowId.length() > 0) {
                        gxViewColumnManager.removeById(rowId);
                        String hql="select rowId from GxViewColumnArticleRelation where columnId=?";
                        List<String>rowIdList=gxViewColumnArticleReManager.find(hql,rowId);
                        for(String id:rowIdList) {
                            gxViewColumnArticleReManager.removeById(id);
                        }
                    }
                }
            }
        } catch (Exception e) {
            statusCode = "300";
            message = "删除失败";
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("divid", "user-manager-view-list");
        return resMap;
    }
    @RequestMapping("vis-column-edit")
    public String edit(@RequestParam("bean") String bean,Model model) {
        GxViewColumn gxViewColumn=gxViewColumnManager.get(bean);
        model.addAttribute("gxViewColumn",gxViewColumn);
        model.addAttribute("columnId",bean);
        return "vis/vis-column-edit";
    }
    @RequestMapping("lookup-vis-column-list")
    public String orgLookupList(@ModelAttribute Page page,
                                @RequestParam Map<String, Object> parameterMap, Model model) {

        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        page = gxViewColumnManager.pagedQuery(page, propertyFilters);
        List<GxViewColumn> columnList = (List<GxViewColumn>) page.getResult();
        page.setResult(columnList);
        model.addAttribute("page", page);

        return "vis/column-list-lookup";

    }
}
