finish =function(url,rtnUrl) {
	url=ctx + "/cou_Save.ac";
	var formData = $(".content form").serializeArray();
	$.post(url, formData, function(data, textStatus, jqXHR) {
		if (data.success) {
			alert("数据插入成功");
		} else {
			alert('保存失败！' + data.msg);
		}
	});
	
};

$(document).ready(function() {
	
	});	


