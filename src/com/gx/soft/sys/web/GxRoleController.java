package com.gx.soft.sys.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gx.soft.common.util.DateUtil;
import com.gx.soft.mobile.persistence.domain.*;
import com.gx.soft.mobile.persistence.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.MessageHelper;
import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.domain.GxSysRole;
import com.gx.soft.sys.persistence.domain.GxSysRoleHasFunction;
import com.gx.soft.sys.persistence.domain.GxSysRoleHasUser;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VRoleUser;
import com.gx.soft.sys.persistence.manager.GxFunctionManager;
import com.gx.soft.sys.persistence.manager.GxRoleHasFunctionManager;
import com.gx.soft.sys.persistence.manager.GxRoleHasUserManager;
import com.gx.soft.sys.persistence.manager.GxRoleManager;
import com.gx.soft.sys.persistence.manager.GxVRoleUserManager;
import com.gx.soft.sys.persistence.manager.SysUserManager;

@Controller
@RequestMapping("role")
public class GxRoleController {
	private GxRoleManager gxRoleManager;
	private MessageHelper messageHelper;
	private GxRoleHasFunctionManager gxRoleHasFunctionManager;
	private GxRoleHasUserManager gxRoleHasUserManager;
	private GxFunctionManager gxFunctionMamager;
	private GxVRoleUserManager vRoleUserManager;
	private SysUserManager gxUserManager;

	@Autowired
	private GxOaMobileRoleManager gxOaMobileRoleManager;
	@Autowired
	private GxOaMobileRoleHasFunctionManager gxOaMobileRoleHasFunctionManager;
	@Autowired
	private GxOaMobileRoleHasUserManager gxOaMobileRoleHasUserManager;
	@Autowired
	private GxOaMobileFunctionManager gxOaMobileFunctionManager;
	@Autowired
	private VMobileRoleUserManager vMobileRoleUserManager;



	private BeanMapper beanMapper = new BeanMapper();

	/**
	 * 前往角色列表页面
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("role-list")
	public String list(@ModelAttribute Page page,
			@ModelAttribute String orderField,
			@ModelAttribute String orderDirection,
			@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxRoleManager.pagedQuery(page, propertyFilters);
		List<GxSysRole> roleList = (List<GxSysRole>) page.getResult();
		page.setResult(roleList);
		model.addAttribute("page", page);
		model.addAttribute("orderField", orderField);
		model.addAttribute("orderDirection", orderDirection);

		return "role/role-list";

	}

	/**
	 * 前往角色的添加/修改页面
	 * 
	 * @param
	 * @param model
	 * @return
	 */
	@RequestMapping("role-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String rowId,
			Model model) {
		GxSysRole gxSysRole = null;
		if (rowId != null) {
			gxSysRole = gxRoleManager.get(rowId);
		} else {
			gxSysRole = new GxSysRole();
		}
		model.addAttribute("model", gxSysRole);
		return "role/role-input";
	}

	/**
	 * 角色的保存/更新
	 * 
	 * @param gxSysRole
	 * @param
	 * @return
	 */
	@RequestMapping(value = "role-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(GxSysRole gxSysRole) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxSysRole dest = null;
			String id = gxSysRole.getRowId();

			if (id != null && id.length() > 0) {
				dest = gxRoleManager.get(id);
				beanMapper.copy(gxSysRole, dest);
				dest.setModifyTime(ts);
			} else {
				dest = gxSysRole;
				dest.setRowId(null);
				dest.setCreateTime(ts);
			}
			gxRoleManager.save(dest);

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
	 * 角色的删除
	 * 
	 * @param selectedItem
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("role-remove")
	public @ResponseBody
	Map<String, Object> roleRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null) {
						GxSysRole sysRole = gxRoleManager.get(rowId);
						String roleId = sysRole.getRoleId();
						List<GxSysRoleHasUser> roleUserList = gxRoleHasUserManager
								.findBy("roleId", roleId);
						List<GxSysRoleHasFunction> roleHasFunctionList = gxRoleHasFunctionManager
								.findBy("roleId", roleId);

						/* 删除角色用户关联表中的该角色对应的数据 */

						if (roleUserList != null && roleUserList.size() > 0) {
							for (GxSysRoleHasUser roleHasUser : roleUserList) {
								if (roleHasUser != null) {
									gxRoleHasUserManager.remove(roleHasUser);
								}
							}
						}

						/* 删除角色权限关联表中的该角色对应的数据 */

						if (roleHasFunctionList != null
								&& roleHasFunctionList.size() > 0) {
							for (GxSysRoleHasFunction roleHasFucntion : roleHasFunctionList) {
								if (roleHasFucntion != null) {
									gxRoleHasFunctionManager
											.remove(roleHasFucntion);
								}
							}
						}

					}
					gxRoleManager.removeById(rowId);

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

