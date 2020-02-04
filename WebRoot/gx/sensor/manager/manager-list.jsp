<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch"  action="<%=basePath%>manager/manager-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        
        <div class="bjui-searchBar">
            <label>传感器名称：</label><input type="text" value="${param.filter_LIKES_sensorSiteName}" name="filter_LIKES_sensorSiteName" class="form-control" size="10">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                &nbsp;
                <button type="button" class="btn-green" data-url="<%=basePath%>manager/manager-input.do?rowId=${rowId}" data-toggle="dialog" data-target="sensor-input" data-id="sensor-input-dialog" data-icon="plus" data-width="400" data-height="450">添加传感器设备</button>
                &nbsp;
                <button type="button" class="btn-red" data-url="<%=basePath%>manager/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>
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
                <th width="10%"  align="center">传感器站名</th>
                <th width="15%"  align="center">传感器地址</th>
                <th width="5%"   align="center">传感器设备ID</th>
                <th width="10%"  align="center">传感器所属标段</th>
                <th width="7%"  align="center">传感器所属标段ID</th>
                <th width="7%"  align="center">传感器所属类别</th>
                <%--<th width="10%"  align="center">创建时间</th>--%>
                <%--<th width="10%"  align="center">更新时间</th>--%>
                <%--<th width="7%"  align="center">状态</th>--%>
                <th width="7%"  align="center">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${page.result}" var="sensor" varStatus="status">
            <tr data-id="${sensor.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${sensor.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center">${sensor.sensorSiteName}</td>
                <td align="center">${sensor.sensorSiteAddress}</td>
                <td align="center">${sensor.sensorSiteId}</td>
                <td align="center">${sensor.sensorSiteBd}</td>
                <td align="center">${sensor.sensorSiteBdId}</td>
                <td align="center">${sensor.sensorSiteType}</td>
                <%--<td align="center"><fmt:formatDate value="${sensor.createTime}" pattern="yyyy-MM-dd" /></td>--%>
                <%--<td align="center"><fmt:formatDate value="${sensor.updateTime}" pattern="yyyy-MM-dd" /></td>--%>
                <%--<td align="center">${sensor.status}</td>--%>
                <td align="center">
                    <button class="btn-blue" data-url="<%=basePath%>manager/manager-input.do?rowId=${sensor.rowId}" data-toggle="dialog" data-id="sensor-update" data-mask="true" data-width="400" data-height="450"  data-title="编辑">编辑</button>
                    &nbsp;&nbsp;
                    <button class="btn-blue" data-url="<%=basePath%>manager/manager-look.do?rowId=${sensor.rowId}" data-toggle="dialog" data-id="sensor-look" data-mask="true" data-width="400" data-height="450"  data-title="查看详情">查看</button>
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