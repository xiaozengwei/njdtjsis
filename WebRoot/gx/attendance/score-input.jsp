<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">

<div class="bjui-pageContent">
    <form action="<%=basePath%>score/score-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${model.rowId}" />
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>积分添加</h3></td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90">用户名：</label>
                    <input type="text" name="userName" value="${name}" data-rule="required" size="20" readonly="readonly" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">登录名：</label>
                    <input type="text" name="userId"  value="${userId}" data-rule="required" size="20" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">分数：</label>
                    <input type="test" name="recordScore" value="${model.recordScore}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">时间：</label>
                    <input type="text" name="recordTime" id="j_custom_issuedate" value="${model.recordTime}" data-toggle="datepicker" data-rule="date" size="19">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">类型：</label>
                    <select name="recordType" data-toggle="selectpicker" id="sc">
                        <option value="正常" ${model.recordType eq '正常' ? 'selected':'' }>正常</option>
                        <option value="迟到" ${model.recordType eq '迟到' ? 'selected':'' }>迟到</option>
                        <option value="早退" ${model.recordType eq '早退' ? 'selected':'' }>早退</option>
                        <option value="缺勤半天" ${model.recordType eq '缺勤半天' ? 'selected':'' }>缺勤半天</option>
                        <option value="缺勤全天" ${model.recordType eq '缺勤全天' ? 'selected':'' }>缺勤全天</option>
                    </select>

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