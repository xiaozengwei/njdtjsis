<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style> 

.wenhao-li-selected{background-color:#3399ff;}

.c-operation,#wenhao-edit {
	width: 100%;
}

.c-operation li {
	float: left;
	margin-left: 15px;
}

#wenhao-type-list {
	width: 48%;
	float: left;
	height: 250px;
	
}

#wenhao-used {
	width: 48%;
	float: right;
	height: 250px;
}

#wenhao-type-list fieldset,#wenhao-used fieldset {
	height: 100%;
}

.wenhao-max {
	width: 100%;
	height: 250px;
	margin-bottom: 10px;
}


#wenhao-type-list li{
	display: block;
	text-decoration: none;
	line-height: 25px;
	width: 100%;
}

.hover-bg{
	background-color: #dfdfdf;
}

.clicked-bg{
	background-color: #e4dbf0;
}
#wenhao-edit{
display: none;
}
</style>
<div class="bjui-pageContent">
	<div class="wenhao-max">
		<div class="wenhao-type-list" id="wenhao-type-list" >
			<fieldset style="overflow: auto;">
				<legend>请选择文号类型</legend>
				<ul id="wenhao-type-list-ul" >
					
				</ul>
			</fieldset>
		</div>
		<div style="" id="wenhao-used">
			<fieldset>
				<legend>现已使用的文号</legend>
				<table width="100%">
					<tr>
						<td style="line-height:30px; text-align:center"><label for="currentMax" class="control-label" style="line-height:30px; text-align:center">已使用的最大号</label></br><input name="currentMax" id="currentMax" />
						</td>
						
					</tr>
					<tr>
						<td style="line-height:30px; text-align:center"><label for="sysNum" class="control-label" style="line-height:30px; text-align:center">系统自动获取的号</label><br><input name="sysNum" id="sysNum" /></td>
						
					</tr>
				</table>

			</fieldset>
		</div>
	</div>
	<div id="wenhao-edit">
		<form id="form-wenhao" action="<%=basePath%>/dic/wenhao-config-save.do" method="post">
		<fieldset>
			<legend>编辑新文号</legend>
			<table width="100%">
				<tr>
					<td><label for="txt-wenhao-type"  class="control-label x85">类型:</label><input type="text" name="wenhaoType" id="txt-wenhao-type" />
					</td>
				</tr>
				<tr>
					<td><label for="select-bracket-type"  class="control-label x85">括号:</label><select id="select-bracket-type" data-toggle="selectpicker">
							<option value="0">方括号</option>
							<option value="1">圆括号</option>
							<option value="2">大括号</option>
					</select>
					</td>
					
				</tr>
				<tr>
					<td><label for="txt-markword"  class="control-label x85">号字:</label><input type="text" name="markWord" id="txt-markword" />
					</td>
					
				</tr>
				<tr>
					<td ><input type="checkbox" id="isMixed" name="isMixed" value="1" /><label 
						for="isMixed">是否混合使用</label> <select name="mix_maxid" id="select-wenhao-list" >
							<option value="">请选择</option>
							
					</select></td>
				</tr>

			</table>


		</fieldset>
</form>
	</div>
	<div class="c-operation">
		<ul>
			<li><button type="button" class="btn-default"
					id="btn-editwenhao-new">编辑新文号</button>
			</li>
			<li><button type="button" class="btn-default"
					id="btn-bringback-wenhao">确定</button>
			</li>
			<li><button type="button" class="btn-close">关闭</button>
			</li>
		</ul>
	</div>
