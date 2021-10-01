package com.sistema.aposta.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Table(name = "Resultado")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresultado")
    private Integer IdResultado;

    @Column(name = "Nome")
    @Pattern(regexp = "[A-z ]{5,50}")
    private String Nome;

    @Column(name ="Vencedor")
    private boolean Vencedor;

    @Column(name = "IdJogo")
    private Integer IdJogo;

    @Column(name="IdClube")
    private Integer IdClube;

    public Integer getIdResultado() {
        return IdResultado;
    }

    public void setIdResultado(Integer idResultado) {
        IdResultado = idResultado;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public boolean isVencedor() {
        return Vencedor;
    }

    public void setVencedor(boolean vencedor) {
        Vencedor = vencedor;
    }

    public Integer getIdJogo() {
        return IdJogo;
    }

    public void setIdJogo(Integer idJogo) {
        IdJogo = idJogo;
    }

    public Integer getIdClube() {
        return IdClube;
    }

    public void setIdClube(Integer idClube) {
        IdClube = idClube;
    }
}
