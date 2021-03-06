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

<script src="<%=ctx %>/admin/pages/education/classroom/list.js" type="text/javascript" ></script>



<body>
<!-- Content Header (Page header) -->
	<section class="content-header">
<!-- 		<h1>
			资询管理 <small>查询教室信息</small>
		</h1> -->
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>资询教室管理</a></li>    
			<li class="active">查询教室信息</li>
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
										<label class="col-sm-4 control-label">按教室名称查询：</label>
										<div class="col-sm-3">
											<input name="param._sk_crName" id="param._sk_crName" type="text" class="form-control" placeholder="按名称模糊查询">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">按校区查询：</label>
										<div class="col-sm-3">
											<select  name="param._ne_crCampus" id="param._ne_crCampus"  class="form-control" style="width:120px;">
											</select>
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
									<th>教室名称</th>
									<th>教室容量</th>
									<th>所在校区</th>
									<th>使用起止</th>
									<th>使用结束</th>
									<th></th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>
									<th>教室名称</th>
									<th>教室容量</th>
									<th>所在校区</th>
									<th>使用起止</th>
									<th>使用结束</th>
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