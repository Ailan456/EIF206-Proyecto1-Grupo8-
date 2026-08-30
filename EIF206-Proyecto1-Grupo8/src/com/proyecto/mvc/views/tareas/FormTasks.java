package com.proyecto.mvc.views.tareas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabExpander;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FormTasks extends JPanel {
	private JTextArea tADescription;
	private JTextField tFName;
	private JButton btnGuardar;
	private JButton btnCancerlar;
	private JComboBox cbxCategory;
	private JPanel panel_categoria;
	private JPanel panel_botones;
	private JLabel label_5;
	private JLabel label;

	public FormTasks() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{330, 0};
		gridBagLayout.rowHeights = new int[]{28, 28, 28, 28, 28, 0, 0, 0, 0, 28, 28, 28, 28, 28, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		tFName = new JTextField();
		GridBagConstraints gbc_tFName = new GridBagConstraints();
		gbc_tFName.fill = GridBagConstraints.BOTH;
		gbc_tFName.insets = new Insets(0, 0, 5, 0);
		gbc_tFName.gridx = 0;
		gbc_tFName.gridy = 1;
		add(tFName, gbc_tFName);
		tFName.setColumns(10);
		
		panel_categoria = new JPanel();
		GridBagConstraints gbc_panel_categoria = new GridBagConstraints();
		gbc_panel_categoria.fill = GridBagConstraints.BOTH;
		gbc_panel_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_panel_categoria.gridx = 0;
		gbc_panel_categoria.gridy = 3;
		add(panel_categoria, gbc_panel_categoria);
		panel_categoria.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		panel_categoria.add(lblDescripcion);
		
		tADescription = new JTextArea();
		panel_categoria.add(tADescription);
		
		label = new JLabel("");
		panel_categoria.add(label);
		
		JLabel lblCategoria = new JLabel("Categoria");
		panel_categoria.add(lblCategoria);
		
		cbxCategory = new JComboBox();
		panel_categoria.add(cbxCategory);
		
		panel_botones = new JPanel();
		GridBagConstraints gbc_panel_botones = new GridBagConstraints();
		gbc_panel_botones.insets = new Insets(0, 0, 5, 0);
		gbc_panel_botones.fill = GridBagConstraints.BOTH;
		gbc_panel_botones.gridx = 0;
		gbc_panel_botones.gridy = 5;
		add(panel_botones, gbc_panel_botones);
		
		btnCancerlar = new JButton("Cancerlar");
		panel_botones.add(btnCancerlar);
		
		btnGuardar = new JButton("Guardar");
		panel_botones.add(btnGuardar);
		
		label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 13;
		add(label_5, gbc_label_5);

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
	
	public void hidePanel_categoria() {
		panel_categoria.setVisible(false);
	}
}
