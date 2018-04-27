<%@page import="com.me.webtools.controllers.LoginController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>


<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />
</head>
<body>

	<jsp:include page="header.jsp" />


		<div class="topnav">
			<a href="editProfile.htm">Update Profile</a> <a
				href="redirectToPassword.htm">Update Password</a> <a
				href="invalidate">Log Out</a>

		</div>



		<c:choose>

			<c:when test="${profileEditable eq true}">

				<div class="test2" style= "width: 49%; overflow: hidden; float:right; padding: 1%;" >
					<form:form id="editUser" modelAttribute="editUser"
						action="editUser.htm" method="post">
						<table align="center" border="0" cellpadding="3" cellspacing="0">
							<tr>
								<td><form:label path="firstname">First Name*</form:label></td>
								<td><form:input path="firstname" name="firstname"
										id="firstname" value="${user.firstname}" required="required" /></td>
							</tr>
							<tr>
								<td><form:label path="lastname">Last tName</form:label></td>
								<td><form:input path="lastname" name="lastname"
										id="lastname" value="${user.lastname}" /></td>
							</tr>


							<tr>
								<td><form:label path="username">User Name*</form:label></td>
								<td><form:input path="username" name="username"
										id="username" required="required" value="${user.username}" /></td>
							</tr>

							<tr>
								<td><form:label path="email">Email</form:label></td>
								<td><form:input path="email" name="email" id="email"
										readonly="true" value="${user.email}" /></td>
							</tr>

							<tr>
								<td><form:label path="phone">Phone</form:label></td>
								<td><form:input path="phone" name="phone" id="phone"
										value="${user.phone}" /></td>
							</tr>


							<tr>
								<td><form:label path="userRole">Role Type*</form:label></td>
								<td><form:input path="userRole" name="userRole"
										id="userRole" value="${user.userRole}" readonly="true" /></td>
							</tr>


							<tr>
								<td><form:label path="city">City*</form:label></td>
								<td><form:input path="city" name="city" id="city"
										value="${user.city}" required="required" /></td>
							</tr>


							<tr>
								<td></td>
								<td><form:button id="register" name="register">Submit</form:button>
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td style="font-style: italic; color: red;">${exception}</td>
							</tr>
						</table>
					</form:form>
				</div>

				<div class="test"  style= "width: 40%; overflow: hidden; float:left; padding: 1%;" >
					<label for="image">Change image: </label></br> <img src="${imageDB}"
						alt="Profile pic" width="315" height="300" />
					<form:form action="saveImage" method="post"
						enctype="multipart/form-data" modelAttribute="abc">
						<div class="form-group">
							<input type="file" name="images" multiple="multiple" /> <input
								id="submit" type="submit" tabindex="5" value="Update"> <br>

						</div>
						<div></div>
					</form:form>



					<form:form action="deletePic" method="post">
						<input id="deletePic" type="submit" tabindex="3"
							value="Delete Pic">
					</form:form>
				</div>

			</c:when>
			<c:otherwise>
				<div style= "width: 49%; overflow: hidden; float:right; padding: 1%;">
				<table align="center" border="0" cellpadding="3" cellspacing="0">
					<tr>
						<td><label>First Name<label></td>
						<td><input id="firstname" value="${user.firstname}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>Last Name<label></td>
						<td><input id="lastname" value="${user.lastname}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>User Name<label></td>
						<td><input id="username" value="${user.username}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>Email<label></td>
						<td><input id="email" value="${user.email}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>Phone<label></td>
						<td><input id="phone" value="${user.phone}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>Role Type<label></td>
						<td><input id="userrole" value="${user.userRole}"
							readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>City<label></td>
						<td><input id="city" value="${user.city}" readonly="readonly" /></td>
					</tr>
				</table>
				</div>
				<div style= "width: 40%; overflow: hidden; float:left; padding: 1%;">
				<img src="${imageDB}" alt="Profile pic" width="300" height="300" " />
				</div>
			</c:otherwise>
		</c:choose>


</body>
</html>