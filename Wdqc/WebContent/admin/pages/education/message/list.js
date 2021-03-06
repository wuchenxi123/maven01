var grid = null;
$(document).ready(function() {
		
	 	  grid = $('#user_datatable').DataTable({
	      processing: true,
	      searching : false,
	      serverSide: true,
	      autoWidth : true,
	      pagingType: "simple_numbers",
	      aLengthMenu:[10,5,20,50,100,500],
	      ajax: {
	    	  	"url": ctx+'/mg_List.ac',
	          	"type": "POST",
	          	data : function(d){
	            var params = $('.Datatable_Param_Form form').serializeArray();
	            var p = $.serializeJson(params); 
	            $.apply(d,p);
	            }
	      },
	      order: [[ 2, 'asc' ]],
	      columns: [
			  { orderable : false ,searchable : false ,defaultContent : ''},	
	          { data : "mgTitle" },
	          { data : "mgType"},
	          { data : "mgCreatorname" },
	          { data : "mgCreattime" },
	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
			   	var editPage = ctx + '/admin/pages/education/message/edit.jsp';
			   	var Delete = ctx + '/mg_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
/*				html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.mtlId + '\');"> <i class="fa fa-edit"></i> 查看</a>';*/
				html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.mgId + '\');"><i class="fa fa-edit"></i>修改</a>';
				html = html + '<a class="btn btn-link" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.mgId + '\');"> <i class="fa fa-times"></i> 删除</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				var mgType = "";
				switch (aData.mgType) {
				case "0":
					mgType = '教务教学';
					break;
				case "1":
					mgType = '人事调整';
					break;
				case "2":
					mgType = '比赛通知';
					break;
				case "3":
					mgType = '荣誉展示';
					break;
				default:

				}
				$('td:eq(2)', nRow).html(mgType);
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