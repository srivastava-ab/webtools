<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet">
<style>
td {
	border: .5px solid black;
	border-collapse: collapse;
}

table#t01 th {
	background-color: #333;
	color: white;
}
</style>


<script>
function myFunction() {
    var txt;
    alert("anbcd");
    var person = prompt("Please enter the sender gmail id:", "abc@gmail.com");
    var person = prompt("Please enter your name:", "");
    var person = prompt("Please enter your name:", "Harry Potter");

    if (person == null || person == "") {
        txt = "User cancelled the prompt.";
    } else {
        txt = "Hello " + person + "! How are you today?";
    }
    document.getElementById("demo").innerHTML = txt;
    document.getElementById("myForm").submit();
}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="auto">

		<div class="topnav">
			<a href="profile.htm">Profile</a> <a href="findJob.htm">Find a
				task</a> <a href="myJob.htm">My tasks</a><a href="invalidate">Log Out</a>
		</div>
	<c:choose>
		<c:when test="${myjobList eq null}">
			<h3>No task assigned to: ${user.firstname}</h3>
		</c:when>
		<c:otherwise>
			<h3>Tasks assigned to: ${user.firstname }</h3>

			<table border="0" cellpadding="3" cellspacing="0"  id="t01" style="width: 90%" border="1">
				<tr>
					<th>Job ID</th>
					<th>Job Details</th>
					<th>Job City</th>
					<th>Job Status</th>
					<th>Job Raised on</th>

					<th style="width: 20%">Send Email</th>
<!-- 					<th>Submit mail</th>
 -->				</tr>

				<c:forEach items="${myjobList}" var="c" varStatus="status">

					<tr>
						<td>${c.jobID}</td>

						<td>${c.jobDetails}</td>
						<td>${c.jobCity}</td>

						<td>${c.jobStatus}</td>
						<td>${c.jobRaisedDate}</td>

						<td>
						
						<c:choose>
							<c:when test="${c.jobStatus eq 'COMPLETE'}">
							Task Completed
							</c:when>
							<c:when test="${c.jobStatus eq 'ASSIGNED'}">
							<a href="sendEmailData.htm?jobID=${c.jobID}">Task
								complete, send mail</a>
							</c:when>
							<c:otherwise>
							Complete the task
						
							</c:otherwise>
						</c:choose>
						
						</td>



					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</div>


	<jsp:include page="footer.jsp" />

</body>
</html>