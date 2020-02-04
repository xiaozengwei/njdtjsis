package com.gx.soft.sys.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.QrCodeCreateUtil;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.vo.ZtreeData;
import com.gx.soft.vis.persistence.domain.GxViewColumn;
import com.gx.soft.vis.persistence.domain.VColumnArticleL;
import com.gx.soft.vis.persistence.manager.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.manager.SysFunctionManager;

/**
 * 进入主页方法
 * 
 * @author optimus
 * @version 1.0
 */
@Controller
@RequestMapping("home")
@SessionAttributes("user_session")
// Session 注解
public class HomeController {
	private static Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	SysFunctionManager sysFunctionManager;

	@Autowired
	private VViewColumnArticleManager vViewColumnArticleManager;
	@Autowired
	private GxViewColumnManager gxViewColumnManager;

	/**
	 * 前往首页页面跳转方法
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("go-home")
	public String goHome(@RequestParam(required = false) Long funId,
						 @ModelAttribute("user_session") VUser user, Model model) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String path = "C:/qrCode/"+sdf.format(new Date())+"/"+"main.jpg";
		File file = new File(path);
		String content = "http://221.6.30.202:9076/njdtjsis/home/go-dtmain.do";
		if (file.exists()) {
			System.out.println("file exists");
		} else {
			QrCodeCreateUtil.encode(content, path);
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String hql = "from GxSysFunction f where  f.rowId in(select rhf.functionId from GxSysRoleHasFunction rhf where rhf.roleId in(select uhr.roleId from GxSysRoleHasUser uhr where uhr.userId=?)) order by f.dataOrder";
		List<GxSysFunction> functionList = sysFunctionManager.find(hql,
				user.getUserId());
		if(funId!= null ){
			GxSysFunction defaultFun = sysFunctionManager.get(funId);
			model.addAttribute("defaultFun", defaultFun);
		}
		model.addAttribute("functionList", functionList);
		model.addAttribute("userName", user.getUserName());
		return "home/home_index";
	}
	/**
	 * 前往地铁网站主页面
	 * @return
	 */
	@RequestMapping("go-dtmain")
	public String goDtMain() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String path = "C:/qrCode/"+sdf.format(new Date())+"/"+"main.jpg";
		File file = new File(path);
		String content = "http://221.6.30.202:9076/njdtjsis/home/go-dtmain.do";
		if (file.exists()) {
			System.out.println("file exists");
		} else {
			QrCodeCreateUtil.encode(content, path);
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "vis/main/dtmainheader";
	}


}
