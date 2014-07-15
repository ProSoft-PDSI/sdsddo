<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/foundation.css" />
	<link rel="stylesheet" href="css/estilos.css" />
	<title></title>
</head>
<body>
	<form method="post" action="Recuperacion" >
		<label>Correo</label>
		<input type = "email" name="correo"/>
		<input type = "submit" value = "Recuperar">
	</form>
	<c:if test="${requestScope.error != null}">
			${requestScope.error}
	</c:if>
	<c:if test="${requestScope.mensaje != null}">
			${requestScope.mensaje}
	</c:if>
</body>
</html>