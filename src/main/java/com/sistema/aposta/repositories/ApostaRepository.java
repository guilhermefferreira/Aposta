package com.sistema.aposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.aposta.entities.Aposta;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

}
