$.page.set({
			Save : ctx + "/te_Save.ac",
			Edit : ctx + "/te_Edit.ac",
			Return : ctx + "/admin/pages/education/teacher/list.jsp",
			
			getTeacherinfo:function(){
						var sex=$("[id='form.teSex']").val();
						$("[id='form.teSex']").get(sex).checked=true; 
			},
});

$finish=function(url, rtnUrl) {
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
$(document).ready(function() {
	$.page.formLoad();
	$.page.config.getTeacherinfo();
});
