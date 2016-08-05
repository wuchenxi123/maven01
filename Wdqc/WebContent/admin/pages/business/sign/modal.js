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
				url : ctx + "/cs_List.ac",
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
				          { data : "course.coName" },
				          { data : "csOpendatestart" },
				          { data : "timeFrame" },
				          { data : "campus.cpName" },
				          { data : "classroom.crName" } ,
				          { data : "csCharge" } ,
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}],
			fnRowCallback : function(nRow, aData, iDataIndex) {
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:$.page.config.selectPickerCode4Modal(\'' + aData.csId + '\',\'' + aData.csName + '\');"> <i class="fa fa-thumb-tack" ></i> 选择</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				var teacher = "";
				var names="";
				teacher=aData.d;
				for ( var i = 0; i < teacher.datas.length; i++) {
					names=teacher.datas[i].teName;
					$('td:eq(3)', nRow).append(names+ ";");
					
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
			var url1 ="";
			var	pk =c;
			if (pk) {
				$.post(url, {
					"param._pk" : pk
				}, function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {		
						$("[id='form.gsName']").val(data.csName);
						$("[id='form.cltSum']").val(data.csCharge);
						$("[id='form.cltId']").val("");
						$("[id='form.csId']").val(data.csId);
						$.page.config.saveGradlassInfo(url1,data);
						/**/
	/*					alert("ffw");
						for ( var i = 0; i < aDatas.length; i++) {
							alert("ffw");
							var html='<div class="panel panel-warning"><div class="panel-heading"><h3 class="panel-title">班级详情</h3></div><div class="panel-body">'
								html=html+'<label class="col-sm-1 control-label">校区：</label> <div class="col-sm-2"><span>'+data.datas[i].csName+'</span></div> <label class="col-sm-1 control-label">教师：</label>'
								html=html+'<div class="col-sm-2"></div> <label class="col-sm-1 control-label">人数：</label> <div class="col-sm-2"><span>'+data.datas[i].csPeoplecount+'</span></div> <label class="col-sm-1 control-label">费用：</label>';
								html=html+'<div class="col-sm-2 text-danger">￥<span>'+data.datas[i].csCharge+'</span></div></div></div>';
								$("#showgradss").append(html);
						}*/
						
						
					}
					
				});
			} else {
				$.page.setFormOthers();
			}	
		
	},
	saveGradlassInfo : function(url,datag) {
		if (!url)
			url =ctx + "/sc_Save.ac";
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				var scId=data.datas.scId;
				getHtml(datag,scId);
				
			} else {
				alert('保存失败！' + data.msg);
			}
		});
		
	},
	saveChargeInfo : function(url,datag) {
		if (!url)
			url =ctx + "/clt_Save.ac";
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				alert("费用信息保存完成");
				
			} else {
				alert('保存失败！' + data.msg);
			}
		});
		
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
	

};
function getHtml(data,id) {

	var Delete = ctx + '/sc_Del.ac';	
	var html='<div class="panel panel-warning" id="pan_' +id + '"><div class="panel-heading"><a class="panel-title">班级详情</a> <a class="pull-right btn " onclick="$.page.config.fnDel(\'' +Delete+  '?ids=' +id + '\',\''+ id + '\',\''+ data.csCharge + '\');"> ';
	html=html+'<i class="fa fa-times"></i> 删除</a></div><div class="panel-body">';
	html=html+'<label class="col-sm-1 control-label">班名：</label> <div class="col-sm-2"><span>'+data.csName+'</span></div>  <label class="col-sm-1 control-label">费用：</label>';
	html=html+'<div class="col-sm-2 text-danger">￥<span>'+data.csCharge+'</span></div><label class="col-sm-1 control-label">优惠：</label><div class="col-sm-2 text-danger">￥<input type="text" id="reduce" value="0"></div></div></div>';		
	var sum=$("#charge").text();
	c=parseInt(sum)+parseInt(data.csCharge);
	$("#charge").text(c);
	$("#showgradss").append(html);
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
