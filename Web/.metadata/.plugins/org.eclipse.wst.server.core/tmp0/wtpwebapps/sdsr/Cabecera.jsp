<script>
	$(document).ready(function(){
		$("#menu a").click(function(){
			$("#menu li").removeClass("active");
			$("this").parent().addClass("active");
		});
	});

</script>
<a href="home.jsp" id="ac_content" class="ac_content" target="frame"><h1>
		<span>PIZZERIA</span>RAVIOLI
	</h1></a>
<nav>
	<ul id="top_nav">
		<li><a href="index.html"><img src="images/icon_1.gif" alt=""></a></li>
		<li><a href="#"><img src="images/icon_2.gif" alt=""></a></li>
		<li class="end"><a href="Contacto.html"><img
				src="images/icon_3.gif" alt=""></a></li>
	</ul>
</nav>
<nav>
	<ul id="menu">
		<li><a href="home.jsp" target="frame">Restaurant</a></li>
		<li><a href="Entrada" target="frame">Entrada</a></li>
		<li><a href="Clasica.jsp" target="frame">Pizza Clasica</a></li>
		<li><a href="Especiales.jsp" target="frame">Especiales</a></li>
		<li><a href="Contacto.html" target="frame">Contacto</a></li>
	</ul>
</nav>
