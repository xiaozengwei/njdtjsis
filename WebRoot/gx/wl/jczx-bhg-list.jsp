<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>wl/jczx-bhg-list.do" method="post">
		<input type="hidden" name="pageSize" value="${page.pageSize}">
		<input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
		<input type="hidden" name="orderField" value="${param.orderField}">
		<input type="hidden" name="orderDirection" value="${param.orderDirection}">
		<div class="bjui-searchBar" style="line-height:40px">
			<label>检测报告编号：</label><input type="text" value="${param.filter_LIKES_testReportNo}" name="filter_LIKES_testReportNo" class="form-control">&nbsp;
			<button type="submit" class="btn-default" data-icon="search">查询</button>
			&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			&nbsp;
			<button type="button" class="btn-green" data-url="<%=basePath%>wl/jczx-bhg-input.do" data-toggle="dialog" data-target="sb-input" data-id="sb-input-dialog" data-icon="plus" data-width="500" data-height="500">添加</button>
			&nbsp;
			<button type="button" class="btn-blue" data-url="<%=basePath%>wl/jczx-bhg-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>
		</div>
	</form>
</div>
<div class="bjui-pageContent">
	<table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
		<thead>
			<tr>
				<th width="3%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
				<th width="3%" align="center">序号</th>
				<th width="8%" align="center">标段</th>
				<th width="8%" align="center">材料名称</th>
				<th width="8%" align="center" >委托日期</th>
				<th width="8%" align="center">试验日期</th>
				<th width="8%" align="center" >检测项目</th>
				<th width="8%" align="center" >检测报告编号</th>
				<th width="8%" align="center">检测结果</th>
				<th width="8%" align="center">初检/复检</th>
				<th width="8%" align="center">处理意见</th>
				<th width="8%" align="center">处理结果</th>
				<th width="15%" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="bhg" varStatus="status">
				<tr data-id="${bhg.rowId}">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${bhg.rowId}"></td>
					<td align="center">${status.count }</td>
					<td align="center">${bhg.ext1}</td>

					<td align="center">${bhg.materialName}</td>
					<td align="center">${bhg.entrustDate}</td>
					<td align="center">${bhg.testDate}</td>
					<td align="center">${bhg.testProject}</td>
					<td align="center">${bhg.testReportNo}</td>
					<td align="center">${bhg.testResult }</td>
					<td align="center">${bhg.cjFj }</td>
					<td align="center">${bhg.handleOpinion }</td>
					<td align="center">${bhg.handleResult }</td>
					<td align="center">
						<a class="btn btn-blue" href="<%=basePath%>wl/jczx-bhg-input.do?rowId=${bhg.rowId}" data-toggle="dialog" data-id="sb-update" data-width="500" data-height="500" data-title="编辑">编辑</a>
						<a class="btn btn-default" href="<%=basePath%>wl/jczx-bhg-detail.do?rowId=${bhg.rowId}" data-toggle="dialog" data-id="sb-detail" data-width="500" data-height="500" data-title="查看详情">查看详情</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
	<div class="pages">
		<span>每页&nbsp;</span>
		<div class="selectPagesize">
			<select data-toggle="selectpicker" data-toggle-change="changepagesize">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="25">25</option>
			</select>
		</div>
		<span>&nbsp;条，共 ${page.totalCount }条</span>
	</div>
	<div class="pagination-box" data-toggle="pagination"
		data-total="${page.totalCount }" data-page-size="${page.pageSize }"
		data-page-current="${page.pageCurrent }"></div>
</div>