$.page.set({
	Save : ctx + "/mtl_Save.ac",
	Edit : ctx + "/mtl_Edit.ac",
	Return : ctx + "/admin/pages/education/material/list.jsp",
	// 完成保存页面跳转

	fnLoadCourse : function() {
		url = ctx + '/cou_Show.ac';

		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				for ( var i = 0; i < data.datas.length; i++) {
					var html = '<option value="' + data.datas[i].coId + '">'
							+ data.datas[i].coName + '</option>';
					$("[id='form.coId']").append(html);
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
				'form.mtlName' : {
					validators : {
						notEmpty : {
							message : '教材名不能为空'
						}
					}
				},
				'form.mtlPrice' : {
					validators : {
						notEmpty : {
							message : '价格不能为空'
						}
					}
				},
				'form.mtlVolume' : {
					validators : {
						notEmpty : {
							message : '数量不能为空'
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
	$.page.config.fnLoadCourse();	
	// form validator
	$.page.config.fnInitValidator();

	
});
