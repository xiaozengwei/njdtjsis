<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>manager/manager-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${sensorIndex.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>传感器指数</h3></td>
            </tr>
            <tr>
                <td>
                    <%--<input type="hidden" name="sensorSiteId"  value="${sensorIndex.sensorSiteId}" >--%>
                    <label class="control-label x90" style="width: 105px;">传感器站名：</label>
                    <%--<input type="text" name="sensorSiteName"  readonly="readonly" value="${sensorIndex.sensorSiteName}" data-toggle="lookup" data-url="<%=basePath %>sensor/lookup-sensor-list.do"  size="20" data-title="请选择传感器名称:" >--%>
                    <input type="text" name="sensorSiteName"   value="${sensorIndex.sensorSiteName}"  >

                </td>
            </tr>
            <tr>
                <td>
                    <%--<input type="hidden" name="sensorSiteId"  value="${sensorIndex.sensorSiteId}" >--%>
                    <label class="control-label x90" style="width: 105px;">传感器ID：</label>
                    <%--<input type="text" name="sensorSiteName"  readonly="readonly" value="${sensorIndex.sensorSiteName}" data-toggle="lookup" data-url="<%=basePath %>sensor/lookup-sensor-list.do"  size="20" data-title="请选择传感器名称:" >--%>
                    <input type="text" name="sensorSiteId"   value="${sensorIndex.sensorSiteId}"  >

                </td>
            </tr>
            <tr>
                <td>
                    <%--<input type="hidden" name="sensorSiteId"  value="${sensorIndex.sensorSiteId}" >--%>
                    <label class="control-label x90" style="width: 105px;">传感器地址：</label>
                    <%--<input type="text" name="sensorSiteName"  readonly="readonly" value="${sensorIndex.sensorSiteName}" data-toggle="lookup" data-url="<%=basePath %>sensor/lookup-sensor-list.do"  size="20" data-title="请选择传感器名称:" >--%>
                    <input type="text" name="sensorSiteAddress"   value="${sensorIndex.sensorSiteAddress}"  >

                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">传感器类别：</label>
                    <%--<input type="text" name="sensorSiteType"  readonly="readonly" value="${sensorIndex.sensorSiteType}" data-toggle="lookup" data-url="<%=basePath %>sensor/lookup-sensor-list-type.do"  size="20" data-title="请选择传感器类别:" >--%>
                    <input type="text" name="sensorSiteType"  value="${sensorIndex.sensorSiteType}"  >
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${sensorIndex.sensorSiteBdId}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${sensorIndex.sensorSiteBd}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
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

