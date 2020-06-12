package com.jcalzado.demo.service;

import java.util.List;

import com.jcalzado.demo.model.Usuario;

public interface UsuarioService{

	public abstract List<Usuario> listarusu();
	public abstract Usuario buscar(String correo);
	public abstract int validar(Usuario u);
	public abstract boolean va(String correo,String password);
	//public abstract List<Usuario> buscarid()
}
