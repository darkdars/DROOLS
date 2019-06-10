package com.sample;

import java.util.*;

public class Loja{
	Armazem armazem;
	HashMap<String,Carrinho> lista;
	

	public Loja(Armazem armazem) {
		this.lista = new HashMap<>();
		this.armazem = armazem;
	}

	public Armazem getArmazem() {
		return armazem;
	}

	public void setArmazem(Armazem armazem) {
		this.armazem = armazem;
	}
	
	
	
}
