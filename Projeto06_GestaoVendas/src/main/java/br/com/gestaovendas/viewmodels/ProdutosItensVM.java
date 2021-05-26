package br.com.gestaovendas.viewmodels;

public class ProdutosItensVM {
	
	private int idItens;
	private int idPedido;
	private String descricao;
	private double precoUnitario;
	private double quantidade;
	private double valorTotal;
	
	
	public int getIdItens() {
		return idItens;
	}
	public void setIdItens(int idItens) {
		this.idItens = idItens;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
