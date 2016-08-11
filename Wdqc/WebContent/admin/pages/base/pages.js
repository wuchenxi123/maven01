var config = {
	page : {
		/**
		 * 所有的页面需要用的参数、成员、函数、方法都放到config中
		 */
		config : {
			/**
			 * jsp use for need return back, such as ,form submit success and
			 * return back to query list.
			 */
			Return : null,
			/**
			 * action use for delete , then click the delete button.
			 */
			Delete : null,
			/**
			 * action use for query/search ,use for datatables control.
			 */
			Search : null,

			Add : null,
			/**
			 * action use for save , then click the save button.
			 */
			Save : null,
			/**
			 * action use for edit , then click the edit/modify button.
			 */
			Edit : null,
			/**
			 * primary key column value , use for Edit action.
			 */
			Pk : null,
			/**
			 * datatables control , use for search action , for data list show.
			 */
			Grid : null,
			/**
			 * ajax param
			 */
			Data : null,
			
			Update:null
		},
		/**
		 * Context Path
		 */
		ctx : '/',
		/**
		 * session user
		 */
		user : {

		},
		/**
		 * picker data is use for "modal" or "daliog"
		 */
		modal : 'modal',
		/**
		 * the element for loay page
		 */
		el : '#content-wrapper-div',
		/**
		 * setting config
		 * 
		 * @param o
		 */
		set : function(o) {
			$.apply($.page.config, o);
		},
		/**
		 * clean config
		 */
		clear : function() {
			if (config) {
				config = {};
			}
			$.page.config = {};
			$.apply($.page.config, {});
		},
		/**
		 * delete record
		 * 
		 * @param url delete url
		 * @param g Datatables for after deleted
		 */
		del : function(url, g) {
			if (!url)
				url = $.page.config.Delete;
			if (!g)
				g = $.page.config.Grid;
			$.post(url, {

			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
					// refresh datatables
					g.draw();
				} else {
					alert(data.msg);
				}
			});
		},
		Update:function(url, g) {
			if (!url)
				url = $.page.config.Update;
			if (!g)
				g = $.page.config.Grid;
			$.post(url, {

			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
					// refresh datatables
					g.draw();
				} else {
					alert(data.msg);
				}
			});
		},
		/**
		 * save record
		 * 
		 * @param url save Url
		 * @param rtnUrl return url after saved
		 */
		save : function(url, rtnUrl) {
			if (!url)
				url = $.page.config.Save;
			if (!rtnUrl)
				rtnUrl = $.page.config.Return;
			var formData = $(".content form").serializeArray();
			$.post(url, formData, function(data, textStatus, jqXHR) {
				if (data.success) {
					$.page.load(rtnUrl);
				} else {
					alert('保存失败！' + data.msg);
				}
			});
		},

		/**
		 * load record to form
		 * 
		 * @param {} load url
		 * @param {} record's pk
		 */
		formLoad : function(url, pk) {
			if (!url)
				url = $.page.config.Edit;
			if (!pk)
				pk = $.page.config.Pk;
			if (!pk)
				pk = $.page.config.Data.Pk;
/*			if (!pk)
				pk = $.query.get('param._pk');*/
			if (pk) {
				$.post(url, {
					"param._pk" : pk
				}, function(data, textStatus, jqXHR) {
					if ("success" == textStatus) {
						$.page.setFormValues(data);
						$.page.setFormOthers();
					}
				});
			} else {
				$.page.setFormOthers();
			}
		},

		setFormOthers : function() {

		},
		/**
		 * reset form
		 * 
		 * @param el
		 */
		resetForm : function(el) {
			if (!el) {
				$("form").resetForm();
			} else {
				$(el).resetForm();
				$(el + ' input').each(function(i) {
					$(this).val('');
					$(this).removeAttr('value');
				});
			}
		},
		/**
		 * get form json data
		 * 
		 * @param el
		 */
		getFormData : function(el) {
			var formData = $(el).serializeArray();
			formData = $.serializeJson(formData);
			var j = '';
			for ( var p in formData) {
				j = j + p + " : " + formData[p] + '\n';
			}
			alert(j);
			return formData;
		},

		/**
		 * set json data to form
		 * 
		 * @param {} data json
		 */
		setFormValues : function(data) {
			for ( var attr in data) {
				$("[id='form." + attr + "']").val(data[attr]);
			}
		},
		/**
		 * hide page
		 */
		hide : function(el) {
			$(el).children().each(function(i) {
				$(this).hide();
			});
		},
		/**
		 * show page
		 */
		show : function(el) {
			$(el).children().each(function(i) {
				$(this).show();
			});
		},
		/**
		 * load js
		 * 
		 * @param url
		 */
		loadJs : function(url, el, cb) {
			// if loaded then return
			var loaded = $(el + " script").attr('src') == url || $(el + " script").length > 0;
			if (loaded) {
				// show all
				$.page.show(el);
				// if loaded then js un cache
				return;
			}
			// loading js ,user unasync and cache
			$.ajax({
				async : false,
				url : url,
				cache : true,
				dataType : "script",
				success : function() {
					// pace stop
					// Pace.stop();
					// show all
					$.page.show(el);
				},
				error : function(x, t, e) {
					alert('$.page.loadJs Error!' + e);
				}
			});
		},

		loadEl : function(url, data, el, cb) {
			// hidden all
			$.page.hide(el);
			// pace start
			// Pace.restart();
			// set Pk
			$.page.set({
				Data : data || {}
			});
			switch (typeof data) {
			case 'string':
				$.page.set({
					Pk : data || ''
				});
				break;
			case 'number':
				$.page.set({
					Pk : data || 0
				});
				break;
			}
			// double jsp and js
			var js = url.replace('.jsp', '.js');
			// after load html ,then load js , warning : js is cache
			$(el).load(url, data, function() {
				$.page.loadJs(js, el, cb);
			});
		},
		/**
		 * load page to content el
		 * 
		 * @param url
		 * @param data
		 * @param cb
		 */
		loadContent : function(url, data, cb) {
			// clear config last
			$.page.clear();
			// load to el
			$.page.loadEl(url, data, '#content-wrapper-div', cb);
		},
		/**
		 * load page to content el
		 * 
		 * @param url
		 */
		load : function(url, data, cb) {
			$.page.loadContent(url, data, cb);
		},
		/**
		 * load page to body el
		 * 
		 * @param url
		 * @param data
		 */
		loadBody : function(url, data, cb) {
			var html = '<div class="content-wrapper" id="content-wrapper-div"></div>';
			$('#body-wrapper-div').html(html);
			$('.content-wrapper').css({
				'margin-left' : '0px'
			});
			$.page.load(url, data, cb);
		},
		/**
		 * login
		 */
		login : function() {
			var savepwd = $("input[name='param._savepwd']").is(':checked');
			var autologin = $("input[name='param._autologin']").is(':checked');
			var formData = $('.login-box-body form').serializeArray();
			formData = $.serializeJson(formData);
			var pwd = formData['param._se_mbPassword'];
			if ('!#@~@#!' == pwd) {
				pwd = $.cookie('pwdMd5');
			} else {
				pwd = hex_md5(pwd);
			}
			$.apply(formData, {
				'param._se_mbPassword' : pwd,
				'param._savepwd' : savepwd,
				'param._autologin' : autologin
			});
			$.cookie('name', formData['param._se_mbName'], {
				path : '/'
			});
			$.cookie('pwd', savepwd ? '!#@~@#!' : '', {
				path : '/'
			});
			$.cookie('pwdMd5', savepwd ? pwd : '', {
				path : '/'
			});
			$.cookie('savepwd', savepwd ? 'check' : 'uncheck', {
				path : '/'
			});
			$.cookie('autologin', autologin ? 'check' : 'uncheck', {
				expires : 7,
				path : '/'
			});
			$.post(ctx + "/mobile/mb_Login.ac", formData, function(data, textStatus, jqXHR) {
				if (data.success) {
					var w = window;
					w.location.href = ctx + "/admin/index.jsp";
				} else {
					alert(data.msg);
				}
			});
		},
		/**
		 * login out
		 */
		loginout : function(flag) {
			$.post(ctx + "/mb_Logout.ac", {
				guest : 'true'
			}, function(data, textStatus, jqXHR) {
				if ("success" == textStatus) {
					var w = window;
					if ('exit' == flag) {
						w.close();
					} else {
						$.page.clearCookie();
						w.location.href = ctx + "/login.jsp";
					}
				} else {
					alert("退出失败，请直接关闭浏览器！");
				}
			});
		},
		/**
		 * change password
		 */
		changepwd : function() {
			var formData = $("form").serializeArray();
			var d = $.serializeJson(formData);
			var newPass = hex_md5(d['form.mbPassword02']);
			$.setArrayValue(formData, 'form.mbPassword', newPass);
			$.post(ctx + "/mb_ChangePwd.ac", formData, function(data, textStatus, jqXHR) {
				if (data.success) {
					alert('密码修改成功，将退出页面重新登入');
					$.page.clearCookie();
					var w = window;
					w.location.href = $.page.config.Return;
				} else {
					alert('密码修改失败！' + data.msg);
				}
			});
		},
		/**
		 * is login or not
		 * 
		 * @returns
		 */
		isLogin : function() {
			return !$.isEmpty($.page.user);
		},
		/**
		 * clear cookies
		 */
		clearCookie : function() {
			$.cookie('name', '', {
				path : "/"
			});
			$.cookie('pwd', '', {
				path : "/"
			});
			$.cookie('pwdMd5', '', {
				path : "/"
			});
			$.cookie('savepwd', '', {
				path : "/"
			});
			$.cookie('autologin', '', {
				path : "/"
			});
		},
		picker : {
			modal : function(control, definition, condition) {
				if (definition == null || definition == "") {
					alert("definition is required!");
					return;
				}
				// definition = window.encodeURIComponent(definition);
				// condition = window.encodeURIComponent(condition);
				$.page.set({
					Definition : definition,
					Condition : condition,
					Control : control
				});
				var url = $.page.ctx + "/admin/pages/business/sign/modal.jsp";
				$('#Data_Picker_Modal').modal({
					remote : url
				});
				$("#Data_Picker_Modal").on("hidden.bs.modal", function() {
					$(this).removeData("bs.modal");
				});
			},
			daliog : function(control, definition, condition) {
				if (definition == null || definition == "") {
					alert("definition is required!");
					return;
				}
				definition = window.encodeURIComponent(definition);
				condition = window.encodeURIComponent(condition);
				var url = $.page.ctx + "/admin/pages/base/picker.jsp?definition=" + definition + "&condition=" + condition;
				var rtn = window.showModalDialog(url, control, "dialogWidth=850px;dialogHeight=570px;status:no;scroll=yes;resizable=yes;");
				if (rtn == null)
					return false;

				var buttonID = control.name;
				if (buttonID == null || buttonID == "") {
					alert("Must set the name property for this selector control!");
					return false;
				}

				var code = buttonID.substring(0, buttonID.indexOf("_button"));
				var name = code + "_text";
				$("[name='" + code + "']").val(rtn[0]);
				$("[name='" + name + "']").val(rtn[1]);
			}
		}
	},
	/**
	 * add c and defaults to o
	 * 
	 * @param o
	 * @param c
	 * @param defaults
	 * @returns
	 */
	apply : function(o, c, defaults) {
		if (defaults) {
			$.apply(o, defaults);
		}
		if (o && c && typeof c == 'object') {
			for ( var p in c) {
				o[p] = c[p];
			}
		}
		return o;
	},
	/**
	 * serialize form data to Json
	 * 
	 * @param arr arr = $("form").serializeArray();
	 * @returns {___anonymous5569_5570}
	 */
	serializeJson : function(arr) {
		var json = {};
		for ( var i in arr) {
			json[arr[i].name] = arr[i].value;
		}
		return json;
	},
	/**
	 * set value to formData
	 * 
	 * @param arr arr = $("form").serializeArray();
	 * @param n
	 * @param v
	 */
	setArrayValue : function(arr, n, v) {
		for ( var i in arr) {
			if (arr[i].name == n) {
				arr[i].value = v;
			}
		}
	},
	/**
	 * is Empty
	 * 
	 * @param v
	 * @returns {Boolean}
	 */
	isEmpty : function(v) {
		switch (typeof v) {
		case 'undefined':
			return true;
		case 'string':
			if ($.trim(v).length == 0)
				return true;
			break;
		case 'boolean':
			if (!v)
				return true;
			break;
		case 'number':
			if (0 === v)
				return true;
			break;
		case 'object':
			if (null === v)
				return true;
			if (undefined !== v.length && v.length == 0)
				return true;
			for ( var k in v) {
				$.trim(k);
				return false;
			}
			return true;
			break;
		}
		return false;
	},
	/**
	 * datatables
	 */
	dt : {
		/**
		 * oLanguage
		 */
		oLanguage : {
			sLengthMenu : "每页显示 _MENU_ 条记录",
			sZeroRecords : "没有检索到数据",
			sInfo : "当前数据为从第 _START_ 到第 _END_ 条数据；总共有 _TOTAL_ 条记录",
			sInfoEmtpy : "没有数据",
			sProcessing : "正在加载数据...",
			oPaginate : {
				sFirst : "首页",
				sPrevious : "上一页",
				sNext : "下一页",
				sLast : "末页"
			}
		}
	}
};

$.extend(config || {});

// PageTable ====== start >>
(function($, window, document, undefined) {
	$.fn.PageTable = function(options) {
		var opts = $.extend({}, $.fn.PageTable.defaults, options);
		return this.each(function() {
			$(this).load(opts.url, opts.data, function() {
				addPager($(this).attr('id'));
			});
		});
	};
	$.fn.PageTable.defaults = {
		paging : true,
		ordering : true,
		info : true,
		url : null,
		data : {}
	};
})(jQuery, window, document);
// PageTable << end ======

/**
 * load page
 * 
 * @param url
 * @param pk
 */
function loadPage(url, pk) {
	$.page.load(url, pk);
};
/**
 * 数据选择器
 * 
 * @param control
 * @param definition
 * @param condition
 */
function openPicker(control, definition, condition) {
	if ($.page.modal == 'modal') {
		$.page.picker.modal(control, definition, condition);
	} else {
		$.page.picker.daliog(control, definition, condition);
	}
}
