<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<%@ include file="Carga.jsp" %>
	<title>..::Sistema de Servicios de Restaurantes::..</title>
	<style type="text/css">
   		body { Background: transparent; }
	</style>
</head>
<body id="page2">
<form method="post" action="Entrada">
<div class="body6" id="marco">
	<div class="body1" id="marco">
		<div class="main">
			
			<article id="content">
				<div class="wrap">
					<%int n = 1; %>
			     <c:forEach var = "i" items = "${requestScope.listamenu}" >
					<% if(n == 1) { %>
					<section class="cols">
						<div class="box">
							<div>
								<h2><c:out value="${i.nombre}"></c:out></h2>
								<figure><img src="${i.imagen}" alt="" ></figure>
								<p class="pad_bot1">${i.descripcion}</p>
								<a href="Entrada" class="button1">S./ ${i.precio} Pedir</a>
							</div>
						</div>
					</section>
				   <% } %>
				   <% if (n>1 && n <= 3) { %>
					<section class="cols pad_left1">
						<div class="box">
							<div>
								<h2><c:out value="${i.nombre}"></c:out></h2>
								<figure><img src="${i.imagen}" alt="" ></figure>
								<p class="pad_bot1">${i.descripcion}</p>
								<input type="hidden" name="codigo" value="${i.codProducto}"></input>
								<input type="submit" class="button1" value="S./ ${i.precio} Pedir"></input>
							</div>
						</div>
					</section>
				  <% } %>
				  <% n++; %>
				</c:forEach>
				</div>
			</article>
		</div>
	</div>
</div>
<div class="body2">
	<div class="main">
		<article id="content2">
			<div class="wrapper">
				<section class="pad_left1">
					<h2>Clasicos</h2>
					<div class="line1">
						<div class="wrapper line2">
							<div class="cols">
								<div class="wrapper pad_bot1">
								<h1>Palitos a la Toscana </h1>
									<figure ><img src="images/ent_4.jpg" alt=""></figure>
									<p class="pad_bot1">Exquisito palitos rellenos de queso <br> mozzarella, 
									  jamon y tocino</p>
									 <a href="#" class="button1">$ 12.00 Pedir</a>
								</div>
							</div>
							<div class="cols pad_left1">
								<div class="wrapper pad_bot1">
								<h1>Alitas de pollo </h1>
									<figure ><img src="images/ent_5.jpg" alt=""></figure>
									<p class="pad_bot1">Alitas de pollo marinado y horneado <br> con nuestra exclusiva receta de salsa <br> picante.</p>
									<a href="#" class="button1">$ 12.00 Pedir</a>
								</div>
							</div>
							<div class="col2 pad_left1">
								<div class="wrapper pad_bot1">
								<h1>Enrrollado de pollo</h1>
									<figure ><img src="images/ent_6.jpg" alt=""></figure>
									<p class="pad_bot1">Deliciosa masa recubierta con queso parmesano lleno de pollo y su salsa de barbacoa, horneados a la perfecci�n.</p>
									<a href="#" class="button1">$ 12.00 Pedir</a>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</article>	
	</div>
</div>
<%-- 	<form action="post" action="Entrada">
		<table>
			<c:forEach var = "i" items = "${requestScope.listamenu}" >
				<tr><td><c:out value="${i.nombre}"></c:out></td><td><button>Agregar</button></td></tr>
			</c:forEach>
		</table>
	</form>
	<c:if test="${requestScope.error != null}">
		<c:out value="${requestScope.error}"></c:out>
	</c:if> --%>
</form>
<script type="text/javascript"> Cufon.now(); </script>
</body>

</html>