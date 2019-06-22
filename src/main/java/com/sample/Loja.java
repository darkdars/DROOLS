package com.sample;

import java.util.*;

public class Loja{
	Armazem armazem;
	HashMap<Cliente,Carrinho> lista;
	
	public Loja() {
		ReadCsvFile readCsvFile = new ReadCsvFile();
		List<Items> listItems = new ArrayList<Items>();


		listItems = readCsvFile.readItemsFile("csv-file/StoreItems.csv");
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
	
	public void addItemToCart(Cliente cliente, Items item) {
		Carrinho carrinho = lista.get(cliente);
		if(carrinho == null) {
			return;
		}
		carrinho.addCompra(item);
		lista.put(cliente, carrinho);
	}
	
	public void removeItemFromCart(Cliente cliente, Items item) {
		Carrinho carrinho = lista.get(cliente);
		if(carrinho == null) {
			return;
		}
		carrinho.removeCompra(item.getId());
		lista.put(cliente, carrinho);
	}
	
	public void removeItemFromCart(Cliente cliente, String id) {
		Carrinho carrinho = lista.get(cliente);
		if(carrinho == null) {
			return;
		}
		Items item = carrinho.removeCompra(id);
		if(item == null) {
			return;
		}
		armazem.setItem(item);
		lista.put(cliente, carrinho);
	}
	
	public Carrinho getCart(Cliente cliente) {
		return lista.get(cliente);
	}

	public void addCliente(Cliente cliente) {
		for (Cliente key : lista.keySet()) {
		    if(key == cliente) {
		    	return;
		    }
		}
		lista.put(cliente, new Carrinho());
	}
	
	public void resetCliente(Cliente cliente) {
		for (Cliente key : lista.keySet()) {
		    if(key == cliente) {
				lista.put(cliente, new Carrinho());
		    	return;
		    }
		}
	}

	public int getNumberOfItemsInCart(Cliente cliente, String id) {
		// TODO Auto-generated method stub
		return this.lista.get(cliente).getItemNumber(id);
	}
	
	
	
	
}
