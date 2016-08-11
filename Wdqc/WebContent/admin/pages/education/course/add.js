
$.page.set({
	Save : ctx + "/cou_Save.ac",
	Edit : ctx + "/cou_Edit.ac",
	Return : ctx + "/admin/pages/education/course/list.jsp",
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
				'form.coName' : {
					validators : {
						notEmpty : {
							message : '请输入课程名称'
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
	
});


$(document).ready(function() {
	$.page.formLoad();
	$.page.config.fnInitValidator();
	});	
