package com.sistema.aposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.aposta.entities.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer>{

}
