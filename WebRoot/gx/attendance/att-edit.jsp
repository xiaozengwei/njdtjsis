<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>attendance/att-save.do?uniqueId=${att.uniqueId}&userId=${userId}&oldTime=${oldTime}" method="post" data-toggle="validate" data-reloadNavtab="true">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>考勤编辑</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">考勤时间：</label>
                    <input type="text" name="signTime" id="j_custom_issuedate" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" data-rule="datetime" value="<fmt:formatDate value="${att.signTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" data-rule="required" size="20">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>