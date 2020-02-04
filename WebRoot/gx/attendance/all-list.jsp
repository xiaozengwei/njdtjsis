<%@page import="com.gx.soft.sys.persistence.domain.GxSysOrg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
    function opNavtab11(obj,userId,time){
//        var user_row_id=$("#"+user_row_id,$.CurrentNavtab).val()
//        var org_name=$("#"+org_name,$.CurrentNavtab).val()
//        org_name=encodeURI(encodeURI(org_name))
        $(obj).navtab({id:'mynavtab', url:'<%=basePath%>attendance/att-detail-user.do?userId='+userId+'&time='+time,title:$(obj).data("title")});
    }
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>attendance/get-all-att.do" method="post" style="margin-bottom: 0">
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
            <label>状态：</label>
            <select name="filter_LIKES_resultType" data-toggle="selectpicker" id="on">
                <option value="">全部</option>
                <option value="">正常</option>
                <option value="">迟到</option>
                <option value="">早退</option>
                <option value="">旷工半天</option>
                <option value="">旷工全天</option>
            </select>
            <label>姓名：</label>
            <input tepe="test" id="userName" name="filter_LIKES_userName" value="${param.filter_LIKES_userName}" class="form-control" siz="15"><br/><br/>
            <label>开始日期：</label>
            <input type="text" name="filter_GED_attendanceTime"
                   value="${param.filter_GED_attendanceTime}" data-toggle="datepicker"
                   data-rule="date" size="19">&nbsp;&nbsp;
            <label>结束日期：</label>
            <input type="text" name="filter_LED_attendanceTime" id="j_custom_issuedate"
                   data-toggle="datepicker" data-rule="date" size="19"
                   value="${param.filter_LED_attendanceTime}">


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
            <th width="10%">时间</th>
            <th height="20" width="8%" >姓名</th>
            <th width="8%" >部门</th>
            <th width="8%">所属规则</th>
            <th align="center" width="10%">最早</th>
            <th  width="10%">最晚</th>
            <th width="8%">次数</th>
            <th width="8%">工作时长</th>
            <th width="8%">审批单</th>
            <th width="8%">状态</th>
            <th width="8%">校准状态</th>
            <th width="8%">操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${attList}" var="att" varStatus="status">
                <tr data-id="6">
                    <td>${status.index+1}</td>
                    <td >${att.timeA}</td>
                    <td >${att.userName}</td>
                    <td>${att.orgName}</td>
                    <td>${att.rule}</td>
                    <td>${att.morning}</td>
                    <td>${att.evening}</td>
                    <td>${att.count}</td>
                    <td>${att.timeLength}</td>
                    <td>${att.status}</td>
                    <td>${att.result}</td>
                    <td>${att.resultChange}</td>
                    <td><button data-toggle="navtab" type="button" class="btn-default" style=""  data-title="查看详情"
                                onclick="opNavtab11(this,'${att.userId}','${att.timeA}')">查看</button>
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

