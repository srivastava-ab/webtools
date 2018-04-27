<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table, th, td {
	border: .5px solid black;
	border-collapse: collapse;
}

table#t01 th {
	background-color: #333;
	color: white;
}
</style>
<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="auto">

		<div class="topnav">
			<a href="profile.htm">Profile</a> <a href="findJob.htm">Find a
				task</a> <a href="myJob.htm">My tasks</a><a href="invalidate">Log
				Out</a>
		</div>

		<c:choose>
			<c:when test="${msg eq null}">

				<c:choose>
					<c:when test="${jobList eq null}">
						<h3>No task found in ${jobCity}</h3>
					</c:when>
					<c:otherwise>
						<h3>Task search result for: ${jobCity }</h3>

						<table table id="t01" style="width: 90%" border="1">
							<tr>
								<th style="width: 10%">Task ID</th>
								<th>Task Details</th>
								<th>Task City</th>
								<th>Task Status</th>
								<th>Task Raised on</th>

								<th>Assign this task to me</th>
							</tr>

							<c:forEach items="${jobList}" var="c" varStatus="status">

								<tr>
									<td>${c.jobID}</td>

									<td>${c.jobDetails}</td>
									<td>${c.jobCity}</td>

									<td>${c.jobStatus}</td>
									<td>${c.jobRaisedDate}</td>




									<td><c:choose>
											<c:when test="${c.jobStatus eq 'NEW'}">
												<a href="assignJobToMe.htm?jobID=${c.jobID}">Assign</a>
											</c:when>
											<c:when test="${c.jobStatus eq 'PENDING_APPROVAL'}">
							Sent for approval
							</c:when>
											<c:when test="${c.jobStatus eq 'COMPLETE'}">
							Task completed
							</c:when>
											<c:otherwise>
							Task already assigned!!
						
							</c:otherwise>
										</c:choose></td>



								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<h3>${msg}</h3>
			</c:otherwise>
		</c:choose>




	</div>
	<br>

	<jsp:include page="footer.jsp" />


</body>
</html>