<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="profile.htm">Profile</a></td>
<a href="request.htm">Raise a request</a></td>


</body>
</html> --%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
	<jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
	<jsp:body>
        <p>Hi I'm the heart of the message</p>
        
        <a href="profile.htm">Profile</a>
		</td>
		</br>
		<a href="request.htm">Raise a request</a>
		</td>
    </jsp:body>
</t:genericpage>