package com.gx.soft.wl.web;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gx.core.export.ExcelDataNormalStrategy;
import com.gx.core.export.ExcelExportUtil;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.danagerproject.persistence.domain.DanagerProject;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.home.persistence.manager.SxpzRecordManager;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.domain.SysTypeDic;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sb.persistence.manager.SysTypeDicManager;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.VUserManager;
import com.gx.soft.wl.persistence.domain.*;
import com.gx.soft.wl.persistence.manager.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("wl")
@SessionAttributes("user_session")
public class WlController {
	private static String appId = "iDaNtYVN0l9AO7Tg8rUxb8";
	private static String appKey = "yqgHTDjLhi5kkvWOX6Wto1";
	private static String masterSecret = "9EkONQI2X46oKLmtuyAcf6";
	private static String url = "http://sdk.open.api.igexin.com/apiex.htm";
	private static String host = "http://sdk.open.api.igexin.com/apiex.htm";
	private Page curPage=null;

	@Autowired
	private MaterialInfoManager materialInfoManager;
	@Autowired
	private MaterialTrackManager materialTrackManager;

	@Autowired
	private SysTypeDicManager sysTypeDicManager;

	@Autowired
	private FileRecordManager fileRecordManager;

	@Autowired
	private UnqualifiedTestJczxManager unqualifiedTestJczxManager;

	@Autowired
	private UnqualifiedTestManager unqualifiedTestManager;

	@Autowired
	private MaterielTestManager materielTestManager;

	@Autowired
	private VUserManager vUserManager;

	@Autowired
	private SxpzRecordManager sxpzRecordManager;

	@Autowired
	private WlImportRecordManager wlImportRecordManager;


	
	private BeanMapper beanMapper = new BeanMapper();

	/******************************************************************物料检测台账***************************************************************/
	@RequestMapping("wl-test-list")
	public String wlTestList(@ModelAttribute Page page,
						  @RequestParam(required = false, defaultValue = "") String orderField,
						  @RequestParam(required = false, defaultValue = "") String orderDirection,
							 @ModelAttribute("user_session") VUser user,
						  @RequestParam Map<String, Object> parameterMap, Model model) {
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		} else {
			page.setOrderBy("createTime");
			page.setOrder("DESC");
		}

