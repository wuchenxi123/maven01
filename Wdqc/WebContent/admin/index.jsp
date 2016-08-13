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
<body>
	<div class="header">

		<div class="top">
			<img class="logo" src="dist/images/logo1.png"
				style="margin-left: 25px;" />
			<ul class="nav">
				<li><a href="#stu" data-toggle="tab">前台业务</a></li>
				<li><a href="#cou" data-toggle="tab">教务教学</a></li>
				<li><a href="#per" data-toggle="tab">人事管理</a></li>
				<li><a href="#fin" data-toggle="tab">财务管理</a></li>
				<li><a href="#mar" data-toggle="tab">市场分析</a></li>
				<li><a href="#che" data-toggle="tab">磁卡考勤</a></li>
				<li><a href="#set" data-toggle="tab">系统设置</a></li>
			</ul>
		</div>
	</div>
	<div class="mycontainer">
		<div class="leftbar">
			<div class="lm01">
				<img class="peptx" src="dist/images/tximg.jpg" />
				<div class="pepdet">
					<p class="pepname"><%=user.getMbPetName()%></p>
					<p>李小雅</p>
					<p>超级管理员</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="lm01">
				<div class="form-group">
					<label class="col-sm-7 control-label">季度報名人數：</label>
					<div class="col-sm-5">
						<span>1277</span>
					</div>
				</div>
			</div>
			<div class="lm01">
				<div class="form-group">
					<label class="col-sm-7 control-label">季度学费收入：</label>
					<div class="col-sm-5">
						<span style="width: 145px;">￥12万</span>
					</div>
				</div>
			</div>
			<!-- <div class="lm02">
				<div class="title">
					<h2>月收入:</h2>
					<br> <span>120000￥</span>
				</div>
				<div class="detail"></div>
			</div>
			<br>
			<br>
			<div class="lm03">
				<div class="title">
					<h2>年收入:</h2>
				</div>
				<div class="detail">120万￥</div>
			</div> -->
		</div>

		<div class="mainbody tab-content" id="myTabContent">
			<div class="currmenu tab-pane fade in active" id="stu">
				<ul class="rig_nav">
					<li class="rig_seleli"><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/consult/add.jsp');">新咨询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/consult/list.jsp');">资询记录</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/sign/add.jsp');">新生报名</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/sign/list.jsp');">报名查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/renewal/list.jsp');">转班续报</a></li>

					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/suspendclasses/list.jsp');">办理停课</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/business/regain/list.jsp');">停课恢复</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="cou">
				<ul class="rig_nav">
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/gradlass/add.jsp');">新增班级</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/gradlass/list.jsp');">班级查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/teacher/add.jsp');">新建教师</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/teacher/list.jsp');">教师查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/course/add.jsp');">新建课程</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/course/list.jsp');">课程查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/classroom/add.jsp');">添加教室</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/classroom/list.jsp');">教室查询</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/material/add.jsp');">新增教材</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/education/material/list.jsp');">教材查询</a></li>

				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="per">
				<ul class="rig_nav">
					<li class="rig_seleli"><a href="#">人事查询</a></li>
					<li><a href="#">招聘</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="fin">
				<ul class="rig_nav">
					<li class="rig_seleli"><a href="#">财务日报</a></li>
					<li><a href="#">流水账</a></li>
					<li><a href="#">分析报表</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="mar">
				<ul class="rig_nav">
					<li class="rig_seleli"><a href="#">饼图</a></li>
					<li><a
						href="javascript:loadPage('<%=ctx%>/admin/pages/chart/info.jsp');">柱状图</a></li>
					<li><a href="#">线形图</a></li>
				</ul>
			</div>
			<div class="currmenu tab-pane fade" id="set">
				<ul class="rig_nav">
					<li class="rig_seleli">
						<a href="javascript:loadPage('<%=ctx%>/admin/pages/member/register.jsp');">添加用户</a>
					</li>
					<li>
						<a href="javascript:loadPage('<%=ctx%>/admin/pages/member/list.jsp');">用户列表</a>
					</li>
					<li><a href="javascript:$.page.loginout('exit');">注销</a></li>
					<li><a href="#">修改密码</a></li>
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