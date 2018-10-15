
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addItem</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div style="align-self: center">
        <form action="/add" method="post">
        <table>
            <tr>
                <td><input type="text" name="name"> </td><td>Enter name</td>
            </tr>
            <tr>
                <td><input type="text" name="about"> </td><td>Enter about</td>
            </tr>
            <tr>
                <td><input type="text" name="price"> </td><td>Enter price</td>
            </tr>
            <tr>
                <td><input type="text" name="pic"> </td><td>Enter pic url</td>
            </tr>
            <tr>
                <td><input type="text" name="category"> </td><td>Enter category</td>
            </tr>
            <tr>
                <td><input type="text" name="model"> </td><td>Enter model</td>
            </tr>
            <tr>
                <td><input type="submit" value="Add"/> </td>
            </tr>
        </table>
        </form>
</div>
</body>
</html>
