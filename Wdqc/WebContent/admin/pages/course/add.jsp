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
<script src="<%=ctx %>/admin/pages/course/add.js" type="text/javascript" ></script>
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
							<input type="hidden" name="form.createTime" id="form.createTime"/>
							<input type="hidden" name="form.creator" id="form.creator"/>
												<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">
								<i class='fa fa-github'></i> 课程信息
							</h3>
						</div>
						<div class="box-body">
							<div class="col-sm-12">
								
								<div class="form-group">
									<label class="col-sm-2 control-label">课程名称：</label>
									<div class="col-sm-10">
										<input name="form.coName" id="form.coName" type="text" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">课程周期：</label>
									<div class="col-sm-10">
										<input name="form.coCycle" id="form.coCycle" type="text" class="form-control" placeholder="上课周期">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">课程费用：</label>
									<div class="col-sm-10">
										<input name="form.coCharge" id="form.coCharge" type="text" class="form-control" placeholder="课程费用">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"><i class="fa fa-mobile-phone"></i> 授课老师：</label>
									<div class="col-sm-10">
										<input name="form.coTeacher" id="form.coTeacher" type="text" class="form-control" placeholder="授课老师名称">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"><i class="fa fa-envelope-o"></i> 助教：</label>
									<div class="col-sm-10">
										<input name="form.coTutor" id="form.coTutor" type="email" class="form-control" placeholder="助教名称">
									</div>
								</div>

							</div>
						</div>
					</div>
						</form>
						<div class="box-footer nav nav-tabs" id="myTab">
							<!-- <button class="btn btn-primary fa fa-floppy-o" onclick="$.page.config.fnSave();">保存</button> -->
							<a href="#fileup" data-toggle="tab" class="btn btn-primary"
								onclick="finish();"> <i class="fa fa-save"></i> 保存
							</a>
						</div>
					</div>
				
				</div>
			</div>


		</div>
	</section>
</body>
</html>