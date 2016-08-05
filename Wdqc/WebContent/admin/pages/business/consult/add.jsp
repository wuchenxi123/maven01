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

	<section class="content">
	<form role="form" class="form-horizontal">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">学生详细信息</h3>
			</div>
			<div class="panel-body" style="height: 255px;">
				<div class="row">
					<div class="col-xs-12">

						<input type="hidden" name="form.adId" id="form.adId" /> <input
							type="hidden" name="form.createTime" id="form.createTime" /> <input
							type="hidden" name="form.creator" id="form.creator" value="1" />
						<input type="hidden" name="form.updator" id="form.updator" /> <input
							type="hidden" name="form.updateTime" id="form.updateTime" />
						<div class="box box-primary">
							<div class="box-body">
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">咨询者名：</label>
											<div class="col-sm-8">
												<input name="form.adName" id="form.adName" type="text"
													class="form-control">
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">资询者性别：</label>
											<div class="col-sm-8">
												<label class="checkbox-inline"> <input type="radio"
													name="form.adSex" id="optionsRadios3" value="1" checked>男
												</label> <label class="checkbox-inline"> <input type="radio"
													name="form.adSex" id="optionsRadios4" value="2">女
												</label>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">资询者电话：</label>
											<div class="col-sm-8">
												<input name="form.adPhone" id="form.adPhone" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">资询者邮箱：</label>
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
								</div>
								<div class="col-sm-12">
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
		<div class="panel panel-primary">
			<div class="panel-body">
				<div class="col-sm-12">
					<div class="form-group">
						<label class="col-sm-2 control-label">咨询方式：</label>
						<div class="col-sm-10">
							<label class="checkbox-inline"> <input type="radio"
								name="form.adWays" id="form.adWays" value="0" checked>
								来访
							</label> <label class="checkbox-inline"> <input type="radio"
								name="form.adWays" id="form.adWays" value="1"> 来电
							</label> <label class="checkbox-inline"> <input type="radio"
								name="form.adWays" id="form.adWays" value="2"> 网络
							</label> <label class="checkbox-inline"> <input type="radio"
								name="form.adWays" id="form.adWays" value="3"> 其他
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">咨询课程：</label>
						<div class="col-sm-6">
							<select name="form.adCourse" id="form.adCourse"
								class="form-control">
							</select>

						</div>
						<div class="col-sm-4"></div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">咨询内容：</label>
						<div class="col-sm-6">
							<textarea name="form.adContent" id="form.adContent" rows="5"
								class="form-control"></textarea>
						</div>
						<div class="col-sm-4"></div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">学习意向：</label>

						<div class="col-sm-6">
							<label class="checkbox-inline"> <input type="radio"
								name="form.adIntention" id="optionsRadios3" value="0" checked>
								一般
							</label> <label class="checkbox-inline"> <input type="radio"
								name="form.adIntention" id="optionsRadios4" value="1">
								中等
							</label> <label class="checkbox-inline"> <input type="radio"
								name="form.adIntention" id="optionsRadios4" value="2">
								强烈
							</label>
						</div>
						<div class="col-sm-4"></div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">标记：</label>
						<div class="col-sm-6">
							<input name="form.adRemarks" id="form.adRemarks" type="text"
								class="form-control">
						</div>
						<div class="col-sm-4"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="col-xs-4 col-xs-offset-4" style="height: 155px;">
				<button type="button" onclick="$.page.config.fnSave();"
					class="btn btn-primary  btn-lg btn-block">提交</button>
			</div>
		</div>
	</form>
	</section>

</body>
</html>