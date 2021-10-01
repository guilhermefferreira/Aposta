package com.sistema.aposta.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aposta")
public class Aposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idaposta")
	private int idAposta;
	
	@Column(name= "idcliente", nullable = false, precision = 11)	
	private int idCliente;
	
	@Column(name= "datacompra", nullable=false, precision = 11)
	private Date dataCompra;
	
	@Column(name= "valor", nullable= false, precision = 16, scale = 2 )	
	private Double valor;
	
	@Column(name="pago", nullable=false)
	private Boolean pago;
	
	@Column(name="idjogo", nullable=false, precision = 11)
    private int idJogo;

	public int getIdAposta() {
		return idAposta;
	}

	public void setIdAposta(int idAposta) {
		this.idAposta = idAposta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}	
	
	
}