		if(!user.getUserId().equals("yu_j") && !user.getUserId().equals("ren_yy")){
			parameterMap.put("filter_EQS_comBdId",user.getComBdId());
		}

		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = materielTestManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		return "wl/wl-test-list";
	}

	@RequestMapping("wl-test-input")
	public String wlTestInput(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		MaterielTest materielTest;
		String resultPage ;
		if (rowId != null) {
			materielTest = materielTestManager.get(rowId);
			model.addAttribute("model", materielTest);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
			resultPage = "wl/wl-test-edit";
		} else {
			resultPage = "wl/wl-test-input";
		}
//		List<SysTypeDic> dicList = sysTypeDicManager.findBy("dicType", "wl_type");
//		model.addAttribute("dicList", dicList);
		return resultPage;
	}

	@RequestMapping("wl-test-save")
	public @ResponseBody
	Map<String, Object> wlTestSave(String attachmentId, MaterielTest materielTest, @ModelAttribute("user_session") VUser user) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			MaterielTest dest;
			String id = materielTest.getRowId();
			if (id != null && id.length() > 0) {
				dest = materielTestManager.get(id);
				beanMapper.copy(materielTest, dest);
				dest.setUpdateTime(ts);
				dest.setUpdateUserId(user.getUserId());
				dest.setUpdateUserName(user.getUserName());
			} else {
				materielTest.setRowId(null);
				dest = materielTest;
				dest.setCreateTime(ts);
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setComBdId(user.getComBdId());
				dest.setComOrgId(user.getComOrgId());
			}
			materielTestManager.save(dest);
			id = dest.getRowId();
			//关联附件
			if(attachmentId != null && attachmentId.length() > 0){
				String[] idArr = attachmentId.split(",");
				for(int i=0;i<idArr.length;i++){
					FileRecord fileRecord = fileRecordManager.get(idArr[i]);
					fileRecord.setRelationId(id);
					fileRecordManager.save(fileRecord);
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
		return resMap;
	}

	@RequestMapping("wl-test-detail")
	public String wlTestDetail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			MaterielTest materielTest = materielTestManager.get(rowId);
			model.addAttribute("model", materielTest);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
		}
		return "wl/wl-test-detail";
	}

	@RequestMapping("wl-test-remove")
	public @ResponseBody
	Map<String, Object> wlTestRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null && rowId.length() > 0) {
						materielTestManager.removeById(rowId);
						List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
						if(fileList != null && fileList.size() > 0){
							for (FileRecord fileRecord:fileList) {
								fileRecordManager.remove(fileRecord);
								FileUtil fileHelper = new FileUtil();
								fileHelper.deleteFile(fileRecord.getFilePath());
							}
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
		resMap.put("reload", true);
		return resMap;
	}

	/******************************************************************不合格检测台账***************************************************************/

	@RequestMapping("bhg-list")
	public String bhgList(@ModelAttribute Page page,
							  @RequestParam(required = false, defaultValue = "") String orderField,
							  @RequestParam(required = false, defaultValue = "") String orderDirection,
						  @ModelAttribute("user_session") VUser user,
							  @RequestParam Map<String, Object> parameterMap, Model model) {
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		} else {
			page.setOrderBy("createTime");
			page.setOrder("DESC");
		}
		if(!user.getUserId().equals("yu_j") && !user.getUserId().equals("ren_yy")){
			parameterMap.put("filter_EQS_comBdId",user.getComBdId());
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = unqualifiedTestManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		return "wl/bhg-list";
	}

	@RequestMapping("bhg-input")
	public String bhgInput(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		UnqualifiedTest unqualifiedTest;
		String resultPage ;
		if (rowId != null) {
			unqualifiedTest = unqualifiedTestManager.get(rowId);
			model.addAttribute("model", unqualifiedTest);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
			resultPage = "wl/bhg-edit";
		} else {
			resultPage = "wl/bhg-input";
		}
//		List<SysTypeDic> dicList = sysTypeDicManager.findBy("dicType", "wl_type");
//		model.addAttribute("dicList", dicList);
		return resultPage;
	}

	@RequestMapping("bhg-save")
	public @ResponseBody
	Map<String, Object> bhgSave(String attachmentId, UnqualifiedTest unqualifiedTest, @ModelAttribute("user_session") VUser user) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		String bdName=null;
		if(user.getComBdId()!=null){
			SxpzRecord sxpzRecord=sxpzRecordManager.findUniqueBy("sxpzBdId",user.getComBdId());
			bdName=sxpzRecord.getSxpzName();
		}
		try {
			UnqualifiedTest dest;
			String id = unqualifiedTest.getRowId();
			if (id != null && id.length() > 0) {
				dest = unqualifiedTestManager.get(id);
				beanMapper.copy(unqualifiedTest, dest);
				dest.setUpdateUserId(user.getUserId());
				dest.setUpdateTime(ts);
				dest.setUpdateUserName(user.getUserName());
			} else {
				unqualifiedTest.setRowId(null);
				dest = unqualifiedTest;
				dest.setCreateTime(ts);
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setComOrgId(user.getComOrgId());
				dest.setComBdId(user.getComBdId());
			}
			unqualifiedTestManager.save(dest);
			id = dest.getRowId();
			//关联附件
			if(attachmentId != null && attachmentId.length() > 0){
				String[] idArr = attachmentId.split(",");
				for(int i=0;i<idArr.length;i++){
					FileRecord fileRecord = fileRecordManager.get(idArr[i]);
					fileRecord.setRelationId(id);
					fileRecordManager.save(fileRecord);
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		if(message.equals("操作成功")){
			AppPush appPush=new AppPush();
			List<String>cilentIdList=new ArrayList<>();
			if(user.getComBdId()!=null) {
				List<VUser> vUserList = vUserManager.findBy("comBdId", user.getComBdId());
				String []userType={"项目经理","总监理工程师","项目总工","总监","安全经理","安质部副部长","业主","质量负责人","总工","安质部部长","项目副经理"};
				for(VUser v:vUserList){
					if(v.getClientId()!=null){
						for(String c:userType){
							if(c.equals(v.getUserType())){
								cilentIdList.add(v.getClientId());
							}
						}

					}
				}
				VUser user1=vUserManager.findUniqueBy("userId","gong_hx");
				cilentIdList.add(user1.getClientId());
			}
			for(String cLientId:cilentIdList){
				//        ios
				IGtPush push = new IGtPush(url, appKey, masterSecret);

				List<String> appIds = new ArrayList<String>();
				appIds.add(appId);
				// 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
				SingleMessage message2 = new SingleMessage();
				TransmissionTemplate transmissionTemplate = appPush.getTemplate(appPush.getDictionaryAlertMsg("不合格检测台账",bdName+"   "+String.valueOf(ts)));
				message2.setData(transmissionTemplate);
//        message2.setAppIdList(appIds);
				message2.setOffline(true);
				message2.setOfflineExpireTime(1000 * 600);
				Target target2 = new Target();
				target2.setAppId(appId);
				target2.setClientId(cLientId);
				//    notificationTemplateDemo(appId, appKey);

				IPushResult ret = push.pushMessageToSingle(message2,target2);
				System.out.println(ret.getResponse().toString());
//______________________________________________________________________________________________________
//       安卓
				TransmissionTemplate template1 = appPush.linkTemplateDemo("不合格检测台账",bdName+"   "+String.valueOf(ts));
				SingleMessage message3 = new SingleMessage();
				message3.setOffline(true);
				// 离线有效时间，单位为毫秒，可选
				message3.setOfflineExpireTime(24 * 3600 * 1000);
				message3.setData(template1);
				// 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
				message3.setPushNetWorkType(0);
				Target target = new Target();
				target.setAppId(appId);
				target.setClientId(cLientId);

				ret = null;
				try {
					ret = push.pushMessageToSingle(message3, target);
				} catch (RequestException e) {
					e.printStackTrace();
					ret = push.pushMessageToSingle(message3, target, e.getRequestId());
				}
				if (ret != null) {

					System.out.println(ret.getResponse().toString());
				} else {
					System.out.println("服务器响应异常");
				}
			}

		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		return resMap;
	}

	@RequestMapping("bhg-detail")
	public String bhgDetail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			UnqualifiedTest unqualifiedTest = unqualifiedTestManager.get(rowId);
			model.addAttribute("model", unqualifiedTest);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
		}
		return "wl/bhg-detail";
	}

	@RequestMapping("bhg-remove")
	public @ResponseBody
	Map<String, Object> bhgRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null && rowId.length() > 0) {
						unqualifiedTestManager.removeById(rowId);
						List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
						if(fileList != null && fileList.size() > 0){
							for (FileRecord fileRecord:fileList) {
								fileRecordManager.remove(fileRecord);
								FileUtil fileHelper = new FileUtil();
								fileHelper.deleteFile(fileRecord.getFilePath());
							}
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
		resMap.put("reload", true);
		return resMap;
	}

	/******************************************************************不合格检测台账（检测中心）***************************************************************/

	@RequestMapping("jczx-bhg-list")
	public String jczxBhgList(@ModelAttribute Page page,
						  @RequestParam(required = false, defaultValue = "") String orderField,
						  @RequestParam(required = false, defaultValue = "") String orderDirection,
							  @ModelAttribute("user_session") VUser user,
						  @RequestParam Map<String, Object> parameterMap, Model model) {
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		} else {
			page.setOrderBy("createTime");
			page.setOrder("DESC");
		}
		if(!user.getUserId().equals("yu_j") && !user.getUserId().equals("ren_yy") && !user.getUserId().equals("si_sy")){
			parameterMap.put("filter_EQS_comBdId",user.getComBdId());
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page = unqualifiedTestJczxManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		return "wl/jczx-bhg-list";
	}

	@RequestMapping("jczx-bhg-input")
	public String jczxBhgInput(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		UnqualifiedTestJczx unqualifiedTestJczx;
		String resultPage ;
		if (rowId != null) {
			unqualifiedTestJczx = unqualifiedTestJczxManager.get(rowId);
			model.addAttribute("model", unqualifiedTestJczx);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
			resultPage = "wl/jczx-bhg-edit";
		} else {
			resultPage = "wl/jczx-bhg-input";
		}
		return resultPage;
	}

	@RequestMapping("jczx-bhg-save")
	public @ResponseBody
	Map<String, Object> jczxBhgSave(String attachmentId, UnqualifiedTestJczx unqualifiedTestJczx, @ModelAttribute("user_session") VUser user) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		String bdName=null;
		if(user.getComBdId()!=null){
			SxpzRecord sxpzRecord=sxpzRecordManager.findUniqueBy("sxpzBdId",user.getComBdId());
			bdName=sxpzRecord.getSxpzName();
		}
		try {
			UnqualifiedTestJczx dest;
			String id = unqualifiedTestJczx.getRowId();
			if (id != null && id.length() > 0) {
				dest = unqualifiedTestJczxManager.get(id);
				beanMapper.copy(unqualifiedTestJczx, dest);
				dest.setUpdateUserId(user.getUserId());
				dest.setUpdateTime(ts);
				dest.setUpdateUserName(user.getUserName());
			} else {
				unqualifiedTestJczx.setRowId(null);
				dest = unqualifiedTestJczx;
				dest.setCreateTime(ts);
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setComOrgId(user.getComOrgId());
				dest.setComBdId(String.valueOf(unqualifiedTestJczx.getExt2()));
			}
			unqualifiedTestJczxManager.save(dest);
			id = dest.getRowId();
			//关联附件
			if(attachmentId != null && attachmentId.length() > 0){
				String[] idArr = attachmentId.split(",");
				for(int i=0;i<idArr.length;i++){
					FileRecord fileRecord = fileRecordManager.get(idArr[i]);
					fileRecord.setRelationId(id);
					fileRecordManager.save(fileRecord);
				}
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "操作失败";
			e.printStackTrace();
		}
		if(message.equals("操作成功")){
			AppPush appPush=new AppPush();
			List<String>cilentIdList=new ArrayList<>();
			if(user.getComBdId()!=null) {
				List<VUser> vUserList = vUserManager.findBy("comBdId", user.getComBdId());
				String []userType={"项目经理","总监理工程师","项目总工","总监","安全经理","安质部副部长","业主","质量负责人","总工","安质部部长","项目副经理"};
				for(VUser v:vUserList){
					if(v.getClientId()!=null){
						for(String c:userType){
							if(c.equals(v.getUserType())){
								cilentIdList.add(v.getClientId());
							}
						}

					}
				}
				VUser user1=vUserManager.findUniqueBy("userId","gong_hx");
				cilentIdList.add(user1.getClientId());
			}
			for(String cLientId:cilentIdList){
				//        ios
				IGtPush push = new IGtPush(url, appKey, masterSecret);

				List<String> appIds = new ArrayList<String>();
				appIds.add(appId);
				// 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
				SingleMessage message2 = new SingleMessage();
				TransmissionTemplate transmissionTemplate = appPush.getTemplate(appPush.getDictionaryAlertMsg("检测中心抽检不合格",bdName+"   "+String.valueOf(ts)));
				message2.setData(transmissionTemplate);
//        message2.setAppIdList(appIds);
				message2.setOffline(true);
				message2.setOfflineExpireTime(1000 * 600);
				Target target2 = new Target();
				target2.setAppId(appId);
				target2.setClientId(cLientId);
				//    notificationTemplateDemo(appId, appKey);

				IPushResult ret = push.pushMessageToSingle(message2,target2);
				System.out.println(ret.getResponse().toString());
//______________________________________________________________________________________________________
//       安卓
				TransmissionTemplate template1 = appPush.linkTemplateDemo("检测中心抽检不合格",bdName+"   "+String.valueOf(ts));
				SingleMessage message3 = new SingleMessage();
				message3.setOffline(true);
				// 离线有效时间，单位为毫秒，可选
				message3.setOfflineExpireTime(24 * 3600 * 1000);
				message3.setData(template1);
				// 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
				message3.setPushNetWorkType(0);
				Target target = new Target();
				target.setAppId(appId);
				target.setClientId(cLientId);

				ret = null;
				try {
					ret = push.pushMessageToSingle(message3, target);
				} catch (RequestException e) {
					e.printStackTrace();
					ret = push.pushMessageToSingle(message3, target, e.getRequestId());
				}
				if (ret != null) {

					System.out.println(ret.getResponse().toString());
				} else {
					System.out.println("服务器响应异常");
				}
			}

		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("closeCurrent", true);
		return resMap;
	}

	@RequestMapping("jczx-bhg-detail")
	public String jczxBhgDetail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			UnqualifiedTestJczx unqualifiedTestJczx = unqualifiedTestJczxManager.get(rowId);
			model.addAttribute("model", unqualifiedTestJczx);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
		}
		return "wl/jczx-bhg-detail";
	}

	@RequestMapping("jczx-bhg-remove")
	public @ResponseBody
	Map<String, Object> jczxBhgRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null && rowId.length() > 0) {
						unqualifiedTestJczxManager.removeById(rowId);
						List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
						if(fileList != null && fileList.size() > 0){
							for (FileRecord fileRecord:fileList) {
								fileRecordManager.remove(fileRecord);
								FileUtil fileHelper = new FileUtil();
								fileHelper.deleteFile(fileRecord.getFilePath());
							}
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
		resMap.put("reload", true);
		return resMap;
	}

	/******************************************************************物料管理***************************************************************/

	/**
	 * 前往物料信息列表
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("wl-list")
	public String queryWlList(@ModelAttribute Page page,String materialType,
							  @RequestParam(required = false, defaultValue = "") String orderField,
							  @RequestParam(required = false, defaultValue = "") String orderDirection,
							  @ModelAttribute("user_session") VUser user,
							  @RequestParam Map<String, Object> parameterMap, Model model) {
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		} else {
			page.setOrderBy("enterTime");
			page.setOrder("DESC");
		}
		if(!user.getUserId().equals("yu_j") && !user.getUserId().equals("ren_yy")){
			parameterMap.put("filter_EQS_bdId",user.getComBdId());
		}
		if(materialType != null && materialType.length() > 0){
			parameterMap.put("filter_EQS_materialType",sysTypeDicManager.get(materialType).getDicName());
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page.setPageSize((int) page.getTotalCount());
		page = materialInfoManager.pagedQuery(page, propertyFilters);
		curPage=page;
		page.setPageSize(10);
		page = materialInfoManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		model.addAttribute("materialType", materialType);
		return "wl/wl-list";
	}

	/**
	 * 物料的添加/更新页面
	 * 
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("wl-input")
	public String input(@RequestParam(value = "rowId", required = false) String rowId, String materialType, Model model) {
		MaterialInfo materialInfo;
		String resultPage ;

		if (rowId != null) {
			materialInfo = materialInfoManager.get(rowId);
			materialType = materialInfo.getMaterialType();
			model.addAttribute("model", materialInfo);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
			if(materialType.equals("混凝土")){
				resultPage = "wl/wl-edit-hnt";
			}else{
				resultPage = "wl/wl-edit";
			}
		} else {
			resultPage = "wl/wl-input";
			if(materialType != null && materialType.length() > 0){
				materialType=sysTypeDicManager.get(materialType).getDicName();
				model.addAttribute("materialType", materialType);
				if(materialType.equals("混凝土")){
					resultPage = "wl/wl-input-hnt";
				}
			}
		}
		List<SysTypeDic> dicList = sysTypeDicManager.findBy("dicType", "wl_type");
		model.addAttribute("dicList", dicList);
		return resultPage;
	}

	@RequestMapping("wl-detail")
	public String detail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			MaterialInfo materialInfo = materialInfoManager.get(rowId);
			model.addAttribute("model", materialInfo);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
			if(materialInfo.getMaterialType().equals("混凝土")){
				return "wl/wl-detail-hnt";
			}

		}
		return "wl/wl-detail";
	}

	/**
	 * 更新或保存物料信息
	 * 
	 * @param materialInfo
	 * @return
	 */
	@RequestMapping("save")
	public @ResponseBody
	Map<String, Object> save(String attachmentId, MaterialInfo materialInfo, @ModelAttribute("user_session") VUser user) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			MaterialInfo dest;
			String id = materialInfo.getRowId();
			if (id != null && id.length() > 0) {
				dest = materialInfoManager.get(id);
				beanMapper.copy(materialInfo, dest);
				dest.setUpdateUserId(user.getUserId());
				dest.setUpdateUserName(user.getUserName());
				dest.setUpdateTime(ts);
			} else {
				materialInfo.setRowId(null);
				dest = materialInfo;
				dest.setCreateTime(ts);
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setOrgDwId(user.getComOrgId());
				dest.setBdId(user.getComBdId());
			}
			materialInfoManager.save(dest);
			id = dest.getRowId();
			//关联附件
			if(attachmentId != null && attachmentId.length() > 0){
				String[] idArr = attachmentId.split(",");
				for(int i=0;i<idArr.length;i++){
					FileRecord fileRecord = fileRecordManager.get(idArr[i]);
					fileRecord.setRelationId(id);
					fileRecordManager.save(fileRecord);
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
		return resMap;
	}

	/**
	 * 物料删除
	 * 
	 * @return
	 */
	@RequestMapping("remove")
	public @ResponseBody
	Map<String, Object> wlRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null && rowId.length() > 0) {
						materialInfoManager.removeById(rowId);
						List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
						if(fileList != null && fileList.size() > 0){
							for (FileRecord fileRecord:fileList) {
								fileRecordManager.remove(fileRecord);
								FileUtil fileHelper = new FileUtil();
								fileHelper.deleteFile(fileRecord.getFilePath());
							}
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
		resMap.put("reload", true);
		return resMap;
	}

	@RequestMapping("export")
	@ResponseBody
	public Map<String, Object> export(HttpServletResponse response) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "导出成功";
		String[] columnNameArr = {"materialName", "materialModel","manufacturer","enterNumber","batchNumber","enterTime"};
		String fileName = "物料管理";
		Map<String, Object> metaMap = new HashMap<>();
		String[] columnComment = {"物料名称", "型号规格","生产厂家","进场数量","批号","进场时间"};
		Integer[] columnWidth = {250, 250, 250};
		metaMap.put("columnName", columnNameArr);
		metaMap.put("columnWidth", columnWidth);
		metaMap.put("columnComment", columnComment);
		ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataNormalStrategy());
		try {
			excelExportUtil.exportBean(response, fileName, (List) curPage.getResult(), metaMap);
		} catch (Exception e) {
			statusCode = "300";
			message = "导出失败";
			e.printStackTrace();
		}
		resMap.put("statusCode",statusCode);
		resMap.put("message",message);
		return resMap;
	}

	@RequestMapping("import")
	public @ResponseBody
	Map<String, Object> processUpload(@RequestParam MultipartFile file, String mainRowId,
									  HttpServletResponse response, Model model, HttpSession session,
									  @ModelAttribute("user_session") VUser user) throws IOException {
		model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
		String statusCode = "200", message = "导入成功", tabid = "", forward = "", forwardConfirm = "";
		boolean closeCurrent = false;
		Map<String, Object> resMap = new HashMap<String, Object>();
		Timestamp ts = DateUtil.getDate();
		long timeL = ts.getTime();
		String fileOriginalName = file.getOriginalFilename();
		int index = fileOriginalName.lastIndexOf(".");
		String file_type = fileOriginalName.substring(index+1);
		WlImportRecord wlImportRecord;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\sb\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				wlImportRecord = new WlImportRecord();
				wlImportRecord.setFilePath(mFilePath);
				wlImportRecord.setFileName(fileOriginalName);
				wlImportRecord.setFileIdentifyName(decodeFileName);
				wlImportRecord.setFileType(file_type);
				wlImportRecord.setUploadUserId(user.getUserId());
				wlImportRecord.setUploadUserName(user.getUserName());
				wlImportRecord.setUploadTime(ts);
				//保存
				wlImportRecordManager.save(wlImportRecord);
				int k=0;
				int flag = 0;   //指示指针所访问的位置
				String f = "true"; //当前行的列是否有空值 true为没有，false有空值，不继续保存，保存失败
				String reson = "";//导入失败原因
				String path=mFilePath;//获取文件的路径
				Workbook workbook = null;
				workbook = new XSSFWorkbook(path);//初始化workbook对象
				for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {       //读取每一个sheet
					System.out.println("2007版进入读取sheet的循环");
					if (null != workbook.getSheetAt(numSheets)) {
						XSSFSheet aSheet = (XSSFSheet) workbook.getSheetAt(numSheets);//定义Sheet对象
						for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
							//进入当前sheet的行的循环
							if (null != aSheet.getRow(rowNumOfSheet)) {
								XSSFRow aRow = aSheet.getRow(rowNumOfSheet); //定义行，并赋值
								MaterialInfo materialInfo = new MaterialInfo();
								System.out.println(aRow.getLastCellNum()+"num"+"rowNumOfSheet"+rowNumOfSheet);

								for (int cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {    //读取rowNumOfSheet值所对应行的数据
									XSSFCell xCell = aRow.getCell(cellNumOfRow); //获得行的列数                                                           //获得列值
									//System.out.println("type="+xCell.getCellType());
									//读取每一个sheet
									if (null != aRow.getCell(cellNumOfRow)) {

										if (rowNumOfSheet == 0) {    // 如果rowNumOfSheet的值为0，则读取表头，判断excel的格式和预定格式是否相符
											if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {

											} else if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {

											} else if (xCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
												if (cellNumOfRow == 0) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("物料种类")) {
														flag++;
													}
													if (!xCell.getStringCellValue().equals("物料种类")) {
														statusCode = "300";
														message = "请按导入示例导入！";
													}
												} else if (cellNumOfRow == 1) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("物料名称")) {
														flag++;
													}
													if (!xCell.getStringCellValue().equals("物料名称")) {
														statusCode = "300";
														message = "请按导入示例导入！";
													}
												} else if (cellNumOfRow == 2) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("管理人员")) {
														flag++;
													}
													if (!xCell.getStringCellValue().equals("管理人员")) {
														statusCode = "300";
														message = "请按导入示例导入！";
													}
												} else if (cellNumOfRow == 3) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("电话")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("电话")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("电话")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}

												}else if (cellNumOfRow == 4) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("型号规格")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("型号规格")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("型号规格")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}

												} else if (cellNumOfRow == 5) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("生产厂家")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("生产厂家")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("生产厂家")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												} else if (cellNumOfRow == 6) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("进场时间")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("进场时间")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("进场时间")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												} else if (cellNumOfRow == 7) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("进场数量")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("进场数量")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("进场数量")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												} else if (cellNumOfRow == 8) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("计量单位")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("计量单位")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("计量单位")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												} else if (cellNumOfRow == 9) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("使用部位")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("使用部位")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("使用部位")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												} else if (cellNumOfRow == 10) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("批号")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("批号")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("批号")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												}else if (cellNumOfRow == 11) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("送检状态")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("送检状态")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("送检状态")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												}else if (cellNumOfRow == 12) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("合格证编号")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("合格证编号")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("合格证编号")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												}else if (cellNumOfRow == 13) {
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("自定义信息")) {
														flag++;
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("自定义信息")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													} else {
														xCell.setCellType(Cell.CELL_TYPE_STRING);
														if (!xCell.getStringCellValue().equals("自定义信息")) {
															statusCode = "300";
															message = "请按导入示例导入！";
														}
													}
												}
											}
										}else {
											// rowNumOfSheet != 0 即开始保存数据
											materialInfo.setCreateTime(ts);
											if (cellNumOfRow == 0) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setMaterialType(xCell.getStringCellValue());
											} else if (cellNumOfRow == 1) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setMaterialName(xCell.getStringCellValue());
											} else if (cellNumOfRow == 2) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setManagerPerson(xCell.getStringCellValue());//申领单位
											} else if (cellNumOfRow == 3) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setTelephone(xCell.getStringCellValue());//申领部门
											} else if (cellNumOfRow == 4) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setMaterialModel(xCell.getStringCellValue());
											} else if (cellNumOfRow == 5) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setManufacturer(xCell.getStringCellValue());
											} else if (cellNumOfRow == 6) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setEnterTime(Timestamp.valueOf(xCell.getStringCellValue()));
											} else if (cellNumOfRow == 7) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setEnterNumber(Double.valueOf(xCell.getStringCellValue()));
											} else if (cellNumOfRow == 8) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setMeasurementUnit(xCell.getStringCellValue());
											} else if (cellNumOfRow == 9) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setUseSite(xCell.getStringCellValue());
											} else if (cellNumOfRow == 10) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setBatchNumber(xCell.getStringCellValue());
											} else if (cellNumOfRow == 11) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setTestStatus(xCell.getStringCellValue());
											} else if (cellNumOfRow == 12) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setCertificateNum(xCell.getStringCellValue());
											} else if (cellNumOfRow == 13) {
												xCell.setCellType(Cell.CELL_TYPE_STRING);
												materialInfo.setCustomMessage(xCell.getStringCellValue());
											}
											k++;
										}
									} //获得一行，即读取每一行
								}
							}
						}
					}
				}
			} else {
				message = "请选择导入文件";
				statusCode = "300";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "导入失败";
			e.printStackTrace();
		}
		String tableUrl = "/pk/find_person_list.do?mainRowId="+mainRowId;
		model.addAttribute("tableUrl",tableUrl);
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		resMap.put("divid", "person_total_list");
		resMap.put("reload", true);
		resMap.put("closeCurrent", true);
		return resMap;
	}
	@RequestMapping("lookup-wl-bdId-list")
	public String orgLookupList(@ModelAttribute Page page,
								@RequestParam Map<String, Object> parameterMap, Model model) {

		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = sxpzRecordManager.pagedQuery(page, propertyFilters);
		List<SxpzRecord> sxpzRecordList = (List<SxpzRecord>) page.getResult();
		page.setResult(sxpzRecordList);
		model.addAttribute("page", page);

		return "wl/wl-list-bdid-lookup";

	}

	/**
	 * 导入示例
	 * @return
	 */
	@RequestMapping("import-example")
	public String importExample(){
		return "wl/wl-import-example";
	}
}
