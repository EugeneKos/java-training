<%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 02.01.20
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authentication Page</title>
</head>
<body>
    <p><h2>Welcome to authentication page</h2></p>
    <form action="auth" method="post">
        <p>Login <input type="text" name="login"></p>
        <p>Password <input type="password" name="password"></p>
        <p><input type="submit" value="authenticate"></p>
    </form>
    <form action="reg" method="get">
        <input type="submit" value="registration">
    </form>
</body>
</html>
