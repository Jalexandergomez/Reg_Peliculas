package com.springboot.reg_peliculas.app.service;

import java.util.List;
import com.springboot.reg_peliculas.app.models.entity.Pelicula;

public interface IPeliculaService {
	
	public List<Pelicula> findAll();
	
	public void save(Pelicula pelicula);
	
	public Pelicula findOne(Long id);
	
	public void delete(Long id);
}
