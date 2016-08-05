<%--  <%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../base/pager.jsp"%>
</head>
<body>
	<div class="dataTables_wrapper form-inline dt-bootstrap">
		<div class="row header">
			<div class="col-sm-2">
				<div class="dataTables_length"></div>
			</div>
			<div class="col-sm-9">
				<form class="form-horizontal" action="/mb_List.ac" onkeydown="if(event.keyCode==13){return false;}">
					<div class="col-sm-9">
						<div class="form-group">
							<label class="col-sm-4 control-label">用户名：</label>
							<div class="col-sm-8">
								<s:textfield cssClass="form-control" name="param._sk_mbName" id="param._sk_mbName" />
								<input name="param._sk_mbName" class="form-control" id="param._sk_mbName" type="text" placeholder="按用户名模糊查询" value="<s:property value="param._sk_mbName"/>">
								<j:selector name="param._ne_mbId" definition="#Member" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">手机：</label>
							<div class="col-sm-3">
								<input name="param._sk_mbPhone" class="form-control" id="param._sk_mbPhone" type="text" placeholder="按手机模糊查询" value="<s:property value="param._sk_mbPhone"/>">
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<a class="btn btn-default reload" href="#"> <i class="fa fa-search"></i> 查询
						</a> <a class="btn btn-default reset" onclick=""> <i class="fa fa-reply-all"></i> 复位
						</a>
					</div>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<div class="row body">
			<div class="col-sm-12">
				<table id="dict_demo2_datatable" class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th></th>
							<th column="mbId">名称</th>
							<th column="mbSex">性别</th>
							<th column="mbType">用户类型</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="dp.datas" status="s">
							<tr>
								<td align="center" style="width: 2%;"><s:property value="#s.index+1" /></td>
								<td align="left" style="width: 78%;"><j:code2Name definition="#Member" code="mbId" /></td>
								<td align="left" style="width: 10%;"><j:code2Name definition="$SEX" code="mbSex" /></td>
								<td align="left" style="width: 10%;"><j:code2Name definition="$USER_TYPE" code="mbType" /></td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot>
						<tr>
							<th></th>
							<th>名称</th>
							<th>性别</th>
							<th>用户类型</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div class="row foot"></div>
	</div>
</body>
</html> --%>