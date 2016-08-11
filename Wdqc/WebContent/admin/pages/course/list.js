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
$(document).ready(function() {
	 var grid = $('#user_datatable').DataTable({
	      processing: true,
	      searching : false,
	      serverSide: true,
	      autoWidth : true,
	      pagingType: "simple_numbers",
	      aLengthMenu:[10,5,20,50,100,500],
	      ajax: {
	          "url": ctx+'/cou_List.ac',
	          "type": "POST"
	      },
	      /* columnDefs: [ {
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
			  { orderable : false ,searchable : false ,defaultContent : ''},
	          { data : "coName" },
	          { data : "coCycle" },
	          { data : "coTeacher" },
	          { data : "coTutor" },
	          { data : "coCharge" },
	          { data : "createTime" } ,
	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
			   	var viewPage = ctx + '/admin/pages/course/view.jsp';
			   	var editPage = ctx + '/admin/pages/course/add.jsp';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.coId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.coId + '\');"><i class="fa fa-eye"></i>修改</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);

/*				var appIcon = '<div class="pull-left image"><img src="' + ctx + "/" + aData.appIcon + '" class="img-circle" width="45" height="45" /></div>';
				$('td:eq(4)', nRow).html(aData.boutiqueSet=='1'?'是':'否');
				$('td:eq(5)', nRow).html(aData.appRecommend=='1'?'是':'否');
				$('td:eq(6)', nRow).html(aData.tolistSet=='1'?'是':'否');*/
				/*$('td:eq(1)', nRow).html(appIcon);*/
				return nRow;
	      },
	      oLanguage : {
	          sLengthMenu: "每页显示 _MENU_ 条记录",   
	          sZeroRecords: "没有检索到数据",   
	          sInfo: "当前数据为从第 _START_ 到第 _END_ 条数据；总共有 _TOTAL_ 条记录",   
	          sInfoEmtpy: "没有数据",   
	          sProcessing: "正在加载数据...",   
	          oPaginate: {   
	              sFirst: "首页",   
	              sPrevious: "上一页",   
	              sNext: "下一页",   
	              sLast: "尾页"  
	          }   
	      }
	    });
	    
	    grid.on( 'order.dt search.dt page.dt length.dt draw.dt', function () {
	    	grid.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } );
	    
});
