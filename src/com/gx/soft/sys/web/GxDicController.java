package com.gx.soft.sys.web;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gx.soft.common.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.MessageHelper;
import com.gx.core.util.StringUtils;
import com.gx.soft.sys.persistence.domain.GxOaWenhaoConfig;
import com.gx.soft.sys.persistence.domain.GxOaWenhaoMax;
import com.gx.soft.sys.persistence.domain.GxSysDicIndex;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.GxIndexManager;
import com.gx.soft.sys.persistence.manager.GxOaWenhaoConfigManager;
import com.gx.soft.sys.persistence.manager.GxOaWenhaoMaxManager;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.sys.persistence.manager.VSysDicManager;

@Controller
@RequestMapping("dic")
@SessionAttributes("user_session")
public class GxDicController {
	private GxIndexManager gxIndexManager;
	private GxRecordManager gxRecordManager;

	private MessageHelper messageHelper;
	private BeanMapper beanMapper = new BeanMapper();
	/**
	 * 文号配置管理
	 */
	private GxOaWenhaoConfigManager wenhaoConfigManager;
	/**
	 * 文号最大值管理
	 */
	private GxOaWenhaoMaxManager wenhaoMaxManager;

	/**
	 * 视图-数据字典管理
	 */
	private VSysDicManager vSysDicManager;

	/**
	 * 前往数据字典索引列表
	 * 
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-index-list")
	public String list(@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page.setOrderBy("orderNum");
		page.setOrder("asc");
		page = gxIndexManager.pagedQuery(page, propertyFilters);
		@SuppressWarnings("unchecked")
		List<GxSysDicIndex> indexList = (List<GxSysDicIndex>) page.getResult();
		page.setResult(indexList);
		model.addAttribute("page", page);
		return "dic/index/dic-index-list";
	}

	/**
	 * 数据字典索引记录的添加/更新页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-index-input")
	public String input(
			@RequestParam(value = "rowId", required = false) String id,
			Model model) {
		GxSysDicIndex dicIndex = null;
		if (id != null) {
			dicIndex = gxIndexManager.get(id);
		} else {
			dicIndex = new GxSysDicIndex();
		}
		model.addAttribute("model", dicIndex);
		return "dic/index/dic-index-input";

	}

	/**
	 * 更新或保存数据字典索引
	 * 
	 * @param dicIndex
	 * @param
	 * @return
	 */
	@RequestMapping("dic-index-save")
	public @ResponseBody
	Map<String, Object> save(GxSysDicIndex dicIndex) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxSysDicIndex dest = null;
			String id = dicIndex.getRowId();

			if (id != null && id.length() > 0) {
				dest = gxIndexManager.get(id);
				beanMapper.copy(dicIndex, dest);
				dest.setUpdateTime(ts);
			} else {
				dicIndex.setRowId(null);
				dest = dicIndex;
				dest.setCreateDate(ts);
			}
			gxIndexManager.save(dest);

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
	 * 数据字典索引的删除
	 * 
	 * @param selectedItem
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("dic-index-remove")
	public @ResponseBody
	Map<String, Object> dicIndexRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					if (rowId != null) {
						GxSysDicIndex dicIndex = gxIndexManager.get(rowId);
						String dicIndexRowId = dicIndex.getRowId();
						List<GxSysDicRecord> dicRecordList = gxRecordManager
								.findBy("tableId", dicIndexRowId);

						/* 删除数据字典索引关联的记录 */

						if (dicRecordList != null && dicRecordList.size() > 0) {
							for (GxSysDicRecord r : dicRecordList) {
								if (r != null) {
									gxRecordManager.remove(r);
								}
							}
						}

					}
					gxIndexManager.removeById(rowId);

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
	 * 前往数据字典关联记录界面
	 * 
	 * @param roleId
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-record-list")
	public String userlist(String rowId, @ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		page.setOrderBy("orderNum");
		page.setOrder("asc");
		parameterMap.put("filter_EQS_tableId", rowId);
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page = gxRecordManager.pagedQuery(page, propertyFilters);
		model.addAttribute("page", page);
		model.addAttribute("rowId", rowId);
		return "dic/dic/dic-record-list";
	}

