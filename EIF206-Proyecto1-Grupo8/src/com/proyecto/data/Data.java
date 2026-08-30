package com.proyecto.data;

import java.util.ArrayList;

import com.proyecto.mvc.models.Categoria;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.models.ListaTareas;
import com.proyecto.mvc.models.Tarea;

public class Data {

	
	//recive las listas y  les carga los ejemplos
	public void getInfo(ListaCategorias listaCategorias ,ListaTareas listaTareas){
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
		
	
						
			listaTareas.store(new Tarea("Estudiar Java","Repasar clases, objetos y métodos.",1,true));
			listaTareas.store(new Tarea("Hacer proyecto","Avanzar en el proyecto del gestor de tareas.",1,true));
			listaTareas.store(new Tarea("Leer capítulo 3","Leer y tomar apuntes del capítulo 3 del libro.",1,true));
			listaTareas.store(new Tarea("Entregar tarea","Completar y entregar la tarea de programación.",1,true));
			listaTareas.store(new Tarea("Estudiar para examen","Repasar los temas incluidos en el próximo examen.",1,true));
			
			
			listaTareas.store(new Tarea("Revisar correos","Revisar y responder los correos pendientes.",2,true));
			listaTareas.store(new Tarea("Reunión de equipo","Participar en la reunión semanal del equipo.",2,true));
			listaTareas.store(new Tarea("Actualizar informe","Actualizar el informe con los datos más recientes.",2,true));
			listaTareas.store(new Tarea("Preparar presentación","Preparar la presentación para la reunión.",2,true));
			listaTareas.store(new Tarea("Completar reporte","Finalizar el reporte de actividades de la semana.",2,true));
			
			
			listaTareas.store(new Tarea("Ir al supermercado","Comprar alimentos y productos necesarios para la semana.",3,true));
			listaTareas.store(new Tarea("Hacer ejercicio","Realizar una rutina de ejercicio durante 30 minutos.",3,true));
			listaTareas.store(new Tarea("Limpiar habitación","Ordenar y limpiar la habitación.",3,true));
			listaTareas.store(new Tarea("Lavar ropa","Lavar, secar y guardar la ropa.",3,true));
			listaTareas.store(new Tarea("Pagar recibos","Pagar los recibos pendientes del mes.",3,true));

	
	
	}
	
	
	

	
}
