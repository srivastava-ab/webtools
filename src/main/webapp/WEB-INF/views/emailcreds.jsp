<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />

<script>
	function validate() {
		var num = document.myEmailForm.senderMail.value;
		if (isNaN(num)) {
			alert("Enter Numeric value for Year");
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>
	<jsp:include page="header.jsp" />


	<div class="auto">

		<div class="topnav">
			<a href="profile.htm">Profile</a> <a href="findJob.htm">Find a
				job</a> <a href="myJob.htm">My jobs</a><a href="invalidate">Log Out</a>
		</div>
		<br>
		<form id="myEmailForm" action="sendEmail.htm" method="post"
			onsubmit="return validate()">
			<input type="text" id="senderMail" name="senderMail"
				placeholder="Enter Gmail id" required /></br> </br> <input type="password"
				id="password" name="password" placeholder="password" required /> </br> </br>
			<input type="hidden" id="idJob" name="idJob" value="${jobID}" />

			<button type="submit">Send Email</button>
		</form>
<br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>