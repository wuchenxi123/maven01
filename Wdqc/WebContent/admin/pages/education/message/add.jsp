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
	var ctx = "${pageContext.request.contextPath}"
	window.UEDITOR_HOME_URL = "/Wdqc/admin/plugins/ueditor/";
</script>
<script src="<%=ctx%>/admin/pages/education/message/add.js" type="text/javascript"></script>

<script src="<%=ctx %>/admin/plugins/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>    
<script src="<%=ctx %>/admin/plugins/ueditor/ueditor.all.min.js" type="text/javascript" charset="utf-8"></script> 
<script src="<%=ctx %>/admin/plugins/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>    

<title>添加课程信息</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
		<li><a href="#">公告通知</a></li>
		<li class="active">添加公告</li>
	</ol>
	</section>

	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<div id="myTabContent" class="tab-content ">
				<div id="info" class="tab-pane fade in active">
					<form role="form" class="form-horizontal">
						<input type="hidden" name="form.mgId" id="form.mgId" />
						<input type="hidden" name="form.mgCreator" id="form.mgCreator" />
						<input type="hidden" name="form.mgCreattime" id="form.mgCreattime" />
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">
									<i class='fa fa-github'></i>公告信息
								</h3>
							</div>
							<div class="box-body">
								<div class="col-sm-12">

									<div class="form-group">
										<label class="col-sm-2 control-label">标题：</label>
										<div class="col-sm-10">
											<input name="form.mgTitle" id="form.mgTitle" type="text"
												class="form-control" placeholder="标题">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">公告类型：</label>
										<div class="col-sm-10">
											<select name="form.mgType" id="form.mgType"
													class="form-control" >	
													<option value="0">教务教学</option>
													<option value="1">人事调整</option>
													<option value="2">比赛通知</option>
													<option value="3">荣誉展示</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">公告内容：</label>
										<div class="col-sm-10">
         								<script id="editor" type="text/plain" style="width:800px;height:500px;"></script>
         								<input name="form.mgContent" id="form.mgContent" type="hidden"
												class="form-control" >
										</div>
									</div>
									
								</div>
							</div>
						</div>
					</form>

					<div class="col-xs-12">
						<div class="col-xs-4 col-xs-offset-4" style="height: 155px;">
							<button type="button" onclick="$.page.config.fnSave();"
								class="btn btn-primary  btn-lg btn-block">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</button>
						</div>
					</div>
				</div>

			</div>
		</div>


	</div>
	</section>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    //function getContent() {
    //    var arr = [];
    //    arr.push(UE.getEditor('editor').getContent());
    //    alert(arr.join("\n"));
    //}
</script>
</body>
</html>
