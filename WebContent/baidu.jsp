<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
	<style>
		#search{width:500px;}
		#showList{
			display:none;
			width:500px;
			height:200px;
			border:1px solid red;
		}
		.item{
			width:100%;
			height:30px;
			line-height:30px;/*和DIV高度保持一致，实现DIV中的内容垂直居中*/
			text-align:left;
		}
		.currentItem{
			background-color:#CCFFCC;
		}
	</style>
	<script>
		$(function(){
			//给文本输入框绑定键盘按键抬起事件
			$('#search').keyup(function(){
				//得到当前输入框的内容
				var key = this.value;
				//发送异步请求到Servlet，Servlet负责查找相关的关键字，把相关的内容发送给浏览器
				$.get(
					'${pageContext.request.contextPath}/baiduServlet',
					'keyword='+key,
					function(data){
						//alert( typeof(data) );
						//通过eval()函数把data字符串当做代码来执行，得到的是一个JSON集合对象
						var list = eval( data );
						//把显示提示信息的DIV设置为可见
						$('#showList').css('display','block');
						//遍历集合对象，显示数据
						var temp = '';
						for( var i = 0 ; i < list.length ; i++ ){
							temp += '<div onmouseover="currentItem(this);" onmouseout="loseCursor(this);" class="item">' + list[i].name + '</div>'
						}
						//设置显示提示项的大DIV的动态高度（根据提示信息的条件计算）
						$('#showList').css('height', (30*list.length)+ 'px');
						//拼接好的内容字符串设置到DIV的内容中
						$('#showList').html(temp);
					}
				);
				
			}).blur(function(){
				//当输入框失去焦点时，则隐藏提示信息的DIV
				$('#showList').css('display','none');
			});
		});
	</script>
</head>
<body>
<center>

	<input id="search" type="text" size="100" />
	<div id="showList"></div>

</center>
</body>
</html>
<script>
	//当鼠标指向当前项的时候发生的事件，把传入的DIV对象的样式变成当前样式
	function currentItem( div ){
		$(div).addClass('currentItem');
	}
	
	//把失去鼠标指针的选项设置回普通样式
	function loseCursor( div ){
		$(div).removeClass('currentItem');
	}

</script>