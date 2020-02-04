package com.gx.soft.sys.web;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.mobile.persistence.domain.GxOaMobileRoleHasUser;
import com.gx.soft.mobile.persistence.domain.GxOaMobileRoleHasUserId;
import com.gx.soft.mobile.persistence.domain.GxSysOrgCopy;
import com.gx.soft.mobile.persistence.domain.VUserCopy;
import com.gx.soft.mobile.persistence.manager.GxOaMobileRoleHasUserManager;
import com.gx.soft.mobile.persistence.manager.GxSysOrgCopyManager;
import com.gx.soft.mobile.persistence.manager.VUserCopyManager;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.*;
import com.gx.soft.sys.persistence.manager.*;
import com.gx.soft.vis.persistence.domain.AttachEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("sysuser")
@SessionAttributes("user_session")
public class GxSysUserController {
	private GxSysOrgManager gxSysOrgManager;
	private VUserManager vUserManager;
	private SysUserManager gxUserManager;
	private GxSysUserInOrgManager gxSysUserInOrgManger;
	private BeanMapper beanMapper = new BeanMapper();
	private ArrayList<String> rowIdList=new ArrayList<>();
	@Autowired
	FileRecordManager fileRecordManager;
	@Autowired
	private VUserTzManager  vUserTzManager;
	@Autowired
	private GxSysOrgTzManager gxSysOrgTzManager;
	@Autowired
	private GxSysUserInOrgTzManager gxSysUserInOrgTzManager;
	@Autowired
	private SysUserManager sysUserManager;
	@Autowired
	private SxpzRecordManager sxpzRecordManager;
	@Autowired
	private GxOaMobileRoleHasUserManager gxOaMobileRoleHasUserManager;
	/**
	 * 前往用户列表页面
	 * 
	 *  page
	 *  parameterMap
	 *  model
	 * @return
	 */
	@RequestMapping("user-list")
	public String list(@ModelAttribute Page page, String orgId,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		parameterMap.put("filter_EQS_orgId", orgId);
		page.addOrder("dataOrder", "asc");
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = vUserManager.pagedQuery(page, propertyFilters);
		List<VUser> userList = (List<VUser>) page.getResult();

		page.setResult(userList);
		model.addAttribute("page", page);
		model.addAttribute("orgId", orgId);

		return "sys/user/user-list";
	}

	/**
	 * 前往用户列表页面Copy
	 *
	 *  page
	 *  parameterMap
	 *  model
	 * @return
	 */
	@RequestMapping("user-list1")
	public String list1(@ModelAttribute Page page, String orgId,
					   @RequestParam Map<String, Object> parameterMap, Model model) {
		parameterMap.put("filter_EQS_orgId", orgId);
		page.addOrder("dataOrder", "asc");
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = vUserCopyManager.pagedQuery(page, propertyFilters);
		List<VUserCopy> userList = (List<VUserCopy>) page.getResult();

		page.setResult(userList);
		model.addAttribute("page", page);
		model.addAttribute("orgId", orgId);

		return "sys/user/user-list1";

	}
	@RequestMapping("user-tz-list")
	public String userTzList(@ModelAttribute Page page, String bdId,
						@RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session")VUser user) {
		if(user.getComBdId()==null) {
			parameterMap.put("filter_EQS_bdId", bdId);
			page.addOrder("createTime", "desc");
			List<PropertyFilter> propertyFilters = PropertyFilter
					.buildFromMap(parameterMap);
			page = sysUserManager.pagedQuery(page, propertyFilters);
			List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
			page.setResult(userList);
		}else if(user.getComBdId().equals(bdId)){
			parameterMap.put("filter_EQS_bdId", bdId);
			page.addOrder("createTime", "desc");
			List<PropertyFilter> propertyFilters = PropertyFilter
					.buildFromMap(parameterMap);
			page = sysUserManager.pagedQuery(page, propertyFilters);
			List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
			page.setResult(userList);
		}
		model.addAttribute("page", page);
		model.addAttribute("bdId", bdId);
		model.addAttribute("orgId", "123");
		return "sys/tz/user-list";

	}

	/**
	 * 前往用户的添加/修改页面
	 *
	 * @param
	 *  model
	 * @return
	 */
	@RequestMapping("user-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/user/user-input";
	}

