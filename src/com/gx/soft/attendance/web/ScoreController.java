package com.gx.soft.attendance.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.attendance.persistence.domain.GxSysScoreRecord;
import com.gx.soft.attendance.persistence.domain.GxSysScoreRule;
import com.gx.soft.attendance.persistence.domain.VUserOrgScore;
import com.gx.soft.attendance.persistence.manager.GxSysScoreManager;
import com.gx.soft.attendance.persistence.manager.GxSysScoreRecordManager;
import com.gx.soft.attendance.persistence.manager.GxSysScoreRuleManager;
import com.gx.soft.attendance.persistence.manager.VUserOrgScoreManager;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("score")
@SessionAttributes("user_session")
public class ScoreController {

    /**
     *  积分查询
     * @param
     * @param model
     * @return
     */
    @RequestMapping("get-all-score")
    public String getAllScore(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page, @ModelAttribute("user_session") VUser user2){
        List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("orderNum","desc");
        page = gxSysScoreManager.pagedQuery(page,propertyFilterList);

        model.addAttribute("page",page);
        return "attendance/score-list";
    }
    /**
     *  积分详情查询
     * @param
     * @param model
     * @return
     */
    @RequestMapping("get-score-detail")
    public String getScoreDetail(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page, @ModelAttribute("user_session") VUser user2){
        List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("dataOrder","desc");
        page=vUserOrgScoreManager.pagedQuery(page,propertyFilterList);
        List<VUserOrgScore> scoreList= (List<VUserOrgScore>)page.getResult();

        model.addAttribute("scoreList",scoreList);
        model.addAttribute("page",page);
        return "attendance/score-detail";
    }
    /**
     *  积分管理
     * @param
     * @param model
     * @return
     */
    @RequestMapping("get-all-score1")
    public String getAllScore1(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page, @ModelAttribute("user_session") VUser user2){
        List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("orderNum","desc");
        page = gxSysScoreManager.pagedQuery(page,propertyFilterList);

        model.addAttribute("page",page);
        return "attendance/score-list1";
    }
    /**
     *  积分详情管理
     * @param
     * @param model
     * @return
     */
    @RequestMapping("get-score-detail1")
    public String getScoreDetail1(@RequestParam Map<String, Object> parameterMap, Model model, @ModelAttribute Page page, @ModelAttribute("user_session") VUser user2,String name){
        List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("dataOrder","desc");
        page=vUserOrgScoreManager.pagedQuery(page,propertyFilterList);
        List<VUserOrgScore> scoreList= (List<VUserOrgScore>)page.getResult();

        model.addAttribute("name",name);
        model.addAttribute("userId",parameterMap.get("filter_EQS_userId"));
        model.addAttribute("scoreList",scoreList);
        model.addAttribute("page",page);
        return "attendance/score-detail1";
    }

    /**
     *  添加/编辑积分记录
     * @param
     * @param model
     * @return
     */
    @RequestMapping("score-input")
    public String input(String scoreKey, Model model,String name,String userId) {
        GxSysScoreRecord gxSysScoreRecord=null;
        if (scoreKey != null) {
            gxSysScoreRecord = gxSysScoreRecordManager.findUniqueBy("rowId",scoreKey);
        } else {
            gxSysScoreRecord = new GxSysScoreRecord();
        }

        try{
            model.addAttribute("name",URLDecoder.decode(name,"UTF-8"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        String hql="from GxSysScoreRule r where r.orgRowId in(select orgId from GxSysUserInOrg io where io.userId=?)";
        GxSysScoreRule gxSysScoreRule=gxSysScoreRuleManager.findUnique(hql,userId);
        model.addAttribute("scoreKey",scoreKey);
        model.addAttribute("userId",userId);
        model.addAttribute("model", gxSysScoreRecord);
        model.addAttribute("ruleList",gxSysScoreRule);
        return "attendance/score-input";
    }

    /**
     * 积分记录保存/更新
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value="score-save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(GxSysScoreRecord gxSysScoreRecord) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Timestamp ts = DateUtil.getDate();
        try {
            GxSysScoreRecord dest=null;
            String id =gxSysScoreRecord.getRowId();

            String hql = "SELECT max(s.orderNum) FROM  GxSysScoreRecord s where s.userId=?";
            List maxNum = gxSysScoreRecordManager.find(hql, gxSysScoreRecord.getUserId());
            int num = 1;
            if (maxNum.size() < 1) {
                num = 1;
            } else {
                Object obj = maxNum.get(0);
                num = !StringUtils.validateLong(obj) ? 1 : new BigDecimal(
                        obj.toString()).intValue() + 1;

            }
            if(id!= null&&id.length()>0){
                dest=gxSysScoreRecordManager.get(id);
                if(dest!=null){
                    beanMapper.copy(gxSysScoreRecord,dest);
                    dest.setUpdateTime(ts);
                }
            } else {
                gxSysScoreRecord.setRowId(null);
                gxSysScoreRecord.setOrderNum(num);
                dest=gxSysScoreRecord;
                dest.setCreateTime(ts);
            }
            gxSysScoreRecordManager.save(dest);
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
    /**
     * 考勤记录的删除
     *
     * @param delids
     * @return
     */
    @RequestMapping("score-remove")
    public @ResponseBody
    Map<String, Object> ruleRemove(String delids) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "删除成功";
        try {
            if (delids != null && delids.length() > 0) {
                String[] ids = delids.split(",");
                for (String rowId : ids) {
                    if (rowId != null) {
                        GxSysScoreRecord sysAttRule=gxSysScoreRecordManager.get(rowId);
                        if (sysAttRule != null) {
                            gxSysScoreRecordManager.remove(sysAttRule);
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
        resMap.put("reload", true);
        return resMap;
    }

    @Resource(name="vUserOrgScoreManager")
    private VUserOrgScoreManager vUserOrgScoreManager;
    @Resource(name="gxSysScoreManager")
    private GxSysScoreManager gxSysScoreManager;
    @Resource(name="gxSysScoreRecordManager")
    private GxSysScoreRecordManager gxSysScoreRecordManager;
    @Resource(name="gxSysScoreRuleManager")
    private GxSysScoreRuleManager gxSysScoreRuleManager;
    BeanMapper beanMapper =new BeanMapper();
}
