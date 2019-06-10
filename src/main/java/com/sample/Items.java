package com.sample;

enum Tipo{
	mulher, homem, crianca
}

public class Items {
	String nome;
	Tipo tipo;
	Items complementar;
	
	public Items(String nome, Tipo tipo, Items complementar) {
		this.nome = nome;
		this.tipo = tipo;
		this.complementar = complementar;
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
	
}
