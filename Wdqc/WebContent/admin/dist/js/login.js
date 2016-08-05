var cfg = {
	fnInit : function() {
		$.page.config.fnInitSubmit();
		$.page.config.fnInitValidator();
	},
	fnInitSubmit : function() {
		// submit;
		$('.login').click(function() {
			$("#loginform").submit();
		});
	},
	fnOnForgotPwd : function() {
		$('#login-iframe', window.parent.document).attr('src',$.page.ctx + '/assets/html5/user/retrieve-mobile.html');
	},
	fnRegister : function() {
		$('#login-iframe', window.parent.document).attr('src',$.page.ctx + '/assets/html5/user/register-mobile.html');
	},
	fniFrameHeight : function() {
		var ifm = document.getElementById("login-iframe");
		var subWeb = document.frames ? document.frames["login-iframe"].document : ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
			ifm.width = subWeb.body.scrollWidth;
		}
	},
	fnLogin : function() {
		var formData = $('.login-box-body form').serializeArray();
		formData = $.serializeJson(formData);
		var pwd = formData['param._se_mbPassword'];
		pwd = hex_md5(pwd);
		$.apply(formData, {
			'param._se_mbPassword' : pwd,
			'mobile' : formData['param._se_mbName'],
			'password' : pwd
		});
		$.post(ctx + "/mb_Login.ac", formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				var w = window.parent;
				w.location.href = ctx + "/admin/index.jsp";
			} else {
				alert(data.msg);
			}
		});
	},
	fnInitValidator : function() {
		$('#loginform').bootstrapValidator({
			fields : {
				'param._se_mbName' : {
					message : 'The username is not valid',
					validators : {
						notEmpty : {
							message : '请输入账号/手机/邮箱'
						}
					}
				},
				'param._se_mbPassword' : {
					validators : {
						notEmpty : {
							message : '请输入密码'
						}
					}
				},
			}
		}).on('error.form.bv', function(e) {
			$('.login').attr('disabled', 'disabled');
		}).on('success.field.bv', function(e) {
			var v = $('#loginform').data('bootstrapValidator').isValid();
			if (v) {
				$('.login').removeAttr('disabled');
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			$.page.config.fnLogin();
		});
	}
};
$.page.set(cfg);
$(document).ready(function() {
	$.page.config.fnInit();
});