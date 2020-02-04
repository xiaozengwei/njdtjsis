<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script>
    function show() {
        window.open("<%=request.getContextPath()%>/gx/map/map.jsp");
    }
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>map/map-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar" style="line-height:40px">
            <label>姓名：</label><input type="text" value="${param.filter_LIKES_userName}" name="filter_LIKES_userName" class="form-control">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            &nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            &nbsp;
            <button type="button" class="btn-blue" onclick="show()">打开地图</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="5%" align="center">序号</th>
            <th width="7%" align="center">姓名</th>
            <th width="12%" align="center" >手机号</th>
            <th width="15%" align="center">经度</th>
            <th width="15%" align="center" >纬度</th>
            <th width="15%" align="center" >标段</th>
            <th width="15%" align="center">时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="sb" varStatus="status">
            <tr data-id="${sb.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${sb.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center">${sb.userName}</td>
                <td align="center">${sb.personPhone}</td>
                <td align="center">${sb.addressJd}</td>
                <td align="center">${sb.addressWd}</td>
                <td align="center">${sb.bdName}</td>
                <td align="center"><fmt:formatDate value="${sb.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>

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