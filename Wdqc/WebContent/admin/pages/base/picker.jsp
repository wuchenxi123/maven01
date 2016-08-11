<%-- <%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>数据选择器</title>

<!-- Head Css -->
<%@ include file="styles.jsp"%>

<!-- JS -->
<%@ include file="scripts.jsp"%>

<script src="<%=ctx%>/admin/pages/base/modal.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper" id="body-wrapper-div">
		<div class="content-wrapper" id="content-wrapper-div" style="margin-left:0px;">

			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					数据选择器 <small>表单选择数据通用窗口</small>
				</h1>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-primary">
							<!-- /.box-header -->
							<div class="box-body">
								<div id="Picker_Datatable_Param_Form" style="display: none;">
									<form class="form-horizontal" onkeydown="if(event.keyCode==13){return false;}">
										<div class="col-sm-6">
											<div class="form-group">
												<label class="col-sm-5 control-label">名称：</label>
												<div class="col-sm-1">
													<input name="name" id="name" type="text" class="form-control" width="20px">
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<a class="btn btn-default" href="javascript:$.page.config.reloadPicker();"> <i class="fa fa-search"></i> 查询
											</a> <a class="btn btn-default" onclick="$.page.resetForm('.Picker_Datatable_Param_Form form');"> <i class="fa fa-reply-all"></i> 复位
											</a>
										</div>
									</form>
								</div>
								<table id="Picker_Datatable" class="table table-bordered table-striped table-hover">
									<thead>
										<tr>
											<th></th>
											<th>编码</th>
											<th>名称</th>
											<th></th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th></th>
											<th>编码</th>
											<th>名称</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</body>
</html>
 --%>