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
<script src="<%=ctx%>/admin/pages/education/teacher/add.js"
	type="text/javascript"></script>
	
<title>添加班级信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">教务教学</a></li>
		<li class="active">添加教师</li>
	</ol>
	</section>

	<!-- Main content -->

	<section class="content">
	<form role="form" class="form-horizontal">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">教师信息</h3>
			</div>
			<div class="panel-body" style="height: 200px">
				<div class="row">
					<div class="col-xs-12">

						<input type="hidden" name="form.teId" id="form.teId" />
						<input type="hidden" name="form.teArrivegradlassrate" id="form.teArrivegradlassrate" />
						<input type="hidden" name="form.teGradlasscount" id="form.teGradlasscount" />
						<div class="box box-primary">
							<div class="box-body">
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">教师名称：</label>
											<div class="col-sm-8">
												<input name="form.teName" id="form.teName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">年龄：</label>
											<div class="col-sm-8">
												<input name="form.teAge" id="form.teAge" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">性别：</label>
											<div class="col-sm-8">
											<!-- 
												<label class="checkbox-inline">
													<input type="radio" name="form.teSex" id="form.teSex"
														value="0">&nbsp; &nbsp;男
												</label> 
												<label class="checkbox-inline"> 
													<input type="radio" name="form.teSex" id="form.teSex"
														 value="1">&nbsp; &nbsp;女
												</label>
												 -->
												 <select name="form.teSex" id="form.teSex"
													class="form-control" >	
													<option value="0">男</option>
													<option value="1">女</option>
												</select>
											</div>
										</div>

									</div>
								</div>
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">居住地址：</label>
											<div class="col-sm-8">
												<input name="form.teLocation" id="form.teLocation" type="text"
													class="form-control">
											</div>
										</div>

									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">手机号：</label>
											<div class="col-sm-8">
												<input name="form.teMobile" id="form.teMobile" type="text"
													class="form-control">
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