package com.sample;

public class Cliente {
	private String id;
	private String name;
	private String lastitem;
	private boolean male;
	private boolean single;
	private boolean children;
	
	public Cliente(String name, boolean male, boolean single, boolean children) {
		this.name = name;
		this.male = male;
		this.single = single;
		this.children = children;
		this.lastitem = " ";
	}
	
	public Cliente(String id, String name, boolean male, boolean single, boolean children) {
		this.id = id;
		this.name = name;
		this.male = male;
		this.single = single;
		this.children = children;
		this.lastitem = " ";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean male() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public boolean checkMale(String tipo) {
		if(tipo == null) {
			return false;
		}
		if((tipo.equals("homem") && male) || (tipo.equals("mulher") && !male)) {
			return true;
		}
		return false;
	}
	
	public String checkMaleString() {
		return male == true ? "homem" : "mulher";
	}
	public boolean single() {
		return this.single;
	}
	public void setSingle(boolean single) {
		this.single = single;
	}
	public boolean isChildren() {
		return children;
	}
	public void setChildren(boolean children) {
		this.children = children;
	}

	public String getLastitem() {
		return lastitem;
	}

	public void setLastitem(String lastitem) {
		this.lastitem = lastitem;
	}
	
	public boolean checkLastitem() {
		return !this.lastitem.equalsIgnoreCase(" ");
	}
	
	public void deleteLastitem() {
		this.lastitem = " ";
	}

}
