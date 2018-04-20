<%--
  Created by IntelliJ IDEA.
  User: grtab
  Date: 2/15/2018
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Save Product</title>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <h5>Details:</h5>
    Product Name: ${product.name}<br/>
    Description: ${product.description}<br/>
    <p>Following files are uploaded successfully.</p>
    <ol>
        <c:forEach items="${product.images}" var="image">
            <li>${image.originalFilename}
                <img width="100" src="<c:url value="/image/"/>${image.originalFilename}"/>
            </li>
        </c:forEach>
    </ol>
</div>
</body>
</html>
