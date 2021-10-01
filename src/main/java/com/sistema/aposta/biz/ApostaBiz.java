package com.sistema.aposta.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.entities.Aposta;
import com.sistema.aposta.repositories.ClienteRepository;
import com.sistema.aposta.repositories.JogoRepository;

public class ApostaBiz {
	
	public Mensagem msg;
	
	private ClienteRepository clienteRepository;
	private JogoRepository jogoRepository;

	public ApostaBiz(ClienteRepository clienteRepository, JogoRepository jogoRepository) {
		msg= new Mensagem();
		
		this.clienteRepository= clienteRepository;
		this.jogoRepository= jogoRepository;
		
	}
	
	public Boolean Validade(Aposta aposta) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse("01/10/2020");
		
		Boolean result = true;
		if (clienteRepository.findById(aposta.getIdCliente() ).isEmpty()) {
			msg.mensagens.add("O idCliente não é válido!");
			result = false;
		}
		if (aposta.getDataCompra().before(date)) {
			msg.mensagens.add("A data da compra não está correta!");
			result = false;
		}
		if(aposta.getValor() >100 ) {
			msg.mensagens.add ("O valor não pode ser maior que 100.00 !");
			result =false;
		}
		if (aposta.getValor() <10 ) {
			msg.mensagens.add("O valor não pode ser menor que 10.00 !");
			result = false;
		}
		if (aposta.getPago() == false) {
			msg.mensagens.add("Não foi pago!");
		}
		if (jogoRepository.findById(aposta.getIdJogo() ).isEmpty()) {
			msg.mensagens.add("O idJogo não é válido!");
			result = false;
		}
		
		return result;
		
	}
}
