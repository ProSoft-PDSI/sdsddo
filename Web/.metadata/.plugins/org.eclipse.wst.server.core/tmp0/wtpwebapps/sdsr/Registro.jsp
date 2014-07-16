<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Registro</title>
</head>
<body>
	<form method="post" action="Registro">
		<label>DNI:</label>
		<input type="text" name="dni" />
		<br />
		<label>Nombre: </label>
		<input type="text" name="nombre" />
		<br />
		<label>Direccion: </label>
		<input type="text" name="direccion" />
		<br />
		<label>Email: </label>
		<input type="email" name="correo" />
		<br />
		<label>Fecha Nacimiento: </label>
		<input type="date" name="fecnac" />
		<br />
		<label>Telefono: </label>
		<input type="text" name="telefono" />		
		<br />
		<label>Usuario: </label>
		<input type="text" name="usuario">
		<br />
		<label>Contraseņa: </label>
		<input type="password" name="contrasenia">
		<br />
		<input type="submit" value="Registrarse">
		<c:if test="${requestScope.mensaje != null}">
			<c:out value="${requestScope.mensaje}"></c:out>
		</c:if>
		<c:if test="${requestScope.mensaje != null}">
			<c:out value="${requestScope.error}"></c:out>
		</c:if>
	</form>
</body>
</html>