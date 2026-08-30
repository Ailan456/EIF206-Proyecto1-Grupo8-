package com.proyecto.mvc.controllers;

import com.proyecto.data.Data;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.views.ViewPrincipal;

public class Controller extends Functions {

	// =========================================================
	// ATRIBUTOS
	// =========================================================
	private ViewPrincipal vp;
	private ListaTareas listaTareas;
	private ListaCategorias listaCategorias;

	// =========================================================
	// CONSTRUCTOR
	// =========================================================
	public Controller() {
		vp = new ViewPrincipal();
		listaTareas = new ListaTareas();
		listaCategorias = new ListaCategorias();
	}

	
	// =========================================================
	// ARRANQUE
	// =========================================================
	public void init() {
		loadData();			//CARGO LOS DATOS
		vp.init();			//CARGO LA GUI PRINCIAL
		
		initVPListeners();	// Funcionalidad de los botones
		indexTareas(false);	// View por defecto al levantar
	}

	
	
		//llamamos los datos de prueva 	
		private void loadData() {new Data().getInfo(listaCategorias, listaTareas);}
		
		
		//llamamos el index
		public void indexTareas(boolean completedTask) {
			ControllerTareas c= new ControllerTareas(vp, listaTareas, listaCategorias, completedTask);
			c.initTasks();
		}
	
		public void indexCategorias() {
			ControllerCategoria c= new ControllerCategoria(vp, listaCategorias);
			c.init();
		}
	
		
	
	// Botones de la view principal
	public void initVPListeners() {
		vp.getBtnTareasPendientes().addActionListener(e -> {
			indexTareas(false);
		});

		vp.getBtnTareasCompletadas().addActionListener(e -> {
			indexTareas(true);
		});

		vp.getBtnCategorias().addActionListener(e -> {
			indexCategorias();
		});
	}

	
	

	
	
	
	
}
