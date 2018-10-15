<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 11.08.2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${item.name}</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<table>
    <tr>
        <td>
            <h2 align="center">${item.name}</h2>
        </td>
    </tr>
    <tr>
        <td>
            <img src="${item.pic}" style="height: 500px"/>
        </td>
        <td>
            <div id="about">
                ${item.about}
            </div>
        </td>
    </tr>
    <tr>
        <td>article:${item.article}</td>
        <td style="text-align: right">${item.price} UAH</td>
        <td style="text-align: right; align-self: right">
           <c:choose>
            <c:when test="${empty user}"><a href="/login"><input type="submit" value="Add to basket"/></a></c:when>
            <c:when test="${not empty user}"><a href="/basket?id=${item.id}"><input type="submit" value="Add to basket"/></a></c:when>
           </c:choose>
               </td>
    </tr>
</table>
</body>
</html>
