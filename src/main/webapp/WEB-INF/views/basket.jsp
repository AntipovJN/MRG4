<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.include file="header.jspf"/>
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
