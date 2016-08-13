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
			fnLoadGradlassList:function(url, pk){
//				if (!pk)
//					pk = $.page.config.Pk;
//				if (!pk)
//					pk = $.page.config.Data.Pk;
//			
//				if (!pk) pk = $.query.get('param._pk');
//
//				if (pk) {
					url = ctx + '/cs_List.ac';
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
					  	          { data : "csName" },
					  	          { data : "csPeoplecount" },
					  	          { data : "" },
					  	          { data : "coName" },
					  	          { data : "csOpendatestart" },
					  	          { data : "cpName" },
					  	          { data : "crName" } ,
					  	          { data : "csCharge" } ,
					  	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
					  	      ], 
					  	    fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					  	    	var viewPage = ctx + '/admin/pages/education/gradlass/view.jsp';
								var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
								html = html + '<a class="btn" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.csId + '\');"> <i class="fa fa-edit"></i> 查看</a>';
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
//				}
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
	$.page.config.fnLoadGradlassList();
=======
			Return : ctx + "/admin/pages/business/sign/list.jsp",
			gradlassurl:ctx + "/cs_Edit.ac",
			Grid : grid,
			fnLoadStudent:function(url, pk){
				if (!pk)
					pk = $.page.config.Pk;
				if (!pk)
					pk = $.page.config.Data.Pk;
			
				if (!pk) pk = $.query.get('param._pk');

				if (pk) {
					alert(pk);
					url = ctx + '/sc_List.ac?param._ne_csId='+pk;
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
					      order: [[ 11, 'desc' ]],
					      /* aoColumnDefs: [{
							 sDefaultContent: '',
							 aTargets: [ '_all' ]
						  }], */
					      columns: [
					  			  { orderable : false ,searchable : false ,defaultContent : ''},	

					  	          { data : "student.stName" },
					  	          { data : "student.stSex" },
					  	          { data : "student.stAge" },
					  	          { data : "student.stMobile" },
					  	          { data : "student.stEmail" },
					  	          { data : "student.stMotherMobile" ,orderable : false ,},
					  	          { data : "student.stStatus" } ,
					  	          { data : "student.stReside" } ,
					  	          { data : "student.stBirthday",orderable : false , } ,	         
					  			  {	data : "student.salerName",orderable : false ,defaultContent : '无' ,},
					  			  { data : "createTime" } ,
					  	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
					  	      ], 
					  	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					  			   	var viewPage = ctx + '/admin/pages/business/sign/view.jsp';
					  				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
					  				html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.stId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
					  				html = html + '</div>';
					  				$('td:eq(-1)', nRow).html(html);
					  				$('td:eq(2)', nRow).html(aData.student.stSex=='0'?'男':'女');
					  				
					  /*				var names="";
					  				Grad=aData.grad;
					  				for ( var i = 0; i < Grad.datas.length; i++) {
					  					names=Grad.datas[i].gradlass.csName;
					  					var html='<table><thead><tr>'+names+'</tr></thead></table>';
					  					$('td:eq(10)', nRow).append(html);
					  					
					  				}*/
					  				
					  				var stStatus = "";
					  				switch (aData.student.stStatus) {
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
	setFormOthers : function() {

	},
	fnLoadCourse : function() {
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
	$.page.config.fnLoadCourse();
	$.page.config.fnLoadStudent();
	$.page.config.fnLoadClassroom();
>>>>>>> branch 'master' of git@github.com:wuchenxi123/wdqc.git
	$.page.formLoad();
});
