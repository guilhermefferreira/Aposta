package com.sistema.aposta.biz;

import com.sistema.aposta.Mensagem;
import com.sistema.aposta.entities.Clube;

import javax.validation.Valid;

public class ClubeBiz {

    public Mensagem msg;

    public ClubeBiz(){
        msg = new Mensagem();
    }

    public Boolean Validade(@Valid Clube clube) {

        Boolean result = true;
        msg = new Mensagem();

        if (clube.getNome().isEmpty()) {
            msg.mensagens.add("O nome não pode ser vazio");
            result = false;

            if (clube.getNome().length() < 5) {
                msg.mensagens.add("O nome não pode ter menos que 5 caracteres ");
                result = false;
            }
            if(clube.getTelefone().isEmpty()){
                msg.mensagens.add("O Telefone não pode ser vazio");
                result = false;
            }
            if(clube.getTelefone().length() < 8){
                msg.mensagens.add("O telefone não pode ter menos que 8 números");
                result = false;
            }
            if(clube.getEmail().isEmpty()){
                msg.mensagens.add("O email não pode ser vazio");
                result = false;
            }
            if (clube.getEmail().length() < 5){
                msg.mensagens.add("O email não pode ter menos que 5 caracteres");
                result = false;
            }

        }
        return result;
    }

}
