package com.sistema.aposta.controller;


import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sistema.aposta.Mensagem;
import com.sistema.aposta.biz.JogoBiz;
import com.sistema.aposta.entities.Jogo;
import com.sistema.aposta.repositories.ClubeRepository;
import com.sistema.aposta.repositories.EstadioRepository;
import com.sistema.aposta.repositories.JogoRepository;

@RestController
@RequestMapping("jogo")
@CrossOrigin
public class JogoController {

	@Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    @Autowired
    private JogoRepository jogoRepository;
    
    @GetMapping
    @RequestMapping("listar")
    public List<Jogo> listar() {
        List<Jogo> lista = jogoRepository.findAll();
        return lista;
    }
    
    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Jogo jogo) {
        jogo.setIdJogo(0);
        return salvar(jogo);
    }
    
    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Jogo jogo) {
        return salvar(jogo);
    }
    
    @GetMapping
    @RequestMapping("/{id}")
    public Jogo Consultar(@PathVariable int id){
        return jogoRepository.findById(id).get();
    }
    
    @PostMapping
    @RequestMapping("deletar")
    public Jogo deletar(@RequestBody int id,Jogo jogo) {
        this.jogoRepository.delete(jogo);
        this.jogoRepository.flush();
        return jogo;
    }
    
    public Mensagem salvar(Jogo jogo) {
        JogoBiz jogoBiz = new JogoBiz(clubeRepository, estadioRepository);
        
        try
        {
            if (jogoBiz.Validade(jogo)) {
                this.jogoRepository.save(jogo);
                this.jogoRepository.flush();
            } else {
                return jogoBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> jogoBiz.msg.mensagens.add(v.getMessage()));
            return jogoBiz.msg;
        }

        jogoBiz.msg.mensagens.add("OK");

        return jogoBiz.msg;


    }
}
