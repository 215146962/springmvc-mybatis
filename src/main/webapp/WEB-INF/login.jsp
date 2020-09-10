<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="static/css/styles.css">
<script src="static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
     function login(){
    	 var username=document.getElementById("username").value;
    	 var password=document.getElementById("password").value; 
		 
		 //创建一个formData对象
		 var formData = new FormData();
		 formData.append("username",username);
		 formData.append("password",password);
    	 $.ajax({ 
    			type:"POST", //请求方式
    			url:"http://localhost:8080/springmvc-mybatis/login", //请求路径
    			cache: false,   
				processData: false,// ⑧告诉jQuery不要去处理发送的数据
				//contentType: false, // ⑨告诉jQuery不要去设置Content-Type请求头
    			data:{
    				username:document.getElementById("username").value,
    				password:document.getElementById("password").value
    			},  //传参
    			dataType: 'json',   //返回值类型
    	        success:function(msg){	    
					if(msg.status==200){
						alert(msg.data);
						window.location.href="http://localhost:8080/springmvc-mybatis/index";
					}else if(msg.status==500){
						alert(msg.msg);
					}
    	           },
    	 		error:function(){
    	 			alert("error");
    	 		}
    			});
      }
	 
	 
</script>

</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			
			<form class="form" method="post">
				<input type="text" id="username" name="username" placeholder="Username" required="required">
				<input type="password" id="password" name="password" placeholder="Password" required="required">
				<button type="button" id="login-button" onclick="login()" >Login</button>
			</form>
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>


<script>
/* $('#login-button').click(function (event) {
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
}); */
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
<h1>数据管理系统</h1>
</div>
</body>
</html>