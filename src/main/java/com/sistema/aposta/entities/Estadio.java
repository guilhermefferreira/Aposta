package com.sistema.aposta.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="estadio")
public class Estadio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestadio")
    private int idEstadio;

	@Column(name = "nome")
	@Pattern(regexp = "[A-z ]{5,50}")
	private String nome;

    public int getIdEstadio() {
		return idEstadio;
	}

	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
