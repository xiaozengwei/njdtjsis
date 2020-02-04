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
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>dangerproject/dangerproject-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}"><!-- 页大小 -->
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}"><!-- 当前页 -->
        <input type="hidden" name="orderField" value="${param.orderField}"><!-- 排序字段 -->
        <input type="hidden" name="orderDirection" value="${param.orderDirection}"><!-- 排序方向 -->
        <label>工程地址：</label><input type="text" value="${param.filter_LIKES_projectAddress}" name="filter_LIKES_projectAddress" class="form-control">&nbsp;
        <button type="submit" class="btn-default" data-icon="search">查询</button>
        &nbsp;
        <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        &nbsp;
        <button type="button" class="btn-green" data-url="<%=basePath%>dangerproject/dangerproject-input.do" data-toggle="dialog" data-target="dangerproject-input" data-id="dangerproject-input-dialog" data-icon="plus" data-width="400" data-height="400">添加危大工程</button>
        &nbsp;
        <button type="button" class="btn-red" data-url="<%=basePath%>dangerproject/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>
    </form>
</div>
<div class="bjui-pageContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="10%" align="center">标段</th>
            <th width="10%" align="center" >工程地点</th>
            <th width="10%" align="center" >分部分项工程类别</th>
            <th width="10%" align="center" >分部分项工程名称</th>
            <th width="5%" align="center" >分部分项工程参数</th>
            <th width="3%" align="center" > 是否超过一定规模</th>
            <th width="5%" align="center" >方案审批情况</th>
            <th width="10%" align="center" >计划开工日期</th>
            <th width="10%" align="center" >计划完工日期</th>
            <th width="5%" align="center" >目前状态</th>
            <th width="5%" align="center" >责任人</th>
            <th width="15%" align="center" >操作</th>
        </tr>
        <c:forEach items="${page.result}" var="risk" varStatus="status">
            <tr id="${risk.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${risk.rowId}"></td>
                <td align="center">${risk.bdName}</td>
                <td align="center">${risk.projectAddress}</td>
                <td align="center">${risk.fbProjectType}</td>
                <td align="center">${risk.fbProjectName}</td>
                <td align="center">${risk.fbProjectParameter}</td>
                <td align="center">${risk.ext1}</td>
                <td align="center">${risk.faSpQk}</td>
                <td align="center">
                    <fmt:formatDate value="${risk.kgTime}" pattern="yyyy-MM" />
                </td>
                <td align="center">
                    <fmt:formatDate value="${risk.wgTime}" pattern="yyyy-MM" />
                </td>
                <td align="center">${risk.nowType}</td>
                <td align="center">${risk.personCharge}</td>
                <td align="center">
                    <button class="btn-blue" data-url="<%=basePath%>dangerproject/dangerproject-input.do?rowId=${risk.rowId}" data-toggle="dialog" data-id="production-update" data-mask="true" data-width="400" data-height="400"  data-title="编辑">编辑</button>
                    &nbsp;&nbsp;
                    <button class="btn-blue" data-url="<%=basePath%>dangerproject/look.do?rowId=${risk.rowId}" data-toggle="dialog" data-id="production-look" data-mask="true" data-width="400" data-height="400"  data-title="查看详情">查看</button>
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