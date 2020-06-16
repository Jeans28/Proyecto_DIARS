package com.jcalzado.demo.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jcalzado.demo.dao.UsuarioDao;
import com.jcalzado.demo.model.Usuario;
import com.jcalzado.demo.service.UsuarioService;

@Service("usuarioservice")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	@Qualifier("usuariodao")
	private UsuarioDao usuariodao;

	
	
	
	@Override
	public List<Usuario> listarusu() {
	
		return usuariodao.findAll();
	}
	
	@Override
	public Usuario buscar(String correo) {
		return usuariodao.findByCorreo(correo);
	}

	@Override
	public int validar(Usuario u) {
		int r=0;
		if(!u.getCorreo().equals(null) && !u.getPassword().equals(null)) {
			r=1;
		}else {
			r=0;
		}
		return r;
	}

	@Override
	public boolean va(String correo, String password) {
		
		boolean i;
		
		i=usuariodao.existsByCorreoAndPassword(correo, password);
		
		boolean res;
		if(i==true){
			res=true;
		}else {
			res=false;
		}
		return res;
	}

	@Override
	public Usuario save(Usuario u) {
		// TODO Auto-generated method stub
		return usuariodao.save(u);
	}
	
}
