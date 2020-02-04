<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>view/view-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${deviceCameraRecord.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>视屏添加</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">物理地址：</label>
                    <input type="text" name="wlAddress"  value="${deviceCameraRecord.wlAddress}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">hls-url-地址：</label>
                    <input type="text" name="hlsLcAddress"  value="${deviceCameraRecord.hlsLcAddress}" data-rule="required" size="20">
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label class="control-label x90" style="width: 105px;">公司ID：</label>--%>
                    <%--<input type="text" name="comId"  value="${deviceCameraRecord.comId}" data-rule="required" size="20">--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">标段ID：</label>
                    <input type="text" name="bdId"  value="${deviceCameraRecord.bdId}" data-rule="required" size="20">
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