package com.sistema.aposta.controller;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.biz.ResultadoBiz;
import com.sistema.aposta.entities.Resultado;
import com.sistema.aposta.repositories.JogoRepository;
import com.sistema.aposta.repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("resultado")
public class ResultadoController {

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<Resultado> listar() {
        return resultadoRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Resultado resultado) {
        resultado.setIdResultado(0);
        return add(resultado);
    }

    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Resultado resultado) {
        return add(resultado);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Resultado Consultar(@PathVariable int id){
        return resultadoRepository.findById(id).get();
    }


    public Mensagem add(Resultado resultado) {
        ResultadoBiz resultadoBiz = new ResultadoBiz(jogoRepository);
        try
        {
            if (resultadoBiz.Validade(resultado)) {
                this.resultadoRepository.save(resultado);
                this.resultadoRepository.flush();
            } else {
                return resultadoBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> resultadoBiz.msg.mensagens.add(v.getMessage()));
            return resultadoBiz.msg;
        }

        resultadoBiz.msg.mensagens.add("OK");

        return resultadoBiz.msg;


    }
}
