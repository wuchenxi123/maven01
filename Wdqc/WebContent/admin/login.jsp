<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>舞动全城信息 | 登录</title>
<link rel="stylesheet" href="../admin/dist/css/login.css" />
</head>
<body class="hold-transition">
	<div id="header">
		<div class="header-layout y-row">
			<h1 class="logo" id="logo">
				<a></a>
			</h1>
			<h2 class="logo-title">帐号登录</h2>
			<ul class="header-nav">
				<li class="nav-first"><a href="#" target="_blank">舞动全城手机版</a></li>
				<li><a href="#" target="_blank">舞动全城电脑版</a></li>
			</ul>
		</div>
	</div>
	<div class="content y-row">
		<div id="login-banner">
			 <img style="width: 450px; height: 350px" src="../admin/dist/images/login.jpg">
		</div>
		<div id="login-module">
		<%@ include file="../admin/pages/base/login.jsp"%>
			<!-- <iframe id="login-iframe" src="../admin/pages/base/login.jsp" width="100%" height="350px" frameborder="none" scrolling="no" style="border: none; visibility: visible;" ></iframe> -->
		</div>
	</div>
	<div class="copyright-100">
		<div class="y-row copyright">
			<p>湖南舞动全城<a href="#"></a></p>
		</div>
	</div>
</body>
</html>


