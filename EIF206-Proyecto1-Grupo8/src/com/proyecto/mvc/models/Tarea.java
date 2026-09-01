package com.proyecto.mvc.models;

public class Tarea {
	private static int counter = 1;
	
	private int id;
	private String name;
	private String description;
	private boolean currentState;
	private int categoryId;
	
	public Tarea(String name, String description, int categoryId) {
		super();
		this.id = counter++;
		this.name = name;
		this.description = description;
		this.currentState = false;
		this.categoryId = categoryId;
	}
	
	
	public Tarea(String name, String description, int categoryId, boolean completed) {
		super();
		this.id = counter++;
		this.name = name;
		this.description = description;
		this.currentState = completed;
		this.categoryId = categoryId;
	}
	
	
	public static int getCounter() {
		return counter;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public static void setCounter(int counter) {
		Tarea.counter = counter;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCurrentState() {
		return currentState;
	}

	public void setCurrentState(boolean currentState) {
		this.currentState = currentState;
	}
	
	public boolean getCurrentState() {
		return this.currentState;
	}
	
	
}
