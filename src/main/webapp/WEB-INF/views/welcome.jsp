<%@page import="com.me.webtools.controllers.LoginController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	Profile editable::${profileEditable}







	<a href="editProfile.htm">Update Profile</a>
	</td>
	</br>
	<a href="updatePassword.htm">Update Password</a>
	</td>


	<c:choose>

		<c:when test="${profileEditable eq true}">


			<form:form id="editUser" modelAttribute="editUser" action="editUser.htm"
				method="post">
				<table align="center">
					<tr>
						<td><form:label path="firstname">First Name*</form:label></td>
						<td><form:input path="firstname" name="firstname"
								id="firstname" value="${user.firstname}" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="lastname">Last tName</form:label></td>
						<td><form:input path="lastname" name="lastname" id="lastname" value="${user.lastname}" />
						</td>
					</tr>


					<tr>
						<td><form:label path="username">User Name*</form:label></td>
						<td><form:input path="username" name="username" id="username"
								required="required" value="${user.username}"/></td>
					</tr>

					<tr>
						<td><form:label path="email">Email</form:label></td>
						<td><form:input path="email" name="email" id="email"
								readonly="true" value="${user.email}"/></td>
					</tr>

					<tr>
						<td><form:label path="phone">Phone</form:label></td>
						<td><form:input path="phone" name="phone" id="phone" value="${user.phone}" /></td>
					</tr>
					
					
					<tr>
						<td><form:label path="userRole">Role Type*</form:label></td>
						<td><form:input path="userRole" name="userRole" id="userRole"  value="${user.userRole}" readonly="true" /></td>
					</tr>
					
					
					<tr>
						<td><form:label path="city">City*</form:label></td>
						<td><form:input path="city" name="city" id="city"  value="${user.city}" required="required" /></td>
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


		</c:when>
		<c:otherwise>

			<table align="center">
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
					<td><input id="city" value="${user.city}"
						readonly="readonly" /></td>
				</tr>

				<%-- 	<tr>
			<td><label><label>Description</td>
			<td><input id="description" value="${user.description}" readonly="readonly" /></td>
		</tr> --%>




			</table>

		</c:otherwise>
	</c:choose>




	<br>
	<br>

	<form action="invalidate" method="post">
		<input id="logout" type="submit" tabindex="3" value="Logout">
	</form>

	<%-- <div class="col-md-6">
			<form :form action="saveImage" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label>Upload pic and add description</label><br> <br> <input
						type="file" method="POST" accept=".jpeg" name="images" /> <br>
					<br>

				</div>
				<div>
					<input id="submit" type="submit" tabindex="5" value="Upload Image">

				</div>
			</form>

			<form id="aboutMeform" modelAttribute="user" action="saveAboutMe"
				method="post">

				<label>About me:</label><br> <input type="text" id="desc"
					name="desc" size="10" maxlength="140" required="required"><br>
				<input id="submitAboutMe" type="submit" tabindex="6" value="Submit">
			</form>
		</div>
		<br>
		<br>
		<img src="${imageDB}" width="100" height="100" alt="Profile pic" />




		<form action="deletePic" method="post">
			<input id="deletePic" type="submit" tabindex="3" value="Delete Pic">
		</form> --%>
</body>
</html>