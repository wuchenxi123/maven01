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
<script src="<%=ctx%>/admin/pages/business/renewal/changeclass.js"
	type="text/javascript"></script>
<title>报名信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
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
							id="form.updateTime" /> <input name="form.gsName"
							id="form.gsName" type="text" class="form-control hidden">
						<input name="form.cltSum" id="form.cltSum" type="text"
							class="form-control hidden"> <input name="form.csId"
							id="form.csId" type="hidden" class="form-control"><input
							name="form.cltSaleboolname" id="form.cltSaleboolname" type="text"
							class="form-control hidden"> <input
							name="form.cltSaletextbookid" id="form.cltSaletextbookid"
							type="text" class="form-control hidden"> <input
							name="form.cltReduce" id="form.cltReduce" type="text"
							class="form-control hidden">
						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">学生详细信息</h3>
							</div>
							<div class="panel-body" style="height: 355px;">
								<div class="row">
									<div class="col-xs-12">
										<div class="box box-primary">
											<div class="box-body">
												<div class="col-sm-12">
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员姓名：</label>
															<div class="col-sm-8">
																<input name="form.stName" id="form.stName" type="text"
																	class="form-control" disabled>
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员性别：</label>
															<div class="col-sm-8">
																<select class="form-control" name="form.stSex"
																	id="form.stSex" disabled>
																	<option value="0">男</option>
																	<option value="1">女</option>

																</select>
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员年龄：</label>
															<div class="col-sm-8">
																<input name="form.stAge" id="form.stAge" type="text"
																	class="form-control" disabled>
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">

													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员电话：</label>
															<div class="col-sm-8">
																<input name="form.stMobile" id="form.stMobile"
																	type="text" class="form-control" disabled>
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">家长电话：</label>
															<div class="col-sm-8">
																<input name="form.stMotherMobile"
																	id="form.stMotherMobile" type="text"
																	class="form-control" disabled>
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员邮箱：</label>
															<div class="col-sm-8">
																<input name="form.stEmail" id="form.stEmail" type="text"
																	class="form-control" disabled>
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">


													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">居住区域：</label>
															<div class="col-sm-8">
																<input name="form.stReside" id="form.stReside"
																	type="text" class="form-control" disabled>
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">报名校区：</label>
															<div class="col-sm-8">
																<select class="form-control"
																	name="form.stLocationSchool" id="form.stLocationSchool"
																	disabled>

																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">
													<!-- <div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">备注信息：</label>
															<div class="col-sm-8">
																<input name="form.stRemark" id="form.stRemark"
																	type="text" class="form-control" disabled>
															</div>
														</div>
													</div> -->

													<%-- <div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">销售推荐：</label>
															<div class="col-sm-8">
																<select class="form-control" name="form.slId"
																	id="form.slId" disabled>
																	<option value="1">无</option>
																	<option value="2">李建</option>
																	<option value="3">张华</option>
																</select>
															</div>
														</div>
													</div> --%>
												</div>
												<div class="col-sm-4"></div>
												<div class="col-sm-4"></div>


											</div>
										</div>
									</div>

								</div>

							</div>
						</div>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">報班详细信息</h3>
							</div>
							<div class="panel-body">
								<div class="col-sm-4">
									<div class="form-group">
										<label class="col-sm-4 control-label">历史报名记录</label>

									</div>
								</div>
								<div class="col-sm-7">
									<div class="pull-right">
										<%-- <span>历史报名总费用:</span>￥<span id="charge1" class="text-danger">0</span> --%>
									</div>
								</div>
								<div class="col-sm-12">
									<table id="user_datatable"
										class="table table-bordered table-striped table-hover">
										<thead>
											<tr>
												<th></th>
												<th>班级名称</th>
												<th>班级容量</th>
												<th>开课日期</th>
												<th>结课日期</th>
												<th>报班学费</th>
												<th>报名时间</th>
												<th>操作</th>
											</tr>
										</thead>

										<tfoot>
											<tr>
												<th></th>
												<th>班级名称</th>
												<th>班级容量</th>
												<th>开课日期</th>
												<th>结课日期</th>
												<th>报班学费</th>
												<th>报名时间</th>
												<th>操作</th>
											</tr>
										</tfoot>
									</table>
								</div>

								<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title" id="myModalLabel">办理转班</h4>
											</div>
											<div class="modal-body">
												<div class="col-sm-12" style="margin-top: 25px;">

													<div id="showgrad"></div>
												</div>
												<div class="col-sm-12">
													<div class="form-group">
														<label class="col-sm-4 control-label">选择转入班级：</label>
														<div class="col-sm-8">
															<j:selector name="param._ne_csId" definition="#Gradlass"
																cssClass="form-control"
																condition="_sk_csName:;_orderby:csId;_desc:1;queryAll:true;" />
														</div>

													</div>
												</div>

												<div class="col-sm-12" style="margin-top: 25px;">

													<div id="showgradss"></div>
												</div>
												<div class="col-sm-12">
													<div class="col-xs-2 col-xs-offset-10">
														<div>
															<span>报名总费用:</span>￥<span id="charge" class="text-danger">0</span>
														</div>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
												<button type="button" class="btn btn-primary"
													data-dismiss="modal" onclick="$.page.config.fnFinish();">
													确定</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
							</div>
						</div>
					</form>

				</div>


			</div>
		</div>


	</div>


	</section>

</body>
</html>