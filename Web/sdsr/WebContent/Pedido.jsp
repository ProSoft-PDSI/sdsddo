<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${RequestScope.menu != null}">
		<c:forEach var="p" items="${requestScope.lista}">
			<c:out value="${p.key}"></c:out>
			<c:out value="${p.value}"></c:out> 
		</c:forEach>
	</c:if>
	
	<ul>
		<li></li>
	</ul>
</body>
</html>