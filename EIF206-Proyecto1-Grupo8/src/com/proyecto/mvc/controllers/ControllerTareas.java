package com.proyecto.mvc.controllers;

import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.views.ViewPrincipal;

public class ControllerTareas {
	
	private ViewPrincipal vp;
	private ListaTareas listaTareas;
	private ListaCategorias listaCategorias;
	
	public ControllerTareas() {
		vp = new ViewPrincipal();
		listaTareas = new ListaTareas();
		listaCategorias = new ListaCategorias();
	}
	
	public void init() {
		vp.init();
	}
	
}
