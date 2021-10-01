package com.sistema.aposta.controller;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.biz.ClienteBiz;
import com.sistema.aposta.entities.Cliente;
import com.sistema.aposta.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("listar")
    public List<Cliente> listar(){
        List <Cliente> lista= clienteRepository.findAll();
        return lista;
    }

    @PostMapping("incluir")
    public Mensagem incluir(@RequestBody Cliente cliente){
        cliente.setIdCliente(0);
        return salvar(cliente);
    }

    @PostMapping("alterar")
    public Mensagem alterar(@RequestBody Cliente cliente){
        return salvar(cliente);
    }

    @GetMapping("/{id}")
    public Cliente consultar(@PathVariable Integer id){
        return clienteRepository.findById(id).get();
    }

    public Mensagem salvar(Cliente cliente){
        ClienteBiz clienteBiz = new ClienteBiz();

        try{
            if(clienteBiz.Validade(cliente)){
                this.clienteRepository.save(cliente);
                this.clienteRepository.flush();
            }else{
                return clienteBiz.msg;
            }
        }catch (ConstraintViolationException e){
            e.getConstraintViolations().forEach(v -> clienteBiz.msg.mensagens.add(v.getMessage()));
            return clienteBiz.msg;
        }
        clienteBiz.msg.mensagens.add("OK");
        return clienteBiz.msg;
    }
}
