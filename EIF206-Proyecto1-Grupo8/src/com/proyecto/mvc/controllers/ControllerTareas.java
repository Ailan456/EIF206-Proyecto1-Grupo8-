package com.proyecto.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.proyecto.data.Data;
import com.proyecto.mvc.models.Categoria;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.models.Tarea;
import com.proyecto.mvc.views.ViewPrincipal;
import com.proyecto.mvc.views.tareas.FormTasks;
import com.proyecto.mvc.views.tareas.ViewTareasPendientes;

public class ControllerTareas extends Functions {

	// =========================================================
	// ATRIBUTOS
	// =========================================================
	private ViewPrincipal vp;
	private ViewTareasPendientes vPendientes;
	private ListaTareas listaTareas;
	private ListaCategorias listaCategorias;

	// =========================================================
	// CONSTRUCTOR
	// =========================================================
	public ControllerTareas() {
		vp = new ViewPrincipal();
		vPendientes = new ViewTareasPendientes(); // La creo aca porque solo se necesita crear 1 vez
		listaTareas = new ListaTareas();
		listaCategorias = new ListaCategorias();
	}

	
	// =========================================================
	// ARRANQUE
	// =========================================================
	public void init() {
		loadData();
		vp.init();
		
		// Funcionalidad de los botones
		initVPListeners();
		initTareasPendientes();

		// View por defecto al levantar
		indexTareasPendientes();
	}

	
	// Botones de la view principal
	public void initVPListeners() {
		vp.getBtnTareasPendientes().addActionListener(e -> {
			indexTareasPendientes();
		});

		vp.getBtnTareasCompletadas().addActionListener(e -> {
			// Llamar view de completadas
		});

		vp.getBtnCategorias().addActionListener(e -> {
			// Llamar view de categorias
		});
	}

	
	
	// =========================================================
	// DATOS DE PRUEBA
	// =========================================================
	private void loadData() {
		new Data().getInfo(listaCategorias, listaTareas);	
	}

	
	
	// =========================================================
	// COMBOBOX DE CATEGORIAS (compartido por todas las views)
	// =========================================================
	// Carga las categorias a TODOS los combobox, solo le pasan el combo de la view
	public void loadCbxCategory(JComboBox<Categoria> cbx) {
		/*
		 * Este metodo remueve todo antes de agregar para que no se agregue cada que se llama a index
		 * Tambien guarda la seleccion para que si se tenia seleccionada una categoria
		 * Esta se mantenga al regresar al index
		 */
		Categoria seleccionada = (Categoria) cbx.getSelectedItem();

		cbx.removeAllItems();

		for (Categoria categoria : listaCategorias.getAll()) {
			cbx.addItem(categoria);
		}

		if (seleccionada != null) {
			cbx.setSelectedItem(seleccionada);
		}
	}

	
	
	
	// =========================================================
	// SECCION: TAREAS PENDIENTES
	// =========================================================
	public String[] getTaskColums() {
		return new String[] {"ID", "Nombre", "Descripcion"};
	}

	
	// completada = false -> tareas pendientes / completada = true -> tareas completadas
	// (el mismo metodo servira para el panel de completadas cuando lo armemos)
	public Object[][] getTaskData(Categoria category, boolean state) {
		ArrayList<Tarea> tareas = new ArrayList<>();
		for (Tarea item : listaTareas.getAll()) {
			if (item.getCategoryId() == category.getId() && item.getCurrentState() == state) {
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

	
	
	public void indexTareasPendientes() {
		loadCbxCategory(vPendientes.getCbxCategory());
		vp.setContenido(vPendientes, "Tareas-Pendientes");
	}

	
	
	// Metodo de inicializacion de listeners aparte para evitar el error de crear multiples listeners
	public void initTareasPendientes() {

		vPendientes.getBtnCargar().addActionListener(e -> {
			cargarTareasPendientes(vPendientes);
		});

		vPendientes.getBtnNueva().addActionListener(e -> {
			createTask();
		});

		vPendientes.getBtnEditar().addActionListener(e -> {
			int id = getSelectedID(vPendientes.getTable());

			if (id > 0) {
				editTask(id);
			}
		});

		vPendientes.getBtnEliminar().addActionListener(e -> {
			int id = getSelectedID(vPendientes.getTable());

			if (id > 0) {
				int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar?");

				if (opcion == 0) {
					listaTareas.destroy(id);
					cargarTareasPendientes(vPendientes);
				}
			}
		});

		vPendientes.getBtnCompletada().addActionListener(e -> {
			int id = getSelectedID(vPendientes.getTable());

			if (id > 0) {
				int opcion = JOptionPane.showConfirmDialog(null, "Desea marcar como completada la tarea?");

				if (opcion == 0) {
					listaTareas.completedTask(id);
					cargarTareasPendientes(vPendientes);
				}
			}
		});
	}

	
	
	
	//Metodo que carga la tabla de pendientes
	public void cargarTareasPendientes(ViewTareasPendientes v) {
		Categoria c = (Categoria) v.getCbxCategory().getSelectedItem();
		v.getModel().setDataVector(getTaskData(c, false), getTaskColums());
		v.getLblActualCategory().setText(c.getName());
	}

	
	
	// =========================================================
	// SECCION: TAREAS COMPLETADAS
	// =========================================================
	// (pendiente: aca va indexTareasCompletadas / initTareasCompletadas / cargarTareasCompletadas,
	//  reutilizando getTaskColums() y getTaskData(categoria, true))

	// =========================================================
	// FORMULARIOS DE TAREAS
	// =========================================================
	public void createTask() {
		FormTasks v = new FormTasks();
		loadCbxCategory(v.getCbxCategory());

		v.getBtnGuardar().addActionListener(e -> {
			if (v.gettFName().getText().isEmpty() || v.gettADescription().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
			} else {
				Categoria category = (Categoria) v.getCbxCategory().getSelectedItem();
				listaTareas.store(new Tarea(v.gettFName().getText(), v.gettADescription().getText(), category.getId()));
				indexTareasPendientes();
				cargarTareasPendientes(vPendientes);
			}
		});

		v.getBtnCancerlar().addActionListener(e -> {
			indexTareasPendientes();
			cargarTareasPendientes(vPendientes);
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
				indexTareasPendientes();
				cargarTareasPendientes(vPendientes);
			}
		});

		v.getBtnCancerlar().addActionListener(e -> {
			indexTareasPendientes();
			cargarTareasPendientes(vPendientes);
		});

		vp.setContenido(v, "Tareas-Registrar");
	}

	
	
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

}
