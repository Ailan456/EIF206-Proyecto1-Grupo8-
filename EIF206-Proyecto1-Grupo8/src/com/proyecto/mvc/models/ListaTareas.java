package com.proyecto.mvc.models;

import java.util.ArrayList;

public class ListaTareas {
	
	private ArrayList<Tarea> list;
	
	public ListaTareas() {
		list = new ArrayList<>();
	}
	
	public void store(Tarea task) {
		list.add(task);
	}

	public void update(Tarea updatedTask, int id) {
		Tarea tarea = findById(id);

		if(tarea != null) {
			tarea.setName(updatedTask.getName());
			tarea.setDescription(updatedTask.getDescription());
			tarea.setCategoryId(updatedTask.getCategoryId());
		}
	}

	public Tarea findById(int id) { //
		
		for(Tarea item : list) {
			if(item.getId()==id) { 
				return item;
			}
		}
		
		return null;
	}

	public void destroy(int id) {
		Tarea tarea = findById(id);

		if(tarea != null) {
			list.remove(tarea);
		}
	}
	
	public ArrayList<Tarea> getAll() {
		return list; 
	}
	//Metodo para cambiar una tarea a completada recibe el ID seleccionado en la tabla
	public void completedTask(int id) {
		Tarea tarea = findById(id);

		if(tarea != null) {
			tarea.setCurrentState(true);
		}
	}
}