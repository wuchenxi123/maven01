$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/renewal/list.jsp",
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
	fnLoadClass : function(url, pk) {

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
					$("#showgrad").empty();
					$("#charge1").text("0");
					for ( var i = 0; i < data.datas.length; i++) {
						sum=$("#charge1").text();
						c=parseInt(sum)+parseInt(data.datas[i].gradlass.csCharge);
						$("#charge1").text(c);
						var Delete = ctx + '/sc_Del.ac';	
						var html='<div class="panel panel-warning" id="pan_' +data.datas[i].scId + '"><div class="panel-heading"><a class="panel-title">班级详情</a> <a class="pull-right btn " onclick="$.page.config.fnDel(\'' +Delete+  '?ids=' +data.datas[i].scId+ '\',\''+ data.datas[i].scId + '\',\''+ data.datas[i].gradlass.csCharge + '\');"> ';
						html=html+'<i class="fa fa-times"></i>退班</a></div><div class="panel-body"><label class="col-sm-1 control-label">班名：</label>';
						html=html+' <div class="col-sm-2"><span>'+data.datas[i].gradlass.csName+'</span></div> <label class="col-sm-1 control-label">班级容量：</label>';
						html=html+'<div class="col-sm-2 text-danger"><span>'+data.datas[i].gradlass.csPeoplecount+'</span></div><label class="col-sm-1 control-label">报名日期：</label><div class="col-sm-2"><span>'+data.datas[i].createTime+'</span></div></div></div> ';							
						$("#showgrad").append(html);
					}
					$("[id='form.cltId']").val("");
				}
			});
		}
	},


	fnDel: function(url, id , cr) {
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
	},
	fnFinish : function(url, rtnUrl) {
		$.page.config.saveGradlassInfo();
		var sum=$("#charge").text();
		var b=$("[id='form.cltReduce']").val();
		alert(b);
		c=parseInt(sum)-parseInt(b);
		alert(c);
		$("[id='form.cltSum']").val(c);
		// 完成保存页面跳转
		if (!url)
			url =ctx + "/ct_Save.ac";
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
	$.page.config.fnLoadClass();
});