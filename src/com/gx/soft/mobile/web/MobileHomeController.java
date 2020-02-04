package com.gx.soft.mobile.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.soft.attendance.persistence.manager.VAttManager;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.mobile.persistence.domain.ByProjectIntroduction;
import com.gx.soft.mobile.persistence.domain.GxOaMobileFunction;
import com.gx.soft.mobile.persistence.manager.ByProIntroManager;
import com.gx.soft.mobile.persistence.manager.GxOaMobileFunctionManager;
import com.gx.soft.mobile.persistence.vo.HomeIndexVo;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.monitor.persistence.domain.YcMonitor;
import com.gx.soft.monitor.persistence.manager.YcMonitorManager;
import com.gx.soft.restservice.persistence.domain.CuringTemperature;
import com.gx.soft.restservice.persistence.domain.VUserInOrgAtt;
import com.gx.soft.restservice.persistence.manager.CuringTemperatureManager;
import com.gx.soft.restservice.persistence.manager.GxSysAttendanceResultManager;
import com.gx.soft.restservice.persistence.manager.VUserInOrgAttManager;
import com.gx.soft.sb.persistence.manager.EquipmentInfoManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.view.persistence.domain.DeviceCameraRecord;
import com.gx.soft.view.persistence.manager.DeviceCameraRecordManager;
import com.gx.soft.wl.persistence.domain.MaterialCount;
import com.gx.soft.wl.persistence.domain.MaterialInfo;
import com.gx.soft.wl.persistence.manager.MaterialCountManager;
import com.gx.soft.wl.persistence.manager.MaterialInfoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 手机端角色相关（角色人员，角色菜单）
 * 
 * @author YING
 * @date 2019-1-5
 */
@Controller
@RequestMapping("mobile-home")
@SessionAttributes(value={"user_session"})
public class MobileHomeController {
	// 日志
	@Autowired
	private CuringTemperatureManager curingTemperatureManager;
	private static Logger logger = LoggerFactory
			.getLogger(MobileHomeController.class);
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private VAttManager vAttManager;
	@Autowired
	private GxSysAttendanceResultManager gxSysAttendanceResultManager;
	@Autowired
	private ByProIntroManager byProIntroManager;
	@Resource
	private GxOaMobileFunctionManager gxOaMobileFunctionManager;

	@Autowired
	private SxpzRecordManager sxpzRecordManager;
	@Autowired
	private YcMonitorManager ycMonitorManager;
	@Autowired
	private VUserInOrgAttManager vUserInOrgAttManager;
	@Autowired
	private DeviceCameraRecordManager deviceCameraRecordManager;
	@Autowired
	private MaterialCountManager materialCountManager;
	@Autowired
	private MaterialInfoManager materialInfoManager;
	@Autowired
	private EquipmentInfoManager equipmentInfoManager;

