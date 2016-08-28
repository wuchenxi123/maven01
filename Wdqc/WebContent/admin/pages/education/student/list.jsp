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

<script src="<%=ctx %>/admin/pages/education/student/list.js" type="text/javascript" ></script>



<body>
<!-- Content Header (Page header) -->
	<section class="content-header">
<!-- 		<h1>
			资询管理 <small>查询资询信息</small>
		</h1> -->
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>学生管理</a></li>    
			<li class="active">全部学生信息</li>
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
										<label class="col-sm-4 control-label">姓名：</label>
										<div class="col-sm-3">
											<input type="hidden" name="form.csId" id="form.csId" />
											<input name="param._sk_stName" id="param._sk_stName" type="text" class="form-control" placeholder="按姓名查询">
										</div>
										<label class="col-sm-4 control-label">手机号码：</label>
										<div class="col-sm-3">
											<input name="param._se_stMobile" id="param._se_stMobile" type="text" class="form-control" placeholder="按手机号码查询">
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
									<th>学校</th>
									<th>年级</th>
									<th>居住区</th>
									<th>手机号</th>
									<th>父亲电话</th>
									<th>母亲电话</th>
									<th>状态</th>
									<th>销售人员</th>
									<th>生日</th>
									<th>创建日期</th>
									<th>操作</th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>																	
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>学校</th>
									<th>年级</th>
									<th>居住区</th>
									<th>手机号</th>
									<th>父亲电话</th>
									<th>母亲电话</th>
									<th>状态</th>
									<th>销售人员</th>
									<th>生日</th>
									<th>创建日期</th>
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