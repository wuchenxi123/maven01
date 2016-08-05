//@ sourceURL=modal.js
var def ='#Gradlass';
var con = '_orderby:csId;_desc:1;queryAll:true;';
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
				url : ctx + "/pk_List.ac",
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
			columns : [ {
				orderable : false,
				searchable : false,
				defaultContent : '',
				width : '10px'
			}, {
				data : "code",
				width : 30
			}, {
				data : "name",
				width : 150
			}, {
				orderable : false,
				searchable : false,
				defaultContent : '',
				width : 30
			} ],
			fnRowCallback : function(nRow, aData, iDataIndex) {
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:$.page.config.selectPickerCode4Modal(\'' + aData.code + '\',\'' + aData.name + '\');"> <i class="fa fa-thumb-tack"></i> 选择</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				return nRow;
			},
			oLanguage : $.dt.oLanguage,
			dom : "<'row'<'col-sm-2'l><'col-sm-10 Picker_Datatable_Param_Form'><'col-sm-3'f>><'row'<'col-sm-12't>><'row'<'col-sm-5'i><'col-sm-7'p>>",
			initComplete : $.page.config.addPickerQueryParam
		});
	}
};

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
