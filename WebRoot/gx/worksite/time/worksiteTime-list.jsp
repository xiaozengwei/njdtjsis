<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>worksite/worksiteTime-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar" style="line-height:40px">
            <label>工点名称：</label><input type="text" value="${param.filter_LIKES_worksitName}" name="filter_LIKES_worksitName" class="form-control">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            &nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            &nbsp;
            <button type="button" class="btn-green" data-url="<%=basePath%>worksiteTime/worksiteTime-input.do" data-toggle="dialog" data-target="worksite-input" data-id="worksite-input-dialog" data-icon="plus" data-width="400" data-height="300">添加工点时间</button>
            &nbsp;
            <button type="button" class="btn-red" data-url="<%=basePath%>worksiteTime/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中工点时间</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="5%" align="center">序号</th>
            <th width="15%" align="center">工点名称</th>
            <%--<th width="10%" align="center" >工点位置</th>--%>
            <%--<th width="5%" align="center">工点经度</th>--%>
            <%--<th width="5%" align="center" >工点纬度</th>--%>
            <%--<th width="15%" align="center">工点标段</th>--%>
            <%--<th width="15%" align="center">工点简介</th>--%>
            <th width="15%" align="center">时间</th>
            <th width="20%" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="worksite" varStatus="status">
            <tr data-id="${worksite.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${worksite.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center">${worksite.worksitName}</td>
                    <%--<td align="center">${worksite.worksiteAddress}</td>--%>
                    <%--<td align="center">${worksite.worksiteJd}</td>--%>
                    <%--<td align="center">${worksite.worksiteWd}</td>--%>
                <%--<td align="center">${worksite.bdName}</td>--%>
                <%--<td align="center">${worksite.bdIntro}</td>--%>
                <td align="center"><fmt:formatDate value="${worksite.createTime }" pattern="yyyy-MM-dd" /></td>
                <td align="center">
                        <%--<a class="btn btn-blue" href="<%=basePath%>worksite/worksite-add.do" data-toggle="dialog" data-id="worksite-add" data-width="400" data-height="300" data-title="编辑">添加时间节点</a>--%>
                    <a class="btn btn-blue" href="<%=basePath%>worksiteTime/worksiteTime-input.do?rowId=${worksite.rowId}" data-toggle="dialog" data-id="worksite-update" data-width="400" data-height="300" data-title="编辑">编辑</a>
                    <a class="btn btn-default" href="<%=basePath%>worksiteTime/look.do?rowId=${worksite.rowId}" data-toggle="dialog" data-id="worksite-detail" data-width="400" data-height="300" data-title="查看">查看</a>
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