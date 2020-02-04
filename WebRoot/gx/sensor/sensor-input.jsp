<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sensor/sensor-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${sensorDataRecordHistory.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>传感器指数</h3></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="sensorSiteId"  value="${sensorDataRecordHistory.sensorSiteId}" >
                    <label class="control-label x90" style="width: 105px;">传感器站名：</label>
                    <input type="text" name="sensorSiteName"  readonly="readonly" value="${sensorDataRecordHistory.sensorSiteName}" data-toggle="lookup" data-url="<%=basePath %>sensor/lookup-sensor-list.do"  size="20" data-title="请选择传感器名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">传感器类别：</label>
                    <input type="text" name="sensorSiteType"  readonly="readonly" value="${sensorDataRecordHistory.sensorSiteType}" data-toggle="lookup" data-url="<%=basePath %>sensor/lookup-sensor-list-type.do"  size="20" data-title="请选择传感器类别:" >
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${sensorDataRecordHistory.sensorSiteBd}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${sensorDataRecordHistory.sensorSiteName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">PM2.5：</label>
                    <input type="text" name="sensorDataPm25"  value="${sensorDataRecordHistory.sensorDataPm25}" oninput="value=value.replace(/[^\d]/g,'')" placeholder="只能输入数字">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">PM10：</label>
                    <input type="text" name="sensorDataPm10"  value="${sensorDataRecordHistory.sensorDataPm10}" oninput="value=value.replace(/[^\d]/g,'')" placeholder="只能输入数字">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">湿度：</label>
                    <input type="text" name="sensorDataHumidity"  value="${sensorDataRecordHistory.sensorDataHumidity}" oninput="value=value.replace(/[^\d]/g,'')" placeholder="只能输入数字">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">温度：</label>
                    <input type="text" name="sensorDataTemperature"  value="${sensorDataRecordHistory.sensorDataTemperature}"  oninput="value=value.replace(/[^\d]/g,'')" placeholder="只能输入数字">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">风速：</label>
                    <input type="text" name="sensorDataWindSpeed"  value="${sensorDataRecordHistory.sensorDataWindSpeed}" oninput="value=value.replace(/[^\d]/g,'')" placeholder="只能输入数字">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">风向：</label>
                    <input type="text" name="sensorDataWindDirection"  value="${sensorDataRecordHistory.sensorDataWindDirection}">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">噪音：</label>
                    <input type="text" name="sensorDataExt1"  value="${sensorDataRecordHistory.sensorDataExt1}">
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

