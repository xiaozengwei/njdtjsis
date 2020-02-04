package com.gx.soft.mobile.web;


import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.domain.EquipmentInfo;
import com.gx.soft.sb.persistence.domain.SysTypeDic;
import com.gx.soft.sb.persistence.manager.EquipmentInfoManager;

import com.gx.soft.sb.persistence.manager.SysTypeDicManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("mobile-sb")
@SessionAttributes("user_session")
public class MobileSbController {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(MobileSbController.class);

	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private EquipmentInfoManager equipmentInfoManager;

	@Autowired
	private SysTypeDicManager sysTypeDicManager;

	/**
	 *
	 * @param userId
	 * @param sbZL 设备种类
	 * @param managerNum 管理编号
	 * @param pageSize 每页记录数
	 * @param pageCurrent 当前页
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "sb-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult sbList(String userId,String sbZL,String bdId, String managerNum,String equipmentName,
					  @RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize,
					  @RequestParam(value = "pageCurrent", required = false, defaultValue = "1")int pageCurrent) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-sb------->sb-list 获取设备信息列表");
		String statusCode = "1";// 成功
		String message = "获取设备信息成功";
		List<EquipmentInfo> sbList = null;
		try {
			Page page = new Page();
			page.setOrderBy("enterTime");
			page.setOrder("DESC");
			page.setPageCurrent(pageCurrent);
			page.setPageSize(pageSize);
			Map<String, Object> parameterMap = new HashMap<>();
			if(bdId==null|| bdId=="") {
				if (user != null) {
					parameterMap.put("filter_EQS_equipmentName", equipmentName);
					if (!user.getUserId().equals("yu_j")) {
						parameterMap.put("filter_EQS_bdId", user.getComBdId());
					}
					parameterMap.put("filter_LIKES_sbZl", sbZL);
					parameterMap.put("filter_LIKES_managerNum", managerNum);
					List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
					page = equipmentInfoManager.pagedQuery(page, propertyFilters);
					sbList = (List<EquipmentInfo>) page.getResult();
				}
			}else{
				parameterMap.put("filter_EQS_equipmentName", equipmentName);
				parameterMap.put("filter_EQS_bdId", bdId);
				parameterMap.put("filter_LIKES_sbZl", sbZL);
				parameterMap.put("filter_LIKES_managerNum", managerNum);
				List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
				page = equipmentInfoManager.pagedQuery(page, propertyFilters);
				sbList = (List<EquipmentInfo>) page.getResult();
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取设备列表失败";
			logger.error("mobile-sb------->sb-list 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, sbList, message);
	}

	/**
	 * 查看详情
	 * @param rowId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "sb-detail", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult sbDetail(String rowId) {
		logger.info("mobile-sb------->sb-detail 获取设备信息");
		String statusCode = "1";// 成功
		String message = "获取设备信息成功";
		EquipmentInfo equipmentInfo = null;
		try {
			if(rowId != null && rowId.length() > 0){
				equipmentInfo = equipmentInfoManager.get(rowId);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取设备列表失败";
			logger.error("mobile-sb------->sb-detail 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, equipmentInfo, message);
	}

	/**
	 * 设备管理
	 * @return
	 */
	@RequestMapping(value = "sb-count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult sbCount(String userId,String bdId) {
		VUser user = vUserManager.findUniqueBy("userId", userId);
		String bdIdOld="";
		List<SysTypeDic> dicList=new ArrayList<>();
		dicList= sysTypeDicManager.findBy("dicType", "sb_type");
		if(user!=null) {
			 bdIdOld = user.getComBdId() == null ? "" : user.getComBdId();
		}
		if(bdId!=null){
			dicList= sysTypeDicManager.findBy("dicType", "sb_type");
		}
		logger.info("mobile-sb------->sb-count 获取设备统计");
		String statusCode = "1";// 成功
		String message = "获取设备信息成功";

		try {
			String hql = "";
			if(bdIdOld.length() > 0){
				hql = "select count(*) from EquipmentInfo where sbZl = ? and bdId = '"+bdIdOld+"'";
			}else{
				hql = "select count(*) from EquipmentInfo where sbZl = ? ";
			}
			for(SysTypeDic sysTypeDic : dicList){
				Integer count = 0;
				Object[] values = {sysTypeDic.getDicName()};
				if(bdId==null || bdId=="") {
					if(user!=null) {
						count = equipmentInfoManager.getCount(hql, values);
					}else {
						count=0;
					}
				}else{
					String hql1="select count(*) from EquipmentInfo where sbZl = ? and bdId = '"+bdId+"'";
					count = equipmentInfoManager.getCount(hql1, values);
				}

				sysTypeDic.setDicTotal(count);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取设备列表失败";
			logger.error("mobile-sb------->sb-detail 出错了");
			ex.printStackTrace();
		}

		return new JsonResult(statusCode, dicList, message);
	}

}
