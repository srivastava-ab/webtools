<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="topnav">
			<a href="profile.htm">Profile</a> <a href="request.htm">Raise a
				Task</a> <a href="myRequest.htm">My Tasks</a><a href="invalidate">Log Out</a>

		</div>

	<div>
		<h3>Create a Task</h3>

		<c:choose>

			<c:when test="${jobMessage eq true}">

		Task Successfully created!!!



			</c:when>
			<c:otherwise>

				<form:form id="jobForm" modelAttribute="job" action="jobSubmit.htm"
					method="post">
					<table align="center">
						<tr>
							<td><form:label path="jobDetails">Job Details</form:label></td>
							<td><form:input path="jobDetails" name="jobDetails"
									id="jobDetails" required="required" /></td>
						</tr>
						<tr>
							<td><form:label path="jobCity">Job City</form:label></td>
							<td><form:input path="jobCity" name="jobCity" id="jobCity"
									required="required" /></td>
						</tr>
						<tr>
							<td></td>
							<td><form:button id="registerJob" name="registerJob">Create Job</form:button>
							</td>
						</tr>
						<tr>
							<td></td>
							<td style="font-style: italic; color: red;">${exception}</td>
						</tr>
					</table>
				</form:form>


			</c:otherwise>
		</c:choose>
	</div>

	<jsp:include page="footer.jsp" />




</body>
</html>