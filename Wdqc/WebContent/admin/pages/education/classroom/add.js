$.page.set({
	Save : ctx + "/cr_Save.ac",
	Edit : ctx + "/cr_Edit.ac",
	Return : ctx + "/admin/pages/education/classroom/list.jsp",
	// 完成保存页面跳转

	fnLoadCampus : function() {
		url = ctx + '/cp_Show.ac';

		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				for ( var i = 0; i < data.datas.length; i++) {
					var html = '<option value="' + data.datas[i].cpId + '">'
							+ data.datas[i].cpName + '</option>';
					$("[id='form.crCampus']").append(html);
				}
				$.page.formLoad();
			}
		});
	},
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
				'form.crName' : {
					validators : {
						notEmpty : {
							message : '教室名不能为空'
						}
					}
				},
				'form.crCapacity' : {
					validators : {
						notEmpty : {
							message : '教室容量不能为空'
						}
					}
				},
				'form.crCampus' : {
					validators : {
						notEmpty : {
							message : '所属校区不能为空'
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
	$.page.config.fnLoadCampus();	
	$.page.config.fnInitValidator();
});
