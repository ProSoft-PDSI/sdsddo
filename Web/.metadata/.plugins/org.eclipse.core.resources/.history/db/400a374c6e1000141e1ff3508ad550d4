<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/foundation.css" />
	<link rel="stylesheet" href="css/estilos.css" />
	<title>..::Sistema de Servicios de Restaurantes::.. - Login</title>
</head>
<body>
	<section class="box">
		<form method="post" action="LoginIngreso">
			<label>Usuario</label>
			<br>
			<input type="text" name="usuario" class="large-12"/>
			<br>
			<br>
			<label>Contraseña</label>
			<br>
			<input type="password" name="contrasenia" class="large-12"/>
            <br>
            <br>
            <input type="submit" value="Ingresar" class="button">
            <a href="Recuperacion.jsp" id="enlaceolvidopass">¿Se ha olvidado la contraseña?</a>
		</form>
		<c:if test="${requestScope.error != null}">
			${requestScope.error}
		</c:if>
	</section>
	<footer>
	</footer>
</body>
</html>