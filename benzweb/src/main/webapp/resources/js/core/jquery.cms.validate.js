(function($){
	var __validate = $.fn.validate;
	$.fn.cmsvalidate = function(opts) {
		var __rules = $.extend({
			userName:"required",
			passWord:"required",
			confirmPwd:{
				equalTo:"#password"
			}
		},opts?(opts.rules||{}):{});
		var __messages = $.extend({
			userName:"用户名不能为空",
			passWord:"用户密码不能为空",
			confirmPwd:"两次输入的密码不正确"
		},opts?(opts.messages||{}):{});
		var __defaultOpts = $.extend(opts||{},{
			rules:__rules,
			messages:__messages,
			errorElement: opts?(opts.errorElement||"span"):"span",
			errorClass:opts?(opts.errorClass||"errorContainer"):"errorContainer"
		});
		$.extend($.fn.validate.prototype,__defaultOpts);
		__validate.call(this,__defaultOpts);
		return this;
	}
})(jQuery)