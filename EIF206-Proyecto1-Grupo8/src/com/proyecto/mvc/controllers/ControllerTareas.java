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

		initVPListeners();
		initTareasPendientes();

		// View por defecto al levantar
		indexTareasPendientes();
	}

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
		// Categorías
		listaCategorias.store(new Categoria("Universidad")); // ID 1
		listaCategorias.store(new Categoria("Trabajo"));     // ID 2
		listaCategorias.store(new Categoria("Personales"));  // ID 3

		// Universidad
		listaTareas.store(new Tarea("Estudiar Java", "Repasar clases, objetos y métodos.", 1));
		listaTareas.store(new Tarea("Hacer proyecto", "Avanzar en el proyecto del gestor de tareas.", 1));
		listaTareas.store(new Tarea("Leer capítulo 3", "Leer y tomar apuntes del capítulo 3 del libro.", 1));
		listaTareas.store(new Tarea("Entregar tarea", "Completar y entregar la tarea de programación.", 1));
		listaTareas.store(new Tarea("Estudiar para examen", "Repasar los temas incluidos en el próximo examen.", 1));
		listaTareas.store(new Tarea("Hacer presentación", "Preparar las diapositivas para la exposición.", 1));
		listaTareas.store(new Tarea("Investigar tema", "Buscar información para el trabajo de investigación.", 1));
		listaTareas.store(new Tarea("Resolver ejercicios", "Completar los ejercicios asignados por el profesor.", 1));
		listaTareas.store(new Tarea("Revisar apuntes", "Organizar y repasar los apuntes de clase.", 1));
		listaTareas.store(new Tarea("Preparar examen", "Realizar un repaso general antes del examen.", 1));

		// Trabajo
		listaTareas.store(new Tarea("Revisar correos", "Revisar y responder los correos pendientes.", 2));
		listaTareas.store(new Tarea("Reunión de equipo", "Participar en la reunión semanal del equipo.", 2));
		listaTareas.store(new Tarea("Actualizar informe", "Actualizar el informe con los datos más recientes.", 2));
		listaTareas.store(new Tarea("Preparar presentación", "Preparar la presentación para la reunión.", 2));
		listaTareas.store(new Tarea("Completar reporte", "Finalizar el reporte de actividades de la semana.", 2));
		listaTareas.store(new Tarea("Llamar al cliente", "Contactar al cliente para revisar los avances.", 2));
		listaTareas.store(new Tarea("Organizar documentos", "Ordenar los documentos importantes del proyecto.", 2));
		listaTareas.store(new Tarea("Revisar proyecto", "Comprobar el progreso y pendientes del proyecto.", 2));
		listaTareas.store(new Tarea("Enviar propuesta", "Enviar la propuesta final al equipo encargado.", 2));
		listaTareas.store(new Tarea("Planificar semana", "Organizar las actividades y prioridades de la próxima semana.", 2));

		// Personales
		listaTareas.store(new Tarea("Ir al supermercado", "Comprar alimentos y productos necesarios para la semana.", 3));
		listaTareas.store(new Tarea("Hacer ejercicio", "Realizar una rutina de ejercicio durante 30 minutos.", 3));
		listaTareas.store(new Tarea("Limpiar habitación", "Ordenar y limpiar la habitación.", 3));
		listaTareas.store(new Tarea("Lavar ropa", "Lavar, secar y guardar la ropa.", 3));
		listaTareas.store(new Tarea("Pagar recibos", "Pagar los recibos pendientes del mes.", 3));
		listaTareas.store(new Tarea("Cocinar comida", "Preparar la comida para los próximos días.", 3));
		listaTareas.store(new Tarea("Leer un libro", "Leer al menos un capítulo del libro actual.", 3));
		listaTareas.store(new Tarea("Llamar a familia", "Llamar a un familiar para conversar.", 3));
		listaTareas.store(new Tarea("Ordenar escritorio", "Organizar y limpiar el escritorio de trabajo.", 3));
		listaTareas.store(new Tarea("Planificar la semana", "Organizar las actividades personales de la semana.", 3));
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
