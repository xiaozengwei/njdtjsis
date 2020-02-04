package com.gx.soft.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.sys.persistence.domain.VSysDic;
import com.gx.soft.sys.persistence.manager.VSysDicManager;

@Service
public class VSysDicService {
	/*
	 * 视图-数据字典管理
	 */
	private VSysDicManager vSysDicManager;

	public List<VSysDic> findVSysDicByFunctionId(String functionId) {
		if(functionId== null || functionId.length() <1){
			functionId="#####";//默认查不到值
		}
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("filter_EQS_indexDicId", functionId);
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);

		List<VSysDic> dList = vSysDicManager.find("orderNum", true,
				propertyFilters);
		return dList;
	}

	// setters
	@Resource
	public void setvSysDicManager(VSysDicManager vSysDicManager) {
		this.vSysDicManager = vSysDicManager;
	}

}
