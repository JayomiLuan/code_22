<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="${pageContext.request.contextPath }/js/ajax.js"></script>
</head>
<body>

<marquee>测试当前页面有没有中断！</marquee>
<!-- 测试使用JS发送异步的GET请求 -->
<input type="button" value="ajax_get" onclick="sendGet();"/>

<!-- 测试发送POST异步请求 -->
<input type="button" value="ajax_post" onclick="sendPost();"/>

</body>
</html>
<script>
    //用于测试当前页面有没有被重新加载
    alert('当前页面加载啦！');

    //用于发送异常GET请求到服务器的函数
    function sendGet() {
        //调用/js/ajax.js中的getRequest()函数取得XMLHttpReuqest对象
        var req = getRequest();
        if (req === null) {
            alert('您的浏览器不支持AJAX！');
            return;
        }
        //发送请求:
        //设置发送异步请求的相关信息：方式，URL
        req.open('GET', '${pageContext.request.contextPath }/ajaxServlet?username=admin&password=123');
        //发送请求，null代表的是请求体
        req.send(null);

        //处理异步响应,给请求对象的onreadstatechange事件添加响应函数,服务器的响应信息直接封装在函数参数中
        req.onreadystatechange = function () {
            //判断异步请求的当前状态码，为响应结束
            if (req.readyState === 4) {
                //判断HTTP响应状态是否为成功
                if (req.status === 200) {
                    //取得响应数据的文本形式
                    alert(req.responseText);
                }
            }
        }
    }

    function sendPost() {
        var req = getRequest();
        if (req === null) {
            alert('您的浏览器不支持AJAX！');
            return false;
        }

        req.open('POST', '${pageContext.request.contextPath}/ajaxServlet');
        //以POST方式发送异步请求时，必须设置此请求头，固定写法
        req.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
        //因为发送方式为POST，所以需要指定请求体（表单数据）
        req.send('username=scott&password=tiger');

        //处理响应
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                //取得响应信息
                var t = req.responseText;
                alert(t);
            }
        }
    }
</script>