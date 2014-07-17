<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/foundation.css" />
	<title>..::Sistema de Servicios de Restaurantes::..</title>
</head>
<body>
	<form action="Menu">
		<table>
			<c:forEach var = "i" items = "${requestScope.listamenu}" >
				<tr><td><c:out value="${i.nombre}"></c:out></td><td><button>Agregar</button></td></tr>
			</c:forEach>
		</table>
	</form>
	<c:if test="${requestScope.error != null}">
		<c:out value="${requestScope.error}"></c:out>
	</c:if>

</body>
</html>