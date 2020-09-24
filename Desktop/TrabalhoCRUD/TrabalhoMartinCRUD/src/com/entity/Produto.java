package com.entity;

public class Produto {
	private String nome;
	private String tipo;
	private double preco; 

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", tipo=" + tipo + ", preco=" + preco + "]";
	}
	
	public Produto() {
		super();
	}

	public Produto(String nome, String tipo, double preco) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	

}
