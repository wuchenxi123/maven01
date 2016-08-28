$.page.set({
	Save : ctx + "/st_Save.ac",
	Edit : ctx + "/st_Edit.ac",
	Return : ctx + "/admin/pages/business/renewal/list.jsp",
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
				$("#material").hide();

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
			url = ctx + '/sc_List.ac?param._ne_stId='+pk;
			$('#user_datatable').DataTable({
			      processing: true,
			      searching : false,
			      serverSide: true,
			      autoWidth : true,
			      pagingType: "simple_numbers",
			      aLengthMenu:[10,5,20,50,100,500],
			      ajax: {
			          "url": url,
			          "type": "POST",
			        
			      },
			      order: [[6, 'asc' ]],
			  
			      columns: [
			  			  { orderable : false ,searchable : false ,defaultContent : ''},			  
				          { data : "gradlass.csName",orderable : false },
				          { data : "gradlass.csPeoplecount",orderable : false },
				          { data : "gradlass.csOpendatestart",orderable : false },
				          { data : "gradlass.csOpendateend" ,orderable : false},
				          { data : "gradlass.csCharge",orderable : false } ,
				          { data : "createTime" } ,
				          {orderable : false ,searchable : false,defaultContent : '' , width : 130}
			      ], 
			      fnRowCallback : function(nRow,aData,iDataIndex){			    	  
					   	var viewPage = ctx + '/admin/pages/education/gradlass/view.jsp';
						var html = '<div class="btn-group btn-group-xs" role="group" aria-label="...">';
						html = html + '<a class="btn btn-link" href="javascript:loadPage(\'' + viewPage + '\',\'' + aData.csId + '\');"> <i class="fa fa-eye"></i> 查看</a>';
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
	fnUpdateClass : function() {

		url = ctx + '/cs_UpdateRemain.ac';
			pk = $("[id='form.csId']").val();;
			
		if (pk) {
			$.post(url, {
				"param._pk" : pk
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {					
					
				}
			});
		}
	},

	/*fnDel: function(url, id , cr) {
		// 删除宣传图路径
		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				$("div").remove("#pan_" + id);
				var sum=$("#charge").text();
				c=parseInt(sum)-parseInt(cr);
				$("#charge").text(c);
			} else {
				alert(data.msg);
			}
		});
	},*/
	fnFinish : function(url, rtnUrl) {
		$.page.config.fnUpdateClass();
		$.page.config.saveGradlassInfo();
		
		var sum = $("#charge").text();
		var a=$("#apply").text();
		var b =$("[id='cltReduce']").val();
		var apply= parseInt(a)-parseInt(b);
		var costsum = parseInt(sum) - parseInt(b);
		$("[id='form.cltApply']").val(apply);
		$("[id='form.cltReduce']").val(b);
		$("[id='form.cltSum']").val(costsum);
		// 完成保存页面跳转
		if (!url)
			url = ctx + "/ct_Save.ac";
		if (!rtnUrl)
			rtnUrl = $.page.config.Return;
		var formData = $("form").serializeArray();
		$.post(url, formData, function(data, textStatus, jqXHR) {
			if (data.success) {
				alert("信息保存成功");
				$.page.load(rtnUrl);
			} else {
				alert('保存失败！' + data.msg);
			}
		});
	},
	fnDel1: function(id,price) {
		var sum=parseInt($("#charge").text())-parseInt(price);
		$("#charge").text(sum);
		$("#showmtl").empty();
		$("[id='cltSaletextbookid']").val("");
		$("[id='cltSaletextbookid']").attr('disabled',false);
		$("[id='form.cltSaleboolname']").val("0");
		$("div").remove("#pan1_" + id);
	},
	
	getsum: function() {
		var sum = $("#chargeadd").text();
		var b =$("[id='cltReduce']").val();
		var costsum = parseInt(sum) - parseInt(b);
		$("#charge").text(costsum);
	},
});
$(document).ready(function() {
	$.page.formLoad();
	$.page.config.fnLoadCampus();
	$.page.config.fnLoadClass();
});