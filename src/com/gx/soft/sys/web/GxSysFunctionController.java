package com.gx.soft.sys.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;

import com.gx.soft.sys.persistence.domain.GxSysFunction;
import com.gx.soft.sys.persistence.manager.GxFunctionManager;
import com.gx.soft.sys.vo.ZtreeData;

/**
 * @date 2017-08-04
 * @author yls
 *
 */
@Controller
@RequestMapping("menu")
public class GxSysFunctionController {
	// 日志
	private static Logger logger = LoggerFactory
				.getLogger(GxSysFunctionController.class);

	
	private GxFunctionManager gxSysFunctionManager;
	private BeanMapper beanMapper = new BeanMapper();
	
	@Resource
	public void setGxFunctionManager(GxFunctionManager gxSysFunctionManager) {
		this.gxSysFunctionManager = gxSysFunctionManager;
	}
	
	/**
	 * 显示菜单列表
	 * @param page
	 * @param parameterMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "sysmenu-list")
	public String showSysMenuList(@ModelAttribute Page page,
			@RequestParam Map<String, Object> parameterMap, Model model) {
		//用于条件搜索时，过滤参数
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		page.setOrderBy("dataOrder");
		page.setOrder("asc");
		page = gxSysFunctionManager.pagedQuery(page, propertyFilters);
		@SuppressWarnings("unchecked")
		List<GxSysFunction> gxSysFunctionList =  (List<GxSysFunction>) page.getResult();
		page.setResult(gxSysFunctionList);
		model.addAttribute("page", page);
		
		return "sys/menus/menu-list";
	}

	/**
	 * 菜单添加/修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "menu-edit")
	public String edit(
			@RequestParam(value = "rowId", required = false) Long id,
			Model model) {
		GxSysFunction gxSysFunction = null;
		GxSysFunction parentFunc = new GxSysFunction();
		if (id != null) {
		   gxSysFunction = gxSysFunctionManager.get(id);
		   if(!"root".equals(gxSysFunction.getParentFunctionId())){
			   parentFunc = gxSysFunctionManager.get(Long.parseLong(gxSysFunction.getParentFunctionId()));
		   }else{
			   parentFunc.setParentFunctionId("root");
			   parentFunc.setFunctionName("root");
		   }
		} else {
			gxSysFunction = new GxSysFunction();
		}
		List<GxSysFunction> sysFunctionList = gxSysFunctionManager.getAll();
		List<ZtreeData> ztree = new ArrayList<ZtreeData>();
		//遍历sysFunctionList为ztree赋值
		for (int i = 0; i < sysFunctionList.size(); i++) {
			GxSysFunction gxSysFunction1 = sysFunctionList.get(i);
			ZtreeData tree = new ZtreeData();
			tree.setId(gxSysFunction1.getRowId()+"");
			tree.setpId(gxSysFunction1.getParentFunctionId());
			tree.setName(gxSysFunction1.getFunctionName());
			ztree.add(tree);
		}
		model.addAttribute("ztree", ztree);
		model.addAttribute("model", gxSysFunction);
		model.addAttribute("parentFunc", parentFunc);
		return "sys/menus/menu-input";

	}
	
	/**
	 * 修改或保存菜单数据
	 * @param gxSysFunction
	 * @return
	 */
	@RequestMapping(value="menu-save")
	public @ResponseBody
	Map<String, Object> save(GxSysFunction gxSysFunction) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "操作成功";
		try {
			GxSysFunction dest = new GxSysFunction();
			Long id = gxSysFunction.getRowId();
			if (id != null) {
				//id不为null，说明数据库已经有此条数据，在此只需修改数据
				dest = gxSysFunctionManager.get(id);
				beanMapper.copy(gxSysFunction, dest);
			} else {
				gxSysFunction.setDataStatus("1");
				dest = gxSysFunction;
			}
			gxSysFunctionManager.save(dest);

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
	 * 删除菜单
	 * @param delids
	 * @return
	 */
	@RequestMapping(value="menu-remove")
	public @ResponseBody
	Map<String, Object> dicIndexRemove(String delids) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		try {
			if (delids != null && delids.length() > 0) {
				String[] ids = delids.split(",");
				for (String rowId : ids) {
					//查看待删除菜单下是否包含子菜单
					List<GxSysFunction> sysFunctionList = gxSysFunctionManager.findBy("parentFunctionId",rowId);
					if(sysFunctionList.size() > 0){
						statusCode = "300";
						message = "包含子菜单不可删";
					}else{
						Long funcId = Long.parseLong(rowId);
						gxSysFunctionManager.removeById(funcId);
					}
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

	
}
