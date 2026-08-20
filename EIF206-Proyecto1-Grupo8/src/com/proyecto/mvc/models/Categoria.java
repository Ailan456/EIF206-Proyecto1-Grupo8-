package com.proyecto.mvc.models;

public class Categoria {

	private static int counter=1;
	
	private int id;
	private String name;
	
	public Categoria(String name) {
		this.id = counter++;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
