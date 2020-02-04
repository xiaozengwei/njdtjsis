package com.gx.soft.home.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.mobile.persistence.domain.ByProjectIntroduction;
import com.gx.soft.mobile.persistence.manager.ByProIntroManager;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.mobile.persistence.vo.JsonResult1;
import com.gx.soft.monitor.persistence.domain.YcMonitor;
import com.gx.soft.monitor.persistence.manager.YcMonitorManager;
import com.gx.soft.restservice.persistence.domain.CuringTemperature;
import com.gx.soft.restservice.persistence.manager.CuringTemperatureManager;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceResultManager;
import com.gx.soft.restservice.persistence.manager.VUserInOrgAttManager;
import com.gx.soft.sb.persistence.manager.EquipmentInfoManager;
import com.gx.soft.sensor.persistence.manager.SensorDataRecordHistoryManager;
import com.gx.soft.sensor.persistence.manager.SensorDataRecordReltimeManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.wl.persistence.domain.MaterialCount;
import com.gx.soft.wl.persistence.domain.MaterialInfo;
import com.gx.soft.wl.persistence.manager.MaterialCountManager;
import com.gx.soft.wl.persistence.manager.MaterialInfoManager;
import com.sun.jmx.snmp.Timestamp;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("hc")
@SessionAttributes("user_session")
public class HController {

	@Autowired
	private SxpzRecordManager sxpzRecordManager;
	@Autowired
	private ByProIntroManager byProIntroManager;
	@Autowired
	private CuringTemperatureManager curingTemperatureManager;

	@Autowired
	private SensorDataRecordReltimeManager sensorDataRecordReltimeManager;

	@Autowired
	private SensorDataRecordHistoryManager sensorDataRecordHistoryManager;
	@Autowired
	private GxSysAttendanceResultManager gxSysAttendanceResultManager;
	@Autowired
	private YcMonitorManager ycMonitorManager;
	@Autowired
	private VUserInOrgAttManager vUserInOrgAttManager;
	@Autowired
	private MaterialCountManager materialCountManager;
	@Autowired
	private EquipmentInfoManager equipmentInfoManager;

	@Autowired
	private MaterialInfoManager materialInfoManager;
	/**
	 * 首页查询界面
	 *
	 * @param model
	 * @return
	 */

