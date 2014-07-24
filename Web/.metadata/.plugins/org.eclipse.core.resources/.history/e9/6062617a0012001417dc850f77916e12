<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<%@ include file="Carga.jsp" %>
<title></title>
	<style type="text/css">
   		body { Background: transparent; }
	</style>
</head>
<body id="page4">
<div class="body6" id="marco">
	<div class="body1" id="marco">
		<div class="main">
<!-- content -->
			<article id="content">
				<div class="wrap">
					<%int n = 1; %>
			     	<c:forEach var = "i" items = "${requestScope.listaespecial}" >
					<% if(n == 1) { %>
					<section class="cols">
						<div class="box">
							<div>
								<h2 class="letter_spacing"><c:out value="${i.nombre}"></c:out></h2>
								<figure><img src="${i.imagen}" alt="" ></figure>
								<p class="pad_bot1"> ${i.descripcion}</p>
								<a class="md-trigger button1" data-modal="modal-1" >S./ ${i.precio} Pedir</a>
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
								<a class="md-trigger button1" data-modal="modal-2">S./ ${i.precio} Pedir</a>
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

<%int h = 1; %>
<form method="post" action="Especiales">
<c:forEach var = "i" items = "${requestScope.listaespecial}" >
<% if(h == 1) { %>
<div id="modal-1" class="md-modal md-effect-1" >
			<div class="md-content">
				<h3><span>${i.nombre}</span></h3>
				<div>
					<h3><figure><img src="${i.imagen}" alt="" ></figure></h3>
					<h5>Pide tu Especial :</h5>
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
						<input type="hidden" name="codigo" value="${i.precio}"></input>
						<input type="submit" class="button1 md-close" value="Agregar a carrito"></input>
		        </div>
        </div>
<% } %>
<% h++; %>        
</div>
</c:forEach>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>