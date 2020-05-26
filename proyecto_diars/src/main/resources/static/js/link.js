$('document').ready(function(){
	$('#btnBuscar').click(function() {
		calcular();
	})
});

function calcular() {
		var nombre=$("txtnombre").val();
		var url="http://localhost:8080/inicio/nombre/"+nombre;
		$(location).attr('href', url);

}