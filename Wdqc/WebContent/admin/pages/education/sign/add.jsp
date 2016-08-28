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
<script src="<%=ctx%>/admin/pages/business/consult/add.js"
	type="text/javascript"></script>
<title>添加咨询信息</title>
</head>
<body>

	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">前台业务</a></li>
		<li class="active">添加咨询</li>
	</ol>
	</section>

	<!-- Main content -->
	<form role="form" class="form-horizontal">
			<div class="step-body container" id="myStep">

				<div class="step-header" style="width: 80%;">
					<ul>
						<li><p>填写基本信息</p></li>
						<li><p>选择班级</p></li>
						<li><p>完成</p></li>
					</ul>
				</div>
				<div class="step-content">
					<div class="step-list">
						<div class="page-panel-title"style="height:45px;">
							<h3 class="page-panel-title-left">流程说明</h3>
							<h3 class="page-panel-title-right">注：请认真填写报名信息，核对信息是否有误</h3>
						</div>
						<div class="intro-flow">
							<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">学生详细信息</h3>
			</div>
			<div class="panel-body" style="height:255px;">
				<div class="row">
					<div class="col-xs-12">

						<input type="hidden" name="form.adId" id="form.adId" /> 
						<input type="hidden" name="form.createTime" id="form.createTime" /> 
						<input type="hidden" name="form.creator" id="form.creator" />
						<input type="hidden" name="form.updator" id="form.updator" />
						<input type="hidden" name="form.updateTime" id="form.updateTime" />
						<div class="box box-primary">
							<div class="box-body">
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学员姓名：</label>
											<div class="col-sm-8">
												<input name="form.adName" id="form.adName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学员性别：</label>
											<div class="col-sm-8">
												<label class="checkbox-inline"> <input type="radio" name="form.adSex" id="optionsRadios3" value="1" checked>男</label>
												
							 					<label class="checkbox-inline"> <input type="radio" name="form.adSex" id="optionsRadios4" value="2">女</label>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学员年龄：</label>
											<div class="col-sm-8">
												<input name="form.adName" id="form.adName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学员生日：</label>
											<div class="col-sm-8">
												<input name="form.adName" id="form.adName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学员电话：</label>
											<div class="col-sm-8">
												<input name="form.adPhone" id="form.adPhone" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">家长电话：</label>
											<div class="col-sm-8">
												<input name="form.adHobbies" id="form.adHobbies" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学员邮箱：</label>
											<div class="col-sm-8">
												<input name="form.adEmial" id="form.adEmial" type="text"
													class="form-control">
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">居住区域：</label>
											<div class="col-sm-8">
												<input name="form.adAddress" id="form.adAddress" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">兴趣爱好：</label>
											<div class="col-sm-8">
												<input name="form.adHobbies" id="form.adHobbies" type="text"
													class="form-control">
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">备注信息：</label>
											<div class="col-sm-8">
												<input name="form.adRemark" id="form.adRemark" type="text"
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
						</div>
						<div class="footer-btn">
							<div class="common-btn">
								<a href="javascript:void(0);" id="applyBtn">保存基本信息</a>
							</div>
						</div>
					</div>
					<div class="step-list">
						<div class="footer-btn">
							<div class="common-btn">
								<a href="javascript:void(0);" id="submitBtn">提交</a>
							</div>
						</div>

					</div>
					<div class="step-list">
						<div class="apply-finish">
							<div class="apply-finish-header">
								<img src="../admin/plugins/jquery-step/images/success.png">
								<div class="apply-finish-msg">恭喜您，提交成功！</div>
							</div>
							<div class="apply-finish-footer">
								<p>
									尊敬的用户，您已提交成功，受理编号为<span id="proNo">LS23423432</span>。
								</p>
								<p>
									<a href="demo-step.html">查看单独demo</a>
								</p>
							</div>
						</div>
					</div>

				</div>

			</div>
	</form>

	<script>
		$(function() {

			var step = $("#myStep").step({
				animate : true,
				initStep : 1,
				speed : 1000
			});

			$("#preBtn").click(function(event) {
				var yes = step.preStep();

			});
			$("#applyBtn").click(function(event) {
				var yes = step.nextStep();

			});
			$("#submitBtn").click(function(event) {
				var yes = step.nextStep();

			});
			$("#goBtn").click(function(event) {
				var yes = step.goStep(3);

			});

		});
	</script>
</body>
</html>