
function eliminar(id) {
	swal({
		  title: "¿Estas seguro de eliminar?",
		  text: "Eliminaras este producto del stock",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				   url:"/eliminar/"+id,
				   success: function(res){
					   console.log(res);
				   }
			  });
		    swal("Producto eliminado", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok) {
		    		location.href="/lproducto";
		    	}
		    });
		  } else {
		    swal("No se elimino el producto");
		  }
		});
}

$(document).on('click', '.add-to-cart', function(e){
	e.preventDefault();
	
	//$.cookie('c', '12345', { expires: 0.5 })
	var button = $(this);
	var data = {
		product_id: button.attr("data-productid"), 
		quantity: 1
	};
	console.log(data);
	
	$.ajax({
	  type: "POST",
	  url: "/carrito",
	  data: data,

	  success: function(res){
		  console.log(res);
	  }, 
	  error: function(err){
		  console.log(err);
	  }
	});
});
