package com.sample;

public class Loja{
	Armazem armazem;
	HashMap<String,Carrinho>;
	
	public Loja(Armazem armazem) {
		this.armazem = armazem;
	}

	public Armazem getArmazem() {
		return armazem;
	}

	public void setArmazem(Armazem armazem) {
		this.armazem = armazem;
	}
	
	
	
}
