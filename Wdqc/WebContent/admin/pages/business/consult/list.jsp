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

<script src="<%=ctx %>/admin/pages/business/consult/list.js" type="text/javascript" ></script>



<body>
<!-- Content Header (Page header) -->
	<section class="content-header">
<!-- 		<h1>
			资询管理 <small>查询资询信息</small>
		</h1> -->
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>资询管理管理</a></li>    
			<li class="active">查询资询信息</li>
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
										<label class="col-sm-4 control-label">按名字查询：</label>
										<div class="col-sm-3">
											<input name="param._sk_adName" id="param._sk_adName" type="text" class="form-control" placeholder="按用户名模糊查询">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">手机：</label>
										<div class="col-sm-3">
											<input name="param._sk_adPhone" id="param._sk_adPhone" type="text" class="form-control" placeholder="按手机模糊查询">
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
									<th>资询者</th>
									<th>性别</th>
									<th>资询方式</th>
									<th>电话</th>
									<th>email</th>
									<th>兴趣</th>
									<th>地址</th>
									<th>资询课程</th>
									<th>意向度</th>
									<th>经办人</th>
									<th>创建时间</th>
									<th></th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>														
									<th>资询者</th>
									<th>性别</th>	
									<th>资询方式</th>	
									<th>电话</th>
									<th>email</th>
									<th>兴趣</th>
									<th>地址</th>
									<th>资询课程</th>
									<th>意向度</th>
									<th>经办人</th>
									<th>创建时间</th>
									<th></th>
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