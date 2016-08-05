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
	          "url": ctx+'/te_List.ac',
	          "type": "POST",
	          data : function(d){
	            	  // add query param to data
	            var params = $('.Datatable_Param_Form form').serializeArray();
//	            params.csId=form.csId;
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
			   	var editPage = ctx + '/admin/pages/education/teacher/add.jsp';
			   	var Delete = ctx + '/te_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.teId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.teId + '\');"><i class="fa fa-eye"></i>修改</a>';
				html = html + '<a class="btn" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.teId + '\');"> <i class="fa fa-times"></i> 删除</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
//				var teacher;
//				var names="";
//				teacher=aData.teaList;
//				if(teacher!=null){
//					for ( var i = 0; i < teacher.length; i++) {
//						names=teacher[i].teName;
//						$('td:eq(3)', nRow).append(names+ " | ");
//					
//					}
//				}
				$('td:eq(2)', nRow).html(aData.teSex=='1'?'女':'男');
/*				var appIcon = '<div class="pull-left image"><img src="' + ctx + "/" + aData.appIcon + '" class="img-circle" width="45" height="45" /></div>';
				
				$('td:eq(5)', nRow).html(aData.appRecommend=='1'?'是':'否');
				$('td:eq(6)', nRow).html(aData.tolistSet=='1'?'是':'否');*/
				/*$('td:eq(1)', nRow).html(appIcon);*/
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