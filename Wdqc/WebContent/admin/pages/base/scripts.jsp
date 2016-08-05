<%@page contentType="text/html; charset=utf-8"%>
<!-- 页面通用JS -->
<!-- jQuery 2.1.4 -->
<script src="<%=ctx%>/admin/jquery/jQuery-2.1.4.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<%=ctx%>/admin/plugins/bootstrap/js/bootstrap.min.js"></script>

<script src="<%=ctx%>/admin/plugins/bootstrap/js/bootstrap-select.js"></script>
<!-- 页面通用JS End -->

<!-- 时间控件 -->
<script src="<%=ctx%>/admin/plugins/timepicker/bootstrap-timepicker.js"></script>
<script src="<%=ctx%>/admin/plugins/timepicker/moment.js"></script>
<script src="<%=ctx%>/admin/plugins/timepicker/moment.min.js"></script>
<script src="<%=ctx%>/admin/plugins/timepicker/daterangepicker.js"></script>

<!-- Plugins -->
<!-- DataTables 1.10.7 -->
<script src="<%=ctx%>/admin/plugins/datatables/jquery.dataTables.js"></script>
<script src="<%=ctx%>/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- Pace v1.0.2 -->
<script src="<%=ctx%>/admin/plugins/pace/pace.min.js"></script>
<!-- SlimScroll 1.3.3 -->
<script src="<%=ctx%>/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=ctx%>/admin/plugins/fastclick/fastclick.min.js"></script>

<script src="<%=ctx%>/admin/plugins/jquery-step/js/jquery.step.js" type="text/javascript"></script>

<!-- Jcrop v2.0.4 头像截图剪裁处理 -->
<script src="<%=ctx%>/admin/plugins/jcrop/Jcrop.min.js"></script>
<!-- Uploadify v3.1.1 文件上传 -->
<script src="<%=ctx%>/admin/plugins/uploadify/jquery.uploadify-3.1.min.js"></script>

<!-- bootstrap-Validator -->
<script src="<%=ctx%>/admin/plugins/bootstrap-validator/bootstrapValidator.min.js"></script>



<!-- jQuery Form v3.51 -->
<script src="<%=ctx%>/admin/plugins/jQuery/jquery.form.min.js"></script>
<!-- jQuery Cookie Plugin v1.4.1 -->
<script src="<%=ctx%>/admin/plugins/jQuery/jquery.cookie.js"></script>

<!-- iCheck v1.0.1表单美化 -->
<script src="<%=ctx%>/admin/plugins/iCheck/icheck.min.js"></script>

<script src="<%=ctx%>/admin/plugins/echart/echarts.js"></script>

<!-- Plugins End-->

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
	paceOptions = {
		ajax : false, // disabled
		document : false, // disabled
		eventLag : false, // disabled
		elements : false
	};
	$(document).ajaxStart(function() {
		Pace.restart();
	});
</script>