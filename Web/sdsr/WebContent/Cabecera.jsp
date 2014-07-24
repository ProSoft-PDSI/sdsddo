<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
	$(document).ready(function(){
		$("#menu a").click(function(){
			$("#menu li").removeClass("active");
			$("this").parent().addClass("active");
		});
	});

</script>
<a href="home.jsp" id="ac_content" class="ac_content" target="frame">
<h1><span>PIZZERIA</span>RAVIOLI</h1></a>
<nav>
	<c:if test="${sessionScope.user != null}">
				<span id="inicio">Bienvenido <c:out value="${sessionScope.user.usuario}"></c:out> !!!! | <a href="CerrarSesion">Cerrar Sesion</a></span><br />
	</c:if>
	<ul id="top_nav">
		<li><a href="index.jsp"><img src="images/icon_1.gif" alt=""></a></li>
		<c:if test="${sessionScope.user == null }">
			<li><a href="LoginRegistro.jsp" target="frame"><img src="images/icon_2.gif" alt="Login y Registro"></a></li>
		</c:if>
		<c:if test="${sessionScope.user != null }">
		<li><a href="ListaPedidos" target="frame"><img src="images/icon_4.gif" alt="Carrito"></a></li>
		</c:if>
	</ul>
</nav>
<nav>
	<ul id="menu">
		<li><a href="home.jsp" target="frame">Restaurant</a></li>
		<li><a href="Entrada" target="frame">Entrada</a></li>
		<li><a href="Pizza" target="frame">Pizza Clasica</a></li>
		<li><a href="Especiales" target="frame">Especiales</a></li>
	</ul>
</nav>