</div>
<script>
function initWenhao(){
	var ul_container = $("#wenhao-type-list ul",$.CurrentDialog);
	var op_container  = $("#select-wenhao-list",$.CurrentDialog);
	$.ajax({
		url:'<%=basePath%>'+'dic/wenhao-config-list.do',
		type:'get',
		dataType: "json",
		success:function(json){
			ul_container.empty();
			op_container.empty();
			$.each(json,function(i,wenhao){
				var li_html ="<li  class='wenhao-li-list' wmax-id='"+wenhao.maxWenhaoRowId+"'>"+wenhao.completeContent+"</li>";
				ul_container.append(li_html);
				ul_container.append(li_html);
				
				
				var op_html ="<option value='"+wenhao.maxWenhaoRowId+"'>"+wenhao.completeContent+"</option>";
				op_container.append(op_html);
			});
		}
	});
}
$(function(){
	initWenhao();
	$("#btn-editwenhao-new",$.CurrentDialog).click(function(){
		$("#wenhao-edit",$.CurrentDialog).show().addClass("wenhao-new-show");
	});
	
	$("#btn-bringback-wenhao",$.CurrentDialog).click(function(){
		if($("#wenhao-edit",$.CurrentDialog).hasClass("wenhao-new-show")){
			//保存文号表单
			var wenhao_form = $("#form-wenhao",$.CurrentDialog);
			var wenhao_type = $("#txt-wenhao-type",wenhao_form).val()||'';//文号类型
			var wenhao_markword = $("#txt-markword",wenhao_form).val()||'';//号字
			var bracket_type = $("#select-bracket-type",wenhao_form).val()||'';//括号类型
			var isMixed = $("#isMixed:checked",wenhao_form).val()||'0';//选中1，未0
			switch(bracket_type){
			case '0'://方括号
				bracket_type ="[*]";
				break;
			case '1'://圆括号
				bracket_type ="(*)";
				break;
			case '2'://大括号
				bracket_type ="{*}";
				break;
			default:
				break;
			}
			
			$.ajax({
				url:wenhao_form.attr("action"),
				type:wenhao_form.attr("method")||'post',
				dataType: "json",
				data:{
					wenhaoType:wenhao_type,
					bracketType:bracket_type,
					markWord:wenhao_markword,
					mix_maxid:$("#select-wenhao-list",$.CurrentDialog).val(),
					isMixed:isMixed
				},
				success:function(json){
					if(json.statusCode==BJUI.statusCode.ok){
						initWenhao();
					}
				}
			});
			
			$("#wenhao-edit",$.CurrentDialog).removeClass("wenhao-new-show").hide();
		}else{//带回状态
			var wenhao_li_selected = $(".wenhao-li-selected",$("#wenhao-type-list-ul",$.CurrentDialog));
			var regstr = ""; 
			var regNum = "";
			var max_id = wenhao_li_selected.attr("wmax-id") ||"";
			if(wenhao_li_selected.length > 0){
				regstr = wenhao_li_selected.text();
				 regNum = $("#sysNum").val();
				 regNum = formatNum(regNum,"0000");
				regstr = regstr.replace("*",regNum);
			}
			$(this).attr("data-args","{'fwNumber':'"+regstr+"','currentNum':'"+regNum+"','maxId':'"+max_id+"'}");
			$(this).attr("data-toggle","lookupback");
		    
			
		}
	});
	//点击所选文号名称，显示系统自动选择的号码
	$("#wenhao-type-list",$.CurrentDialog).on("click",".wenhao-li-list",function(){
		var wenhao_max_id = $(this).attr("wmax-id")
		$(this).addClass("wenhao-li-selected").siblings().removeClass("wenhao-li-selected");
		$.ajax({
			url:'<%=basePath%>'+'dic/wenhao-max-get.do',
			type:'get',
			data:{
				maxId:wenhao_max_id
				
			},
			success:function(whmax){
				$("#currentMax",$.CurrentDialog).val(whmax);
				$("#sysNum",$.CurrentDialog).val(formatNum(parseInt(whmax)+1,"0000"));
			}
		});
	});
	$("#currentMax",$.CurrentDialog).on("change",function(){
			var whmax= $("#currentMax",$.CurrentDialog).val() ||"0";
			$("#sysNum",$.CurrentDialog).val(formatNum(parseInt(whmax)+1,"0000"));
	});
});
</script>
