package com.sistema.aposta.controller;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.biz.EstadioBiz;
import com.sistema.aposta.entities.Estadio;
import com.sistema.aposta.repositories.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("estadio")
public class EstadioController {

    @Autowired
    private EstadioRepository estadioRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<Estadio> listar() {
        return estadioRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Estadio estadio) {
        estadio.setIdEstadio(0);
        return add(estadio);
    }

    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Estadio estadio) {
        return add(estadio);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Estadio Consultar(@PathVariable int id){
        return estadioRepository.findById(id).get();
    }


    public Mensagem add(Estadio estadio) {
        EstadioBiz estadioBiz = new EstadioBiz();
        try
        {
            if (estadioBiz.Validade(estadio)) {
                this.estadioRepository.save(estadio);
                this.estadioRepository.flush();
            } else {
                return estadioBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> estadioBiz.msg.mensagens.add(v.getMessage()));
            return estadioBiz.msg;
        }

        estadioBiz.msg.mensagens.add("OK");

        return estadioBiz.msg;


    }

}
