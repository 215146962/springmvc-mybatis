<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="static/css/styles.css">
		<link rel="stylesheet" type="text/css" href="static/css/table.css">
		<script src="static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
		<script>
			$(function(){
				/*公共部分
				 * 导航栏
				 * footer CopyRight
				 */
				$(".headerpage").load("header.html");
				$(".footerpage").load("footer.html");
				$.get("http://localhost:8080/person/getPersons",
					function(data,status){
						//开始拼接数据
						if(data == null || data.data==null || data.data.length === 0){
							$('#data_list').html('<tr></tr>');
						}else{
							var html='';
							$.each(data.data,function(infoIndex,info){
								html+='<tr>';
								html+='<td id="name">'+info.name+'</td>';
								html+='<td id="idCard">'+info.idCard+'</td>';
								html+='<td id="phone">'+info.phone+'</td>';
								html+='<td id="address">'+info.address+'</td>';
								html+='<td><button class="updateInfo btn btn-info" value="'+info.id+'">修改信息</button><td>';
								html+='</tr>';
							});
							$('#data_list').html(html);
						}
					});
			});
		</script>
	</head>
	<body>
		<!-- 顶部导航 -->
		<div class="headerpage" style="height: 100px;"></div>
		<!--顶部导航 over-->

		<!--中部主体-->
		<table>
			<thead>
				<tr>
					<th class="col-1">姓名</th>
					<th class="col-3">身份证号</th>
					<th class="col-3">电话</th>
					<th class="col-3">地址</th>
					<th class="col-1">操作</th>
				</tr>
			</thead>
			<tbody id="data_list">
			</tbody>
		</table>
		<!--中部主体 over-->

		<!--footer-->
		<div class="footerpage"></div>
		<!--footer over-->

	</body>
	
</html>
