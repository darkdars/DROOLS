package com.sample;

import java.util.*;

public class Armazem extends Items{
	List<Items> listItems;
	HashMap<String, Integer> numberItems; 
	
	public Armazem(List<Items> listItems) {
		// TODO Auto-generated constructor stub
		super();
		this.listItems = listItems;
		updateNumbers();
	}

	public List<Items> getListItems() {
		return listItems;
	}

	public void setListItems(List<Items> listItems) {
		this.listItems = listItems;
	}
	
	public Items getItem(String id) {
		for(Items i : this.listItems) {
			if(i.getId() == id) {
				Integer number =  new Integer(this.numberItems.get(i.id) == null ? 0 : this.numberItems.get(i.id));
				this.numberItems.put(i.id, --number);
				this.listItems.remove(i);
				return i;
			}
		}
		
		return null;
	}
	
	public void setItem(Items item) {		
		Integer number =  new Integer(this.numberItems.get(item.id) == null ? 0 : this.numberItems.get(item.id));
		this.numberItems.put(item.id, ++number);
		this.listItems.add(item);
	}

	public int getNumeroItems(String id) {
		return this.numberItems.get(id) == null ? 0 : this.numberItems.get(id);
	}

	public HashMap<String, Integer> getNumberItems() {
		return numberItems;
	}

	public void setNumberItems(HashMap<String, Integer> numberItems) {
		this.numberItems = numberItems;
	}
	
	public void updateNumbers() {
		this.numberItems = new HashMap<String,Integer>();
		for(Items item : this.listItems) {
			Integer number =  new Integer(this.numberItems.get(item.id) == null ? 0 : this.numberItems.get(item.id));
			this.numberItems.put(item.id, ++number);
		}
	}
}
