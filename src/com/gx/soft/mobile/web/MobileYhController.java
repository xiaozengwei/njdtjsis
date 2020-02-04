package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.manager.SysTypeDicManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.yh.persistence.domain.YhPcSituation;
import com.gx.soft.yh.persistence.manager.YhPcSituationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mobile-yh")
@SessionAttributes("user_session")
public class MobileYhController {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(MobileYhController.class);

	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private YhPcSituationManager yhPcSituationManager;

	@Autowired
	private SysTypeDicManager sysTypeDicManager;

	/**
	 * 获取隐患登记列表
	 * @param userId 当前用户
	 * @param tbDate 填报日期
	 * @param pageSize 每页记录数
	 * @param pageCurrent 当前页
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "yh-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult yhList(String userId,String tbDate,String bdId,
					  @RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize,
					  @RequestParam(value = "pageCurrent", required = false, defaultValue = "1")int pageCurrent) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-yh------->yh-list 获取隐患列表");
		String statusCode = "1";// 成功
		String message = "获取设备列表成功";

		List<YhPcSituation> wlList = null;
		try {
			Page page = new Page();
			page.addOrder("createTime", "desc");
			page.setPageCurrent(pageCurrent);
			page.setPageSize(pageSize);
			Map<String, Object> parameterMap = new HashMap<>();
			if(bdId==null|| bdId=="") {
				if (user != null) {
					parameterMap.put("filter_LIKES_bdId", user.getComBdId());
					parameterMap.put("filter_EQD_tbDate", tbDate);
					List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
					page = yhPcSituationManager.pagedQuery(page, propertyFilters);
					wlList = (List<YhPcSituation>) page.getResult();
				}
			}else {
				parameterMap.put("filter_LIKES_bdId", bdId);
				parameterMap.put("filter_EQD_tbDate", tbDate);
				List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
				page = yhPcSituationManager.pagedQuery(page, propertyFilters);
				wlList = (List<YhPcSituation>) page.getResult();
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取隐患列表失败";
			logger.error("mobile-yh------->yh-list 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, wlList, message);
	}

	/**
     * 查看详情
	 * @param rowId
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "yh-detail", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult yhDetail(String rowId) {
		logger.info("mobile-yh------->yh-detail 获取隐患信息");
		String statusCode = "1";// 成功
		String message = "获取隐患信息成功";
		YhPcSituation yhPcSituation = null;
		try {
			if(rowId != null && rowId.length() > 0){
				yhPcSituation = yhPcSituationManager.get(rowId);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取隐患信息失败";
			logger.error("mobile-yh------->yh-detail 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, yhPcSituation, message);
	}

}
