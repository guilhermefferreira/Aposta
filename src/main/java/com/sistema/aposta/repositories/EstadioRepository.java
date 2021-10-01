package com.sistema.aposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.aposta.entities.Estadio;

public interface EstadioRepository {
	
	@Repository
	public interface estadioRepository extends JpaRepository<Estadio,Integer> {
	}

		
		
}
		
