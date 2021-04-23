package br.com.projeto.classes;

import java.util.Date;

//JavaBens - POJO: Plain Old Java Objects)
public class Funcionario {
	
	private String nome;
	private Date dataNascimento;
	private String cargo;
	private double salario;	
	
	private double irpf;
	private double s_liquido;
	

	public Funcionario() {}	

	
	public Funcionario(String nome, Date dataNascimento, String cargo, double salario) {
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setCargo(cargo);
		this.setSalario(salario);
	}




	private double calcularIrpf(double salario) {
		double[] taxas = {0, 7.5, 15, 22.5, 27.5};

		double [] valores = {0, 
							1903.98,
							2826.65,
							3751.05,
							46664.68};
		
		double imposto = 0;
		
		for(int i = taxas.length - 1; i >= 0; i--) {
			if (salario > valores[i]) {
				imposto += ( salario - valores[i] ) * taxas[i] / 100;
				salario = valores[i];
			}
		}
		
		return imposto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
		
		this.irpf = calcularIrpf(salario);
		this.s_liquido = this.salario - this.irpf;
	}
	
	//Apenas getters - propriedades readonly
	public double getIrpf() {
		return this.irpf;
	}

	public double getSalarioLiquido() {
		return this.s_liquido;
	}	
	
}
