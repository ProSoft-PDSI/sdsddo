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
								<a href="Pizza" class="button1">Pedir</a>
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
								<a href="Pizza" class="button1">Pedir</a>
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
						<% int k = 1; %>
			    			<c:forEach var = "i" items = "${requestScope.listapizzaclasico}" >
			    			<% if(k == 1) { %>
							<div class="cols">
								<div class="wrapper pad_bot1">
								<h1><c:out value="${i.nombre}"></c:out></h1>
									<figure><img src="${i.imagen}" alt="" ></figure>
									<p class="pad_bot1"> ${i.descripcion}</p>
									 <a href="#" class="button1">Pedir</a>
								</div>
							</div>
							<% } %>
							<% if (k > 1 && k <= 3) { %>
							<div class="cols pad_left1">
								<div class="wrapper pad_bot1">
								<h1><c:out value="${i.nombre}"></c:out></h1>
									<figure><img src="${i.imagen}" alt="" ></figure>
									<p class="pad_bot1"> ${i.descripcion}</p>
									 <a href="#" class="button1">Pedir</a>
								</div>
							</div>
							<% } %>
							</c:forEach>
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