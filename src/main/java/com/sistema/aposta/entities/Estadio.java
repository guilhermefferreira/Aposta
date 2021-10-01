package com.sistema.aposta.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

public class Estadio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestadio")
    private int idEstadio;

    @Column(name = "nome")
    @Pattern(regexp = "[A-z ]{5,50}")
    private String nome;

}
