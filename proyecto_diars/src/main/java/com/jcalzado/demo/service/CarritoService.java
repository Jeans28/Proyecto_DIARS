package com.jcalzado.demo.service;

import java.util.List;
import java.util.Optional;

import com.jcalzado.demo.model.Carrito;

public interface CarritoService {
	
	public abstract int save(Carrito p);
	public abstract List<Carrito>listarCesta();
	public abstract void deleteCesta(int id);
	public Optional<Carrito>listarId(int id);
	
	//listar por nombre
	public abstract List<Carrito> Buscarnombre(String nombre);
}
