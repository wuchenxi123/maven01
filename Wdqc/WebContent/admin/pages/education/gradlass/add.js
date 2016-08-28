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
									$("[id='form.cpId']").append(html);
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
//								var htmlInit = '<option value=""></option>';
//								$("[id='form.coId']").append(htmlInit);
								for ( var i = 0; i < data.datas.length; i++) {
									var html = '<option value="'
											+ data.datas[i].coId + '">'
											+ data.datas[i].coName
											+ '</option>';
									$("[id='form.coId']").append(html);
								}
								/**/
							}
						});
			},

			fnLoadClassify : function() {

				url = ctx + '/grp_Show.ac';
				$.post(url, {
				}, function(data, textStatus, jqXHR) {
//					var htmlInit = '<option value=""></option>';
//					$("[id='form.coClassify']").append(htmlInit);
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
					        $("[id='form.csOpendatestart']").val(startDate.format('YYYY-MM-DD'));
					        $("[id='form.csOpendateend']").val(endDate.format('YYYY-MM-DD'));
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
				var html1 = '<select name="form.teaList['+k+'].teId "'
					+ 'id="form.teacher.teId'+k+' "'+'class="form-control" style="margin-top: 16px"><option value=""></option>'
					+htmltea+ '</select>';
				$("[id='form.teaSelect']").append(html1);
//				$.page.config.fnLoadTeacher();
//				alert(html1);
				k++;
			},
			fnPrevent : function() {
				e.preventDefault();
			},
			fnPreventTab : function(b) {
				if (b) {
					// 阻止跳转
					$("[id='form.gradlassSave']").on('show.bs.tab', function(e) {
						e.preventDefault();
					});
				} else {
					$("[id='form.gradlassSave']").unbind();
				}
			},
			fnInitValidator : function() {
				$.page.config.fnPreventTab(true);
				$('#info form').bootstrapValidator({
					trigger : 'blur',
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						'form.csName' : {
							validators : {
								notEmpty : {
									message : '请输入班级名称'
								}
							}
						},
						'form.csCharge' : {
							validators : {
								notEmpty : {
									message : '学费标准不能为空'
								}
							}
						},
						'form.csClasshour' : {
							validators : {
								notEmpty : {
									message : '课时总计不能为空'
								}
							}
						},
						'form.csEveryclass' : {
							validators : {
								notEmpty : {
									message : '每次上课课时不能为空 '
								}
							}
						},
					}
				}).on('success.form.bv', function(e) {
					e.preventDefault();
					// 解绑事件
					$.page.config.fnPreventTab(false);
					$.page.config.fnFinish();
				});
			},
			fnSave : function() {

				$("#info form").submit();
			},
			fnFinish : function(url, rtnUrl) {
				if (!url)
					url = $.page.config.Save;
				if (!rtnUrl)
					rtnUrl = $.page.config.Return;
				var formData = $("form").serializeArray();
				$.post(url, formData, function(data, textStatus, jqXHR) {
					if (data.success) {
						alert('保存成功!');
						$.page.load(rtnUrl);
					} else {
						alert('保存失败！请再次查看已填信息' + data.msg);
					}
				});

			},
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
});
$("[id='form.csArriveInform']").on('click',function(e){
	if($("[id='form.csArriveInform']").is(':checked')) {
		$("[id='form.csArriveInform']").val('1');
	}
	else{
		$("[id='form.csArriveInform']").val('0');
	}
});
$('input[type=checkbox]').change(function(){
	var chk_value =[];
	$('input[name="csWeekend"]:checked').each(function(){
	chk_value.push($(this).val());
	});
	$("[id='form.csWeekend']").val(chk_value);
})
$("[id='form.classtime']").on('click',function(e){
	if($("[id='form.classtime']").is(':checked')) {
		
		$("[id='csWeekend']").each(function(){
			if($(this).prop("checked")){
			$(this).prop("checked",false);
			}
			}); 
		
		$("[id='form.csWeekend']").val('');
		$("[id='form.csDatestarthour']").val('');
		$("[id='form.csDatestartminute']").val('');
		$("[id='form.csDateendhour']").val('');
		$("[id='form.csDateendminute']").val('');
		
		$("[id='csWeekend']").each(function(){
			$(this).attr("disabled",true);
			}); 
		$("[id='form.csDatestarthour']").attr("disabled",true);
		$("[id='form.csDatestartminute']").attr("disabled",true);
		$("[id='form.csDateendhour']").attr("disabled",true);
		$("[id='form.csDateendminute']").attr("disabled",true);
	}
	else{
		$("[id='csWeekend']").each(function(){
			$(this).attr("disabled",false);
			}); 
		
		$("[id='form.csDatestarthour']").attr("disabled",false);
		$("[id='form.csDatestartminute']").attr("disabled",false);
		$("[id='form.csDateendhour']").attr("disabled",false);
		$("[id='form.csDateendminute']").attr("disabled",false);
	}
});


$(document).ready(function() {
	$.page.config.fnLoadCampus();
	$.page.config.fnLoadCourse();
	$.page.config.fnLoadClassify();
	$.page.config.fnLoadTeacher();
	$.page.config.fnLoadClassroom();
	$.page.config.fnLoadTime();
	$.page.formLoad();
	$.page.config.fnInitValidator();
	

});
