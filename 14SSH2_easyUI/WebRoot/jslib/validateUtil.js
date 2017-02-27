/**
 * 扩展validatebox，添加验证两次密码一致功能
 */
$.extend($.fn.validatebox.defaults.rules, {
    eqPwd: {
        validator: function(value,param){
        	//console.log(value);
        	//console.log(param);
        	//console.log($(param[0]).val());
            return value == $(param[0]).val();
        },
        message: '两次输入密码不一致'
    }
});
