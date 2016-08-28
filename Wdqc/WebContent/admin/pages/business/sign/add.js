$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/sign/list.jsp",
	// 完成保存页面跳转
	infosave : function(url) {
		if (!url)
			url = $.page.config.Save;
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				$("[id='form.stId']").val(data.datas.stId);
			} else {
				alert('保存失败！' + data.msg);
			}
		});

	},
	fnLoadCampus : function() {
		url = ctx + '/cp_Show.ac';

		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				for ( var i = 0; i < data.datas.length; i++) {
					var html = '<option value="' + data.datas[i].cpId + '">'
							+ data.datas[i].cpName + '</option>';
					$("[id='form.stLocationSchool']").append(html);
				}
				/**/
				// laod form datas
				$.page.formLoad();

			}
		});
	},
	fnPrevent : function() {
		e.preventDefault();
	},
	fnPreventTab : function(b) {
		if (b) {
			// 阻止跳转
			$('a[href="#fileup"]').on('show.bs.tab', function(e) {
				e.preventDefault();
			});
		} else {
			$('a[href="#fileup"]').unbind();
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
				'form.stName' : {
					validators : {
						notEmpty : {
							message : '请输入学员姓名'
						}
					}
				},
				'form.stMobile' : {
					validators : {
						notEmpty : {
							message : '学员电话不能为空'
						}
					}
				},
				'form.stEmail' : {
					validators : {
						notEmpty : {
							message : '邮箱不能为空'
						}
					}
				},

			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			// 解绑事件
			$.page.config.fnPreventTab(false);
			$.page.config.infosave();
			$("#material").hide();
		});
	},
	fnSave : function() {

		$("#info form").submit();
	},
	/*
	 * fnFinish : function(url, rtnUrl) { // 完成保存页面跳转 if (!url) url =
	 * $.page.config.Save; if (!rtnUrl) rtnUrl = $.page.config.Return;
	 * alert("信息保存成功"); $.page.load(rtnUrl); },
	 */

	fnFinish : function(url, rtnUrl) {
		$.page.config.fnUpdateClass();
		$.page.config.saveGradlassInfo();
		var sum = $("#charge").text();
		var a=$("#apply").text();
		var b =$("[id='cltReduce']").val();
		var apply= parseInt(a)-parseInt(b);
		var costsum = parseInt(sum) - parseInt(b);
		$("[id='form.cltApply']").val(apply);
		$("[id='form.cltReduce']").val(b);
		$("[id='form.cltSum']").val(costsum);
		// 完成保存页面跳转
		if (!url)
			url = ctx + "/ct_Save.ac";
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
	fnDel1: function(id,price) {
		var sum=parseInt($("#charge").text())-parseInt(price);
		$("#charge").text(sum);
		$("#showmtl").empty();
		$("[id='cltSaletextbookid']").val("");
		$("[id='cltSaletextbookid']").attr('disabled',false);
		$("[id='form.cltSaleboolname']").val("0");
		$("div").remove("#pan1_" + id);
	},
	fnUpdateClass : function() {

		url = ctx + '/cs_UpdateRemain.ac';
			pk = $("[id='form.csId']").val();;
				alert(pk);
		if (pk) {
			$.post(url, {
				"param._pk" : pk
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {					
					
				}
			});
		}
	},
	getsum: function() {
		var sum = $("#apply").text();
		var b =$("[id='cltReduce']").val();
		var costsum = parseInt(sum) - parseInt(b);
		$("#charge").text(costsum);
	},
});


$(document).ready(function() {
	$.page.config.fnLoadCampus();
	$.page.formLoad();
	// form validator
	$.page.config.fnInitValidator();
	/*
	 * $("#reduse").blur(function(){ var sum=$("#charge").text(); var
	 * b=$("#reduse").val(); alert(b); c=parseInt(sum)-parseInt(b); alert(c);
	 * $("[id='form.cltSum']").val(c); $("#charge").text(c); });
	 */
});