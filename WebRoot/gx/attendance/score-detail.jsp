<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="bjui-pageContent">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>score/get-score-detail.do" method="post" style="margin-bottom: 0">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderDirection"
               value="${param.orderDirection}">
        <input type="hidden" name="filter_EQS_userId" value="${param.filter_EQS_userId}">
        <input type="hidden" name="filter_GED_recordTime" value="${param.filter_GED_recordTime}">
        <input type="hidden" name="filter_LED_recordTime" value="${param.filter_LED_recordTime}">
    </form>
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th  width="4%"  align="center">序号</th>
            <th  width="10%"  align="center">时间</th>
            <th  width="8%"  align="center">姓名</th>
            <th width="8%"  align="center">部门</th>
            <th width="8%" align="center">积分</th>
            <th width="8%" align="center">状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${scoreList}" var="score" varStatus="status">
            <tr data-id="">
                <td align="center">${status.count}</td>
                <td align="center">${score.recordTime}</td>
                <td align="center">${score.userName}</td>
                <td align="center">${score.orgName}</td>
                <td align="center">${score.recordScore}</td>
                <td align="center">${score.recordType}</td>
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