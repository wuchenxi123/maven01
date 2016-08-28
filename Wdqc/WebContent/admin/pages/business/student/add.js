var k=1;
var htmltea="";
$.page.set({
			Save : ctx + "/cs_Save.ac",
			Edit : ctx + "/cs_Edit.ac",
			Return : ctx + "/admin/pages/education/gradlass/list.jsp",
			// 完成保存页面跳转
			
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
									$("[id='form.campus.cpId']").append(html);
								}
								
							}
						});
			},
			fnLoadCourse : function() {
				url = ctx + '/cou_Show.ac';

				$.post(url, {

				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								var htmlInit = '<option value=""></option>';
								$("[id='form.course.coId']").append(htmlInit);
								for ( var i = 0; i < data.datas.length; i++) {
									var html = '<option value="'
											+ data.datas[i].coId + '">'
											+ data.datas[i].coName
											+ '</option>';
									$("[id='form.course.coId']").append(html);
								}
								/**/
							}
						});
			},

			fnLoadClassify : function(coid) {

				url = ctx + '/cou_ShowClassify.ac';
				$.post(url, {
					"param._ne_coId" : coid
				}, function(data, textStatus, jqXHR) {
					$("[id='form.course.coClassify']").empty();
					if ("success" == textStatus) {
						for ( var i = 0; i < data.datas[0].gs.length; i++) {
							var html = '<option value="'
									+ data.datas[0].gs[i].groupId + '">'
									+ data.datas[0].gs[i].groupName
									+ '</option>';
							$("[id='form.course.coClassify']").append(html);
						}
						
					}
				});
			},
			fnLoadTime : function() {
				$('#reservation').daterangepicker(
					       {
					          startDate: moment().subtract('days', 29),
					          endDate: moment(),
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
								var htmlInit = '<option value=""></option>';
								$("[id='form.teacher.teId']").append(htmlInit);
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
$("[id='form.course.coId']").change(function() {
//	alert($("[id='form.course.coId']").val().length);
	if($("[id='form.course.coId']").val()==0){
		$("[id='form.course.coClassify']").empty();
		return;
	}
	var selected = $(this).find("option:selected").val();
	$.page.config.fnLoadClassify(selected);
});

$("[id='form.csOpenSateStatus']").on('click',function(e){
	if($("[id='form.csOpenSateStatus']").is(':checked')) {
		$("[id='reservation']").val('');
		$("[id='reservation']").attr("disabled",true);
		$("[id='form.csOpenSateStatus']").val('1');
	}
	else{
		$("[id='reservation']").attr("disabled",false);
		$("[id='form.csOpenSateStatus']").val('0');
	}
//	alert($("[id='reservation']").val());
//	alert($("[id='form.csOpenSateStatus']").val());
});
$("[id='form.csArriveInform']").on('click',function(e){
	if($("[id='form.csArriveInform']").is(':checked')) {
		$("[id='form.csArriveInform']").val('1');
	}
	else{
		$("[id='form.csArriveInform']").val('0');
	}
//	alert($("[id='form.csArriveInform']").val());
});

$("[id='form.classtime']").on('click',function(e){
	if($("[id='form.classtime']").is(':checked')) {
		$("[id='form.csWeekend']").val('');
		$("[id='form.csDatestarthour']").val('');
		$("[id='form.csDatestartminute']").val('');
		$("[id='form.csDateendhour']").val('');
		$("[id='form.csDateendminute']").val('');
		
		$("[id='form.csWeekend']").attr("disabled",true);
		$("[id='form.csDatestarthour']").attr("disabled",true);
		$("[id='form.csDatestartminute']").attr("disabled",true);
		$("[id='form.csDateendhour']").attr("disabled",true);
		$("[id='form.csDateendminute']").attr("disabled",true);
	}
	else{
		$("[id='form.csWeekend']").attr("disabled",false);
		$("[id='form.csDatestarthour']").attr("disabled",false);
		$("[id='form.csDatestartminute']").attr("disabled",false);
		$("[id='form.csDateendhour']").attr("disabled",false);
		$("[id='form.csDateendminute']").attr("disabled",false);
	}
});

$finish=function(url, rtnUrl) {
//	alert(Return);
	if (!url)
		url = $.page.config.Save;
	if (!rtnUrl)
		rtnUrl = $.page.config.Return;
//	alert(url);
	var formData = $("form").serializeArray();
	$.post(url, formData, function(data, textStatus, jqXHR) {
		if (data.success) {
			alert('保存成功!');
			$.page.load(rtnUrl);
		} else {
			alert('保存失败！' + data.msg);
		}
	});

},
$(document).ready(function() {
	$.page.config.fnLoadCampus();
	$.page.config.fnLoadCourse();
	$.page.config.fnLoadTeacher();
	$.page.config.fnLoadClassroom();
	$.page.config.fnLoadTime();
	$.page.formLoad();

});
