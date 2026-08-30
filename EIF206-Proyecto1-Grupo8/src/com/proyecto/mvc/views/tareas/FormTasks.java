package com.proyecto.mvc.views.tareas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
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
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JPanel panel_botones;
	private JLabel label_4;
	private JLabel label_5;

	public FormTasks() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{330, 0};
		gridBagLayout.rowHeights = new int[]{28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		tFName = new JTextField();
		GridBagConstraints gbc_tFName = new GridBagConstraints();
		gbc_tFName.fill = GridBagConstraints.BOTH;
		gbc_tFName.insets = new Insets(0, 0, 5, 0);
		gbc_tFName.gridx = 0;
		gbc_tFName.gridy = 2;
		add(tFName, gbc_tFName);
		tFName.setColumns(10);
		
		label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.fill = GridBagConstraints.BOTH;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 4;
		add(lblDescripcion, gbc_lblDescripcion);
		
		label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 5;
		add(label_2, gbc_label_2);
		
		tADescription = new JTextArea();
		GridBagConstraints gbc_tADescription = new GridBagConstraints();
		gbc_tADescription.fill = GridBagConstraints.BOTH;
		gbc_tADescription.insets = new Insets(0, 0, 5, 0);
		gbc_tADescription.gridx = 0;
		gbc_tADescription.gridy = 6;
		add(tADescription, gbc_tADescription);
		
		label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 7;
		add(label_3, gbc_label_3);
		
		panel_categoria = new JPanel();
		GridBagConstraints gbc_panel_categoria = new GridBagConstraints();
		gbc_panel_categoria.fill = GridBagConstraints.BOTH;
		gbc_panel_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_panel_categoria.gridx = 0;
		gbc_panel_categoria.gridy = 8;
		add(panel_categoria, gbc_panel_categoria);
		panel_categoria.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCategoria = new JLabel("Categoria");
		panel_categoria.add(lblCategoria);
		
		label_4 = new JLabel("");
		panel_categoria.add(label_4);
		
		cbxCategory = new JComboBox();
		panel_categoria.add(cbxCategory);
		
		label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 9;
		add(label_5, gbc_label_5);
		
		panel_botones = new JPanel();
		GridBagConstraints gbc_panel_botones = new GridBagConstraints();
		gbc_panel_botones.fill = GridBagConstraints.BOTH;
		gbc_panel_botones.gridx = 0;
		gbc_panel_botones.gridy = 10;
		add(panel_botones, gbc_panel_botones);
		
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
