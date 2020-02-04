package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.attendance.persistence.manager.VAttManager;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.mobile.persistence.domain.BuildProgressRecord;
import com.gx.soft.mobile.persistence.domain.BuilddgPadDay;
import com.gx.soft.mobile.persistence.domain.GxOaMobileFunction;
import com.gx.soft.mobile.persistence.manager.BuildProgressManager;
import com.gx.soft.mobile.persistence.manager.BuilddgPadDayManager;
import com.gx.soft.mobile.persistence.manager.GxOaMobileFunctionManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.TotalPriceVo;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceResultManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 建筑物施工进度
 * 
 * @author SONG
 * @date 2019-5-17
 */
@Controller
@RequestMapping("mobile-build")
@SessionAttributes(value={"user_session"})
public class MobileBuildController {
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(MobileBuildController.class);
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private VAttManager vAttManager;
	@Autowired
	private BuilddgPadDayManager builddgPadDayManager;
	@Autowired
	private BuildProgressManager buildProgressManager;
	@Autowired
	private SxpzRecordManager sxpzRecordManager;


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "progress", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult progress(String userId,String bdId,@RequestParam Map<String, Object> paramMap,@ModelAttribute Page page) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-build-progress------->获取施工进度");
		String statusCode = "1";// 成功
		String message = "获取列表成功";
		page.addOrder("ext1", "desc");

		List<BuildProgressRecord> buildProgressRecordsRecord = null;

		if(bdId==null || bdId=="") {
			if (user != null) {
				if (user.getComBdId() != null) {
					paramMap.put("filter_EQS_bdId", user.getComBdId());
					List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(paramMap);
					page = buildProgressManager.pagedQuery(page, propertyFilters);
				}
			}
		}else {
			paramMap.put("filter_EQS_bdId", bdId);
			List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(paramMap);
			page = buildProgressManager.pagedQuery(page, propertyFilters);
		}



		return new JsonResult(statusCode, page.getResult(), message);
	}

	@RequestMapping(value = "total-price", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult getTotalPrice(String userId,String bdId,@ModelAttribute Page page) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		String statusCode = "1";// 成功
		String message = "获取列表成功";
		TotalPriceVo totalPriceVo=new TotalPriceVo();


		if(bdId==null || bdId=="") {
			if (user != null) {
				if (user.getComBdId() != null) {
					String hql="SELECT sum(htPrice) from BuildProgressRecord where bdId=? ";

					List<String>countList=buildProgressManager.find(hql,user.getComBdId());
					totalPriceVo.setBdName((String) (sxpzRecordManager.find("SELECT sxpzName from SxpzRecord where sxpzBdId=?",user.getComBdId())).get(0));
					totalPriceVo.setDanwei("亿元");
					totalPriceVo.setTotalPrice(countList.get(0));
				}
			}
		}else {
			String hql="SELECT sum(htPrice) from BuildProgressRecord where bdId=? ";
			List<String>countList=buildProgressManager.find(hql,bdId);
			totalPriceVo.setBdName((String) (sxpzRecordManager.find("SELECT sxpzName from SxpzRecord where sxpzBdId=?",bdId)).get(0));
			totalPriceVo.setDanwei("亿元");
			totalPriceVo.setTotalPrice(countList.get(0));
		}



		return new JsonResult(statusCode, totalPriceVo, message);
	}

	/**
	 * 获取每日危险警示牌
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "dgpad", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult dgpad(String userId,String bdId,@RequestParam Map<String, Object> parameterMap) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-build-dgpad------->获取每日危险警示牌");
		String statusCode = "1";// 成功
		String message = "获取列表成功";
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<BuilddgPadDay> BuilddgPadDayRc = null;
		if(bdId==null || bdId=="") {
			if (user != null) {
				if (user.getComBdId() != null) {
					BuilddgPadDayRc = builddgPadDayManager.findBy("bdId", user.getComBdId());
				} else {
					BuilddgPadDayRc = builddgPadDayManager.find(propertyFilters);
				}
			}
		}else {
			BuilddgPadDayRc = builddgPadDayManager.findBy("bdId", bdId);
		}

		return new JsonResult(statusCode, BuilddgPadDayRc, message);
	}
}
