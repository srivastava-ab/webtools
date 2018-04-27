<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/main.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<div class="header">
<c:choose>
	<c:when test="${user eq null}">
	<h2>Welcome to WorkHouse</h2>
	</c:when>
	<c:otherwise>
	 <img width = "80" height = "70" alt="abc" src="image/${user.imageName}"/> 
	<h2 >Welcome to WorkHouse - ${user.firstname}</h2>
	</c:otherwise>
</c:choose>

 


</div>
 
</body>
</html>