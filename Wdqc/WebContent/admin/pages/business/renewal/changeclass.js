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
			}
		});
	},
	fnDel: function(url,g) {
		if (!g)
			g = $.page.config.Grid;
		swal({   
			title: "退班",   
			text: "转班前需退当前班级，是否退班",   
			type: "info",   
			showCancelButton: true,   
			closeOnConfirm: false,   
			showLoaderOnConfirm: true, 
			}, 
			function(){
				// 退班
				$.post(url, {

				}, function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {
							g.draw();
							swal({   title: "退班提示!", 
								text: "退班成功", 
								timer: 500,   
								showConfirmButton: false });							
							$('#myModal').modal();
					} else {
						alert(data.msg);
					}
				});
		
				});

	},
	fnFinish : function() {
		$.page.config.saveGradlassInfo();
		
			$('#myModal').on('hidden.bs.modal',
						    function() {								
					 			$.page.load($.page.config.Return);
			}) 
				
	},
	

});
function reload(){
	grid.ajax.reload();
} 
var grid = null;
$(document).ready(function() { 
	grid=$('#user_datatable').DataTable({
	      processing: true,
	      searching : false,
	      serverSide: true,
	      autoWidth : true,
	      pagingType: "simple_numbers",
	      aLengthMenu:[10,5,20,50,100,500],
	      ajax: {
	          "url": ctx + '/sc_List.ac',
	           data:{
	        	   'param._ne_stId': $.page.config.Pk
	        	   },
	          "type": "POST",
	        
	      },
	      order: [[6, 'asc' ]],
	  
	      columns: [
	  			  { orderable : false ,searchable : false ,defaultContent : ''},			  
		          { data : "gradlass.csName",orderable : false },
		          { data : "gradlass.csPeoplecount",orderable : false },
		          { data : "gradlass.csOpendatestart",orderable : false },
		          { data : "gradlass.csOpendateend" ,orderable : false},
		          { data : "gradlass.csCharge",orderable : false } ,
		          { data : "createTime" } ,
		          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
	    	  	var Delete = ctx + '/sc_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn btn-link" onclick="$.page.config.fnDel(\'' +Delete+  '?ids=' +aData.scId+ '\');"> <i class="fa fa-eye"></i>转班</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				

				return nRow;
	      },
	      oLanguage : $.dt.oLanguage,
	      dom : "<'row'<'col-sm-2'l><'col-sm-9 Datatable_Param_Form'><'col-sm-3'f>><'row'<'col-sm-12't>><'row'<'col-sm-5'i><'col-sm-7'p>>",
	      initComplete : addQueryParam
	    });		
	 grid.on( 'order.dt search.dt page.dt length.dt draw.dt', function () {
	    	grid.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } );
	 $.page.set({
	    	Grid : grid
	    });
	$.page.formLoad();
	$.page.config.fnLoadCampus();
});