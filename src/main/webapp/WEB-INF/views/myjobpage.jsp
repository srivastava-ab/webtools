<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />
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




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="auto">
		<div class="topnav">
			<a href="profile.htm">Profile</a> <a href="request.htm">Raise a
				Task</a> <a href="myRequest.htm">My Tasks</a><a href="invalidate">Log
				Out</a>

		</div>
		<c:choose>
			<c:when test="${myTaskList eq null}">
				<h3>No tasks created by: ${user.firstname}</h3>
			</c:when>
			<c:otherwise>
				<h3>Tasks created by: ${user.firstname }</h3>

				<table id="t01" >
					<tr>
						<th style="width: 10%">Task ID</th>
						<th>Task Details</th>
						<th>Task City</th>
						<th>Task Status</th>
						<th>Task Assigned to</th>
						<th  style="width: 15%">Task Raised on</th>
						<th style="width: 20%">Send Email</th>

					</tr>

					<c:forEach items="${myTaskList}" var="c" varStatus="status">

						<tr>
							<td> ${c.jobID}</td>

							<td>${c.jobDetails}</td>
							<td>${c.jobCity}</td>




							<td>${c.jobStatus }</td>

							<td>${c.jobProcessedBy }</td>
							<td>${c.jobRaisedDate}</td>

							<td><c:choose>
									<c:when test="${c.jobStatus eq 'COMPLETE'}">
							Task Completed
							</c:when>
									<c:when test="${c.jobStatus eq 'PENDING_APPROVAL'}">
										<a href="approveJob.htm?jobID=${c.jobID}">Approve task</a>
									</c:when>
									<c:when test="${c.jobStatus eq 'NEW'}">
							Task not assigned yet
							</c:when>
									<c:otherwise>
							Task has been assigned already
						
							</c:otherwise>
								</c:choose></td>



						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="footer.jsp" />


</body>
</html>