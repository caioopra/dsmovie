package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service  // registra como componente do sistema
public class MovieService {
	
	@Autowired  // framework possui gerenciador de dependencias
	private MovieRepository repository;  
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);  // retorna uma Page de Movie da entidade
		// precisa converter para Page DTO, usando o MovieDTO que traduz
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	// buscar apenas um filme
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();  // retorna uma Page de Movie da entidade
		// precisa converter para Page DTO, usando o MovieDTO que traduz
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
