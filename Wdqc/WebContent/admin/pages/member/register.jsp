<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
<!--<script src="<%=ctx%>/admin/jquery/jquery-1.10.1.min.js"></script>
 MD5 v2.1-->
<script src="<%=ctx%>/admin/plugins/md5/md5.js"></script>	
<script src="<%=ctx%>/admin/pages/member/register.js"
	type="text/javascript"></script>

<title>注册信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">注册信息</a></li>
		<li class="active">添加注册</li>
	</ol>
	</section>

	<!-- Main content -->

	<section class="content">
	<form role="form" class="form-horizontal">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">注册信息</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">

						<div class="box box-primary">
							<div class="box-body">
							<input type="hidden" name="form.mbId" id="form.mbId" />
							<input type="hidden" name="form.mbRegisterDate" id="form.mbRegisterDate" />
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">角色：</label>
											<div class="col-sm-8">
												<select name="form.roleId" id="form.roleId"
													class="form-control">	
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">用户名：</label>
											<div class="col-sm-8">
												<input name="form.mbName" id="form.mbName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">真实姓名：</label>
											<div class="col-sm-8">
												<input name="form.mbPetName" id="form.mbPetName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">密码：</label>
											<div class="col-sm-8">
												<input name="form.mbPassword" id="form.mbPassword" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">邮箱：</label>
											<div class="col-sm-8">
												<input name="form.mbEmail" id="form.mbEmail" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">手机：</label>
											<div class="col-sm-8">
												<input name="form.mbPhone" id="form.mbPhone" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-sm-12">
									<div class="col-sm-7">
										<div class="form-group">
											<label class="col-sm-2 control-label">性别：</label>
											<div class="col-sm-5">
												<label class="checkbox-inline"> <input type="radio"
													name="form.mbSex" id="form.mbSex" value="0" checked>
													&nbsp; &nbsp; &nbsp;男
												</label> <label class="checkbox-inline"> <input type="radio"
													name="form.mbSex" id="form.mbSex" value="1">
													&nbsp; &nbsp; &nbsp;女
												</label> 
											</div>
										</div>

									</div>
								</div>
								
								
								

							</div>

						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="col-xs-4 col-xs-offset-4" style="height: 155px;">
				<button type="button" onclick="$finish();"
					class="btn btn-primary  btn-lg btn-block">保存</button>
			</div>
		</div>
	</form>
	</section>

</body>
</html>