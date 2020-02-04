<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>wl/save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
	 <input type="hidden" name="rowId"  value="${model.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>设备详情</h3></td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">物料种类：</label>
                        <input type="text" name="materialType"  value="${model.materialType}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">物料名称：</label>
                        <input type="text" name="materialName"  value="${model.materialName}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">管理人员：</label>
                        <input type="text" name="managerPerson"  value="${model.managerPerson}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">电话：</label>
                        <input type="text" name="telephone"  value="${model.telephone}" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">型号规格：</label>
                        <input type="text" name="materialModel"  value="${model.materialModel}" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">生产厂家：</label>
                        <input type="text" name="manufacturer"  value="${model.manufacturer}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">进场时间：</label>
                        <input type="text" name="enterTime" value="${model.enterTime }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">进场数量：</label>
                        <input type="text" name="enterNumber"  value="${model.enterNumber}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">计量单位：</label>
                        <input type="text" name="measurementUnit" value="${model.measurementUnit }" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90">使用部位：</label>
                        <input type="text" name="useSite" value="${model.useSite }" size="20">
                	</td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">批号：</label>
                        <input type="text" name="batchNumber" value="${model.batchNumber }" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90">送检状态：</label>
                        <input type="text" name="testStatus" value="${model.testStatus }" size="20">
                	</td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">合格证编号：</label>
                        <input type="text" name="certificateNum" value="${model.certificateNum }" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">自定义信息：</label>
                        <input type="text" name="customMessage" value="${model.customMessage }" size="20">
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
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>