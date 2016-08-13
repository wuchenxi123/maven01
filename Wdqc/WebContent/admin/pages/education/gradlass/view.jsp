<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
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
<script src="<%=ctx%>/admin/pages/education/gradlass/view.js"
	type="text/javascript"></script>
<title>报名信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">教务教学</a></li>
		<li class="active">学生名单</li>
	</ol>
	</section>

	<!-- Main content -->
	<section class="content">
 <form role="form" class="form-horizontal"> 
	<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">班级详细信息</h3>
			</div>
			<div class="panel-body" style="height: 270px;">
				<div class="row">
					<div class="col-xs-12">

						<input type="hidden" name="form.csId" id="form.csId" />
						<input type="hidden" name="form.gradlassTeacher" id="form.gradlassTeacher" />
						<div class="box box-primary">
							<div class="box-body">
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">校区：</label>
											<div class="col-sm-8">
												<select name="form.cpId" id="form.cpId"
													class="form-control">	
													</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">班级名称：</label>
											<div class="col-sm-8">
												<input name="form.csName" id="form.csName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学费标准：</label>
											<div class="col-sm-8">
												<input name="form.csCharge" id="form.csCharge" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">课程：</label>
											<div class="col-sm-8">
											<select name="form.coId" id="form.coId"
													class="form-control">
													</select>	
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">课时：</label>
											<div class="col-sm-8">
												<input name="form.csClasshour" id="form.csClasshour" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">教室名称 ：</label>
											<div class="col-sm-8">
											<select name="form.crId" id="form.crId"
													class="form-control">
													</select>	
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">开课时间：</label>
											<div class="col-sm-8">
												<input name="form.csOpendatestart" id="form.csOpendatestart" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">结束时间：</label>
											<div class="col-sm-8">
												<input name="form.csOpendateend" id="form.csOpendateend" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">上课时间：</label>
											<div class="col-sm-8">
											<input name="form.csWeekend" id="form.csWeekend" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-5 control-label"></label>
											<div class="col-sm-3">
											<input name="form.csDateStartHour" id="form.csDateStartHour" type="text"
													class="form-control">
											</div>
											<div class="col-sm-3">
											<input name="form.csDateStartMinute" id="form.csDateStartMinute" type="text"
													class="form-control">
											</div>
											
										</div>
									</div>
									<div class="col-sm-1">
										<div class="form-group">
											<div class="col-sm-1">
												<label class="col-sm-1 control-label">到</label>
											</div>
										</div>
									</div>
									
									<div class="col-sm-3">
										<div class="form-group">
											<label class="col-sm-3 control-label"></label>
											<div class="col-sm-4">
											<input name="form.csDateEndHour" id="form.csDateEndHour" type="text"
													class="form-control">
											</div>
											<div class="col-sm-4">
											<input name="form.csDateEndMinute" id="form.csDateEndMinute" type="text"
													class="form-control">
											</div>
											
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">教师名称 ：</label>
											<div class="col-sm-8" id="form.teaSelect">
												<input name="form.teaList[0].teName" id="form.teaList.teId" 
												type="text" class="form-control"> 
											<!-- <select name="form.teaList[0].teId" id="form.teacher.teId"
													class="form-control">
												</select> -->
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">已有人数 ：</label>
											<div class="col-sm-8" id="form.teaSelect">
												<input name="form.csPeoplecount" id="form.csPeoplecount"
													type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">额定人数：</label>
											<div class="col-sm-8">
												<input name="form.csPeoplecount" id="form.csPeoplecount"
													type="text" class="form-control">
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
<!--  	 <form role="form" class="form-horizontal">--> 
	<div class="panel panel-primary">
			<div class="panel-heading">
<<<<<<< HEAD
							<h3 class="panel-title">班级列表信息</h3>
						</div>
			<div class="row">
			<div class="col-xs-12">
				<div class="box">
					
					<!-- /.box-header -->
					<div class="box-body">
			
						<table id="user_datatable"
							class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th></th>
									<th>班级名称</th>
									<th>人数</th>
									<th>教师</th>
									<th>课程</th>
									<th>开班</th>
									<th>校区</th>
									<th>教室</th>
									<th>学费</th>
									<th>操作</th>
								</tr>
							</thead>
	
							<tfoot>
								<tr>
									<th></th>
									<th>班级名称</th>
									<th>人数</th>
									<th>教师</th>
									<th>课程</th>
									<th>开班</th>
									<th>校区</th>
									<th>教室</th>
									<th>学费</th>
									<th>操作</th>
=======
							<h3 class="panel-title">学生列表信息</h3>
						</div>
			<div class="row">
			<div class="col-xs-12">
				<div class="box">
					
					<!-- /.box-header -->
					<div class="box-body">
			
						<table id="user_datatable"
							class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th></th>																
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>电话</th>
									<th>email</th>
									<th>家长电话</th>
									<th>状态</th>
									<th>居住地</th>
									<th>生日</th>									
									<th>销售人</th>
									<th>报名时间</th>
									<th></th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>																	
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>电话</th>
									<th>email</th>
									<th>家长电话</th>
									<th>状态</th>
									<th>居住地</th>
									<th>生日</th>									
									<th>销售人</th>
									<th>报名时间</th>
									<th></th>
>>>>>>> branch 'master' of git@github.com:wuchenxi123/wdqc.git
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	</section>
</body>
</html>
