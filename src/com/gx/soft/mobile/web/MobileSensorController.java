package com.gx.soft.mobile.web;


import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.manager.EquipmentInfoManager;
import com.gx.soft.sensor.persistence.domain.SensorDataRecordHistory;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("mobile-sensor")
public class MobileSensorController {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(MobileSensorController.class);

	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private EquipmentInfoManager equipmentInfoManager;

	/**
	 * 获取传感器历史信息列表
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "sensor-history-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult sbList(String userId) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-sensor------->sensor-history-list 获取传感器历史信息列表");
		String statusCode = "1";// 成功
		String message = "信息获取成功";

		String hql = "from SensorDataRecordHistory";
		List<SensorDataRecordHistory> sList = null;
		try {
			sList = equipmentInfoManager.find(hql);
		} catch (Exception ex) {
			statusCode = "-1";
			message = "获取传感器历史信息列表数据失败";
			logger.error("mobile-sensor------->sensor-history-list  出错了");
			ex.printStackTrace();
		}

		return new JsonResult(statusCode, sList, message);
	}



}
