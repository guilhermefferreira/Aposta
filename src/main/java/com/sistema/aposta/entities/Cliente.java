package com.sistema.aposta.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int IdCliente;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String Nome;

    @Column(name = "email", nullable = false, length = 50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String Email;

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
