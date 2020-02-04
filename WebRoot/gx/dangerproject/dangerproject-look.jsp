<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
//    $(function () {
//        $("#startTime").blur(function(){
//            if($("#endTime").val().length!=0){
//                if( $("#endTime").val()<$("#startTime").val()){
//                    $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
//                    $("#submit").attr('disabled',true);
//                }else{
//                    $("#submit").attr('disabled',false);
//                }
//            }
//
//            $("#endTime").blur(function(){
//                if( $("#endTime").val()<$("#startTime").val()){
//                    $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
//                    $("#submit").attr('disabled',true);
//                    return false;
//                }else {
//                    $("#submit").attr('disabled',false);
//                }
//            });
//        });
//    })
</script>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>dangerproject/save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${danagerProject.rowId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${danagerProject.bdId}" >
                    <label class="control-label x90" style="width: 105px;">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${danagerProject.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">工程地点：</label>
                    <input type="text" name="projectAddress"  value="${danagerProject.projectAddress}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">分部分项工程类别：</label>
                    <input type="text" name="fbProjectType"  value="${danagerProject.fbProjectType}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">分部分项工程名称：</label>
                    <input type="text" name="fbProjectName"  value="${danagerProject.fbProjectName}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">分部分项工程参数：</label>
                    <input type="text" name="fbProjectParameter"  value="${danagerProject.fbProjectParameter}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">是否超过一定规模：</label>
                    <select data-toggle="selectpicker" name="ext1"  value="${danagerProject.ext1}" data-rule="required">
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">方案审批情况：</label>
                    <select data-toggle="selectpicker" name="faSpQk"  value="${danagerProject.faSpQk}" data-rule="required">
                        <option value="已审批">已审批</option>
                        <option value="未审批">未审批</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">计划开工日期：</label>
                    <input id="startTime" type="text" name="kgTime"  value="${danagerProject.kgTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly" data-rule="required" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">计划完工日期：</label>
                    <input id="endTime" type="text" name="wgTime"  value="${danagerProject.wgTime}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">目前状态：</label>
                    <select data-toggle="selectpicker" name="nowType"  value="${danagerProject.nowType}" data-rule="required">
                        <option value="正在实施">正在实施</option>
                        <option value="未实施">未实施</option>
                        <option value="部分实施">部分实施</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">责任人：</label>
                    <input type="text" name="personCharge"  value="${danagerProject.personCharge}" data-rule="required">
                </td>
            </tr>
            </tbody>
        </table>


        </tbody>
        </table>
    </form>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>
