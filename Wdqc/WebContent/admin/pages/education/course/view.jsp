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
	var ctx="${pageContext.request.contextPath}"
</script>
<script src="<%=ctx %>/admin/pages/education/course/view.js" type="text/javascript" ></script>
<title>添加课程信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
			<li><a href="#">课程管理</a></li>
			<li class="active">添加课程</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">

				<div id="myTabContent" class="tab-content ">
					<div id="info" class="tab-pane fade in active">
						<form role="form" class="form-horizontal">
							<input type="hidden" name="form.coId" id="form.coId" />
							<input type="hidden" name="form.creator" id="form.creator"/>
						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">课程详细信息</h3>
							</div>
						<div class="panel-body" style="height: 200px;">
						<div class="row">
							<div class="col-sm-12">
								
								<div class="form-group">
									<label class="col-sm-2 control-label">课程名称：</label>
									<div class="col-sm-10">
										<input name="form.coName" id="form.coName" type="text" class="form-control">
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								
								<div class="form-group">
									<label class="col-sm-2 control-label">更新时间：</label>
									<div class="col-sm-10">
										<input name="form.updatetime" id="form.updatetime" type="text" class="form-control">
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								
								<div class="form-group">
									<label class="col-sm-2 control-label">创建时间：</label>
									<div class="col-sm-10">
										<input name="form.createtime" id="form.createtime" type="text" class="form-control">
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>
					<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">课程列表信息</h3>
							</div>
							<div class="panel-body">
								<div class="col-sm-8">
								</div>
								<div class="col-sm-12">
									<table id="user_datatable"
										class="table table-bordered table-striped table-hover">
										<thead>
											<tr>
												<th></th>
												<th>课程名</th>
												<th>经办人</th>
												<th>更新时间</th>
												<th>创建时间</th>
												<th></th>
											</tr>
										</thead>

										<tfoot>
											<tr>
												<th></th>
												<th>课程名</th>
												<th>经办人</th>
												<th>更新时间</th>
												<th>创建时间</th>
												<th></th>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>
						</div>
						<a class="btn btn-primary" onclick="$.page.config.fnFinish();">
							<i class="fa fa-save"></i>返回列表
						</a>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>