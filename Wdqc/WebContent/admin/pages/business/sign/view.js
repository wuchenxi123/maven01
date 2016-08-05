$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/sign/list.jsp",
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
	fnLoadClass : function(url, pk) {
		url = ctx + '/sc_Show.ac';
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			$.post(url, {
				"param._ne_stId" : pk
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
					$("#showgradss").empty();
					$("#charge").text("0");
					for ( var i = 0; i < data.datas.length; i++) {
						sum=$("#charge").text();
						c=parseInt(sum)+parseInt(data.datas[i].gradlass.csCharge);
						$("#charge").text(c);
						var Delete = ctx + '/sc_Del.ac';	
						var html='<div class="panel panel-warning" id="pan_' +data.datas[i].scId + '"><div class="panel-heading"><a class="panel-title">班级详情</a>  ';
						html=html+'</div><div class="panel-body">';
						html=html+'<label class="col-sm-1 control-label">班名：</label> <div class="col-sm-2"><span>'+data.datas[i].gradlass.csName+'</span></div> <label class="col-sm-1 control-label">班级容量：</label>';
						html=html+'<div class="col-sm-2 text-danger"><span>'+data.datas[i].gradlass.csPeoplecount+'</span></div>';	
						html=html+'<label class="col-sm-1 control-label">报名日期：</label><div class="col-sm-2 text-danger"><span>'+data.datas[i].createTime+'</span></div></div></div>';	
						$("#showgradss").append(html);
					}
					$("[id='form.cltId']").val("");
				}
			});
		}
	},
	fnLoadCostlist : function(url, pk) {
		url = ctx + '/ct_Show.ac';
		if (!pk)
			pk = $.page.config.Pk;
		if (!pk)
			pk = $.page.config.Data.Pk;
	
		if (!pk) pk = $.query.get('param._pk');

		if (pk) {
			$.post(url, {
				"param._ne_stId" : pk
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
					$("#showcost").empty();
					$("#costsum").text("0");
					for ( var i = 0; i < data.datas.length; i++) {
						sum=$("#costsum").text();
						c=parseInt(sum)+parseInt(data.datas[i].cltSum);
						$("#costsum").text(c);
						var html='<div class="panel panel-warning" id="pan_' +data.datas[i].cltId + '"><div class="panel-heading"><a class="panel-title">账单详情</a>  ';
						html=html+'</div><div class="panel-body">';
						html=html+'<label class="col-sm-1 control-label">报班班名：</label> <div class="col-sm-2"><span>'+data.datas[i].gradlass.csName+'</span></div> <label class="col-sm-1 control-label">报名费用：</label>';
						html=html+'<div class="col-sm-2 text-danger"><span>'+data.datas[i].cltSum+'</span></div>';	
						html=html+'<label class="col-sm-1 control-label">缴费日期：</label><div class="col-sm-2 text-danger"><span>'+data.datas[i].createTime+'</span></div>';
						html=html+'<label class="col-sm-1 control-label">经办人：</label><div class="col-sm-2"><span>'+data.datas[i].member.mbName+'</span></div></div></div>';	
						$("#showcost").append(html);
					}
				}
			});
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
	          { data : "stMobile" },
	          { data : "stEmail" },
	          { data : "campus.cpName" ,orderable : false ,},
	          { data : "stStatus" } ,
	          { data : "stReside" } ,
	          { data : "member.mbName",orderable : false , } ,
	          { data : "createTime" } ,
			  { orderable : false ,searchable : false ,defaultContent : ''},	
	          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
	      ], 
	      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
			   	var viewPage = ctx + '/admin/pages/business/sign/view.jsp';
			   	var editPage = ctx + '/admin/pages/business/sign/edit.jsp';
			   	var Delete = ctx + '/st_Del.ac';
				var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
				html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.stId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
				html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + editPage + '\',\'' + aData.stId + '\');"><i class="fa fa-edit"></i>修改信息</a>';
				html = html + '<a class="btn btn-link" onclick="$.page.del(\'' +Delete+ '?ids=' + aData.stId + '\');"> <i class="fa fa-times"></i> 删除</a>';
				html = html + '</div>';
				$('td:eq(-1)', nRow).html(html);
				$('td:eq(2)', nRow).html(aData.stSex=='0'?'男':'女');
				/*$('td:eq(7)', nRow).html(aData.stStatus=='0'?'上课':'已结课');*/
				
				var names="";
				Grad=aData.grad;
				for ( var i = 0; i < Grad.datas.length; i++) {
					names=Grad.datas[i].gradlass.csName;
					var html='<table><thead><tr>'+names+'</tr></thead></table>';
					$('td:eq(11)', nRow).append(html);
					
				}
				
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
	    
	    grid.on( 'order.dt search.dt page.dt length.dt draw.dt', function () {
	    	grid.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } );
	    
	    $.page.set({
	    	Grid : grid
	    });
});