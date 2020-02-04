<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>wlcount/wlcount-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${materialCount.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>物料使用数量统计</h3></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${materialCount.bdId}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${materialCount.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"   data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">物料类型：</label>
                    <select name="materialType" data-toggle="selectpicker">
                        <option value="钢筋" ${materialCount.materialType eq '钢筋' ? 'selected="selected"':'' }>钢筋</option>
                        <option value="防水材料" ${materialCount.materialType eq '防水材料' ? 'selected="selected"':'' }>防水材料</option>
                        <option value="钢筋网片" ${materialCount.materialType eq '钢筋网片' ? 'selected="selected"':'' }>钢筋网片</option>
                        <option value="水泥" ${materialCount.materialType eq '水泥' ? 'selected="selected"':'' }>水泥</option>
                        <option value="混凝土" ${materialCount.materialType eq '混凝土' ? 'selected="selected"':'' }>混凝土</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">使用数量：</label>
                    <input type="number" name="materialCount" value="${materialCount.materialCount}">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">计量单位：</label>
                    <select name="ext1" data-toggle="selectpicker">
                        <option value="吨" ${materialCount.ext1  eq '吨' ? 'selected="selected"':'' }>吨</option>
                        <option value="平米" ${materialCount.ext1 eq '平米' ? 'selected="selected"':'' }>平米</option>
                        <option value="米" ${materialCount.ext1  eq '米' ? 'selected="selected"':'' }>米</option>
                        <option value="桶" ${materialCount.ext1  eq '桶' ? 'selected="selected"':'' }>桶</option>
                        <option value="卷" ${materialCount.ext1  eq '卷' ? 'selected="selected"':'' }>卷</option>
                    </select>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label class="control-label x90" style="width: 105px;">创建人：</label>--%>
                    <%--<input type="text" name="createName" value="${materialCount.createName}">--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">使用时间：</label>
                    <input  type="text" name="createTime"  value="${materialCount.createTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly" data-rule="required" >
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