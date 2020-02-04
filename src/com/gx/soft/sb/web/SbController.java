package com.gx.soft.sb.web;

import com.gx.core.export.ExcelDataNormalStrategy;
import com.gx.core.export.ExcelExportUtil;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.common.util.QrCodeCreateUtil;
import com.gx.soft.danagerproject.persistence.domain.DanagerProject;
import com.gx.soft.sb.persistence.domain.EquipmentInfo;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.EquipmentInfoManager;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("sb")
@SessionAttributes("user_session")
public class SbController {

	@Autowired
	private EquipmentInfoManager equipmentInfoManager;
	@Autowired
	private FileRecordManager fileRecordManager;
	@Autowired
	private GxRecordManager gxRecordManager;
	
	private BeanMapper beanMapper = new BeanMapper();
	private Page curPage=null;

	/**
	 * 前往设备信息列表
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("sb-list")
	public String sbList(@ModelAttribute Page page,
						 @RequestParam(required = false, defaultValue = "") String orderField,
						 @RequestParam(required = false, defaultValue = "") String orderDirection,
						 @RequestParam Map<String, Object> parameterMap, Model model,@ModelAttribute("user_session") VUser user) {
		if (orderField.length() > 0 && orderDirection.length() > 0) {
			page.setOrderBy(orderField);
			page.setOrder(orderDirection);
		} else {
			page.setOrderBy("enterTime");
			page.setOrder("DESC");
		}
		parameterMap.put("filter_EQS_bdId",user.getComBdId());
		if(!user.getUserId().equals("yu_j")) {
			parameterMap.put("filter_EQS_bdId", user.getComBdId());
		}
		List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
		page.setPageSize((int) page.getTotalCount());
		page = equipmentInfoManager.pagedQuery(page, propertyFilters);
		curPage=page;
		page.setPageSize(10);
		page = equipmentInfoManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		return "sb/sb-list";
	}

	/**
	 * 设备信息的添加/更新页面
	 * 
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("sb-input")
	public String input(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		String resultPage ;
		if (rowId != null && rowId.length() > 0) {
			EquipmentInfo equipmentInfo = equipmentInfoManager.get(rowId);
			model.addAttribute("equipmentInfo", equipmentInfo);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
			resultPage = "sb/sb-edit";
		} else {
			resultPage = "sb/sb-input";
		}
		return resultPage;
	}

	@RequestMapping("sb-detail")
	public String detail(@RequestParam(value = "rowId", required = false) String rowId, Model model) {
		if (rowId != null) {
			EquipmentInfo equipmentInfo = equipmentInfoManager.get(rowId);
			model.addAttribute("equipmentInfo", equipmentInfo);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList",fileList);
		}
		return "sb/sb-detail";
	}

	/**
	 * 更新或保存设备信息
	 * 
	 * @param equipmentInfo
	 * @return
	 */
	@RequestMapping(value = "sb-save",method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, Object> save(String attachmentId, EquipmentInfo equipmentInfo, @ModelAttribute("user_session") VUser user) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			EquipmentInfo dest ;
			String id = equipmentInfo.getRowId();
			if (id != null && id.length() > 0) {
				dest = equipmentInfoManager.get(id);
				beanMapper.copy(equipmentInfo, dest);
				dest.setUpdateTime(ts);
				dest.setUpdateUserId(user.getUserId());
				dest.setUpdateUserName(user.getUserName());
				equipmentInfoManager.save(dest);
			} else {
				equipmentInfo.setRowId(null);
				dest = equipmentInfo;
				dest.setCreateTime(ts);
				dest.setCreateUserId(user.getUserId());
				dest.setCreateUserName(user.getUserName());
				dest.setOrgDwId(user.getComOrgId());
				dest.setBdId(user.getComBdId());
				equipmentInfoManager.save(dest);
				id = dest.getRowId();
				String path = "C:/qrCode/"+sdf.format(new Date())+"/"+id+".jpg";
				// 生成二维码
//				String content = "http://localhost:8080/njdtjsis/sb/get-sb-info.do?rowId="+id;
				String content = "http://221.6.30.202:9076/njdtjsis/sb/get-sb-info.do?rowId="+id;
				QrCodeCreateUtil.encode(content, path);
				dest.setQrCode(path);
				equipmentInfoManager.save(dest);
				id = dest.getRowId();

			}
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
	 * 设备删除
	 * 
	 * @return
	 */
	@RequestMapping("remove")
	public @ResponseBody
	Map<String, Object> sbRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null && rowId.length() > 0) {
						equipmentInfoManager.removeById(rowId);
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

	/**
	 * 二维码显示
	 * @param rowId
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "QR-code-show")
	public void downloadReport(String rowId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(rowId != null && rowId.length() > 0){
			EquipmentInfo equipmentInfo = equipmentInfoManager.get(rowId);
			String qrCode = equipmentInfo.getQrCode();
			String fileName = equipmentInfo.getManagerNum()+".jpg";
			FileUtil fileHelper = new FileUtil();
			fileHelper.downloadFile(qrCode, request, response, fileName);
		}
	}

	/**
	 * 查看设备信息（二维码扫描）
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("get-sb-info")
	public String getSbInfo(@RequestParam(value = "rowId") String rowId, Model model) {
		String returnPage = "sb/sb-info";
		if (rowId != null) {
			EquipmentInfo equipmentInfo = equipmentInfoManager.get(rowId);
			model.addAttribute("equipmentInfo", equipmentInfo);
			List<FileRecord> fileList = fileRecordManager.findBy("relationId", rowId);
			model.addAttribute("fileList", fileList);
		}else{
			returnPage = "";
		}
		return returnPage;
	}

	@RequestMapping("get-lsDw")
	public @ResponseBody
	List<GxSysDicRecord> getSlDw(String equipmentType) {
		String dicType;
		if(equipmentType.equals("租赁设备")){
			dicType = "zl-sb";
		}else{
			dicType = "xzDw-sb";
		}
		List<GxSysDicRecord> pzList = gxRecordManager.findBy("dicType", dicType);
		return pzList;
	}
	@RequestMapping("export")
	@ResponseBody
	public Map<String, Object> export(HttpServletResponse response) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "导出成功";
		String[] columnNameArr = {"sbZl", "equipmentName","lsDw","managerNum","enterTime"};

		String fileName = "设备种类";
		Map<String, Object> metaMap = new HashMap<>();
		String[] columnComment = {"设备种类", "设备名称","隶属单位","管理编号","进场时间"};

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

}
