package com.sistema.aposta.entities;

import javax.persistence.*;

@Table(name = "Jogo")
public class Jogo {
	
	@Id
	@Column(name = "idjogo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdJogo;

	@Column(name = "Nome")
	private String Nome;
	
	@Column(name = "idcasa")
	private Integer IdCasa;
	
	@Column(name = "Idvisitante")
	private Integer IdVisitante;
	
	@Column(name = "idestadio")
	private Integer IdEstadio;

	public Integer getIdJogo() {
		return IdJogo;
	}

	public void setIdJogo(Integer idJogo) {
		IdJogo = idJogo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Integer getIdCasa() {
		return IdCasa;
	}

	public void setIdCasa(Integer idCasa) {
		IdCasa = idCasa;
	}

	public Integer getIdVisitante() {
		return IdVisitante;
	}

	public void setIdVisitante(Integer idVisitante) {
		IdVisitante = idVisitante;
	}

	public Integer getIdEstadio() {
		return IdEstadio;
	}

	public void setIdEstadio(Integer idEstadio) {
		IdEstadio = idEstadio;
	}
}
