<%--
  Created by IntelliJ IDEA.
  User: grtab
  Date: 2/17/2018
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search </title>

    ${user.email}<br>
    ${user.firstname}<br>
    ${user.desc}<br>

    <img src="${imageDB}" height = "100" width="100"/>


    <form action="back" method="post">
        <input id="back" type="submit" tabindex="3" value="Back">
    </form>

</head>
<body>

</body>
</html>
