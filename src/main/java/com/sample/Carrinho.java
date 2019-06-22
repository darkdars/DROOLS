package com.sample;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	List<Items> compras;
	float valor;
	
	public Carrinho() {
		this.compras = new ArrayList<>();
		
	}
	
	public void updateValor() {
		this.valor = 0;
		for (Items i: compras) {
			this.valor += i.getValor();
		}
	}
	
	public List<Items> getCompras() {
		return compras;
	}
	public void setCompras(List<Items> compras) {
		this.compras = compras;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void addCompra(Items item) {
		this.valor += item.getValor();
		this.compras.add(item);
	}
	
	public void removeCompra(String id) {
		Items tempItem;
		for(Items item : this.compras) {
			if(item.getId().equalsIgnoreCase(id)) {
				this.valor -= item.getValor();
				this.compras.remove(item);
				break;
			}
		}
	}

	public Object getItemNumber(String id) {
		int count = 0;
		for(Items item : this.compras) {
			if(item.getNome().equalsIgnoreCase("id")) {
				count++;
			}
		}
		return count;
	}
	
	
}
