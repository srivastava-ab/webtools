<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to home page</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="auto">

		<div class="topnav">
			<a href="profile.htm">Profile</a> <a href="request.htm">Raise a
				task</a> <a href="myRequest.htm">My tasks</a><a href="invalidate">Log Out</a>

		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>