package com.springboot.reg_peliculas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.reg_peliculas.app.dao.IPeliculaDao;
import com.springboot.reg_peliculas.app.models.entity.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	private IPeliculaDao peliculaDao;
	private Long id;

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pelicula pelicula) {
		peliculaDao.save(pelicula);
	}

	@Override
	@Transactional(readOnly = true)
	public Pelicula findOne(Long id) {		
		return peliculaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		peliculaDao.deleteById(id);
	}

	
}
