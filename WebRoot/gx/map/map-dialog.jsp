<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="bjui-pageContent">
    <div class="bjui-doc">
        <h3 class="page-header">人员详细信息</h3>
    </div>
    <table class="table table-condensed table-hover">
        <tbody>
        <tr>
            <td>
                <label class="control-label x90" style="width: 105px;">姓名：</label>
                <input type="text"   value="${mapRecord.userName}" data-rule="required">
            </td>
            <td>
                <label class="control-label x90" style="width: 105px;">手机号：</label>
                <input type="text"   value="${mapRecord.personPhone}" data-rule="required">
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>