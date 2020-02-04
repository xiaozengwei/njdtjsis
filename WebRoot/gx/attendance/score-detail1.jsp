<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>score/get-score-detail1.do" method="post" style="margin-bottom: 0">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <input type="hidden" name="orderDirection"
               value="${param.orderDirection}">
        <input type="hidden" name="filter_EQS_userId" value="${param.filter_EQS_userId}">
        <input type="hidden" name="filter_GED_recordTime" value="${param.filter_GED_recordTime}">
        <input type="hidden" name="filter_LED_recordTime" value="${param.filter_LED_recordTime}">
        <%--<input type="hidden" name="userName" value="${userName}">--%>
        <%--<input type="hidden" name="userId" value="${userId}">--%>
        <div class="bjui-searchBar">
            <br/>
            <label>状态：</label>
            <select name="filter_LIKES_recordType" data-toggle="selectpicker" id="on">
                <option value="">全部</option>
                <option value="正常" ${param.filter_LIKES_recordType eq '正常'?'selected':''}>正常</option>
                <option value="迟到" ${param.filter_LIKES_recordType eq '迟到'?'selected':''}>迟到</option>
                <option value="早退" ${param.filter_LIKES_recordType eq '早退'?'selected':''}>早退</option>
                <option value="缺勤半天" ${param.filter_LIKES_recordType eq '缺勤半天'?'selected':''}>缺勤半天</option>
                <option value="缺勤全天" ${param.filter_LIKES_recordType eq '缺勤全天'?'selected':''}>缺勤全天</option>
            </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                <button type="button" class="btn-green" data-toggle="dialog" data-target="score-input" data-url="<%=basePath%>score/score-input.do?name=${name}&userId=${userId}" data-id="role-input-dialog"  data-icon="plus" data-width="400" data-height="400">添加考勤积分</button>&nbsp;
                <button type="button" class="btn-blue"  data-url="<%=basePath %>score/score-remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中</button>
            </div>
        </div>


    </form>
</div>


<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th width="3%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th  width="4%"  align="center">序号</th>
            <th  width="10%"  align="center">时间</th>
            <th  width="8%"  align="center">姓名</th>
            <th width="8%"  align="center">部门</th>
            <th width="8%" align="center">积分</th>
            <th width="8%" align="center">状态</th>
            <th width="8%" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${scoreList}" var="score" varStatus="status">
            <tr data-id="">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${score.scoreKey}"></td>
                <td align="center">${status.count}</td>
                <td align="center">${score.recordTime}</td>
                <td align="center">${score.userName}</td>
                <td align="center">${score.orgName}</td>
                <td align="center">${score.recordScore}</td>
                <td align="center">${score.recordType}</td>
                <td align="center"><button data-url="<%=basePath%>score/score-input.do?scoreKey=${score.scoreKey}&name=${name}&userId=${userId}" class="btn-green" data-toggle="dialog"
                            data-id="sysuser-update" data-width="400" data-height="400"  data-title="编辑" data-icon="edit">编辑</button></td>
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