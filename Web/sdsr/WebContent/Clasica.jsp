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
								<a class="md-trigger button1" data-modal="modal-1" >Pedir</a>
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
								<a class="md-trigger button1" data-modal="modal-2" >Pedir</a>
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
<c:if test="${sessionScope.user!=null}">
<%int h = 1; %>
<form method="post" action="Pizza">

<c:forEach var = "i" items = "${requestScope.listapizza}" >
<div id="modal-1" class="md-modal md-effect-1" >


			<div class="md-content">
				<h3><span>${i.nombre}</span></h3>
				<div>
					<h3><figure><img src="${i.imagen}" alt="" ></figure></h3>
					
					<h5>Pide tu Pizza :</h5>
						
						<ul>
							<li>Cantidad:
								<select name="cant">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</li>
						</ul>
						<input type="hidden" name="codigo" value="${i.codProducto}"></input>
						<input type="hidden" name="precio" value="${i.precio}"></input>
						<input type="submit" class="button1 md-close" value="Agregar a carrito"></input>
					
				</div>
			</div>
<% h++; %>
</div>
</c:forEach>
	</form>
</c:if>



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

<%@ include file="footer.jsp" %>
</body>
</html>