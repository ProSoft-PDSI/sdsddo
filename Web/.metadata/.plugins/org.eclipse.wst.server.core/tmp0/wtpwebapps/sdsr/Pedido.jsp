<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e</title>
</head>
<body>
		<c:if test="${sessionScope.lista!=null}">
			<c:forEach var="p" items="${sessionScope.lista}">
				<ul>
					<li><c:out value="${p.key}"></c:out><c:out value="${p.value}"></c:out> </li>
				</ul>
				
			</c:forEach>
		</c:if>
		<c:if test="${requestScope.lista == null}">
			<c:out value="no hay datos"></c:out>
		</c:if>
	
</body>
</html>