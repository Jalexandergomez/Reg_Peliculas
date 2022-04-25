package com.springboot.reg_peliculas.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.reg_peliculas.app.models.entity.Pelicula;
import com.springboot.reg_peliculas.app.service.IPeliculaService;

@RestController
public class peliculaRestController {
	
	@Autowired
	private IPeliculaService servicios;
	
	@GetMapping(value= "/consultar")
	public List<Pelicula> consultar(){		
		List<Pelicula> peliculas = servicios.findAll();		
		return peliculas;
	}
	
	@PostMapping(value="/guardar")
	public String guardar(String titulo, String genero, String director, String observaciones) {
		
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setGenero(genero);
		pelicula.setDirector(director);
		pelicula.setObservaciones(observaciones);		
		servicios.save(pelicula);			
		return "pelicula guardada";
	}
	
	@PutMapping(value="/editar")
	public Pelicula editar(Long id,String titulo, String genero, String director, String observaciones){
		
		Pelicula pelicula = new Pelicula();
		pelicula.setId(id);
		pelicula.setTitulo(titulo);
		pelicula.setGenero(genero);
		pelicula.setDirector(director);
		pelicula.setObservaciones(observaciones);		
		servicios.save(pelicula);
		return pelicula;
	}
	
	@DeleteMapping(value="/eliminar")
	public String eliminar(Long id) {
		servicios.delete(id);
		
		return "pelicula eliminada id: " + id ;
	}
	
	@GetMapping(value="/consultaID")
	public Pelicula consultaID(Long id) {
		Pelicula pelicula = servicios.findOne(id);				
		return pelicula;
	}
}
