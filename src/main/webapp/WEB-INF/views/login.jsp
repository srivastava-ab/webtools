<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="topnav">
		<a href="login" id="login">Login</a> <a href="register" id="register">Register</a>

	</div>
	<div class="auto">
		<form:form id="loginForm" modelAttribute="login" action="loginProcess"
			method="post">
			<table align="center">
				</br>
				<tr>
					<td><form:label path="email">Email: </form:label></td>
					<td><form:input path="email" name="email" id="email" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /></td>
				</tr>
				<tr></tr>

				<tr>
					<td></td>
					<td align="left"><form:button id="login" name="login">Login</form:button>
					</td>
				</tr>
				<tr></tr>

				<tr></tr>
				<tr>
					<td></td>
					<td>New User? <a href="register">Register here</a>
					</td>
				</tr>
			</table>
		</form:form>
		<table align="center">
			<tr>
				<td style="font-style: italic; color: red;">${message}</td>
			</tr>
		</table>

	</div>
		<jsp:include page="footer.jsp" />
	
</body>
</html>