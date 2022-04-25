package com.springboot.reg_peliculas.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.reg_peliculas.app.models.entity.Pelicula;
import com.springboot.reg_peliculas.app.service.IPeliculaService;

@Controller
public class PeliculaController {

	@Autowired
	private IPeliculaService peliculaService;

	@GetMapping(value ={"/", "/lista", "/listar" })
	public String lista(Model model) {
		model.addAttribute("titulo", "Mi Lista De Películas");
		model.addAttribute("peliculas", peliculaService.findAll());
		return "lista";
	}

	@GetMapping(value = "/formulario")
	public String formulario(Model model) {
		Pelicula pelicula = new Pelicula();

		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Formulario De Películas");
		model.addAttribute("boton", "Agregar");

		return "formulario";
	}

	@PostMapping(value = "/formulario")
	public String guardar(Pelicula pelicula) {
		peliculaService.save(pelicula);
		return "redirect:lista";
	}

	@RequestMapping(value = "/formulario/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Pelicula pelicula = null;

		if (id > 0) {
			pelicula = peliculaService.findOne(id);
		} else {
			return "redirect:/lista";
		}

		model.put("pelicula", pelicula);
		model.put("titulo", "Editar Película");
		model.put("boton", "Editar");

		return "formulario";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			peliculaService.delete(id);
		}

		return "redirect:/lista";
	}
	
	
}
