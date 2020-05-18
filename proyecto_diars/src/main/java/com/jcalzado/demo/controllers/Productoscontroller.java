package com.jcalzado.demo.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jcalzado.demo.model.Producto;
import com.jcalzado.demo.service.ProductoService;

@Controller
public class Productoscontroller {

	@Autowired
	@Qualifier("productoservice")
	private ProductoService productoService;
	
	@GetMapping("/lproducto")
	public String listar(Model model) {
		List<Producto>productos=productoService.listarpro();
		model.addAttribute("productos", productos);
		return "producto";
	}
	
	@GetMapping("/aproducto")
	public String agregar(Model model) {
		model.addAttribute("producto",new Producto());
		return "agregarproducto";
	}
	@PostMapping("/save")
	public String guardap(@Valid Producto p,Model model) {
		productoService.save(p);
		return "redirect:/lproducto";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Producto>producto=productoService.listarId(id);
		model.addAttribute("producto", producto);
		return "agregarproducto";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarp(Model model,@PathVariable int id) {
		 productoService.deletepro(id);
		return "redirect:/lproducto";
	}
	
	@GetMapping("/")
	public String acatalogo(Model model) {
		model.addAttribute("producto",new Producto());
		return "acatalogo";
	}
	
	@PostMapping("/")
	public String guardarca(@RequestParam(name= "file", required=false) MultipartFile foto, Producto p, RedirectAttributes flash) {
		if(!foto.isEmpty()) {
			String ruta = "C://Temp//uploads";
			
			try {
				byte[] bytes=foto.getBytes();
				Path rutaAbsoluta= Paths.get(ruta+"//"+foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				p.setFoto(foto.getOriginalFilename());
				
			} catch (Exception e) {
				
			}
			productoService.save(p);
			flash.addFlashAttribute("success", "Foto subida!!");
			
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/lcatalogo")
	public String listarcatalogo(Model model) {
		List<Producto>productos=productoService.listarpro();
		model.addAttribute("productos", productos);
		return "catalago";
	}
}
