<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="bjui-pageHeader">
    <%--<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>generalize/generalize-list.do" method="post">--%>
        <%--<input type="hidden" name="pageSize" value="${page.pageSize}"><!-- 页大小 -->--%>
        <%--<input type="hidden" name="pageCurrent" value="${page.pageCurrent}"><!-- 当前页 -->--%>
        <%--<input type="hidden" name="orderField" value="${param.orderField}"><!-- 排序字段 -->--%>
        <%--<input type="hidden" name="orderDirection" value="${param.orderDirection}"><!-- 排序方向 -->--%>
        <%--<label>物理地址：</label><input type="text" value="${param.filter_LIKES_wlAddress}" name="filter_LIKES_wlAddress" class="form-control">&nbsp;--%>
        <%--<label>hls-url-地址：</label><input type="text" value="${param.filter_LIKES_hlsLcAddress}" name="filter_LIKES_hlsLcAddress" class="form-control">&nbsp;--%>
        <%--<button type="submit" class="btn-default" data-icon="search">查询</button>--%>
        <%--&nbsp;--%>
        <%--<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>--%>
        <%--&nbsp;--%>
        <%--<button type="button" class="btn-green" data-url="<%=basePath%>view/view-input.do?rowId=${rowId}" data-toggle="dialog" data-target="view-input" data-id="view-input-dialog" data-icon="plus" data-width="400" data-height="300">添加视频</button>--%>
        <%--&nbsp;--%>
        <%--<button type="button" class="btn-red" data-url="<%=basePath%>view/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>--%>
    <%--</form>--%>
</div>
<div class="bjui-pageContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="5%" align="center">序号</th>
            <th width="7%" align="center">车站土建总工程</th>
            <th width="7%" align="center" >区间土建总工程</th>
            <th width="5%" align="center" >辅轨总进度</th>
            <th width="7%" align="center" >设备工程总进度</th>
            <th width="7%" align="center" >车站土建总工程</th>
            <th width="7%" align="center" >投资完成金额(亿)</th>
            <th width="5%" align="center" >车站总数</th>
            <th width="5%" align="center" >已开工车站</th>
            <th width="5%" align="center" >盾构机总数</th>
            <th width="5%" align="center" >始发盾构机</th>
            <th width="25%" align="center" >工程简介</th>
            <th width="8%" align="center" >操作</th>
        </tr>
        <c:forEach items="${page.result}" var="view" varStatus="status">
            <tr data-id="${view.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${view.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center">${view.stationTotalProject}%</td>
                <td align="center">${view.qjtjTotalGcs}%</td>
                <td align="center">${view.fgTotalSchedule}%</td>
                <td align="center">${view.sbTotalSchedule}%</td>
                <td align="center">${view.stationTotalProject02}</td>
                <td align="center">${view.tzwcMoney}</td>
                <td align="center">${view.stationAllCount}</td>
                <td align="center">${view.ykgStationAllCount}</td>
                <td align="center">${view.dgjAllCount}</td>
                <td align="center">${view.ysfDgjCount}</td>
                <td align="center">${view.projectIntroduction}</td>
                <td align="center">
                    <button class="btn-blue" data-url="<%=basePath%>generalize/generalize-input.do?rowId=${view.rowId}" data-toggle="dialog" data-id="generalize-update" data-mask="true" data-width="500" data-height="900"  data-title="编辑">编辑</button>
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