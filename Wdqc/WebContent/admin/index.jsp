<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
</head>
<%@ include file="pages/base/base.jsp"%>

<%@ include file="pages/base/styles.jsp"%>

<!-- JS -->
<%@ include file="pages/base/scripts.jsp"%>
<script src="<%=ctx%>/admin/dist/js/index.js"
	type="text/javascript"></script>
<style>
.lmadd{
 border-bottom:1px dashed #000;
 padding-bottom: 30px;
 margin-top:15px;
}
</style>
<body>
	<div class="header1" style="border: 2px soid #000">
	
		<h2 style="font-size: 25px;color: #fff;text-align: left;padding:15px;font-family:微软雅黑;">舞动全城教务信息管理系统</h2>
	</div>
	<div class="header">
		<div class="top">
			<img class="logo" src="dist/images/logo1.png"
				style="margin-left: 25px;" />
			<ul class="nav">
				<li><a href="#stu" data-toggle="tab"><i class="ion-film-marker"></i>&nbsp;前台业务</a></li>
				<li><a href="#cou" data-toggle="tab"><i class="ion-printer"></i>&nbsp;教务教学</a></li>
				<li><a href="#per" data-toggle="tab"><i class="ion-person-stalker"></i>&nbsp;人事管理</a></li>
				<li><a href="#fin" data-toggle="tab"><i class="ion-clipboard"></i>&nbsp;财务管理</a></li>
				<li><a href="#mar" data-toggle="tab"><i class="ion-arrow-graph-up-right"></i>&nbsp;市场分析</a></li>
			<!-- 	<li><a href="#che" data-toggle="tab"><i class="ion-card"></i>&nbsp;磁卡考勤</a></li> -->
				<li><a href="#set" data-toggle="tab"><i class="ion-gear-b"></i>&nbsp;系统设置</a></li>
			</ul>
		</div>
	</div>
	<div class="mycontainer">
		<div class="leftbar">
			<div class="lm00">
			<div style="padding-left:20px;">
			<img class="peptx img-circle img-responsive" src="../admin/dist/images/advtar.jpg" width=70; height=70; />
			</div>
				
				<div class="pepdet">
					<p class="pepname"><%=user.getMbName()%></p>
					<p><%=user.getMbPetName()%></p>
				</div>
				<br><br><br><br><br>
				<div class="form-group">
					<label class="col-sm-7 control-label">報名总數：</label>
					<div class="col-sm-5">
						<span id="sgincount">1277</span>
					</div>
				</div>
				<br>
				<div class="form-group">
					<label class="col-sm-7 control-label">收入总数：</label>
					<div class="col-sm-5">
						<span style="width: 145px;" id="fedsum" class="text-danger">￥12万</span>
					</div>
			</div>
				<!-- <div class="form-group">
					<label class="col-sm-5 control-label">校区：</label>
					<div class="col-sm-7">
						<select name="form.stSex" id="form.stSex">
							 <option value="1">湖南衡阳校区</option>
							 <option value="2">湖南省湘潭校区</option>
						 </select>
					</div>
				</div> -->
			</div>
			<div class="lm01">
				<a href="javascript:loadPage('<%=ctx%>/admin/pages/business/consult/list.jsp');"><i class="ion-ios-paper"></i>&nbsp;资询记录<i class="ion-chevron-right pull-right"></i></a>				
			</div>
			<div class="lm01">
				<a href="javascript:loadPage('<%=ctx%>/admin/pages/business/sign/list.jsp');"><i class="ion-social-buffer"></i>&nbsp;报名查询<i class="ion-chevron-right pull-right"></i></a>
			</div>
			<div class="lm01">
				<a href="javascript:loadPage('<%=ctx%>/admin/pages/education/gradlass/list.jsp');"><i class="ion-android-contacts"></i>&nbsp;班级查询<i class="ion-chevron-right pull-right"></i></a>	
			</div>
			<div class="lm01">
				<a href="javascript:loadPage('<%=ctx%>/admin/pages/chart/info.jsp');"><i class="ion-arrow-graph-up-right"></i>&nbsp;市场分析<i class="ion-chevron-right pull-right"></i></a>
			</div>
		</div>

		<div class="mainbody tab-content" id="myTabContent">
			<div class="currmenu tab-pane fade in active" id="stu">
				<ul class="rig_nav">
					<li class="rig_seleli"><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/consult/add.jsp');"><i class="ion-flag text-danger"></i>&nbsp;新咨询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/consult/list.jsp');"><i class="ion-ios-paper text-danger"></i>&nbsp;资询记录</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/sign/add.jsp');"><i class="ion-ios-personadd text-danger"></i>&nbsp;新生报名</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/sign/list.jsp');"><i class="ion-ios-people text-danger"></i>&nbsp;报名查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/renewal/list.jsp');"><i class="ion-ios-refresh text-danger"></i>&nbsp;转班续报</a></li>

					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/suspendclasses/list.jsp');"><i class="ion-ios-pricetag text-danger"></i>&nbsp;办理停课</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/regain/list.jsp');"><i class="ion-ios-pricetag-outline text-danger"></i>&nbsp;停课恢复</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="cou">
				<ul class="rig_nav">
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/gradlass/add.jsp');"><i class="ion-ios-plus text-danger"></i>&nbsp;新增班级</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/gradlass/list.jsp');"><i class="ion-ios-book text-danger"></i>&nbsp;班级查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/teacher/add.jsp');"><i class="ion-ios-personadd text-danger"></i>&nbsp;新建教师</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/teacher/list.jsp');"><i class="ion-ios-list text-danger"></i>&nbsp;教师查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/course/add.jsp');"><i class="ion-flag text-danger"></i>&nbsp;新建课程</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/course/list.jsp');"><i class="ion-ios-list-outline text-danger"></i>&nbsp;课程查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/classroom/add.jsp');"><i class="ion-ios-plus-outline text-danger"></i>&nbsp;添加教室</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/classroom/list.jsp');"><i class="ion-ios-photos text-danger"></i>&nbsp;教室查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/material/add.jsp');"><i class="ion-ios-book text-danger"></i>&nbsp;新增教材</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/material/list.jsp');"><i class="ion-ios-box-outline text-danger"></i>&nbsp;教材查询</a></li>

				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="per">
				<ul class="rig_nav">
					<li class="rig_seleli"><a href="#"><i class="ion-ios-list text-danger"></i>&nbsp;人事查询</a></li>
					<li><a href="#"><i class="ion-person-stalker text-danger"></i>&nbsp;招聘</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="fin">
				<ul class="rig_nav">
					<li class="rig_seleli"><a href="#"><i class="ion-ios-compose text-danger"></i>&nbsp;财务日报</a></li>
					<li><a href="#"><i class="ion-ios-pulse-strong text-danger"></i>&nbsp;流水账</a></li>
					<li><a href="#"><i class="ion-ios-settings text-danger"></i>&nbsp;分析报表</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="mar">
				<ul class="rig_nav">
					<li class="rig_seleli"><a href="javascript:loadPage('<%=ctx%>/admin/pages/chart/info.jsp');"><i class="ion-ios-pie text-danger"></i>&nbsp;分析首页</a></li>
					<li><a
						href="#"><i class="ion-ios-pulse-strong text-danger"></i>&nbsp;收入分析</a></li>
					<li><a href="#"><i class="ion-ios-pulse-strong text-danger"></i>&nbsp;学员分析</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="set">
				<ul class="rig_nav">
					<li class="rig_seleli">
						<a href="javascript:loadPage('<%=ctx%>/admin/pages/member/register.jsp');"><i class="ion-person-add text-danger"></i>&nbsp;添加用户</a>
					</li>
					<li>
						<a href="javascript:loadPage('<%=ctx%>/admin/pages/member/list.jsp');"><i class="ion-clipboard text-danger"></i>&nbsp;用户列表</a>
					</li>
					<li>
						<a href="javascript:loadPage('<%=ctx%>/admin/pages/education/message/add.jsp');">添加公告</a>
					</li>
					<li>
						<a href="javascript:loadPage('<%=ctx%>/admin/pages/education/message/list.jsp');">公告列表</a>
					</li>
					<li>
						<a href="javascript:$.page.loginout('exit');"><i class="ion-log-out text-danger"></i>&nbsp;注销</a>
					</li>
					
				</ul>
			</div>
			<div class="rig_lm02">
				<div class="title">
					<img src="dist/images/listicon.jpg" class="icon"
						style="padding-top: 13px;">
					<h2 style="padding-top: 11px;"></h2>
				</div>
				<div class="content-wrapper" id="content-wrapper-div"></div>
			</div>

		</div>

	</div>

	<%-- 		<!-- Botton footer -->
		<%@ include file="pages/footer.jsp"%>

		<!-- Right Settings Sidebar -->
		<%@ include file="pages/settings.jsp"%> --%>


	<div class="footer"></div>
	<script type="text/javascript">
		$("li").click(function() {
			$(this).addClass("rig_seleli");
			$(this).siblings().removeClass("rig_seleli");
		});
		$(document).ready(function(e) {	
			var counter = 0;
			if (window.history && window.history.pushState) {
				$(window).on('popstate', function () {
					window.history.pushState('forward', null, '#');
					window.history.forward(1);
					$("#label").html("第" + (++counter) + "次单击后退按钮。");
				});
			}
			window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
			window.history.forward(1);
		});
	</script>
	<%@ include file="pages/base/footer.jsp"%>
</body>
</html>