	/**
	 * 获取菜单列表-全部
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "home", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult functionList(String userId) {
		VUser user = vUserManager.findUniqueBy("userId", userId);
		logger.info("mobile-role------->function-list 获取全部菜单列表");
		String statusCode = "1";// 成功
		String message = "获取菜单列表成功";
		List<GxOaMobileFunction> functionList = null;
		if(user!=null) {
			if (!(userId.equals("admin") || userId.equals("gong_hx"))) {
				String hql = "from GxOaMobileFunction f where  f.functionId in(select rhf.functionId from GxOaMobileRoleHasFunction rhf where rhf.roleId in(select uhr.id.roleId from GxOaMobileRoleHasUser uhr where uhr.id.userId=?)) order by f.orderNum";
				try {
					functionList = gxOaMobileFunctionManager.find(hql, user.getUserId());
				} catch (Exception ex) {
					statusCode = "-1";
					message = "获取菜单列表失败";
					logger.error("mobile-role------->function-list 出错了");
					ex.printStackTrace();
				}

				return new JsonResult(statusCode, functionList, message);
			} else {
				String hql1 = "from GxOaMobileFunction f where  f.functionId in(select rhf.functionId from GxOaMobileRoleHasFunction rhf where rhf.roleId in(select uhr.id.roleId from GxOaMobileRoleHasUser uhr where uhr.id.userId=?)) order by f.orderNum";
				functionList = gxOaMobileFunctionManager.find(hql1, user.getUserId());
				for(int i=0;i<functionList.size();i++){
					if(!(functionList.get(i).getFunctionId().equals("0008") || functionList.get(i).getFunctionId().equals("0019"))) {
						functionList.get(i).setFunctionUrl("menuCommonList");
					}
				}
				return new JsonResult(statusCode, functionList, message);
			}
		}
		statusCode = "-1";
		message = "获取菜单列表失败";
		return new JsonResult(statusCode, functionList, message);
	}



	/**
	 * 获取菜单列表-常用
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "home-cy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult functionListCy(String userId) {
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-role------->function-list 获取常用菜单列表");
		String statusCode = "1";// 成功
		String message = "获取菜单列表成功";

		String hql = "from GxOaMobileFunction f where  f.functionId in(select rhf.functionId from GxOaMobileRoleHasFunction rhf where rhf.roleId in(select uhr.id.roleId from GxOaMobileRoleHasUser uhr where uhr.id.userId=?)) and f.functionType='2' order by f.orderNum asc";
		List<GxOaMobileFunction> functionList = null;
		if(user!=null) {
			if(!(userId.equals("admin")|| userId.equals("gong_hx"))) {
				try {
					functionList = gxOaMobileFunctionManager.find(hql, user.getUserId());
				} catch (Exception ex) {
					statusCode = "-1";
					message = "获取菜单列表失败";
					logger.error("mobile-role------->function-list 出错了");
					ex.printStackTrace();
				}
				return new JsonResult(statusCode, functionList, message);
			}else{
				functionList = gxOaMobileFunctionManager.find(hql, user.getUserId());
				for(int i=0;i<functionList.size();i++){
					if(!(functionList.get(i).getFunctionId().equals("0008") || functionList.get(i).getFunctionId().equals("0019"))) {
						functionList.get(i).setFunctionUrl("menuCommonList");
					}
				}
				return new JsonResult(statusCode, functionList, message);
			}
		}
		statusCode = "-1";
		message = "获取菜单列表失败";
		return new JsonResult(statusCode, functionList, message);
	}
	/**
	 * 获取菜单列表-主页
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "home-index", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult homeindex(String userId,@RequestParam Map<String, Object> parameterMap) throws ParseException {
		ArrayList<HomeIndexVo>homeIndexVoList=new ArrayList<>();
//		int i=0;
		VUser user = vUserManager.findUniqueBy("userId",userId);
		logger.info("mobile-role------->function-list 获取liebiao");
		String statusCode = "1";// 成功
		String message = "获取菜单列表成功";
		String hql5="select distinct materialType from MaterialInfo";
		List<String>materialTypeList=materialInfoManager.find(hql5);
		ArrayList<DeviceCameraRecord >deviceCameraRecordList=new ArrayList<>();
		ArrayList<String >urlList=new ArrayList<>();
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<SxpzRecord> sxpzRecord = null;
		if(user.getComBdId()!=null){
			sxpzRecord = sxpzRecordManager.findBy("sxpzBdId",user.getComBdId());
		}else{
			sxpzRecord = sxpzRecordManager.find(propertyFilters);
		}
		for(SxpzRecord sr:sxpzRecord){
			HomeIndexVo homeIndexVo=new HomeIndexVo();
			Map<String,Object> paramMap=new HashMap<String,Object>();
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(date);
			String st=time+" 00:00:00";
			String end=time+" 23:59:59";
			paramMap.put("filter_GED_signTime",st);
			paramMap.put("filter_LED_signTime",end);
			paramMap.put("filter_EQS_signType","0");
			paramMap.put("filter_LIKES_bdId", sr.getSxpzId());
			String hql2="from DeviceCameraRecord where bdId=?";
			deviceCameraRecordList= (ArrayList<DeviceCameraRecord>) deviceCameraRecordManager.find(hql2,sr.getSxpzId());
			if(deviceCameraRecordList.size()>0){
				homeIndexVo.setH5(deviceCameraRecordList);
			}
			List<PropertyFilter> propertyFilterList=PropertyFilter.buildFromMap(paramMap);
			int count = vUserInOrgAttManager.find(propertyFilterList).size();
			homeIndexVo.setV1(String.valueOf(count));
			Map<String, Object> paramMap1 = new HashMap<String, Object>();
			paramMap1.put("filter_GED_enterTime", st);
			paramMap1.put("filter_LED_enterTime", end);
			paramMap1.put("filter_LIKES_bdId", sr.getSxpzId());
			List<PropertyFilter> propertyFilterList1 = PropertyFilter.buildFromMap(paramMap1);
			int jcsbCount=equipmentInfoManager.find(propertyFilterList1).size();
			homeIndexVo.setV2(String.valueOf(jcsbCount));

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
			homeIndexVo.setV3(String.valueOf(jcwlCount));


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
			homeIndexVo.setV4(String.valueOf(drsywlCount));
			String hql="from YcMonitor where time in(select max(time) from YcMonitor group by bdId)";
			ArrayList<YcMonitor> ycMonitorList= (ArrayList<YcMonitor>) ycMonitorManager.find(hql);
			HashSet h =new HashSet(ycMonitorList);
			ycMonitorList.clear();
			ycMonitorList.addAll(h);
			for(YcMonitor ycMonitor1:ycMonitorList) {
				if (ycMonitor1.getBdId().equals(sr.getSxpzBdId())) {
					homeIndexVo.setH3(ycMonitor1.getPm25());
					homeIndexVo.setH4(ycMonitor1.getPm10());
					homeIndexVo.setV5(ycMonitor1.getDb());
					homeIndexVo.setH1(ycMonitor1.getTemperature());
					homeIndexVo.setH2(ycMonitor1.getHumidity());
					homeIndexVo.setV6(ycMonitor1.getSpeed());
					homeIndexVo.setV7(ycMonitor1.getWind());
				}
			}
			String hql1="from CuringTemperature where time in(select max(time) from CuringTemperature group by bdId)";
			ArrayList<CuringTemperature>curingTemperatureList= (ArrayList<CuringTemperature>) curingTemperatureManager.find(hql1);
//			CuringTemperature curingTemperature=curingTemperatureList.get(0);
			HashSet hashSet =new HashSet(curingTemperatureList);
			curingTemperatureList.clear();
			curingTemperatureList.addAll(hashSet);
			for(CuringTemperature  curingTemperature:curingTemperatureList){
				if(curingTemperature.getBdId().equals(sr.getSxpzBdId())){
					homeIndexVo.setB1(curingTemperature.getTemperature());
					homeIndexVo.setB2(curingTemperature.getHumidity());
				}
			}
			homeIndexVo.setBdIntro(sr.getBdIntro());
			homeIndexVo.setRowId(sr.getRowId());
			homeIndexVo.setSxpzId(sr.getSxpzId());
			homeIndexVo.setSxpzName(sr.getSxpzName());
			homeIndexVo.setSxpzComId(sr.getSxpzComId());
			homeIndexVo.setSxpzBdId(sr.getSxpzBdId());
			homeIndexVo.setSxpzComName(sr.getSxpzComName());
			homeIndexVo.setSxpzStatus(sr.getSxpzStatus());
			homeIndexVo.setSxpzOrder(sr.getSxpzOrder());
			homeIndexVo.setCreateTime(sr.getCreateTime());
			homeIndexVo.setUpdateTime(sr.getUpdateTime());

			List<VUserInOrgAtt> list=vUserInOrgAttManager.find("select doorControlName from VUserInOrgAtt where bdId=? and signTime=? group by doorControlName",sr.getSxpzId(),new Date());
			if(list.size()>=1){
				homeIndexVo.setDoorControl("y");
			}else {
				homeIndexVo.setDoorControl("n");
			}
			homeIndexVoList.add(homeIndexVo);
		}
		return new JsonResult(statusCode, homeIndexVoList, message);
	}

	@RequestMapping(value = "home-index-admin", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult homeindexAdmin(@RequestParam Map<String, Object> parameterMap, @ModelAttribute Page page) {
//		logger.info("mobile-role------->function-list 获取liebiao");
		String statusCode = "1";// 成功
		String message = "获取北延工程总概括成功";
//		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
//		page = deviceCameraRecordManager.pagedQuery(page,propertyFilterList);
		List<ByProjectIntroduction> byProjectIntroduction = byProIntroManager.getAll();
		if(byProjectIntroduction.size()<0){
			statusCode="0";
			message="获取北延工程总概括失败";
		}

		return new JsonResult(statusCode, byProjectIntroduction, message);
	}
}
