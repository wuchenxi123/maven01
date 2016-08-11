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
	 console.log(window.location.href);  
//	 console.log(getUrlParam('csId'));  
	 	  grid = $('#user_datatable').DataTable({
	      processing: true,
	      searching : false,
	      serverSide: true,
	      autoWidth : true,
	      pagingType: "simple_numbers",
	      aLengthMenu:[10,5,20,50,100,500],
	      ajax: {
	          "url": ctx+'/st_List.ac',
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
	      order: [[ 2, 'asc' ]],
	      /* aoColumnDefs: [{
			 sDefaultContent: '',
			 aTargets: [ '_all' ]
		  }], */
	      columns: [
			  { orderable : false ,searchable : false ,defaultContent : ''},			  
	          { data : "stName" },
	          { data : "stSex" },
	          { data : "stAge" },
	          { data : "stLocationSchool" },
	          { data : "stGradeClass" },
	          { data : "stReside" },
	          { data : "stMobile" },
	          { data : "stFatherMobile" } ,
	          { data : "stMotherMobile" } ,
	          { data : "stStatus" },
	          { data : "slId" },
	          { data : "stBirthday" },
	          { data : "createTime" } ,
	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
			   	var viewPage = ctx + '/admin/pages/course/view.jsp';
			   	var editPage = ctx + '/admin/pages/education/gradlass/edit.jsp';
			   	var Delete = ctx + '/cs_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.csId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
				html = html + '<a class="btn" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.csId + '\');"><i class="fa fa-eye"></i>修改</a>';
				html = html + '<a class="btn" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.csId + '\');"> <i class="fa fa-times"></i> 删除</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				var teacher;
				var names="";
				teacher=aData.teaList;
				if(teacher!=null){
					for ( var i = 0; i < teacher.length; i++) {
						names=teacher[i].teName;
						$('td:eq(3)', nRow).append(names+ " | ");
					
					}
				}
				$('td:eq(2)', nRow).html(aData.stSex=='1'?'女':'男');
				var stStatus = "";
				switch (aData.stStatus) {
				case 0:
					console.log("1222");
					stStatus = '欠费';
					break;
				case 1:
					console.log("122222");
					stStatus = '正常';
					break;
				case 2:
					stStatus = '转出';
					break;
				case 3:
					stStatus = '停课';
					break;
				case 4:
					stStatus = '退费';
					break;
				case 5:
					console.log("12222");
					stStatus = '结课';
					break;
				default:
				}
				console.log(aData.stStatus);
				$('td:eq(10)', nRow).html(stStatus);

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
	function getUrlParam(name){  
	    //构造一个含有目标参数的正则表达式对象  
	    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
	    //匹配目标参数  
	    var r = window.location.search.substr(1).match(reg); 
	    alert(r);
	    //返回参数值  
	    if (r!=null) return unescape(r[2]);  
	    return null;  
	}  
	function reload(){
		grid.ajax.reload();
	}