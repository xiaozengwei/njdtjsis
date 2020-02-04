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
//    $(function () {
//
//
//    var editorOption = {
//        toolbars: [[
//            'fullscreen',  '|', 'undo', 'redo', '|',
//            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
//            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
//            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
//            'directionalityltr', 'directionalityrtl', 'indent', '|',
//            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
//            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
//            'simpleupload', 'insertimage', 'emotion', 'scrawl',  'insertframe',   'pagebreak', 'template', 'background', '|',
//            'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
//            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
//            'searchreplace', 'drafts'
//        ]],
//        elementPathEnabled: false,
//        charset:"utf-8"
//        ,initialFrameWidth:920 //初始化编辑器宽度,默认1000
//        ,initialFrameHeight:500 //初始化编辑器高度,默认320
//
//    };
//    var ue = new baidu.editor.ui.Editor(editorOption);
//    ue.render("container");
//    ue.ready(function() {
//        ue.focus(true);
//    });
//    })
</script>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form id="ff" action="<%=basePath%>generalize/save.do" method="post" data-toggle="validate" data-reloadNavtab="true" >
        <input type="hidden" name="rowId"  value="${byProjectIntroduction.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">车站土建总工程：</label>
                    <input type="number" name="stationTotalProject"  data-rule="required;  range[0~100]" value="${byProjectIntroduction.stationTotalProject}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">区间土建总工程：</label>
                    <input type="number" name="qjtjTotalGcs"  data-rule="required;  range[0~100]" value="${byProjectIntroduction.qjtjTotalGcs}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">辅轨总进度：</label>
                    <input type="number" name="fgTotalSchedule"  data-rule="required;  range[0~100]" value="${byProjectIntroduction.fgTotalSchedule}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">设备工程总进度：</label>
                    <input type="number" name="sbTotalSchedule"  data-rule="required; range[0~100]" value="${byProjectIntroduction.sbTotalSchedule}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">投资完成金额(亿)：</label>
                    <input type="number" name="tzwcMoney"  data-rule="required;  range[0~100]" value="${byProjectIntroduction.tzwcMoney}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">车站总数：</label>
                    <input type="number" name="stationAllCount"  data-rule="required; integer; range[0~100]" value="${byProjectIntroduction.stationAllCount}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">已开工车站：</label>
                    <input type="number" name="ykgStationAllCount"  data-rule="required; integer; range[0~100]" value="${byProjectIntroduction.ykgStationAllCount}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">盾构机总数：</label>
                    <input type="number" name="dgjAllCount"  data-rule="required; integer; range[0~100]" value="${byProjectIntroduction.dgjAllCount}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">始发盾构机：</label>
                    <input type="number" name="ysfDgjCount"  data-rule="required; integer; range[0~100]" value="${byProjectIntroduction.ysfDgjCount}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">工程简介：</label>
                    <textarea name="projectIntroduction" cols="30" rows="1" data-toggle="autoheight">
                        ${byProjectIntroduction.projectIntroduction}
                    </textarea>
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

