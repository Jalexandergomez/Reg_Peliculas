package com.springboot.reg_peliculas.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.reg_peliculas.app.models.entity.Pelicula;

public interface IPeliculaDao extends CrudRepository<Pelicula, Long> {
}
