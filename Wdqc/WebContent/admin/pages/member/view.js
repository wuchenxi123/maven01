$.page.set({
	Edit : ctx + "/mb_Edit.ac",
	Return : ctx + "/admin/pages/member/list.jsp",
	Grid : grid,
	
	fnLoadRole : function() {
		url = ctx + '/role_Show.ac';

		$.post(url, {

		},
				function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {
						for ( var i = 0; i < data.datas.length; i++) {
							var html = '<option value="'
									+ data.datas[i].roleId + '">'
									+ data.datas[i].roleName
									+ '</option>';
							$("[id='form.roleId']").append(html);
						}
						
					}
				});
	},
	fnLoadMember:function(url, pk){
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			url = ctx + '/mb_List.ac';
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
			  			  { data : "mbName" },
				          { data : "mbSex" } ,
				          { data : "roleName" } ,
				          { data : "mbPetName" },
				          { data : "mbEmail" } ,
				          { data : "mbPhone" },
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
			      ], 
			      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					   	var viewPage = ctx + '/admin/pages/member/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.mbId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
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
	$.page.config.fnLoadRole();
	$.page.config.fnLoadMember();
	$.page.formLoad();
	 
});