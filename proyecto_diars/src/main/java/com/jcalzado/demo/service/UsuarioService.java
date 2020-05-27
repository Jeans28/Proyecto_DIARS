package com.jcalzado.demo.service;

import java.util.List;
import java.util.Optional;

import com.jcalzado.demo.model.Usuario;

public interface UsuarioService{

	public abstract List<Usuario> lsitarusu();
	public abstract List<Usuario> validar(String correo,String contraseña);
}
