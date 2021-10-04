package com.sistema.aposta.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.entities.Cliente;
import com.sistema.aposta.repositories.ClienteRepository;

public class ClienteBiz {
	
		public Mensagem msg;

		public ClienteBiz(){
			msg = new Mensagem();
		}

		public Boolean Validade(Cliente cliente) {
	
		Boolean result = true;
		if (cliente.getNome().isEmpty()) {
			msg.mensagens.add("O nome do cliente não pode ser vazio");
			result = false;
		}
		
		if (cliente.getEmail().isEmpty()) {
			msg.mensagens.add("O email do cliente não pode ser vazio");
			result = false;
		}
		
		return result;
		
	}

}
