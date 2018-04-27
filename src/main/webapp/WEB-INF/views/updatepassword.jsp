<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />

		<div class="topnav">
			<a href="editProfile.htm">Update Profile</a> <a
				href="redirectToPassword.htm">Update Password</a> <a href="invalidate">Log Out</a>

		</div>


<c:choose>
	<c:when test="${updated eq null}">
	<form:form id="confirmPassword" action="updatePassword.htm"
		method="post" >
		<div class="form-group">
			<table border="0" cellpadding="3" cellspacing="0">
				<tr>
					<td>Password:</td>
					<td><input type="password" id="txtPassword" name="txtPassword"/></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" id="txtConfirmPassword" name="txtConfirmPassword"/></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
		</div>
		<div>
			<button type="submit" class="btn btn-primary" onClick="return Validate()">Upload</button>
		</div>
	</form:form>
	
	</c:when>
	<c:otherwise>
		Password has been updated successfully!!!<br>

	</c:otherwise>
</c:choose>


		<jsp:include page="footer.jsp" />
	



	<%-- <form name="confirmPassword" action="updatePassword.htm" method='post'>

	</form> --%>
	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
</body>
</html>