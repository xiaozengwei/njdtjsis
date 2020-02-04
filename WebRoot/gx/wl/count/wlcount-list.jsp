<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<script>
    function show( url) {
        window.open("<%=request.getContextPath()%>/gx/view/view-show.jsp?url="+url)
    }
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>wlcount/wlcount-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}"><!-- 页大小 -->
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}"><!-- 当前页 -->
        <input type="hidden" name="orderField" value="${param.orderField}"><!-- 排序字段 -->
        <input type="hidden" name="orderDirection" value="${param.orderDirection}"><!-- 排序方向 -->
        <label>标段名称：</label><input type="text" value="${param.filter_LIKES_bdName}" name="filter_LIKES_bdName" class="form-control">&nbsp;
        <button type="submit" class="btn-default" data-icon="search">查询</button>
        &nbsp;
        <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        &nbsp;
        <button type="button" class="btn-green" data-url="<%=basePath%>wlcount/wlcount-input.do?rowId=${rowId}" data-toggle="dialog" data-target="wlcount-input" data-id="wlcount-input-dialog" data-icon="plus" data-width="400" data-height="350">添加物料使用量</button>
        &nbsp;
        <button type="button" class="btn-red" data-url="<%=basePath%>wlcount/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>
    </form>
</div>
<div class="bjui-pageContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="15%" align="center">标段名称</th>
            <th width="15%" align="center" >物料类型</th>
            <th width="5%" align="center" >物料数量</th>
            <th width="5%" align="center" >单位</th>
            <th width="15%" align="center" >创建人</th>
            <th width="15%" align="center" >使用时间</th>
            <th width="15%" align="center" >操作</th>
        </tr>
        <c:forEach items="${page.result}" var="risk" varStatus="status">
            <tr data-id="${risk.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${risk.rowId}"></td>
                <td align="center">${risk.bdName}</td>
                <td align="center">${risk.materialType}</td>
                <td align="center">${risk.materialCount}</td>
                <td align="center">${risk.ext1}</td>
                <td align="center">${risk.createName}</td>
                <td align="center">
                    <fmt:formatDate value="${risk.createTime}" pattern="yyyy-MM-dd" />
                </td>
                <td align="center">
                    <button class="btn-blue" data-url="<%=basePath%>wlcount/wlcount-input.do?rowId=${risk.rowId}" data-toggle="dialog" data-id="wlcount-update" data-mask="true" data-width="400" data-height="350"  data-title="编辑">编辑</button>
                    &nbsp;&nbsp;
                    <button class="btn-blue" data-url="<%=basePath%>wlcount/wlcount-look.do?rowId=${risk.rowId}" data-toggle="dialog" data-id="wlcount-look" data-mask="true" data-width="400" data-height="350"  data-title="查看详情">查看</button>
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