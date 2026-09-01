package com.proyecto.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import com.proyecto.mvc.models.Categoria;
import com.proyecto.mvc.models.ListaCategorias;
import com.proyecto.mvc.views.ViewPrincipal;
import com.proyecto.mvc.views.tareas.Form;
import com.proyecto.mvc.views.tareas.ViewTable;

public class ControllerCategoria extends Functions {

	ViewPrincipal vp;
	private ListaCategorias listaCategorias;
	private ViewTable tableView;
	
	
	public ControllerCategoria(ViewPrincipal vp, ListaCategorias listaCategorias) {
		this.vp = vp;
		this.listaCategorias=listaCategorias;
		this.tableView = new ViewTable();
		setBtnsCat();
	}
	
	
	
	public void init() {index();}
	
	
	

	public void index() { //Pone el panel index
		tableView.getModel().setDataVector(getData(), getColums());
		tableView.showForTheCategory(false);
		vp.setContenido(tableView, "Categorias");
		
	}

	
	
	
	
	
	
	
	public void setBtnsCat() {

		
		tableView.getBtnNueva().addActionListener(e->{
			create();
		});

		tableView.getBtnEditar().addActionListener(e->{
			int id = getSelectedID(tableView.getTable());// Usamos al metodo de functions que heredamos
			if(id>0) {
				edit(id);
			}
		});

		tableView.getBtnEliminar().addActionListener(e->{
			int id = getSelectedID(tableView.getTable());
			if(id>0) {

				int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?");
				if(opcion == 0) {
					listaCategorias.destroy(id);
					index();
				}
			}
		});

	}
	
	
	
	
	
	
	
	
	public void create() { // Panel de registrar pipol
		Form v = new Form();
		v.showPanel_categoriaForTheCategoryForm(false);//escondemos la opcion que no se usa
		
		vp.setContenido(v, "Registrar Categoria");

		v.getBtnGuardar().addActionListener(e->{

			String name =v.gettFName().getText();//Obtengo datos de la vista
			Categoria categoria = new Categoria(name);//Creo el objeto
			listaCategorias.store(categoria);//Guardo en la lista
			index();//Regresar al index
		});
	
		v.getBtnCancerlar().addActionListener(e->{index();});
	}

	
	
	
	
	
	
	public void edit(int id) {//Lo mismo que form pero en vez de create llamo a update
		Form v = new Form();
		v.showPanel_categoriaForTheCategoryForm(false);//escondemos la opcion que no se usa
		
		//busco la categoria y muestro sus datos
		Categoria categoria = listaCategorias.findById(id);
		v.settFName(categoria.getName());
		
		vp.setContenido(v, "Editar Categoria"); 

		v.getBtnGuardar().addActionListener(e->{
			//Obtengo datos de la vista
			String nombre = v.gettFName().getText();
			//Creo el objeto
			Categoria item = new Categoria(nombre);
			//Guardo en la lista
			listaCategorias.update(item, id);
			//Regresar al index
			index();
		});
		
		v.getBtnCancerlar().addActionListener(e->{index();});
	}

	
	
	
	
	
	
	
	
	
	
	
	//table
	
		public String[] getColums() {
			return new String[] {"ID","Nombre"};
		}

		public Object [][] getData(){
			ArrayList<Categoria> Categorias = listaCategorias.getAll();
			Object[][] data = new Object[Categorias.size()][getColums().length];
			for (int i = 0; i < data.length; i++){
				data[i][0] = Categorias.get(i).getId();
				data[i][1] = Categorias.get(i).getName();
			}
			
			return data;
		}

	
	
	
}
