<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>

<html>
<head>
<%@ include file="base.jsp"%>
<title>舞动全城后台管理 | 登录</title>
<!-- 页面通用CSS -->
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/bootstrap.min.css">
 
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/font-awesome.min.css">

<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/font-awesome-animation.min.css">
<!-- Ionicons 2.0.0 -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/ionicons.min.css">
<!-- Pace -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/pace/pace-theme-center-simple.css" />
<!-- 页面通用CSS End -->

<!-- 页面通用JS -->
<!-- jQuery 2.1.4 -->
<script src="<%=ctx%>/admin/jquery/jQuery-2.1.4.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<%=ctx%>/admin/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Pace v1.0.2 -->
<script src="<%=ctx%>/admin/plugins/pace/pace.min.js"></script>
<!-- 页面通用JS End -->
	
<!-- Common -->
<script src="<%=ctx%>/admin/pages/base/pages.js"></script>
<!-- Common End -->
<!-- Base -->
<!-- bootstrap-Validator -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap-validator/bootstrapValidator.min.css" />
<!-- bootstrap-Validator -->
<script src="<%=ctx%>/admin/plugins/bootstrap-validator/bootstrapValidator.min.js"></script>
<!-- MD5 v2.1-->
<script src="<%=ctx%>/admin/plugins/md5/md5.js"></script>

<link rel="stylesheet" href="<%=ctx%>/admin/dist/css/login.css" />

<script src="<%=ctx%>/admin/dist/js/login.js"></script>
</head>
<body class="hold-transition">
	<div class="login-b">
		<div class="login-box-body">
			<form id="loginform">
				<div class="form-group has-feedback">
					<input name="param._se_mbName" id="param._se_mbName" type="text" class="form-control" placeholder="账号/手机/邮箱" />
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input name="param._se_mbPassword" id="param._se_mbPassword" type="password" class="form-control" placeholder="密码" />
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>

				<div class="row">
					<div class="col-xs-12"></div>
				</div>
			</form>
			<div class="row">
				<div class="col-xs-12">
					<button class="btn btn-primary btn-block btn-flat login" style="font-size: 18px;">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
				</div>
			</div>
			<br>
			<div class="pull-left">
				<a href="javascript:$.page.config.fnOnForgotPwd();"><i class="fa fa-credit-card"></i> 忘记密码</a>
			</div>
			<div class="pull-right">
				<a href="javascript:$.page.config.fnRegister();"><i class="fa fa-envelope-o"></i> 手机注册</a>
			</div>
			<br> <br>
			<div>
				<input type="checkbox" checked="checked">
				<!-- <label>我同意并已阅读<a href="#" target="_blank">《提奥网站服务协议》</a></label> -->
			</div>
		</div>
	</div>
</body>
</html>