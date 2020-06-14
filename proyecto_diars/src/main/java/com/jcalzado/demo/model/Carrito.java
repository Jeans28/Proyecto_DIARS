package com.jcalzado.demo.model;


public class Carrito extends Producto{
	private int item;
	private double subtotal;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + item;
		long temp;
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		if (item != other.item)
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carrito [item=" + item + ", subtotal=" + subtotal + ", hashCode()=" + hashCode() + ", getIdproducto()="
				+ getIdproducto() + ", getNombre()=" + getNombre() + ", getCantidad()=" + getCantidad()
				+ ", getPrecio()=" + getPrecio() + ", getDescripcion()=" + getDescripcion() + ", getEstado()="
				+ getEstado() + ", getFoto()=" + getFoto() + ", getCategoria()=" + getCategoria() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}


	private static final long serialVersionUID = 1L;
}
