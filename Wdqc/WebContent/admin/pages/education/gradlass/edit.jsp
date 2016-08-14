<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<script src="<%=ctx%>/admin/pages/education/gradlass/edit.js"
	type="text/javascript"></script>
	
<title>添加班级信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">教务教学</a></li>
		<li class="active">编辑班级</li>
	</ol>
	</section>

	<!-- Main content -->

	<section class="content">
	<form role="form" class="form-horizontal">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">班级详细信息</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">
						<input type="hidden" name="form.createTime" id="form.createTime" />
						<input type="hidden" name="form.csId" id="form.csId" />
						<input type="hidden" name="form.gradlassTeacher" id="form.gradlassTeacher" />
						<div class="box box-primary">
							<div class="box-body">
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">校区：</label>
											<div class="col-sm-8">
												<select name="form.cpId" id="form.cpId"
													class="form-control">	
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">班级名称：</label>
											<div class="col-sm-8">
												<input name="form.csName" id="form.csName" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">课程：</label>
											<div class="col-sm-8">
												<select name="form.coId" id="form.coId"
													class="form-control">
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<div class="col-sm-8">
												<select name="form.coClassify"
													id="form.coClassify" class="form-control">
												</select>
											</div>
										</div>
									</div>
								</div>


								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">学费标准：</label>
											<div class="col-sm-8">
												<input name="form.csCharge" id="form.csCharge" type="text"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="form-group">
											<label class="col-sm-4 control-label">元 / 期</label>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">课时总计：</label>
											<div class="col-sm-8">
												<input name="form.csClasshour" id="form.csClasshour"
													type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<label class="col-sm-20 control-label">
												课时 (如果每节课包含1课时，则课时总计等于上课次数)</label>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">每次上课 ： </label>
											<div class="col-sm-8">
												<input name="form.csEveryclass" id="form.csEveryclass"
													type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<label class="col-sm-20 control-label">课时(教师记上课和学员刷卡默认消耗的课时)</label>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">开班日期区间：</label>
											<div class="col-sm-8">
								                 <fieldset>
								                  <div class="control-group">
								                    <div class="controls">
								                     <div class="input-prepend input-group">
								                       <span class="add-on input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span><input type="text" readonly="readonly" style="width: 200px" name="reservation" id="reservation" class="form-control" /> 
								                     </div>
								                    </div>
								                  </div>
								                 </fieldset>
								                 <input name="form.csOpendatestart"
													id="form.csOpendatestart" type="hidden"
													class="form-control">
												<input name="form.csOpendateend"
												id="form.csOpendateend" type="hidden"
												class="form-control">
											<!-- 
												<input name="form.csOpenDateStart"
													id="form.course.csOpenDateStart" type="text"
													class="form-control">
													 -->
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<div class="col-sm-1">
												<input name="form.csOpendatestatus"
													id="form.csOpendatestatus" type="checkbox" 
													class="form-control" style="width: 16px; height: 16px;" >
											</div>
											<label class="col-sm-2 control-label">待定</label>

										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">教师名称 ：</label>
											<div class="col-sm-8" id="form.teaSelect">
												<select name="form.teaList[0].teId" id="form.teacher.teId"
													class="form-control">
												</select>
																							
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="form-group">
											<input type="button" value="添加"
												style="width: 40px; height: 30px;" onclick="$.page.config.addTeacher();" id="form.teaAdd">
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">原有教师：</label>
											<div class="col-sm-8" id="teacherarea">
											
											</div>
										</div>
									</div>
									
									
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">教室名称 ：</label>
											<div class="col-sm-8">
													<select name="form.crId"
													id="form.classroom.crName"
													class="form-control">
													</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<input type="button" value="教室时段"
												style="width: 60px; height: 30px;">
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">上课时间：</label>
											<div class="col-sm-8">
												<select name="form.csWeekend" id="form.csWeekend"
													class="form-control">
													<option value="周六">周六</option>
													<option value="周日">周日</option>
													<option value="周一">周一</option>
													<option value="周二">周二</option>
													<option value="周三">周三</option>
													<option value="周四">周四</option>
													<option value="周五">周五</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<div class="col-sm-3">
												<select name="form.csDateStartHour"
													id="form.csDateStartHour" class="form-control">
													<option value="05">05</option>
													<option value="06">06</option>
													<option value="07">07</option>
													<option value="08">08</option>
													<option value="09">09</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
													<option value="13">13</option>
													<option value="14">14</option>
													<option value="15">15</option>
													<option value="16">16</option>
													<option value="17">17</option>
													<option value="18">18</option>
													<option value="19">19</option>
													<option value="20">20</option>
													<option value="21">21</option>
													<option value="22">22</option>
													<option value="23">23</option>
												</select>
											</div>
											<div class="col-sm-3">
												<select name="form.csDateStartMinute"
													id="form.csDateStartMinute" class="form-control">
													<option value="00">00</option>
													<option value="10">10</option>
													<option value="20">20</option>
													<option value="30">30</option>
													<option value="40">40</option>
													<option value="50">50</option>
												</select>
											</div>
											<div class="col-sm-1">
												<label class="col-sm-4 control-label">到</label>
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<div class="form-group">
											<div class="col-sm-3">
												<select name="form.csDateEndHour" id="form.csDateEndHour"
													class="form-control">
													<option value="05">05</option>
													<option value="06">06</option>
													<option value="07">07</option>
													<option value="08">08</option>
													<option value="09">09</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
													<option value="13">13</option>
													<option value="14">14</option>
													<option value="15">15</option>
													<option value="16">16</option>
													<option value="17">17</option>
													<option value="18">18</option>
													<option value="19">19</option>
													<option value="20">20</option>
													<option value="21">21</option>
													<option value="22">22</option>
													<option value="23">23</option>
												</select>
											</div>
											<div class="col-sm-3">
												<select name="form.csDateEndMinute"
													id="form.csDateEndMinute" class="form-control">
													<option value="00">00</option>
													<option value="10">10</option>
													<option value="20">20</option>
													<option value="30">30</option>
													<option value="40">40</option>
													<option value="50">50</option>
												</select>
												
											</div>
											
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">上课时间待定</label>
											<div class="col-sm-8">
												<input name="form.classtime"
													id="form.classtime" type="checkbox"
													class="form-control" style="width: 16px; height: 16px;">
												
											</div>
										</div>
									</div>

								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">额定人数：</label>
											<div class="col-sm-8">
												<input name="form.csPeoplecount" id="form.csPeoplecount"
													type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="form-group">
											<label class="col-sm-4 control-label">人</label>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">到校通知 ：</label>
											<div class="col-sm-6">
												<input name="form.csArriveinform"
													id="form.csArriveinform" type="checkbox"
													class="form-control" style="width: 16px; height: 16px;">
											</div>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<label class="col-sm-12 control-label">本班学员刷卡签到自动短信通知父母
											</label>
											<div class="col-sm-4"></div>
										</div>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="col-sm-20">
										<div class="form-group">
											<label class="col-sm-4 control-label">备注 ：</label>
											<div class="col-sm-8">
												<textarea rows="3" cols="20" name="form.csRemark"
													id="form.csRemark" class="form-control"></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="col-xs-4 col-xs-offset-4" style="height: 155px;">
				<button type="button" onclick="$.page.config.finish();"
					class="btn btn-primary  btn-lg btn-block">保存</button>
			</div>
		</div>
	</form>
	</section>

</body>
</html>