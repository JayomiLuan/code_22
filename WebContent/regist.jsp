<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
    <script>
        $(function () {
            $('#username').change(function () {
                //得到用户输入的用户名
                var username = $(this).val();
                $.get(
                    '${pageContext.request.contextPath}/registServlet',
                    'username=' + username,
                    function (data) {
                        //接收服务端的异步响应，把信息显示到usernameTip标签中
//							alert( typeof( data ) );
                        if (data === 't') {
                            //用户名可用
                            $('#usernameTip').html('<font color="green">用户名可用！</font>');
                        } else {
                            //用户名不可用
                            $('#usernameTip').html('<font color="red">用户名被占用！</font>');
                        }
                    }
                );
            });
        });

    </script>
</head>
<body>
    <form action="" method="post">
        <table align="center">
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="username" id="username"/>
                    <span id="usernameTip"></span>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册"/>
                    <input type="reset"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
<script>
    function testBlur() {
        alert('输入框失去焦点');
    }

    function testChange() {
        alert('内容改变了！');
    }

</script>