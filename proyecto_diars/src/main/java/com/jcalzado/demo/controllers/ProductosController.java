package com.jcalzado.demo.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jcalzado.demo.model.Producto;
import com.jcalzado.demo.model.Usuario;
import com.jcalzado.demo.service.CategoriaService;
import com.jcalzado.demo.service.ProductoService;
import com.jcalzado.demo.service.UsuarioService;

@Controller
public class ProductosController {

	@Autowired
	@Qualifier("productoservice")
	private ProductoService productoService;

	@Autowired
	@Qualifier("categoriaservice")
	private CategoriaService categoriaservice;

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioservice;

	@GetMapping("/lproducto")
	public String listar(Model model) {
		List<Producto> productos = productoService.listarpro();
		model.addAttribute("productos", productos);
		model.addAttribute("producto", new Producto());
		return "producto";
	}

	/*
	 * @GetMapping("/aproducto") public String agregar(Model model) {
	 * model.addAttribute("producto",new Producto()); return "agregarproducto"; }
	 */
	/*
	 * @PostMapping("/save") public String guardap(@Valid Producto p,Model model) {
	 * productoService.save(p); return "redirect:/lproducto"; }
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Producto> producto = productoService.listarId(id);
		model.addAttribute("producto", producto);
		model.addAttribute("categoria", categoriaservice.listarcat());
		return "editar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarp(Model model, @PathVariable int id) {
		productoService.deletepro(id);
		return "redirect:/lproducto";
	}

	@GetMapping("/aproducto")
	public String agregarp(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("categoria", categoriaservice.listarcat());
		return "agregarproducto";
	}

	@PostMapping("/aproducto")
	public String guardarca(@RequestParam(name = "file", required = false) MultipartFile foto, @Valid Producto p,
			BindingResult result, RedirectAttributes flash) {

		if (result.hasErrors()) {
			return "agregarproducto";
		} else{
			if (!foto.isEmpty()) {
				String ruta = "D://Temp//uploads";

				try {
					byte[] bytes = foto.getBytes();
					Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
					Files.write(rutaAbsoluta, bytes);
					p.setFoto(foto.getOriginalFilename());

				} catch (Exception e) {

				}
				productoService.save(p);
				flash.addFlashAttribute("success", "Foto subida!!");
			}
		}

		return "redirect:/lproducto";
	}
	

	@PostMapping("/editars")
	public String editars(@RequestParam(name = "file", required = false) MultipartFile foto,  Producto p, RedirectAttributes flash) {

			if (!foto.isEmpty()) {
				String ruta = "D://Temp//uploads";

				try {
					byte[] bytes = foto.getBytes();
					Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
					Files.write(rutaAbsoluta, bytes);
					p.setFoto(foto.getOriginalFilename());

				} catch (Exception e) {

				}
				productoService.save(p);
				flash.addFlashAttribute("success", "Foto subida!!");
			}

		return "redirect:/lproducto";
	}

	@GetMapping("/catalogo")
	public String listarcatalogo(Model model) {
		List<Producto> productos = productoService.listarpro();
		model.addAttribute("producto", new Producto());
		model.addAttribute("productos", productos);
		return "catalago";
	}

	@GetMapping("/catalogoa")
	public String listarprueba(Model model) {
		List<Producto> productos = productoService.listarpro();
		List<Usuario> usuario = usuarioservice.lsitarusu();
		model.addAttribute("productos", productos);
		model.addAttribute("usuario", usuario);
		return "catalogoa";
	}

	@GetMapping("/pnombre")
	public String Buscarpornombre(@RequestParam String nombre, Model model,
			@ModelAttribute("producto") Producto producto) {
		model.addAttribute("nombrepro", productoService.Buscarnombre(nombre));
		return "nombre";
	}
	
	@GetMapping("/catalogon")
	public String catalogopornombre(@RequestParam String nombre, Model model,
			@ModelAttribute("producto") Producto producto) {
		model.addAttribute("nombrepro", productoService.Buscarnombre(nombre));
		return "catalogopornombre";
	}

	@GetMapping("/,/login")
	public String index() {
		return "index";
	}

	/*
	 * @GetMapping("/validar") public String validar( String correo,String
	 * contraseña,Usuario u,BindingResult result,Model model) {
	 * if(result.hasErrors()) { return "index"; }
	 * List<Usuario>usuario=usuarioservice.validar(correo, contraseña); if(usuario
	 * !=null){ return "/inicio/catalogo"; } if(correo.equals("admin") &&
	 * contraseña.equals("123456")) { return "redirect:/inicio/catalogoa"; } return
	 * "index"; }
	 */

}
