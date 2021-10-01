package com.sistema.aposta.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int IdTecido;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String Nome;

    @Column(name = "email",precision = 12, scale = 2)
    private double Email;

    public int getIdTecido() {
        return IdTecido;
    }

    public void setIdTecido(int idTecido) {
        IdTecido = idTecido;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public double getEmail() {
        return Email;
    }

    public void setEmail(double email) {
        Email = email;
    }
}
