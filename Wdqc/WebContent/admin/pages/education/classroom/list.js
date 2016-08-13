/*var ctx = "${pageContext.request.contextPath}";
$formLoad = function(url, pk) {
	url ='http://localhost:8080/weiyanggucheng/cou_Show.ac';
		$.post(url, {
		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				for(var i=0;i<data.datas.length;i++){						
					alert(data.datas[i].coId);				
				}								
		}
	}); 
};*/
$.fnLoadCampus =function() {
		url = ctx + '/cp_Show.ac';
		$.post(url, {
		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				var htmlInit = '<option value=""></option>';
				$("[id='param._ne_crCampus']").append(htmlInit);
				for ( var i = 0; i < data.datas.length; i++) {
					var html = '<option value="' + data.datas[i].cpId + '">'
							+ data.datas[i].cpName + '</option>';
					$("[id='param._ne_crCampus']").append(html);
				}
				/**/
			}
		});
	};
var grid = null;
$(document).ready(function() {
		$.fnLoadCampus();
	 	  grid = $('#user_datatable').DataTable({
	      processing: true,
	      searching : false,
	      serverSide: true,
	      autoWidth : true,
	      pagingType: "simple_numbers",
	      aLengthMenu:[10,5,20,50,100,500],
	      ajax: {
	    	  "url": ctx+'/cr_List.ac',
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
	      order: [[ 2, 'asc' ]],
	      /* aoColumnDefs: [{
			 sDefaultContent: '',
			 aTargets: [ '_all' ]
		  }], */
	      columns: [
			  { orderable : false ,searchable : false ,defaultContent : ''},	
	          { data : "crName" },
	          { data : "crCapacity"},
	          { data : "campus.cpName" },
	          { data : "msStartDate" },
	          { data : "msEndDate" },
	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
			  /* 	var viewPage = ctx + '/admin/pages/education/material/view.jsp';*/
			   	var editPage = ctx + '/admin/pages/education/classroom/add.jsp';
			   	var Delete = ctx + '/cr_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
/*				html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.mtlId + '\');"> <i class="fa fa-edit"></i> 查看</a>';*/
				html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.crId + '\');"><i class="fa fa-edit"></i>修改</a>';
/*				html = html + '<a class="btn btn-link" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.crId + '\');"> <i class="fa fa-times"></i> 删除</a>';*/
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
//				var Price="";
//				Price="<a class="+'text-danger'+">"+'￥'+aData.mtlPrice+'.00'+"</a>";
//				$('td:eq(6)', nRow).html(Price);
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
	  });
	function addQueryParam(data){
		$('.Datatable_Param_Form').html($('#Datatable_Param_Form').html());
		$('#Datatable_Param_Form').remove();
		
		// key down event
		$('.Datatable_Param_Form input').keydown(function(event) {
			switch (event.keyCode) {
			case 0xD:
				reload();
				break;
			default:
				
			}
		});
	}
	function reload(){
		grid.ajax.reload();
	}