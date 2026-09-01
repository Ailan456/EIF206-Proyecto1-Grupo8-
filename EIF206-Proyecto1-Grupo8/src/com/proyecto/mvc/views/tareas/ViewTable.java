package com.proyecto.mvc.views.tareas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewTable extends JPanel {
	private JComboBox cbxCategory;
	private JButton btnCargar;
	private JTable table;
	private JButton btnNueva;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnCompletada;
	private DefaultTableModel model;
	private JLabel lblActualCategory;
	private JPanel panel_botones;
	private JPanel pSuperior;
	private JPanel pCentralSuperior;

	
	public ViewTable() {
		setLayout(new BorderLayout(0, 0));
		
		pSuperior = new JPanel();
		pSuperior.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSuperior.setBackground(Color.LIGHT_GRAY);
		FlowLayout fl_pSuperior = (FlowLayout) pSuperior.getLayout();
		fl_pSuperior.setAlignment(FlowLayout.LEFT);
		add(pSuperior, BorderLayout.NORTH);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pSuperior.add(lblCategoria);
		
		cbxCategory = new JComboBox();
		pSuperior.add(cbxCategory);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pSuperior.add(btnCargar);
		
		JPanel pCentral = new JPanel();
		add(pCentral, BorderLayout.CENTER);
		pCentral.setLayout(new BorderLayout(0, 0));
		
		pCentralSuperior = new JPanel();
		pCentralSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		FlowLayout fl_pCentralSuperior = (FlowLayout) pCentralSuperior.getLayout();
		fl_pCentralSuperior.setAlignment(FlowLayout.LEFT);
		pCentral.add(pCentralSuperior, BorderLayout.NORTH);
		
		JLabel lblSelectedCategory = new JLabel("Categoria:");
		lblSelectedCategory.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pCentralSuperior.add(lblSelectedCategory);
		
		lblActualCategory = new JLabel("No seleccionada");
		lblActualCategory.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pCentralSuperior.add(lblActualCategory);
		
		panel_botones = new JPanel();
		panel_botones.setBorder(new EmptyBorder(5, 5, 5, 5));
		FlowLayout fl_panel_botones = (FlowLayout) panel_botones.getLayout();
		fl_panel_botones.setAlignment(FlowLayout.RIGHT);
		pCentral.add(panel_botones, BorderLayout.SOUTH);
		
		btnNueva = new JButton("Nueva");
		btnNueva.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_botones.add(btnNueva);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_botones.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_botones.add(btnEliminar);
		
		btnCompletada = new JButton("Completada");
		btnCompletada.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_botones.add(btnCompletada);
		
		JScrollPane scrollPane = new JScrollPane();
		pCentral.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		
		table = new JTable(model);
		scrollPane.setViewportView(table);

	}


	public JComboBox getCbxCategory() {
		return cbxCategory;
	}


	public void setCbxCategory(JComboBox cbxCategory) {
		this.cbxCategory = cbxCategory;
	}


	public JButton getBtnCargar() {
		return btnCargar;
	}


	public void setBtnCargar(JButton btnCargar) {
		this.btnCargar = btnCargar;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JButton getBtnNueva() {
		return btnNueva;
	}


	public void setBtnNueva(JButton btnNueva) {
		this.btnNueva = btnNueva;
	}


	public JButton getBtnEditar() {
		return btnEditar;
	}


	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public JButton getBtnCompletada() {
		return btnCompletada;
	}


	public void setBtnCompletada(JButton btnCompletada) {
		this.btnCompletada = btnCompletada;
	}


	public DefaultTableModel getModel() {
		return model;
	}


	public void setModel(DefaultTableModel model) {
		this.model = model;
	}


	public JLabel getLblActualCategory() {
		return lblActualCategory;
	}


	public void setLblActualCategory(JLabel lblActualCategory) {
		this.lblActualCategory = lblActualCategory;
	}
	
	
	public void hidePanel_botonesForCompletedList() {
		panel_botones.setVisible(false);
	}
	
	public void hideForTheCategory() {
		btnCompletada.setVisible(false);
		pSuperior.setVisible(false);
		pCentralSuperior.setVisible(false);
		
	}

}
