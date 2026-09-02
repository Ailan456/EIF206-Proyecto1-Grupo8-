package com.proyecto.mvc.controllers;

import com.proyecto.mvc.data.Data;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.views.ViewPrincipal;

public class Controller{

	// =========================================================
	// ATRIBUTOS
	// =========================================================
	private ViewPrincipal vp;
	private ListaTareas listaTareas;
	private ListaCategorias listaCategorias;
	private ControllerTareas controllerTask;
	private ControllerCategoria controllerCategory;
	
	// =========================================================
	// CONSTRUCTOR
	// =========================================================
	public Controller() {
		vp = new ViewPrincipal();
		listaTareas = new ListaTareas();
		listaCategorias = new ListaCategorias();
		controllerTask= new ControllerTareas(vp, listaTareas, listaCategorias);
		controllerCategory= new ControllerCategoria(vp, listaCategorias,listaTareas);
		
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
		
		//TablaTareas
		public void indexTareas(boolean completedTask) {
			controllerTask.init(completedTask);
		}
		
		//TablaCategoria
		public void indexCategorias() {
			controllerCategory.init();
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
