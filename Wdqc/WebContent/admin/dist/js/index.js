fnLoadCampus = function() {
		url = ctx + '/extra/getSignInfo.ac';

		$.post(url, {

		}, function(data, textStatus, jqXHR) {
			if ("success" == textStatus) {
				$("#sgincount").html(data.count);
				$("#fedsum").html('￥'+data.costsum);

			}
		});
	};
	
	$(document).ready(function() {
		fnLoadCampus();
	});