	@RequestMapping("layout")
	public String layout(@ModelAttribute("user_session") VUser user, Model model,@RequestParam Map<String, Object> parameterMap) {

		String statusCode = "1";// 成功
		String message = "获取菜单列表成功";
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<SxpzRecord> sxpzRecord = null;
		if(user.getComBdId()!=null){
			sxpzRecord = sxpzRecordManager.findBy("sxpzBdId",user.getComBdId());
		}else{
			sxpzRecord = sxpzRecordManager.find(propertyFilters);
		}
		String hql5="select distinct materialType from MaterialInfo";
		List<String>materialTypeList=materialInfoManager.find(hql5);
		for(SxpzRecord sr:sxpzRecord) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(date);
			String st = time + " 00:00:00";
			String end = time + " 23:59:59";
			paramMap.put("filter_GED_signTime", st);
			paramMap.put("filter_LED_signTime", end);
			paramMap.put("filter_EQS_signType", "0");
			paramMap.put("filter_LIKES_bdId", sr.getSxpzId());
			List<PropertyFilter> propertyFilterList = PropertyFilter.buildFromMap(paramMap);
			int count = vUserInOrgAttManager.find(propertyFilterList).size();
			sr.setV1(String.valueOf(count));

			Map<String, Object> paramMap1 = new HashMap<String, Object>();
			paramMap1.put("filter_GED_enterTime", st);
			paramMap1.put("filter_LED_enterTime", end);
			paramMap1.put("filter_LIKES_bdId", sr.getSxpzId());
			List<PropertyFilter> propertyFilterList1 = PropertyFilter.buildFromMap(paramMap1);
			int jcsbCount=equipmentInfoManager.find(propertyFilterList1).size();
			sr.setV2(String.valueOf(jcsbCount));

			Map<String, Object> paramMap2 = new HashMap<String, Object>();
			paramMap2.put("filter_GED_enterTime", st);
			paramMap2.put("filter_LED_enterTime", end);
			paramMap2.put("filter_LIKES_bdId", sr.getSxpzId());
			List<PropertyFilter> propertyFilterList2 = PropertyFilter.buildFromMap(paramMap2);
			int jcwlCount=0;
			List<MaterialInfo>materialInfoList=materialInfoManager.find(propertyFilterList2);
			for(MaterialInfo m:materialInfoList){
				if(!m.getMaterialType().equals("防水材料")) {
					jcwlCount += m.getEnterNumber();
				}
			}
			sr.setV3(String.valueOf(jcwlCount));


			String hql3="from MaterialCount where createTime=(select max(createTime) from  MaterialCount where bdId=? and materialType=? and createTime in (select createTime from MaterialCount where createTime>? and createTime<?))";

			int drsywlCount=0;
			for(String m:materialTypeList) {
				if(!m.equals("防水材料")) {
					List<MaterialCount> materialCountList = materialCountManager.find(hql3, sr.getSxpzBdId(), m,java.sql.Timestamp.valueOf(st), java.sql.Timestamp.valueOf(end));
					if (materialCountList.size() > 0) {
						drsywlCount += materialCountList.get(0).getMaterialCount();
					}
				}
			}
			sr.setV4(String.valueOf(drsywlCount));
			String hql="from YcMonitor where time in(select max(time) from YcMonitor group by bdId)";
			ArrayList<YcMonitor> ycMonitorList= (ArrayList<YcMonitor>) ycMonitorManager.find(hql);
			HashSet h =new HashSet(ycMonitorList);
			ycMonitorList.clear();
			ycMonitorList.addAll(h);
//			YcMonitor ycMonitor=ycMonitorList.get(0);
			for(YcMonitor ycMonitor1:ycMonitorList){
				if(ycMonitor1.getBdId().equals(sr.getSxpzBdId())) {
					sr.setH3(ycMonitor1.getPm25());
					sr.setH4(ycMonitor1.getPm10());
					sr.setV5(ycMonitor1.getDb());
					sr.setH1(ycMonitor1.getTemperature());
					sr.setH2(ycMonitor1.getHumidity());
					sr.setV6(ycMonitor1.getSpeed());
					sr.setV7(ycMonitor1.getWind());
				}
			}
			String hql1 = "from CuringTemperature where time in(select max(time) from CuringTemperature group by bdId)";
			ArrayList<CuringTemperature> curingTemperatureList = (ArrayList<CuringTemperature>) curingTemperatureManager.find(hql1);
			HashSet hashSet = new HashSet(curingTemperatureList);
			curingTemperatureList.clear();
			curingTemperatureList.addAll(hashSet);
//			CuringTemperature curingTemperature = curingTemperatureList.get(0);
			for(CuringTemperature curingTemperature:curingTemperatureList){
				if(curingTemperature.getBdId().equals(sr.getSxpzBdId())){
					sr.setB1(curingTemperature.getTemperature());
					sr.setB2(curingTemperature.getHumidity());
				}
			}

		}
		List<ByProjectIntroduction>byProjectIntro=byProIntroManager.getAll();
		model.addAttribute("sxpzRecord", sxpzRecord);
		model.addAttribute("byProjectIntro", byProjectIntro.get(0));
		return "home/index_layout";
	}


