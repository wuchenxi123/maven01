<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	var config = {
		init : function() {

		},
		/* init2 : function() {
			var url = $.page.ctx + '/mb_List.ac';
			$("#dict_demo2_datatable").load(url, {
				dt : 'Page',
				'param._pagesize' : 5,
				'param._orderby' : 'mbId'
			}, function() {
				addPager($(this).attr('id'));
			});
		},
		init3 : function() {
			var url = $.page.ctx + '/mb_List.ac';
			$("#dict_demo3_datatable").load(url, {
				dt : 'Page',
				'param._pagesize' : 5
			}, function() {
				addPager($(this).attr('id'));
			});
		},
		init4 : function() {
			$("#dict_demo4_datatable").PageTable({
				url : $.page.ctx + '/mb_List.ac',
				data : {
					dt : 'Page',
					'param._pagesize' : 5,
					'param._orderby' : 'mbId',
					'param._desc' : '1'
				}
			});
		} */
	};

	$(document).ready(function() {
		$.page.set(config);
		$.page.config.init();
/* 		$.page.config.init2();
		$.page.config.init3();
		$.page.config.init4(); */
	});
</script>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header" style="display: none;">
		<h1>
			系统设置 <small>数据字典开发样例</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
			<li><a href="#">系统设置</a></li>
			<li class="active">数据字典开发样例</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content" style="display: none;">
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class='fa fa-github-alt'></i> 在表单中使用数据字典
						</h3>
					</div>
					<div class="box-body">
						<form role="form" class="form-horizontal" id="test_form">
						<%-- 	<div class="form-group">
								<label class="col-sm-3 control-label">通过配置字典表的方式：</label>
								<div class="col-sm-2">
									<j:selector name="param._se_mbSex" definition="$SEX" cssClass="form-control" />
								</div>
								<div class="col-sm-2">
									<j:selector name="param._se_mbType1" definition="$USER_TYPE" cssClass="form-control" condition="_se_dictCode:0;_orderby:sortOrder;queryAll:true;" />
								</div>
								<div class="col-sm-2">
									<j:selector name="param._se_mbType2" definition="$USER_TYPE" cssClass="form-control" condition="_orderby:sortOrder;queryAll:true;" />
								</div>
							</div> --%>
							<div class="form-group">
								<label class="col-sm-3 control-label">通过动态数据方式的方式：</label>
								<div class="col-sm-2">
									<j:selector name="param._ne_csId" definition="#Gradlass" cssClass="form-control" condition="_orderby:csId;_desc:1;queryAll:true;" />
								</div>
<%-- 								<div class="col-sm-2">
									<j:selector name="param._ne_csId1" definition="#Gradlass" cssClass="form-control" condition="_sk_csName:超级管理员;_orderby:csId;_desc:1;queryAll:true;" />
								</div> --%>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">静态常量的方式：</label>
								<div class="col-sm-2">
									<j:selector name="param._se_mbState" definition="State" cssClass="form-control" />
									<a class="btn btn-default reload" onclick="$.page.getFormData('#test_form');"> <i class="fa fa-search"></i> 查看内容
									</a> <a class="btn btn-default reset" onclick="$.page.resetForm('#test_form');"> <i class="fa fa-reply-all"></i> 复位
									</a>
								</div>
							</div>
						</form>
					</div>
				</div>
<!-- 
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class='fa fa-github-alt'></i> 在表格中使用数据字典：直接html方式 (标签需要在服务端解释，代码必须写在jsp中，可以使用common-support.xml中配置result页面的方式)
						</h3>
					</div>
					<div class="box-body" id="dict_demo2_datatable"></div>
					<div class="box-body" id="dict_demo3_datatable"></div>
				</div>
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class='fa fa-github-alt'></i> 在表格中使用数据字典：包装成PageTable JQUERY插件(推荐)
						</h3>
					</div>
					<div class="box-body" id="dict_demo4_datatable"></div>
				</div> -->

			</div>
		</div>
	</section>
</body>
</html>