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
                        <label class="control-label x90">强度等级：</label>
                        <select name="strengthGrade" data-toggle="selectpicker" data-width="70">
                            <option value="C20" ${model.strengthGrade eq 'C20' ? 'selected="selected"':'' }>C20</option>
                            <option value="C30" ${model.strengthGrade eq 'C30' ? 'selected="selected"':'' }>C30</option>
                            <option value="C35" ${model.strengthGrade eq 'C35' ? 'selected="selected"':'' }>C35</option>
                            <option value="C35水下" ${model.strengthGrade eq 'C35水下' ? 'selected="selected"':'' }>C35水下</option>
                            <option value="C40微膨胀混凝土" ${model.strengthGrade eq 'C40微膨胀混凝土' ? 'selected="selected"':'' }>C40微膨胀混凝土</option>
                            <option value="C50" ${model.strengthGrade eq 'C50' ? 'selected="selected"':'' }>C50</option>
                        </select>
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
                        <input type="text" name="enterTime" value="<fmt:formatDate value='${model.enterTime }' pattern='yyyy-MM-dd' />" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly">
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
                        <input type="text" name="measurementUnit"  value="${model.measurementUnit}" size="20">
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
                        <label class="control-label x90">养护条件：</label>
                        <select name="curingCondition" data-toggle="selectpicker" >
                            <option value="同养" ${model.curingCondition eq '同养' ? 'selected="selected"':'' }>同养</option>
                            <option value="标养" ${model.curingCondition eq '标养' ? 'selected="selected"':'' }>标养</option>
                        </select>
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
                        <label class="control-label x90">报告编号：</label>
                        <input type="text" name="reportNumber" value="${model.reportNumber }" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">检测项目：</label>
                        <select name="testItem" data-toggle="selectpicker" >
                            <option value="抗压" ${model.testItem eq '抗压' ? 'selected="selected"':'' }>抗压</option>
                            <option value="抗渗" ${model.testItem eq '抗渗' ? 'selected="selected"':'' }>抗渗</option>
                        </select>
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