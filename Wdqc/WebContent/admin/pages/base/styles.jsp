<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="n" uri="/wagon-tags"%>
<jsp:directive.page import="com.util.Constants" />
<%
	String ctx = request.getContextPath();
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/bootstrap-select.css">
 
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/font-awesome.min.css">

<link rel="stylesheet" href="<%=ctx%>/admin/plugins/bootstrap/css/font-awesome-animation.min.css">
<!-- Ionicons 2.0.0 -->
<link rel="stylesheet" href="<%=ctx%>//admin/plugins/bootstrap/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/datatables/dataTables.bootstrap.min.css"/>

<link rel="stylesheet" href="<%=ctx%>/admin/plugins/jcrop/Jcrop.min.css">
	
<link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/plugins/uploadify/uploadify.min.css"/>

<!-- iCheck -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/iCheck/square/blue.css">


<link rel="stylesheet" type="text/css"
	href="<%=ctx%>/admin/plugins/jquery-step/css/jquery.step.css">

<link type="text/css" rel="stylesheet" href="<%=ctx%>/admin/dist/css/css.css" />

<link type="text/css" rel="stylesheet" href="<%=ctx%>/admin/dist/css/index.css" />

<link rel="stylesheet" type="text/css" media="all" href="<%=ctx%>/admin/dist/css/daterangepicker-bs3.css"/>

<!-- Pace -->
<link rel="stylesheet" href="<%=ctx%>/admin/plugins/pace/pace-theme-center-simple.css" />

<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- your css links -->
<style type="text/css">
.jcrop-thumb {
	top: 15px;
	right: -20px;
	border: 1px black solid;
}

.uploadify-button {
	background-color: transparent;
	border: none;
	padding: 0;
}

.uploadify:hover .uploadify-button {
	background-color: transparent;
}

.content-wrapper-zero {
	margin-left: 0px;
}
</style>

<!-- your css links end -->
