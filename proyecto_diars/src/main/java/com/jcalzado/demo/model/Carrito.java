package com.jcalzado.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name="carrito")
public class Carrito implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carritoId;
	@Column
	@NotEmpty
	private String item;
	@Column
	@NotEmpty
	private String nombre;
	@Column
	@NotEmpty
	private String descripcion;
	@Column
	@NotNull
	@Min(1)
	private double precio;
	@Column
	@NotNull
	@Min(1)
	private int cantidad;
	@Column
	@NotEmpty
	private double subtotal;	
	@Column
	private String foto;
	
	@OneToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
/*
	public Carrito(){
		
	}

	public Carrito(int itemId, @NotEmpty String nombre, @NotEmpty String descripcion, @Min(1) double precio,
			@Min(1) int cantidad, @NotEmpty double subtotal, String foto, Producto producto) {
		super();
		this.itemId = itemId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.foto = foto;
		this.producto = producto;
	}
*/

	public int getCarritoId() {
		return carritoId;
	}

	public void setCarritoId(int carritoId) {
		this.carritoId = carritoId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + carritoId;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		if (cantidad != other.cantidad)
			return false;
		if (carritoId != other.carritoId)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Carrito [carritoId=" + carritoId + ", item=" + item + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", foto="
				+ foto + ", producto=" + producto + "]";
	}



	private static final long serialVersionUID = 1L;
}
