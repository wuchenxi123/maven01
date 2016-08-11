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
	var ctx = "${pageContext.request.contextPath}"
</script>
<script src="<%=ctx%>/admin/pages/education/classroom/add.js" type="text/javascript"></script>
<title>添加课程信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">教务教学</a></li>
		<li class="active">添加教室</li>
	</ol>
	</section>

	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<div id="myTabContent" class="tab-content ">
				<div id="info" class="tab-pane fade in active">
					<form role="form" class="form-horizontal">
						<input type="hidden" name="form.crId" id="form.crId" />
						<input type="hidden" name="form.msStartDate" id="form.msStartDate" />
						<input type="hidden" name="form.msEndDate" id="form.msEndDate" />
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">
									<i class='fa fa-github'></i>教室信息
								</h3>
							</div>
							<div class="box-body">
								<div class="col-sm-12">

									<div class="form-group">
										<label class="col-sm-2 control-label">教室名称：</label>
										<div class="col-sm-10">
											<input name="form.crName" id="form.crName" type="text"
												class="form-control" placeholder="教室名称">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">教室容量：</label>
										<div class="col-sm-10">
											<input name="form.crCapacity" id="form.crCapacity" type="text"
												class="form-control" placeholder="教室容量">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">所属校区：</label>
										<div class="col-sm-10">
												<select name="form.crCampus" id="form.crCampus"
													class="form-control">	
												</select>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>

					<div class="col-xs-12">
						<div class="col-xs-4 col-xs-offset-4" style="height: 155px;">
							<button type="button" onclick="$.page.config.fnSave();"
								class="btn btn-primary  btn-lg btn-block">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</button>
						</div>
					</div>
				</div>

			</div>
		</div>


	</div>
	</section>
</body>
</html>