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
<body id="page5">
<div class="body6">
	<div class="body1">
		<div class="main">
<!-- header -->
		<%@ include file="Cabecera.jsp" %>		
		<article id="content">
				<div class="wrap">
					<div class="box">
						<iframe>
						</iframe>
					</div>
				</div>
			</article>
		</div>
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
<!--  
			<c:if test="${sessionScope.user != null}">
				Bienvenido <c:out value="${sessionScope.user.usuario}"></c:out> !!!! | <a href="CerrarSesion">Cerrar Sesion</a><br />
			</c:if>
			<c:if test="${sessionScope.user == null }">
				<a href="login.jsp">Login</a>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				<a href="ListaPedido">Pedidos</a>
			</c:if>
			<a href="#"></a>
			<a href="home.jsp">Menu</a>

		<c:if test="${requestScope.error != null}">
			<c:out value="${requestScope.error}"></c:out>
		</c:if>
-->

	</body>
</html>