package com.sample;

public class Cliente {
	private String id;
	private String name;
	private boolean isMale;
	private boolean isSingle;
	private boolean children;
	
	
	public Cliente(String id, String name, boolean isMale, boolean isSingle, boolean children) {
		this.id = id;
		this.name = name;
		this.isMale = isMale;
		this.isSingle = isSingle;
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
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public boolean isSingle() {
		return isSingle;
	}
	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}
	public boolean isChildren() {
		return children;
	}
	public void setChildren(boolean children) {
		this.children = children;
	}
	
}
