package com.sistema.aposta.controller;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.biz.ClubeBiz;
import com.sistema.aposta.entities.Clube;
import com.sistema.aposta.repositories.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("clube")
@CrossOrigin
public class ClubeController {

    @Autowired
    private ClubeRepository clubeRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<Clube> listar() {
        return clubeRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Clube clube) {
        clube.setIdClube(0);
        return add(clube);
    }

    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Clube clube) {
        return add(clube);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Clube Consultar(@PathVariable int id){
        return clubeRepository.findById(id).get();
    }


    public Mensagem add(Clube clube) {
        ClubeBiz clubeBiz = new ClubeBiz();
        try
        {
            if (clubeBiz.Validade(clube)) {
                this.clubeRepository.save(clube);
                this.clubeRepository.flush();
            } else {
                return clubeBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> clubeBiz.msg.mensagens.add(v.getMessage()));
            return clubeBiz.msg;
        }

        clubeBiz.msg.mensagens.add("OK");

        return clubeBiz.msg;


    }
}
