<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>role/mobile-role-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        
        <div class="bjui-searchBar">
            <label>角色名称：</label><input type="text" id="customNo" value="${param.filter_LIKES_roleName}" name="filter_LIKES_roleName" class="form-control" size="10">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
            	<button type="button" class="btn-green" data-url="<%=basePath%>role/mobile-role-input.do"  data-toggle="dialog" data-target="role-input" data-id="role-input-dialog"  data-icon="plus" data-width="800" data-height="400">添加角色</button>&nbsp;
                <button type="button" class="btn-blue" data-url="<%=basePath %>role/mobile-role-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中行</button>
                
            </div>
        </div>
       
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
            	<th width="3%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            	<th  width="5%"  align="center">排序</th>
                <th width="25%"  align="center">角色名称</th>
                <th width="15%"  align="center">角色类型</th>
                <th width="15%"  align="center">角色说明</th>
                <th width="20%" align="center">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${page.result}" var="role" varStatus="status">
            <tr data-id="${role.rowId}">
            	<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${role.rowId}"></td>
            	<td align="center">${status.index +1 }</td>
                <td align="center">${role.roleName}</td>
                <td align="center">${role.roleType eq '0' ? '非系统角色':'系统角色' }</td>
                <td align="center">${role.roleIntro}</td>
                <td align="center">
                    <a href="<%=basePath%>role/mobile-role-input.do?rowId=${role.rowId}"  data-toggle="dialog" data-id="role-update" data-width="800" data-height="400"  data-title="编辑">编辑</a>||
                    <a href="<%=basePath%>role/mobile-role-functionlist.do?rowId=${role.rowId}"  data-toggle="dialog" data-id="role-functionlist" data-width="700" data-height="500" data-title="修改权限">修改权限</a>||
                    <a href="<%=basePath%>role/mobile-role-userlist.do?rowId=${role.rowId}"  data-toggle="navtab" data-id="role-userlist"  data-title="关联用户">关联用户</a>
                  
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