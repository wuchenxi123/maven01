$.page.set({
	Edit : ctx + "/te_Edit.ac",
	Return : ctx + "/admin/pages/education/teacher/list.jsp",
	Grid : grid,
	
	
	fnLoadTeacher:function(url, pk){
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			url = ctx + '/te_List.ac';
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
			  			  { data : "teName" },
				          { data : "teSex" },
				          { data : "teAge" },
				          { data : "teLocation" },
				          { data : "teMobile" },
				          { data : "teArrivegradlassrate" },
				          { data : "teGradlasscount" },
				          { data : "updatedate" },
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
			      ], 
			      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					   	var viewPage = ctx + '/admin/pages/education/teacher/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.teId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
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
	
	fnLoadGradlass:function(url, pk){
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			url = ctx + '/te_ListGradlass.ac?param._ne_teId='+pk;
			grid = $('#user_datatable1').DataTable({
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
			      order: [],
			      /* aoColumnDefs: [{
					 sDefaultContent: '',
					 aTargets: [ '_all' ]
				  }], */
			      columns: [
			  			  { orderable : false ,searchable : false ,defaultContent : ''},			  
			  			  { data : "csName" },
				          { data : "csPeoplecount" },
				          { data : "coName" ,orderable : false ,},
				          { data : "csOpendatestart" },
				          { data : "csWeekend" },
				          { data : "timeFrame" ,orderable : false ,},
				          { data : "cpName" ,orderable : false ,},
				          { data : "crName" ,orderable : false ,} ,
				          { data : "csCharge" } ,
				          { data : "csStatus" } ,
				          { data : "createTime" } ,
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
			      ], 
			      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					   	var viewPage = ctx + '/admin/pages/education/teacher/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.teId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
						html = html + '</div>';
						$('td:eq(-1)', nRow).html(html);
						$('td:eq(10)', nRow).html(aData.csStatus=='0'?'开班':'下线');

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
	$.page.config.fnLoadTeacher();
	$.page.config.fnLoadGradlass();
	$.page.formLoad();
	 
});