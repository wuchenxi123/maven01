$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/sign/list.jsp",
	Grid : grid,
	// 完成保存页面跳转
	infosave : function(url) {
		if (!url)
			url = $.page.config.Save;
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				$("[id='form.stId']").val(data.datas.stId);
			} else {
				alert('保存失败！' + data.msg);
			}
		});

	},
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
	fnLoadClass : function(pk) {
		
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			url = ctx + '/sc_List.ac?param._ne_stId='+pk;
			$('#user_datatable').DataTable({
			      processing: true,
			      searching : false,
			      serverSide: true,
			      autoWidth : true,
			      pagingType: "simple_numbers",
			      aLengthMenu:[10,5,20,50,100,500],
			      ajax: {
			          "url": url,
			          "type": "POST",
			        
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
			      order: [[6, 'asc' ]],
			      /* aoColumnDefs: [{
					 sDefaultContent: '',
					 aTargets: [ '_all' ]
				  }], */
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
					   	var viewPage = ctx + '/admin/pages/education/gradlass/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.csId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
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
	fnLoadCostlist : function(url, pk) {		
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			url = ctx + '/ct_List.ac?param._ne_stId='+pk;
			$('#user_datatable1').DataTable({
			      processing: true,
			      searching : false,
			      serverSide: true,
			      autoWidth : true,
			      pagingType: "simple_numbers",
			      aLengthMenu:[10,5,20,50,100,500],
			      ajax: {
			          "url": url,
			          "type": "POST",
			        
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
			      order: [[7, 'asc' ]],
			      /* aoColumnDefs: [{
					 sDefaultContent: '',
					 aTargets: [ '_all' ]
				  }], */
			      columns: [
			  			  { orderable : false ,searchable : false ,defaultContent : ''},			  
				          { data : "csname",orderable : false },
				          { data : "cltApply",orderable : false },
				          { data : "cltSaleboolname",orderable : false },	
				          { data : "cltReduce",orderable : false },	
				          { data : "cltSum" ,orderable : false},
				          { data : "member",orderable : false } ,
				          { data : "createTime" } ,
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
			      ], 
			      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					   	var viewPage = ctx + '/admin/pages/education/gradlass/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.csId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
						html = html + '</div>';
						$('td:eq(-1)', nRow).html(html);
						var sum=$("#costsum").text();
						sum=parseInt(sum)+parseInt(aData.cltSum);
						$("#costsum").text(sum);
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
	$.page.config.fnLoadCampus();
	$.page.config.fnLoadClass();
	$.page.config.fnLoadCostlist();
	$.page.formLoad();
	  
});