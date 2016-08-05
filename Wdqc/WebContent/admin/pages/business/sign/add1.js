$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/sign/list.jsp",
	//完成保存页面跳转
	infosave :function(url) {
		if (!url)
			url = $.page.config.Save;
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				alert('保存成功!' );
			} else {
				alert('保存失败！' + data.msg);
			}
		});
			

	},
});
$(document).ready(function() {
	$.page.formLoad();
	});	