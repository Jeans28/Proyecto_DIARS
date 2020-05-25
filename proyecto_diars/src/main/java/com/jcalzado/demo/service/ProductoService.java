package com.jcalzado.demo.service;

import java.util.List;
import java.util.Optional;

import com.jcalzado.demo.model.Producto;

public interface ProductoService {

	public abstract int save(Producto p);
	public abstract List<Producto>listarpro();
	public abstract void deletepro(int id);
	public Optional<Producto>listarId(int id);
	
	//listar por nombre
	public abstract List<Producto> Buscarnombre(String nombre);

}
