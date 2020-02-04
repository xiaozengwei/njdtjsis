<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>dgj/dgj-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}"><!-- 页大小 -->
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}"><!-- 当前页 -->
        <input type="hidden" name="orderField" value="${param.orderField}"><!-- 排序字段 -->
        <input type="hidden" name="orderDirection" value="${param.orderDirection}"><!-- 排序方向 -->
        <div style="float: right">
            <button type="button" class="btn-green" data-url="<%=basePath%>dgj/dgj-input.do?rowId=${rowId}" data-toggle="dialog" data-target="dgj-input" data-id="dgj-dialog" data-icon="plus" data-width="400" data-height="300">添加盾构机进度</button>
            &nbsp;
            <button type="button" class="btn-red" data-url="<%=basePath%>dgj/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>
        </div>

    </form>
</div>
<div class="bjui-pageContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="4%" align="center">序号</th>
            <th width="4%" align="center">实际环数</th>
            <th width="4%" align="center">设计环数</th>
            <th width="4%" align="center">开累环数</th>
            <th width="4%" align="center">出土车数</th>
            <th width="35%" align="center" >影响因素</th>
            <th width="7%" align="center" >时间</th>
            <th width="5%" align="center" >操作</th>
        </tr>
        <c:forEach items="${page.result}" var="view" varStatus="status">
            <tr data-id="${view.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${view.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center">${view.tjHs}</td>
                <td align="center">${view.sjHs}</td>
                <td align="center">${view.klHs}</td>
                <td align="center">${view.ctCs}</td>
                <td align="center">${view.yxYs}</td>
                <td align="center">
                    <fmt:formatDate value="${view.scTime}" pattern="yyyy-MM-dd" />
                </td>
                <td align="center">
                    <a class="btn btn-blue" href="<%=basePath%>dgj/dgj-input.do?rowId=${view.rowId}" data-toggle="dialog" data-id="dgj-update" data-width="400" data-height="300" data-title="编辑">编辑</a>
                </td>
            </tr>
        </c:forEach>
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