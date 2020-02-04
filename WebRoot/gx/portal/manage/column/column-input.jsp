<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>portal/manager/column/save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
    	<input type="hidden" name="rowId" value="${model.rowId}"/>
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>栏目添加</h3></td>
                </tr>
                
                <tr>
                	<td>
                        <label class="control-label x90">栏目名称：</label>
                        <input type="text" name="columnName"  value="${model.columnName}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">栏目类别：</label>
                        <input type="text" name="columnType"  value="${model.columnType}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">父组织：</label>
                        <input type="hidden" name="parentId"  value="${empty model.parentId ? 'root' : model.parentId}" >
                        <input type="text" name="parentName"  value="${model.parentName}" data-toggle="lookup" data-url="<%=basePath %>portal/manage/colum/lookup/list.do" size="20" data-title="请选择父组织">
                        
                    </td>
                   
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90">排序：</label>
                        <input type="text" name="orderNum" value="${model.orderNum }" data-rule="required;number" size="20">
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