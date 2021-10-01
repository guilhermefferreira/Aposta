package com.sistema.aposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.aposta.entities.Estadio;

public class EstadioRespository {
	@Repository
	public interface EstadioRepository extends JpaRepository<Estadio,Integer> {
	}


}
