var k=1;
var htmltea="";
$.page.set({
			Save : ctx + "/cs_Save.ac",
			Edit : ctx + "/cs_Edit.ac",
			Return : ctx + "/admin/pages/education/gradlass/list.jsp",
			
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
			},
//			fnLoadClassify : function(coid) {
//				url = ctx + '/cou_ShowClassify.ac';
//				$.post(url, {
//					"param._ne_coId" : coid
//				}, function(data, textStatus, jqXHR) {
//					$("[id='form.coClassify']").empty();
//					if ("success" == textStatus) {
//						for ( var i = 0; i < data.datas[0].gs.length; i++) {
//							var html = '<option value="'
//									+ data.datas[0].gs[i].groupId + '">'
//									+ data.datas[0].gs[i].groupName
//									+ '</option>';
//							$("[id='form.coClassify']").append(html);
//						}
//					}
//				});
//			},
			fnLoadTuition : function() {
				var tuition=$("[id='form.csTuition']").val();
				var html="";
				switch (tuition) {
				case 0:
					html = '<option value=0>按期</option>';
					break;
				case 1:
					html = '<option value=1>课时</option>';
					break;
				case 2:
					html = '<option value=2>按时间</option>';
					break;
				default:
					break;
				}
				$("[id='form.csTuition']").append(html);
			},
			getGradlassinfo:function(){
				alert("请编辑信息");
						$("[id='reservation']").val($("[id='form.csOpendatestart']").val()+"--"+$("[id='form.csOpendateend']").val());
						$("[id='form.csOpendatestart']").val($("[id='form.csOpendatestart']").val());
						
				        $("[id='form.csOpendateend']").val($("[id='form.csOpendateend']").val());
						$.page.config.fnLoadTime($("[id='form.csOpendatestart']").val(),$("[id='form.csOpendateend']").val());
						$("[id='form.csOpendatestart']").val()==""||null?
								$("[id='form.csOpendatestatus']").prop("checked", true):$("[id='form.csOpendatestatus']").prop("checked", false);
						var str=$("[id='form.csWeekend']").val();
						
						var arr=str.split(',');
						$.each(arr,function(i,item){
							$("input[name='csWeekend'][value="+item+"]").attr("checked","checked");
						});
						$("[id='form.csWeekend']").val(str);
						$("[id='form.csDateStartHour']").val()==null?
								$("[id='form.classtime']").prop("checked", true):$("[id='form.classtime']").prop("checked", false);
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
								$("[id='form.teacher.teId']").append('<option value=""></option>');
								for ( var i = 0; i < data.datas.length; i++) {
									html = '<option value="'
											+ data.datas[i].teId + '">'
											+ data.datas[i].teName
											+ '</option>';
									htmltea+=html;
									$("[id='form.teacher.teId']").append(html);
								}
							}
						});
			},
			addTeacher :function() {
				var html1 = '<select name="form.teaList['+k+'].teId "'
					+ 'id="form.teacher.teId'+k+' "'+'class="form-control" style="margin-top: 16px"><option value=""></option>'
					+htmltea+ '</select>';
				$("[id='form.teaSelect']").append(html1);
				k++;
			},
			
			fnLoadClassTeacher : function(pk) {				
				var Delete=ctx+'/gt_Del.ac';
				if (!pk)
					pk = $.page.config.Pk;
				if (!pk)
					pk = $.page.config.Data.Pk;
				if(pk){
					url = ctx + '/gt_Show.ac?param._ne_gradlassid='+pk;
				}
				
				$.post(url, {

				},
						function(data, textStatus, jqXHR) {
							if ("success" == textStatus) {
								var html="";
								var html2="";
								for ( var i = 0; i < data.datas.length; i++) {
									html='<div id="pan_'+data.datas[i].ctId+'"  style="float:left">'+data.datas[i].teachername+'<a class="btn btn-default btn-sm" onclick="$.page.config.del(\'' +Delete+ '?ids=' + data.datas[i].ctId + '\',\''+ data.datas[i].ctId+'\');"> <i class="fa fa-times"></i> 删除</a></div>';
									$("#teacherarea").append(html);
								};
							};
						});
			},
			
			del : function(url,id) {
				$.post(url, {

				}, function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {						
						$("div").remove("#pan_" + id);
					} else {
						alert(data.msg);
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
							}
						});
			},
		
			
			fnPrevent : function() {
				e.preventDefault();
			},
			fnPreventTab : function(b) {
				if (b) {
					// 阻止跳转
					$("[id='form.gradlassEdit']").on('show.bs.tab', function(e) {
						e.preventDefault();
					});
				} else {
					$("[id='form.gradlassEdit']").unbind();
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
			// 完成保存页面跳转
			fnFinish:function(url, rtnUrl) {
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
var str=""; 
$('input[type=checkbox]').change(function(){
	var chk_value =[];
	$('input[name="csWeekend"]:checked').each(function(){
	chk_value.push($(this).val());
//		str+=$(this).val()+","; 
	});
//	alert(chk_value);
	$("[id='form.csWeekend']").val(chk_value);
//	alert($("[id='form.csWeekend']").val());
})

$("[id='form.classtime']").on('click',function(e){
	if($("[id='form.classtime']").is(':checked')) {
		
		$("[id='csWeekend']").each(function(){
			if($(this).prop("checked")){
			$(this).prop("checked",false);
			}
			}); 
		
		$("[id='form.csWeekend']").val('');
		$("[id='form.csDateStartHour']").val('');
		$("[id='form.csDateStartMinute']").val('');
		$("[id='form.csDateEndHour']").val('');
		$("[id='form.csDateEndMinute']").val('');
		
		$("[id='csWeekend']").each(function(){
			$(this).attr("disabled",true);
			}); 
		$("[id='form.csDateStartHour']").attr("disabled",true);
		$("[id='form.csDateStartMinute']").attr("disabled",true);
		$("[id='form.csDateEndHour']").attr("disabled",true);
		$("[id='form.csDateEndMinute']").attr("disabled",true);
	}
	else{
		$("[id='csWeekend']").each(function(){
			$(this).attr("disabled",false);
			}); 
		
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
	$.page.config.fnInitValidator();
	$.page.config.fnLoadTeacher();
	$.page.config.fnLoadClassTeacher();
	$.page.config.fnLoadClassroom();
	$.page.config.fnLoadTuition();
	$.page.config.getGradlassinfo();
	
//	$.page.config.getTeaList();
//	$.page.config.fnLoadClassifys();
//	$.page.config.fnLoadTime();
	
});
