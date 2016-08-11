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
	          "url": ctx+'/ay_List.ac',
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
	      order: [[ 11, 'desc' ]],
	      /* aoColumnDefs: [{
			 sDefaultContent: '',
			 aTargets: [ '_all' ]
		  }], */
	      columns: [
			  { orderable : false ,searchable : false ,defaultContent : ''},			  
	          { data : "adName" },
	          { data : "adSex" },
	          { data : "adWays" },
	          { data : "adPhone" },
	          { data : "adEmial" },
	          { data : "adHobbies" },
	          { data : "adAddress" },
	          { data : "coursename"  ,orderable : false } ,
	          { data : "adIntention" } ,
	          { data : "creatorname"  ,orderable : false } ,
	          { data : "createTime" } ,
	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
			   	var viewPage = ctx + '/admin/pages/business/consult/view.jsp';
			   	var editPage = ctx + '/admin/pages/business/consult/add.jsp';
			   	var Delete = ctx + '/ay_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.adId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.adId + '\');"><i class="fa fa-eye"></i>修改</a>';
				html = html + '<a class="btn" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.adId + '\');"> <i class="fa fa-times"></i> 删除</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				$('td:eq(2)', nRow).html(aData.adSex=='1'?'男':'女');
				var adWays = "";
				switch (aData.adWays) {
				case 0:
					adWays = '来访';
					break;
				case 1:
					adWays = '来电';
					break;
				case 2:
					adWays = '网络';
					break;
				case 3:
					adWays = '其他';
					break;
				default:

				}
				$('td:eq(3)', nRow).html(adWays);
				var adIntention = "";
				switch (aData.adIntention) {
				case 0:
					adIntention = '一般';
					break;
				case 1:
					adIntention = '中等';
					break;
				case 2:
					adIntention = '强烈';
					break;
				default:

				}
				$('td:eq(9)', nRow).html(adIntention);

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