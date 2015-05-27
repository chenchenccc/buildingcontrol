// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
//				var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
				var usernameReg = /^[a-zA-z][a-zA-Z0-9_]{4,9}$/;
				var passwordReg = /^[*]{5,+}$/;
//				var validcodeReg = /.*{4}/;
				if($('#username').val() == ''){
					show_err_msg('用户名为空！');	
					$('#username').focus();
				}else if($('#password').val() == ''){
					show_err_msg('密码为空！');
					$('#password').focus();
				}else if($('#validcode').val() == ''){
					show_err_msg('验证码为空！');
					$('#password').focus();
				}else if(!usernameReg.test($('#username').val())){
					show_err_msg('用户名格式出错，用户名由5-10位的字母下划线和数字组成，只能以字母开头！');
					$('#username').focus();
				//}else if(!validcodeReg.test($('#validcode').val())){
					//show_err_msg('验证码格式出错！');
					//$('#validcode').focus();
				
				}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					$('#login_form').submit();
					show_msg('正在验证，请稍后...');	
				}
			});
		});