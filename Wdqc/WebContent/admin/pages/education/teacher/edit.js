var k=1;
var htmltea="";
$.page.set({
			Save : ctx + "/cs_Save.ac",
			Edit : ctx + "/cs_Edit.ac",
			Return : ctx + "/admin/pages/education/gradlass/list.jsp",
			// 完成保存页面跳转
			finish:function(url, rtnUrl) {
				if (!url)
					url = $.page.config.Save;
				if (!rtnUrl)
					rtnUrl = $.page.config.Return;
				var formData = $("form").serializeArray();
				$.post(url, formData, function(data, textStatus, jqXHR) {
					if (data.success) {
						alert('编辑成功!');
						$.page.load(rtnUrl);
					} else {
						alert('编辑失败！' + data.msg);
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
							$.page.formLoad();
						});
//				alert($("[id='form.campus.cpId']").val());
//				alert($("[id='form.csName']").val());
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
							/**/
						}
						$.page.formLoad();
					});
			},
			fnLoadGroup : function() {
				
				url = ctx + '/grp_Show.ac';

				$.post(url, {

				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								for ( var i = 0; i < data.datas.length; i++) {
									var html = '<option value="'
											+ data.datas[i].groupId + '">'
											+ data.datas[i].groupName
											+ '</option>';
									$("[id='form.coClassify']").append(html);
								}
								
							}
						});
//				alert($("[id='form.campus.cpId']").val());
//				alert($("[id='form.csName']").val());
			},
			fnLoadClassify : function(coid) {
				url = ctx + '/cou_ShowClassify.ac';
				$.post(url, {
					"param._ne_coId" : coid
				}, function(data, textStatus, jqXHR) {
					$("[id='form.coClassify']").empty();
					if ("success" == textStatus) {
						for ( var i = 0; i < data.datas[0].gs.length; i++) {
							var html = '<option value="'
									+ data.datas[0].gs[i].groupId + '">'
									+ data.datas[0].gs[i].groupName
									+ '</option>';
							$("[id='form.coClassify']").append(html);
						}
					}
				});
			},
			
			getGradlassinfo:function(){
//				var url=ctx + "/cs_Edit.ac";
				$.post(url,
//				{
//					"param.pk":$("[id='form.csId']").val()
//				},
					function(data, textStatus, jqXHR) {
//					alert($("[id='form.csName']").val());
//					alert($("[id='form.coId']").val());
					if ("success"==textStatus) {
						var tuition=$("[id='form.csTuition']").val();
						var coId1=$("[id='form.coId']").val();
						$("[id='form.csTuition']").get(tuition).checked=true; 
						$("[id='reservation']").val($("[id='form.csOpendatestart']").val()+"--"+$("[id='form.csOpendateend']").val());
						$("[id='form.csOpendatestart']").val($("[id='form.csOpendatestart']").val());
				        $("[id='form.csOpendateend']").val($("[id='form.csOpendateend']").val());
						$.page.config.fnLoadTime($("[id='form.csOpendatestart']").val(),$("[id='form.csOpendateend']").val());
						$("[id='form.csOpendatestart']").val()==""||null?
								$("[id='form.csOpendatestatus']").prop("checked", true):$("[id='form.csOpendatestatus']").prop("checked", false);
						$("[id='form.csWeekend']").val()==null?
								$("[id='form.classtime']").prop("checked", true):$("[id='form.classtime']").prop("checked", false);
						$("[id='form.csArriveinform']").val()==1?
								$("[id='form.csArriveinform']").prop("checked", true):$("[id='form.csArriveinform']").prop("checked", false);
									
					} 
				});

			},
			
			fnLoadTime : function(ostartDate,oendDate) {
				$('#reservation').daterangepicker(
					       {
					    	  startDate: ostartDate,
						      endDate: oendDate,
					          dateLimit: { days: 60 },
					          showDropdowns: true,
					          showWeekNumbers: true,
					          timePicker: false,
					          timePickerIncrement: 1,
					          timePicker12Hour: true,
					          ranges: {
					             '今天': [moment(), moment()],
					             '昨天': [moment().subtract('days', 1), moment().subtract('days', 1)],
					             '上周': [moment().subtract('days', 6), moment()],
					             '上个月': [moment().subtract('days', 29), moment()],
					             '本月': [moment().startOf('month'), moment().endOf('month')],
					             '下个月': [moment().subtract('month', -1).startOf('month'), moment().subtract('month', -1).endOf('month')]
					          },
					          opens: 'left',
					          buttonClasses: ['btn btn-default'],
					          applyClass: 'btn-small btn-primary',
					          cancelClass: 'btn-small',
					          format: 'YYYY-MM-DD',
					          separator: ' 到 ',
					          locale: {
					              applyLabel: 'Submit',
					              fromLabel: 'From',
					              toLabel: 'To',
					              customRangeLabel: 'Custom Range',
					              daysOfWeek: ['日', '一', '二', '三', '四', '五','六'],
					              monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
					              firstDay: 1
					          }
					       },
					       function(start, end) {
					        console.log("Callback has been called!");
					        $('#reservation span').html(start.format('D MMMM YYYY') + ' - ' + end.format('D MMMM YYYY'));
					        startDate = start;
					        endDate = end; 
//					        alert(start.format('YYYY-MM-DD')+end.format('YYYY-MM-DD'));
					        $("[id='form.csOpendatestart']").val(start.format('YYYY-MM-DD'));
					        $("[id='form.csOpendateend']").val(end.format('YYYY-MM-DD'));
					       }
					    );
			},
			
			fnLoadTeacher : function() {
				url = ctx + '/te_Show.ac';

				$.post(url, {

				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
//								var htmlInit = '<option value=""></option>';
//								$("[id='form.teacher.teId']").append(htmlInit);
//								alert("---");
								for ( var i = 0; i < data.datas.length; i++) {
									html = '<option value="'
											+ data.datas[i].teId + '">'
											+ data.datas[i].teName
											+ '</option>';
									htmltea+=html;
									$("[id='form.teacher.teId']").append(html);
								}
								/*$.page.formLoad();*/
							}
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
									$("[id='form.classroom.crName']").append(html);
								}
								/*$.page.formLoad();*/
							}
						});
			},
		
			addTeacher :function() {
//				alert(k);
				
//				alert(htmltea);
				var html1 = '<select name="form.teaList['+k+'].teId "'
					+ 'id="form.teacher.teId'+k+' "'+'class="form-control">'
					+htmltea+ '</select>';
				$("[id='form.teaSelect']").append(html1);
//				$.page.config.fnLoadTeacher();
//				alert(html1);
				k++;
			},
});
$("[id='form.coId']").change(function() {
//	alert($("[id='form.course.coId']").val().length);
	if($("[id='form.coId']").val()==0){
		$("[id='form.coClassify']").empty();
		return;
	}
	var selected = $(this).find("option:selected").val();
	alert(selected);
	$.page.config.fnLoadClassify(selected);
});

