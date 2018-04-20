<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table, th, td {
	border: .5px solid black;
	border-collapse: collapse;
}

table#t01 th {
	background-color: red;
	color: white;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ABC::${myjobList}
	<c:choose>
		<c:when test="${myjobList eq null}">
			<h1>No job assigned to:  ${user.firstname}</h1>
		</c:when>
		<c:otherwise>
			<h1>Jobs assigned to: ${user.firstname }</h1>

			<table table id="t01" style="width: 60%" border="1">
				<tr>
					<th>Job ID</th>
					<th>Job Details</th>
					<th>Job City</th>
					<th>Job Status</th>
					<th>Job Raised on</th>

					<th>Send Email/th>
				</tr>

				<c:forEach items="${myjobList}" var="c" varStatus="status">

					<tr>
						<td><input type="text" name="myjobList[${status.index}].jobID"
							value="${c.jobID}" readonly /></td>

						<td><input type="text"
							name="myjobList[${status.index}].jobDetails"
							value="${c.jobDetails}" readonly /></td>
						<td><input type="text"
							name="myjobList[${status.index}].jobCity" value="${c.jobCity}"
							readonly /></td>

						<td><input type="text"
							name="myjobList[${status.index}].jobStatus" value="${c.jobStatus}"
							readonly /></td>
						<td><input type="text"
							name="myjobList[${status.index}].jobRaisedDate"
							value="${c.jobRaisedDate}" readonly /></td>




						<td><a href="sendEmail.htm?jobID=${c.jobID}">Task complete, send mail</a></td>



					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


</body>
</html>