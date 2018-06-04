/*
分页插件
 */
(function($) {
	$.fn.pager = function(options) {
		var pluginName = 'pager';
		var defaults = {
			currentPageNo : 1,
			totalRecordCount : 0,
			pageSize : 20,
			showPageNoCount : 5,
			isShowRecordCount : true,
			isShowGoto : true,
			pageFunction : null
		};

		function Pager(element, options) {
			this.opts = $.extend({}, defaults, options);
			this.element = element;
			this.totalPageAmount = Math.ceil(this.opts.totalRecordCount
					/ this.opts.pageSize);
			this.create();
		}

		Pager.prototype = {
			constructor : Pager,

			create : function() {
				var html = "<p class=\"pager\">" + this.handle() + "</p>";
				// console.log(html);
				$(this.element).html(html);
				this.bind();
			},

			bind : function() {
				var fun = this.opts.pageFunction;
				$(this.element).find("a:not([class='page-cur'])").click(
						function() {
							// console.log(this.opts.pageFunction);
							fun($(this).text());
						});

				$(this.element).find("input#pageGoto").keyup(function(e) {
					$(this).val(parseInt($(this).val()));
					if ($(this).val() == 'NaN') {
						$(this).val(1);
					}else if($(this).val() < 1){
						$(this).val(-$(this).val());
						return;
					}else if($(this).val() > this.totalPageAmount){
						$(this).val(this.totalPageAmount);
						return;
					}
					if (e.keyCode == 13) {
						fun($(this).val());
					}
				});
			},

			handle : function() {
				var html = "";
				var num = Math.ceil((this.opts.showPageNoCount - 1) / 2);
				if (this.totalPageAmount <= this.opts.showPageNoCount + num) {// 总页数少于等于要显示的页码数时，全显示
					for (var i = 1; i <= this.totalPageAmount; i++) {
						if (i == this.opts.currentPageNo) {
							html += "<a href=\"javascript:;\" class=\"page-cur\">"
									+ i + "</a>";
						} else {
							html += "<a href=\"javascript:;\">" + i + "</a>";
						}
					}
				} else {// 总页数大于要显示的页码数时					
					var pageHeadHtml = "<a href=\"javascript:;\">1</a><i>...</i>";
					var pageTailHtml = "<i>...</i><a href=\"javascript:;\">"
							+ this.totalPageAmount + "</a>";

					if (this.opts.currentPageNo - num <= 2) {
						// console.log(1);
						for (var i = 1; i <= this.opts.showPageNoCount + 1; i++) {
							if (i == this.opts.currentPageNo) {
								html += "<a href=\"javascript:;\" class=\"page-cur\">"
										+ i + "</a>";
							} else {
								html += "<a href=\"javascript:;\">" + i
										+ "</a>";
							}
						}
						html += pageTailHtml;
					} else if (parseInt(this.opts.currentPageNo)
							+ parseInt(num) >= this.totalPageAmount) {
						html += pageHeadHtml;

						for (var i = this.totalPageAmount
								- this.opts.showPageNoCount; i <= this.totalPageAmount; i++) {
							if (i == this.opts.currentPageNo) {
								html += "<a href=\"javascript:;\" class=\"page-cur\">"
										+ i + "</a>";
							} else {
								html += "<a href=\"javascript:;\">" + i
										+ "</a>";
							}
						}

					} else {
						html += pageHeadHtml;
						for (var i = this.opts.currentPageNo - 2; i <= parseInt(this.opts.currentPageNo) + 2; i++) {
							if (i == this.opts.currentPageNo) {
								html += "<a href=\"javascript:;\" class=\"page-cur\">"
										+ i + "</a>";
							} else {
								html += "<a href=\"javascript:;\">" + i
										+ "</a>";
							}
						}
						html += pageTailHtml;
					}

				}

				if (this.opts.isShowRecordCount) { // 显示多少条记录
					html += "<span>共<b>" + this.opts.totalRecordCount
							+ "</b>条记录</span>";
				}
				if (this.opts.isShowGoto) { // 显示GOTO跳转页功能
					html += "<input type=\"text\" id=\"pageGoto\" placeholder=\"转到\"> 页";
				}
				return html;
			}
		};

		return this.each(function() {
			new Pager(this, options);
		});

	}
})(jQuery);
