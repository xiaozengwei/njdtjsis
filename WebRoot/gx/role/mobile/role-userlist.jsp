<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>role/mobile-role-userlist.do?rowId=${rowId}" method="post" data-reloadNavtab="false">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        
        <div class="bjui-searchBar">
            <label>用户名：</label><input type="text" id="customNo" value="${param.filter_LIKES_userName}"  name="filter_LIKES_userName" class="form-control" size="10">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
            	<button type="button" class="btn-orange" data-url="<%=basePath%>role/mobile-role-saveAllUserToRole.do?roleId=${rowId}"  data-toggle="doajax" data-target="role-adduser" data-id="role-input-dialog"  data-icon="plus" data-width="600" data-height="250">关联全部用户</button>&nbsp;
            	<button type="button" class="btn-green" data-url="<%=basePath%>role/mobile-role-user-add.do?rowId=${rowId}"  data-toggle="dialog" data-target="role-adduser" data-id="role-input-dialog"  data-icon="plus" data-width="600" data-height="250">关联用户</button>&nbsp;
                <button type="button" class="btn-blue" data-url="<%=basePath %>role/mobile-role-removeUser.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids"  >删除选中行</button>
            </div>
        </div>
       
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
            	<th width="26"><input type="checkbox"  class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            	<th align="center">排序</th>
                <th >用户名</th>
                <th>用户类型</th>
            </tr>
        </thead>
        <tbody>
        	
        	<c:forEach items="${page.result}" var="user" varStatus="status">
            <tr >
            	<td><input type="checkbox" name="ids" data-toggle="icheck" value="${user.VMobileRoleUserKey}"></td>
            	<td align="center">${status.index +1 }</td>
                <td>${user.userName}</td>
                <td>${user.userType eq '1' ? '员工': user.userType eq '2' ? '部门主管': user.userType eq '3' ? '分院长':'院长' }</td>
               
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