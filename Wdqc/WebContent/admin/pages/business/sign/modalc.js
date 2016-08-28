//@ sourceURL=modal.js
var def ='#Gradlass';
var con = '_orderby:csId;_desc:1;queryAll:true;';
var cltId="";
var config = {
	Definition : $.page.config.Definition || def,
	Condition : $.page.config.Condition || con,
	addPickerQueryParam : function(data) {
		$('.Picker_Datatable_Param_Form').html($('#Picker_Datatable_Param_Form').html());
		$('#Picker_Datatable_Param_Form').remove();

		// key down event
		$('.Picker_Datatable_Param_Form input').keydown(function(event) {
			if (event.keyCode == 0xD) {
				$.page.config.reloadPicker();
				return;
			}
		});
	},
	reloadPicker : function() {
		$.page.config.Grid.ajax.reload();
	},
	selectPickerCode4Daliog : function(code, name) {
		var a = new Array(2);
		a[0] = code;
		a[1] = name;
		var win = window;
		win.returnValue = a;
		win.close();
	},
	selectPickerCode4Modal : function(c, n) {
		$.page.config.addInfo(c);
		if (!$.page.config.Control) {
			
			$.page.config.selectPickerCode4Daliog(c, n);
			
			return;
		}
		var t = $.page.config.Control;
		var buttonID = t.name;
		if (buttonID == null || buttonID == "") {
			alert("Must set the name property for this selector control!");
			return false;
		}
		
		var code = buttonID.substring(0, buttonID.indexOf("_button"));
		var name = code + "_text";
		var nn = $(t).parent().prev("[name='" + name + "']");
		nn.val(n);
		var cn = $(nn).prev("[name='" + code + "']");
		cn.val(c);	
		//$("[name='" + code + "']").val(c);
		//$("[name='" + name + "']").val(n);
		$('#Data_Picker_Modal').modal('hide');
		
	},
	init : function() {
		$.page.config.Grid = $('#Picker_Datatable').DataTable({
			processing : false,
			searching : false,
			serverSide : true,
			autoWidth : true,
			pagingType : "full_numbers",// full_numbers
			aLengthMenu : [ 10, 5, 20, 50, 100, 500 ],
			ajax : {
				url : ctx + "/cs_List.ac?param._ne_csStatus=0",
				type : "POST",
				data : function(d) {
					// add query param to data
					var params = $('.Picker_Datatable_Param_Form form').serializeArray();
					var p = $.serializeJson(params);
					$.apply(d, p);
					$.apply(d, {
						definition : $.page.config.Definition,
						condition : $.page.config.Condition,
						dt : 'DataTable'
					});
				}
			},
			order : [ [ 2, 'asc' ] ],
			columns : [  { orderable : false ,searchable : false ,defaultContent : ''},			  
				          { data : "csName" },
				          { data : "csPeoplecount" },
				          { data : "teacher" },
				          { data : "coName" },
				          { data : "csOpendatestart" },
				          { data : "timeFrame" },
				          { data : ".cpName" },
				          { data : "crName" } ,
				          { data : "csCharge" } ,
				          { data : "csPeopleremain" } ,
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}],
			fnRowCallback : function(nRow, aData, iDataIndex) {
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:$.page.config.selectPickerCode4Modal(\'' + aData.csId + '\',\'' + aData.csName + '\');"> <i class="fa fa-thumb-tack" ></i> 选择</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				var teacher = "";
				var names="";
				teacher=aData.teaList;
				if(teacher!=null){
					for ( var i = 0; i < teacher.length; i++) {
						names=teacher[i].teName;
						$('td:eq(3)', nRow).append(names+ " | ");
					
					}
				}
				return nRow;
			},
			oLanguage : $.dt.oLanguage,
			dom : "<'row'<'col-sm-2'l><'col-sm-10 Picker_Datatable_Param_Form'><'col-sm-3'f>><'row'<'col-sm-12't>><'row'<'col-sm-5'i><'col-sm-7'p>>",
			initComplete : $.page.config.addPickerQueryParam
		});
	},
	addInfo : function(c) {
			var url =ctx + "/cs_Edit.ac";
			var	pk =c;
			if (pk) {
				$.post(url, {
					"param._pk" : pk
				}, function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {		
						$("[id='form.cltId']").val("");
						$("[id='form.csId']").val(data.csId);
						$("#showgradss").empty();
						$.page.config.fnLoadmaterial(data.coId);
						var html='<div class="panel panel-warning" id="pan_' +data.csId + '"><div class="panel-heading"><a class="panel-title">班级详情</a> <a class="pull-right btn " onclick="$.page.config.fnDel(' +data.csId + ')"> ';
						html=html+'<i class="fa fa-times"></i> 删除</a></div><div class="panel-body">';
						html=html+'<label class="col-sm-1 control-label">班名：</label> <div class="col-sm-2"><span>'+data.csName+'</span></div>  <label class="col-sm-1 control-label">费用：</label>';
						html=html+'<div class="col-sm-2 text-danger">￥<span id="apply">'+data.csCharge+'</span></div><label class="col-sm-1 control-label">班级容量：</label><div class="col-sm-2"><span>'+data.csPeoplecount+'</span></div>';	
						html=html+'<label class="col-sm-1 control-label">优惠：</label><div class="col-sm-2"><input id="cltReduce" type="text" class="form-control" value="0"></div></div><a class="btn" style="margin-left:920px;" onclick="$.page.config.getsum()">确定</a></div>';
						$("#charge").text(data.csCharge);
						$("#showgradss").append(html);
						$("#material").show();
						
					}
					
				});
			} else {
				$.page.setFormOthers();
			}	
		
	},
	fnLoadmaterial : function(pk) {
		url = ctx + '/mtl_Show.ac?param._ne_coId='+pk;

		$.post(url, {

		},
				function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {
						$("[id='cltSaletextbookid']").empty();
						var html = '<option value="">无</option>';
						$("[id='cltSaletextbookid']").append(html);
						for ( var i = 0; i < data.datas.length; i++) {
							html = '<option value="'
									+ data.datas[i].mtlId + '">'
									+ data.datas[i].mtlName
									+ '</option>';
							$("[id='cltSaletextbookid']").append(html);
						}											
					}
				});
	},
	saveGradlassInfo : function(url) {
		if (!url)
			url =ctx + "/sc_Save.ac";
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {	
				/*$.page.config.changeGradlassInfo();*/
			} else {
				alert('保存失败！' + data.msg);
			}
		});
		
	},
	saveChargeInfo : function(url) {
		if (!url)
			url =ctx + "/ct_Save.ac";
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				alert("费用信息保存完成");
				
			} else {
				alert('保存失败！' + data.msg);
			}
		});
		
	},
	/*changeGradlassInfo : function(url) {
		if (!url)
			url =ctx + "/gs_Update.ac";
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				alert("费用信息保存完成");
				
			} else {
				alert('保存失败！' + data.msg);
			}
		});
		
	},*/
	fnDel: function( id) {
				$("#showmtl").empty();
				$("#material").hide();
				$("div").remove("#pan1_" + id);
				$("#showgradss").empty();
				$("div").remove("#pan_" + id);
				$("#charge").text("0");
	},
	

};
function getHtml(data,id) {
	$("#showgradss").empty();
	var Delete = ctx + '/sc_Del.ac';	
	var html='<div class="panel panel-warning" id="pan_' +id + '"><div class="panel-heading"><a class="panel-title">班级详情</a> <a class="pull-right btn " onclick="$.page.config.fnDel(\'' +Delete+  '?ids=' +id + '\',\''+ id + '\',\''+ data.csCharge + '\');"> ';
	html=html+'<i class="fa fa-times"></i> 删除</a></div><div class="panel-body">';
	html=html+'<label class="col-sm-1 control-label">班名：</label> <div class="col-sm-2"><span>'+data.csName+'</span></div>  <label class="col-sm-1 control-label">费用：</label>';
	html=html+'<div class="col-sm-2 text-danger">￥<span>'+data.csCharge+'</span></div><label class="col-sm-1 control-label">班级容量：</label><div class="col-sm-2"><span>'+data.csPeoplecount+'</span></div></div></div>';		
	var sum=$("#charge").text();
	c=parseInt(sum)+parseInt(data.csCharge);
	$("#charge").text(c);
	$("#showgradss").append(html);
}

