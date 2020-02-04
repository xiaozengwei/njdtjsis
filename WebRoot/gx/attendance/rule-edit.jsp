<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>attendance/rule-save.do?rowId=${model.rowId}" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="org_row_id"  value="${model.orgRowId}" />
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>规则编辑</h3></td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90">规则规则：</label>
                    <input type="text" name="ruleName"  value="${model.ruleName}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">考勤时间：</label>
                    <input type="text" name="ruleTime"  value="${model.ruleTime}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">考勤周期：</label>
                    <input type="text" name="rulePeriod"  value="${model.rulePeriod}" data-rule="required" size="20">
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label class="control-label x90">考勤地点：</label>--%>
                    <%--<input type="text" name="ruleAddress"  value="${model.ruleAddress}" data-rule="required" size="20">--%>

                <%--</td>--%>

            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label class="control-label x90">性别：</label>--%>
                    <%--<select name="userSex" data-toggle="selectpicker">--%>
                        <%--<option value="1" ${model.userSex eq '1' ? 'selected="selected"':'' }>男</option>--%>
                        <%--<option value="0"  ${model.userSex eq '0' ? 'selected="selected"':'' }>女</option>--%>
                    <%--</select>--%>

                <%--</td>--%>

            <%--</tr>--%>
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