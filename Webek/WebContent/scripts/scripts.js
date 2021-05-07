function ajaxTest(){
	$.ajax({
		url : 'http://localhost:8080/WeBek/servletejemlo',
		data : {
			userName : 'Guest'
		},
		success : function(responseText) {
			console.log(responseText);
			$('#ajaxGetUserServletResponse').text(responseText);
		}
	});
}
function functionFormulario(){
	let nombre = $("#nombre").val();
	let correo = $("#correo").val();
	let comentario = $("#comentario").val();
	
	$.ajax({
		url : "http://localhost:8080/WeBek/servletejemlo",
	 data: {
		"nombre" :nombre,
		"correo" :correo,
		"comentario" : comentario,
		
	},
	success : function(responseText) {
		console.log(responseText);
		$('#ajaxGetUserServletResponse').text(responseText);
	}
	
	});
	
	
	
	
	
	alert("Nombre: " + nombre + "\n Correo: " + correo + "\n Comentario:" + comentario)
}