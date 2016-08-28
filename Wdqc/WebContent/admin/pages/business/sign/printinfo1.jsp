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
<script src="<%=ctx%>/admin/pages/business/sign/printinfo.js"
	type="text/javascript"></script>
<title>报名信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		前台业务<small>学生报名</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">前台业务</a></li>
		<li class="active">学生报名</li>
	</ol>
	</section>

	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<div id="myTabContent" class="tab-content ">
				<div id="info" class="tab-pane fade in active">
					<form role="form" class="form-horizontal">
						<input type="hidden" name="form.stId" id="form.stId" /> <input
							type="hidden" name="form.stStatus" id="form.stStatus" value="0" />
						<input type="hidden" name="form.createTime" id="form.createTime" />
						<input type="hidden" name="form.creator" id="form.creator"
							value="1" /> <input type="hidden" name="form.updator"
							id="form.updator" /> <input type="hidden" name="form.updateTime"
							id="form.updateTime" />
						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">学生详细信息</h3>
							</div>
							<div class="panel-body" style="height: 355px;">
								<div class="row">
									<div class="col-xs-12">
										<div class="box box-primary">
											<div class="box-body">

												<table border="1" bordercolor="a0c6e5" align=center
													cellspacing=1 cellpadding=3
													style="border-collapse: collapse; text-align: center;">
													<tbody style="text-align: center;">
														<tr>
															<td>班级</td>
															<td>课程</td>
															<td width="200px">上课时长</td>
															<td width="200px">上课时段</td>
														</tr>
														<tr>
															
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>

								</div>

							</div>
						</div>
						<a class="btn btn-primary" onClick='javascript:window.print()'>
							<i class="fa fa-save"></i>打印
						</a>
					</form>
				</div>

			</div>
		</div>
	</div>
	</section>
</body>
</html>