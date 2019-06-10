package com.sample;

enum Tipo{
	mulher, homem, crianca
}

public class Items {
	String id;
	String nome;
	Tipo tipo;
	Items complementar;
	int stock;
	
	public Items() {
		
	}
	
	public Items(String nome, Tipo tipo, Items complementar, int stock) {
		this.nome = nome;
		this.tipo = tipo;
		this.complementar = complementar;
		this.stock = stock;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Items getComplementar() {
		return complementar;
	}
	public void setComplementar(Items complementar) {
		this.complementar = complementar;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
