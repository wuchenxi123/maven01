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

<script src="<%=ctx %>/admin/pages/education/teacher/list.js" type="text/javascript" ></script>



<body>
<!-- Content Header (Page header) -->
	<section class="content-header">
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>教师管理</a></li>    
			<li class="active">全部教室信息</li>
			<a class="btn btn-info pull-right" onclick="exportTeacher()">导出数据</a>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<!-- /.box-header -->
					<div class="box-body">
					<div id="Datatable_Param_Form" style="display: none;">
						
							<form class="form-horizontal">
								<div class="col-sm-9">
									<div class="form-group">
										<label class="col-sm-2 control-label">姓名：</label>
										<div class="col-sm-3">
											<input name="param._sk_teName" id="param._sk_teName" type="text" class="form-control" placeholder="按姓名查询">
										</div>
										<label class="col-sm-4 control-label">手机号码：</label>
										<div class="col-sm-3">
											<input name="param._sk_teMobile" id="param._sk_teMobile" type="text" class="form-control" placeholder="按手机号码查询">
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<a class="btn btn-default" href="javascript:reload();"> <i class="fa fa-search"></i> 查询
									</a> <a class="btn btn-default" onclick="$.page.resetForm('.Datatable_Param_Form form');"> <i class="fa fa-reply-all"></i> 复位
									</a>
								</div>
							</form>
						</div>
						<table id="user_datatable" class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th></th>																	
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>课程</th>
									<th>居住区</th>
									<th>手机号</th>
									<th>出勤率</th>
									<th>带班数</th>
									<th>更改时间</th>
									<th>操作</th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>																	
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>课程</th>
									<th>居住区</th>
									<th>手机号</th>
									<th>出勤率</th>
									<th>带班数</th>
									<th>更改时间</th>
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