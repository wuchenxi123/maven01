$.page.set({
			Save : ctx + "/cs_Save.ac",
			Edit : ctx + "/cs_Edit.ac",
			Return : ctx + "/admin/pages/education/gradlass/list.jsp",
			gradlassurl:ctx + "/cs_Edit.ac",
			Grid : grid,
			fnLoadClassroom : function() {
				url = ctx + '/cr_Show.ac';
				$.post(url, {
				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								for ( var i = 0; i < data.datas.length; i++) {
									var html = '<option value="'
											+ data.datas[i].crId + '">'
											+ data.datas[i].crName
											+ '</option>';
									$("[id='form.crId']").append(html);
								}
							}
						});
			},
			fnLoadCampus : function() {
				url = ctx + '/cp_Show.ac';
				$.post(url, {
				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								for ( var i = 0; i < data.datas.length; i++) {
									var html = '<option value="'
											+ data.datas[i].cpId + '">'
											+ data.datas[i].cpName
											+ '</option>';
									$("[id='form.cpId']").append(html);
								}
							}
						});
			},
			fnLoadStudentList:function(url, pk){
				if (!pk)
					pk = $.page.config.Pk;
				if (!pk)
					pk = $.page.config.Data.Pk;
			
				if (!pk) pk = $.query.get('param._pk');
				if (pk) {
					url = ctx + '/cs_ListStudent.ac?param._ne_csId='+pk;
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
					      order: [[ 9, 'asc' ]],
					      columns: [
					  			  { orderable : false ,searchable : false ,defaultContent : ''},			  
					  			  { data : "stName" },
						          { data : "stSex" },
						          { data : "stAge" },
						          { data : "stMobile" },
						          { data : "stEmail" },
						          { data : "stStatus" } ,
						          { data : "stReside" } ,
						          { data : "creatorname",orderable : false , } ,	         
								  { data : "createTime" } ,
					  	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
					  	      ], 
					  	    fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					  	    	var viewPage = ctx + '/admin/pages/business/sign/view.jsp';
								var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
								html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.stId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
								html = html + '</div>';
								$('td:eq(-1)', nRow).html(html);
								$('td:eq(2)', nRow).html(aData.stSex=='0'?'男':'女');
								var stStatus = "";
								switch (aData.stStatus) {
								case "0":
									stStatus = '开课';
									break;
								case "1":
									stStatus = '停课';
									break;
								case "2":
									stStatus = '课程过期';
									break;
								default:

								}
								$('td:eq(7)', nRow).html(stStatus);
								return nRow;
					      },
					      oLanguage : $.dt.oLanguage,
					      dom : "<'row'<'col-sm-2'l><'col-sm-9 Datatable_Param_Form'><'col-sm-3'f>><'row'<'col-sm-12't>><'row'<'col-sm-5'i><'col-sm-7'p>>",
					      initComplete : addQueryParam
					    });
			}
					    grid.on( 'order.dt search.dt page.dt length.dt draw.dt', function () {
					    	grid.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
					            cell.innerHTML = i+1;
					        } );
					    } );
			},
			fnFinish : function( rtnUrl) {

					rtnUrl = $.page.config.Return;
						$.page.load(rtnUrl);
					
				
			},
	
	setFormOthers : function() {

	},
	fnLoadGradlass : function() {
		url = ctx + '/cou_Show.ac';
		$.post(url, {
		},
				function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {
						for ( var i = 0; i < data.datas.length; i++) {
							var html = '<option value="'
									+ data.datas[i].coId + '">'
									+ data.datas[i].coName
									+ '</option>';
							$("[id='form.coId']").append(html);
						}
					}
					$.page.formLoad();
				});
	},
	
//	fnLoadTeacher : function() {
//		url = ctx + '/te_Show.ac';
//		$.post(url, {
//		},
//				function(data, textStatus, jqXHR) {
//					if ("success" == textStatus) {
//						for ( var i = 0; i < data.datas.length; i++) {
//							html = '<option value="'
//									+ data.datas[i].teId + '">'
//									+ data.datas[i].teName
//									+ '</option>';
//							htmltea+=html;
//							$("[id='form.teacher.teId']").append(html);
//						}
//						$.page.formLoad();
//					}
//				});
//	},
	
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


$(document).ready(function() {
//	alert($("[id='form.csName']").val());
	$.page.config.fnLoadCampus();
	$.page.config.fnLoadGradlass();
	$.page.config.fnLoadClassroom();
//	$.page.config.fnLoadTeacher();
	$.page.config.fnLoadGradlass();
	$.page.config.fnLoadStudentList();
	$.page.formLoad();
});