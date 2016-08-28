$.page.set({
	Save : ctx + "/mg_Save.ac",
	Edit : ctx + "/mg_Edit.ac",
	Return : ctx + "/admin/pages/education/message/list.jsp",

	
	// 完成保存页面跳转
	fnInitValidator : function() {
		$('.content form').bootstrapValidator({
			trigger : 'blur',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				'form.mgTitle' : {
					validators : {
						notEmpty : {
							message : '标题不能为空'
						}
					}
				},
				'form.mgType' : {
					validators : {
						notEmpty : {
							message : '公告类型不能为空'
						}
					}
				},
//				'form.mgContent' : {
//					validators : {
//						notEmpty : {
//							message : '公告内容不能为空'
//						}
//					}
//				},

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
		var arr = [];
		arr.push(UE.getEditor('editor').getContent());
		
        $("[id='form.mgContent']").val(arr);
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
	fnLoadContent:function(){
		alert("请编辑信息");
		var arr = [];
		arr.push($("[id='form.mgContent']").val());
//		UE.getEditor('editor').setContent(' '+arr.join()+' ',true);
		UE.getEditor('editor').addListener("ready", function () {
		       UE.getEditor('editor').setContent(arr.join());
		});
		$("[id='form.mgContent']").val(arr);
	},
});

$(document).ready(function() {
	$.page.formLoad();
	$.page.config.fnInitValidator();
	$.page.config.fnLoadContent();
});
