<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>..::Sistema de Servicios de Restaurantes::..</title>
<link rel="stylesheet" href="css/miEstilos.css">
<link rel="stylesheet" href="css/foundation.css" />
<script type="text/javascript" src="js/javaScript.js"></script>
<script type="text/javascript" src="js/jquery-1.10.0.min.js"></script>
</head>
<body>
	<div id="agrupar">
		<header id="cabecera">
			<h1>PAGOS</h1>
		</header>
		<nav id="menu">
			<ul>
				<li>Principal1</li>
				<li>Principal2</li>
				<li>Principal3</li>
			</ul>
		</nav>
		<section id="seccion">
			<form id="formulario" name="formulario" method="post" action="">
				<table>
					<tr>
						<td>Pedido:</td>
						<td id="td_pedido" name="td_pedido">${sessionScope.pedido}</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Total Pedido:</td>
						<td id="td_total_pedido" name="td_total_pedido">${sessionScope.total}</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Tipo Pago:</td>
						<td><select id="tipo_pago" name="tipo_pago">
								<option value="E">Efectivo</option>
								<option value="D">Debito</option>
						</select></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Monto:</td>
						<td id="td_imp_efec" name="td_imp_efec"><input type="number" id="imp_efec"
							name="imp_efec" min="0" pattern="[0-9]*[.,]?[0-9]+"></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Cambio:</td>
						<td id="td_imp_camb" td="td_imp_camb"></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="Procesar"
							class="button" id="btn_Procesar" name="btn_Procesar"></td>
					</tr>
				</table>
				<input type="hidden" id="hid_tipo_pago" name="hid_tipo_pago"> <input
					type="hidden" id="hid_usuario" name="hid_usuario" value="${sessionScope.usuario}">
					<input type="hidden" id="hid_cambio" name="hid_cambio">
			</form>

		</section>
		<aside id="columna"></aside>
		<footer id="pie"> Sistema Delivery Online &copy; 2014-2015 </footer>

	</div>
</body>
</html>