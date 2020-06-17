package com.jcalzado.demo.service;

import java.util.List;
import java.util.Optional;

import com.jcalzado.demo.model.Carrito;

public interface CarritoService {
	public abstract int save(Carrito c);
	public abstract List<Carrito>listarcar();
	public abstract void deletecar(int id);
	public Optional<Carrito>listarId(int id);
}
