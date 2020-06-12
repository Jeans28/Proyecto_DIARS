package com.jcalzado.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcalzado.demo.model.Producto;
import com.jcalzado.demo.model.Usuario;
import com.jcalzado.demo.service.ProductoService;
import com.jcalzado.demo.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioservice;

	@Autowired
	@Qualifier("productoservice")
	private ProductoService productoService;
	
	
	
	
}
