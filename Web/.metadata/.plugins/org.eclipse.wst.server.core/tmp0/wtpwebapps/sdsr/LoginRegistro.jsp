<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
<title></title>
<meta charset="utf-8" />
<style type="text/css">
body {
	Background: transparent;
}
</style>
<%@ include file="Carga.jsp" %>
</head>
<body id="page5">
<div class="body6">
	<div class="body1">
		<div class="main">
<!-- content -->
			<article id="content">
				<div class="wrap">
					<div class="box">
					<form id="ContactForm">
						<section class="loginform cf">
							<form name="login" action="index_submit" method="get" accept-charset="utf-8">
								<ul>
								   <h1> Iniciar Sesion </h1>
									<li>
										<label for="usermail"><br>Email</label>
										<input type="text" name="usuario" placeholder="yourname@email.com" required>
									</li>
									<li>
										<label for="password">Password</label>
										<input type="password" name="contrasenia" placeholder="password" required></li>
									<li>
										<input type="submit" value="Login">
									</li>
								</ul>
								</form>
						</section>
					</form>
					<div>
						<form id="ContactForm">
						<section class="loginform cf">
						   <form name="login" action="index_submit" method="get" accept-charset="utf-8">
							<ul>
							    <h1>Registrate</h1>
								<li>
									<label for="usermail"><br>Email</label>
									<input type="Text" name="usermail"  required>
								</li>
								<li>
									<label for="password">Contraseņa</label>
									<input type="Text" name="password"  required>
								</li>
								<li>
									<label for="password">Confirmar Contraseņa</label>
									<input type="Text" name="password"  required>
								</li>
								<li>
									<label for="Nombre">Nombre</label>
									<input type="Text" name="Nombre"  required>
								</li>
								<li>
									<label for="Apellido">Apellidos</label>
									<input type="Text" name="Apellido"  required>
								</li>
								<li>
									<label for="Number">DNI</label>
									<input type="Text" name="Number"  required>
								</li>
								<li>
									<label for="Direccion">Direccion</label>
									<input type="Text" name="Direccion"  required>
								</li>
								<li>
									<label for="Number">Telefono</label>
									<input type="Text" name="Number"  required>
								</li>
								<li>
									<input type="submit" value="Registrar">
								</li>
							</ul>
						</form>
					</section>
							</form>
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