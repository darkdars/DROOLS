package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Carrinho {
	List<Items> compras;
	HashMap<String, Integer> numberItems; 
	float valor;
	
	public Carrinho() {
		this.compras = new ArrayList<>();
		numberItems = new HashMap<>();
		
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
		Integer number =  new Integer(this.numberItems.get(item.id) == null ? 0 : this.numberItems.get(item.id));
		this.valor += item.getValor();
		for(Items i : this.compras) {
			if(i.getId().equals(item.getId())) {
				this.numberItems.put(i.id, ++number);
				return;
			}
		}
		this.compras.add(item);
		this.numberItems.put(item.id, ++number);
	}
	
	public Items removeCompra(String id) {
		Integer number =  new Integer(this.numberItems.get(id) == null ? 0 : this.numberItems.get(id));
		for(Items item : this.compras) {
			if(item.getId().equalsIgnoreCase(id)) {
				this.valor -= item.getValor();
				if(--number == 0) {
					this.compras.remove(item);
					this.numberItems.remove(item.id);
				}
				this.numberItems.put(item.id, number);
				return item;
			}
		}
		return null;
	}

	public int getItemNumber(String id) {
		return this.numberItems.get(id);
	}

	public int getNumberOfItems() {
		return compras.size();
	}
	
	
}
