package com.proyecto.mvc.views.tareas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;

public class Form extends JPanel {
	
	private JTextArea tADescription;
	private JTextField tFName;
	private JButton btnGuardar;
	private JButton btnCancerlar;
	private JComboBox cbxCategory;
	private JPanel panel_botones;
	private JLabel label;
	private JPanel panel;
	private JLabel lblDescripcion;
	private JLabel lblCategoria;
	private JLabel label_1;
	private JLabel label_2;

	public Form() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(370, 270));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		tFName = new JTextField();
		panel.add(tFName);
		tFName.setColumns(10);
		
		label_2 = new JLabel("");
		panel.add(label_2);
		
		lblDescripcion = new JLabel("Descripcion");
		panel.add(lblDescripcion);
		
		tADescription = new JTextArea();
		panel.add(tADescription);
		
		label = new JLabel("");
		panel.add(label);
		
		lblCategoria = new JLabel("Categoria");
		panel.add(lblCategoria);
		
		cbxCategory = new JComboBox();
		panel.add(cbxCategory);
		
		label_1 = new JLabel("");
		panel.add(label_1);
		
		panel_botones = new JPanel();
		panel.add(panel_botones);
		
		btnCancerlar = new JButton("Cancerlar");
		panel_botones.add(btnCancerlar);
		
		btnGuardar = new JButton("Guardar");
		panel_botones.add(btnGuardar);

	}

	public JComboBox getCbxCategory() {
		return cbxCategory;
	}

	public void setCbxCategory(JComboBox cbxCategory) {
		this.cbxCategory = cbxCategory;
	}

	public JTextArea gettADescription() {
		return tADescription;
	}

	public void settADescription(JTextArea tADescription) {
		this.tADescription = tADescription;
	}

	

	public JTextField gettFName() {
		return tFName;
	}

	public void settFName(String name) {
		this.tFName.setText(name);
	}

	public void settFName(JTextField tFName) {
		this.tFName = tFName;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancerlar() {
		return btnCancerlar;
	}

	public void setBtnCancerlar(JButton btnCancerlar) {
		this.btnCancerlar = btnCancerlar;
	}
	
	public void showPanel_categoriaForTheCategoryForm(boolean show) {
		lblDescripcion.setVisible(show);
		tADescription.setVisible(show);
		label.setVisible(show);
		label_1.setVisible(show);
		lblCategoria.setVisible(show);
		cbxCategory.setVisible(show);
		
	}
}
