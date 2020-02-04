<%@page import="java.util.*,com.gx.soft.sys.persistence.domain.GxSysFunction" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	List<GxSysFunction> functionLvevl1 = (List<GxSysFunction>)request.getAttribute("functionList");
	String userName  = (String)request.getAttribute("userName");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="zh">
<head>
<%--<base href="<%=request.getContextPath()%>/gx/"/>
--%><meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>智慧工地系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="Keywords" content=""/>
<meta name="Description" content=""/>
<!-- bootstrap - css -->
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/bootstrap.css" rel="stylesheet">
<!-- core - css -->
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/purple/core.css" id="bjui-link-theme" rel="stylesheet">
<!-- plug - css -->
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/kindeditor_4.1.10/themes/default/default.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/niceValidator/jquery.validator.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/bootstrapSelect/bootstrap-select.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/FA/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/gx/BJUI/themes/css/style-my.css" rel="stylesheet">
<!--[if lte IE 7]>
<link href="/gx/BJUI/themes/css/ie7.css" rel="stylesheet">


<![endif]-->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lte IE 9]>
    <script src="/gx/BJUI/other/html5shiv.min.js"></script>
    <script src="/gx/BJUI/other/respond.min.js"></script>

<![endif]-->
 <script src="<%=request.getContextPath()%>/gx/BJUI/other/html5shiv.min.js"></script>
    <script src="<%=request.getContextPath()%>/gx/BJUI/other/respond.min.js"></script>

    <script src="/gx/js/jquery-weui.min.js"></script>
    <script src="/gx/js/jquery-weui.min.css"></script>
    <script src="/gx/js/weui.min.css"></script>
<!-- jquery -->
<script src="<%=request.getContextPath()%>/gx/BJUI/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/jquery.cookie.js"></script>
<!--[if lte IE 9]>
<script src="BJUI/other/jquery.iframe-transport.js"></script>
<![endif]-->
<!-- BJUI.all 分模块压缩版 -->
<!--<script src="BJUI/js/bjui-all.js"></script>-->
<!-- 以下是B-JUI的分模块未压缩版，建议开发调试阶段使用下面的版本 -->

<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-core.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-regional.zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-frag.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-extends.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-basedrag.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-slidebar.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-contextmenu.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-navtab.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-dialog.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-taskbar.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-ajax.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-alertmsg.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-pagination.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-util.date.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-ajaxtab.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-datagrid.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-tablefixed.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-tabledit.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-spinner.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-lookup.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-tags.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-upload.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-theme.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-initui.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-plugins.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/bjui-zmy.js"></script>

<!-- plugins -->
<!-- swfupload for uploadify && kindeditor -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/swfupload/swfupload.js"></script>
<!-- kindeditor -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/kindeditor_4.1.10/kindeditor-all.min.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/kindeditor_4.1.10/lang/zh_CN.js"></script>
<!-- colorpicker -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- ztree -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/ztree/jquery.ztree.all-3.5.js"></script>
<!-- nice validate -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/niceValidator/jquery.validator.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/niceValidator/jquery.validator.themes.js"></script>
<!-- bootstrap plugins -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/bootstrapSelect/bootstrap-select.min.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/bootstrapSelect/defaults-zh_CN.min.js"></script>
<!-- icheck -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/icheck/icheck.min.js"></script>
<!-- dragsort -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/dragsort/jquery.dragsort-0.5.1.min.js"></script>
<!-- HighCharts -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/highcharts/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/highcharts/highcharts-3d.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/highcharts/themes/gray.js"></script>
<!-- other plugins -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/other/jquery.autosize.js"></script>
<link href="<%=request.getContextPath()%>/gx/BJUI/plugins/uploadify/css/uploadify.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/uploadify/scripts/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/gx/js/plupload.full.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/gx/js/i18n/zh_CN.js"></script>
 <!-- 配置文件 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/widgets/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/widgets/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/widgets/ueditor/ueditor.parse.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/widgets/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 日历（日程）控件 -->

