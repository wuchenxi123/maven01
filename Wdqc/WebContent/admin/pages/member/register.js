var k=1;
var htmltea="";
$.page.set({
			Save : ctx + "/mb_Save.ac",
			Edit : ctx + "/mb_Edit.ac",
			Return : ctx + "/admin/pages/member/list.jsp",
			// 完成保存页面跳转
			
			fnLoadRole : function() {
				url = ctx + '/role_Show.ac';

				$.post(url, {

				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								for ( var i = 0; i < data.datas.length; i++) {
									var html = '<option value="'
											+ data.datas[i].roleId + '">'
											+ data.datas[i].roleName
											+ '</option>';
									$("[id='form.roleId']").append(html);
								}
								
							}
						});
			},
//			fnLogin : function() {
//				var pwd = $("[id='form.mbPassword']").val();
//				pwd = hex_md5(pwd);
//				alert
//			},
			
});


$finish=function(url, rtnUrl) {
	var pwd = $("[id='form.mbPassword']").val();
	pwd = hex_md5(pwd);
	alert(pwd);
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
//	alert($.md5("Hello,Liehuo.Net"));
	$.page.config.fnLoadRole();
	$.page.formLoad();
});