	/**
	 * 数据字典关联记录输入/更新页面
	 * 
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("dic-record-input")
	public String dicRecordInput(
			@RequestParam(value = "rowId", required = false) String id,
			String indexId, Model model) {
		GxSysDicRecord dicRecord = null;
		if (id != null) {
			dicRecord = gxRecordManager.get(id);
		} else {
			dicRecord = new GxSysDicRecord();
		}
		model.addAttribute("model", dicRecord);
		model.addAttribute("indexId", indexId);
		return "dic/dic/dic-record-input";
	}

	/**
	 * 数据字典关联记录的保存
	 * 
	 * @param rowId
	 * @param gxSysRole
	 * @return
	 */
	@RequestMapping("dic-record-save")
	public @ResponseBody
	Map<String, Object> dicRecordSave(GxSysDicRecord dicRecord) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		Timestamp ts = DateUtil.getDate();
		try {
			GxSysDicRecord dest = null;
			String id = dicRecord.getRowId();
			String maxStatus = dicRecord.getMaxStatus() == null ? "0"
					: dicRecord.getMaxStatus();
			String maxId = dicRecord.getMaxId();
			if (id != null && id.length() > 0) {// operation:update
				dest = gxRecordManager.get(id);
				String maxstatusD = dest.getMaxStatus() == null ? "" :  dest.getMaxStatus() ;
				String maxIdD = dest.getMaxId();
				beanMapper.copy(dicRecord, dest);
				dest.setUpdateTime(ts);
				if (!maxStatus.equals(maxstatusD)) {
					if (maxStatus.equals("0") && maxstatusD.equals("1")) {// 修改为不启用
						wenhaoMaxManager.removeById(maxIdD);
						maxId = "";

					} else {// 修改为启用
						GxOaWenhaoMax max = new GxOaWenhaoMax();
						max.setMaxWenhao("0");
						wenhaoMaxManager.save(max);
						maxId = max.getWenhaoMaxRowId();

					}
				} else {
					maxStatus = maxstatusD;
					maxId = maxIdD;
				}
			} else {// operation:insert
				dicRecord.setRowId(null);
				dest = dicRecord;
				dest.setCreateDate(ts);
				if (maxStatus.equals("1")) {

					GxOaWenhaoMax max = new GxOaWenhaoMax();
					max.setMaxWenhao("0");
					wenhaoMaxManager.save(max);
					maxId = max.getWenhaoMaxRowId();

				}
			}
			dest.setMaxStatus(maxStatus);
			dest.setMaxId(maxId);
			gxRecordManager.save(dest);

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
	 * 数据字典关联记录的删除
	 * 
	 * @param roleId
	 * @param selectedItem
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("dic-record-remove")
	public @ResponseBody
	Map<String, Object> dicRecordRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {

			if (delids != null && delids.length() > 0) {
				String[] rowids = delids.split(",");
				/* 其次遍历指定的rowId获取到指定的roleHasUser对象并删除 */
				for (String rowId : rowids) {
					gxRecordManager.removeById(rowId);
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
	 * 显示文号配置列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "wenhao-config-list-page", method = RequestMethod.GET)
	public String showWenhaoConfig(Model model) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<GxOaWenhaoConfig> configList = wenhaoConfigManager
				.find(propertyFilters);
		model.addAttribute("configList", configList);
		return "dic/wenhao-config-list";
	}

	/**
	 * 获取文号表的列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "wenhao-config-list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<GxOaWenhaoConfig> listWenhaoConfig() {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<GxOaWenhaoConfig> configList = wenhaoConfigManager
				.find(propertyFilters);
		return configList;
	}

	/**
	 * 文号保存
	 * 
	 * @param wenhao
	 * @return
	 */
	@RequestMapping(value = "wenhao-config-save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, Object> wenhaoConfigSave(GxOaWenhaoConfig wenhao,
			@RequestParam(required = false) String isMixed,
			@RequestParam(required = false) String mix_maxid,
			@ModelAttribute("user_session") GxSysUser user) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "保存成功";
		try {
			Timestamp time = DateUtil.getDate();
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			String creatorUserId = user.getUserId();
			String creatorUserName = user.getUserName();
			String markWord = wenhao.getMarkWord();
			String wenhaoType = wenhao.getWenhaoType();
			String bracketType = wenhao.getBracketType();
			String bracketLeft = bracketType.substring(0,
					bracketType.indexOf("*"));// 左括号
			String bracketRight = bracketType.substring(
					bracketType.indexOf("*") + 1, bracketType.length());// 右括号

			String completeContent = wenhaoType + markWord + bracketLeft + year
					+ bracketRight + "*" + "号";

			if (isMixed.equals("0")) {// 不混合使用
				GxOaWenhaoMax wenhaoMax = new GxOaWenhaoMax();
				wenhaoMax.setMaxWenhao("0");
				wenhaoMaxManager.save(wenhaoMax);
				mix_maxid = wenhaoMax.getWenhaoMaxRowId();
			}
			wenhao.setCreateTime(time);
			wenhao.setWenhaoYear(String.valueOf(year));
			wenhao.setCreatorId(creatorUserId);
			wenhao.setCreatorName(creatorUserName);
			wenhao.setCompleteContent(completeContent);
			wenhao.setMaxWenhaoRowId(mix_maxid);

			wenhaoConfigManager.save(wenhao);

			resMap.put("wenhao", wenhao);
		} catch (Exception e) {

			statusCode = "300";
			message = "保存失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 获取最大值
	 * 
	 * @param maxId
	 * @return
	 */
	@RequestMapping(value = "wenhao-max-get", method = RequestMethod.GET)
	public @ResponseBody
	String showWenhaoMax(String maxId,@RequestParam(required=false,defaultValue="")String year) {
		GxOaWenhaoMax max = wenhaoMaxManager.get(maxId);
		String maxStr = max != null ? max.getMaxWenhao() : "0";
		String currentYear = max.getExtend2();
		if(StringUtils.validateString(year)){//如果年份不为空，则要取当年年份最大
			if(!currentYear.equals(year)){
				maxStr = "0";
			}
		}
		return maxStr ;
	}

	@RequestMapping(value = "advice-list", method = RequestMethod.GET)
	public String showAdviceList(String column, Model model) {

		model.addAttribute("column", column);
		return "dic/advice";
	}

	// setters
	@Resource
	public void setGxIndexManager(GxIndexManager gxIndexManager) {
		this.gxIndexManager = gxIndexManager;
	}

	@Resource
	public void setGxRecordManager(GxRecordManager gxRecordManager) {
		this.gxRecordManager = gxRecordManager;
	}

	@Resource
	public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}

	@Resource(name = "gxOaWenhaoConfigManager")
	public void setWenhaoConfigManager(
			GxOaWenhaoConfigManager wenhaoConfigManager) {
		this.wenhaoConfigManager = wenhaoConfigManager;
	}

	@Resource(name = "gxOaWenhaoMaxManager")
	public void setWenhaoMaxManager(GxOaWenhaoMaxManager wenhaoMaxManager) {
		this.wenhaoMaxManager = wenhaoMaxManager;
	}

	@Resource
	public void setvSysDicManager(VSysDicManager vSysDicManager) {
		this.vSysDicManager = vSysDicManager;
	}

}
