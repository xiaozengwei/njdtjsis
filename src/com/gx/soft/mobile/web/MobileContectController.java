package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手机端登录控制器
 * 
 * @author optimus
 * @date 2019-4-20
 */
@Controller
@RequestMapping("mobile-contect")
public class MobileContectController {
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(MobileContectController.class);
	@Autowired
	private VUserManager vUserManager;


	/**
	 * 通讯录
	 * 
	 * @param userId
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult list(String userId) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile------->contect list 手机端通讯录");
		String statusCode = "1";// 成功
		String message = "获取列表成功";
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		if(!user.getComOrgId().equals("01")){
			parameterMap.put("filter_EQS_comBdId", user.getComBdId());
			if(parameterMap.get("userName")!=null){
				parameterMap.put("filter_EQS_userName", parameterMap.get("userName"));
			}
			if(parameterMap.get("dutName")!=null){
				parameterMap.put("filter_EQS_userType", parameterMap.get("dutName"));
			}
		}
		List<VUser> gxusers =null;
		try {

			List<PropertyFilter> propertyFilters = PropertyFilter
					.buildFromMap(parameterMap);
				gxusers =vUserManager.find(propertyFilters);
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取列表失败";
			logger.error("mobile-contect------->flist 出错了");
			ex.printStackTrace();
		}

		return new JsonResult(statusCode, gxusers, message);
	}


}
