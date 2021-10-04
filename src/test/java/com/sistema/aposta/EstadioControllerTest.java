package com.sistema.aposta;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sistema.aposta.controller.EstadioController;
import com.sistema.aposta.entities.Estadio;
import com.sistema.aposta.repositories.EstadioRepository;


@SpringBootTest
public class EstadioControllerTest {
	
	@Autowired
	private EstadioController estadioController;
	
	@Autowired
	private EstadioRepository estadioRepository;
	
	@Test
    void listarTest() {
        Integer expected = (int)estadioRepository.count();
        Integer result = estadioController.listar().size();
        assertThat(result).isEqualTo(expected);
    }
	
	@Test
	void incluirTest() {
		Estadio estadio = new Estadio();
		Integer expected = (int) estadioRepository.count()+1;
		estadio.setIdEstadio(0);
		estadio.setNome("Andressa");
		estadioController.incluir(estadio);
		Integer result = (int)estadioRepository.count();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void alterarTest() {
		Estadio estadio = estadioController.Consultar(1);
		estadio.setNome("Josens");
		estadioController.alterar(estadio);
		Estadio estadioTest =  estadioController.Consultar(1);
		
		assertThat(estadio.getNome()).isEqualTo(estadioTest.getNome());
	}
	
	@Test
	void consultarTest() {
		
		Estadio estadio = new Estadio();
		estadio.setNome("Josens");
		Estadio estadioTest = estadioController.Consultar(1);
		
		assertThat(estadio.getNome()).isEqualTo(estadioTest.getNome());
	}

}
