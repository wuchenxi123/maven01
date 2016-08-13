<%@page contentType="text/html; charset=utf-8"%>
<jsp:directive.page import="com.util.Constants" />
<jsp:directive.page import="com.manage.member.persistent.MemberVO ;" />
<%
	String ctx = request.getContextPath();
	MemberVO user = (MemberVO) request.getSession().getAttribute(Constants.SESSION_TIOSUSER);
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<!-- 页面通用CSS -->
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/bootstrap.min.css">
 
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/font-awesome.min.css">

<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/font-awesome-animation.min.css">
<!-- Ionicons 2.0.0 -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/ionicons.min.css">
<!-- Pace -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/pace/pace-theme-center-simple.css" />
<!-- 页面通用CSS End -->

<!-- 页面通用JS -->
<!-- jQuery 2.1.4 -->
<script src="<%=ctx%>/admin/jquery/jQuery-2.1.4.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<%=ctx%>/admin/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Pace v1.0.2 -->
<%-- <script src="<%=ctx%>/admin/plugins/pace/pace.min.js"></script> --%>
<!-- 页面通用JS End -->

<!-- Common -->
<script src="<%=ctx%>/admin/pages/base/pages.js"></script>
<!-- Common End -->

<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
	$.page.ctx = ctx;
	$.apply($.page.user, {
		mbId : '${TiosUser.mbId }',
		mbPassword : '${TiosUser.mbPassword }'
	});
</script>	