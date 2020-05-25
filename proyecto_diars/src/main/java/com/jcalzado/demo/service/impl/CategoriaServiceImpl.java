package com.jcalzado.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jcalzado.demo.dao.Categoriadao;
import com.jcalzado.demo.model.Categoria;
import com.jcalzado.demo.service.CategoriaService;

@Service("categoriaservice")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	@Qualifier("categoriadao")
	private Categoriadao categoriadao;
	@Override
	public List<Categoria> listarcat() {
		// TODO Auto-generated method stub
		return categoriadao.findAll();
	}

}
