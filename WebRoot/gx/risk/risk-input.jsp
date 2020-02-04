<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
  /* $(function () {
       var mysubmit=document.getElementById('submit');
       mysubmit.onclick=function(event){
           if( $("#endTime").val()<$("#startTime").val()){
//               $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
               alert("false");
               event.preventDefault();
           }else{
               alert("true");
           }
       }
   })*/
  $(function () {
//      $("#startTime").blur(function(){
//            if($("#endTime").val().length!=0){
//                if( $("#endTime").val()<$("#startTime").val()){
//                    $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
//                    $("#submit").attr('disabled',true);
//                }else{
//                    $("#submit").attr('disabled',false);
//                }
//            }
//
//          $("#endTime").blur(function(){
//              if( $("#endTime").val()<$("#startTime").val()){
//                  $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
//                  $("#submit").attr('disabled',true);
//                  return false;
//              }else {
//                  $("#submit").attr('disabled',false);
//              }
//          });
//      });
      $('#startTime').on('afterchange.bjui.datepicker', function(e, data) {
          if($("#endTime").val().length!=0){
              if( $("#endTime").val()<$("#startTime").val()){
                  $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
                  $("#submit").attr('disabled',true);
              }else{
                  $("#submit").attr('disabled',false);
              }
          }

      })
      $('#endTime').on('afterchange.bjui.datepicker', function(e, data) {
          if( $("#endTime").val()<$("#startTime").val()){
              $(this).alertmsg('error', '结束时间不能小于开始时间，请检查!', {displayMode:'slide', displayPosition:'topcenter'})
              $("#submit").attr('disabled',true);
              return false;
          }else {
              $("#submit").attr('disabled',false);
          }
      })
  })
</script>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form id="ff" action="<%=basePath%>risk/risk-save.do" method="post" data-toggle="validate" data-reloadNavtab="true" >
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
                    <input type="text" name="dgReson"  value="${builddgPadDay.dgReson}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">可能导致的事故：</label>
                    <input type="text" name="dgSg"  value="${builddgPadDay.dgSg}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">风险度：</label>
                    <select data-toggle="selectpicker" name="dgLevel"  value="${builddgPadDay.dgLevel}">
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
                    <input type="text" name="contrlAnswer"  value="${builddgPadDay.contrlAnswer}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">受控时间：</label>
                    <select data-toggle="selectpicker" name="contrlTime"  value="${builddgPadDay.contrlTime}" data-rule="required">
                        <option value="全过程">全过程</option>
                        <option value="半过程">半过程</option>
                    </select>
                    <%--<input type="text" name="contrlTime"  value="${builddgPadDay.contrlTime}" data-rule="required" size="20">--%>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">施工负责人：</label>
                    <input type="text" name="buildManager"  value="${builddgPadDay.buildManager}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">班组分组人：</label>
                    <input type="text" name="levelManager"  value="${builddgPadDay.levelManager}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">开始日期：</label>
                    <input   id="startTime" readonly="readonly" type="text" name="startTime" value="${startTime}" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">结束日期：</label>
                    <input   id="endTime" type="text" readonly="readonly"  name="endTime" value="${endTime}" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" >
                </td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">安全负责人：</label>
                    <input type="text" name="safeManager"  value="${builddgPadDay.safeManager}" data-rule="required" size="20">
                </td>
            </tr>
            </tbody>
        </table>
    </form>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit"  id="submit" class="btn-default">保存</button></li>
    </ul>
</div>

