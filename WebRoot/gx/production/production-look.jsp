<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>production/production-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${buildProgressRecord.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>完成产值</h3></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${buildProgressRecord.bdId}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${buildProgressRecord.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">合同额度(亿元)：</label>
                    <input type="text" name="htPrice"  value="${buildProgressRecord.htPrice}">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">开累完成(亿元)：</label>
                    <input type="text" name="htCost"  value="${buildProgressRecord.htCost}">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">本月产值(亿元)：</label>
                    <input type="number" name="ext3"  value="${buildProgressRecord.ext3}">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">产值时间：</label>
                    <input  type="text" name="ext1"  value="${buildProgressRecord.ext1}"  data-toggle="datepicker" data-pattern="yyyy-MM" readonly="readonly"  >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">上传时间：</label>
                    <input  type="text" name="createTime"  value="${buildProgressRecord.createTime}"  data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly"  >
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

