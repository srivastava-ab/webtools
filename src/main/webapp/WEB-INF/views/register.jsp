<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="email">Email*</form:label></td>
				<td><form:input path="email" name="email" id="email"
						required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password*</form:label></td>
				<td><form:password path="password" name="password"
						id="password" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName*</form:label></td>
				<td><form:input path="firstname" name="firstname"
						id="firstname" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" />
					<form:input path="imageName" type="hidden" name="image"
						value="Blank" /></td>
			</tr>



			<%-- ${enum1}</br>${enumValues} --%>

			<tr>
				<td><form:label path="username">UserName*</form:label></td>
				<td><form:input path="username" name="username" id="username"
						required="required" /></td>
			</tr>


			<tr>
				<td><form:label path="city">City*</form:label></td>
				<td><form:input path="city" name="city" id="city" required="required" />
			</tr>


			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
			</tr>



			<tr>
				<td><form:label path="userRole">User Role*</form:label></td>
				<td><form:select path="userRole" name="userrole" id="userrole"
						required="required">
						<form:option value="" label="Select" />
						<form:options items="${enum1}" />
					</form:select></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="views/home.jsp">Home</a></td>
			</tr>
			<tr>
				<td></td>
				<td style="font-style: italic; color: red;">${exception}</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
