<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="loading">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
<meta name="keywords" content="" />
<meta name="description" content="设计师网站">
<meta name="author" content="" />

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<link rel="apple-touch-icon-precomposed" href="images/favicon.ico">
<script>
var logined = 0
</script>
<title>教学互动专区</title>
</head>

<body>
<script>
var now_page = 1,
search_value = '';
</script>

		<div id="menu">
	<h4>互动社区</h4>
	 <ul>
			<li class="nav_index menu_cur"><a href="main.jsp"><i></i><span>首页</span><b></b><div class="clear"></div></a></li>
			<li class="nav_site"><a href="NewTheme.jsp"><i></i><span>发布主题</span><b></b><div class="clear"></div></a></li>
			<li class="nav_help"><a href="Stheme"><i></i><span>主题查看</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href="About.jsp"><i></i><span>关于我们</span><b></b><div class="clear"></div></a></li>
		</ul>
	</div>
		<div id="user">
					<div class="account">
				<div class="login_b_t">
					<div class="pd10">
						<div class="fl"><h4>当前登录账号为：${uname}</h4></div>
						<div class="fr"></div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="pd10">
			    <p>   </p>
			</div>
			<div class="pd10">
			<a href="index.jsp" id="weibo_app"><span><i></i>退出登录</span></a>
			</div>

			</div>	
	<div id="header">
		<div class="wrap">
			<i class="menu_open"></i>
			<div class="logo"><a href="main.jsp/" title="返回主页"><img src="css/logo.png" /></a></div>
			<i class="search_open"></i>
		</div>
		<div class="logo_msk"></div>
	</div>
	<div id="container">
		<div id="sort">
		
		</div>
		<div class="hero-unit" width="100%">
		<h2  align="center">请在下方输入要发布的话题：</h2>
		</div>
		
	
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/Ntheme">
		<div class="center">
			<div class="control-group"   width="100%">
  					<h3 align="center">主题题目</h3>
					<textarea  name="title" rows="6" style="width: 615px; height: 88px"></textarea>
					<h3 align="center">主题内容</h3>
                     <textarea   name="content" rows="3" style="width: 615px; height: 257px"></textarea>
    				<div class="form-actions" align="center">
  						 <button type="submit" class="btn btn-large  btn-primary">确认发表</button>
  								
					</div>  
				
			</div>>
		    </div>
		
		</form>
		<div class="push_msk"></div>
	</div>

	
	<div class="loading_dark"></div>
	<div id="loading_mask">
		<div class="loading_mask">
			<ul class="anm">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
	<script language="javascript" src="js/zepto.min.js"></script>
	<script language="javascript" src="js/fx.js"></script>
	<script language="javascript" src="js/script.js"></script>
	
</body>
</html>
<script type=text/javascript>
	if('${Msg}'!=''){
		alert('${Msg}');
	}

</script>