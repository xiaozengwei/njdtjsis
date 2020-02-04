package com.gx.soft.yh.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.yh.persistence.domain.YhPcSituation;
import com.gx.soft.yh.persistence.manager.YhPcSituationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("yh")
@SessionAttributes("user_session")
public class YhController {

	@Autowired
	private YhPcSituationManager yhPcSituationManager;
	@Autowired
	private FileRecordManager fileRecordManager;
	@Autowired
	private GxRecordManager gxRecordManager;
	
	private BeanMapper beanMapper = new BeanMapper();

	/**
	 * 前往设备信息列表
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("yh-list")
	public String yhList(@ModelAttribute Page page, @RequestParam Map<String, Object> parameterMap, Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = yhPcSituationManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		return "yh/yh-list";
	}

	/**
	 * 设备信息的添加/更新页面
	 * 
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("yh-input")
	public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		YhPcSituation yhPcSituation;
		if (rowId != null && rowId.length() > 0) {
			yhPcSituation = yhPcSituationManager.get(rowId);
			model.addAttribute("yhPcSituation", yhPcSituation);
		}
		return "yh/yh-input";
	}

	@RequestMapping("yh-detail")
	public String detail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			YhPcSituation yhPcSituation = yhPcSituationManager.get(rowId);
			model.addAttribute("yhPcSituation", yhPcSituation);
		}
		return "yh/yh-detail";
	}

	/**
	 * 更新或保存设备信息
	 * 
	 * @param yhPcSituation
	 * @return
	 */
	@RequestMapping(value = "yh-save",method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, Object> save(YhPcSituation yhPcSituation, @ModelAttribute("user_session") VUser user) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			YhPcSituation dest ;
			String id = yhPcSituation.getRowId();
			if (id != null && id.length() > 0) {
				dest = yhPcSituationManager.get(id);
				beanMapper.copy(yhPcSituation, dest);
//				dest.setUpdateTime(ts);
//				dest.setUpdateUserId(user.getUserId());
//				dest.setUpdateUserName(user.getUserName());
				yhPcSituationManager.save(dest);
			} else {
				yhPcSituation.setRowId(null);
				dest = yhPcSituation;
				dest.setCreateTime(ts);
				dest.setComOrgId(user.getComOrgId());
				dest.setBdId(user.getComBdId());
				yhPcSituationManager.save(dest);
			}
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
	 * 隐患排查情况表删除
	 * 
	 * @return
	 */
	@RequestMapping("remove")
	public @ResponseBody
	Map<String, Object> yhRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null && rowId.length() > 0) {
						yhPcSituationManager.removeById(rowId);
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

}
