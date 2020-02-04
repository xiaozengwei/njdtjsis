<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>sysuser/user-list.do?orgId=${orgId}" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        
        <div class="bjui-searchBar">
            <label>用户名称：</label><input type="text" value="${param.filter_LIKES_userName}" name="filter_LIKES_userName" class="form-control" size="10">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
            	<button type="button" class="btn-green" data-url="<%=basePath%>sysuser/user-input.do?orgId=${orgId}"  data-toggle="dialog" data-target="sysuser-input" data-id="sysuser-input-dialog"  data-icon="plus" data-width="600" data-height="400">添加人员</button>&nbsp;
                <button type="button" class="btn-blue" data-url="<%=basePath %>sysuser/user-remove.do?orgId=${orgId}" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中</button>
            	<button type="button" class="btn-green" data-url="<%=basePath%>sysuser/user-input-orgs.do?orgId=${orgId}"  data-toggle="dialog" data-target="sysuser-input" data-id="sysorgsuser-input-dialog"  data-icon="plus" data-width="600" data-height="400">添加多组织人员</button>&nbsp;
                <button type="button" class="btn-blue" data-url="<%=basePath %>sysuser/user-orgs-remove.do?orgId=${orgId}" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >解除组织关系</button>
                
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
            	<th width="3%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            	<th  width="5%"  align="center">序号</th>
            	<th  width="20%"  align="center">用户名</th>
                <th width="20%"  align="center">登录名</th>
                <th width="35%" align="center">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${page.result}" var="user" varStatus="status">
            <tr data-id="${user.userRowId}">
            	<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${user.userRowId}"></td>
            	<td align="center">${status.count }</td>
                <td align="center">${user.userName}</td>
                <td align="center">${user.userId}</td>
                <td align="center">
                    <button data-url="<%=basePath%>sysuser/user-input.do?rowId=${user.userRowId}" class="btn-green" data-toggle="dialog" data-id="sysuser-update" data-width="600" data-height="400"  data-title="编辑" data-icon="edit">编辑</button>&nbsp;&nbsp;
                   <button data-url="<%=basePath%>sysuser/updateOrder/up.do?uioRowId=${user.uioRowId}" class="btn-blue btn-resort" data-toggle="doajax" data-icon="chevron-up" data-type="get">升序</button>&nbsp;&nbsp;
                    <button data-url="<%=basePath%>sysuser/updateOrder/down.do?uioRowId=${user.uioRowId}"  class="btn-blue btn-resort" data-toggle="doajax"  data-icon="chevron-down" data-type="get">降序</button>
                     <button type="button" class="btn-orange" data-url="<%=basePath%>sysuser/org-page.do?rowId=${user.userRowId}"  data-toggle="dialog" data-confirm-msg="确定修改单位吗？" data-width="650" data-height="450"  data-title="修改单位" >修改单位</button >
                    
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
		data-page-size="${page.pageSize }" data-page-current="${page.pageCurrent }"></div>
</div>