var k=1;
var htmlcou="";
$.page.set({
			Save : ctx + "/te_Save.ac",
			Edit : ctx + "/te_Edit.ac",
			Return : ctx + "/admin/pages/education/teacher/list.jsp",
			
			
			fnLoadCourse : function() {
				url = ctx + '/cou_Show.ac';

				$.post(url, {

				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								$("[id='form.course.coId']").append('<option value=""></option>');
								for ( var i = 0; i < data.datas.length; i++) {
									html = '<option value="'
											+ data.datas[i].coId + '">'
											+ data.datas[i].coName
											+ '</option>';
									htmlcou+=html;
									$("[id='form.course.coId']").append(html);
								}
								/*$.page.formLoad();*/
							}
						});
			},
			addCourse :function() {
				var html1 = '<select name="form.courseList['+k+'].coId "'
					+ 'id="form.course.coId'+k+' "'+'class="form-control" style="margin-top: 16px"><option value=""></option>'
					+htmlcou+ '</select>';
				$("[id='form.courseSelect']").append(html1);
				k++;
			},
			
			fnLoadTeacherCourse : function(pk) {				
				var Delete=ctx+'/tc_Del.ac';
				if (!pk)
					pk = $.page.config.Pk;
				if (!pk)
					pk = $.page.config.Data.Pk;
				if(pk){
					url = ctx + '/tc_Show.ac?param._ne_teid='+pk;
				}
				
				$.post(url, {

				},
					function(data, textStatus, jqXHR) {
						if ("success" == textStatus) {
							for ( var i = 0; i < data.datas.length; i++) {
								var html='<div id="pan_'+data.datas[i].tcId+'"  style="float:left">'+data.datas[i].coursename+'<a class="btn btn-default btn-sm" onclick="$.page.config.del(\'' +Delete+ '?ids=' + data.datas[i].tcId + '\',\''+ data.datas[i].tcId+'\');"> <i class="fa fa-times"></i> 删除</a></div>';
								$("#coursearea").append(html);
							};
						};
					});
			},
			
			del : function(url,id) {
					$.post(url, {

					}, function(data, textStatus, jqXHR) {
						if ("success" == textStatus) {						
							$("div").remove("#pan_" + id);
						} else {
							alert(data.msg);
						}
					});
			},
			fnPrevent : function() {
				e.preventDefault();
			},
			fnPreventTab : function(b) {
				if (b) {
					// 阻止跳转
					$("[id='form.teacherSave']").on('show.bs.tab', function(e) {
						e.preventDefault();
					});
				} else {
					$("[id='form.teacherSave']").unbind();
				}
			},
			fnInitValidator : function() {
				$.page.config.fnPreventTab(true);
				$('#info form').bootstrapValidator({
					trigger : 'blur',
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						'form.teName' : {
							validators : {
								notEmpty : {
									message : '请输入教师名称'
								}
							}
						},
						'form.teAge' : {
							validators : {
								notEmpty : {
									message : '年龄不能为空'
								}
							}
						},
						'form.teMobile' : {
							validators : {
								notEmpty : {
									message : '手机号不能为空'
								}
							}
						},
						
					}
				}).on('success.form.bv', function(e) {
					e.preventDefault();
					// 解绑事件
					$.page.config.fnPreventTab(false);
					$.page.config.fnFinish();
				});
			},
			fnSave : function() {

				$("#info form").submit();
			},
			fnFinish : function(url, rtnUrl) {
				if (!url)
					url = $.page.config.Save;
				if (!rtnUrl)
					rtnUrl = $.page.config.Return;
				var formData = $("form").serializeArray();
				$.post(url, formData, function(data, textStatus, jqXHR) {
					if (data.success) {
						alert('保存成功!');
						$.page.load(rtnUrl);
					} else {
						alert('保存失败！' + data.msg);
					}
				});

			},
			
});


$(document).ready(function() {
	$.page.config.fnLoadCourse();
	$.page.config.fnInitValidator();
	$.page.config.fnLoadTeacherCourse();
	$.page.formLoad();
});
