<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sysuser/user-save1.do?orgId=${orgId}" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="rowId"  value="${model.rowId}" />
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h4>人员添加</h4></td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90">用户名：</label>
                    <input type="text" name="userName"  value="${model.userName}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">显示名：</label>
                    <input type="text" name="userShowName"  value="${model.userShowName}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">登录名：</label>
                    <input type="text" name="userId"  value="${model.userId}" data-rule="required" size="20" ${orgId==null?"readonly='readonly'":""}>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">密码：</label>
                    <input type="password" name="userEnName"  value="${model.userEnName}" data-rule="required" >

                </td>

            </tr>
            <tr>
                <td>
                    <label class="control-label x90">性别：</label>
                    <select name="userSex" data-toggle="selectpicker">
                        <option value="1" ${model.userSex eq '1' ? 'selected="selected"':'' }>男</option>
                        <option value="0"  ${model.userSex eq '0' ? 'selected="selected"':'' }>女</option>
                    </select>

                </td>

            </tr>
            <tr>
                <td>
                    <label class="control-label x90">用户类型：</label>
                    <input type="text" name="userType"  value="${model.userType}"  size="20">
                </td>

            </tr>
            <tr>
                <td>
                    <label class="control-label x90">手机号：</label>
                    <input type="text" name="userMobileNum"  value="${model.userMobileNum}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">身份证：</label>
                    <input type="text" name="userCardId"  value="${model.userCardId}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">卡号：</label>
                    <input type="text" name="cardNo"  value="${model.cardNo}"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">用户级别：</label>
                    <input type="text" name="userLevel"  value="${model.userLevel}"  size="20">

                </td>

            </tr><%--
                <tr>
                	<td>
                		<label class="control-label x90">排序：</label>
                        <input type="text" name="dataOrder"  value="${model.dataOrder }" data-rule="number" size="20">
                	</td>

                </tr>

            --%></tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>