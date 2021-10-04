package com.sistema.aposta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sistema.aposta.controller.ClubeController;
import com.sistema.aposta.entities.Clube;
import com.sistema.aposta.repositories.ClubeRepository;

@SpringBootTest
public class ClubeControllerTest {

	@Autowired
	private ClubeRepository clubeRepository;

	@Autowired
	private ClubeController clubeController;

	@Test
	void listarTest() {
		Integer expected = (int) clubeRepository.count();
		Integer result = clubeController.listar().size();

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void incluirTeste() {
		Integer expected = (int) clubeRepository.count() + 1;
		System.out.println(expected);

		Clube clube = new Clube();
		clube.setIdClube(0);
		clube.setNome("Sao Paulo");
		clube.setTelefone("12345252525");

		clube.setEmail("joao@hotmail.com");

		clubeController.incluir(clube);

		Integer result = (int) clubeRepository.count();

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void alterarTeste() {
		Clube clube = clubeController.Consultar(3);

		clube.setNome("Palmeiras");
		clube.setTelefone("998761231");
		clube.setEmail("joao@hotmail.com");

		System.out.println(clube.getIdClube());

		Mensagem mensagem = clubeController.alterar(clube);
		System.out.println(mensagem.getMensagens());
		Clube clubeTest = clubeController.Consultar(3);

		assertThat(clube.getIdClube()).isEqualTo(clubeTest.getIdClube());
		
	}
	
	@Test
    void ConsultarTest(){
        Integer Expected = 5;
        Clube funcionario = clubeController.Consultar(5);

        assertThat(funcionario.getIdClube()).isEqualTo(Expected);

    }
}
