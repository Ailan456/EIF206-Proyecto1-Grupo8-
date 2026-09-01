
package com.proyecto.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.proyecto.mvc.models.Categoria;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.models.Tarea;
import com.proyecto.mvc.views.ViewPrincipal;
import com.proyecto.mvc.views.tareas.Form;
import com.proyecto.mvc.views.tareas.ViewTable;

public class ControllerTareas extends Functions {

	private ViewPrincipal vp;
	private ListaTareas listaTareas;
	private ListaCategorias listaCategorias;
	private ViewTable tableView;
	private boolean completedTask;
	

	//nota, hay que revisar los llamados en controller tarea a initTasks();
	public ControllerTareas(ViewPrincipal vp, ListaTareas listaTareas,
			ListaCategorias listaCategorias) {
		this.vp= vp;
		this.listaTareas= listaTareas;
		this.listaCategorias=listaCategorias;		
		this.tableView = new ViewTable();
		setBtnsFunctions();//ahora se setea en el constructor, porque se hace una sola vez
		
	}

	
	
	
	// =========================================================
		// SECCION: TAREAS 
		// =========================================================


	public void initTasks(boolean completedTask) {
		loadCbxCategory(tableView.getCbxCategory()); //carga todos las opciones, y selecciona el que ya estaba 
		vp.setContenido(tableView, completedTask? "Tareas-Completadas":"Tareas-Pendientes"); // lo mostramos
		tableView.showPanel_botonesForCompletedList(!completedTask); //muestra los botones si es falso que completedTask
		this.completedTask=completedTask;
		cargarTabla(tableView);
	}

	

	// Metodo de inicializacion de listeners aparte para evitar el error de crear multiples listeners
	public void setBtnsFunctions() {
		
		tableView.getBtnCargar().addActionListener(e -> {
			cargarTabla(tableView);
		});
		
		if(!completedTask) { //dentro de este if, se setean los botones, solo si se van a usar
			tableView.getBtnNueva().addActionListener(e -> {
				createTask();
			});
	
			tableView.getBtnEditar().addActionListener(e -> {
				int id = getSelectedID(tableView.getTable());
				
				if (id > 0)
					editTask(id);
			});
	
			tableView.getBtnEliminar().addActionListener(e -> {
				int id = getSelectedID(tableView.getTable());
	
				if (id > 0) {
					int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar?");
	
					if (opcion == 0) {
						listaTareas.destroy(id);
						cargarTabla(tableView);
					}
				}
			});
	
			tableView.getBtnCompletada().addActionListener(e -> {
				int id = getSelectedID(tableView.getTable());
	
				if (id > 0) {
					int opcion = JOptionPane.showConfirmDialog(null, "Desea marcar como completada la tarea?");
	
					if (opcion == 0) {
						listaTareas.completedTask(id);
						cargarTabla(tableView);
					}
				}
			});
		}//if
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
	public void cargarTabla(ViewTable v) {
		Categoria c = (Categoria) v.getCbxCategory().getSelectedItem();
		
		if(c!=null) {
			v.getModel().setDataVector(getTaskData(c), getTaskColums());
			v.getLblActualCategory().setText(c.getName());
		}
	}
	

	
	
	// =========================================================
	// FORMULARIOS DE TAREAS
	// =========================================================
	public void createTask() {
		Form v = new Form();
		loadCbxCategory(v.getCbxCategory());

		v.getBtnGuardar().addActionListener(e -> {
			Categoria category = (Categoria) v.getCbxCategory().getSelectedItem();
			if (v.gettFName().getText().isEmpty() || v.gettADescription().getText().isEmpty() || category==null) {
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
			} else {
				listaTareas.store(new Tarea(v.gettFName().getText(), v.gettADescription().getText(), category.getId()));
				initTasks(completedTask);
			}
		});

		v.getBtnCancerlar().addActionListener(e -> {
			initTasks(completedTask);
		});

		vp.setContenido(v, "Tareas-Registrar");
	}

	
	
	public void editTask(int id) {
		Form v = new Form();

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
				initTasks(completedTask);
			}
		});

		v.getBtnCancerlar().addActionListener(e -> {
			initTasks(completedTask);
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
	// Creamos las columnas y la informacion de la tabla
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
