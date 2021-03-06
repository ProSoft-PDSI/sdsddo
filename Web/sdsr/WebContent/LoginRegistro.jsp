<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
<title></title>
<meta charset="utf-8" />
<%@ include file="Carga.jsp" %>
<style type="text/css">
body {
	Background: transparent;
}
</style>
</head>
<body id="page5">
<div class="body6" id="marco">
	<div class="body1" id="marco">
		<div class="main">
<!-- content -->

			<article id="content">
				<div class="wrap">
					<div class="box">
						<section class="loginform cf">
							<form action="LoginIngreso" method="post" accept-charset="utf-8">
								<ul>
								   <h1>Iniciar Sesion </h1>
									<li>
										<label for="usuario"><br>Usuario</label>
										<input type="text" name="usuario" required>
									</li>
									<li>
										<label for="contrasenia">Contrasenia</label>
										<input type="password" name="contrasenia" required></li>
									<li>
										<input type="submit" value="Login">
									</li>
								
								<c:if test="${requestScope.error != null}">
										<li>${requestScope.error}</li>
								</c:if>
								<c:if test="${requestScope.mensaje != null}">
										<li><span id="enlace"><a href="index.jsp" target="_top">${requestScope.mensaje}</a></span></li>
								</c:if>
								</ul>
							</form>
						</section>
					<div class="posicion">
						<section class="loginform cf">
						   <form action="Registro" method="post" accept-charset="utf-8">
							<ul>
							    <h1>Registrate</h1><br>
								<li>
									<label for="nombre">Nombre</label>
									<input type="text" name="nombre"  required>
								</li>
								<li>
									<label for="apellido">Apellidos</label>
									<input type="text" name="apellido"  required>
								</li>
								<li>
									<label for="dni">DNI</label>
									<input type="text" name="dni"  required>
								</li>
								<li>
									<label for="fecnac">Fecha Nacimiento</label>
									<input type="date" name="fecnac"  required>
								</li>
								<li>
									<label for="direccion">Direccion</label>
									<input type="text" name="direccion"  required>
								</li>
								<li>
									<label for="telefono">Telefono</label>
									<input type="text" name="telefono"  required>
								</li>
								<li>
									<label for="correo">Email</label>
									<input type="email" name="correo"  required>
								</li>
								<li>
									<label for="usuario">Usuario</label>
									<input type="text" name="usuario"  required>
								</li>
								<li>
									<label for="contrasenia1">Contraseņa</label>
									<input type="password" name="contrasenia1"  required>
								</li>
								<li>
									<label for="contrasenia2">Confirmar Contraseņa</label>
									<input type="password" name="contrasenia2"  required>
								</li>
								<li>
									<input type="submit" value="Registrar">
								</li>
								<c:if test="${requestScope.mensaje1 != null}">
								<li>
								
									<c:out value="${requestScope.mensaje1}"></c:out>
								</li>
								</c:if>
								<c:if test="${requestScope.error1 != null}">
								<li>
									<c:out value="${requestScope.error1}"></c:out>
								</li>
								</c:if>
							</ul>
						</form>
					</section>
							</div>
						</div>
					</div>
			</article>
		</div>
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>