<script src='<%=request.getContextPath()%>/widgets/fullCalendar2.4.0/lib/moment.min.js'></script>
<script  type="text/javascript" src='<%=request.getContextPath()%>/widgets/fullCalendar2.4.0/fullcalendar.js'></script>
<script  type="text/javascript" src='<%=request.getContextPath()%>/widgets/fullCalendar2.4.0/lang/zh-cn.js'></script>

<!-- ECharts -->
<script src="<%=request.getContextPath()%>/gx/BJUI/plugins/echarts/echarts.js"></script>
<!-- init -->
<script type="text/javascript">
_BASE_PATH = '<%=basePath%>';
$(function() {
    BJUI.init({
        JSPATH       : '../gx/BJUI/',         //[可选]框架路径
        PLUGINPATH   : '../gx/BJUI/plugins/', //[可选]插件路径
        loginInfo    : {url:'login_timeout.html', title:'登录', width:400, height:200}, // 会话超时后弹出登录对话框
        statusCode   : {ok:200, error:300, timeout:301}, //[可选]
        ajaxTimeout  : 500000, //[可选]全局Ajax请求超时时间(毫秒)
        pageInfo     : {total:'total', pageCurrent:'pageCurrent', pageSize:'pageSize', orderField:'orderField', orderDirection:'orderDirection'}, //[可选]分页参数
        alertMsg     : {displayPosition:'topcenter', displayMode:'slide', alertTimeout:3000}, //[可选]信息提示的显示位置，显隐方式，及[info/correct]方式时自动关闭延时(毫秒)
        keys         : {statusCode:'statusCode', message:'message'}, //[可选]
        ui           : {
                         windowWidth      : 0,    //框架可视宽度，0=100%宽，> 600为则居中显示
                         showSlidebar     : true, //[可选]左侧导航栏锁定/隐藏
                         clientPaging     : true, //[可选]是否在客户端响应分页及排序参数
                         overwriteHomeTab : false //[可选]当打开一个未定义id的navtab时，是否可以覆盖主navtab(我的主页)
                       },
        debug        : false,    // [可选]调试模式 [true|false，默认false]
        theme        : 'sky' // 若有Cookie['bjui_theme'],优先选择Cookie['bjui_theme']。皮肤[五种皮肤:default, orange, purple, blue, red, green]
    });
    var funId='${defaultFun.rowId}';
    if(funId.length>0){
    	funId="I"+funId;
	    $(this).navtab({id:funId, url:'<%=basePath %>${defaultFun.functionEnName}', title:'${defaultFun.functionName}',isdefault:true});
    }




    // main - menu
     $('#bjui-accordionmenu')
        .collapse()
        .on('hidden.bs.collapse', function(e) {
            $(this).find('> .panel > .panel-heading').each(function() {
                var $heading = $(this), $a = $heading.find('> h4 > a')

                if ($a.hasClass('collapsed')) $heading.removeClass('active')
            })
        })
        .on('shown.bs.collapse', function (e) {
            $(this).find('> .panel > .panel-heading').each(function() {
                var $heading = $(this), $a = $heading.find('> h4 > a')

                if (!$a.hasClass('collapsed')) $heading.addClass('active')
            })
        });

    $(document).on('click', 'ul.menu-items li > a', function(e) {
        var $a = $(this), $li = $a.parent(), options = $a.data('options').toObj(), $children = $li.find('> .menu-items-children');
        var onClose = function() {
            $li.removeClass('active');
        }
        var onSwitch = function() {
            $('#bjui-accordionmenu').find('ul.menu-items li').removeClass('switch');
            $li.addClass('switch');
        }

        $li.addClass('active');
        if (options) {
            options.url      = $a.attr('href');
            options.onClose  = onClose;
            options.onSwitch = onSwitch;
            if (!options.title) options.title = $a.text()

            if (!options.target)
                $a.navtab(options);
            else
                $a.dialog(options);
        }
        if ($children.length) {
            $li.toggleClass('open');
        }

        e.preventDefault();
    });

    //时钟
    var today = new Date(), time = today.getTime();
    $('#bjui-date').html(today.formatDate('yyyy/MM/dd'));
    setInterval(function() {
        today = new Date(today.setSeconds(today.getSeconds() + 1));
        $('#bjui-clock').html(today.formatDate('HH:mm:ss'));
    }, 1000);
    $("#bjui-hnav-navbar li:first").addClass("active");



});

