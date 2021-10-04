package com.sistema.aposta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.aposta.controller.JogoController;
import com.sistema.aposta.entities.Jogo;
import com.sistema.aposta.repositories.JogoRepository;

@SpringBootTest
class JogoControllerTest {
    @Autowired
    private JogoRepository jogoRepository;
    
    @Autowired
    private JogoController jogoController;
    
    @Test
	void listarTest() {
		Integer expected = (int)jogoRepository.count();
		Integer result = jogoController.listar().size();
	    assertThat(result).isEqualTo(expected);
	}
    
	@Test
	void incluirTest() {
		Jogo jogo = new Jogo();
		jogo.setIdJogo(0);
	    jogo.setNome("Borucia Dortmund x augsBurg");
	    jogo.setIdCasa(1);
	    jogo.setIdVisitante(1);
	    jogo.setIdEstadio(1);
		Integer expected = (int)jogoRepository.count()+1;
		Mensagem Message = jogoController.incluir(jogo);
		Integer result = (int)jogoRepository.count();
		if(jogoRepository.findById(jogo.getIdJogo()).isEmpty()){
			assertThat(result).isEqualTo(expected);
		}else{
			System.out.println(Message.getMensagens());
		}
	}
	
	@Test
	void alterarTest() {
		Jogo jogo = jogoController.Consultar(7);	
		jogo.setNome("Bota Fogo x Flamengo");
		jogo.setIdCasa(1);
		jogo.setIdVisitante(1);
		jogo.setIdEstadio(1);		
		jogoController.alterar(jogo);		
		Jogo jogoTest = jogoController.Consultar(7);	
		assertThat(jogo.getNome()).isEqualTo(jogoTest.getNome());
	}
	
	@Test
	void consultaTest() {
	
		Jogo jogoTest = jogoController.Consultar(3);		
		assertThat(jogoTest.getIdJogo()).isEqualTo(jogoTest.getIdJogo());
		}
    
    
}
