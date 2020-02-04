
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageContent tableContent"  >
    <table class="table table-bordered table-hover table-striped table-top table-center" style="border-top:1px #dddddd solid">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <thead>
        <tr>
            <th width="5%">排序</th>
            <th height="30" width="9%" >部门</th>
            <th width="9%" >姓名</th>
            <th width="17%">打卡时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${attList}" var="att" varStatus="status">
            <tr data-id="4">
                <td>${status.index+1 }</td>
                <td>${att.orgName}</td>
                <td>${att.userName}</td>
                <td>${att.attendanceTime}</td>
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
