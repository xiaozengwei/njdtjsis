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
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>apk/apk-list.do" method="post">
        <input type="hidden" name="pageSize" value="${page.pageSize}"><!-- 页大小 -->
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}"><!-- 当前页 -->
        <input type="hidden" name="orderField" value="${param.orderField}"><!-- 排序字段 -->
        <input type="hidden" name="orderDirection" value="${param.orderDirection}"><!-- 排序方向 -->
        <button type="button" class="btn-green" data-url="<%=basePath%>apk/apk-input.do" data-toggle="dialog" data-target="apk-input" data-id="apk-input-dialog" data-icon="plus" data-width="800" data-height="800">添加apk</button>
        &nbsp;
        <button type="button" class="btn-red" data-url="<%=basePath%>apk/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>
    </form>
</div>
<div class="bjui-pageContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="7%" align="center">app名称</th>
            <%--<th width="5%" align="center" >app英文名</th>--%>
            <th width="10%" align="center" >版本号</th>
            <%--<th width="10%" align="center" >显示版本号</th>--%>
            <th width="8%" align="center" >发布人</th>
            <th width="8%" align="center" >发布日期</th>
            <th width="7%" align="center" >属性</th>
            <th width="20%" align="center" >更新内容</th>
            <th width="15%" align="center" >操作</th>
        </tr>
        <c:forEach items="${page.result}" var="risk" varStatus="status">
            <tr id="${risk.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${risk.rowId}"></td>
                <td align="center">${risk.appName}</td>
                <%--<td align="center">${risk.appEnName}</td>--%>
                <td align="center">${risk.appVer}</td>
                <%--<td align="center">${risk.appShowVer}</td>--%>
                <td align="center">${risk.publishUser}</td>
                <td align="center">
                    <fmt:formatDate value="${risk.publishDate}" pattern="yyyy-MM-dd HH:mm" />
                </td>
                <td align="center">${risk.status}</td>
                <td align="center">${risk.updtaeContent}</td>
                <td align="center">
                    <button class="btn-blue" data-url="<%=basePath%>apk/apk-input.do?rowId=${risk.rowId}" data-toggle="dialog" data-id="production-update" data-mask="true" data-width="800" data-height="800"  data-title="编辑">编辑</button>
                    &nbsp;&nbsp;
                    <button class="btn-blue" data-url="<%=basePath%>apk/apk-look.do?rowId=${risk.rowId}" data-toggle="dialog" data-id="production-look" data-mask="true" data-width="800" data-height="800"  data-title="查看详情">查看</button>
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