<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>dtyc/save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId" value="${dtYcApply.rowId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">上传人姓名：</label>
                    <input type="text" name="applicantName" value="${dtYcApply.applicantName}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">身份证：</label>
                    <input type="text" name="applicantIdCard" value="${dtYcApply.applicantIdCard}"
                           data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">手机号：</label>
                    <input type="text" name="applicantPhone" value="${dtYcApply.applicantPhone}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">标段：</label>
                    <input type="text" name="bdId" value="${dtYcApply.bdId}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">地点：</label>
                    <input type="text" name="ycAddress" value="${dtYcApply.ycAddress}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">描述：</label>
                    <textarea name="ycMs" data-toggle="autoheight" >${dtYcApply.ycMs}</textarea>
                </td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">意见：</label>
                    <textarea name="clYj" data-toggle="autoheight" >${dtYcApply.clYj}</textarea>
                </td>
            </tr>
            <tr>
                <td id="columnArticleTitlePicForm">
                    <table id="tabelRe" class="table table-bordered table-hover table-striped table-top">
                        <tbody id="tbBody">
                        <tr>
                            <td width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids"
                                                                 data-toggle="icheck"></td>
                            <td align="center" width="30%">文件名称</td>
                            <td align="center" width="35%">上传时间</td>
                            <td align="center" width="15%">上传人</td>
                            <td align="center" width="10%">操作</td>
                        </tr>
                        <c:forEach items="${fileRecordList}" var="fileRecord" varStatus="status">
                            <tr id="${fileRecord.rowId}">
                                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck"
                                                          value="${fileRecord.rowId}"></td>
                                <td align="center">${fileRecord.fileName }</td>
                                <td align="center">${fileRecord.uploadTime}</td>
                                <td align="center">${fileRecord.uploadUserId}</td>
                                <td align="center">
                                    <button type="button" class="btn-blue" data-url="<%=basePath%>dtyc/fileDownload.do?delids=${fileRecord.rowId}" data-toggle="doexport" data-confirm-msg="确定要下载吗？" data-icon="download" >下载文件</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </td>
            </tr>


            </tbody>
        </table>
    </form>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close">关闭</button>
        </li>
        <li>
            <button type="submit" id="submit" class="btn-default">保存</button>
        </li>
    </ul>
</div>

