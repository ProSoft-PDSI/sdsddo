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
<div class="body6">
	<div class="body1">
		<div class="main">
<!-- content -->

			<article id="content">
				<div class="wrap">
					<div class="box">
					<div >
					<form id="ContactForm">
						<section class="loginform cf">
							<form name="login" action="index_submit" method="get" accept-charset="utf-8">
								<ul>
								   <h1>Iniciar Sesion </h1>
									<li>
										<label for="usermail"><br>Email</label>
										<input type="email" name="usermail" placeholder="yourname@email.com" required>
									</li>
									<li>
										<label for="password">Password</label>
										<input type="password" name="password" placeholder="password" required></li>
									<li>
										<input type="submit" value="Login">
									</li>
								</ul>
							</form>
						</section>
					</form>
					</div>
					<div>
						<form id="ContactForm">
						<section class="loginform cf">
						   <form name="login" action="index_submit" method="get" accept-charset="utf-8">
							<ul>
							    <h1>Registrate</h1>
								<li>
									<label for="usermail"><br>Email</label>
									<input type="email" name="usermail"  required>
								</li>
								<li>
									<label for="password">Contraseņa</label>
									<input type="password" name="contrasenia1"  required>
								</li>
								<li>
									<label for="password">Confirmar Contraseņa</label>
									<input type="password" name="contrasenia2"  required>
								</li>
								<li>
									<label for="Nombre">Nombre</label>
									<input type="text" name="Nombre"  required>
								</li>
								<li>
									<label for="Apellido">Apellidos</label>
									<input type="text" name="Apellido"  required>
								</li>
								<li>
									<label for="dni">DNI</label>
									<input type="text" name="dni"  required>
								</li>
								<li>
									<label for="Direccion">Direccion</label>
									<input type="text" name="Direccion"  required>
								</li>
								<li>
									<label for="Number">Telefono</label>
									<input type="Text" name="telefono"  required>
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