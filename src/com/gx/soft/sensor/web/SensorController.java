package com.gx.soft.sensor.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.restservice.persistence.manager.CuringTemperatureManager;
import com.gx.soft.sensor.persistence.domain.SensorDataRecordHistory;
import com.gx.soft.sensor.persistence.domain.SensorIndex;
import com.gx.soft.sensor.persistence.manager.SensorDataRecordHistoryManager;
import com.gx.soft.sensor.persistence.manager.SensorDataRecordReltimeManager;
import com.gx.soft.sensor.persistence.manager.SensorIndexManager;
import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sensor")
@SessionAttributes("user_session")
public class SensorController {
	private BeanMapper beanMapper = new BeanMapper();
	@Autowired
	private CuringTemperatureManager  curingTemperatureManager;

	@Autowired
	private SensorIndexManager sensorIndexManager;

	@Autowired
	private SensorDataRecordReltimeManager sensorDataRecordReltimeManager;

	@Autowired
	private SensorDataRecordHistoryManager sensorDataRecordHistoryManager;
	@Autowired
	private SxpzRecordManager sxpzRecordManager;


	/**
	 * 传感器参数查询页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("search-list")
	public String search_list(Page page, String orderField, String orderDirection,
			@RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user) {
		parameterMap.put("filter_EQS_sensorSiteId",user.getComBdId());
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page.addOrder("orderNum", "desc");
		page = sensorDataRecordHistoryManager.pagedQuery(page, propertyFilters);

		model.addAttribute("page", page);
		model.addAttribute("orderField", orderField);
		model.addAttribute("orderDirection", orderDirection);

		return "sensor/search-list";

	}
	@RequestMapping("sensor-input")
	public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		SensorDataRecordHistory sensorDataRecordHistory;
		if (rowId != null) {
			sensorDataRecordHistory = sensorDataRecordHistoryManager.get(rowId);
		} else {
			sensorDataRecordHistory = new SensorDataRecordHistory();
		}
		model.addAttribute("sensorDataRecordHistory", sensorDataRecordHistory);
		return "sensor/sensor-input";
	}


	@RequestMapping("lookup-sensor-list")
	public String orgLookupList(@ModelAttribute Page page,
								@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = sensorIndexManager.pagedQuery(page, propertyFilters);
		List<SensorIndex> sensorIndex = (List<SensorIndex>) page.getResult();
		page.setResult(sensorIndex);
		model.addAttribute("page", page);
		return "sensor/sensor-list-lookup";
	}
	@RequestMapping("lookup-sensor-list-type")
	public String lookupTypeList(@ModelAttribute Page page,
								@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = sensorIndexManager.pagedQuery(page, propertyFilters);
		List<SensorIndex> sensorIndex = (List<SensorIndex>) page.getResult();
		page.setResult(sensorIndex);
		model.addAttribute("page", page);
		return "sensor/sensor-list-type-lookup";
	}

	@RequestMapping(value = "sensor-save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> save(SensorDataRecordHistory sensorDataRecordHistory,@RequestParam("bdId")String bdId,@RequestParam("bdName")String bdName) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			SensorDataRecordHistory dest ;
			String id = sensorDataRecordHistory.getRowId();
			if (id != null && id.length() > 0) {
				dest = sensorDataRecordHistoryManager.get(id);
				dest.setSensorSiteBdId(bdId);
				dest.setSensorSiteBd(bdName);
				String hql="from SxpzRecord  where sxpzId=?";
				List<SxpzRecord>sxpz=sxpzRecordManager.find(hql,sensorDataRecordHistory.getSensorSiteId());
				SxpzRecord  sxpzRecord=sxpz.get(0);
				sxpzRecord.setH1(sensorDataRecordHistory.getSensorDataTemperature());
				sxpzRecord.setH4(sensorDataRecordHistory.getSensorDataHumidity());
				sxpzRecord.setH2(sensorDataRecordHistory.getSensorDataPm25());
				sxpzRecord.setH3(sensorDataRecordHistory.getSensorDataPm10());
				sxpzRecord.setV6(sensorDataRecordHistory.getSensorDataWindSpeed());
				sxpzRecord.setV7(sensorDataRecordHistory.getSensorDataWindDirection());
				sxpzRecord.setV5(sensorDataRecordHistory.getSensorDataExt1());
				sxpzRecord.setB1(sensorDataRecordHistory.getSensorDataExt2());
				sxpzRecord.setB2(sensorDataRecordHistory.getSensorDataExt3());

				sxpzRecordManager.save(sxpzRecord);
				beanMapper.copy(sensorDataRecordHistory, dest);
			} else {
				String hql="SELECT max(orderNum) from SensorDataRecordHistory";
				List<Long> orderNum = sensorDataRecordHistoryManager.find(hql);

				sensorDataRecordHistory.setRowId(null);
				dest = sensorDataRecordHistory;
				if(orderNum.size()!=0) {
					dest.setOrderNum((long)(orderNum.get(0) + 1));
				}else {
					dest.setOrderNum((long)1);
				}
				dest.setCreateTime(ts);
				dest.setSensorSiteBdId(bdId);
				dest.setSensorSiteBd(bdName);
			}
			sensorDataRecordHistoryManager.save(dest);
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
						sensorDataRecordHistoryManager.removeById(rowId);
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
	@RequestMapping("sensor-look")
	public String edit(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		SensorDataRecordHistory sensorDataRecordHistory;
		sensorDataRecordHistory = sensorDataRecordHistoryManager.get(rowId);
		model.addAttribute("sensorDataRecordHistory", sensorDataRecordHistory);
		return "sensor/sensor-look";
	}

}
