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
	public List<Usuario> lsitarusu() {
		// TODO Auto-generated method stub
		return usuariodao.findAll();
	}
	
}
