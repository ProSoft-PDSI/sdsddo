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
		
			<c:if test="${sessionScope.user != null}">
				Bienvenido <c:out value="${sessionScope.user.usuario}"></c:out> !!!! | <a href="CerrarSesion">Cerrar Sesion</a><br />
			</c:if>
			<c:if test="${sessionScope.user == null }">
				<a href="login.jsp">Login</a>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				<a href="ListaPedidos">Pedidos</a>
			</c:if>
			<a href="#"></a>
			<a href="home.jsp">Menu</a>

		<c:if test="${requestScope.error != null}">
			<c:out value="${requestScope.error}"></c:out>
		</c:if>
	</body>
</html>