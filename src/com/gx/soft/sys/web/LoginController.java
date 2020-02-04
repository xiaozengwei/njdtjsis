package com.gx.soft.sys.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.SysFunctionManager;
import com.gx.soft.sys.persistence.manager.SysUserManager;

;

/**
 * 登录方法控制器
 * 
 * @author optimus
 * @version 1.0
 */
@Controller
@RequestMapping("login")
@SessionAttributes("user_session")
// Session 注解
public class LoginController {
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	@Autowired
	private SysUserManager sysUserManager;
    @Autowired
	private VUserManager vUserManager;
	@Resource(name = "sysFunctionManager")
	private SysFunctionManager sysFunctionManager;

	/**
	 * 前往登录页面跳转方法
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("go-login")
	public String goLogin(Model model) {

		return "login/login";
	}

	/**
	 * 登录验证
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("init-login")
	public String login(@RequestParam Map<String, Object> parameterMap,
			Model model) {
		String url = "";
		// List<PropertyFilter> propertyFilters =
		// PropertyFilter.buildFromMap(parameterMap);
		List<VUser> userList = vUserManager.findBy("userId",
				parameterMap.get("userId"));
		if (userList.size() > 0) {
			url = "redirect:/home/go-home.do";
//			url = "redirect:/portal/template.do";
			VUser user = userList.get(0);
			model.addAttribute("user_session", user);
		} else {
			url = "redirect:/login/go-login.do";
		}

		return url;
	}

	/**
	 * 登出
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("out-login")
	public String loginOut(@RequestParam Map<String, Object> parameterMap,
			HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(true);
		session.removeAttribute("user_session");
		String url = "redirect:/login/go-login.do";

		return url;
	}

	/**
	 * 跳转修改密码页面
	 * 
	 * @param parameterMap
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("to-changepwd")
	public String toChangePwdPage(
			@RequestParam Map<String, Object> parameterMap,
			HttpServletRequest req, Model model) {

		return "sys/user/user-changepwd";
	}

	/**
	 * 保存密码
	 * 
	 * @param pass_sure
	 * @param pass_new
	 * @param pass_old
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("changepwd-save")
	public @ResponseBody
	Map<String, Object> changePwd(String pass_sure, String pass_new,
			@RequestParam(defaultValue="####")String pass_old, @ModelAttribute("user_session") VUser user,
			Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		try {
			if(pass_old.equals(user.getUserPassword())){
				if(pass_new.equals(pass_sure)){
					user.setUserPassword(pass_new);
					sysUserManager.save(user);
				}else{
					message="输入密码不一致";
					statusCode="300";
				}
			}else{
				message="旧密码输入有误";
				statusCode="300";
			}
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
	/**
	 * 原密码的校验
	 * @param pass_old
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("validate-pwd")
	public @ResponseBody
	Map<String, Object> validatePwd(@RequestParam(defaultValue="####")
			String pass_old, @ModelAttribute("user_session") VUser user,
			Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "ok", message = "输入正确";
		try {
			if(!pass_old.equals(user.getUserPassword())){
				message="旧密码输入有误";
				statusCode="error";
			}
		} catch (Exception e) {
			statusCode = "error";
			message = "系统异常，请刷新系统后重试";
			e.printStackTrace();
		}

		resMap.put(statusCode, message);

		return resMap;
	}
	@RequestMapping(value = "form-validate", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Map<String, Object> validateUserLogin(String username, String pwd) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("filter_EQS_userId", username);
		parameterMap.put("filter_EQS_userEnName", pwd);// 暂时不验证密码
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);

		List<GxSysUser> gxusers = sysUserManager.find(propertyFilters);
		String statusCode = "200";
		if (gxusers.size() < 1) {
			statusCode = "300";
		}
		resMap.put("statusCode", statusCode);
		return resMap;
	}

}
