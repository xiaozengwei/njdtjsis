<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="bjui-pageContent" style="background:#FFF; min-width: 1260px; overflow-x: auto " id="index_layout">
	<div class="supervise">
		<div class="superviseTitle">
			<img src="<%=request.getContextPath()%>/gx/images/supervise.png" width="30" height="30" valign="middle" hspace="5">1号线北延工程总概况
		</div>
		<div class="gkContent">
			<div class="supervise">
				<div class="cgqContent">
					<div class="drowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg01">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td  height="120px" align="center">
													<div class="line35">车站土建总工程</div>
													<div class="linebg " >
													${byProjectIntro.stationTotalProject}</div>
												</td>

											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="drowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg02">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td height="120px" align="center"  >
													<div class="line35">区间土建总工程 </div>
													<div class="linebg02">${byProjectIntro.qjtjTotalGcs}</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="drowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg03">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td height="120px" align="center">
													<div class="line35">辅轨总进度</div>
													<div class="linebg03">${byProjectIntro.fgTotalSchedule}</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="drowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg04">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td height="120px" align="center">
													<div class="line35">设备工程总进度</div>
													<div class="linebg04">${byProjectIntro.sbTotalSchedule}</div>
												</td>
											</tr>
										</table>
									</div>
								</td>

							</tr>

						</table>
					</div>
					<%--<div class="drowdiv">--%>
						<%--<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">--%>
							<%--<tr>--%>
								<%--<td style="padding:5px;">--%>
									<%--<div class="coldiv bg05">--%>
										<%--<table border="0" cellspacing="0" cellpadding="0" align="center">--%>
											<%--<tr>--%>

												<%--<td height="120px" align="center" >--%>
													<%--<div class="line35">车站土建总工程</div>--%>
													<%--<div class="line30">${byProjectIntro.stationTotalProject02}</div>--%>
												<%--</td>--%>
											<%--</tr>--%>
										<%--</table>--%>
									<%--</div>--%>
								<%--</td>--%>

							<%--</tr>--%>

						<%--</table>--%>
					<%--</div>--%>
					<div class="drowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg06">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td height="120px" align="center" >
													<div class="line35">投资完成金额</div>
													<div class="line30">${byProjectIntro.tzwcMoney}亿</div>
												</td>
											</tr>
										</table>
									</div>
								</td>

							</tr>

						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="gkContent">

				<div class="cgqContent">
					<div class="rowdiv4">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bggray">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td align="center" height="120px">
													<div class="line32">车站总数</div>
													<div class="lineB">${byProjectIntro.stationAllCount}个</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="rowdiv4">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bggray">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td align="center" height="120px">
													<div class="line32">已开工车站 </div>
													<div class="lineB">${byProjectIntro.ykgStationAllCount}个</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="rowdiv4">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px">
									<div class="coldiv bggray">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td height="120px" align="center">
													<div class="line32">盾构机总数</div>
													<div class="lineB">${byProjectIntro.dgjAllCount}台</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="rowdiv4">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bggray">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>

												<td align="center" height="120px">
													<div class="line32">始发盾构机</div>
													<div class="lineB">${byProjectIntro.ysfDgjCount}台</div>
												</td>
											</tr>
										</table>
									</div>
								</td>

							</tr>

						</table>
					</div>

				</div>
			<div style="display: block; width:99%;margin: auto;  clear: both; background:#f9f8f8; border:0px #ff0000 solid;   -moz-border-radius: 5px;-webkit-border-radius:5px;	border-radius:5px; padding:5px; "><span style="display: block; font-size: 14px; font-weight: bold; line-height: 40px; ">
				<span style="display: inline-block; width: 12px;height: 12px; border-radius: 12px; background: #f7be4d; margin-right: 5px;"></span>1号线北延简介</span>
				<span style="text-indent: 26px; font-size: 13px; line-height: 30px;">
					${byProjectIntro.projectIntroduction}
				</span>
			</div>
		</div>

	</div>
