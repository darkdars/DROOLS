package com.sample;



public class Items {
	String id;
	String nome;
	String descricao;
	String tipo;
	String img;
	Items complementar;
	float valor;
	
	public Items() {
		
	}
	
	public Items(String id, String nome,float valor, String descricao, String tipo, Items complementar) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.complementar = complementar;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Items(String id, String nome,float valor, String descricao, String tipo, Items complementar, String img) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.complementar = complementar;
		this.descricao = descricao;
		this.valor = valor;
		this.img = img;
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
	public Items getComplementar() {
		return complementar;
	}
	public void setComplementar(Items complementar) {
		this.complementar = complementar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
}
