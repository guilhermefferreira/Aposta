package com.sistema.aposta;

import com.sistema.aposta.controller.ApostaController;
import com.sistema.aposta.entities.Aposta;
import com.sistema.aposta.repositories.ApostaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApostaControllerTest {

    @Autowired
    private ApostaController apostaController;

    @Autowired
    private ApostaRepository apostaRepository;

    @Test
    void listarTest() {
        Integer expected = (int)apostaRepository.count();
        Integer result = apostaController.listar().size();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void incluirTest() {
        Aposta aposta = new Aposta();
        Integer expected = (int) apostaRepository.count()+1;
        aposta.setIdAposta(0);
        aposta.setIdCliente(1);
        aposta.setIdJogo(1);
        aposta.setValor(30.00);
        aposta.setPago(true);
        aposta.setDataCompra(new Date("2022/01/01"));
        apostaController.incluir(aposta);
        Integer result = (int)apostaRepository.count();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void alterarTest() {

        Aposta aposta = apostaController.Consultar(1);
        aposta.setDataCompra(new Date("2022/01/01"));
        aposta.setValor(30.00);
        aposta.setPago(true);
        aposta.setIdCliente(1);
        apostaController.alterar(aposta);
        Aposta apostaTest = apostaController.Consultar(1);

        assertThat(aposta.getValor()).isEqualTo(apostaTest.getValor());

    }

    @Test
    void consultarTest(){

        Aposta apostaTest = apostaController.Consultar(1);

        assertThat(apostaTest.getIdAposta()).isEqualTo(1);

    }
}
