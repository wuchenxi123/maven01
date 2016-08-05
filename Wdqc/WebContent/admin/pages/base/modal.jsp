<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<%
	String ctx = request.getContextPath();
%>
<html>
<head>
<title>数据选择器</title>
<script src="<%=ctx%>/admin/pages/base/modal.js"
	type="text/javascript"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="gridSystemModalLabel">数据选择器</h4>
	</div>
	<div class="modal-body">
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
	<div class="modal-footer">
		<button type="button" class="btn btn-primary fa fa-close" data-dismiss="modal">关闭</button>
	</div>
</body>
</html>
