<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$("#menu a").click(function(){
			$("#menu a").removeClass("active");
			$("this").addClass("active");
		});
	})

</script>
</head>
<body>
				<a href="home.jsp" id="ac_content" class="ac_content" target="frame"><h1><span>PIZZERIA</span>RAVIOLI</h1></a>
				<nav>
					<ul id="top_nav">
						<li><a href="index.html"><img src="images/icon_1.gif" alt=""></a></li>
						<li><a href="#"><img src="images/icon_2.gif" alt=""></a></li>
						<li class="end"><a href="Contacto.html"><img src="images/icon_3.gif" alt=""></a></li>
					</ul>
				</nav>
				<nav>
					<ul id="menu">
							<li><a href="home.jsp"  target="frame">Restaurant</a></li>
							<li><a href="Entrada.html" target="frame">Entrada</a></li>
							<li><a>Pizza Clasica</a></li>
							<li><a>Especiales</a></li>
							<li><a href="Contacto.html"  target="frame">Contacto</a></li>
						</ul>
				</nav>
</body>