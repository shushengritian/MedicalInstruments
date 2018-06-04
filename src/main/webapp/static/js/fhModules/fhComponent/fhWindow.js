// 表单弹出层
// fhWindow
layui.define(['layer', 'element', 'table', 'fhConfig'], function(exports) {
	var $ = layui.jquery;
	var layer = layui.layer;
	var element = layui.element;
	var table = layui.table;
	var fhConfig = layui.fhConfig;
	var fhWindow = {
		open: function(elm, url, opt) {
			$(document).on('click', elm, function() {

				if(fhConfig.isAjaxType == 'get') {
					//layer.closeAll('page'); //关闭所有页面层
					$.get(url, opt.data||{}, function(str) {
						var param = {
							type: 1,
							content: str,
						}
						$.extend(opt, param)
						layer.open(opt);
						//console.log('兼容静态服务器 post 不能请求');
					});
				} else {

					$.post(url,  opt.data||{}, function(str) {
						var param = {
							type: 1,
							content: str
						}
						$.extend(opt, param)
						layer.open(opt);
					});

				}

			});
		},
		openOne: function(elm, url, opt) {
			$(document).one('click', elm, function() {
				
				if(fhConfig.isAjaxType == 'get') {
					//layer.closeAll('page'); //关闭所有页面层
					$.get(url, opt.data||{}, function(str) {
						var param = {
								type: 1,
								content: str,
						}
						$.extend(opt, param)
						layer.open(opt);
						//console.log('兼容静态服务器 post 不能请求');
					});
				} else {
					
					$.post(url,  opt.data||{}, function(str) {
						var param = {
								type: 1,
								content: str
						}
						$.extend(opt, param)
						layer.open(opt);
					});
					
				}
				
			});
		},
		// 弹出列表层
		openList: function(elm, url, dataObj, callBack, opt) {

			$(document).on('click', elm, function() {
				var param = {
					type: 1,
					tableDom: 'kd-table',
					area: ['auto', 'auto'],
					btn: ['确认', '取消'],
					yes: function(index, layero) {
						//layer.msg('确认 按钮 被点击');
						var checkStatus = table.checkStatus(paramData.tableDom),
							data = checkStatus.data;
						// 回调函数
						callBack(data, index, layero);
						layer.close(index);
					},
				}
				// 合并参数
				var paramData = $.extend(param, opt, {}) // 后者覆盖前者
				//layer.closeAll('page'); //关闭所有页面层
				// 兼容静态服务器
				if(fhConfig.isAjaxType == 'get') {
					//layer.closeAll('page'); //关闭所有页面层
					$.get(url, dataObj, function(str) {
						paramData.type = 1;
						paramData.content = str;
						layer.open(paramData);
						//console.log('兼容静态服务器 post 不能请求');
					})
				} else {
					$.post(url, dataObj, function(str) {
						paramData.type = 1;
						paramData.content = str;
						layer.open(paramData);
					});
				}

			});
		}

	}

	exports('fhWindow', fhWindow);
})