	/**
	 * 前往用户的添加/修改页面Copy
	 *
	 *
	 *  model
	 * @return
	 */
	@RequestMapping("user-input1")
	public String input1(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/user/user-input1";
	}
	@RequestMapping("user-tz-input")
	public String inputTz(
			@RequestParam(value = "rowId", required = false) String rowId,
			String bdId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
			String hql="from FileRecord where relationId=?";
			ArrayList<FileRecord>fileRecordList= (ArrayList<FileRecord>) fileRecordManager.find(hql,rowId);
			model.addAttribute("fileRecordList", fileRecordList);
		} else {
			gxSysUser = new GxSysUser();
		}
		String hql="from SxpzRecord where sxpzBdId=?";
		SxpzRecord sxpzRecord=null;
		if(bdId!=null) {
			 sxpzRecord = sxpzRecordManager.findUnique(hql, bdId);
		}else{
			 sxpzRecord = sxpzRecordManager.findUnique(hql, gxSysUser.getBdId());
		}
		model.addAttribute("sxpzRecord", sxpzRecord);
		model.addAttribute("model", gxSysUser);
		return "sys/tz/user-input-tz";
	}
	@RequestMapping("user-tz-look")
	public String lookTz(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
			String hql="from FileRecord where relationId=?";
			ArrayList<FileRecord>fileRecordList= (ArrayList<FileRecord>) fileRecordManager.find(hql,rowId);
			model.addAttribute("fileRecordList", fileRecordList);
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/tz/user-look-tz";
	}
	/**
	 * 用户的保存/更新
	 * 
	 *  gxsysUser
	 * @return
	 */
	@RequestMapping(value = "user-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(GxSysUser gxsysUser, String orgId,
			HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		VUser gxuser = (VUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {
			if(!orgId.equals("")){
				if(gxUserManager.findUniqueBy("userId",gxsysUser.getUserId())!=null){
					throw new Exception("登录名已存在");
				}
			}

			GxSysUser dest = null;
			String id = gxsysUser.getRowId();
			String opt = "save";
			String oldUserId = "";
			if (id != null && id.length() > 0) {
				dest = gxUserManager.get(id);
				oldUserId = dest.getUserId();
				if(!oldUserId.equals(gxsysUser.getUserId())){
					if(gxUserManager.findUniqueBy("userId",gxsysUser.getUserId())!=null){
						throw new Exception("登录名已存在");
					}
				}
				if (dest != null) {
					beanMapper.copy(gxsysUser, dest);
					dest.setModifyTime(ts);
					opt = "update";
				}
			} else {
				dest = gxsysUser;
				dest.setRowId(null);
				dest.setCreateTime(ts);

			}
			gxUserManager.save(dest);
			if (opt.equals("save")) {// 保存操作：保存用户和组织机构关系
				GxSysUserInOrg gxSysUserInOrg = new GxSysUserInOrg();
				gxSysUserInOrg.setCreateTime(ts);
				gxSysUserInOrg.setCreateUserId(gxuser != null ? gxuser
						.getUserId() : "");
				gxSysUserInOrg.setOrgId(orgId);
				gxSysUserInOrg.setUserId(dest.getUserId());
				gxSysUserInOrg.setDataOrder(dest.getDataOrder());

				String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrg t where t.orgId=?";
				List maxNum = gxSysUserInOrgManger.find(hql, orgId);
				int num = 1;
				if (maxNum.size() < 1) {
					num = 1;
				} else {
					Object obj = maxNum.get(0);
					num = !StringUtils.validateLong(obj) ? 1 : new BigDecimal(
							obj.toString()).intValue() + 1;

				}
				gxSysUserInOrg.setDataOrder(num);
				gxSysUserInOrgManger.save(gxSysUserInOrg);
				dest.setDataOrder(num);
				gxUserManager.save(dest);
			} else {// 更新操作
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("filter_EQS_orgId", orgId);
				parameterMap.put("filter_EQS_userId", oldUserId);
				List<PropertyFilter> propertyFilters = PropertyFilter
						.buildFromMap(parameterMap);
				List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
						.find(propertyFilters);
				GxSysUserInOrg uio = userInOrgList != null
						&& userInOrgList.size() > 0 ? userInOrgList.get(0)
						: null;
				if (uio != null) {
					uio.setDataOrder(dest.getDataOrder());// 更新排序状态
					uio.setUserId(dest.getUserId());// 更新userId
					gxSysUserInOrgManger.save(uio);
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			message+="——"+e.getMessage();
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list");

		return resMap;

	}

	/**
	 * 用户的保存/更新Copy
	 *
	 *  gxsysUser
	 * @return
	 */
	@RequestMapping(value = "user-save1", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save1(GxSysUser gxsysUser, String orgId,
							 HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		VUser gxuser = (VUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {
			GxSysUser user=gxUserManager.findUniqueBy("userId",gxsysUser.getUserId());

			if(!orgId.equals("")){
				VUserCopy vUserCopy = vUserCopyManager.findUniqueBy("userId",gxsysUser.getUserId());
				if(vUserCopy!=null){
					throw new Exception("登录名已存在:<br/>"+vUserCopy.getpOrgName()+"--"+vUserCopy.getOrgName());
				}
				if(user!=null){
					throw new Exception("登录名已存在");
				}
				if(!gxsysUser.getUserCardId().equals("")&&gxUserManager.findUniqueBy("userCardId",gxsysUser.getUserCardId())!=null){
					GxSysUser user1=gxUserManager.findUniqueBy("userCardId",gxsysUser.getUserCardId());
					VUserCopy vUserCopy1=vUserCopyManager.findUniqueBy("userCardId",gxsysUser.getUserCardId());
					String pOrgName="";
					String orgName="";
					if(vUserCopy1!=null){
						pOrgName=vUserCopy1.getpOrgName()+"--";
						orgName=vUserCopy1.getOrgName();
					}
					throw new Exception("身份证已存在,"+user1.getUserName()+":"+user1.getUserId()+"</br>"+pOrgName+orgName);
				}
			}
			GxSysUser dest = null;
			String id = gxsysUser.getRowId();
			String opt = "save";
			String oldUserId = "";
			if (id != null && id.length() > 0) {
				dest = gxUserManager.get(id);
				oldUserId = dest.getUserId();
				if(!oldUserId.equals(gxsysUser.getUserId())){
					if(user!=null){
						throw new Exception("登录名已存在");
					}
				}
				if (dest != null) {
					beanMapper.copy(gxsysUser, dest);
					dest.setModifyTime(ts);
					opt = "update";
				}
			} else {
				dest = gxsysUser;
				dest.setRowId(null);
				dest.setCreateTime(ts);

			}
			dest.setCardNo(null);
			dest.setCreateUserId(gxuser.getUserId());
			gxUserManager.save(dest);
			GxSysRoleHasUser roleUser = new GxSysRoleHasUser();
			roleUser.setRowId(null);
			roleUser.setUserId(gxsysUser.getUserId());
			roleUser.setRoleId("basic-role");
			roleUser.setRlType("0");
			roleUser.setCreateTime(ts);
			gxRoleHasUserManager.save(roleUser);
			GxOaMobileRoleHasUser roleHasUser=new GxOaMobileRoleHasUser(new GxOaMobileRoleHasUserId(gxsysUser.getUserId(),"8a8080cb4f4537e5014f5d6b76ba00262"));
			roleHasUser.setCreateTime(ts);
			gxOaMobileRoleHasUserManager.save(roleHasUser);
			if (opt.equals("save")) {// 保存操作：保存用户和组织机构关系
				GxSysUserInOrgCopy gxSysUserInOrgCopy = new GxSysUserInOrgCopy();
				gxSysUserInOrgCopy.setCreateTime(ts);
				gxSysUserInOrgCopy.setCreateUserId(gxuser != null ? gxuser
						.getUserId() : "");
				gxSysUserInOrgCopy.setOrgId(orgId);
				gxSysUserInOrgCopy.setUserId(dest.getUserId());
				gxSysUserInOrgCopy.setDataOrder(dest.getDataOrder());

				String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrgCopy t where t.orgId=?";
				List maxNum = gxSysUserInOrgCopyManager.find(hql, orgId);
				int num = 1;
				if (maxNum.get(0)==null) {
					num=Integer.parseInt(orgDataOrderDefaultManager.findUniqueBy("orgId",orgId).getDataOrder());
				} else {
					Object obj = maxNum.get(0);
					num = !StringUtils.validateLong(obj) ? 1 : new BigDecimal(
							obj.toString()).intValue() + 1;

				}
				gxSysUserInOrgCopy.setDataOrder(num);
				gxSysUserInOrgCopyManager.save(gxSysUserInOrgCopy);
				dest.setDataOrder(num);
				dest.setCardNo(null);
				gxUserManager.save(dest);
//-------------------------------------------------------------------------------------
				String hql1 = "SELECT max(t.dataOrder) FROM  GxSysUserInOrg t where t.orgId=?";
				List maxNum1 = gxSysUserInOrgCopyManager.find(hql, orgId);
				int num1 = 1;
				if(maxNum1!=null){
					Object obj1 = maxNum1.get(0);
					num1 = !StringUtils.validateLong(obj1) ? 1 : new BigDecimal(
							obj1.toString()).intValue() + 1;
				}
				GxSysUserInOrg gxSysUserInOrg = new GxSysUserInOrg();
				gxSysUserInOrg.setCreateTime(ts);
				gxSysUserInOrg.setCreateUserId(gxuser != null ? gxuser
						.getUserId() : "");
				gxSysUserInOrg.setUserId(dest.getUserId());
				gxSysUserInOrg.setDataOrder(num1);
				if(orgId.equals("0101")){
					gxSysUserInOrg.setOrgId("010120");
				}else{
					gxSysUserInOrg.setOrgId(orgId.substring(0,6)+"20");
				}
				gxSysUserInOrgManger.save(gxSysUserInOrg);

			} else {// 更新操作
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("filter_EQS_orgId", orgId);
				parameterMap.put("filter_EQS_userId", oldUserId);
				List<PropertyFilter> propertyFilters = PropertyFilter
						.buildFromMap(parameterMap);
				List<GxSysUserInOrgCopy> userInOrgList = gxSysUserInOrgCopyManager
						.find(propertyFilters);
				GxSysUserInOrgCopy uio = userInOrgList != null
						&& userInOrgList.size() > 0 ? userInOrgList.get(0)
						: null;
				if (uio != null) {
					uio.setUserId(dest.getUserId());// 更新userId
					gxSysUserInOrgCopyManager.save(uio);
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			message+="——"+e.getMessage();

		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list1");
		return resMap;
	}
	@RequestMapping(value = "user-save-tz", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> saveTz(GxSysUser gxsysUser,String tz,String sxpzBdId,String sxpzName,
							  HttpSession session) {
		Timestamp ts = DateUtil.getDate();
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode="200";
		String message="操作成功";
		String rowId=gxsysUser.getRowId();
		GxSysUser user=sysUserManager.get(rowId);
		if(user.getBdId()==null){
			user.setCreateTime(ts);
		}
		if(user!=null) {
			user.setBdId(sxpzBdId);
			user.setBdName(sxpzName);
		}else {
			statusCode="300";
			message="操作失败";
		}
		sysUserManager.save(user);
		if(rowId!=null) {
			for (int i = 0; i < rowIdList.size(); i++) {
				FileRecord fileRecord = fileRecordManager.get(rowIdList.get(i));
				fileRecord.setRelationId(rowId);
				fileRecordManager.save(fileRecord);
				System.out.println("123");
			}
			rowIdList.clear();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-tz-list");
		return resMap;
	}
	/**
	 * 用户的删除
	 * 
	 *  delids
	 * @return
	 */
	@RequestMapping("user-remove")
	public @ResponseBody
	Map<String, Object> userRemove(String delids,
			@RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {
						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							gxUserManager.remove(sysUser);
						}
						String userId = sysUser.getUserId();
						// 删除组织机构-人员关联关系
						parameterMap.put("filter_EQS_userId", userId);
						parameterMap.put("filter_EQS_orgId", orgId);
						List<PropertyFilter> propertyFilters = PropertyFilter
								.buildFromMap(parameterMap);
						List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
								.find(propertyFilters);
						for (GxSysUserInOrg o : userInOrgList) {
							gxSysUserInOrgManger.remove(o);
						}
						for(GxSysUserInOrgCopy in:gxSysUserInOrgCopyManager.findBy("userId",userId)){
							gxSysUserInOrgCopyManager.remove(in);
						}



						parameterMap.clear();

					}

				}

			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list");
		return resMap;
	}

	/**
	 * 用户的删除Copy
	 *
	 *  delids
	 * @return
	 */
	@RequestMapping("user-remove1")
	public @ResponseBody
	Map<String, Object> userRemove1(String delids,
								   @RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {
						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							gxUserManager.remove(sysUser);
						}
						String userId = sysUser.getUserId();
						// 删除组织机构-人员关联关系
						parameterMap.put("filter_EQS_userId", userId);
						parameterMap.put("filter_EQS_orgId", orgId);
						List<PropertyFilter> propertyFilters = PropertyFilter
								.buildFromMap(parameterMap);
						List<GxSysUserInOrgCopy> userInOrgList = gxSysUserInOrgCopyManager
								.find(propertyFilters);
						for (GxSysUserInOrgCopy o : userInOrgList) {
							gxSysUserInOrgCopyManager.remove(o);
						}
						for(GxSysUserInOrg in:gxSysUserInOrgManger.findBy("userId",userId)){
							gxSysUserInOrgManger.remove(in);
						}
						for (GxSysRoleHasUser gxSysRoleHasUser:gxRoleHasUserManager.findBy("userId",userId)){
							gxRoleHasUserManager.remove(gxSysRoleHasUser);
						}
						gxOaMobileRoleHasUserManager.removeById(new GxOaMobileRoleHasUserId(userId,"8a8080cb4f4537e5014f5d6b76ba00262"));


						parameterMap.clear();

					}

				}

			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list1");
		return resMap;
	}
	@RequestMapping("user-remove-tz")
	public @ResponseBody
	Map<String, Object> userRemoveTz(String delids,
								   @RequestParam(defaultValue = "####") String bdId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");
				for (String rowId : ids) {

					if (rowId != null) {
						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							sysUser.setBdId(null);
							sysUser.setBdName(null);
							gxUserManager.save(sysUser);
						}
					}

				}

			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-tz-list");
		return resMap;
	}


	/**
	 * 前往人员管理总页面（左侧是组织树，右侧是人员管理）
	 * 
	 * roleId
	 *  model
	 * @return
	 */
	@RequestMapping("user-manager-page")
	public String userManagerPage(Model model) {
		return "sys/user/user-manager";
	}


	/**
	 * 前往人员管理总页面（左侧是组织树，右侧是人员管理）Copy
	 *
	 *  roleId
	 *  model
	 * @return
	 */
	@RequestMapping("user-manager-page1")
	public String userManagerPage1(Model model) {
		return "sys/user/user-manager1";
	}



	/**
	 * 多组织人员添加页面
	 * 
	 *  rowId
	 *  orgId
	 *  model
	 * @return
	 */
	@RequestMapping("user-input-orgs")
	public String orgsUserinput(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/user/add-orgs-user";
	}

	/**
	 * 多组织人员添加页面
	 *
	 *  rowId
	 *  orgId
	 *  model
	 * @return
	 */
	@RequestMapping("user-input-orgs1")
	public String orgsUserinput1(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/user/add-orgs-user1";
	}
	@RequestMapping("user-input-org-tz")
	public String orgsUserinputTz(
			@RequestParam(value = "rowId", required = false) String rowId,
			String orgId, Model model) {
		GxSysUser gxSysUser = null;
		if (rowId != null) {
			gxSysUser = gxUserManager.get(rowId);
		} else {
			gxSysUser = new GxSysUser();
		}
		model.addAttribute("orgId", orgId);
		model.addAttribute("model", gxSysUser);
		return "sys/tz/add-orgs-user-tz";
	}

	/**
	 * 多组织人员添加-保存操作
	 *
	 *  gxsysUser
	 *  orgId
	 *  session
	 * @return
	 */
	@RequestMapping(value = "orgsuser-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> orgsUserSave(String userId, String orgId,
			HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		VUser gxuser = (VUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			if (StringUtils.validateString(userId)) {
				String[] userIdArr = userId.split(",");
				for (String eUserId : userIdArr) {
					parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", eUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
							.find(propertyFilters);
					GxSysUserInOrg uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio == null) {
						String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrg t where t.orgId=?";
						List maxNum = gxSysUserInOrgManger.find(hql, orgId);
						int num = 1;
						if (maxNum.size() < 1) {
							num = 1;
						} else {
							Object obj = maxNum.get(0);
							num = !StringUtils.validateLong(obj) ? 1
									: new BigDecimal(obj.toString()).intValue() + 1;
						}

						GxSysUserInOrg gxSysUserInOrg = new GxSysUserInOrg();
						gxSysUserInOrg.setCreateTime(ts);
						gxSysUserInOrg.setCreateUserId(gxuser != null ? gxuser
								.getUserId() : "");
						gxSysUserInOrg.setOrgId(orgId);
						gxSysUserInOrg.setUserId(eUserId);
						gxSysUserInOrg.setDataOrder(num);
						gxSysUserInOrgManger.save(gxSysUserInOrg);
					}
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list");

		return resMap;

	}

	/**
	 * 多组织人员添加-保存操作
	 *
	 *  gxsysUser
	 *  orgId
	 *  session
	 * @return
	 */
	@RequestMapping(value = "orgsuser-save1", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> orgsUserSave1(String userId, String orgId,
									 HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		VUser gxuser = (VUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {

			Map<String, Object> parameterMap = new HashMap<String, Object>();
			if (StringUtils.validateString(userId)) {
				String[] userIdArr = userId.split(",");
				for(String id:userIdArr){
					VUserCopy vUserCopy = vUserCopyManager.findUniqueBy("userId",id);
					if(vUserCopy!=null){
						throw new Exception("已存在组织关系：<br/>"+vUserCopy.getpOrgName()+"--"+vUserCopy.getOrgName());
					}
				}


				for (String eUserId : userIdArr) {
					parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", eUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrgCopy> userInOrgList = gxSysUserInOrgCopyManager
							.find(propertyFilters);
					GxSysUserInOrgCopy uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio == null) {
						String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrgCopy t where t.orgId=?";
						List maxNum = gxSysUserInOrgCopyManager.find(hql, orgId);
						int num = 1;
						if (maxNum.get(0)==null) {
							num = Integer.parseInt(orgDataOrderDefaultManager.findUniqueBy("orgId",orgId).getDataOrder());
						} else {
							Object obj = maxNum.get(0);
							num = !StringUtils.validateLong(obj) ? 1
									: new BigDecimal(obj.toString()).intValue() + 1;
						}

						GxSysUserInOrgCopy gxSysUserInOrgCopy = new GxSysUserInOrgCopy();
						gxSysUserInOrgCopy.setCreateTime(ts);
						gxSysUserInOrgCopy.setCreateUserId(gxuser != null ? gxuser
								.getUserId() : "");
						gxSysUserInOrgCopy.setOrgId(orgId);
						gxSysUserInOrgCopy.setUserId(eUserId);
						gxSysUserInOrgCopy.setDataOrder(num);
						gxSysUserInOrgCopyManager.save(gxSysUserInOrgCopy);
					}
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			message+="——"+e.getMessage();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list1");

		return resMap;

	}
	@RequestMapping(value = "orgsuser-save-tz", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> orgsUserSaveTz(String userId, String orgId,
									 HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		VUser gxuser = (VUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			if (StringUtils.validateString(userId)) {
				String[] userIdArr = userId.split(",");
				for (String eUserId : userIdArr) {
					parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", eUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrgTz> userInOrgList = gxSysUserInOrgTzManager
							.find(propertyFilters);
					GxSysUserInOrgTz uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio == null) {
						String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrgTz t where t.orgId=?";
						List maxNum = gxSysUserInOrgTzManager.find(hql, orgId);
						int num = 1;
						if (maxNum.size() < 1) {
							num = 1;
						} else {
							Object obj = maxNum.get(0);
							num = !StringUtils.validateLong(obj) ? 1
									: new BigDecimal(obj.toString()).intValue() + 1;
						}

						GxSysUserInOrgTz gxSysUserInOrgTz = new GxSysUserInOrgTz();
						gxSysUserInOrgTz.setCreateTime(ts);
						gxSysUserInOrgTz.setCreateUserId(gxuser != null ? gxuser
								.getUserId() : "");
						gxSysUserInOrgTz.setOrgId(orgId);
						gxSysUserInOrgTz.setUserId(eUserId);
						gxSysUserInOrgTz.setDataOrder(num);
						gxSysUserInOrgTzManager.save(gxSysUserInOrgTz);
					}
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-tz-list");

		return resMap;

	}


	/**
	 * 解除用户和组织关系
	 * 
	 *  delids
	 *  orgId
	 * @return
	 */
	@RequestMapping("user-orgs-remove")
	public @ResponseBody
	Map<String, Object> userOrgsRemove(String delids,
			@RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {

						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							// gxUserManager.remove(sysUser);
							String userId = sysUser.getUserId();
							// 删除组织机构-人员关联关系
							parameterMap.put("filter_EQS_userId", userId);
							parameterMap.put("filter_EQS_orgId", orgId);
							List<PropertyFilter> propertyFilters = PropertyFilter
									.buildFromMap(parameterMap);
							List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
									.find(propertyFilters);
							for (GxSysUserInOrg o : userInOrgList) {
								gxSysUserInOrgManger.remove(o);
							}
							parameterMap.clear();
						}
					}
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list");
		return resMap;
	}
	/**
	 * 解除用户和组织关系
	 *
	 *delids
	 *  orgId
	 * @return
	 */
	@RequestMapping("user-orgs-remove1")
	public @ResponseBody
	Map<String, Object> userOrgsRemove1(String delids,
									   @RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {

						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							// gxUserManager.remove(sysUser);
							String userId = sysUser.getUserId();
							// 删除组织机构-人员关联关系
							parameterMap.put("filter_EQS_userId", userId);
							parameterMap.put("filter_EQS_orgId", orgId);
							List<PropertyFilter> propertyFilters = PropertyFilter
									.buildFromMap(parameterMap);
							List<GxSysUserInOrgCopy> userInOrgList = gxSysUserInOrgCopyManager
									.find(propertyFilters);
							for (GxSysUserInOrgCopy o : userInOrgList) {
								gxSysUserInOrgCopyManager.remove(o);
							}
							parameterMap.clear();
						}

					}

				}

			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list1");
		return resMap;
	}
	@RequestMapping("user-orgs-remove-tz")
	public @ResponseBody
	Map<String, Object> userOrgsRemoveTz(String delids,
									   @RequestParam(defaultValue = "####") String orgId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				String[] ids = delids.split(",");

				for (String rowId : ids) {

					if (rowId != null) {

						GxSysUser sysUser = gxUserManager.get(rowId);
						if (sysUser != null) {
							// gxUserManager.remove(sysUser);
							String userId = sysUser.getUserId();
							// 删除组织机构-人员关联关系
							parameterMap.put("filter_EQS_userId", userId);
							parameterMap.put("filter_EQS_orgId", orgId);
							List<PropertyFilter> propertyFilters = PropertyFilter
									.buildFromMap(parameterMap);
							List<GxSysUserInOrgTz> userInOrgList = gxSysUserInOrgTzManager
									.find(propertyFilters);
							for (GxSysUserInOrgTz o : userInOrgList) {
								gxSysUserInOrgTzManager.remove(o);
							}
							parameterMap.clear();
						}
					}
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-tz-list");
		return resMap;
	}


	/**
	 * 选择关联用户页面
	 * 
	 *  rowId
	 *  userName
	 *  page
	 *  parameterMap
	 *  model
	 * @return
	 */
	@RequestMapping("userlookup")
	public String userlookup(@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxUserManager.pagedQuery(page, propertyFilters);
		page.addOrder("createTime","desc");
		List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
		page.setResult(userList);
		model.addAttribute("page", page);
		return "sys/user/userlookup";
	}


	/**
	 * 选择关联用户页面
	 *
	 *  rowId
	 *  userName
	 *  page
	 *  parameterMap
	 *  model
	 * @return
	 */
	@RequestMapping("userlookup1")
	public String userlookup1(@ModelAttribute Page page,
							 @RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxUserManager.pagedQuery(page, propertyFilters);
		List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
		page.setResult(userList);
		model.addAttribute("page", page);
		return "sys/user/userlookup1";
	}

	/**
	 * 文件的排序更新
	 * 
	 *  file
	 *  fileTypeId
	 *  session
	 * @return
	 */
	@RequestMapping(value = "updateOrder/{opt}", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> updateOrder(String uioRowId, @PathVariable String opt,
			@ModelAttribute("user_session") VUser user, HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		try {
			GxSysUserInOrg srcUio = gxSysUserInOrgManger.get(uioRowId);
			String orgId = srcUio.getOrgId();
			String userId = srcUio.getUserId();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filter_EQS_orgId", orgId);
			List<PropertyFilter> propertyFilters = PropertyFilter
					.buildFromMap(params);
			List<GxSysUserInOrg> userRList = gxSysUserInOrgManger.find(
					"dataOrder", true, propertyFilters);
			int srcIndex = userRList.indexOf(srcUio);// 该元素在列表中所在的索引号
			int count = userRList.size();
			int destCount = -1;// 准备交换的元素的索引
			if (srcIndex != -1) {// 不等于-1，表示在列表中能查找到

				int addend = 0;
				if (opt.equals("up")) {
					if (srcIndex != 0) {// 如果当前已经是第一个元素，不操作；否则查找上一个元素
						destCount = srcIndex - 1;
					} else {
						destCount = srcIndex;
					}
				} else if (opt.equals("down")) {// 若是降序操作，被加数为1
					if (srcIndex != count - 1) {// 如果当前已经是最后一个元素，不操作；否则查找下个元素
						destCount = srcIndex + 1;
					} else {
						destCount = srcIndex;
					}
				}
			}
			if (destCount != -1) {
				// 查找交换的实体，交换order后保存到数据库
				if (destCount == srcIndex) {// 当前元素索引和目标索引一致，说明是同一个元素，不需要调换顺序
					statusCode = "200";
					message = "当前已经是第一个/最后一个元素";
				} else {
					GxSysUserInOrg destUio = userRList.get(destCount);
					int srcOrder = srcUio.getDataOrder();
					int destOrder = destUio.getDataOrder();
					srcUio.setDataOrder(destOrder);
					destUio.setDataOrder(srcOrder);
					// 同步更新用户表中的排序字段
					GxSysUser srcUser = gxUserManager.findUniqueBy("userId",
							srcUio.getUserId());
					if (srcUser != null) {
						srcUser.setDataOrder(srcUio.getDataOrder());
						gxUserManager.save(srcUser);
					}
					GxSysUser destUser = gxUserManager.findUniqueBy("userId",
							destUio.getRowId());
					if (destUser != null) {
						destUser.setDataOrder(destUio.getDataOrder());
						gxUserManager.save(destUser);
					}

					gxSysUserInOrgManger.save(destUio);
					gxSysUserInOrgManger.save(srcUio);
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list");
		return resMap;

	}


	/**
	 * 文件的排序更新Copy
	 *
	 *  file
	 *  fileTypeId
	 *  session
	 * @return
	 */
	@RequestMapping(value = "updateOrder1/{opt}", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> updateOrder1(String uioRowId, @PathVariable String opt,
									@ModelAttribute("user_session") VUser user, HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		try {
			GxSysUserInOrgCopy srcUio = gxSysUserInOrgCopyManager.get(uioRowId);
			String orgId = srcUio.getOrgId();
			String userId = srcUio.getUserId();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filter_EQS_orgId", orgId);
			List<PropertyFilter> propertyFilters = PropertyFilter
					.buildFromMap(params);
			List<GxSysUserInOrgCopy> userRList = gxSysUserInOrgCopyManager.find(
					"dataOrder", true, propertyFilters);
			int srcIndex = userRList.indexOf(srcUio);// 该元素在列表中所在的索引号
			int count = userRList.size();
			int destCount = -1;// 准备交换的元素的索引
			if (srcIndex != -1) {// 不等于-1，表示在列表中能查找到

				int addend = 0;
				if (opt.equals("up")) {
					if (srcIndex != 0) {// 如果当前已经是第一个元素，不操作；否则查找上一个元素
						destCount = srcIndex - 1;
					} else {
						destCount = srcIndex;
					}
				} else if (opt.equals("down")) {// 若是降序操作，被加数为1
					if (srcIndex != count - 1) {// 如果当前已经是最后一个元素，不操作；否则查找下个元素
						destCount = srcIndex + 1;
					} else {
						destCount = srcIndex;
					}
				}
			}
			if (destCount != -1) {
				// 查找交换的实体，交换order后保存到数据库
				if (destCount == srcIndex) {// 当前元素索引和目标索引一致，说明是同一个元素，不需要调换顺序
					statusCode = "200";
					message = "当前已经是第一个/最后一个元素";
				} else {
					GxSysUserInOrgCopy destUio = userRList.get(destCount);
					int srcOrder = srcUio.getDataOrder();
					int destOrder = destUio.getDataOrder();
					srcUio.setDataOrder(destOrder);
					destUio.setDataOrder(srcOrder);
					// 同步更新用户表中的排序字段
					GxSysUser srcUser = gxUserManager.findUniqueBy("userId",
							srcUio.getUserId());
					if (srcUser != null) {
						srcUser.setDataOrder(srcUio.getDataOrder());
						gxUserManager.save(srcUser);
					}
					GxSysUser destUser = gxUserManager.findUniqueBy("userId",
							destUio.getRowId());
					if (destUser != null) {
						destUser.setDataOrder(destUio.getDataOrder());
						gxUserManager.save(destUser);
					}

					gxSysUserInOrgCopyManager.save(destUio);
					gxSysUserInOrgCopyManager.save(srcUio);
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "user-manager-user-list1");
		return resMap;

	}

	/**
	 * 含有组织树总页面
	 * 
	 *  rowId用户ID
	 *  model
	 * @return
	 */
	@RequestMapping("org-page")
	public String getOrgs(
			String rowId,
			@RequestParam(defaultValue = "add", required = false) String group,
			@RequestParam(defaultValue = "", required = false) String boxId,
			@RequestParam(defaultValue = "navtab", required = false) String target,
			Model model) {
		String hql = "from GxSysOrg order by dataOrder asc";
		List<GxSysOrg> orgList = gxSysOrgManager.find(hql, new Object[] {});
		model.addAttribute("orgList", orgList);
		model.addAttribute("userId", rowId);
		model.addAttribute("target", target);
		model.addAttribute("group", group);
		model.addAttribute("boxId", boxId);
		return "sys/user/org-bring-back";
	}


	/**
	 * 含有组织树总页面Copy
	 *
	 *  rowId用户ID
	 *  model
	 * @return
	 */
	@RequestMapping("org-page1")
	public String getOrgs1(
			String rowId,
			@RequestParam(defaultValue = "add", required = false) String group,
			@RequestParam(defaultValue = "", required = false) String boxId,
			@RequestParam(defaultValue = "navtab", required = false) String target,
			@RequestParam Map<String, Object> parameterMap,
			@ModelAttribute("user_session") VUser user,
			Model model) {
		if(user.getComBdId()!=null){
			parameterMap.put("filter_EQS_orgBdId",user.getComBdId());
		}
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<GxSysOrgCopy> orgList = gxSysOrgCopyManager.find("dataOrder", true,
				propertyFilters);
		if(user.getComBdId()!=null) {
			orgList.addAll(gxSysOrgCopyManager.findBy("orgType", "0"));
			orgList.addAll(gxSysOrgCopyManager.findBy("orgType", "1"));
			List<GxSysOrgCopy> list = gxSysOrgCopyManager.findBy("parentOrgId", "0102");
			for (GxSysOrgCopy org : list) {
				String[] args = org.getOrgBdId().split(",");
				if (Arrays.asList(args).contains(user.getComBdId()) && args.length != 1) {
					orgList.add(org);
				}
			}
		}
		model.addAttribute("orgList", orgList);
		model.addAttribute("userId", rowId);
		model.addAttribute("target", target);
		model.addAttribute("group", group);
		model.addAttribute("boxId", boxId);
		return "sys/user/org-bring-back1";
	}
	@RequestMapping("org-page-tz")
	public String getOrgsTz(
			String rowId,
			@RequestParam(defaultValue = "add", required = false) String group,
			@RequestParam(defaultValue = "", required = false) String boxId,
			@RequestParam(defaultValue = "navtab", required = false) String target,
			Model model) {
		String hql = "from GxSysOrgTz order by dataOrder asc";
		List<GxSysOrgTz> orgList = gxSysOrgTzManager.find(hql, new Object[] {});
		model.addAttribute("orgList", orgList);
		model.addAttribute("userId", rowId);
		model.addAttribute("target", target);
		model.addAttribute("group", group);
		model.addAttribute("boxId", boxId);
		return "sys/tz/org-bring-back-tz";
	}
	/**
	 * 用户的保存/更新
	 * 
	 *  gxsysUser
	 * @return
	 */
	@RequestMapping(value = "user-org-update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> updateOrg(String orgId, String userId,
			HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		if (statusCode.equals("200")) {
			try {
				GxSysUser dest = null;
				String oldUserId = "";
				if (StringUtils.validateString(userId)) {
					dest = gxUserManager.get(userId);
					oldUserId = dest.getUserId();
					// 更新操作
					Map<String, Object> parameterMap = new HashMap<String, Object>();
					// parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", oldUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrg> userInOrgList = gxSysUserInOrgManger
							.find(propertyFilters);
					GxSysUserInOrg uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio != null) {
						// uio.setDataOrder(dest.getDataOrder());// 更新排序状态
						// uio.setUserId(dest.getUserId());// 更新userId
						String hql="select max(t.dataOrder) from GxSysUserInOrg t where t.orgId=?";
						List maxnum=gxSysUserInOrgManger.find(hql,"0"+orgId);
						int dataOrder;
						if(maxnum.size()<1){
							dataOrder=1;
						}else {
							Object object=maxnum.get(0);
							dataOrder=!StringUtils.validateLong(object)?1:new BigDecimal(object.toString()).intValue()+1;
						}
						uio.setOrgId("0"+orgId);
						uio.setDataOrder(dataOrder);
						uio.setCreateTime(ts);
						gxSysUserInOrgManger.save(uio);
					}
				}

			} catch (Exception e) {
				statusCode = "300";
				message = "操作失败";
				e.printStackTrace();
			}
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list");

		return resMap;

	}


	/**
	 * 用户的保存/更新Copy
	 *
	 *  gxsysUser
	 * @return
	 */
	@RequestMapping(value = "user-org-update1", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> updateOrg1(String orgId, String userId,
								  HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		if (statusCode.equals("200")) {
			try {
				GxSysUser dest = null;
				String oldUserId = "";
				if (StringUtils.validateString(userId)) {
					dest = gxUserManager.get(userId);
					oldUserId = dest.getUserId();
					// 更新操作
					Map<String, Object> parameterMap = new HashMap<String, Object>();
					// parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", oldUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrgCopy> userInOrgList = gxSysUserInOrgCopyManager
							.find(propertyFilters);
					GxSysUserInOrgCopy uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio != null) {
						// uio.setDataOrder(dest.getDataOrder());// 更新排序状态
						// uio.setUserId(dest.getUserId());// 更新userId
						String hql="select max(t.dataOrder) from GxSysUserInOrgCopy t where t.orgId=?";
						List maxnum=gxSysUserInOrgCopyManager.find(hql,"0"+orgId);
						int dataOrder;
						if(maxnum.get(0)==null){
							dataOrder=Integer.parseInt(orgDataOrderDefaultManager.findUniqueBy("orgId","0"+orgId).getDataOrder());
						}else {
							Object object=maxnum.get(0);
							dataOrder=!StringUtils.validateLong(object)?1:new BigDecimal(object.toString()).intValue()+1;
						}
						uio.setDataOrder(dataOrder);
						uio.setOrgId("0"+orgId);
						uio.setCreateTime(ts);
						gxSysUserInOrgCopyManager.save(uio);
					}
				}

			} catch (Exception e) {
				statusCode = "300";
				message = "操作失败";
				e.printStackTrace();
			}
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list1");

		return resMap;

	}
	@RequestMapping(value = "user-org-update-tz", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> updateOrgTz(String orgId, String userId,
								  HttpSession session) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();

		if (statusCode.equals("200")) {
			try {
				GxSysUser dest = null;
				String oldUserId = "";
				if (StringUtils.validateString(userId)) {
					dest = gxUserManager.get(userId);
					oldUserId = dest.getUserId();
					// 更新操作
					Map<String, Object> parameterMap = new HashMap<String, Object>();
					// parameterMap.put("filter_EQS_orgId", orgId);
					parameterMap.put("filter_EQS_userId", oldUserId);
					List<PropertyFilter> propertyFilters = PropertyFilter
							.buildFromMap(parameterMap);
					List<GxSysUserInOrgTz> userInOrgList = gxSysUserInOrgTzManager
							.find(propertyFilters);
					GxSysUserInOrgTz uio = userInOrgList != null
							&& userInOrgList.size() > 0 ? userInOrgList.get(0)
							: null;
					if (uio != null) {
						// uio.setDataOrder(dest.getDataOrder());// 更新排序状态
						// uio.setUserId(dest.getUserId());// 更新userId
						String hql="select max(t.dataOrder) from GxSysUserInOrgTz t where t.orgId=?";
						List maxnum=gxSysUserInOrgTzManager.find(hql,"0"+orgId);
						int dataOrder;
						if(maxnum.size()<1){
							dataOrder=1;
						}else {
							Object object=maxnum.get(0);
							dataOrder=!StringUtils.validateLong(object)?1:new BigDecimal(object.toString()).intValue()+1;
						}
						uio.setOrgId("0"+orgId);
						uio.setDataOrder(dataOrder);
						uio.setCreateTime(ts);
						gxSysUserInOrgTzManager.save(uio);
					}
				}

			} catch (Exception e) {
				statusCode = "300";
				message = "操作失败";
				e.printStackTrace();
			}
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-tz-list");

		return resMap;

	}
	@RequestMapping("fileupload")
	@ResponseBody
	public Map<String, Object> processUpload(@RequestParam MultipartFile file,
											 Model model, HttpSession session
	) throws IOException {
		Map<String, Object> resMap = new HashMap<String, Object>();
		VUser user=(VUser)session.getAttribute("user_session");
		resMap.put("user", user);
		model.addAttribute("message", "File '" + file.getOriginalFilename());
//        String bol="yes";
		String fileOriginalName = file.getOriginalFilename();
		String statusCode = "200", message = "上传成功";
		AttachEntity attachment = new AttachEntity();
		FileRecord fileRecord=new FileRecord();
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath("") + decodeFileName; // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\hiddenDanger\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				fileRecord.setFilePath(mFilePath);
				fileRecord.setUploadUserName(user.getUserId());
				fileRecord.setUploadUserId(user.getUserName());
				fileRecord.setFileName(fileOriginalName);
				Timestamp time = new Timestamp(System.currentTimeMillis());
				fileRecord.setUploadTime(time);
				fileRecord.setFileType(file.getContentType());
				fileRecord.setFileIdentifyName(decodeFileName);
				fileRecordManager.save(fileRecord);
				message = "请选择上传文件";
				statusCode = "300";
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "上传失败";
//            bol="no";
			e.printStackTrace();
		}
		resMap.put("AttachEntity", fileRecord);
		if(fileRecord.getRowId()!=null) {
			rowIdList.add(fileRecord.getRowId());
		}
		return resMap;
	}

	@RequestMapping("lookup-user-list")
	public String orgLookupList(@ModelAttribute Page page,
								@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = sysUserManager.pagedQuery(page, propertyFilters);
		List<GxSysUser> gxSysUserList = (List<GxSysUser>) page.getResult();
		List<GxSysUser> newGxSysUserList=new ArrayList<>();
		for(GxSysUser user:gxSysUserList){
			if(user.getBdName()==null){
				newGxSysUserList.add(user);
			}
		}
		page.setResult(newGxSysUserList);
		model.addAttribute("page", page);
		return "sys/tz/lookup-user-list";

	}

	@RequestMapping("user-import")
	public String userImports(Model model,String orgId) {
		model.addAttribute("orgId",orgId);
		return "sys/user/user-import";
	}

	@RequestMapping("import")
	@ResponseBody
	public	Map<String, Object> imports(@RequestParam MultipartFile file,Model model, HttpSession session,String i) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		VUser user=(VUser)session.getAttribute("user_session");
		resMap.put("user", user);
		model.addAttribute("message", "File '" + file.getOriginalFilename());
		System.out.println(i);
//        String bol="yes";
		String fileOriginalName = file.getOriginalFilename();
		String statusCode = "200", message = "上传成功";
		List<GxSysUser> list=new ArrayList<>();
		String type=null;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
//				FileUtil fileHelper = new FileUtil();
//				String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
//				String mFilePath = session.getServletContext().getRealPath("") + decodeFileName; // 取得服务器路径
//				mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\hiddenDanger\\" + decodeFileName;
//				fileHelper.createFile(mFilePath, file.getBytes());
// 				FileInputStream fileIn = new FileInputStream(mFilePath);
				//----------------------------------------------------------------
				Workbook wb0=null;
				if(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).equals(".xlsx")){
					wb0=new XSSFWorkbook(file.getInputStream());
					type="ByteArrayInputStream";
				}else if(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).equals(".xls")){
					wb0=new HSSFWorkbook(file.getInputStream());
					type="FileInputStream";
				}
				Sheet sheet = wb0.getSheetAt(0);
				for(Row row:sheet){
					if(row.getCell(1)==null){
						break;
					}
					GxSysUser gxSysUser=new GxSysUser();
					Cell cell0 = row.getCell(1);
					Cell cell3 = row.getCell(3);
					Cell cell4 = row.getCell(4);
					if(cell0!=null&&cell3!=null){
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						cell3.setCellType(Cell.CELL_TYPE_STRING);
						cell4.setCellType(Cell.CELL_TYPE_STRING);
					}
					GxSysUser u=sysUserManager.findUniqueBy("userId",row.getCell(1).getStringCellValue());
					GxSysUser u1=sysUserManager.findUniqueBy("userCardId",row.getCell(3).getStringCellValue());
					GxSysUser u2=sysUserManager.findUniqueBy("cardNo",row.getCell(4).getStringCellValue());
					if(u!=null||u1!=null){
						gxSysUser.setUserName(row.getCell(0).getStringCellValue());
						gxSysUser.setUserId(row.getCell(1).getStringCellValue());
						gxSysUser.setUserSex(row.getCell(2).getStringCellValue());
						gxSysUser.setUserCardId(row.getCell(3).getStringCellValue());
						gxSysUser.setCardNo(row.getCell(4)!=null?row.getCell(4).getStringCellValue():"");
						gxSysUser.setUserType(row.getCell(5)!=null?row.getCell(5).getStringCellValue():"");
						if(u!=null){
							gxSysUser.setUserId("用户名已存在");
						}
						if(u1!=null){
							gxSysUser.setUserCardId("身份证已存在");
						}
						if(u2!=null){
							gxSysUser.setCardNo("卡号已存在");
						}
						list.add(gxSysUser);
					}
				}
				if(list.size()==0){
					FileUtil fileHelper = new FileUtil();
					String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
					String mFilePath = session.getServletContext().getRealPath("") + decodeFileName; // 取得服务器路径
					mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\userinfo\\" + decodeFileName;
					fileHelper.createFile(mFilePath, file.getBytes());
					resMap.put("fileUrl",mFilePath);
					resMap.put("flog",false);
				}else {
					resMap.put("flog",true);
				}
				file.getInputStream().close();
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "上传失败";
			resMap.put("flog",true);
//            bol="no";
			e.printStackTrace();
		}
		resMap.put("list", list);
		resMap.put("type",type);
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	@RequestMapping("import-save")
	public @ResponseBody
	Map<String, Object> UserSaveImport(String fileUrl,HttpSession session,String orgId,String type) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		VUser gxuser = (VUser) (session.getAttribute("user_session") == null ? null
				: session.getAttribute("user_session"));

		Workbook wb0=null;
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			InputStream in= new FileInputStream(fileUrl);
			if(type.equals("ByteArrayInputStream")){
				wb0=new XSSFWorkbook(in);
			}else {
				wb0=new HSSFWorkbook(in);
			}

			Sheet sheet = wb0.getSheetAt(0);
			for(Row row:sheet) {
				if(row.getCell(1)==null){
					break;
				}
				GxSysUser gxSysUser=new GxSysUser();
				gxSysUser.setRowId(null);
				gxSysUser.setUserName(row.getCell(0).getStringCellValue());
				gxSysUser.setUserShowName(row.getCell(0).getStringCellValue());
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				gxSysUser.setUserId(row.getCell(1).getStringCellValue());
				gxSysUser.setUserMobileNum(row.getCell(1).getStringCellValue());
				gxSysUser.setUserEnName("123");
				gxSysUser.setUserSex(row.getCell(2).getStringCellValue().equals("男")?"1":"0");
				gxSysUser.setUserCardId(row.getCell(3).getStringCellValue());
				row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				gxSysUser.setCardNo(row.getCell(4)!=null?row.getCell(4).getStringCellValue():"");
				gxSysUser.setUserType(row.getCell(5)!=null?row.getCell(5).getStringCellValue():"");
				gxSysUser.setCreateTime(new Timestamp(new Date().getTime()));

				GxSysUserInOrgCopy gxSysUserInOrgCopy = new GxSysUserInOrgCopy();
				gxSysUserInOrgCopy.setCreateTime(new Timestamp(new Date().getTime()));
				gxSysUserInOrgCopy.setCreateUserId(gxuser != null ? gxuser
						.getUserId() : "");
				gxSysUserInOrgCopy.setOrgId(orgId);
				gxSysUserInOrgCopy.setUserId(gxSysUser.getUserId());

				String hql = "SELECT max(t.dataOrder) FROM  GxSysUserInOrgCopy t where t.orgId=?";
				List maxNum = gxSysUserInOrgCopyManager.find(hql, orgId);
				int num = 1;
				if (maxNum.get(0)==null) {
					num=Integer.parseInt(orgDataOrderDefaultManager.findUniqueBy("orgId",orgId).getDataOrder());
				} else {
					Object obj = maxNum.get(0);
					num = !StringUtils.validateLong(obj) ? 1 : new BigDecimal(
							obj.toString()).intValue() + 1;
				}
				gxSysUserInOrgCopy.setDataOrder(num);
				gxSysUserInOrgCopyManager.save(gxSysUserInOrgCopy);
				gxUserManager.save(gxSysUser);
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		resMap.put("divid", "user-manager-user-list1");

		return resMap;

	}

	@RequestMapping("test")
	public @ResponseBody Map<String, Object> test(String path) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Workbook wb0=null;

		List<VUserCopy> list=vUserCopyManager.findBy("comBdId","010301");
		List<String> list1=new ArrayList<>();
		int i=0;
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			InputStream in= new FileInputStream("C:\\Users\\Admin\\Desktop\\"+path);
//			wb0=new XSSFWorkbook(in);
			wb0=new HSSFWorkbook(in);
			Sheet sheet = wb0.getSheetAt(0);

			for(Row row:sheet) {
				boolean flog=false;
				i++;
				if (i==1){
					continue;
				}
				if(row.getCell(0)==null){
					break;
				}
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//				VUserCopy user=vUserCopyManager.findUniqueBy("userName",row.getCell(0).getStringCellValue());

//				if (user==null){
//					resMap.put(row.getCell(0).getStringCellValue(),row.getCell(0).getStringCellValue());
//				}

				for(VUserCopy v:list){
					if(v.getUserName().equals(row.getCell(0).getStringCellValue())){
//						list1.add(v.getUserName());
						flog=true;
						break;
					}
				}
				if(!flog){
					resMap.put(row.getCell(0).getStringCellValue(),row.getCell(0).getStringCellValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		for(VUserCopy l:list){
//			boolean f=true;
//			for(String str:list1){
//				if(str.equals(l.getUserName())){
//					f=false;
//				}
//			}
//			if(!f){
//				resMap.put(l.getUserName(),l.getUserName());
//			}
//		}
		resMap.put("1",i);
		return resMap;
	}

	@Resource
	public void setGxSysOrgManager(GxSysOrgManager gxSysOrgManager) {
		this.gxSysOrgManager = gxSysOrgManager;
	}
	@Resource
	public void setvUserManager(VUserManager vUserManager) {
		this.vUserManager = vUserManager;
	}
	@Resource(name="vUserCopyManager")
	private VUserCopyManager vUserCopyManager;
	@Resource(name="gxSysUserInOrgCopyManager")
	private GxSysUserInOrgCopyManager gxSysUserInOrgCopyManager;
	@Resource(name="gxSysOrgCopyManager")
	private GxSysOrgCopyManager gxSysOrgCopyManager;
	@Autowired
	private GxRoleHasUserManager gxRoleHasUserManager;
	@Resource
	public void setGxSysUserInOrgManger(
			GxSysUserInOrgManager gxSysUserInOrgManger) {
		this.gxSysUserInOrgManger = gxSysUserInOrgManger;
	}
	@Resource(name="orgDataOrderDefaultManager")
	private OrgDataOrderDefaultManager orgDataOrderDefaultManager;
	@Resource
	public void setGxUserManager(SysUserManager gxUserManager) {
		this.gxUserManager = gxUserManager;
	}
}
