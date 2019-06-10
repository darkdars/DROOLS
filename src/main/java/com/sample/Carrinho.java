package com.sample;

import java.util.List;

public class Carrinho {
	List<Items> compras;
	float valor;
	
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
		this.updateValor();
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void addCompra(Items item) {
		this.compras.add(item);
	}
	
	public void removeCompra(Items item) {
		
	}
	
	
}
