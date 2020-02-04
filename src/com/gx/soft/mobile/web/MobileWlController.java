package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.WlCountVo;
import com.gx.soft.sb.persistence.domain.SysTypeDic;
import com.gx.soft.sb.persistence.manager.SysTypeDicManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.wl.persistence.domain.MaterialInfo;
import com.gx.soft.wl.persistence.domain.UnqualifiedTest;
import com.gx.soft.wl.persistence.domain.UnqualifiedTestJczx;
import com.gx.soft.wl.persistence.manager.MaterialInfoManager;
import com.gx.soft.wl.persistence.manager.UnqualifiedTestJczxManager;
import com.gx.soft.wl.persistence.manager.UnqualifiedTestManager;
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
@RequestMapping("mobile-wl")
@SessionAttributes("user_session")
public class MobileWlController {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(MobileWlController.class);

	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private MaterialInfoManager materialInfoManager;

	@Autowired
	private SysTypeDicManager sysTypeDicManager;

	@Autowired
	private UnqualifiedTestManager unqualifiedTestManager;

	@Autowired
	private UnqualifiedTestJczxManager unqualifiedTestJczxManager;

	/**
	 * 获取设备信息列表（按照进场时间排序）
	 * @param userId
	 * @param materialName 物料名称
	 * @param batchNumber 批号
	 * @param pageSize 每页记录数
	 * @param pageCurrent 当前页
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "wl-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult wlList(String userId,String bdId,String materialName, String batchNumber,String materialType,
					  @RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize,
					  @RequestParam(value = "pageCurrent", required = false, defaultValue = "1")int pageCurrent) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-wl------->wl-list 获取设备信息列表");
		String statusCode = "1";// 成功
		String message = "获取设备列表成功";
		List<MaterialInfo> wlList = null;
		try {
			Page page = new Page();
			page.setOrderBy("enterTime");
			page.setOrder("DESC");
			page.setPageCurrent(pageCurrent);
			page.setPageSize(pageSize);
			Map<String, Object> parameterMap = new HashMap<>();
			if(bdId==null|| bdId=="") {
				if (user != null) {
					if (!user.getUserId().equals("yu_j") && !user.getUserId().equals("ren_yy") && !user.getUserId().equals("si_sy")) {
						parameterMap.put("filter_EQS_bdId", user.getComBdId());
					}
					parameterMap.put("filter_LIKES_materialType", materialType);
					parameterMap.put("filter_LIKES_materialName", materialName);
					parameterMap.put("filter_LIKES_batchNumber", batchNumber);
					List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
					page = materialInfoManager.pagedQuery(page, propertyFilters);
					wlList = (List<MaterialInfo>) page.getResult();
				}
			}else{
				parameterMap.put("filter_EQS_bdId", bdId);
				parameterMap.put("filter_LIKES_materialType", materialType);
				parameterMap.put("filter_LIKES_materialName", materialName);
				parameterMap.put("filter_LIKES_batchNumber", batchNumber);
				List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
				page = materialInfoManager.pagedQuery(page, propertyFilters);
				wlList = (List<MaterialInfo>) page.getResult();
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取物料列表失败";
			logger.error("mobile-wl------->wl-list 出错了");
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
	@RequestMapping(value = "wl-detail", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult wlDetail(String rowId) {
		logger.info("mobile-wl------->wl-detail 获取物料详细信息");
		String statusCode = "1";// 成功
		String message = "获取物料信息成功";
		MaterialInfo materialInfo = null;
		try {
			if(rowId != null && rowId.length() > 0){
				materialInfo = materialInfoManager.get(rowId);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取物料信息失败";
			logger.error("mobile-wl------->wl-detail 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, materialInfo, message);
	}

	/**
	 * 物料管理
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "wl-count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult sbCount(String userId,String bdId) {
		VUser user = vUserManager.findUniqueBy("userId", userId);
		String bdIdOld="";
		List<SysTypeDic> dicList=new ArrayList<>();
		dicList = sysTypeDicManager.findBy("dicType", "wl_type");
		if(user!=null) {
			bdIdOld = user.getComBdId() == null ? "" : user.getComBdId();
		}
		if(bdId!=null){
			dicList = sysTypeDicManager.findBy("dicType", "wl_type");
		}
		logger.info("mobile-wl------->wl-count 获取物料管理");
		String statusCode = "1";// 成功
		String message = "获取物料管理成功";
		List<WlCountVo> resList = new ArrayList<>();
		try {
			String hql = "";
			if(bdIdOld.length() > 0){
				hql = "from MaterialInfo where materialType = ? and bdId = '"+bdIdOld+"'";
			}else{
				hql = "from MaterialInfo where materialType = ?";
			}
			for(SysTypeDic sysTypeDic : dicList){
				WlCountVo wlCountVo = new WlCountVo();
				wlCountVo.setDicName(sysTypeDic.getDicName());
				Double count = 0.000;
				Object[] values = {sysTypeDic.getDicName()};
				List<MaterialInfo> list = materialInfoManager.find(hql, values);
				if(bdId==null || bdId=="") {
					if (list != null && list.size() > 0) {
						for (MaterialInfo materialInfo : list) {
							if(user!=null) {
								count += materialInfo.getEnterNumber();
							}else{
								count=0.0;
							}
						}
					}
				}else {
					String hql1 = "from MaterialInfo where materialType = ? and bdId = '"+bdId+"'";
					List<MaterialInfo> list1 = materialInfoManager.find(hql1, values);
					if (list1 != null && list1.size() > 0) {
						for (MaterialInfo materialInfo : list1) {
							count += materialInfo.getEnterNumber();
						}
					}
				}
				wlCountVo.setDicTotal(String.format("%.3f", count));
				resList.add(wlCountVo);
			}
			//添加不合格检测
			WlCountVo wlCountVo = new WlCountVo();
			wlCountVo.setDicName("不合格检测");
			if(bdId==null || bdId=="") {
				String hql2="from UnqualifiedTest where comBdId=?";
				int num=0;
				if(userId.equals("admin") || userId.equals("gong_hx")) {
					num=unqualifiedTestManager.getCount();
				}else{
					num = unqualifiedTestManager.find(hql2, bdIdOld).size();
				}
				wlCountVo.setDicTotal(num+ "");
				resList.add(wlCountVo);
			}else{
				String hql3="from UnqualifiedTest where comBdId=?";
				int num=unqualifiedTestManager.find(hql3,bdId).size();
				wlCountVo.setDicTotal(num + "");
				resList.add(wlCountVo);
			}

			WlCountVo wlBhgCountVo=new WlCountVo();
			wlBhgCountVo.setDicName("不合格检测（检测中心）");
			if(bdId==null || bdId=="") {
				System.out.println();
				String hql2="from UnqualifiedTestJczx where comBdId=?";
				int num=0;
				if(userId.equals("admin") || userId.equals("gong_hx")) {
					num=unqualifiedTestJczxManager.getCount();
				}else{
					num = unqualifiedTestJczxManager.find(hql2, bdIdOld).size();
				}
				wlBhgCountVo.setDicTotal(num+ "");
				resList.add(wlBhgCountVo);
			}else{
				String hql3="from UnqualifiedTestJczx where comBdId=?";
				int num=unqualifiedTestJczxManager.find(hql3,bdId).size();
				wlBhgCountVo.setDicTotal(num + "");
				resList.add(wlBhgCountVo);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取物料管理失败";
			logger.error("mobile-wl------->wl-count 出错了");
			ex.printStackTrace();
		}
		for(WlCountVo wl:resList){
			if(wl.getDicName().equals("不合格检测（检测中心）") || wl.getDicName().equals("不合格检测")){
				wl.setDanWei("项");
			}else{
				wl.setDanWei("吨");
			}
		}
		return new JsonResult(statusCode, resList, message);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bhg-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult bhgList(String userId,String materialName,String bdId, String testProject,String testReportNo,
					  @RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize,
					  @RequestParam(value = "pageCurrent", required = false, defaultValue = "1")int pageCurrent) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-wl------->bhg-list 获取不合格列表");
		String statusCode = "1";// 成功
		String message = "获取不合格列表成功";
		List<UnqualifiedTest> bhgList = null;
		try {
			Page page = new Page();
			page.setOrderBy("testDate");
			page.setOrder("DESC");
			page.setPageCurrent(pageCurrent);
			page.setPageSize(pageSize);
			Map<String, Object> parameterMap = new HashMap<>();
			if(bdId==null || bdId=="") {
				if (user != null) {
					parameterMap.put("filter_LIKES_comBdId", user.getComBdId());
					parameterMap.put("filter_LIKES_materialName", materialName);
					parameterMap.put("filter_LIKES_testProject", testProject);
					parameterMap.put("filter_LIKES_testReportNo", testReportNo);
					List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
					page = unqualifiedTestManager.pagedQuery(page, propertyFilters);
					bhgList = (List<UnqualifiedTest>) page.getResult();
				}
			}else {
				parameterMap.put("filter_LIKES_comBdId", bdId);
				parameterMap.put("filter_LIKES_materialName", materialName);
				parameterMap.put("filter_LIKES_testProject", testProject);
				parameterMap.put("filter_LIKES_testReportNo", testReportNo);
				List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
				page = unqualifiedTestManager.pagedQuery(page, propertyFilters);
				bhgList = (List<UnqualifiedTest>) page.getResult();
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取不合格列表失败";
			logger.error("mobile-wl------->bhg-list 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, bhgList, message);
	}

	/**
	 *
	 * @param rowId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bhg-detail", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult bhgDetail(String rowId) {
		logger.info("mobile-wl------->bhg-detail 获取检验不合格详细信息");
		String statusCode = "1";// 成功
		String message = "获取检验不合格信息成功";
		UnqualifiedTest unqualifiedTest = null;
		try {
			if(rowId != null && rowId.length() > 0){
				unqualifiedTest = unqualifiedTestManager.get(rowId);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取检验不合格信息失败";
			logger.error("mobile-wl------->bhg-detail 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, unqualifiedTest, message);
	}

	/****************************************检测中心抽检不合格*******************************************/

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "jczx-bhg-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult jczxBhgList(String userId,String materialName, String bdId,String testProject,String testReportNo,
					   @RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize,
					   @RequestParam(value = "pageCurrent", required = false, defaultValue = "1")int pageCurrent) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-wl------->jczx-bhg-list 获取检测中心抽检不合格列表");
		String statusCode = "1";// 成功
		String message = "检测中心抽检不合格列表成功";
		List<UnqualifiedTestJczx> jczxBhgList = null;
		try {
			Page page = new Page();
			page.setOrderBy("testDate");
			page.setOrder("DESC");
			page.setPageCurrent(pageCurrent);
			page.setPageSize(pageSize);
			Map<String, Object> parameterMap = new HashMap<>();
			if(bdId==null || bdId=="") {
				parameterMap.put("filter_LIKES_comBdId", user.getComBdId());
			}else {
				parameterMap.put("filter_LIKES_comBdId", bdId);
			}
			parameterMap.put("filter_LIKES_materialName",materialName);
			parameterMap.put("filter_LIKES_testProject",testProject);
			parameterMap.put("filter_LIKES_testReportNo",testReportNo);
			List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
			page = unqualifiedTestJczxManager.pagedQuery(page, propertyFilters);
			jczxBhgList = (List<UnqualifiedTestJczx>) page.getResult();
		}
		catch (Exception ex) {
			statusCode = "-1";
			message = "检测中心抽检不合格列表失败";
			logger.error("mobile-wl------->jczx-bhg-list 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, jczxBhgList, message);
	}

	/**
	 *
	 * @param rowId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "jczx-bhg-detail", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult jczxBhgDetail(String rowId) {
		logger.info("mobile-wl------->jczx-bhg-detail 获取检测中心抽检不合格详细信息");
		String statusCode = "1";// 成功
		String message = "获取检测中心抽检不合格信息成功";
		UnqualifiedTestJczx unqualifiedTestJczx = null;
		try {
			if(rowId != null && rowId.length() > 0){
				unqualifiedTestJczx = unqualifiedTestJczxManager.get(rowId);
			}
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取检测中心抽检不合格信息失败";
			logger.error("mobile-wl------->jczx-bhg-detail 出错了");
			ex.printStackTrace();
		}
		return new JsonResult(statusCode, unqualifiedTestJczx, message);
	}

}
