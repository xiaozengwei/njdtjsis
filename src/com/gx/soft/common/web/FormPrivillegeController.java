package com.gx.soft.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.common.persistence.domain.GxOaFormPrivillegeRelation;
import com.gx.soft.common.persistence.manager.GxOaFormPrevillegeRelationManager;

/**
 * 表单权限控制器
 * 
 * @author YING
 * @date 2016-3-1
 */
@Controller
@RequestMapping(value = "form-privillege")
@SessionAttributes("user_session")
@Scope("prototype")
public class FormPrivillegeController {

	/**
	 * 表单元素权限manager
	 */
	@Resource
	private GxOaFormPrevillegeRelationManager formPrevillegeRelationManager;

	/**
	 * 获取表单 权限列表json
	 * 
	 * @param rowId
	 *            收文/发文ID
	 * @param businessKey
	 *            (sw/fw)
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, String> queryFormPrivillegeJson(String ptId, String atId,
			String businessKey) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		// parameterMap.put("filter_EQS_processTemplateId", ptId);
		parameterMap.put("filter_EQS_activityId", atId);
		parameterMap.put("filter_EQS_businessKey", businessKey);
		List<PropertyFilter> propertyFilters = PropertyFilter
				.buildFromMap(parameterMap);
		List<GxOaFormPrivillegeRelation> formPrivillegeList = formPrevillegeRelationManager
				.find(propertyFilters);
		Map<String, String> formPrivillegeMap = new HashMap<String, String>();
		for (GxOaFormPrivillegeRelation pr : formPrivillegeList) {
			formPrivillegeMap.put(pr.getFormElementName(),
					pr.getElementPrivillege());
		}
		return formPrivillegeMap;
	}

}
