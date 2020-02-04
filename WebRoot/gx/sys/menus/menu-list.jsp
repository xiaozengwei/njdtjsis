<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
       <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>menu/sysmenu-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        
        <div class="bjui-searchBar">
            <label>菜单名称：</label><input type="text"  value="${param.filter_LIKES_functionName}" name="filter_LIKES_functionName" class="form-control" size="20">&nbsp;   
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
            	<button type="button" class="btn-green" data-url="<%=basePath%>menu/menu-edit.do"  data-toggle="dialog" data-target="menu-input" data-id="menu-input-dialog"  data-icon="plus" data-width="500" data-height="400">添加菜单</button>&nbsp;
                <button type="button" class="btn-blue" data-url="<%=basePath %>menu/menu-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中行</button>
                
            </div>
        </div>
       
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
            	<th width="3%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            	<th  width="5%"  align="center">菜单名称</th>
                <th width="15%"  align="center">英文名称</th>
                <th width="15%"  align="center">数据排序</th>
                <th width="15%"  align="center">菜单级别</th>
                <th width="20%" align="center">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${page.result}" var="gxSysFunction" varStatus="status">
            <tr data-id="${gxSysFunction.rowId}">
            	<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${gxSysFunction.rowId}"></td>
            	<td align="center">${gxSysFunction.functionName}</td>
                <td align="center">${gxSysFunction.functionEnName}</td>
                <td align="center">${gxSysFunction.dataOrder}</td>
                <td align="center">${gxSysFunction.functionType}</td>
                <td align="center">
                    
                   <button type="button" class="btn-green" data-url="<%=basePath%>menu/menu-edit.do?rowId=${gxSysFunction.rowId}"  data-toggle="dialog"  data-id="menu-update" data-target="menu-update"  data-width="500" data-height="400">编辑</button>
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
			<select data-toggle="selectpicker"
				data-toggle-change="changepagesize">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="25">25</option>
			</select>
		</div>
		<span>&nbsp;条，共 ${page.totalCount }条</span>
	</div>
	<div class="pagination-box" data-toggle="pagination" data-total="${page.totalCount }"
		data-page-size="${page.pageSize }" data-page-current="${page.pageCurrent}"></div>
</div>