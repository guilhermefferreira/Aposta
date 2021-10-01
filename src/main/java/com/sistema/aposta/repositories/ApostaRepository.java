package com.sistema.aposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.aposta.entities.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

}