//菜单-事件
function MainMenuClick(event, treeId, treeNode) {
    event.preventDefault();

    if (treeNode.isParent) {
        var zTree = $.fn.zTree.getZTreeObj(treeId);

        zTree.expandNode(treeNode, !treeNode.open, false, true, true);
        return;
    }

    if (treeNode.target && treeNode.target == 'dialog'){
        $(event.target).dialog({id:treeNode.tabid, url:treeNode.url, title:treeNode.name});
    } else{
        $(event.target).navtab({id:treeNode.tabid, url:treeNode.url, title:treeNode.name, fresh:treeNode.fresh, external:treeNode.external})

    }
}
</script>
<!-- for doc begin -->
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/gx/js/syntaxhighlighter-2.1.382/styles/shCore.css"/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/gx/js/syntaxhighlighter-2.1.382/styles/shThemeEclipse.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/gx/js/syntaxhighlighter-2.1.382/scripts/brush.js"></script>
<script type="text/javascript">
$(function(){
    SyntaxHighlighter.config.clipboardSwf = '/js/syntaxhighlighter-2.1.382/scripts/clipboard.swf'
    $(document).on(BJUI.eventType.initUI, function(e) {
        SyntaxHighlighter.highlight();
    })
})
</script>
<!-- for doc end -->
</head>
<body><input id="isOpenDefaultPage" type="hidden" value="0"/>
    <!--[if lte IE 7]>
        <div id="errorie"><div>您还在使用较老版本的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;</a></div></div>
    <![endif]-->
    <div id="bjui-window">
    <header id="bjui-header">
        <div class="bjui-navbar-header">
            <button type="button" class="bjui-navbar-toggle btn-default" data-toggle="collapse" data-target="#bjui-navbar-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <a class="bjui-navbar-logo" href="#"><img src="<%=request.getContextPath()%>/gx/images/logo.png"></a>
        </div>
        <nav id="bjui-navbar-collapse">
            <ul class="bjui-navbar-right">
                <li class="datetime"><div><span id="bjui-date"></span> <span id="bjui-clock"></span></div></li>
                <li ></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">您好!${userName}<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
 					<li><a href="<%=basePath %>login/to-changepwd.do" data-toggle="dialog" data-id="changepwd_page" data-mask="true" data-width="400" data-height="360">&nbsp;<span class="glyphicon glyphicon-lock"></span> 修改密码&nbsp;</a></li>
                        <li class="divider"></li>
                        <li><a href="<%=basePath %>login/out-login.do" class="red">&nbsp;<span class="glyphicon glyphicon-off"></span> 注销登陆</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle theme blue" data-toggle="dropdown" title="切换皮肤"><i class="fa fa-tree"></i></a>
                    <ul class="dropdown-menu" role="menu" id="bjui-themes">
                        <li><a href="javascript:;" class="theme_default" data-toggle="theme" data-theme="default">&nbsp;<i class="fa fa-tree"></i> 黑白分明&nbsp;&nbsp;</a></li>
                        <li><a href="javascript:;" class="theme_orange" data-toggle="theme" data-theme="orange">&nbsp;<i class="fa fa-tree"></i> 橘子红了</a></li>
                        <li><a href="javascript:;" class="theme_purple" data-toggle="theme" data-theme="purple">&nbsp;<i class="fa fa-tree"></i> 紫罗兰</a></li>
                        <li class="active"><a href="javascript:;" class="theme_blue" data-toggle="theme" data-theme="blue">&nbsp;<i class="fa fa-tree"></i> 天空蓝</a></li>
                        <li><a href="javascript:;" class="theme_green" data-toggle="theme" data-theme="green">&nbsp;<i class="fa fa-tree"></i> 绿草如茵</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="bjui-hnav" >
            <button type="button" class="btn-default bjui-hnav-more-left" title="导航菜单左移"><i class="fa fa-angle-double-left"></i></button>
            <div id="bjui-hnav-navbar-box" >
                <ul id="bjui-hnav-navbar">
                <%
                    for (int i = 0; i < functionLvevl1.size(); i++) {//一级循环
							if (functionLvevl1.get(i).getParentFunctionId().equals("root")) {
                %>
            <li id="I<%=functionLvevl1.get(i).getRowId()%>" data-id="I<%=functionLvevl1.get(i).getRowId()%>" >
                <a href="javascript:;" data-toggle="slidebar"  >
                    <i class="fa fa-check-square-o"></i>
                    <%=functionLvevl1.get(i).getFunctionName()%>
                </a>
               <div class="items hide" data-noinit="true">
                   <ul id="I<%=functionLvevl1.get(i).getRowId()%>" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-faicon="check-square-o">

                       <%
							for (int j = 0; j < functionLvevl1.size(); j++) {//二级循环
								if (functionLvevl1.get(j).getParentFunctionId().equals(functionLvevl1.get(i).getRowId().toString())) {
						%>

                       <li id="I<%=functionLvevl1.get(j).getRowId()%>"  data-id="I<%=functionLvevl1.get(j).getRowId()%>" data-pid="I<%=functionLvevl1.get(j).getParentFunctionId()%>" data-faicon="th-large" data-tabid="T<%=functionLvevl1.get(j).getRowId()%>" data-fresh="true" ><%=functionLvevl1.get(j).getFunctionName()%></li>

                       <%
							for (int k = 0; k < functionLvevl1.size(); k++) {//3级循环
								if (functionLvevl1.get(k).getParentFunctionId().equals(functionLvevl1.get(j).getRowId().toString())) {
						%>                    
                    <li  id="I<%=functionLvevl1.get(k).getRowId()%>" data-id="I<%=functionLvevl1.get(k).getRowId()%>" data-pid="I<%=functionLvevl1.get(k).getParentFunctionId()%>" data-url="<%=basePath +functionLvevl1.get(k).getFunctionEnName()%>" data-tabid="T<%=functionLvevl1.get(k).getRowId()%>" data-faicon="hand-o-up"  data-options="{id:'I<%=functionLvevl1.get(k).getRowId()%>', faicon:'hand-o-up'}" data-fresh="true" ><%=functionLvevl1.get(k).getFunctionName()%></li>
                	<%}}//三级级循环结束%>
                	<%}}//二级循环结束%>
                </ul>
                </div>
            </li>
			<%}}//一级循环结束%>
              </ul>
            </div>
            <button type="button" class="btn-default bjui-hnav-more-right" title="导航菜单右移"><i class="fa fa-angle-double-right"></i></button>
        </div>
    </header>
    <div id="bjui-container">
        <div id="bjui-leftside">
            <div id="bjui-sidebar-s">
                <div class="collapse"></div>
            </div>
            <div id="bjui-sidebar">
                <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
                <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">
                </div>
            </div>
        </div>
        <div id="bjui-navtab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent">
                    <ul class="navtab-tab nav nav-tabs">
                        <li data-url="<%=basePath %>hc/layout.do" data-autorefresh=45 ><a href="javascript:;"><span><i class="fa fa-home"></i> #maintab#</span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft"><i class="fa fa-angle-double-left"></i></div>
                <div class="tabsRight"><i class="fa fa-angle-double-right"></i></div>
                <div class="tabsMore"><i class="fa fa-angle-double-down"></i></div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">#maintab#</a></li>
            </ul>
            <div class="navtab-panel tabsPageContent">
                <div class="navtabPage unitBox">
                    <div class="bjui-pageContent" style="background:#FFF;">
                        Loading...
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer id="bjui-footer">Copyright &copy; 2019　<a href="" target="_blank"></a></footer>
    </div>
</body>
</html>