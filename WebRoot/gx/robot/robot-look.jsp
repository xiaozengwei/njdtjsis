<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form id="ff" action="<%=basePath%>robotWeb/robot-save.do" method="post" data-toggle="validate" data-reloadNavtab="true" >
        <input type="hidden" name="rowId"  value="${robotWords.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${builddgPadDay.bdId}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">词组类别：</label>
                    <input type="text" name="rwordsType"  value="${robotWords.rwordsType}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">问句词组：</label>
                    <input type="text" name="askRwords"  value="${robotWords.askRwords}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">下一词组猜想：</label>
                    <input type="text" name="nextRwords"  value="${robotWords.nextRwords}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">词组状态：</label>
                    <input type="text" name="rwordsStatus"  value="${robotWords.rwordsStatus}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">回复词组：</label>
                    <input type="text" name="answerRwords"  value="${robotWords.answerRwords}"  size="20">
                </td>
            </tr>
            </tbody>
        </table>
    </form>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>

