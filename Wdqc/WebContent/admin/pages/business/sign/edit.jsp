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
<script src="<%=ctx%>/admin/pages/business/sign/edit.js"
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
												<div class="col-sm-12">
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员姓名：</label>
															<div class="col-sm-8">
																<input name="form.stName" id="form.stName" type="text"
																	class="form-control">
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员性别：</label>
															<div class="col-sm-8">
																<select class="form-control" name="form.stSex"
																	id="form.stSex">
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
																	class="form-control">
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员生日：</label>
															<div class="col-sm-8">
																<input name="form.stBirthday" id="form.stBirthday"
																	type="text" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员电话：</label>
															<div class="col-sm-8">
																<input name="form.stMobile" id="form.stMobile"
																	type="text" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">家长电话：</label>
															<div class="col-sm-8">
																<input name="form.stMotherMobile"
																	id="form.stMotherMobile" type="text"
																	class="form-control">
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">学员邮箱：</label>
															<div class="col-sm-8">
																<input name="form.stEmail" id="form.stEmail" type="text"
																	class="form-control">
															</div>
														</div>
													</div>

													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">居住区域：</label>
															<div class="col-sm-8">
																<input name="form.stReside" id="form.stReside"
																	type="text" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">兴趣爱好：</label>
															<div class="col-sm-8">
																<input name="form.stHobbies" id="form.stHobbies"
																	type="text" class="form-control">
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">备注信息：</label>
															<div class="col-sm-8">
																<input name="form.stRemark" id="form.stRemark"
																	type="text" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">报名校区：</label>
															<div class="col-sm-8">
																<select class="form-control"
																	name="form.stLocationSchool" id="form.stLocationSchool">

																</select>
															</div>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">销售推荐：</label>
															<div class="col-sm-8">
																<select class="form-control" name="form.slId"
																	id="form.slId">
																	<option value="1">无</option>
																	<option value="2">李建</option>
																	<option value="3">张华</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-4"></div>
												<div class="col-sm-4"></div>


											</div>
										</div>
									</div>

								</div>

							</div>
						</div>
						<%-- <div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">報班详细信息</h3>
							</div>
							<div class="panel-body">
								<div class="col-sm-4">
									<div class="form-group">
										<label class="col-sm-4 control-label">选择班级：</label>
										<div class="col-sm-8">
											<j:selector name="param._ne_csId" definition="#Gradlass"
												cssClass="form-control"
												condition="_sk_csName:;_orderby:csId;_desc:1;queryAll:true;" />
										</div>

									</div>
								</div>
								<div class="col-sm-8">
									<!-- <div class="form-group">
												<label class="col-sm-3 control-label">静态常量的方式：</label>
												<div class="col-sm-3">
													<a class="btn btn-default reload"
														onclick="$.page.getFormData('#test_form');"> <i
														class="fa fa-search"></i> 查看内容
													</a> <a class="btn btn-default reset"
														onclick="$.page.resetForm('#test_form');"> <i
														class="fa fa-reply-all"></i> 复位
													</a>
												</div>
											</div> -->

								</div>
								<div class="col-sm-12" style="margin-top: 100px;">
									<div id="showgradss"></div>
								</div>
								<div class="col-sm-12">
									<div class="col-xs-2 col-xs-offset-10 text-danger">
										<div>
											<span>总价:</span>￥<span id="charge">0</span>
										</div>
									</div>
								</div>
							</div>
						</div>
 --%>
						<a class="btn btn-primary" onclick="$.page.config.fnSave();">
							<i class="fa fa-save"></i>提交
						</a>
					</form>

				</div>


			</div>
		</div>


	</div>
	</section>
</body>
</html>