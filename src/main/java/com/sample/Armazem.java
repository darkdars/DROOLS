package com.sample;

import java.util.*;

public class Armazem extends Items{
	List<Items> listItems;
	HashMap<String, Integer> numberItems; 
	
	public Armazem(List<Items> listItems) {
		// TODO Auto-generated constructor stub
		super();
		this.listItems = listItems;
		numberItems = new HashMap<>();
		for(Items item : listItems) {
			this.numberItems.put(item.getId(), new Integer(20));
		}
	}

	public List<Items> getListItems() {
		List<Items> tempItems = new ArrayList();
		for(Items i : this.listItems) {
			if(this.numberItems.get(i.id) > 0) {
				tempItems.add(i);
			}
		}
		return tempItems;
	}

	public void setListItems(List<Items> listItems) {
		this.listItems = listItems;
	}
	
	public Items getItem(String id) {
		for(Items i : this.listItems) {
			if(i.getId() == id && this.numberItems.get(i.id) != 0) {
				Integer number =  new Integer(this.numberItems.get(i.id) == null ? 0 : this.numberItems.get(i.id));
				this.numberItems.put(i.id, --number);
				return i;
			}
		}
		
		return null;
	}
	
	public void setItem(Items item) {		
		Integer number =  new Integer(this.numberItems.get(item.id) == null ? 0 : this.numberItems.get(item.id));
		this.numberItems.put(item.getId(), ++number);
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
}
