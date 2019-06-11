package com.sample;

public class Cliente {
	private String id;
	private String name;
	private boolean male;
	private boolean single;
	private boolean children;
	
	
	public Cliente(String id, String name, boolean male, boolean single, boolean children) {
		this.id = id;
		this.name = name;
		this.male = male;
		this.single = single;
		this.children = children;
		
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
	
}
