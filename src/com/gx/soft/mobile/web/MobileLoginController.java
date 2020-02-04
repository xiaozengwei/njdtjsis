package com.gx.soft.mobile.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gx.soft.sys.persistence.manager.VUserManager;

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
@RequestMapping("mobile-login")
public class MobileLoginController {
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(MobileLoginController.class);
	@Autowired
	private VUserManager vUserManager;
	@Autowired
	private SysUserManager sysUserManager;

	/**
	 * 获取登录信息
	 * 
	 * @param userId
	 * @param pwd
	 * @param appkey
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Map<String, Object> validateUserLogin(String userId, String pwd, String appkey,String versionCode,String clientId , HttpServletRequest request) {
		logger.info("mobile------->validateUserLogin 手机端验证登录");
		HttpSession session = request.getSession(true);
		String statusCode = "-1";// 登录失败
		String message = "登录失败";
		Map<String, Object> resMap = new HashMap<String, Object>();

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<VUser> gxusers =null;
		parameterMap.put("filter_EQS_userId", userId);
		parameterMap.put("filter_EQS_userPassword", pwd);// 暂时不验证密码
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		if(userId!=null&&pwd!=null){
			GxSysUser u=sysUserManager.findUniqueBy("userId",userId);
			u.setClientId(clientId);
			sysUserManager.save(u);
			gxusers =vUserManager.find(propertyFilters);
			statusCode = "200";
			message = "登录成功";
			if (gxusers.isEmpty()) {
				statusCode = "300";
				message = "登录失败";
			}else{
				session.setAttribute("user_session", gxusers.get(0));
			}
		}
		resMap.put("statusCode", statusCode);
		resMap.put("user", gxusers);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 修改密码
	 *
	 */
	@RequestMapping(value = "changepwd", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Map<String, Object> changepwd(String userId,String pass_sure, String pass_new,String pass_old) {
		GxSysUser user = sysUserManager.findUniqueBy("userId",userId);
		logger.info("mobile------->changepwd 手机端修改密码");
		String statusCode = "200";
		String message = "操作成功";
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			if(pass_old.equals(user.getUserEnName())) {
				if (pass_new.equals(pass_sure)) {
					user.setUserEnName(pass_new);
					sysUserManager.save(user);
				} else {
					message = "输入密码不一致";
					statusCode = "300";
				}
			}else {
				message="旧密码输入有误";
				statusCode="300";
			}
		} catch (NullPointerException e){
			statusCode = "300";
			message = "不允许为空";
			e.printStackTrace();
		} catch (Exception e){
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}
	@RequestMapping(value = "remove-clientId", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Map<String, Object> removeClinet(String userId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200";
		String message = "操作成功";
		GxSysUser sysUser=null;
		sysUser=sysUserManager.findUniqueBy("userId",userId);
		if(sysUser!=null) {
			sysUser.setClientId(null);
			sysUserManager.save(sysUser);
		}else{
			statusCode="100";
			message="操作失败";
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		return resMap;
	}
}
