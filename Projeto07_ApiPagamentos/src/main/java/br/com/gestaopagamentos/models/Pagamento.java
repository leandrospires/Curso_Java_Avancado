package br.com.gestaopagamentos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NUMEROPEDIDO")
	private String numeropedido;
	
	@Column(name = "NUMEROCARTAO")
	private String numerocartao;
	
	@Column(name = "VALOR")
	private double valor;
	
	@Column(name = "STATUS")
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeropedido() {
		return numeropedido;
	}
	public void setNumeropedido(String numeropedido) {
		this.numeropedido = numeropedido;
	}
	public String getNumerocartao() {
		return numerocartao;
	}
	public void setNumerocartao(String numerocartao) {
		this.numerocartao = numerocartao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
