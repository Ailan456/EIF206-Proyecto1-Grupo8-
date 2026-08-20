package com.proyecto.mvc.models;

import java.util.ArrayList;

public class ListaCategorias {
	
private ArrayList<Categoria> list;
	
	public ListaCategorias() {
		list = new ArrayList<>();
	}
	
	public void store(Categoria category) {
		list.add(category);
	}

	public void update(Categoria updatedCategory, int id) {
		Categoria category = findById(id);

		if(category != null) {
			category.setName(updatedCategory.getName());
			
		}
	}

	public Categoria findById(int id) { 
		
		for(Categoria item : list) {
			if(item.getId()==id) { 
				return item;
			}
		}
		
		return null;
	}

	public void destroy(int id) {
		Categoria category = findById(id);

		if(category != null) {
			list.remove(category);
		}
	}
	
	public ArrayList<Categoria> getAll() {
		return list; 
	}
}
