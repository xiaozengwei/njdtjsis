<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>attendance/get-all-rule.do" method="post" style="margin-bottom: 0">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection"
               value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <br/>
            <label>部门：</label>
            <input tepe="test" id="orgName" name="filter_LIKES_orgName" value="${param.filter_LIKES_orgName}" class="form-control" siz="15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                <button type="button" class="btn-green" data-url="<%=basePath%>attendance/rule-input.do"  data-toggle="dialog" data-target="sysorg-input" data-id="role-input-dialog"  data-icon="plus" data-width="400" data-height="400">添加规则</button>&nbsp;
                <button type="button" class="btn-blue"  data-url="<%=basePath %>attendance/rule-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent"  >
    <table class="table table-bordered table-hover table-striped table-top table-center" data-selected-multi="true" align="center" style="border-top:1px #dddddd solid">
        <thead>
        <tr>
            <th width="3%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="5%">排序</th>
            <th width="10%">部门</th>
            <th width="8%" >考勤规则</th>
            <th width="8%">考勤时间</th>
            <th align="center" width="10%">考勤周期</th>
            <th width="8%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ruleList}" var="rule" varStatus="status">
            <tr data-id="5">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${rule.rowId}"></td>
                <td>${status.index+1}</td>
                <td>${rule.orgName}</td>
                <%--<td>${rule.ruleAddress}</td>--%>
                <td>${rule.ruleName}</td>
                <td>${rule.ruleTime}</td>
                <td>${rule.rulePeriod}</td>
                <td><button data-url="<%=basePath%>attendance/rule-input.do?orgRowId=${rule.orgRowId}" class="btn-green" data-toggle="dialog"
                            data-id="sysuser-update" data-width="400" data-height="400"  data-title="编辑" data-icon="edit">编辑</button>
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

