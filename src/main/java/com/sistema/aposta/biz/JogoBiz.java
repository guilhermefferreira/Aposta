package com.sistema.aposta.biz;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.entities.Jogo;
import com.sistema.aposta.repositories.ClubeRepository;
import com.sistema.aposta.repositories.EstadioRepository;

public class JogoBiz {

	public Mensagem msg;

	private ClubeRepository clubeRepository;
	private EstadioRepository estadioRepository;

	public JogoBiz(ClubeRepository clubeRepository, EstadioRepository estadioRepository) {
		msg = new Mensagem();

		this.clubeRepository = clubeRepository;
		this.estadioRepository = estadioRepository;
	}

	public Boolean Validade(Jogo jogo) {

		Boolean result = true;
		if (jogo.getNome().isEmpty()) {
			msg.mensagens.add("O nome do jogo não pode ser vazio");
			result = false;
		}

		if (clubeRepository.findById(jogo.getIdCasa()).isEmpty()) {
			msg.mensagens.add("O id escolhido não é válido");
			result = false;
		}

		if (clubeRepository.findById(jogo.getIdVisitante()).isEmpty()) {
			msg.mensagens.add("O id escolhido não é válido");
			result = false;
		}

		if (estadioRepository.findById(jogo.getIdEstadio()).isEmpty()) {
			msg.mensagens.add("O estadio escolhido não é válido");
			result = false;
		}

		return result;

	}
}
