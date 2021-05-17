package br.com.gestaoprojetos.viewmodels;

public class ClientesProjetosVM {
	private String nomeCliente;
	private String telefoneCliente;
	private long Quantidade;
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public long getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(long quantidade) {
		Quantidade = quantidade;
	}
	
}
