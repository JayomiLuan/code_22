<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(function(){
				//给第一个按钮绑定单击事件
				$('#btn_get').click(function(){
					//JSON格式的参数
					var param = {"username":"administrator","password":"passw0rd"};
					$.get(
						'${pageContext.request.contextPath}/ajaxServlet',
						param,
						function(data){
							//打印服务器的响应数据
							alert(data);
						}
					);
				});
				
				//给第二个按钮绑定单击事件
				$('#btn_post').click(function(){
					var param = {"username":"root","password":"toor"};
					$.post(
						'${pageContext.request.contextPath}/ajaxServlet',
						param,
						function(data){
							alert(data);
						}
					);
				});
				
			});
		
		</script>
	</head>
<body>
	
	<input type="button" value="测试JQuery发送GET异步请求" id="btn_get" />
	<input type="button" value="测试JQuery发送POST异步请求" id="btn_post" />
	

</body>
</html>