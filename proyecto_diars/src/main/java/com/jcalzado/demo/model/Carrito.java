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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name="carrito")
public class Carrito implements Serializable{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carritoid;
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
	@NotEmpty
	private int item;
	@Column
	private String foto;
	@Column
	@NotEmpty
	private double subtotal;
	@OneToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	

	public int getCarritoid() {
		return carritoid;
	}



	public void setCarritoid(int carritoid) {
		this.carritoid = carritoid;
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



	public int getItem() {
		return item;
	}



	public void setItem(int item) {
		this.item = item;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public double getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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
		result = prime * result + carritoid;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + item;
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
		if (carritoid != other.carritoid)
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
		if (item != other.item)
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
		return "Carrito [carritoid=" + carritoid + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", item=" + item + ", foto=" + foto + ", subtotal=" + subtotal + ", producto=" + producto
				+ "]";
	}


	private static final long serialVersionUID = 1L;
}
