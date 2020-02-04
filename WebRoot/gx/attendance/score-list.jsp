<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
    function opNavtab11(obj,userId,start,end){
        $(obj).navtab({id:'mynavtab', url:'<%=basePath%>score/get-score-detail.do?filter_EQS_userId='+userId+'&filter_GED_recordTime='+start+'&filter_LED_recordTime='+end,title:$(obj).data("title")});
    }
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>score/get-all-score.do" method="post" style="margin-bottom: 0">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
        <div class="bjui-searchBar">
            <br/>
            <label>部门：</label>
            <input tepe="test" id="orgName" name="filter_LIKES_orgName" value="${param.filter_LIKES_orgName}" class="form-control" siz="15">
            <label>姓名：</label>
            <input tepe="test" id="userName" name="filter_LIKES_userName" value="${param.filter_LIKES_userName}" class="form-control" siz="15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <div class="bjui-pageContent tableContent">
        <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
            <thead>
            <tr>
                <th  width="5%"  align="center">序号</th>
                <th  width="10%"  align="center">从</th>
                <th width="10%"  align="center">至</th>
                <th width="5%"  align="center">姓名</th>
                <th width="5%"  align="center">部门</th>
                <th width="5%" align="center">分数</th>
                <th width="10%" align="center">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.result}" var="score" varStatus="status">
                <tr data-id="">

                    <td align="center">${status.count }</td>
                    <td align="center">${score.scoreStart}</td>
                    <td align="center">${score.scoreEnd}</td>
                    <td align="center">${score.userName}</td>
                    <td align="center">${score.orgName}</td>
                    <td align="center">${score.scoreValue}</td>
                    <td align="center">
                        <button data-toggle="navtab" type="button" class="btn-default" style=""  data-title="积分详情"
                                onclick="opNavtab11(this,'${score.userId}','<fmt:formatDate value="${score.scoreStart}" pattern="yyyy-MM-dd HH:mm:ss"/>','<fmt:formatDate value="${score.scoreEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>')" >查看积分详情</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
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