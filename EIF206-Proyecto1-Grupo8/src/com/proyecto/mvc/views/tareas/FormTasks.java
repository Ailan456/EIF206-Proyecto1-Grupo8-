package com.proyecto.mvc.views.tareas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class FormTasks extends JPanel {
	private JTextArea tADescription;
	private JTextField tFName;
	private JButton btnGuardar;
	private JButton btnCancerlar;
	private JComboBox cbxCategory;

	public FormTasks() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(44, 26, 46, 14);
		add(lblNombre);
		
		tFName = new JTextField();
		tFName.setBounds(44, 48, 225, 20);
		add(tFName);
		tFName.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(44, 79, 76, 14);
		add(lblDescripcion);
		
		tADescription = new JTextArea();
		tADescription.setBounds(44, 96, 225, 64);
		add(tADescription);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(44, 171, 62, 14);
		add(lblCategoria);
		
		cbxCategory = new JComboBox();
		cbxCategory.setBounds(44, 196, 225, 20);
		add(cbxCategory);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(44, 227, 89, 23);
		add(btnGuardar);
		
		btnCancerlar = new JButton("Cancerlar");
		btnCancerlar.setBounds(147, 227, 96, 23);
		add(btnCancerlar);

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

	
}
