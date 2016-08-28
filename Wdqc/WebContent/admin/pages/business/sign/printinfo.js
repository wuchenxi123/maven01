$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/sign/list.jsp",
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
	/*fnLoadClass : function(url, pk) {

		url = ctx + '/sc_Show.ac';
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			$.post(url, {
				"param._ne_stId" : pk
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
					$("#showgradss").empty();
					$("#charge").text("0");
					for ( var i = 0; i < data.datas.length; i++) {
						sum=$("#charge").text();
						c=parseInt(sum)+parseInt(data.datas[i].gradlass.csCharge);
						$("#charge").text(c);
						var Delete = ctx + '/sc_Del.ac';	
						var html='<div class="panel panel-warning" id="pan_' +data.datas[i].scId + '"><div class="panel-heading"><a class="panel-title">班级详情</a> <a class="pull-right btn " onclick="$.page.config.fnDel(\'' +Delete+  '?ids=' +data.datas[i].scId+ '\',\''+ data.datas[i].scId + '\',\''+ data.datas[i].gradlass.csCharge + '\');"> ';
						html=html+'<i class="fa fa-times"></i> 退班</a></div><div class="panel-body">';
						html=html+'<label class="col-sm-1 control-label">班名：</label> <div class="col-sm-2"><span>'+data.datas[i].gradlass.csName+'</span></div> <label class="col-sm-1 control-label">费用：</label>';
						html=html+'<div class="col-sm-2 text-danger">￥<span>'+data.datas[i].gradlass.csCharge+'</span></div></div></div>';							
						$("#showgradss").append(html);
					}
					$("[id='form.cltId']").val("");
				}
			});
		}
	},*/
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
			$.page.config.fnFinish();
		});
	},
	fnSave : function() {

		$("#info form").submit();
	},
/*	fnDel: function(url, id , cr) {
		// 删除宣传图路径
		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				$("div").remove("#pan_" + id);
				var sum=$("#charge").text();
				c=parseInt(sum)-parseInt(cr);
				$("#charge").text(c);
			} else {
				alert(data.msg);
			}
		});
	},*/
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
	$.page.config.fnLoadCampus();
	// form validator
	$.page.config.fnInitValidator();
});