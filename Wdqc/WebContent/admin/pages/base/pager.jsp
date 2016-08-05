<%@page contentType="text/html; charset=utf-8"%>
<script type="text/javascript">
	//@ sourceURL=pager.js 
	function addPager(id) {
		// pager
		var pageNo = parseInt('<s:property value="dp.pageNo" />');
		var totalPage = parseInt('<s:property value="dp.totalPage" />');
		var rowCount = parseInt('<s:property value="dp.rowCount" />');
		var pageSize = parseInt('<s:property value="dp.pageSize" />');
		var orderby = '<s:property value="param._orderby"/>';
		var desc = '<s:property value="param._desc"/>';
		desc = '1' == desc ? 'desc' : 'asc';
		var start = (pageNo - 1) * pageSize + 1;
		var end = Math.min(rowCount, start + pageSize - 1);
		var stPage = (pageNo >= 8 ? pageNo - 3 : 1);
		var edPage = (stPage + 8 > totalPage) ? totalPage + 1 : stPage + 8;
		var info = $('<div />', {
			'class' : 'dataTables_info',
			'id' : id + '_info',
			'role' : 'status',
			'aria-live' : "polite",
			'html' : '当前数据为从第 ' + start + ' 到第 ' + end + ' 条数据；总共有 ' + rowCount + ' 条记录'
		});
		var paginate = $('<div />', {
			'class' : 'dataTables_paginate paging_full_numbers',
			'id' : id + "_paginate"
		});
		var ul = $('<ul />', {
			'class' : 'pagination'
		}).appendTo(paginate);
		var first = $('<li />', {
			'class' : 'paginate_button first' + (pageNo == 1 ? ' disabled' : ''),
			'id' : id + '_first',
			'html' : '<a href="javascript:reload(\'' + id + '\',\'1\');">首页</a>'
		});
		var previous = $('<li />', {
			'class' : 'paginate_button previous' + (pageNo == 1 ? ' disabled' : ''),
			'id' : id + '_previous',
			'html' : '<a href="javascript:reload(\'' + id + '\',\'' + (pageNo - 1) + '\');">上一页</a>'
		});
		var next = $('<li />', {
			'class' : 'paginate_button next' + (pageNo == totalPage ? ' disabled' : ''),
			'id' : id + '_next',
			'html' : '<a href="javascript:reload(\'' + id + '\',\'' + (pageNo + 1) + '\');">下一页</a>'
		});
		var last = $('<li />', {
			'class' : 'paginate_button last' + (pageNo == totalPage ? ' disabled' : ''),
			'id' : id + '_last',
			'html' : '<a href="javascript:reload(\'' + id + '\',\'' + totalPage + '\');">末页</a>'
		});
		ul.append(first).append(previous);
		for ( var i = stPage; i < edPage; i++) {
			var page = $('<li />', {
				'class' : 'paginate_button' + (pageNo == i ? ' active' : ''),
				'id' : id + '_page_' + i,
				'html' : '<a href="javascript:reload(\'' + id + '\',\'' + i + '\');">' + i + '</a>'
			});
			ul.append(page);
		}
		ul.append(next).append(last);

		var s5 = $('<div />').append(info);
		var s7 = $('<div />').append(paginate);
		$('#' + id + " .foot").html('<div class="col-sm-5">' + s5.html() + '</div><div class="col-sm-7">' + s7.html() + '</div>');

		// length
		var arr = [ 1, 5, 10, 20, 50, 100, 500 ];
		var select = $('<select />', {
			'class' : 'form-control input-sm',
			'id' : id + '_length'
		});
		for ( var i = 0; i < arr.length; i++) {
			select.append('<option value="' + arr[i] + '" ' + (arr[i] == pageSize ? 'selected' : '') + '>' + arr[i] + '</option>');
		}
		var label = $('<label />', {
			'html' : '每页显示'
		}).append(select).append('<label>条记录</label>');
		var lb = $('<div />').append(label);
		$('#' + id + " .dataTables_length").html(lb.html());
		// add length change event
		$('#' + id + '_length').change(function() {
			reload(id, 1);
		});

		// sorting
		$('#' + id + " table").addClass('dataTable no-footer');
		$('#' + id + " table thead th").each(function(i) {
			if (i > 0) {
				var _o = $(this).attr('column');
				if(!_o){
					return;
				}
				$(this).addClass('sorting' + (_o == orderby ? '_' + desc : ""));
				$(this).attr('sort', (_o == orderby ? desc : ""));

				// add click sorting event
				$(this).click(function() {
					// remove other sorting class
					$('#' + id + " table thead th").each(function(j) {
						if (j > 0 && i != j) {
							$(this).removeClass('sorting_asc sorting_desc');
							$(this).addClass('sorting');
							$(this).attr('sort', '');
						}
					});
					// remove this sorting class
					$(this).removeClass('sorting');
					// add this sorting_desc or sorting_asc
					$(this).toggleClass(function() {
						if ($(this).hasClass('sorting_asc')) {
							$(this).attr('sort', 'desc');
							return 'sorting_desc';
						} else if ($(this).hasClass('sorting_desc')) {
							$(this).attr('sort', 'asc');
							return 'sorting_asc';
						} else {
							$(this).attr('sort', 'asc');
							return 'sorting_asc';
						}
					});

					// load data by ajax
					reload(id, 1);
				});
			}
		});

		// button
		$('#' + id + ' .reload').attr("href", "javascript:reload('" + id + "','1');");
		$('#' + id + ' .reset').attr("onclick", "$.page.resetForm('#" + id + " form');");

		// key down event
		$('#' + id + ' form input').keydown(function(event) {
			if (event.keyCode == 0xD) {
				reload(id, 1);
			}
		});
	}

	function reload(id, pageNo, cfg) {
		// get action
		var url = $('#' + id + ' form').attr('action');
		// get page size
		var pageSize = $('#' + id + '_length').val();
		// get params
		var params = $('#' + id + ' form').serializeArray();
		// get orderby and desc
		var orderby = null;
		var desc = null;
		$('#' + id + " table thead th").each(function(index, domEle) {
			if (index > 0) {
				orderby = $(this).attr('column');
				desc = $(this).attr('sort');
				if (desc != '') {
					return false;
				} else {
					orderby = null;
					desc = null;
				}
			}
		});
		var data = $.serializeJson(params);
		$.apply(data, cfg);
		$.apply(data, {
			dt : 'Page',
			'param._pageno' : pageNo,
			'param._pagesize' : pageSize,
			'param._orderby' : !orderby ? data['param._orderby'] : orderby,
			'param._desc' : !desc ? data['param._desc'] : (desc == 'desc' ? '1' : '')
		});
		// load page to dom
		$('#' + id).load($.page.ctx + url, data, function() {
			// add pager dom
			addPager(id);
		});
	}
</script>