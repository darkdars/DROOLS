package com.sample;

import java.util.*;

public class Armazem extends Items {
	List<Items> listItems;
	
	public Armazem(List<Items> listItems) {
		// TODO Auto-generated constructor stub
		this.listItems = listItems;
	}

	public List<Items> getListItems() {
		return listItems;
	}

	public void setListItems(List<Items> listItems) {
		this.listItems = listItems;
	}
	
	

}
