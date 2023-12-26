package com.modals;

public class Admin {

	private String name;

	public Admin(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + "]";
	}
	
}
