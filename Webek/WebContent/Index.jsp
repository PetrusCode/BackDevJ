<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>La Incognita</title>
</head>
<body> 

    <div class="header"> <h1> Las incognitas de la vida </h1></div>
    <div class="fWith">
       <div class="seccionContenido">
       Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit egestas pretium. Maecenas pharetra, nisl cursus accumsan venenatis, risus tortor consequat lorem, quis gravida lorem nisl ac diam. Ut ultricies urna viverra ante finibus aliquet. Vivamus in porta nisl, vitae tempor enim. Vivamus egestas at risus in porta. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Maecenas cursus velit nec neque fermentum varius. Vivamus suscipit, lectus non tempor blandit, risus turpis blandit elit, finibus mattis diam augue nec sem. Donec pharetra mauris vitae nibh ornare interdum. Pellentesque pellentesque nibh a sem porta, sed tempus diam scelerisque. Maecenas consectetur egestas massa, nec pretium nulla tristique at. Aliquam et turpis et nunc aliquam finibus.
       </div>
       <div class="seccionContenido">
       Nombre <input id="nombre" type="text"><br>
       Comentario <input id="comentario" type="text"><br>
	   <button onclick="functionFormulario()">Mostrar</button>
       </div>
       </div>
       
       <div class="fWith">
       <div class="seccionContenido">
       <img src="./imagens/java.jpg" alt="Java">
       </div>
	
	<div class="seccionContenido">
				<iframe width="auto" height="auto" src="https://www.youtube.com/embed/plRIGIZgiG4" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
		</div>
	
			<div id="ajaxGetUserServletResponse"></div>
			<button onclick="ajaxTest()"> Click Here </button>
			
			<div id="ajaxGetUserservletejemlo">
			</div>
			<button onclick ="ajaxTest()"> Click Here</button>
			
			
	<!-- Librerias visuales -->
	<link rel="stylesheet" href="./css/style.css">
	<!-- Scripts -->
	<script src="./scripts/basics.js">
	</script>
	<script src="./libs/jquery-3.3.1.min.js">
	</script>
	
	
</body>
</html>