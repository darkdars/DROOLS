package com.sample;

import java.util.*;

public class Armazem extends Items{
	private List<Items> listItems;
	private HashMap<String, Integer> numberItems;
	private static final Integer minimumStock = 5;
	private static final Integer maxStock = 20;
	private String lastRule = "Didn't Trigger Any";
	private List<Items> lastList;

	public Armazem(List<Items> listItems) {
		// TODO Auto-generated constructor stub
		super();
		this.listItems = listItems;
		this.lastList = new ArrayList();
		numberItems = new HashMap<>();
		for(Items item : listItems) {
			this.numberItems.put(item.getId(), new Integer(maxStock));
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
	
	public void setMaxNumberItems(String id) {
		this.numberItems.put(id, maxStock);
	}
	public Object[] getNumberItemsKey() {
		return this.numberItems.keySet().toArray();
	}
	public Object[] getNumberItemsValue() {
		return this.numberItems.values().toArray();
	}

	public static Integer getMinimumstock() {
		return minimumStock;
	}

	public static Integer getMaxstock() {
		return maxStock;
	}
	
	public List<Items> getChildList(String tipo){
		List<Items> sendList = new ArrayList();
		List<Items> tempList = new ArrayList();
		lastRule = "Check Children";
		for(Items item : this.listItems) {
			if(item.getTipo().equalsIgnoreCase(tipo)) {
				sendList.add(item);
				lastList.add(item);
			}else {
				tempList.add(item);				
			}
		}
		sendList.addAll(tempList);
		return sendList;
	}
	
	public List<Items> getDescriptionList(String tipo, String descricao){
		List<Items> sendList = new ArrayList();
		List<Items> tempList = new ArrayList();
		lastRule = "Check Married";
		for(Items item : this.listItems) {
			if(item.getTipo().equalsIgnoreCase(tipo) && item.getDescricao().equalsIgnoreCase(descricao)) {
				sendList.add(item);
				lastList.add(item);
			}else {
				tempList.add(item);				
			}
		}
		sendList.addAll(tempList);
		return sendList;
	}
	
	public List<Items> getComplamentaryList(String complementar){
		List<Items> sendList = new ArrayList();
		List<Items> tempList = new ArrayList();
		lastRule = "Check Single";
		for(Items item : this.listItems) {
			if(item.getId().equalsIgnoreCase(complementar)) {
				sendList.add(item);
				lastList.add(item);
			}else {
				tempList.add(item);				
			}
		}
		sendList.addAll(tempList);
		return sendList;
	}
	
	public List<Items> getLastList(){
		List<Items> send = lastList;
		lastList = new ArrayList();
		resetLastRule();
		return send;
	}
	
	public void resetLastRule(){
		lastRule = "Didn't Trigger Any";
	}
	public String getLastRule(){
		String send = lastRule;
		return send;
	}
}
