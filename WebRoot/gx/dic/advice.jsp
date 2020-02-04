<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="bjui-pageContent">
	<table width="680px" border="0" cellspacing="0" cellpadding="0"
		class="border5">
		<tr>
			<td class="tdTitle2 " width="80px">常用词语</td>
			<td class="tdTitle2 " width="220px">集 团 领 导</td>
			<td class="tdTitle2 " width="160px">部 门</td>
			<td class="tdTitle2 " width="140px">常 用 词 语</td>
			<td class="tdTitle2 " width="80px">标点符号</td>
		</tr>
		<tr>
			<td valign="middle" align="center" class="ty">
				<p>拟</p>
				<p>请</p>
				<p>呈</p>
				<p>由</p></td>
			<td valign="top" class="ty">
				<p>章小奇 董事长 党委书记</p>
				<p>程向阳 总经理 党委副书记</p>
				<p>张金发 监事会主席 纪委书记 党委委员</p>
				<p>张梦洁 副总经理</p>
				<p>王虹燕 副总经理 党委委员</p></td>
			<td valign="top" class="ty">
				<p>综合办公室</p>
				<p>党群工作与人力资源部</p>
				<p>计划财务部</p>
				<p>投资发展部</p>
				<p>资产运营部</p>
				<p>监督办公室</p>

				<p>O2O平台</p>
				<p>体育交易平台</p>
				<p>宣传服务平台</p>
				<p>体育产业协会</p></td>
			<td valign="top" rowspan="2" class="cycy">
				<p style="float: left;">已阅</p>&nbsp;&nbsp;
				<p style="float: left;margin-left: 8px;">传阅</p>&nbsp;&nbsp;
				<p style="float: left;margin-left: 8px;">阅示</p>
				<div style="clear: both;"></div>
				<p style="float: left;">阅研</p>&nbsp;&nbsp;
				<p style="float: left;margin-left: 8px;">阅知</p>&nbsp;&nbsp;
				<p style="float: left;margin-left: 8px;">阅</p>
				<div style="clear: both;"></div>
				<p style="float: left;">牵头</p>&nbsp;&nbsp;
				<p style="float: left;margin-left: 8px;">办理</p>&nbsp;&nbsp;
				<p style="float: left;margin-left: 8px;">参加</p>
				<div style="clear: both;"></div>
				<p>按要求办理。</p>
				<p>具体落实此项工作。</p>
				<p>暂不办理。</p>
				<p>已办结。</p>
				<p>已落实。</p>
				<p>已上报。</p>
				<p>请归档。</p></td>
			<td valign="top" align="center" rowspan="2" class="cycy">
				<p>，</p>
				<p>。</p>
				<p>！</p>
				<p>；</p>
				<p>（</p>
				<p>）</p>
				<p>？</p>
				<p>、</p></td>
		</tr>
		<tr>
			<td class="tdTitle2 ">常用称谓</td>
			<td class="ty" align="center"><p>集团领导</p>
			</td>
			<td class="ty" valign="top">
				<p>负责人</p>
				<p>各部门</p>
				<p>各部门负责人</p>
				<p>各项目组负责人</p>
				<p>集团中层以上干部</p>
				<p>各部门全体人员</p></td>
		</tr>
		<tr>
			<td colspan="5" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					style="margin-top:5px" class="border5">
					<tr>
						<td class="tdTitle2 SolidB " height="25" align="center">意见</td>
					</tr>
					<tr>
						<td><textarea rows="5" cols="68"  data-toggle="autoheight"
								id="txt_advice"></textarea>
						</td>
					</tr>
				</table>
			</td>

		</tr>
	</table>

</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn-default"
				id="btn-bringback-advice">确定</button></li>
		<li><button type="button" class="btn-default"
				id="btn-clean-advice">清空</button></li>
		<li><button type="button" class="btn-close">关闭</button></li>
	</ul>
</div>
<script>
	$(function() {
		$("p", $.CurrentDialog).click(function() {
			$("#txt_advice", $.CurrentDialog).append($(this).text());
		});
		
		$("#btn-clean-advice", $.CurrentDialog).click(function() {
			$("#txt_advice", $.CurrentDialog).val("");
		});
		$("#btn-bringback-advice", $.CurrentDialog).click(function() {
			var v_advice = $("#txt_advice").val() || "";
			$.CurrentNavtab.find(':input').each(function() {
				var $input = $(this), inputName = '${column}';

				var name = $input.attr("name");

				if (name == inputName) {

					$input.val(v_advice);

				}

			});
			$(this).dialog('closeCurrent');
		});
	});
</script>
