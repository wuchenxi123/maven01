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

<script src="<%=ctx %>/admin/pages/education/message/list.js" type="text/javascript" ></script>



<body>
<!-- Content Header (Page header) -->
	<section class="content-header">
<!-- 		<h1>
			资询管理 <small>查询教室信息</small>
		</h1> -->
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>公告管理</a></li>    
			<li class="active">查询公告信息</li>
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
										<label class="col-sm-4 control-label">按标题查询：</label>
										<div class="col-sm-3">
											<input name="param._sk_mgTitle" id="param._sk_mgTitle" type="text" class="form-control" placeholder="按标题模糊查询">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">按类型查询：</label>
										<div class="col-sm-3">
											<select  name="param._se_mgType" id="param._se_mgType"  class="form-control" style="width:120px;">
													<option value="0">教务教学</option>
													<option value="1">人事调整</option>
													<option value="2">比赛通知</option>
													<option value="3">荣誉展示</option>
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
									<th>标题</th>
									<th>公告类型</th>
									<th>创建者</th>
									<th>创建日期</th>
									<th>操作</th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>
									<th>标题</th>
									<th>公告类型</th>
									<th>创建者</th>
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