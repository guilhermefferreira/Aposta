package com.sistema.aposta.biz;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.entities.Jogo;
import com.sistema.aposta.entities.Resultado;
import com.sistema.aposta.repositories.ClubeRepository;
import com.sistema.aposta.repositories.JogoRepository;
import com.sistema.aposta.repositories.ResultadoRepository;

import javax.validation.Valid;

public class ResultadoBiz {

    public Mensagem mensagem;

    private JogoRepository jogoRepository;

    private ClubeRepository clubeRepository;

    public ResultadoBiz(JogoRepository jogoRepository, ClubeRepository clubeRepository){
        mensagem = new Mensagem();
        this.jogoRepository = jogoRepository;
        this.clubeRepository = clubeRepository;
    }

    public boolean Validade(@Valid Resultado resultado){
        boolean valido = true;
        Jogo jogo = jogoRepository.findById(resultado.getIdJogo()).get();
        if(jogo == null){
            mensagem.mensagens.add("Jogo não encontrado / Inexistente!");
            valido = false;
        }
        if(jogo.getIdVisitante() != resultado.getIdClube() && jogo.getIdCasa() != resultado.getIdClube()){
            mensagem.mensagens.add("Clube não pertence a este jogo!");
            valido = false;
        }
        if(resultado.getIdClube() != null && resultado.isVencedor() == false){
            mensagem.mensagens.add("Não há vencedores em empates.");
            valido = false;
        }
        if(resultado.getNome().isBlank() || resultado.getNome().isEmpty()){
            mensagem.mensagens.add("Nome não pode ser nulo");
            valido = false;
        }
        return valido;
    }
}
