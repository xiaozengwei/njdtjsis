<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<html>
<head>
    <title>设备信息</title>
    <meta name="viewport"  content="width=device-width,minimum-scale=1.0, maximum-scale=2.0; charset=UTF-8">
    <style>
        .titlebg{background: #f3f3f3;}
        .bordertable{ border: 1px #e5e5e5 solid; border-collapse: collapse;width: 100%;}
        .bordertable td{ border: 1px #e5e5e5 solid; border-collapse: collapse; height: 48px;padding: 5px;}
    </style>
</head>
<body style="text-align: center;margin: 0px;padding: 0px;">
<div style="margin:0 auto;width: 100%;">
    <table  class="bordertable" cellpadding="0" cellspacing="0">
        <tr style="border-bottom: 1px black solid;">
            <td width="40%" class="titlebg" align="right">驾驶员：</td>
            <td width="60%" align="left">${equipmentInfo.driverName}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">电话：</td>
            <td align="left">${equipmentInfo.telephone}</td>
        </tr>
        <tr>
            <td align="right"class="titlebg">设备种类：</td>
            <td align="left">${equipmentInfo.sbZl}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">设备类别：</td>
            <td align="left">${equipmentInfo.equipmentType}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">设备名称：</td>
            <td align="left">${equipmentInfo.equipmentName}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">型号：</td>
            <td align="left">${equipmentInfo.equipmentModel}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">隶属单位：</td>
            <td align="left">${equipmentInfo.lsDw}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">进场时间：</td>
            <td align="left">${equipmentInfo.enterTime}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">管理编号：</td>
            <td align="left">${equipmentInfo.managerNum}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">自定义信息：</td>
            <td align="left">${equipmentInfo.customMessage}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">是否报检：</td>
            <td align="left">${equipmentInfo.isTest}</td>
        </tr>
        <tr>
            <td align="right" class="titlebg">工作状态：</td>
            <td align="left">${equipmentInfo.workStatus}</td>
        </tr>
        <c:forEach items="${fileList}" var="file">
            <tr>
                <td colspan="2" width="100%"><img src="<%=basePath%>fileRecord/fileDownload.do?fileId=${file.rowId}" width="100%"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
