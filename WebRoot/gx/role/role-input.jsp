<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>role/role-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
    	<input name="rowId" type="hidden" value="${model.rowId }"/>
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td colspan="2" align="center"><h3>角色添加</h3></td>
                </tr>
                
                <tr>
                	<td>
                        <label for="j_dialog_rolename" class="control-label x90">角色名称：</label>
                        <input type="text" name="roleName" id="j_dialog_rolename" value="${model.roleName}" data-rule="required" size="20">
                    </td>
                    <td>
                        <label for="j_dialog_roleid" class="control-label x90">角色Id：</label>
                        <input type="text" name="roleId" id="j_dialog_roleid" value="${model.roleId}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label for="j_dialog_roletype" class="control-label x90">角色类型：</label>
                        <select name="roleType" id="j_dialog_roletype" data-toggle="selectpicker" size="30">
                            <option value="0">非系统角色</option>
                            <option value="1" selected>系统角色</option>
                        </select>
                    </td>
                    <td>
                        <label for="j_dialog_parentrolename" class="control-label x90">父角色：</label>
                        <input type="hidden" name="parentRoleId" value="root">
                        <input type="text" name="parentRoleName" value="root" class="form-control" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                		<label for="j_dialog_dataorder" class="control-label x90">角色排序：</label>
                        <input type="text" name="dataOrder" id="j_dialog_dataorder" value="${model.dataOrder }" data-rule="required;number" size="20">
                	</td>
                	<td>
                		<label for="j_dialog_roleintro" class="control-label x90">角色说明：</label>
                		<textarea name="roleIntro" id="j_dialog_dataorder" cols="30">${model.roleIntro}</textarea>
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