$("[id='form.csOpendatestatus']").on('click',function(e){
	if($("[id='form.csOpendatestatus']").is(':checked')) {
		$("[id='reservation']").val('');
		$("[id='reservation']").attr("disabled",true);
		$("[id='form.csOpendatestatus']").val('1');
	}
	else{
		$("[id='reservation']").attr("disabled",false);
		$("[id='form.csOpendatestatus']").val('0');
	}
//	alert($("[id='reservation']").val());
//	alert($("[id='form.csOpenSateStatus']").val());
});
$("[id='form.csArriveinform']").on('click',function(e){
	if($("[id='form.csArriveinform']").is(':checked')) {
		$("[id='form.csArriveinform']").val('1');
	}
	else{
		$("[id='form.csArriveinform']").val('0');
	}
//	alert($("[id='form.csArriveInform']").val());
});

$("[id='form.classtime']").on('click',function(e){
	if($("[id='form.classtime']").is(':checked')) {
		$("[id='form.csWeekend']").val('');
		$("[id='form.csDateStartHour']").val('');
		$("[id='form.csDateStartMinute']").val('');
		$("[id='form.csDateEndHour']").val('');
		$("[id='form.csDateEndMinute']").val('');
		
		$("[id='form.csWeekend']").attr("disabled",true);
		$("[id='form.csDateStartHour']").attr("disabled",true);
		$("[id='form.csDateStartMinute']").attr("disabled",true);
		$("[id='form.csDateEndHour']").attr("disabled",true);
		$("[id='form.csDateEndMinute']").attr("disabled",true);
	}
	else{
		$("[id='form.csWeekend']").attr("disabled",false);
		$("[id='form.csDateStartHour']").attr("disabled",false);
		$("[id='form.csDateStartMinute']").attr("disabled",false);
		$("[id='form.csDateEndHour']").attr("disabled",false);
		$("[id='form.csDateEndMinute']").attr("disabled",false);
	}
});
$("[id='form.cpId'] option").each(function(){
    if($(this).val()=='${form.cpId}'){
        $(this).attr('selected',true);
    }
});

$(document).ready(function() {
	$.page.formLoad();
	$.page.config.fnLoadCampus();
	$.page.config.fnLoadCourse();
	$.page.config.fnLoadGroup();
	$.page.config.getGradlassinfo();
	$.page.config.fnLoadTeacher();
	$.page.config.fnLoadClassroom();
	
//	$.page.config.fnLoadClassifys();
//	$.page.config.fnLoadTime();
	
});
