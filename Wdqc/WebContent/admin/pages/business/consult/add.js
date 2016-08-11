
$.page.set({
	Save : ctx + "/ay_Save.ac",
	Edit : ctx + "/ay_Edit.ac",
	Return : ctx + "/admin/pages/business/consult/list.jsp",
	//完成保存页面跳转
	fnInitValidator : function() {
		$('.content form').bootstrapValidator({
			trigger : 'blur',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				'form.adName' : {
					validators : {
						notEmpty : {
							message : '请输入学员姓名'
						}
					}
				},
				'form.adPhone' : {
					validators : {
						notEmpty : {
							message : '学员电话不能为空'
						}
					}
				},
				'form.adEmial' : {
					validators : {
						notEmpty : {
							message : '邮箱不能为空'
						}
					}
				},
				
				
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			$.page.config.fnFinish();
		});
	},
	fnSave : function() {
		
		$(".content form").submit();
	},
	fnFinish : function(url, rtnUrl) {
		// 完成保存页面跳转
		if (!url)
			url = $.page.config.Save;
		if (!rtnUrl)
			rtnUrl = $.page.config.Return;
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				alert("信息保存成功");
				$.page.load(rtnUrl);
			} else {
				alert('保存失败！' + data.msg);
			}
		});
	},
	fnLoadCourse : function() {
		url = ctx + '/cou_Show.ac';

		$.post(url, {

		},
				function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {
						var htmlInit = '<option value=""></option>';
						$("[id='form.adCourse']").append(htmlInit);
						for ( var i = 0; i < data.datas.length; i++) {
							var html = '<option value="'
									+ data.datas[i].coId + '">'
									+ data.datas[i].coName
									+ '</option>';
							$("[id='form.adCourse']").append(html);
						}
						/**/
						// laod form datas
						$.page.formLoad();
					}
				});
	},
	
	
	
});


$(document).ready(function() {
	$.page.config.fnLoadCourse();
	$.page.formLoad();
	// form validator
	$.page.config.fnInitValidator();

	});	
