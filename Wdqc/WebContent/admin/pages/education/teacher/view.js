$.page.set({
<<<<<<< HEAD
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
	fnFinish : function( rtnUrl) {

			rtnUrl = $.page.config.Return;
				$.page.load(rtnUrl);
			
		
	},

});

$(document).ready(function() {
	$.page.config.fnLoadTeacher();
	$.page.formLoad();
	 
=======
			Save : ctx + "/cs_Save.ac",
			Edit : ctx + "/cs_Edit.ac",
			Return : ctx + "/admin/pages/business/sign/list.jsp",
			gradlassurl:ctx + "/cs_Edit.ac",
			formLoad : function(url, pk) {
				if (!pk)
					pk = $.page.config.Pk;
				if (!pk)
					pk = $.page.config.Data.Pk;
				/*
				 * if (!pk) pk = $.query.get('param._pk');
				 */
				if(pk){
				 	  grid = $('#user_datatable').DataTable({
				      processing: true,
				      searching : false,
				      serverSide: true,
				      autoWidth : true,
				      pagingType: "simple_numbers",
				      aLengthMenu:[10,5,20,50,100,500],
				      ajax: {
				          "url": ctx+'/te_ListGradlass.ac?param._ne_teId='
							+ pk,
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
				          { data : "csEveryclass" },
				          { data : "csTuition" },
				          { data : "csOpendatestart" },
				          { data : "csClasshour" },
				          { data : "csWeekend" },
				          { data : "csCharge" },
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
				      ], 
				      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
				    		var studentPage = ctx + '/admin/pages/education/gradlass/view.jsp';
						   	var editPage = ctx + '/admin/pages/education/gradlass/edit.jsp';
						   	var Delete = ctx + '/cs_Del.ac';
							var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
							html = html + '<a class="btn" href="javascript:loadPage(\'' + studentPage + '\',\'' + aData.csId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
							html = html + '<a class="btn" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.csId + '\');"><i class="fa fa-eye"></i>修改</a>';
							html = html + '<a class="btn" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.csId + '\');"> <i class="fa fa-times"></i> 删除</a>';
							html = html + '</div>';
							$('td:eq(-1)', nRow).html(html);
//							alert(aData.gradlassList.length);
							var teacher;
//							var names="";
//							teacher=aData.teaList;
//							if(teacher!=null){
//								for ( var i = 0; i < teacher.length; i++) {
//									names=teacher[i].teName;
//									$('td:eq(3)', nRow).append(names+ " | ");
//								
//								}
//							}
//							$('td:eq(4)', nRow).html(aData.gradlassList[0].csTuition);
//							$('td:eq(7)', nRow).html(aData.gradlassList[0].csWeekend);
							var csTuition = "";
							switch (aData.csTuition) {
							case 0:
								csTuition = '按期';
								break;
							case 1:
								csTuition = '按课时';
								break;
							case 2:
								csTuition = '按时间';
								break;
							default:

							}
							$('td:eq(4)', nRow).html(csTuition);

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
					}
	},
	
	setFormOthers : function() {

	},
});

function addQueryParam(data) {
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
function getUrlParam(name) {
	// 构造一个含有目标参数的正则表达式对象
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	// 匹配目标参数
	var r = window.location.search.substr(1).match(reg);
	alert(r);
	// 返回参数值
	if (r != null)
		return unescape(r[2]);
	return null;
}
function reload() {
	grid.ajax.reload();
}
var grid = null;
$(document).ready(function() {
	$.page.formLoad();
	$.page.config.formLoad();
>>>>>>> branch 'master' of git@github.com:wuchenxi123/wdqc.git
});