//	@RequestMapping("echarts")
//	public @ResponseBody
//	JsonResult1 pieEcharts(@ModelAttribute("user_session")VUser user,@RequestParam("val")String val){
//
//		Map<String, Object> feature = new HashMap<String, Object>();
//		Map<String, Object> mark = new HashMap<String, Object>();
//		mark.put("show", true);
//		Map<String, Object> dataView = new HashMap<String, Object>();
//		dataView.put("show", true);
//		dataView.put("readOnly", false);
//		Map<String, Object> magicType = new HashMap<String, Object>();
//		magicType.put("show", true);
//		List<String> type = new ArrayList<>();
//		type.add("pie");
//		type.add("funnel");
//		magicType.put("type", type);
//		Map<String, Object> option = new HashMap<String, Object>();
//		Map<String, Object> funnel = new HashMap<String, Object>();
//		funnel.put("x","25%");
//		funnel.put("width", "55%");
//		funnel.put("funnelAlign","left");
//		funnel.put("max", 1548);
//		option.put("funnel", funnel);
//		Map<String, Object> restore = new HashMap<String, Object>();
//		restore.put("show", true);
//		Map<String, Object> saveAsImage = new HashMap<String, Object>();
//
//		//致贫原因list
//		List<String> causeList = new ArrayList<String>();
//		List<String> causeListKey = new ArrayList<String>();
//
//		causeListKey.add("ywc");
//		causeListKey.add("wwc");
////		causeListKey.add("key-car");
////		causeListKey.add("key-meeting");
////		causeListKey.add("key-doc-print");
////		causeListKey.add("key-asset-buy");
//
//
//		//初始化致贫原因List
//		List<Object> YeCountList = new ArrayList<Object>();
//
//		/* 致贫原因统计 */
//		for (String key : causeListKey) {
//			Map<String,Object> s = new HashMap<String,Object>();
////			String hql = "select count(*) from VTaskHistory f where f.businessKey='"+key+"' and userId = '"+user.getUimsid()+"'";
////			int count = vTaskHistoryManager.getCount(hql);
//
//			if(key.equals("ywc")){
//				s.put("value", val);
//				s.put("name", "已完成");
//			}else if(key.equals("wwc")) {
//				s.put("name", "未完成");
//				s.put("value", (100-Integer.valueOf(val)));
//			}
//			YeCountList.add(s);
//		}
//		//初始化JSON对象拼装
//		Map<String, Object> tooltip = new HashMap<String, Object>();
//		Map<String, Object> legend = new HashMap<String, Object>();
//		Map<String, Object> toolbox = new HashMap<String, Object>();
//
//		List<Object> series = new ArrayList<Object>();
//		List<Object> center = new ArrayList<Object>();
//
//		tooltip.put("trigger", "item");
//		tooltip.put("formatter", "{a} <br/>{b} : {c} ({d}%)");
//		legend.put("orient", "vertical");
//		legend.put("x", "left");
//		legend.put("data", causeList);
//		toolbox.put("show", false);
//		toolbox.put("feature", feature);
//		Map<String, Object> series1 = new HashMap<String, Object>();
//		series1.put("name", "已办");
//		series1.put("type", "pie");
////完成环形图
//		ArrayList<String>radius=new ArrayList<>();
//		radius.add("50%");
//		radius.add("70%");
//		series1.put("radius",radius.toArray());
//		Map<String,Object> normal1 = new HashMap<>();
//		Map<Object,Object> normal2 = new HashMap<>();
//		normal2.put("length",5);
//		// normal2.put("length2","5");
//		normal2.put("show",true);
//		normal1.put("normal",normal2);
//		series1.put("labelLine",normal1);
//
//
//		Map<String,Map> normal = new HashMap<>();
//		Map<String,Object> label = new HashMap<>();
//		Map<String,Object> labelLine  = new HashMap<>();
//
//		Map<String,Object> emphasis  = new HashMap<>();
//		emphasis.put("show",true);
////		emphasis.put("shadowBlur",10);
////		emphasis.put("shadowOffsetX",0);
//
//		labelLine.put("show",true);
//		label.put("formatter","{b}({d}%)");
//		// label.put("show",true);
//		label.put("length",50);
//		label.put("show",true);
//
//		normal.put("label",label);
//		normal.put("labelLine ",labelLine);
//
//		Map<String,Object>  map = new HashMap<>();
//		map.put("normal",normal);
//		map.put("emphasis",emphasis);
//		series1.put("itemStyle", map);//文字后显示%
//
//		center.add("50%");
//		center.add("50%");
//		series1.put("center", center);
//		series1.put("data", YeCountList);
//		series.add(series1);
//		JsonResult1 js = new JsonResult1(tooltip, legend, toolbox,series);
////		System.out.println(JSON.toJSONString(js));
//		return js ;
//
//	}
//@RequestMapping("echarts")
//public @ResponseBody
//JsonResult1 pieEcharts(@ModelAttribute("user_session")VUser user,@RequestParam("val")String val){
//
//	Map<String, Object> feature = new HashMap<String, Object>();
//	Map<String, Object> mark = new HashMap<String, Object>();
//	mark.put("show", true);
//	Map<String, Object> dataView = new HashMap<String, Object>();
//	dataView.put("show", true);
//	dataView.put("readOnly", false);
//	Map<String, Object> magicType = new HashMap<String, Object>();
//	magicType.put("show", true);
//	List<String> type = new ArrayList<>();
//	type.add("pie");
//	type.add("funnel");
//	magicType.put("type", type);
//
//	Map<String, Object> option = new HashMap<String, Object>();
//	Map<String, Object> funnel = new HashMap<String, Object>();
//	funnel.put("x","25%");
//	funnel.put("width", "55%");
//	funnel.put("funnelAlign","left");
//	funnel.put("max", 1548);
//	option.put("funnel", funnel);
//	Map<String, Object> restore = new HashMap<String, Object>();
//	restore.put("show", true);
//	Map<String, Object> saveAsImage = new HashMap<String, Object>();
//
//	List<String> causeList = new ArrayList<String>();
//	List<String> causeListKey = new ArrayList<String>();
//
//	causeListKey.add("ywc");
//	causeListKey.add("wwc");
//
//
//
//	List<Object> YeCountList = new ArrayList<Object>();
//
//	for (String key : causeListKey) {
//		Map<String,Object> s = new HashMap<String,Object>();
//		if(key.equals("ywc")){
//			s.put("value", val);
//			s.put("name", "已完成");
//		}else if(key.equals("wwc")) {
//			s.put("name", "未完成");
//			s.put("value", (100-Integer.valueOf(val)));
//		}
//		YeCountList.add(s);
//	}
//	//初始化JSON对象拼装
//	Map<String, Object> tooltip = new HashMap<String, Object>();
//	Map<String, Object> legend = new HashMap<String, Object>();
//	Map<String, Object> toolbox = new HashMap<String, Object>();
//
//	List<Object> series = new ArrayList<Object>();
//	List<Object> center = new ArrayList<Object>();
//
//	tooltip.put("trigger", "item");
//	tooltip.put("formatter", "{a} <br/>{b} : {c} ({d}%)");
//	legend.put("orient", "vertical");
//	legend.put("x", "left");
//	legend.put("data", causeList);
////	toolbox.put("show", false);
////	toolbox.put("feature", feature);
//	Map<String, Object> series1 = new HashMap<String, Object>();
////	series1.put("name", "已办");
//	series1.put("type", "pie");
////完成环形图
//	ArrayList<String>radius=new ArrayList<>();
//	radius.add("50%");
//	radius.add("70%");
//	series1.put("radius",radius.toArray());
////	Map<String,Object> normal1 = new HashMap<>();
////	Map<Object,Object> normal2 = new HashMap<>();
////	normal2.put("length",5);
////	// normal2.put("length2","5");
////	normal2.put("show",true);
////	normal1.put("normal",normal2);
////	series1.put("labelLine",normal1);
//
//
//
//
//	Map<String,Object> label = new HashMap<>();
//	Map<String,Object> normal3 = new HashMap<>();
//	Map<String,Object> emphasis  = new HashMap<>();
//	Map<String,Object> textStyle  = new HashMap<>();
//	textStyle.put("fontSize","30");
//	textStyle.put("fontWeight","bold");
//	emphasis.put("textStyle",textStyle);
//	emphasis.put("show",true);
//	normal3.put("show",false);
//	normal3.put("position",center);
//	label.put("emphasis",emphasis);
//	label.put("normal",normal3);
//
//	series1.put("avoidLabelOverlap",false);
//	series1.put("label",label);
//
//
//	center.add("50%");
//	center.add("50%");
//	series1.put("center", center);
//	series1.put("data", YeCountList);
//	series.add(series1);
//	JsonResult1 js = new JsonResult1(tooltip, legend, toolbox,series);
////		System.out.println(JSON.toJSONString(js));
//	return js ;
//
//}

}
