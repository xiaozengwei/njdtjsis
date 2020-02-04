<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <th width="5%" align="center">排序</th>
            <th height="30" width="5%" align="center">部门</th>
            <th width="5%" align="center">姓名</th>
            <th width="8%" align="center">打卡时间</th>
            <th width="5%" >进出场状态</th>
            <th width="5%">门禁</th>
            <th width="5%" align="center">操作</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${attList}" var="att" varStatus="status">
            <tr data-id="4">
                <td>${status.index+1 }</td>
                <td>${att.orgName}</td>
                <td>${att.userName}</td>
                <td><fmt:formatDate value="${att.signTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${att.signType eq '0' ?"进":"出"}</td>
                <td>${att.doorControlName}</td>
                <td align="center"><button data-url="<%=basePath%>attendance/att-input.do?uniqueId=${att.uniqueId}&userId=${att.userId}&oldTime=${att.signTime}" class="btn-green" data-toggle="dialog"
                                           data-id="sysuser-update" data-width="400" data-height="400"  data-title="编辑" data-icon="edit">编辑</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>
