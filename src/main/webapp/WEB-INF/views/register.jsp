<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 15.08.2018
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<form action="/register" method="post">
    <table>
        <tr>
            <td>Login:</td> <td><input name="login"/></td>
        </tr><tr>
            <td>Password:</td><td><input type="password" name="password1"/><td>
    </tr>
        <tr>
            <td>Password again:</td> <td><input type="password" name="password2"></td>
        </tr>
        <tr>
            <td>Your name:</td><td><input name="name"/></td>
        </tr>
        <tr>
            <td>Your phone:</td><td><input name="phone"/></td>
        </tr>
        <tr>
            <td>Your Email:</td><td><input name="email"/></td>
        </tr>
    </table>
    <input type="submit" value="Sing up"/>
</form>
</body>
</html>
