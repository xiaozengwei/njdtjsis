package com.gx.soft.mobile.web;

import com.gx.core.page.Page;
import com.gx.soft.mobile.persistence.domain.GxOaMobilePublish;
import com.gx.soft.mobile.persistence.manager.GxOaMobilePublishManager;
import com.gx.soft.mobile.persistence.vo.CheckUpdateVo;
import com.gx.soft.mobile.persistence.vo.GxOaMobilePublishVo;
import com.gx.soft.mobile.persistence.vo.JsonResult;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 手机端登录控制器
 * 
 * @author optimus
 * @date 2019-4-20
 */
@Controller
@RequestMapping("mobile-version")
public class MobileVersionController {
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(MobileVersionController.class);
	@Autowired
	private GxOaMobilePublishManager gxOaMobilePublishManager;
	@Autowired
	private FileRecordManager fileRecordManager;
	/**
	 * 获取版本信息
	 *
	 * @return
	 */
	@RequestMapping(value = "check", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult checkVersion() {
		logger.info("mobile-version------->check 检查最新版本信息");
		String statusCode = "1";// 获取成功
		String message = "获取成功";
		GxOaMobilePublish mobilePublish = null;
		GxOaMobilePublishVo mobilePublishVo = null;
		try {
			mobilePublish = gxOaMobilePublishManager
					.findUnique("FROM GxOaMobilePublish  ");
			mobilePublishVo = new GxOaMobilePublishVo(
					mobilePublish.getAppName(), mobilePublish.getAppEnName(),
					mobilePublish.getAppVer(), mobilePublish.getAppShowVer(),
					mobilePublish.getPublishDate(),
					mobilePublish.getPublishUser());
		} catch (Exception e) {
			statusCode = "-1";// 获取失败
			message = "获取失败";
			logger.error("mobile-version------->check 出错了");
			e.printStackTrace();
		}

		return new JsonResult(statusCode, mobilePublish, message);
	}
	@RequestMapping(value = "checkUpadte", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JsonResult checkUpadte(@ModelAttribute Page page, @RequestParam Map<String, Object> paramMap) {
		CheckUpdateVo checkUpdateVo=new CheckUpdateVo();
		String statuseCode="1";
		String message="成功";
		if(gxOaMobilePublishManager.getAll().size()>0) {
			String url=gxOaMobilePublishManager.getAll().get(0).getAttachId();
			checkUpdateVo.setAppName(gxOaMobilePublishManager.getAll().get(0).getAppName());
			checkUpdateVo.setAppVer(gxOaMobilePublishManager.getAll().get(0).getAppVer());
			if(gxOaMobilePublishManager.getAll().get(0).getUpdtaeContent()!=null) {
				checkUpdateVo.setUpdateContent(gxOaMobilePublishManager.getAll().get(0).getUpdtaeContent());
			}
			if (gxOaMobilePublishManager.getAll().get(0).getStatus().equals("apk")) {
				checkUpdateVo.setStatusl("apk");
				checkUpdateVo.setApkUrl(url);
			} else {
				checkUpdateVo.setStatusl("wgt");
				checkUpdateVo.setWgtUrl(url);
			}
		}else{
			statuseCode="0";
			message="失败";
		}

		return new JsonResult(statuseCode, checkUpdateVo, message);
	}

//	@RequestMapping(value = "checkUpadte", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody
//	JsonResult checkUpadte(String appName, String appVer, @ModelAttribute Page page, @RequestParam Map<String, Object> paramMap) {
//		logger.info("mobile-version------->check 检查最新版本信息");
//		CheckUpdateVo checkUpdateVo=new CheckUpdateVo();
//		String statusCode = "1";// 获取成功
//		String message = "获取成功";
//		GxOaMobilePublish mobilePublish = null;
//		String hql="from GxOaMobilePublish where appName=? and appVer=(SELECT max(appVer) from GxOaMobilePublish)";
//		List<GxOaMobilePublish>gxOaMobilePublishList=gxOaMobilePublishManager.find(hql,appName);
//		try {
//			mobilePublish=gxOaMobilePublishList.get(0);
//			if(mobilePublish.getAppName().equals(appName.trim())){
//				String address=fileRecordManager.get(mobilePublish.getAttachId()).getFilePath();
//				if(mobilePublish.getStatus().equals("apk")){
//					checkUpdateVo.setApkUrl(address);
//				}else{
//					checkUpdateVo.setWgtUrl(address);
//				}
//				if(Integer.valueOf(mobilePublish.getAppVer())>Integer.valueOf(appVer)){
//					checkUpdateVo.setUpdate(true);
//				}
//			}
//
//		} catch (Exception e) {
//			statusCode = "-1";// 获取失败
//			message = "获取失败";
//			logger.error("mobile-version------->check 出错了");
//			e.printStackTrace();
//		}
//
//		return new JsonResult(statusCode, checkUpdateVo, message);
//	}



}
