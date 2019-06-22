package com.sample;

import java.util.*;

public class Loja{
	Armazem armazem;
	HashMap<Cliente,Carrinho> lista;
	
	public Loja() {
		List<Items> listItems = new ArrayList<Items>();

		// Inserir na lista de items

		Items item1 = new Items("001", "Chapeu",10, "Tommy", "homem", null);
		Items item2 = new Items("002", "Oculos de Sol",10, "Ray Ban", "homem", item1);
		Items item3 = new Items("003", "Camisola",0, "Sou o Papa!", "crianca", null);
		
		listItems.add(item1);
		listItems.add(item2);
		listItems.add(item3);

		// Armazém criado
		this.armazem = new Armazem(listItems);

		this.lista = new HashMap<>();
	}
	
	public Loja(Armazem armazem) {
		this.lista = new HashMap<>();
		this.armazem = armazem;
		Carrinho carrinho = new Carrinho();
		//carrinho.addCompra(new Items("001", "Chapeu",10, "Tommy", "homem", null));
		//this.lista.put("001", carrinho);
	}

	public Armazem getArmazem() {
		return armazem;
	}

	public void setArmazem(Armazem armazem) {
		this.armazem = armazem;
	}

	public HashMap<Cliente, Carrinho> getLista() {
		return lista;
	}

	public void setLista(HashMap<Cliente, Carrinho> lista) {
		this.lista = lista;
	}
	
	public void addCart(Cliente cliente, Carrinho carrinho) {
		lista.put(cliente, carrinho);
	}
	
	public Carrinho getCart(Cliente cliente) {
		return lista.get(cliente);
	}
	
	
	
	
}
