<%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 02.01.20
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Person Page</title>
</head>
<body>
    <p><h3>Person First Name: ${personFirstName}</h3></p>
    <p><h3>Person Last Name: ${personLastName}</h3></p>
    <p><h3>Person Login: ${personLogin}</h3></p>
    <p><h3>Number of Visit: ${personNumOfVisit}</h3></p>

    <form action="logout" method="get">
        <input type="submit" value="logout">
    </form>
</body>
</html>
