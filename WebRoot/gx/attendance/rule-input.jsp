<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>attendance/rule-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>规则添加</h3></td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90">组织：</label>
                    <input type="hidden" name="orgId">
                    <input type="hidden" name="comBdId">
                    <input type="text" name="orgName" data-toggle="lookup" data-url="<%=basePath %>attendance/lookup-org-list.do" data-rule="required" size="20" readonly="readonly" data-title="请选择组织">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">规则规则：</label>
                    <input type="text" name="ruleName" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">考勤时间：</label>
                    <input type="text" name="ruleTime" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">考勤周期：</label>
                    <input type="text" name="rulePeriod" size="20">
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