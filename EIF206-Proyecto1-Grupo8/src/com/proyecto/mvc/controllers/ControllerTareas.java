
package com.proyecto.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.proyecto.mvc.models.Categoria;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.models.Tarea;
import com.proyecto.mvc.views.ViewPrincipal;
import com.proyecto.mvc.views.tareas.FormTasks;
import com.proyecto.mvc.views.tareas.ViewTareasPendientes;

public class ControllerTareas extends Functions {

	private ViewPrincipal vp;
	private ViewTareasPendientes taskView;
	private ListaTareas listaTareas;
	private ListaCategorias listaCategorias;
	private boolean completedTask;
	

	
	public ControllerTareas(ViewPrincipal vp, ListaTareas listaTareas,
			ListaCategorias listaCategorias, boolean completedTask) {
		this.vp= vp;
		this.listaTareas= listaTareas;
		this.listaCategorias=listaCategorias;
		this.completedTask=completedTask;
		
		this.taskView = new ViewTareasPendientes();
	}

	
	
	
	// =========================================================
		// SECCION: TAREAS 
		// =========================================================

	

	// Metodo de inicializacion de listeners aparte para evitar el error de crear multiples listeners
	public void setBtns() {
		
		taskView.getBtnCargar().addActionListener(e -> {
			cargarTareas(taskView);
		});
		
		if(!completedTask) { //dentro de este if, se setean los botones, solo si se van a usar
			taskView.getBtnNueva().addActionListener(e -> {
				createTask();
			});
	
			taskView.getBtnEditar().addActionListener(e -> {
				int id = getSelectedID(taskView.getTable());
				
				if (id > 0)
					editTask(id);
			});
	
			taskView.getBtnEliminar().addActionListener(e -> {
				int id = getSelectedID(taskView.getTable());
	
				if (id > 0) {
					int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar?");
	
					if (opcion == 0) {
						listaTareas.destroy(id);
						cargarTareas(taskView);
					}
				}
			});
	
			taskView.getBtnCompletada().addActionListener(e -> {
				int id = getSelectedID(taskView.getTable());
	
				if (id > 0) {
					int opcion = JOptionPane.showConfirmDialog(null, "Desea marcar como completada la tarea?");
	
					if (opcion == 0) {
						listaTareas.completedTask(id);
						cargarTareas(taskView);
					}
				}
			});
		}//if
	}



	//carga los
	public void initTasks() {
		loadCbxCategory(taskView.getCbxCategory());
		vp.setContenido(taskView, completedTask? "Tareas-Completadas":"Tareas-Pendientes");
		setBtns();
	}

	
	
	// =========================================================
	// COMBOBOX DE CATEGORIAS (compartido por todas las views)
	// =========================================================
	// Carga las categorias a TODOS los combobox, solo le pasan el combo de la view
	public void loadCbxCategory(JComboBox<Categoria> cbx) {
		Categoria seleccionada = (Categoria) cbx.getSelectedItem();
		cbx.removeAllItems();

		for (Categoria categoria : listaCategorias.getAll())
			cbx.addItem(categoria);
		
		if (seleccionada != null) {
			cbx.setSelectedItem(seleccionada);
		}else{cbx.setSelectedIndex(-1);} //si no selecciono nada, se muestra en blanco
	}

	
	
	
	

	
	
	
	
	
	
	//Metodo que carga la tabla de pendientes(0) y completas(1), segun el parametro
	public void cargarTareas(ViewTareasPendientes v) {
		Categoria c = (Categoria) v.getCbxCategory().getSelectedItem();
		
		if(c!=null) {
			v.getModel().setDataVector(getTaskData(c), getTaskColums());
			v.getLblActualCategory().setText(c.getName());
			//si ya esta compledata no mostrar los botones
			if(completedTask)
				v.hidePanel_botones();
		}
	}
	

	
	
	// =========================================================
	// FORMULARIOS DE TAREAS
	// =========================================================
	public void createTask() {
		FormTasks v = new FormTasks();
		loadCbxCategory(v.getCbxCategory());

		v.getBtnGuardar().addActionListener(e -> {
			Categoria category = (Categoria) v.getCbxCategory().getSelectedItem();
			if (v.gettFName().getText().isEmpty() || v.gettADescription().getText().isEmpty() || category==null) {
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
			} else {
				listaTareas.store(new Tarea(v.gettFName().getText(), v.gettADescription().getText(), category.getId()));
				initTasks();
				cargarTareas(taskView);
			}
		});

		v.getBtnCancerlar().addActionListener(e -> {
			initTasks();
			cargarTareas(taskView);
		});

		vp.setContenido(v, "Tareas-Registrar");
	}

	
	
	public void editTask(int id) {
		FormTasks v = new FormTasks();

		// Cargamos datos
		Tarea item = listaTareas.findById(id);
		v.gettFName().setText(item.getName());
		v.gettADescription().setText(item.getDescription());
		loadCbxCategory(v.getCbxCategory());
		seleccionarCategoriaEnCombo(v.getCbxCategory(), item.getCategoryId());

		v.getBtnGuardar().addActionListener(e -> {
			if (v.gettFName().getText().isEmpty() || v.gettADescription().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
			} else {
				Categoria category = (Categoria) v.getCbxCategory().getSelectedItem();
				listaTareas.update(new Tarea(v.gettFName().getText(), v.gettADescription().getText(), category.getId()), id);
				initTasks();
	cargarTareas(taskView);
			}
		});

		v.getBtnCancerlar().addActionListener(e -> {
			initTasks();
			cargarTareas(taskView);
		});

		vp.setContenido(v, "Tareas-Registrar");
	}

	
	//carga en el cbx, la categoria con el id correspondiente
	// Busca en el combo la Categoria cuyo ID coincide con categoryId y la selecciona.
	// Hacerlo asi evita errores al borrar opciones del cbx
	private void seleccionarCategoriaEnCombo(JComboBox<Categoria> cbx, int categoryId) {
	 	for (int i = 0; i < cbx.getItemCount(); i++) {
			Categoria c = cbx.getItemAt(i);
			if (c.getId() == categoryId) {
				cbx.setSelectedItem(c);
				break;
			}
		}
	}

	
	

	// =========================================================
	//Informacion index
	// =========================================================
	
	public String[] getTaskColums() {
		return new String[] {"ID", "Nombre", "Descripcion"};
	}

	
	
	
	// completada = false -> tareas pendientes / completada = true -> tareas completadas
	// (el mismo metodo servira para el panel de completadas cuando lo armemos)
	public Object[][] getTaskData(Categoria category) {
		ArrayList<Tarea> tareas = new ArrayList<>();
		for (Tarea item : listaTareas.getAll()) {
			if (item.getCategoryId() == category.getId() && item.getCurrentState() == completedTask) {
				tareas.add(item);
			}
		}
		Object[][] data = new Object[tareas.size()][getTaskColums().length];
		int i = 0;
		for (Tarea item : tareas) {
			data[i][0] = item.getId();
			data[i][1] = item.getName();
			data[i][2] = item.getDescription();
			i++;
		}
		return data;
	}

	
	
	
}