<c:forEach items="${sxpzRecord}" var="sxpz" varStatus="status">
	<div class="supervise">
		<div class="superviseTitle">
			<img src="<%=request.getContextPath()%>/gx/images/supervise.png" width="30" height="30" valign="middle" hspace="5">${sxpz.sxpzName}
		</div>
		<div class="supContent">
			<div class="supContent_div">在场人员：<span class="number">${sxpz.v1}</span> 人  </div>
			<div class="supContent_div">当日进出物料：<span class="number">${sxpz.v3}</span> 吨  </div>
			<div class="supContent_div">进场设备：<span class="number">${sxpz.v2}</span> 台  </div>
			<div class="supContent_div">当日物料使用量：<span class="number">${sxpz.v4}</span> 吨  </div>
			<div class="supervise">
				<div class="cgqContent">

					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bgyellow">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_pm25.png" width="50"  hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.h3}</span>μg/m³ </div>
													<div class="line30">PM2.5</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bgblue">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_pm10.png" width="50"  hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.h4}</span>ug/m3 </div>
													<div class="line30">PM10</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg05">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_zy.png" width="50"  hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.v5}</span>dB </div>
													<div class="line30">噪音</div>
												</td>
											</tr>
										</table>
									</div>
								</td>

							</tr>

						</table>
					</div>
					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bgred">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_wd.png" width="70"  hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.h1}</span>℃ </div>
													<div class="line30">温度</div>
												</td>
											</tr>
										</table>
									</div>
								</td>

							</tr>

						</table>
					</div>
					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bggreen">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_sz.png" width="60" hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.h2}</span>% </div>
													<div class="line30">湿度</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>

					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"  align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg06">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_fs.png" width="50"  hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.v6}</span>m/s </div>
													<div class="line30">风速</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="rowdiv">
						<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td style="padding:5px 0px;">
									<div class="coldiv bg02">
										<table border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td height="120px" align="center"  width="90px"><img src="<%=request.getContextPath()%>/gx/images/img_fx.png" width="50" hspace="5" /></td>
												<td align="left">
													<div class="line30"><span class="numberF">${sxpz.v7}</span> </div>
													<div class="line30">风向</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>

				</div>

			</div>
			<div style="display: block; width:100%;margin: auto;  clear: both;/* background:#f9f8f8;*/ border:0px #ff0000 solid;   -moz-border-radius: 5px;-webkit-border-radius:5px;	border-radius:5px; padding:5px; "><span style="display: block; font-size: 14px; font-weight: bold; line-height: 40px; ">
				<span style="display: inline-block; width: 12px;height: 12px; border-radius: 12px; background: #f7be4d; margin-right: 5px;"></span>当日养护室状态</span>
			</div>
			<div class="rowdiv">
				<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
					<tr>
						<td style="padding:5px 0px;">
							<div class="coldiv bgred">
								<table border="0" cellspacing="0" cellpadding="0" align="center" width="100%">
									<tr>
										<td height="120px" align="center"  ><img src="<%=request.getContextPath()%>/gx/images/img_wd.png" width="60"  hspace="5" /></td>
										<td align="left" >
											<div class="line30"><span class="numberF">${sxpz.b1}</span>℃ </div>
											<div class="line30">温度</div>
										</td>
									</tr>
								</table>
							</div>
						</td>

					</tr>

				</table>
			</div>
			<div class="rowdiv">
				<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
					<tr>
						<td style="padding:5px 0px;">
							<div class="coldiv bggreen">
								<table border="0" cellspacing="0" cellpadding="0" align="center"  width="100%">
									<tr>
										<td height="120px" align="center" ><img src="<%=request.getContextPath()%>/gx/images/img_sz.png" width="60" hspace="5" /></td>
										<td align="left" >
											<div class="line30"><span class="numberF">${sxpz.b2}</span>% </div>
											<div class="line30">湿度</div>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</c:forEach>

</div>




