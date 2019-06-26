	//表单验证规则
	var formValid = $(".add-form").validate({
		rules: {
			"addFormName":{
				"required":true,		//必填字段
				"minlength":2
			},
			"addFormPass1":{
				"required":true		
			},
			"addFormPass2":{
				"required":true,
				"equalTo": "#password1"		//输入值必须和 #password1 相同
			},
			"addFormPhone":{
				"required":true,
				"digits":true,		//必须输入整数
				"minlength":11		//输入长度最小是 11
			},
			"addFormAdd":{
				"required":true		
			}
		},
		messages: {
			"addFormName":{
				"required":"用户名不能为空哦",
				"minlength":"用户名不能太短哦"
			},
			"addFormPass1":{
				"required":"密码不能为空哦"
			},
			"addFormPass2":{
				"required":"确认密码不能为空哦",
				"equalTo":"两次输入的密码不一致哦"
			},
			"addFormPhone":{
				"required":"手机号不能为空哦",
				"digits":"手机号格式不正确哦",
				"minlength":"手机号格式不正确哦",
			},
			"addFormAdd":{
				"required":"地址不能为空哦"
			}
		},
		errorPlacement:function(error,element) {
			error.appendTo(element.siblings(".yf-error-tip"));
		}
	});
	

	function login(){
  		$("#loginForm").validate({
  			submitHandle:function(form){
  				doLogin;
  			}
  		})
  	}	
	
	function doLogin(){
		 g_showLoading();
		 $.ajax({
			 url:"/do_login",
             type:"POST",	
             data:{
            	 
             },
             success:function(){
            	 layer.closeAll();
             },
             error:function(){
            	 layer.closeAll();
             }
		 }};
	}
	
	
	
	
	
	
	
	
