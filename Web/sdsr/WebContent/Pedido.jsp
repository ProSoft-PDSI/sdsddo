<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%@ include file="Carga.jsp" %>
	<style type="text/css">
   		body { Background: transparent; }
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
						<form method="post" action="InsertarPedido">
						<div>
							<h2 class="letter_spacing"><span>Pedidos</span></h2>
		<c:if test="${sessionScope.lista!=null}">	
				<table class="tablita">
					<c:forEach var="p" items="${sessionScope.lista}">
						<tr>
						<td>${p.codproducto}</td> 
						<td>${p.cant}</td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" class="button1" value="Hacer Pedido">
				
				<c:if test="${requestScope.mensaje != null}">
						${requestScope.mensaje};
				</c:if>
				
				<c:if test="${requestScope.error != null}">
						${requestScope.error};
				</c:if>
		</c:if>
		<c:if test="${sessionScope.lista == null}">
			<c:out value="no hay datos"></c:out>
		</c:if>
			</div>
			</form>
					</div>
				</div>
			</article>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
	
</body>
</html>