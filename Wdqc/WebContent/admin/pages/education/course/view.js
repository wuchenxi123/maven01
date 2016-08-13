$.page.set({
	Save : ctx + "/cou_Save.ac",
	Edit : ctx + "/cou_Edit.ac",
	Return : ctx + "/admin/pages/education/course/list.jsp",
	Grid : grid,
	// 完成保存页面跳转
	infosave : function(url) {
		if (!url)
			url = $.page.config.Save;
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				$("[id='form.coId']").val(data.datas.coId);
			} else {
				alert('保存失败！' + data.msg);
			}
		});

	},
	fnLoadMember : function() {
		url = ctx + '/mb_Show.ac';

		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				for ( var i = 0; i < data.datas.length; i++) {
					var html = '<option value="' + data.datas[i].mbId + '">'
							+ data.datas[i].mbName + '</option>';
					$("[id='form.creator']").append(html);
				}
				/**/
				// laod form datas
				$.page.formLoad();

			}
		});
	},
	fnLoadCourse:function(url, pk){
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			url = ctx + '/cou_List.ac';
			grid = $('#user_datatable').DataTable({
			      processing: true,
			      searching : false,
			      serverSide: true,
			      autoWidth : true,
			      pagingType: "simple_numbers",
			      aLengthMenu:[10,5,20,50,100,500],
			      ajax: {
			          "url": url,
			          "type": "POST",
			          data : function(d){
			            	  // add query param to data
			            var params = $('.Datatable_Param_Form form').serializeArray();
			            var p = $.serializeJson(params); 
			            $.apply(d,p);
			            }
			      },
		/*	      columnDefs: [ {
			          searchable: false,
			          orderable: false,
			          targets: 0,
			          sDefaultContent : ''
			      },{
			          searchable: false,
			          orderable: false,
			          targets: 7
			      } ], */
			      order: [[ 1, 'asc' ]],
			      /* aoColumnDefs: [{
					 sDefaultContent: '',
					 aTargets: [ '_all' ]
				  }], */
			      columns: [
			  			  { orderable : false ,searchable : false ,defaultContent : ''},			  
			  			 { data : "coName" },
				          { data : "creatername" } ,
				          { data : "updatetime" } ,
				          { data : "createtime" } ,
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
			      ], 
			      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					   	var viewPage = ctx + '/admin/pages/education/course/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.coId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
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
		}
	},
	fnFinish : function( rtnUrl) {

			rtnUrl = $.page.config.Return;
				$.page.load(rtnUrl);
			
		
	},

});

$(document).ready(function() {
	$.page.config.fnLoadCourse();
	$.page.formLoad();
	 
});