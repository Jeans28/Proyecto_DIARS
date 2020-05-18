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