<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>dic/dic-index-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
    	<input name="rowId" type="hidden" value="${model.rowId }"/>
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td colspan="2" align="center"><h3>数据字典添加</h3></td>
                </tr>
                
                <tr>
                	<td>
                        <label for="j_dialog_rolename" class="control-label x90">字典名称：</label>
                        <input type="text" name="dicFunctionName"  value="${model.dicFunctionName}" data-rule="required" size="20">
                    </td>
                    <td>
                        <label for="j_dialog_roleid" class="control-label x90">字典功能Id：</label>
                        <input type="text" name="dicFunctionId" value="${model.dicFunctionId}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label for="j_dialog_roletype" class="control-label x90">字典类型：</label>
                        <input type="text" name="dicFunctionType" value="${model.dicFunctionType}" data-rule="required" size="20">
                    </td>
                    <td>
                        <label for="j_dialog_parentrolename" class="control-label x90">字典显示内容：</label>
                        <textarea cols="30" rows="1" data-toggle="autoheight"  name="dicFunctionDec">${model.dicFunctionDec }</textarea>
                    </td>
                </tr>
                <tr>
                	<td>
                		<label for="j_dialog_dataorder" class="control-label x90">字典状态：</label>
                        <input type="text" name="status" value="${model.status }" data-rule="" size="20">
                	</td>
                	<td>
                		<label for="j_dialog_roleintro" class="control-label x90">排序：</label>
                        <input type="text" name="orderNum" value="${model.orderNum }" data-rule="number" size="20">
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