	/**
	 * 前往权限页面
	 * 
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping("role-functionlist")
	public String functionlist(
			@RequestParam(value = "rowId", required = false) String rowId,
			Model model) {
		GxSysRole sysRole = gxRoleManager.get(rowId);
		String roleId = "";
		if (sysRole != null) {
			roleId = sysRole.getRoleId();
		}
		List<GxSysRoleHasFunction> roleFunctions = gxRoleHasFunctionManager
				.findBy("roleId", roleId);
		List<GxSysFunction> functionList = gxFunctionMamager.getAll();

		Map<Long, String> functionIdMap = new HashMap<Long, String>();
		for (GxSysRoleHasFunction rf : roleFunctions) {
			functionIdMap
					.put(rf.getFunctionId(), rf.getFunctionId().toString());
		}

		model.addAttribute("roleId", roleId);
		model.addAttribute("functionIdMap", functionIdMap);
		model.addAttribute("functionList", functionList);

		return "role/role-functionlist";

	}

	/**
	 * 角色权限的更新
	 * 
	 * @param roleId
	 * @param perId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "role-permissionUpdate", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, Object> permissionUpdate(String roleId, String perId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "修改成功";
		try {
			List<GxSysRoleHasFunction> roleFunctions = gxRoleHasFunctionManager
					.findBy("roleId", roleId);

			List<String> oldFunctionList = new ArrayList<String>();// 原权限菜单

			for (GxSysRoleHasFunction r : roleFunctions) {
				if (!oldFunctionList.contains(r.getFunctionId())) {
					oldFunctionList.add(r.getFunctionId() + "");
				}
			}
			List<String> newFunctionList = new ArrayList<String>();// 新菜单
			if (!perId.trim().isEmpty()) {
				String[] newFunctions = perId.split(",");
				for (String funId : newFunctions) {
					if (!newFunctionList.contains(funId)) {
						newFunctionList.add(funId);
					}
				}
				for (String funId : newFunctions) {
					if (!oldFunctionList.contains(funId)) {// 如果原菜单中不存在，则保存
						GxSysRoleHasFunction roleHasFunction = new GxSysRoleHasFunction();
						roleHasFunction.setFunctionId(Long.parseLong(funId));
						roleHasFunction.setRoleId(roleId);
						gxRoleHasFunctionManager.save(roleHasFunction);
					}
				}
			}

			for (GxSysRoleHasFunction oldFun : roleFunctions) {
				if (!newFunctionList.contains(oldFun.getFunctionId() + "")) {// 如果新菜单中不存在，则删除
					if (oldFun != null) {
						gxRoleHasFunctionManager.remove(oldFun);
					}

				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "修改失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);

		return resMap;

	}

	/**
	 * 前往角色关联用户界面
	 * 
	 * @param roleId
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("role-userlist")
	public String userlist(@RequestParam(value = "rowId") String rowId,
			@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		GxSysRole sysRole = gxRoleManager.get(rowId);
		String roleId = "####";
		if (sysRole != null) {
			roleId = sysRole.getRoleId();
		}
		parameterMap.put("filter_EQS_roleId", roleId);
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = vRoleUserManager.pagedQuery(page, propertyFilters);
		@SuppressWarnings("unchecked")
		List<VRoleUser> roleHasUserList = (List<VRoleUser>) page.getResult();
		page.setResult(roleHasUserList);
		model.addAttribute("page", page);
		model.addAttribute("roleRowId", rowId);
		return "role/role-userlist";
	}

	/**
	 * 选择关联用户页面
	 * 
	 * @param rowId
	 * @param userName
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("role-userlookup")
	public String userlookup(@ModelAttribute Page page, String roleRowid,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		GxSysRole role = gxRoleManager.get(roleRowid);

		String hqlu = " SELECT u.userId FROM GxSysRoleHasUser u WHERE u.roleId = ?";
		List<String> userIdList = gxRoleHasUserManager.find(hqlu,
				role.getRoleId());
		Map<String, Object> paraMap = new HashMap<String, Object>();
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(paraMap);
		List<GxSysUser>  gxuserList = gxUserManager.find(propertyFilters);
		List<GxSysUser>  uuserList = new ArrayList<GxSysUser>();
		for(GxSysUser user : gxuserList){
			if(!userIdList.contains(user.getUserId())){
				uuserList.add(user);
			}
		}
		
		//Object[] userids = userIdList.toArray();
		String useridString = "";
		for (GxSysUser user : uuserList) {
			String id = user.getUserId();
			if (id != null) {
				useridString += id + ",";
			}
		}
		if (useridString.length() > 0) {
			useridString = useridString.substring(0, useridString.length() - 1);
		}
		parameterMap.put("filter_INS_userId", useridString);
		 propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxUserManager.pagedQuery(page, propertyFilters);
		List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
		page.setResult(userList);
		model.addAttribute("page", page);
		model.addAttribute("roleRowid", roleRowid);
		return "role/role-userlookup";
	}

	@RequestMapping("role-user-add")
	public String roleUserAdd(String rowId, Model model) {
		model.addAttribute("rowId", rowId);
		return "role/role-adduser";
	}

	/**
	 * 角色关联用户的保存
	 * 
	 * @param rowId
	 * @param gxSysRole
	 * @return
	 */
	@RequestMapping("role-saveUserToRole")
	public @ResponseBody
	Map<String, Object> saveUserToRole(String roleRowId,
			@RequestParam(value = "userId", required = false) String userIds) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		try {
			GxSysRole gxSysRole = gxRoleManager
					.findUniqueBy("rowId", roleRowId);
			String roleId = gxSysRole.getRoleId();
			String[] userIdGroup = userIds.split(",");
			Timestamp ts = DateUtil.getDate();
			List<String> uIdList = new ArrayList<String>();
			for (String id : userIdGroup) {// 去重复的值
				if (!uIdList.contains(id)) {
					uIdList.add(id);
				}
			}
			for (String userId : uIdList) {
				if (userId != null && roleId != null) {
					GxSysRoleHasUser roleUser = new GxSysRoleHasUser();
					roleUser.setUserId(userId);
					roleUser.setRoleId(roleId);
					roleUser.setRlType(gxSysRole.getRoleType());
					roleUser.setCreateTime(ts);
					gxRoleHasUserManager.save(roleUser);
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "保存失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);

		return resMap;

	}

	/**
	 * 角色关联用户的删除
	 * 
	 * @param roleId
	 * @param selectedItem
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("role-removeUser")
	public @ResponseBody
	Map<String, Object> roleUserRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {

			if (delids != null && delids.length() > 0) {
				String[] rowids = delids.split(",");
				/* 其次遍历指定的rowId获取到指定的roleHasUser对象并删除 */
				for (String rowId : rowids) {
					gxRoleHasUserManager.removeById(rowId);
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", true);

		return resMap;
	}

	/**
	 * 前往角色列表页面
	 *
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("mobile-role-list")
	public String mobileList(@ModelAttribute Page page,
							 @ModelAttribute String orderField,
							 @ModelAttribute String orderDirection,
							 @RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxOaMobileRoleManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		model.addAttribute("orderField", orderField);
		model.addAttribute("orderDirection", orderDirection);

		return "role/mobile/role-list";

	}

	/**
	 * 前往角色的添加/修改页面
	 *
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping("mobile-role-input")
	public String mobileInput(
			@RequestParam(value = "rowId", required = false) String rowId,
			Model model) {
		GxOaMobileRole gxSysRole = null;
		if (rowId != null) {
			gxSysRole = gxOaMobileRoleManager.get(rowId);
		} else {
			gxSysRole = new GxOaMobileRole();
		}
		model.addAttribute("model", gxSysRole);
		return "role/mobile/role-input";
	}

	/**
	 * 角色的保存/更新
	 *
	 * @param gxSysRole
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "mobile-role-save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> mobileSave(GxOaMobileRole gxSysRole) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxOaMobileRole dest = null;
			String id = gxSysRole.getRowId();

			if (id != null && id.length() > 0) {
				dest = gxOaMobileRoleManager.get(id);
				beanMapper.copy(gxSysRole, dest);
				dest.setModifyTime(ts);
			} else {
				dest = gxSysRole;
				dest.setRowId(null);
				dest.setCreateTime(ts);
			}
			gxOaMobileRoleManager.save(dest);

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
	 * 角色的删除
	 *
	 * @param selectedItem
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("mobile-role-remove")
	public @ResponseBody
	Map<String, Object> mobileRoleRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null) {
						GxOaMobileRole sysRole = gxOaMobileRoleManager
								.get(rowId);
						String roleId = sysRole.getRoleId();
						List<GxOaMobileRoleHasUser> roleUserList = gxOaMobileRoleHasUserManager
								.findBy("roleId", roleId);
						List<GxOaMobileRoleHasFunction> roleHasFunctionList = gxOaMobileRoleHasFunctionManager
								.findBy("roleId", roleId);

						/* 删除角色用户关联表中的该角色对应的数据 */

						if (roleUserList != null && roleUserList.size() > 0) {
							for (GxOaMobileRoleHasUser roleHasUser : roleUserList) {
								if (roleHasUser != null) {
									gxOaMobileRoleHasUserManager
											.remove(roleHasUser);
								}
							}
						}

						/* 删除角色权限关联表中的该角色对应的数据 */

						if (roleHasFunctionList != null
								&& roleHasFunctionList.size() > 0) {
							for (GxOaMobileRoleHasFunction roleHasFucntion : roleHasFunctionList) {
								if (roleHasFucntion != null) {
									gxOaMobileRoleHasFunctionManager
											.remove(roleHasFucntion);
								}
							}
						}

					}
					gxOaMobileRoleManager.removeById(rowId);

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

	/**
	 * 前往权限页面
	 *
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping("mobile-role-functionlist")
	public String mobileFunctionlist(
			@RequestParam(value = "rowId", required = false) String rowId,
			Model model) {
		GxOaMobileRole sysRole = gxOaMobileRoleManager.get(rowId);
		String roleId = "";
		if (sysRole != null) {
			roleId = sysRole.getRowId();
		}
		List<GxOaMobileRoleHasFunction> roleFunctions = gxOaMobileRoleHasFunctionManager
				.findBy("roleId", roleId);
		List<GxOaMobileFunction> functionList = gxOaMobileFunctionManager
				.getAll();

		Map<String, String> functionIdMap = new HashMap<String, String>();
		for (GxOaMobileRoleHasFunction rf : roleFunctions) {
			functionIdMap
					.put(rf.getFunctionId(), rf.getFunctionId().toString());
		}

		model.addAttribute("roleId", roleId);
		model.addAttribute("functionIdMap", functionIdMap);
		model.addAttribute("functionList", functionList);

		return "role/mobile/role-functionlist";

	}

	/**
	 * 角色权限的更新
	 *
	 * @param roleId
	 * @param perId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "mobile-role-permissionUpdate", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, Object> mobilePermissionUpdate(String roleId, String perId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "修改成功";
		try {
			List<GxOaMobileRoleHasFunction> roleFunctions = gxOaMobileRoleHasFunctionManager
					.findBy("roleId", roleId);

			List<String> oldFunctionList = new ArrayList<String>();// 原权限菜单

			for (GxOaMobileRoleHasFunction r : roleFunctions) {
				if (!oldFunctionList.contains(r.getFunctionId())) {
					oldFunctionList.add(r.getFunctionId() + "");
				}
			}
			List<String> newFunctionList = new ArrayList<String>();// 新菜单
			if (!perId.trim().isEmpty()) {
				String[] newFunctions = perId.split(",");
				for (String funId : newFunctions) {
					if (!newFunctionList.contains(funId) && !funId.equals("1")) {
						newFunctionList.add(funId);
					}
				}
				for (String funId : newFunctionList) {
					if (!oldFunctionList.contains(funId)) {// 如果原菜单中不存在，则保存
						GxOaMobileRoleHasFunction roleHasFunction = new GxOaMobileRoleHasFunction();
						roleHasFunction.setFunctionId(funId);
						roleHasFunction.setRoleId(roleId);
						gxOaMobileRoleHasFunctionManager.save(roleHasFunction);
					}
				}
			}

			for (GxOaMobileRoleHasFunction oldFun : roleFunctions) {
				if (!newFunctionList.contains(oldFun.getFunctionId() + "")) {// 如果新菜单中不存在，则删除
					if (oldFun != null) {
						gxOaMobileRoleHasFunctionManager.remove(oldFun);
					}

				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "修改失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);

		return resMap;

	}

	/**
	 * 前往角色关联用户界面
	 *
	 * @param roleId
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("mobile-role-userlist")
	public String mobileUserlist(@RequestParam(value = "rowId") String rowId,
								 @ModelAttribute Page page,
								 @RequestParam Map<String, Object> parameterMap, Model model) {
		parameterMap.put("filter_EQS_roleKey", rowId);
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = vMobileRoleUserManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		model.addAttribute("rowId", rowId);
		return "role/mobile/role-userlist";
	}

	/**
	 * 选择关联用户页面
	 *
	 * @param rowId
	 * @param userName
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("mobile-role-userlookup")
	public String mobileUserlookup(@ModelAttribute Page page, String roleRowid,
								   @RequestParam Map<String, Object> parameterMap, Model model) {

		String hqlu = " SELECT u.id.userId FROM GxOaMobileRoleHasUser u WHERE u.id.roleId = ?";
		List<String> userIdList = gxOaMobileRoleHasUserManager.find(hqlu,
				roleRowid);
		Map<String, Object> paraMap = new HashMap<String, Object>();
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(paraMap);
		List<GxSysUser> gxuserList = gxUserManager.find(propertyFilters);
		List<GxSysUser> uuserList = new ArrayList<GxSysUser>();
		for (GxSysUser user : gxuserList) {
			if (!userIdList.contains(user.getUserId())) {
				uuserList.add(user);
			}
		}

		// Object[] userids = userIdList.toArray();
		String useridString = "";
		for (GxSysUser user : uuserList) {
			String id = user.getUserId();
			if (id != null) {
				useridString += id + ",";
			}
		}
		if (useridString.length() > 0) {
			useridString = useridString.substring(0, useridString.length() - 1);
		}
		parameterMap.put("filter_INS_userId", useridString);
		propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = gxUserManager.pagedQuery(page, propertyFilters);
		List<GxSysUser> userList = (List<GxSysUser>) page.getResult();
		page.setResult(userList);
		if(useridString.equals("")){
			page.setTotalCount(0);
			page.setResult("");
		}
		model.addAttribute("page", page);
		model.addAttribute("roleRowid", roleRowid);
		return "role/mobile/role-userlookup";
	}

	@RequestMapping("mobile-role-user-add")
	public String mobileRoleUserAdd(String rowId, Model model) {
		model.addAttribute("rowId", rowId);
		return "role/mobile/role-adduser";
	}

	/**
	 * 角色关联用户的保存
	 *
	 * @param rowId
	 * @param gxSysRole
	 * @return
	 */
	@RequestMapping("mobile-role-saveUserToRole")
	public @ResponseBody
	Map<String, Object> mobileSaveUserToRole(String roleRowId,
											 @RequestParam Map<String, Object> parameterMap) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		try {
			String userIds = parameterMap.get("userId") == null ? ""
					: parameterMap.get("userId").toString();
			String roleId = roleRowId;
			String[] userIdGroup = userIds.split(",");
			Timestamp ts = DateUtil.getDate();
			List<String> uIdList = new ArrayList<String>();
			for (String id : userIdGroup) {// 去重复的值
				if (!uIdList.contains(id)) {
					uIdList.add(id);
				}
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filter_EQS_id.roleId", roleId);
			List<PropertyFilter> propertyFilters = null;
			for (String userId : uIdList) {

				if (userId != null && roleId != null) {
					params.put("filter_EQS_id.userId", userId);
					propertyFilters = PropertyFilter.buildFromMap(params);
					List<GxOaMobileRoleHasUser> roleHasUserList = gxOaMobileRoleHasUserManager
							.find(propertyFilters);
					if (roleHasUserList.size() < 1) {
						GxOaMobileRoleHasUser roleUser = new GxOaMobileRoleHasUser();

						GxOaMobileRoleHasUserId id = new GxOaMobileRoleHasUserId(
								userId, roleId);
						roleUser.setId(id);
						roleUser.setCreateTime(ts);
						gxOaMobileRoleHasUserManager.save(roleUser);
					}
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "保存失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);

		return resMap;

	}

	/**
	 * 角色关联所有人员-mobile
	 *
	 * @param roleId
	 * @param parameterMap
	 * @return
	 */
	@RequestMapping("mobile-role-saveAllUserToRole")
	public @ResponseBody
	Map<String, Object> mobileSaveAllUserToRole(String roleId,
												@RequestParam Map<String, Object> parameterMap) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		try {
			List<PropertyFilter> propertyFilters = new ArrayList<PropertyFilter>();
			List<GxSysUser> sysUserList = gxUserManager.find(propertyFilters);
			Timestamp ts = DateUtil.getDate();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filter_EQS_id.roleId", roleId);
			for (GxSysUser user : sysUserList) {
				String userId = user.getUserId();
				if (userId != null && roleId != null) {
					params.put("filter_EQS_id.userId", userId);
					propertyFilters = PropertyFilter.buildFromMap(params);
					List<GxOaMobileRoleHasUser> roleHasUserList = gxOaMobileRoleHasUserManager
							.find(propertyFilters);
					if (roleHasUserList.size() < 1) {
						GxOaMobileRoleHasUser roleUser = new GxOaMobileRoleHasUser();

						GxOaMobileRoleHasUserId id = new GxOaMobileRoleHasUserId(
								userId, roleId);
						roleUser.setId(id);
						roleUser.setCreateTime(ts);
						gxOaMobileRoleHasUserManager.save(roleUser);
					}
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "保存失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", true);

		return resMap;

	}

	/**
	 * 角色关联所有人员
	 *
	 * @param roleId
	 * @param parameterMap
	 * @return
	 */
	@RequestMapping("role-saveAllUserToRole")
	public @ResponseBody
	Map<String, Object> saveAllUserToRole(String roleId,
										  @RequestParam Map<String, Object> parameterMap) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		try {

			String roleRowId = roleId;
			List<PropertyFilter> propertyFilters = new ArrayList<PropertyFilter>();
			List<GxSysUser> sysUserList = gxUserManager.find(propertyFilters);
			Timestamp ts = DateUtil.getDate();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("filter_EQS_roleId", roleRowId);
			for (GxSysUser user : sysUserList) {
				String userId = user.getUserId();
				if (userId != null && roleRowId != null) {
					params.put("filter_EQS_userId", userId);
					propertyFilters = PropertyFilter.buildFromMap(params);
					List<GxSysRoleHasUser> roleHasUserList = gxRoleHasUserManager
							.find(propertyFilters);
					if (roleHasUserList.size() < 1) {
						GxSysRoleHasUser roleUser = new GxSysRoleHasUser();

						roleUser.setUserId(userId);
						roleUser.setRoleId(roleRowId);
						roleUser.setCreateTime(ts);
						gxRoleHasUserManager.save(roleUser);
					}
				}
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "保存失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", true);

		return resMap;

	}

	/**
	 * 角色关联用户的删除
	 *
	 * @param roleId
	 * @param selectedItem
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("mobile-role-removeUser")
	public @ResponseBody
	Map<String, Object> mobileRoleUserRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {

			if (delids != null && delids.length() > 0) {
				String[] rowids = delids.split(",");
				/* 其次遍历指定的rowId获取到指定的roleHasUser对象并删除 */
				for (String rowId : rowids) {
					String[] rowIds = rowId.split("_");
					gxOaMobileRoleHasUserManager
							.removeById(new GxOaMobileRoleHasUserId(rowIds[1]+"_"+rowIds[2],
									rowIds[0]));
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败";
			e.printStackTrace();
		}

		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("reload", true);

		return resMap;
	}











	@Resource
	public void setGxRoleManager(GxRoleManager gxRoleManager) {
		this.gxRoleManager = gxRoleManager;
	}

	@Resource
	public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}

	@Resource
	public void setGxRoleHasFunctionManager(
			GxRoleHasFunctionManager gxRoleHasFunctionManager) {
		this.gxRoleHasFunctionManager = gxRoleHasFunctionManager;
	}

	@Resource
	public void setGxRoleHasUserManager(
			GxRoleHasUserManager gxRoleHasUserManager) {
		this.gxRoleHasUserManager = gxRoleHasUserManager;
	}

	@Resource
	public void setGxFunctionMamager(GxFunctionManager gxFunctionMamager) {
		this.gxFunctionMamager = gxFunctionMamager;
	}

	@Resource
	public void setGxUserManager(SysUserManager gxUserManager) {
		this.gxUserManager = gxUserManager;
	}

	@Resource
	public void setvRoleUserManager(GxVRoleUserManager vRoleUserManager) {
		this.vRoleUserManager = vRoleUserManager;
	}

}
