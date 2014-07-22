<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title></title>
<%@ include file="Carga.jsp" %>
</head>
<body id="page3">
<div class="body6">
	<div class="body1">
		<div class="main">
<!-- content -->
			<article id="content">
				<div class="wrap">
					<%int n = 1; %>
			     	<c:forEach var = "i" items = "${requestScope.listapizza}" >
					<% if(n == 1) { %>
					<section class="cols">
						<div class="box">
							<div>
								<h2 class="letter_spacing"><c:out value="${i.nombre}"></c:out></h2>
								<figure><img src="${i.imagen}" alt="" ></figure>
								<p class="pad_bot1">${i.descripcion}</p>
								<input type="hidden" name="codigo" value="${i.codProducto}"></input>
								<a href="Entrada" class="button1">S./ ${i.precio} Pedir</a>
							</div>
						</div>
					</section>
				   <% } %>
				   <% if (n>1 && n <= 3) { %>
					<section class="cols pad_left1">
						<div class="box">
							<div>
								<h2 class="letter_spacing"><c:out value="${i.nombre}"></c:out></h2>
								<figure><img src="${i.imagen}" alt="" ></figure>
								<p class="pad_bot1">${i.descripcion}</p>
								<input type="hidden" name="codigo" value="${i.codProducto}"></input>
								<a href="Entrada" class="button1">S./ ${i.precio} Pedir</a>
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
								<h1> Pepperoni </h1>
									<figure ><img src="images/clas_4.jpg" alt=""></figure>
									<p class="pad_bot1"> Sabor incomparable de pepperoni<br> americano y queso mozzarella.</p>
									 <a href="#" class="button1">$ 12.00 Pedir</a>
								</div>
							</div>
							<div class="cols pad_left1">
								<div class="wrapper pad_bot1">
								<h1> Napolitana </h1>
									<figure ><img src="images/clas_5.jpg" alt=""></figure>
									<p class="pad_bot1">Una clasica combinacion de tomate,<br> salsa de oregano y queso mozzarella.</p>
									<a href="#" class="button1">$ 12.00 Pedir</a>
								</div>
							</div>
							<div class="col2 pad_left1">
								<div class="wrapper pad_bot1">
								<h1>Enrrollado de pollo</h1>
									<figure ><img src="images/clas_6.jpg" alt=""></figure>
									<p class="pad_bot1">Combinacion de carne molida,<br> rodajas de jalapeño, pimiento y cebolla.</p>
									<a href="#" class="button1">$ 12.00 Pedir</a>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</article>
<!-- / content -->
	</div>
</div>

<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>