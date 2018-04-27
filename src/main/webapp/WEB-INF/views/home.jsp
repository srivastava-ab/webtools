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
	<c:choose>
		<c:when test="${user eq null}">
		
	<div class="auto">

		<div class="topnav">
			<a href="login" id="login">Login</a> <a href="register" id="register">Register</a>

		</div>
	</div>
		</c:when>
		<c:otherwise>
		<div class="auto">

<div class="topnav">
		<a href =profile.htm id="test">Check Profile</a> <a	href="invalidate">Log Out</a>

	</div>
<h4>You are already logged in as- ${user.firstname} </h4> 

</div>
		</c:otherwise>
	</c:choose>


	<jsp:include page="footer.jsp" />

</body>
</html>