function cltSaleid(pk) {	
	url =ctx + "/mtl_Edit.ac";
	if (!pk) {
		
	}
	if (pk) {
		$.post(url, {
			"param._pk" : pk
		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {		
				$("[id='form.cltSaleboolname']").val(data.mtlPrice);
				$("[id='form.cltSaletextbookid']").val(data.mtlId);
				$("[id='cltSaletextbookid']").attr('disabled',"true");
				$("[id='form.cltId']").val("");
				$("#charge").text($("#apply").text());
				$("#showmtl").empty();
				var html='<div class="panel panel-warning" id="pan1_' +data.mtlId + '"><div class="panel-heading"><a class="panel-title">班级详情</a> <a class="pull-right btn " onclick="$.page.config.fnDel1(' +data.mtlId + ',\'' + data.mtlPrice + '\')"> ';
				html=html+'<i class="fa fa-times"></i> 删除</a></div><div class="panel-body">';
				html=html+'<label class="col-sm-1 control-label">教材名：</label> <div class="col-sm-2"><span>'+data.mtlName+'</span></div>  <label class="col-sm-1 control-label">价格：</label>';
				html=html+'<div class="col-sm-2 text-danger">￥<span>'+data.mtlPrice+'</span></div><label class="col-sm-1 control-label">库存量：</label><div class="col-sm-2"><span>'+data.mtlRemain+'</span></div>';	
				html=html+'</div></div>';
				var sum=parseInt($("#charge").text())+parseInt(data.mtlPrice);
				$("#charge").text(sum);
				$("#chargeadd").text(sum);
				$("#showmtl").append(html);				
			}
			
		});
	}
}

$(document).ready(function() {
	$.page.set(config);
	$.page.config.init();
	$.page.config.Grid.on('order.dt search.dt page.dt length.dt draw.dt', function() {
		$.page.config.Grid.column(0, {
			search : 'applied',
			order : 'applied'
		}).nodes().each(function(cell, i) {
			cell.innerHTML = i + 1;
		});
	});
	
});
