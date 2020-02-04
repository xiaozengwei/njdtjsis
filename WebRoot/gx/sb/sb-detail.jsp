<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sb/sb-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
	 <input type="hidden" name="rowId"  value="${equipmentInfo.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>设备详细</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">驾驶员：</label>
                    <input type="text" name="driverName"  value="${equipmentInfo.driverName}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">电话：</label>
                    <input type="text" name="telephone"  value="${equipmentInfo.telephone}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">设备种类：</label>
                    <input type="text" name="sbZl"  value="${equipmentInfo.sbZl}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">设备类别：</label>
                    <input type="text" name="equipmentType"  value="${equipmentInfo.equipmentType}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">设备名称：</label>
                    <input type="text" name="equipmentName"  value="${equipmentInfo.equipmentName}" size="20">
                </td>

            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">型号：</label>
                    <input type="text" name="equipmentModel"  value="${equipmentInfo.equipmentModel}" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">隶属单位：</label>
                    <input type="text" name="lsDw" value="${equipmentInfo.lsDw }" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">进场时间：</label>
                    <input type="text" name="enterTime" value="${equipmentInfo.enterTime }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">管理编号：</label>
                    <input type="text" name="managerNum" value="${equipmentInfo.managerNum }" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">自定义信息：</label>
                    <input type="text" name="customMessage" value="${equipmentInfo.customMessage }" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">是否报检：</label>
                    <input type="text" name="customMessage" value="${equipmentInfo.isTest }" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">工作状态：</label>
                    <input type="text" name="customMessage" value="${equipmentInfo.workStatus }" size="20">
                </td>
            </tr>
            <tr>
                <table class="table table-bordered table-hover table-striped table-top" id="attachmentTab">
                    <tr>
                        <th align="center" width="60%">附件名称</th>
                        <th align="center" width="40%">上传时间</th>
                    </tr>
                    <c:forEach items="${fileList}" var="file">
                        <tr>
                            <td align="center"><a href="<%=path %>/fileRecord/fileDownload.do?fileId=${file.rowId}">${file.fileName}</a></td>
                            <td align="center"><fmt:formatDate value="${file.uploadTime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                        </tr>
                    </c:forEach>
                </table>
            </tr>
            <tr>
                <td align="center">
                    <img src="<%=basePath%>sb/QR-code-show.do?rowId=${equipmentInfo.rowId}">
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