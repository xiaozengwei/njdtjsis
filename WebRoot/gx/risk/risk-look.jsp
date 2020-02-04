<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>risk/risk-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${builddgPadDay.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>重大风险</h3></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${builddgPadDay.bdId}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${builddgPadDay.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">潜在危险因素：</label>
                    <input type="text" name="dgReson"  readonly="readonly" value="${builddgPadDay.dgReson}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">可能导致的事故：</label>
                    <input type="text" name="dgSg"  readonly="readonly" value="${builddgPadDay.dgSg}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">风险度：</label>
                    <select data-toggle="selectpicker" name="dgLevel"  value="${builddgPadDay.dgLevel}" disabled="disabled">
                        <option value="I">I</option>
                        <option value="II">II</option>
                        <option value="III">III</option>
                        <option value="IV">IV</option>
                        <option value="V">V</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">控制措施：</label>
                    <input type="text" name="contrlAnswer" readonly="readonly"  value="${builddgPadDay.contrlAnswer}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">受控时间：</label>
                    <select data-toggle="selectpicker" name="contrlTime"  value="${builddgPadDay.contrlTime}" data-rule="required" disabled="disabled">
                        <option value="全过程">全过程</option>
                        <option value="半过程">半过程</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">施工负责人：</label>
                    <input type="text" name="buildManager" readonly="readonly"  value="${builddgPadDay.buildManager}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">班组分组人：</label>
                    <input type="text" name="levelManager"  readonly="readonly" value="${builddgPadDay.levelManager}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">安全负责人：</label>
                    <input type="text" name="safeManager" readonly="readonly" value="${builddgPadDay.safeManager}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">开始日期：</label>
                    <input   class="time" type="text" name="startTime" readonly="readonly" value="${startTime }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" data-onlybtn="true" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">结束日期：</label>
                    <input   class="time" type="text" name="endTime" readonly="readonly" value="${endTime}" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" data-onlybtn="true" >
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

