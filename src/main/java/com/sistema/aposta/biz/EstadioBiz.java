package com.sistema.aposta.biz;
import javax.validation.Valid;
import com.sistema.aposta.Mensagem;
import com.sistema.aposta.entities.Estadio;


public class EstadioBiz {
	
	public Mensagem msg;
	
	public EstadioBiz(){
        msg = new Mensagem();
    }
	
	public Boolean Validade(@Valid Estadio estadio) {

        Boolean result = true;
        msg = new Mensagem();

        if (estadio.getNome().isEmpty()) {
            msg.mensagens.add("O nome não pode ser vazio");
            result = false;

            if (estadio.getNome().length() < 5) {
                msg.mensagens.add("O nome não pode ter menos que 5 caracteres ");
                result = false;
            }
        }
        
        return result;
    }
}	
