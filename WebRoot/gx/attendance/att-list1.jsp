<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
    function opNavtab11(obj,userId,time){
        $(obj).navtab({id:'mynavtab1', url:'<%=basePath%>attendance/att-detail1.do?userId='+userId+'&time='+time,title:$(obj).data("title")});
    }
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>attendance/att-list1.do" method="post" style="margin-bottom: 0">
        <%--<input type="hidden" name="pageSize" value="${page.pageSize}">--%>
        <%--<input type="hidden" name="pageCurrent" value="${page.pageCurrent}">--%>
        <%--<input type="hidden" name="orderField" value="${param.orderField}">--%>
        <%--<input type="hidden" name="orderDirection"--%>
        <%--value="${param.orderDirection}">--%>
        <div class="bjui-searchBar">
            <br/>
            <label>部门：</label>
            <input tepe="test" id="orgName" name="filter_LIKES_orgName" value="${param.filter_LIKES_orgName}" class="form-control" siz="15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>状态：</label>
            <select name="filter_LIKES_resultType" data-toggle="selectpicker" id="on">
                <option value="">全部</option>
                <option value="正常" ${param.filter_LIKES_resultType eq '正常'?'selected':''}>正常</option>
                <option value="迟到" ${param.filter_LIKES_resultType eq '迟到'?'selected':''}>迟到</option>
                <option value="早退" ${param.filter_LIKES_resultType eq '早退'?'selected':''}>早退</option>
                <option value="缺勤半天" ${param.filter_LIKES_resultType eq '缺勤半天'?'selected':''}>缺勤半天</option>
                <option value="缺勤全天" ${param.filter_LIKES_resultType eq '缺勤全天'?'selected':''}>缺勤全天</option>
            </select>
            <label>姓名：</label>
            <input tepe="test" id="userName" name="filter_LIKES_userName" value="${param.filter_LIKES_userName}" class="form-control" siz="15"><br/><br/>
            <label>开始日期：</label>
            <input type="text" name="filter_GED_signTime"
                   value="${param.filter_GED_signTime}" data-toggle="datepicker"
                   data-rule="date" size="19">&nbsp;&nbsp;
            <label>结束日期：</label>
            <input type="text" name="filter_LED_signTime" id="j_custom_issuedate"
                   data-toggle="datepicker" data-rule="date" size="19"
                   value="${param.filter_LED_signTime}">


            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent"  >
    <table class="table table-bordered table-hover table-striped table-top table-center" data-selected-multi="true" align="center" style="border-top:1px #dddddd solid">
        <thead>
        <tr>
            <th width="5%">排序</th>
            <th width="5%">时间</th>
            <th width="8%" >姓名</th>
            <th width="8%" >部门</th>
            <th width="8%">门禁</th>
            <th width="5%">所属规则</th>
            <th width="6%">进</th>
            <th width="6%">出</th>
            <th width="5%">次数</th>
            <th width="5%">工作时长</th>
            <th width="5%">审批单</th>
            <th width="5%">状态</th>
            <th width="5%">校准状态</th>
            <th width="5%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="att" varStatus="status">
            <tr data-id="6">
                <td>${status.index+1}</td>
                <td >${att.signTime}</td>
                <td >${att.userName}</td>
                <td>${att.orgName}</td>
                <td>${att.doorControlName}</td>
                <td>${att.ruleName}</td>
                <td><fmt:formatDate value="${att.earlyTime}" pattern="HH:mm:ss"/></td>
                <td><fmt:formatDate value="${att.lastTime}" pattern="HH:mm:ss"/></td>
                <td>${att.count}</td>
                <td>${att.workTime}</td>
                <td>${att.resultKey}</td>
                <td>${att.resultType}</td>
                <td>${att.resultCheckType}</td>
                <td>
                    <button data-toggle="navtab" type="button" class="btn-green" data-icon="edit" data-title="考勤详情管理"
                            onclick="opNavtab11(this,'${att.userId}','${att.signTime}')">编辑</button>
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
         data-page-size="${page.pageSize}" data-page-current="${page.pageCurrent }"></div>
</div>

