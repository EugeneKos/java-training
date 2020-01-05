<%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 02.01.20
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <p><h2>Welcome to registration page</h2></p>
    <form action="reg" method="post">
        <p>First Name <input type="text" name="firstName"></p>
        <p>Last Name <input type="text" name="lastName"></p>
        <p>Login <input type="text" name="login"></p>
        <p>Password <input type="password" name="password"></p>
        <p><input type="submit" value="registration"></p>
    </form>
</body>
</html>
