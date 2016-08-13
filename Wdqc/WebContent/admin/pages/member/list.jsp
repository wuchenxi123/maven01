<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var ctx="${pageContext.request.contextPath}";
</script>
<script src="<%=ctx %>/admin/pages/member/list.js" type="text/javascript" ></script>



<body>
<!-- Content Header (Page header) -->
	<input type="hidden" name="form.appStatus" id="form.appStatus" value="1"/>
	<section class="content-header">
<!-- 		<h1>
			课程管理 <small>查询课程信息</small>
		</h1> -->
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>用户管理</a></li>    
			<li class="active">查询用户信息</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<!-- /.box-header -->
					<div class="box-body">
						<table id="user_datatable" class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th></th>
									<th>用户名</th>
									<th>性别</th>
									<th>角色</th>
									<th>真实姓名</th>
									<th>邮箱</th>
									<th>手机</th>
									<th>操作</th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>
									<th>用户名</th>
									<th>性别</th>
									<th>角色</th>
									<th>真实姓名</th>
									<th>邮箱</th>
									<th>手机</th>
									<th>操作</th>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>