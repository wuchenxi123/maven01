/*by hu jianjun*/
$.page.set({
	View : ctx + "/ay_Edit.ac",
	CouseView:ctx+"/cou_Edit.ac",
	Return : ctx + "/admin/pages/store/application/list.jsp",
	formLoadview : function(url, pk) {
		if (!url)
			url = $.page.config.View;
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.query.get('param._pk');
		if (pk) {
			$.post(url, {
				"param._pk" : pk
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
						for ( var attr in data) {
							$("[id='form." + attr + "']").val(data[attr]);						
						}						
				}
			});
		} else {
			$.page.setFormOthers();
		}
	},

});
$(document).ready(function() {
	// laod form datas
	$.page.config.formLoadview();
});
