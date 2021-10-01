package com.sistema.aposta.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.biz.ApostaBiz;
import com.sistema.aposta.entities.Aposta;
import com.sistema.aposta.repositories.ApostaRepository;
import com.sistema.aposta.repositories.ClienteRepository;
import com.sistema.aposta.repositories.JogoRepository;

@RestController
@RequestMapping("Aposta")
//@CrossOrigin("http://localhost:4200/")
public class ApostaController {
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired
	private JogoRepository jogoRepository;
	
	  @GetMapping
	    @RequestMapping("listar")
	    public List<Aposta> listar() {
	        List<Aposta> lista = apostaRepository.findAll();
	        return lista;
	    }


	    @PostMapping
	    @RequestMapping("incluir")
	    public Mensagem incluir(@RequestBody Aposta aposta) {
	        aposta.setIdAposta(0);
	        return add(aposta);
	    }

	    @PostMapping
	    @RequestMapping("alterar")
	    public Mensagem alterar(@RequestBody Aposta aposta) {
	        return add(aposta);
	    }

	    @GetMapping
	    @RequestMapping("/{id}")
	    public Aposta Consultar(@PathVariable int id){
	        return apostaRepository.findById(id).get();
	    }


	    public Mensagem add(Aposta aposta) {
	    	ApostaBiz apostaBiz = new ApostaBiz(clienteRepository, jogoRepository);
	        System.out.println(aposta.getDataCompra());
	        try
	        {
	            if (apostaBiz.Validade(aposta)) {
	                this.apostaRepository.save(aposta);
	                this.apostaRepository.flush();
	            } else {
	                return apostaBiz.msg;
	            }
	        }
	        catch (ConstraintViolationException e) {
	            e.getConstraintViolations().forEach(v -> apostaBiz.msg.mensagens.add(v.getMessage()));
	            return apostaBiz.msg;
	        }
	        catch (ParseException e) {
	            e.printStackTrace();
	        }

	        apostaBiz.msg.mensagens.add("OK");

	        return apostaBiz.msg;


	    }
	}

