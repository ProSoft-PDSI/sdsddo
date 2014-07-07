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
<form method="post" action="Menu"> 
	<input type="submit" value="presiona">
	<c:if test="${requestScope.menu != null}">
		<table>
			<c:forEach var = "i" items = "${requestScope.menu}" >
				<tr><td><c:out value="${i.nombre}"></c:out></td><td><button onclick="agregaracarrito("+${i.codProducto}+")">Agregar</button></td></tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${requestScope.error != null}">
		${requestScope.error}
	</c:if>
</form>
</body>
</html>