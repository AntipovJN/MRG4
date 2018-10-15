<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 15.08.2018
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div id="login" style="align-self: center">
    <form action="/login" method="post">
    <table>
        <tr>
            <td>Login:</td>
            <td>Password:</td>
        </tr>
        <tr>
            <td><input name="login"/></td>
            <td><input type="password" name="password"/><td>
        </tr>
    </table>
    <input type="submit" value="Sing in"/>
    </form>
</div>
</body>
</html>
