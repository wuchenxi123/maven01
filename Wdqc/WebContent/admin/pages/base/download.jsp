<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>文件下载</title>
<script type="text/javascript">
function fileDownLoad(path){
	var url = ctx + '/file_DownLoad.ac?fileName=' + escape(encodeURIComponent(path));
	window.open(url);
}
</script>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header" style="display: none;">
		<h1>
			系统设置 <small>文件下载样例</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
			<li><a href="#">系统设置</a></li>
			<li class="active">文件下载样例</li>
		</ol>
	</section>


	<!-- Main content -->
	<section class="content" style="display: none;">
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class='fa fa-github-alt'></i> 文件下载样例
						</h3>
					</div>
					<div class="box-body">
						<button class="btn btn-primary fa fa-download" onclick="fileDownLoad('upload/ADT-20.0.0中文.zip');"> 下载</button>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>