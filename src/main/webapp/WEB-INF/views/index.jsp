<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>MyRecovery</title>
  </head>
  <body>
<jsp:directive.include file="header.jspf"/>
<c:if test="${user.acessLevel == 'admin'}">
  <a href="/add"><input type="submit" value="add Item"></a>
</c:if>
  <c:forEach items="${items}" var="item">
    <div style="width: 500px">

      <a href ="/item?id=${item.id}">
        <table>
        <tr>
          <td>
              <h2>${item.name}</h2>
          </td>
        </tr>
        <tr>
          <td>
            <img src="${item.pic}" style="height: 200px; width: 200px"/>
          </td>
          <td>
            ${item.about}
          </td>
        </tr>
        <tr>
          <td>
            <h1>${item.price}</h1>
          </td>
        </tr>
      </table>
      </a>
    </div>
  </c:forEach>
  </body>
</html>
