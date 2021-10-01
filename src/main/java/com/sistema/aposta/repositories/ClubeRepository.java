package com.sistema.aposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.aposta.entities.Clube;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Integer>{

}
